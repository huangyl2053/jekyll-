/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0220001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB022001.DBB022001_FukaDaichoHanyoListSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001.HanyoListFukaDaichoParamDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220001.HanyoListFukaDaichoParamHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220001.HanyoListFukaDaichoParamValidationHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM22001_汎用リスト賦課台帳のクラス
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class HanyoListFukaDaichoParam {

    /**
     * 初期化イベント。
     *
     * @param div HanyoListFukaDaichoParamDiv
     * @return ResponseData<HanyoListFukaDaichoParamDiv>
     */
    public ResponseData<HanyoListFukaDaichoParamDiv> onLoad(HanyoListFukaDaichoParamDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するボタンのメソッドです。
     *
     * @param div HanyoListFukaDaichoParamDiv
     * @return ResponseData
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(HanyoListFukaDaichoParamDiv div) {
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnExecute());
        return responseData;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param div HanyoListFukaDaichoParamDiv
     * @return ResponseData
     */
    public ResponseData<HanyoListFukaDaichoParamDiv> onClick_btnBatchParameterRestore(HanyoListFukaDaichoParamDiv div) {
        getHandler(div).pamaRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 最新状態で抽出CKBがチェック。
     *
     * @param div HanyoListFukaDaichoParamDiv
     * @return ResponseData<HanyoListFukaDaichoParamDiv>
     */
    public ResponseData<HanyoListFukaDaichoParamDiv> onChange_chkKijyunbiSiteiUmu(HanyoListFukaDaichoParamDiv div) {
        getHandler(div).onChange_chkKijyunbiSiteiUmu();
        return ResponseData.of(div).respond();
    }

    /**
     * 基準日未入力チェック。
     *
     * @param div HanyoListFukaDaichoParamDiv
     * @return ResponseData<HanyoListFukaDaichoParamDiv>
     */
    public ResponseData<HanyoListFukaDaichoParamDiv> checkTxtKijyunbi(HanyoListFukaDaichoParamDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForAction();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンイベント。
     *
     * @param div HanyoListFukaDaichoParamDiv
     * @return ResponseData<HanyoListFukaDaichoBatchParameter>
     */
    public ResponseData<DBB022001_FukaDaichoHanyoListSakuseiParameter> onClick_btnExecute(HanyoListFukaDaichoParamDiv div) {
        DBB022001_FukaDaichoHanyoListSakuseiParameter parameter = getHandler(div).onClick_btnExecute();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListFukaDaichoParamHandler getHandler(HanyoListFukaDaichoParamDiv div) {
        return new HanyoListFukaDaichoParamHandler(div);
    }

    private HanyoListFukaDaichoParamValidationHandler getValidationHandler(HanyoListFukaDaichoParamDiv div) {
        return new HanyoListFukaDaichoParamValidationHandler(div);
    }

}
