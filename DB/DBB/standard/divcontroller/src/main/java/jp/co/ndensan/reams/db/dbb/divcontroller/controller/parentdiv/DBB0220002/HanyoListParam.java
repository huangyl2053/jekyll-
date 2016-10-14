/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0220002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB022002.DBB022002_ShotokuJohoHanyoListSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220002.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220002.HanyoListParamHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBBGM22002_汎用リスト 所得情報のクラス
 *
 * @reamsid_L DBB-1901-010 surun
 */
public class HanyoListParam {

    /**
     * 初期化イベント。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onLoad(HanyoListParamDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するボタンのメソッドです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HanyoListParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).条件を保存());
        return responseData;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListParamDiv> onClick_btnBatchParameterRestore(HanyoListParamDiv div) {
        getHandler(div).条件を復元();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンイベント。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamBatchParameter>
     */
    public ResponseData<DBB022002_ShotokuJohoHanyoListSakuseiParameter> onClick_btnExecute(HanyoListParamDiv div) {
        DBB022002_ShotokuJohoHanyoListSakuseiParameter parameter = getHandler(div).onClick_btnExecute();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }

}
