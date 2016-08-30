/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC7200001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710200.DBC710200_HanyoListKijunShunyugakuTekiyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7200001.HanyoListBatchParamDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7200001.HanyoListBatchParamHandler;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 汎用リスト_基準収入額適用情報のクラスです。
 *
 * @reamsid_L DBC-5050-010 xuyannan
 */
public class HanyoListBatchParam {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 汎用リスト_基準収入額適用情報画面のdiv
     * @return 初期化画面
     */
    public ResponseData<HanyoListBatchParamDiv> onLoad(HanyoListBatchParamDiv div) {
        List<KaigoDonyuKeitai> list = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        getHandler(div).onLoad(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件を保存する」ボタンを押下します。
     *
     * @param div 汎用リスト_基準収入額適用情報画面のdiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HanyoListBatchParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnBatchParameterSave());
        return responseData;
    }

    /**
     * 「条件を復元する」ボタンを押下します。
     *
     * @param div HanyoListBatchParamDiv
     * @return ResponseData<HanyoListBatchParamDiv>
     */
    public ResponseData<HanyoListBatchParamDiv> onClick_btnBatchParameterRestore(HanyoListBatchParamDiv div) {
        getHandler(div).onClick_btnBatchParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * データ種別RBTのonChangeです。
     *
     * @param div HanyoListBatchParamDiv
     * @return ResponseData<HanyoListBatchParamDiv>
     */
    public ResponseData<HanyoListBatchParamDiv> onChange_DataShubetsu(HanyoListBatchParamDiv div) {
        getHandler(div).set抽出区分の表示制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出区分RBTのonChangeです。
     *
     * @param div HanyoListBatchParamDiv
     * @return ResponseData<HanyoListBatchParamDiv>
     */
    public ResponseData<HanyoListBatchParamDiv> onChange_ChushutsuKubun(HanyoListBatchParamDiv div) {
        getHandler(div).set基準年月の表示制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div HanyoListBatchParamDiv
     * @return ResponseData<HanyoListBatchParamDiv>
     */
    public ResponseData<DBC710200_HanyoListKijunShunyugakuTekiyoParameter> onClick_btnBatchRegister(HanyoListBatchParamDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnBatchParameterSave()).respond();
    }

    private HanyoListBatchParamHandler getHandler(HanyoListBatchParamDiv div) {
        return new HanyoListBatchParamHandler(div);
    }
}
