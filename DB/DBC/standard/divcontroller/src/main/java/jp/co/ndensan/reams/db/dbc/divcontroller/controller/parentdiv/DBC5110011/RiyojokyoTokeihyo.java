/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC5110011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150020.DBC150020_NenreikaikyuRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011.RiyojokyoTokeihyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5110011.RiyojokyoTokeihyoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5110011.RiyojokyoTokeihyoValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC5110011_年齢階級別利用状況作成クラスです。
 *
 * @reamsid_L DBC-3470-010 xuyongchao
 */
public class RiyojokyoTokeihyo {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<RiyojokyoTokeihyoDiv>
     */
    public ResponseData<RiyojokyoTokeihyoDiv> onLoad(RiyojokyoTokeihyoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * コバッチパラメータ復元ボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<RiyojokyoTokeihyoDiv>
     */
    public ResponseData<RiyojokyoTokeihyoDiv> onClick_btnParameterRestore(RiyojokyoTokeihyoDiv div) {
        getHandler(div).onClick_btnKogakuParamRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータ保存ボタンの処理です。
     *
     * @param div 画面情報
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnParameterSave(RiyojokyoTokeihyoDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).setBatchParameter());
        return responseData;
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<RiyojokyoTokeihyoDiv>
     */
    public ResponseData<DBC150020_NenreikaikyuRiyojokyoParameter> onClick_Jikkou(RiyojokyoTokeihyoDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSyujiiIkensyoDiv>
     */
    public ResponseData<RiyojokyoTokeihyoDiv> onClick_Check(RiyojokyoTokeihyoDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).未入力チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private RiyojokyoTokeihyoHandler getHandler(RiyojokyoTokeihyoDiv div) {
        return new RiyojokyoTokeihyoHandler(div);
    }

    private RiyojokyoTokeihyoValidationHandler getValidationHandler(RiyojokyoTokeihyoDiv div) {
        return new RiyojokyoTokeihyoValidationHandler(div);
    }

}
