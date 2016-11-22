/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.journal.JournalWriter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SearchSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 国保連情報取込処理共通のビジネスです。<br>
 * 国保連情報取込共通処理（ファイル取得）
 *
 * @reamsid_L DBC-0980-525 zhangrui
 */
public class KokuhorenKyoutsuuFileGetManager {

    private static final RString MSG_交換情報識別番号 = new RString("交換情報識別番号");
    private static final RString MSG_ファイル格納フォルダ名 = new RString("ファイル格納フォルダ名");
    private static final RString PREFIX = new RString("1\\_");
    private static final RString パーセント = new RString("%");
    private static final RString FILTER = new RString("1_*.csv");

    /**
     * 国保連情報取込共通処理（ファイル取得）のコンストラクタ。
     *
     */
    public KokuhorenKyoutsuuFileGetManager() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenKyoutsuuFileGetManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KokuhorenKyoutsuuFileGetManager}のインスタンス
     */
    public static KokuhorenKyoutsuuFileGetManager createInstance() {
        return InstanceProvider.create(KokuhorenKyoutsuuFileGetManager.class);
    }

    /**
     * 国保連情報取込共通処理（ファイル取得）
     *
     * @param 交換情報識別番号 RString
     * @param ファイル格納フォルダ名 RString
     * @param currentLoginId currentLoginId
     * @return KokuhorenKyoutsuuFileGetReturnEntity
     */
    public KokuhorenKyoutsuuFileGetReturnEntity getFile(RString 交換情報識別番号, RString ファイル格納フォルダ名, RString currentLoginId) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_交換情報識別番号.toString()));
        requireNonNull(ファイル格納フォルダ名, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_ファイル格納フォルダ名.toString()));
        KokuhorenKyoutsuuFileGetReturnEntity result
                = new KokuhorenKyoutsuuFileGetReturnEntity();
        List<UzT0885SharedFileEntryEntity> entityList;
        JournalWriter writer = new JournalWriter();
        RString sharedFileNamePattern = PREFIX.concat(交換情報識別番号).concat(パーセント);
        SearchSharedFileOpts opts = new SearchSharedFileOpts().
                loginId(currentLoginId).
                sharedFilePat(sharedFileNamePattern);
        try {
            entityList = SharedFile.searchSharedFile(opts, GyomuCode.DB介護保険);
        } catch (Exception ex) {
            writer.writeErrorJournal(RDateTime.now(), new RString(ex.getMessage()));
            throw new BatchInterruptedException(ex.getMessage());
        }
        if (null == entityList || entityList.isEmpty()) {
            writer.writeErrorJournal(RDateTime.now(), new RString(DbcErrorMessages.取込対象ファイルが存在しない.getMessage()
                    .replace(PREFIX.concat(交換情報識別番号).toString()).toString()));
            throw new BatchInterruptedException(DbcErrorMessages.取込対象ファイルが存在しない.getMessage()
                    .replace(PREFIX.concat(交換情報識別番号).concat(パーセント).toString()).toString());
        }
        List<SharedFileEntryDescriptor> fileEntryList = new ArrayList<>();
        Set<RString> fileNameSet = new HashSet<>();
        for (UzT0885SharedFileEntryEntity entity : entityList) {
            FilesystemPath localFilePath = FilesystemPath.fromString(ファイル格納フォルダ名);
            ReadOnlySharedFileEntryDescriptor ro_sfed
                    = ReadOnlySharedFileEntryDescriptor.fromEntity(entity);
            SharedFileEntryDescriptor sfed = SharedFileEntryDescriptor.fromEntity(entity);
            fileEntryList.add(sfed);
            try {
                FilesystemPath 保存先フォルダのパス = SharedFile.copyToLocal(ro_sfed, localFilePath);
                result.set保存先フォルダのパス(保存先フォルダのパス);
                fileNameSet.add(entity.getLocalFileName());
            } catch (Exception ex) {
                Logger.getLogger(KokuhorenKyoutsuuFileGetManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new BatchInterruptedException(ex.getMessage());
            }
        }
        if (null == fileNameSet || fileNameSet.isEmpty()) {
            writer.writeErrorJournal(RDateTime.now(), new RString(DbcErrorMessages.取込対象ファイルが存在しない.getMessage()
                    .replace(PREFIX.concat(交換情報識別番号).toString()).toString()));
            throw new BatchInterruptedException(DbcErrorMessages.取込対象ファイルが存在しない.getMessage()
                    .replace(PREFIX.concat(交換情報識別番号).toString()).toString());
        }
        List<RString> fileNameList = new ArrayList<>();
        fileNameList.addAll(fileNameSet);
        result.setEntityList(fileEntryList);
        result.setFileNameList(fileNameList);

        return result;
    }

}
