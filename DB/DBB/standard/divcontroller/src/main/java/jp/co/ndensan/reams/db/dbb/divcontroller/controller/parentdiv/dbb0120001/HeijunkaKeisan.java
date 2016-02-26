/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0120001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.dbbbt35003.Dbbbt35003FlowParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.valueobject.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TsuchishoIkkatsuHakkoTempData;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0120001.HeijunkaKeisanHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0120001.HeijunkaKeisanValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 特徴平準化（特徴6月分）コントロールdivです。
 */
public class HeijunkaKeisan {

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> onLoad(HeijunkaKeisanDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
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

    public ResponseData<HeijunkaKeisanDiv> beforeOnClick_btnHakko(HeijunkaKeisanDiv div) {
        if (div.getTokuchoHeijunkaChohyoHakko().getTxtHeijunkaHenkoTsuchiHakkoYMD().getValue() == null) {
            ValidationMessageControlPairs validPairs = getValidationHandler().validateFor発行日の必須入力();
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<Dbbbt35003FlowParameter> onClick_btnHakko(HeijunkaKeisanDiv div) {

        Dbbbt35003FlowParameter parameter = new Dbbbt35003FlowParameter();
        TsuchishoIkkatsuHakkoTempData tempData = getHandler(div).getTempData();
        parameter.toDbbt35003Parameter(tempData);
        return ResponseData.of(parameter).respond();
    }

    private HeijunkaKeisanValidationHandler getValidationHandler() {
        return new HeijunkaKeisanValidationHandler();
    }

    private HeijunkaKeisanHandler getHandler(HeijunkaKeisanDiv div) {
        return new HeijunkaKeisanHandler(div);
    }

}
