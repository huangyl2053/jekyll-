/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7170001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710170.DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7170001.HanyoListParameteDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7170001.HanyoListParameteHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト出力(高額合算支給額決定情報)のクラスです。
 *
 * @reamsid_L DBC-3101-010 qinzhen
 */
public class HanyoListParamete {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParameteDiv> onLoad(HanyoListParameteDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 支給区分RbGrのonChangeです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParameteDiv> onChange_Chushutsukikan(HanyoListParameteDiv div) {
        getHandler(div).set支給制御処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 支払方法区分RbGrのonChangeです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParameteDiv> onChange_BunshoBangoInput(HanyoListParameteDiv div) {
        getHandler(div).set支払方法制御処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter> onClick_btnExcute(HanyoListParameteDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private HanyoListParameteHandler getHandler(HanyoListParameteDiv div) {
        return new HanyoListParameteHandler(div);
    }
}
