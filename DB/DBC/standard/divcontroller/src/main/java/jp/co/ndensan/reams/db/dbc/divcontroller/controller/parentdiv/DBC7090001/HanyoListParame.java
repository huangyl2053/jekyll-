/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7090001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710090.DBC710090_HanyoListKagoMoshitateParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7090001.HanyoListParameDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7090001.HanyoListParameHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト出力(過誤申立情報)のクラスです。
 *
 * @reamsid_L DBC-3095-010 qinzhen
 */
public class HanyoListParame {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div HanyoListParameDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParameDiv> onLoad(HanyoListParameDiv div) {
        getHandler(div).initialize();

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div HanyoListParameDiv
     * @return ResponseData
     */
    public ResponseData<DBC710090_HanyoListKagoMoshitateParameter> onClick_btnExcute(HanyoListParameDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private HanyoListParameHandler getHandler(HanyoListParameDiv div) {
        return new HanyoListParameHandler(div);
    }
}
