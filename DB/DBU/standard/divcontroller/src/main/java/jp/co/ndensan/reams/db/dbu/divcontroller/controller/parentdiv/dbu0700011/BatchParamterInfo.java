/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0700011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.hiroshimadomain.HiroshimaDomainBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0700011.BatchParamterInfoHandler;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 広域内転居結果一覧表作成画面Divを制御します。
 *
 */
public class BatchParamterInfo {

    private final RString 実行ボタン = new RString("BatchRegister");

    public ResponseData<BatchParamterInfoDiv> onLoad(BatchParamterInfoDiv div) {
        SearchResult<KoikiZenShichosonJoho> 市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
        getHandler(div).onLoad(市町村List);
        return ResponseData.of(div).respond();
    }

    public ResponseData<BatchParamterInfoDiv> onClick_btnCheck(BatchParamterInfoDiv div) {
        FlexibleDate kaishihiValue = div.getTxtkaishihi().getValue();
        FlexibleDate shohiValue = div.getTxtshohi().getValue();
        if (null == kaishihiValue || kaishihiValue.isEmpty()
                || shohiValue == null || shohiValue.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行ボタン, true);
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        } else if (shohiValue.isBefore(kaishihiValue)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行ボタン, true);
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<HiroshimaDomainBatchParameter> onClick_btnBatchRegister(BatchParamterInfoDiv div) {
        HiroshimaDomainBatchParameter paramter = getHandler(div).setBatchParamter();
        ResponseData<HiroshimaDomainBatchParameter> responseData = new ResponseData<>();
        responseData.data = getHandler(div).setBatchParamter();
        return ResponseData.of(paramter).respond();
    }

    private BatchParamterInfoHandler getHandler(BatchParamterInfoDiv div) {
        return new BatchParamterInfoHandler(div);
    }
}
