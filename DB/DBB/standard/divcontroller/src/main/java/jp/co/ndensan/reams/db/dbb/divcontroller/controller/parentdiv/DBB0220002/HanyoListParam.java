/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0220002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolistparam.HanyoListParamBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220002.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220002.HanyoListParamHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220002.HanyoListParamValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM22002_汎用リスト 所得情報のクラス
 *
 * @reamsid_L DBB-1901-010 surun
 */
public class HanyoListParam {

    /**
     * onLoad
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onLoad(HanyoListParamDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * onClickRunButton
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamBatchParameter>
     */
    public ResponseData<HanyoListParamBatchParameter> onClickRunButton(HanyoListParamDiv div) {
        HanyoListParamBatchParameter parameter = getHandler(div).onClick実行ボタン();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForAction();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(parameter).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }

    private HanyoListParamValidationHandler getValidationHandler(HanyoListParamDiv div) {
        return new HanyoListParamValidationHandler(div);
    }
}
