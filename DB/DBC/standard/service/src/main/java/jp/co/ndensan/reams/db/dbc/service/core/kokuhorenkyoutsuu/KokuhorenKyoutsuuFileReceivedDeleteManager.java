package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連情報取込処理共通のビジネスです。<br>
 * 国保連情報取込共通処理（取込済ファイル削除）
 *
 * @reamsid_L DBC-0980-540 zhangrui
 */
public class KokuhorenKyoutsuuFileReceivedDeleteManager {

    private static final int 定数_3 = 3;
    private static final RString アンダーライン = new RString("_");
    private static final RString ドット = new RString(".");

    private static final RString MESSAGE_処理年月 = new RString("処理年月");
    private static final RString MESSAGE_保存先フォルダ = new RString("保存先フォルダ");
    private static final RString MESSAGE_エントリ情報LIST = new RString("エントリ情報List");

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenKyoutsuuFileReceivedDeleteManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KokuhorenKyoutsuuFileReceivedDeleteManager}のインスタンス
     */
    public static KokuhorenKyoutsuuFileReceivedDeleteManager createInstance() {
        return InstanceProvider.create(KokuhorenKyoutsuuFileReceivedDeleteManager.class);
    }

    /**
     * 国保連情報取込共通処理（取込済ファイル削除）
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<SharedFileEntryDescriptor>
     * @return 削除成功TRUE 失敗FALSE
     */
    @Transaction
    public boolean deleteReceivedFile(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<SharedFileEntryDescriptor> エントリ情報List) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_処理年月.toString()));
        requireNonNull(保存先フォルダ, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_保存先フォルダ.toString()));
        requireNonNull(エントリ情報List, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_エントリ情報LIST.toString()));
        List<RString> fileNameList = new ArrayList<>();
        Collections.addAll(fileNameList, Directory.getFiles(保存先フォルダ));
        List<File> toList = new ArrayList<>();
        for (RString fileName : fileNameList) {
            RString ファイル名_拡張子あり = fileName;
            RString 拡張子 = ファイル名_拡張子あり.substring(ファイル名_拡張子あり.lastIndexOf(ドット));
            RString ファイル名 = ファイル名_拡張子あり.substring(0, ファイル名_拡張子あり.lastIndexOf(ドット));
            RString 主要部分 = ファイル名.substring(ファイル名.indexOf(アンダーライン));
            StringBuilder 新ファイル名 = new StringBuilder(String.valueOf(定数_3));
            新ファイル名.append(主要部分);
            新ファイル名.append(処理年月.toString());
            新ファイル名.append(拡張子);
            File from = new File(保存先フォルダ + File.separator + fileName);
            File to = new File(保存先フォルダ + File.separator + 新ファイル名.toString());
            if (!from.renameTo(to)) {
                throw new BatchInterruptedException(UrErrorMessages.ファイルWRITEエラー.getMessage().
                        replace(新ファイル名.toString()).toString());
            }
            toList.add(to);
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険,
                FilesystemName.fromString(アンダーライン.concat(new File(保存先フォルダ.toString()).getName())));
        sfd = SharedFile.defineSharedFile(sfd);
        RString 保管日数 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_取込ファイル_保管日数,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RDate 自動削除日 = RDate.getNowDate().plusDay(Integer.valueOf(保管日数.toString()));
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(true).dateToDelete(自動削除日);
        SharedFile.copyToSharedFile(sfd, new FilesystemPath(保存先フォルダ), opts);
        for (SharedFileEntryDescriptor エントリ情報 : エントリ情報List) {
            try {
                SharedFile.deleteEntry(エントリ情報);
            } catch (SystemException ex) {
                Logger.getLogger(KokuhorenKyoutsuuInterfaceKanriKousinManager.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        for (File to : toList) {
            if (!to.delete()) {
                to.deleteOnExit();
            }
        }
        return true;
    }
}
