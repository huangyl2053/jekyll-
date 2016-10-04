/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0700011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050020.DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0700011.BatchParamterInfoHandler;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
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
 * @reamsid_L DBU-1150-010 gongliang
 */
public class BatchParamterInfo {

    private final RString 実行ボタン = new RString("BatchRegister");

    /**
     * 画面初期化onLoad
     *
     * @param div BatchParamterInfoDiv
     * @return 広域内転居結果一覧表作成画面
     */
    public ResponseData<BatchParamterInfoDiv> onLoad(BatchParamterInfoDiv div) {
        SearchResult<KoikiZenShichosonJoho> 市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
        getHandler(div).onLoad(市町村List);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンを押下 checkを実行します。
     *
     * @param div BatchParamterInfoDiv
     * @return 広域内転居結果一覧表作成画面
     */
    public ResponseData<BatchParamterInfoDiv> onClick_btnCheck(BatchParamterInfoDiv div) {
        FlexibleDate kaishihiValue = div.getTxtkaishihi().getValue();
        FlexibleDate shohiValue = div.getTxtshohi().getValue();
        if (kaishihiValue.isEmpty() && shohiValue.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行ボタン, true);
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        } else if (!shohiValue.isEmpty() && !kaishihiValue.isEmpty() && shohiValue.isBefore(kaishihiValue)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行ボタン, true);
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下 バッチを起動する
     *
     * @param div BatchParamterInfoDiv
     * @return バッチを起動する
     */
    public ResponseData<DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter> onClick_btnBatchRegister(BatchParamterInfoDiv div) {
        DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter paramter = getHandler(div).setBatchParamter();
        ResponseData<DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter> responseData = new ResponseData<>();
        responseData.data = getHandler(div).setBatchParamter();
        return ResponseData.of(paramter).respond();
    }

    private BatchParamterInfoHandler getHandler(BatchParamterInfoDiv div) {
        return new BatchParamterInfoHandler(div);
    }
}
