/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2700011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020.DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011.TorikomiFuairuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2700011.TorikomiFuairuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2700011.TorikomiFuairuValidationHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付費単位数表標準マスタ取込画面のDivControllerです。
 *
 * @reamsid_L DBC-3400-010 x_zhaowen
 */
public class TorikomiFuairu {

    private final RString 共有ファイル名 = new RString("KM999999_COMMON.CSV");

    /**
     * 「アップロード」ボタンの処理です。
     *
     * @param div TorikomiFuairuDiv
     * @param files FileData[]
     * @return ResponseData
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<TorikomiFuairuDiv> onClick_btnAppurodo(TorikomiFuairuDiv div, FileData[] files) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler(div).validateForアップロードファイル未指定(pairs);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(共有ファイル名);
         RString maeSharedName = RString.EMPTY;
        RString atoSharedName = RString.EMPTY;
        for (UzT0885SharedFileEntryEntity sharedfile : sharedFiles) {
            atoSharedName = sharedfile.getSharedFileName();
            if (atoSharedName.compareTo(maeSharedName) != 0) {
                SharedFile.copyToLocal(FilesystemName.fromString(atoSharedName), FilesystemPath.fromString(Path.getTmpDirectoryPath()));
                maeSharedName = atoSharedName;
            }
        }
        RString csvFilePath = Path.combinePath(Path.getTmpDirectoryPath(), atoSharedName);
        getHandler(div).upload(csvFilePath);
        div.getTxtFuairuName().setValue(atoSharedName);
//        div.getTxtKoshinNichiji().setValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンのチェックです。
     * 
     * @param div TorikomiFuairuDiv
     * @return ResponseData<TorikomiFuairuDiv>
     */
    public ResponseData<TorikomiFuairuDiv> onCheck_btnExecute(TorikomiFuairuDiv div) {
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(共有ファイル名);
        if (sharedFiles == null || sharedFiles.isEmpty()) {
            throw new BatchInterruptedException(DbzErrorMessages.アップロードファイル無し.getMessage().toString());
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 実行ボタン処理です。
     * 
     * @param div TorikomiFuairuDiv
     * @return ResponseData<DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter>
     */
    public ResponseData<DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter> onClick_btnExecute(TorikomiFuairuDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }
    
    private TorikomiFuairuValidationHandler getValidationHandler(TorikomiFuairuDiv div) {
        return new TorikomiFuairuValidationHandler(div);
    }
    
    private TorikomiFuairuHandler getHandler(TorikomiFuairuDiv div) {
        return new TorikomiFuairuHandler(div);
    }
    
    
}
