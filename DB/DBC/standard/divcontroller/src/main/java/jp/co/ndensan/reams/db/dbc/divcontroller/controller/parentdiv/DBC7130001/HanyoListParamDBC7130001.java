/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7130001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710130.DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7130001.HanyoListParamDBC7130001Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7130001.HanyoListParamDBC7130001Handler;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト_短期入所拡大該当者のクラスです。
 *
 * @reamsid_L DBC-3111-010 xuyannan
 */
public class HanyoListParamDBC7130001 {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト_短期入所拡大該当者画面のdiv
     * @return 初期化画面
     */
    public ResponseData<HanyoListParamDBC7130001Div> onLoad(HanyoListParamDBC7130001Div div) {
        List<KaigoDonyuKeitai> list = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        getHandler(div).onLoad(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件を保存する」ボタンを押下します。
     *
     * @param div 汎用リスト_短期入所拡大該当者画面のdiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HanyoListParamDBC7130001Div div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnBatchParameterSave());
        return responseData;
    }

    /**
     * 「条件を復元する」ボタンを押下します。
     *
     * @param div HanyoListParamDBC7130001Div
     * @return ResponseData<HanyoListParamDBC7130001Div>
     */
    public ResponseData<HanyoListParamDBC7130001Div> onClick_btnBatchParameterRestore(HanyoListParamDBC7130001Div div) {
        getHandler(div).onClick_btnBatchParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListParamDBC7130001Div
     * @return ResponseData<HanyoListParamDBC7130001Div>
     */
    public ResponseData<DBC710130_HanyoListTankiNyushoKakudaiGaitoshaParameter> onClick_btnBatchRegister(HanyoListParamDBC7130001Div div) {
        return ResponseData.of(getHandler(div).onClick_btnBatchParameterSave()).respond();
    }

    private HanyoListParamDBC7130001Handler getHandler(HanyoListParamDBC7130001Div div) {
        return new HanyoListParamDBC7130001Handler(div);
    }
}
