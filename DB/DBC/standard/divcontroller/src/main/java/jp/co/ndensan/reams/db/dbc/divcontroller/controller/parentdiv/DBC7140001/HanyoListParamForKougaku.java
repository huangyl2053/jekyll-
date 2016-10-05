/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7140001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710140.DBC710140_HanyoListKogakuGassanShinseishoJohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001.HanyoListParamForKougakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7140001.HanyoListParamForKougakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7140001.HanyoListParamForKougakuValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(高額合算申請書情報)のクラスです。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public class HanyoListParamForKougaku {

    private static final ReportId 帳票ID = new ReportId("DBC701014_HanyoList_KogakuGassanShinseishoJoho");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト出力(高額合算申請書情報)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<HanyoListParamForKougakuDiv> onLoad(HanyoListParamForKougakuDiv div) {
        getHandler(div).initialize();
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        div.getCcdShutsuryokuKoumoku().load(帳票ID.getColumnValue(), SubGyomuCode.DBC介護給付);
        return createResponse(div);
    }

    /**
     * 入力項目チェックです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParamForKougakuDiv> onClick_Check(HanyoListParamForKougakuDiv div) {
        HanyoListParamForKougakuValidationHandler handler = new HanyoListParamForKougakuValidationHandler(div);
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
    public ResponseData<BatchParameterMap> onClick_btnSeikatsuKogakuParamSave(HanyoListParamForKougakuDiv div) {
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
    public ResponseData<HanyoListParamForKougakuDiv> onClick_tekiyoJyokenFukugen(HanyoListParamForKougakuDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * click事件「実行する」ボタンです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<DBC710140_HanyoListKogakuGassanShinseishoJohoParameter> click_batchRegister(HanyoListParamForKougakuDiv div) {
        HanyoListParamForKougakuHandler handler = getHandler(div);
        DBC710140_HanyoListKogakuGassanShinseishoJohoParameter parameter = handler.getBatchParamter();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamForKougakuHandler getHandler(HanyoListParamForKougakuDiv div) {
        return new HanyoListParamForKougakuHandler(div);
    }

    private ResponseData<HanyoListParamForKougakuDiv> createResponse(HanyoListParamForKougakuDiv div) {
        return ResponseData.of(div).respond();
    }
}
