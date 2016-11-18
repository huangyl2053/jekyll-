/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7170001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710170.DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7170001.HanyoListParameteDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7170001.HanyoListParameteHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算支給額決定情報)のクラスです。
 *
 * @reamsid_L DBC-3101-010 qinzhen
 */
public class HanyoListParamete {
    private static final RString MSG_出力順 = new RString("出力順");

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
     * 条件を保存するボタンのメソッドです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HanyoListParameteDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).setBatchParameter());
        return responseData;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParameteDiv> onClick_btnBatchParameterRestore(HanyoListParameteDiv div) {
        getHandler(div).条件を復元();
        onChange_Chushutsukikan(div);
        onClick_btnBatchParameterSave(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div HanyoListParameteDiv
     * @return ResponseData
     */
    public ResponseData<DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter> onClick_btnExcute(HanyoListParameteDiv div) {
        if (!div.getCcdShutsuryokujun().isSelected()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(MSG_出力順.toString()));
        }
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private HanyoListParameteHandler getHandler(HanyoListParameteDiv div) {
        return new HanyoListParameteHandler(div);
    }
}
