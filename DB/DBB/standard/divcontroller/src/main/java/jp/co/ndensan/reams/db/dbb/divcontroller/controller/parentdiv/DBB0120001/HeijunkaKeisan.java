/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0120001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.DBB0120001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0120001.HeijunkaKeisanHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0120001.HeijunkaKeisanValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 特徴平準化（特徴6月分）コントロールdivです。
 *
 * @reamsid_L DBB-0820-010 xuyue
 */
public class HeijunkaKeisan {

    private final RString 特徴平準化_特徴6月分_メニュー = new RString("DBBMN35001");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> onLoad(HeijunkaKeisanDiv div) {
        getHandler(div).initialize();
        if (ResponseHolder.getMenuID().equals(特徴平準化_特徴6月分_メニュー)) {
            return ResponseData.of(div).setState(DBB0120001StateName.平準化計算);
        }
        return ResponseData.of(div).setState(DBB0120001StateName.通知書一括発行);
    }

    /**
     * コントロールdivが「生成」された際の処理です。(オンアクティブ)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> onActive(HeijunkaKeisanDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行/予約する」ボタンの前処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> beforeOnClick_btnHakko(HeijunkaKeisanDiv div) {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor発行日の必須入力(validPairs, div);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特徴平準化（特徴6月分）メニューからの「実行する」ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter> onClick_btnHeijunkaJikko(HeijunkaKeisanDiv div) {
        // TODO 「バッチ設計_DBBBT35001_特徴平準化（特徴6月分）.xlsx」が未実装
        TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter parameter = getHandler(div).setBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 特徴平準化（特徴6月分）メニューからの「予約する」ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter> onClick_btnHeijunkaYoyaku(HeijunkaKeisanDiv div) {
        // TODO 「バッチ設計_DBBBT35001_特徴平準化（特徴6月分）.xlsx」が未実装
        TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter parameter = getHandler(div).setBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 特徴平準化（特徴6月分）通知書一括発行メニューからの「実行する」ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter> onClick_btnIkkatsuHakkoJikko(HeijunkaKeisanDiv div) {

        TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter parameter = getHandler(div).setBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 特徴平準化（特徴6月分）通知書一括発行メニューからの「予約する」ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter> onClick_btnIkkatsuHakkoYoyaku(HeijunkaKeisanDiv div) {

        TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter parameter = getHandler(div).setBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private HeijunkaKeisanValidationHandler getValidationHandler() {
        return new HeijunkaKeisanValidationHandler();
    }

    private HeijunkaKeisanHandler getHandler(HeijunkaKeisanDiv div) {
        return new HeijunkaKeisanHandler(div);
    }

}
