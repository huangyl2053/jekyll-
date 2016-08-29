/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7100001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710100.DBC710100_HanyoListKagoKekkaParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7100001.HanyoListParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7100001.HanyoListParameterHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト出力(過誤結果情報)のクラスです。
 *
 * @reamsid_L DBC-3094-010 qinzhen
 */
public class HanyoListParameter {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div HanyoListParameterDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParameterDiv> onLoad(HanyoListParameterDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div HanyoListParameterDiv
     * @return ResponseData
     */
    public ResponseData<DBC710100_HanyoListKagoKekkaParameter> onClick_btnExcute(HanyoListParameterDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private HanyoListParameterHandler getHandler(HanyoListParameterDiv div) {
        return new HanyoListParameterHandler(div);
    }
}
