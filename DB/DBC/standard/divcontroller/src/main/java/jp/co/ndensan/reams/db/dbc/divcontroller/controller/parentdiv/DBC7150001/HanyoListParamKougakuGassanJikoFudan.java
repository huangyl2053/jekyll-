/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7150001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710150.DBC710150_HanyoListKogakuGassanJikoFutangakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001.HanyoListParamKougakuGassanJikoFudanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7150001.HanyoListParamKougakuGassanJikoFudanHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7150001.HanyoListParamKougakuGassanJikoFudanValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト(高額合算自己負担額情報)のクラスです。
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class HanyoListParamKougakuGassanJikoFudan {

    private static final ReportId 帳票ID = new ReportId("DBC701015_HanyoList_KogakuGassanJikoFutangaku");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト(高額合算自己負担額情報)画面のdiv
     * @return 初期化画面
     */
    public ResponseData<HanyoListParamKougakuGassanJikoFudanDiv> onLoad(HanyoListParamKougakuGassanJikoFudanDiv div) {
        getHandler(div).initialize();
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        div.getCcdShutsuryokuKoumoku().load(帳票ID.getColumnValue(), SubGyomuCode.DBC介護給付);
        return createResponse(div);
    }

    /**
     * 「選択」ボタンを押すの場合。
     *
     * @param div 汎用リスト(高額合算自己負担額情報)画面のdiv
     * @return 画面
     */
    public ResponseData<HanyoListParamKougakuGassanJikoFudanDiv> onSelect_DdlDetaSakuseiKubunButton(HanyoListParamKougakuGassanJikoFudanDiv div) {
        getHandler(div).getEditDdlDetaSakuseiKubun();
        return createResponse(div);
    }

    /**
     * 入力項目チェックです。
     *
     * @param div 汎用リスト(高額合算自己負担額情報)
     * @return ResponseData
     */
    public ResponseData<HanyoListParamKougakuGassanJikoFudanDiv> onClick_Check(HanyoListParamKougakuGassanJikoFudanDiv div) {
        HanyoListParamKougakuGassanJikoFudanValidationHandler handler = new HanyoListParamKougakuGassanJikoFudanValidationHandler(div);
        ValidationMessageControlPairs pairs = handler.getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    /**
     * click事件「実行する」ボタンです。
     *
     * @param div HanyoListParamKougakuGassanJikoFudanDiv
     * @return ResponseData
     */
    public ResponseData<DBC710150_HanyoListKogakuGassanJikoFutangakuParameter> click_batchRegister(HanyoListParamKougakuGassanJikoFudanDiv div) {
        HanyoListParamKougakuGassanJikoFudanHandler handler = getHandler(div);
        DBC710150_HanyoListKogakuGassanJikoFutangakuParameter parameter = handler.getBatchParamter();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamKougakuGassanJikoFudanHandler getHandler(HanyoListParamKougakuGassanJikoFudanDiv div) {
        return new HanyoListParamKougakuGassanJikoFudanHandler(div);
    }

    private ResponseData<HanyoListParamKougakuGassanJikoFudanDiv> createResponse(HanyoListParamKougakuGassanJikoFudanDiv div) {
        return ResponseData.of(div).respond();
    }
}
