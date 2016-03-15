/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShinsakaiJohoKojin;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.ShinsakaiJohoKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shinsakaijohokojin.ShinsakaiJohoKojinHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shinsakaijohokojin.ShinsakaiJohoKojinValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div 「ShinsakaiJohoKojin」のイベントを定義したDivControllerです。
 */
public class ShinsakaiJohoKojin {

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ShinsakaiJohoKojinDiv
     * @return ResponseData<ShinsakaiJohoKojinDiv>
     */
    public ResponseData<ShinsakaiJohoKojinDiv> onLoad(ShinsakaiJohoKojinDiv div) {
        ValidationMessageControlPairs validationMessage = getValidationHandler(div).validateForAction();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        getHandler(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 戻る」ボタン押下の処理です。
     *
     * @param div ShinsakaiJohoKojinDiv
     * @return ResponseData<ShinsakaiJohoKojinDiv>
     */
    public ResponseData<ShinsakaiJohoKojinDiv> btn_Modoru(ShinsakaiJohoKojinDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShinsakaiJohoKojinHandler getHandler(ShinsakaiJohoKojinDiv div) {
        return new ShinsakaiJohoKojinHandler(div);
    }

    private ShinsakaiJohoKojinValidationHandler getValidationHandler(ShinsakaiJohoKojinDiv div) {
        return new ShinsakaiJohoKojinValidationHandler(div);
    }
}
