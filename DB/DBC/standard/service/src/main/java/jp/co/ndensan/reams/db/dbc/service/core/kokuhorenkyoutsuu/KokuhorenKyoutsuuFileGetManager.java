/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込処理共通のビジネスです。<br>
 * 国保連情報取込共通処理（ファイル取得）
 *
 * @reamsid_L DBC-0980-525 zhangrui
 */
public final class KokuhorenKyoutsuuFileGetManager {

    private static final RString MSG_交換情報識別番号 = new RString("交換情報識別番号");
    private static final RString MSG_ファイル格納フォルダ名 = new RString("ファイル格納フォルダ名");
    private static final RString PREFIX = new RString("1_");

    private KokuhorenKyoutsuuFileGetManager() {
    }

    /**
     * 国保連情報取込共通処理（ファイル取得）
     *
     * @param 交換情報識別番号 RString
     * @param ファイル格納フォルダ名 RString
     * @return KokuhorenKyoutsuuFileGetReturnEntity
     */
    public static KokuhorenKyoutsuuFileGetReturnEntity getFile(RString 交換情報識別番号, RString ファイル格納フォルダ名) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_交換情報識別番号.toString()));
        requireNonNull(ファイル格納フォルダ名, UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_ファイル格納フォルダ名.toString()));
        KokuhorenKyoutsuuFileGetReturnEntity result
                = new KokuhorenKyoutsuuFileGetReturnEntity(null, new ArrayList<UzT0885SharedFileEntryEntity>());
        List<UzT0885SharedFileEntryEntity> entityList;
        try {
            entityList = SharedFile.searchSharedFile(PREFIX.concat(交換情報識別番号));
        } catch (Exception ex) {
            Logger.getLogger(KokuhorenKyoutsuuFileGetManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new BatchInterruptedException(ex.getMessage());
        }
        if (null == entityList || entityList.isEmpty()) {
            throw new BatchInterruptedException(DbcErrorMessages.取込対象ファイルが存在しない.getMessage()
                    .replace(PREFIX.concat(交換情報識別番号).toString()).toString());
        }

        for (UzT0885SharedFileEntryEntity entity : entityList) {
            FilesystemPath localFilePath = FilesystemPath.fromString(ファイル格納フォルダ名);
            ReadOnlySharedFileEntryDescriptor ro_sfed
                    = ReadOnlySharedFileEntryDescriptor.fromEntity(entity);
            try {
                FilesystemPath 保存先フォルダのパス = SharedFile.copyToLocal(ro_sfed, localFilePath);
                result.set保存先フォルダのパス(保存先フォルダのパス);
            } catch (Exception ex) {
                Logger.getLogger(KokuhorenKyoutsuuFileGetManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new BatchInterruptedException(ex.getMessage());
            }
        }
        result.setEntityList(entityList);
        return result;
    }

}
