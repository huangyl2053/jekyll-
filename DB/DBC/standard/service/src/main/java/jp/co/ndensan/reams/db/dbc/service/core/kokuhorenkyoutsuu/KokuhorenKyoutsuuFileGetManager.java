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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.dac._UzT0885SharedFileEntryDac;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.core.mybatis._DbSession;
import jp.co.ndensan.reams.uz.uza.core.mybatis._SessionKey;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

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
    private static final RString DB_SESSION_ERROR = new RString("DB接続セッションの取得に失敗しました。");

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
            return result;
        }
        if (null == entityList || entityList.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.取込対象ファイルが存在しない.getMessage()
                    .replace(PREFIX.concat(交換情報識別番号).toString()));
        }

        for (UzT0885SharedFileEntryEntity entity : entityList) {
            FilesystemName sharedFileName = FilesystemName.fromString(entity.getSharedFileName());
            FilesystemPath localFilePath = FilesystemPath.fromString(ファイル格納フォルダ名);
            ReadOnlySharedFileDescriptor ro_sfd = new ReadOnlySharedFileDescriptor(sharedFileName);
            RDateTime sharedFileId = getMaxSharedFileId(ro_sfd);
            if (sharedFileId == null) {
                throw new ApplicationException("指定の共有ファイルは存在しません。 共有ファイル：" + ro_sfd.getLabel());
            }
            ReadOnlySharedFileEntryDescriptor ro_sfed
                    = new ReadOnlySharedFileEntryDescriptor(sharedFileName, sharedFileId);
            try {
                FilesystemPath 保存先フォルダのパス = SharedFile.copyToLocal(ro_sfed, localFilePath);
                result.setEntityList(entityList);
                result.set保存先フォルダのパス(保存先フォルダのパス);
            } catch (Exception ex) {
                Logger.getLogger(KokuhorenKyoutsuuFileGetManager.class.getName()).log(Level.SEVERE, null, ex);
                return result;
            }
        }

        return result;
    }

    private static RDateTime getMaxSharedFileId(SharedFileDescriptor sfd) {
        RDateTime ret = null;
        try (SqlSession session = getGyomuSession(sfd.getGyomuCd())) {
            try {
                _UzT0885SharedFileEntryDac sharedFileEntryDac = new _UzT0885SharedFileEntryDac(session);
                UzT0885SharedFileEntryEntity entity885 = sharedFileEntryDac.selectMaxSharedFileId(sfd);
                if (entity885 != null) {
                    ret = entity885.getSharedFileId();
                }
                session.commit();
            } catch (Exception ex) {
                session.rollback();
                throw new SystemException(String.format("最も新しい共有ファイルエントリの検索に失敗。[%s]", sfd.getLabel()), ex);
            }
        } catch (Exception e) {
            throw new SystemException(e.getMessage() != null ? e.getMessage() : DB_SESSION_ERROR.toString(), e);
        }
        return ret;
    }

    /**
     * 業務のセッション情報を返却します。
     *
     * @param gyomuCode 主管業務コード
     * @return 業務のセッション情報
     */
    private static SqlSession getGyomuSession(GyomuCode gyomuCode) {
        if (gyomuCode == null) {
            throw new SystemException("引数(GyomuCode)が null です。");
        } else if (gyomuCode == GyomuCode.EMPTY) {
            throw new SystemException("引数(GyomuCode)が GyomuCode.EMPTY です。");
        }
        //独自にTxnを開始・終了するので、MAINセッションは使えません。
        _SessionKey key = _SessionKey.of(SharedFile.class, gyomuCode);
        return _DbSession.get(key);
    }
}
