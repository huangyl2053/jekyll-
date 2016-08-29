/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7140001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710140.DBC710140_HanyoListKogakuGassanShinseishoJohoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7140001.HanyoListParamHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7140001.HanyoListParamValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(高額合算申請書情報)のクラスです。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public class HanyoListParam {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト出力(高額合算申請書情報)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<HanyoListParamDiv> onLoad(HanyoListParamDiv div) {
        getHandler(div).initialize();
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701014.getReportId());
        return createResponse(div);
    }

    /**
     * 入力項目チェックです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParamDiv> onClick_Check(HanyoListParamDiv div) {
        HanyoListParamValidationHandler handler = new HanyoListParamValidationHandler(div);
        ValidationMessageControlPairs pairs = handler.getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    /**
     * 条件を保存するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnSeikatsuKogakuParamSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        DBC710140_HanyoListKogakuGassanShinseishoJohoParameter parameter = getHandler(div).onClick_btnKogakuParamSave();
        responseData.data = new BatchParameterMap(parameter);
        return responseData;
    }

    /**
     * 条件を復元するボタン押下です。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onClick_tekiyoJyokenFukugen(HanyoListParamDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * click事件「実行する」ボタンです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<DBC710140_HanyoListKogakuGassanShinseishoJohoParameter> click_batchRegister(HanyoListParamDiv div) {
        HanyoListParamHandler handler = getHandler(div);
        DBC710140_HanyoListKogakuGassanShinseishoJohoParameter parameter = handler.getBatchParamter();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }

    private ResponseData<HanyoListParamDiv> createResponse(HanyoListParamDiv div) {
        return ResponseData.of(div).respond();
    }
}
