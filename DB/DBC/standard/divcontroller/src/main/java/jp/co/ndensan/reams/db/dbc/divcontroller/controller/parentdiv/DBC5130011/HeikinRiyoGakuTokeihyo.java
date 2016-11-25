/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5130011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150040.DBC150040_HeikinriyogakuTokeihyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5130011.HeikinRiyoGakuTokeihyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5130011.HeikinRiyoGakuTokeihyoHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 平均利用額統計表のDivControllerクラスです。
 *
 * @reamsid_L DBC-3490-010 sunhaidi
 */
public class HeikinRiyoGakuTokeihyo {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div HeikinRiyoGakuTokeihyoDiv
     * @return ResponseData<HeikinRiyoGakuTokeihyoDiv>
     */
    public ResponseData<HeikinRiyoGakuTokeihyoDiv> onLoad(HeikinRiyoGakuTokeihyoDiv div) {
        div.getChikuShitei().getCcdChikuShichosonSelect().initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するボタンのイベントメソッドです。
     *
     * @param div HeikinRiyoGakuTokeihyoDiv
     * @return ResponseData<HeikinRiyoGakuTokeihyoDiv>
     */
    public ResponseData<HeikinRiyoGakuTokeihyoDiv> onClick_btnBatchParameterRestore(HeikinRiyoGakuTokeihyoDiv div) {

        getHandler(div).onClick_btnBatchParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を復元するボタンのイベントメソッドです。
     *
     * @param div HeikinRiyoGakuTokeihyoDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HeikinRiyoGakuTokeihyoDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).getBatchParameter());
        return responseData;
    }

    /**
     * 「実行する」ボタンのイベントメソッドです。
     *
     * @param div HeikinRiyoGakuTokeihyoDiv
     * @return ResponseData<DBC150040_HeikinriyogakuTokeihyoBatchParameter>
     */
    public ResponseData<DBC150040_HeikinriyogakuTokeihyoParameter> onClick_btnBatchRegister(HeikinRiyoGakuTokeihyoDiv div) {
        return ResponseData.of(getHandler(div).getBatchParameter()).respond();
    }

    private HeikinRiyoGakuTokeihyoHandler getHandler(HeikinRiyoGakuTokeihyoDiv div) {
        return new HeikinRiyoGakuTokeihyoHandler(div);
    }
}
