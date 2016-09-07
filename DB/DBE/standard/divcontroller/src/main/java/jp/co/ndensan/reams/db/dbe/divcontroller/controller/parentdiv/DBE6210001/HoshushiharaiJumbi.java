/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6210001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.hoshushiharaijunbi.HoshuShiharaiJunbiBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6210001.HoshushiharaiJumbiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6210001.HoshushiharaiJumbiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6210001.HoshushiharaiJumbiValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE6210001_報酬支払い準備画面クラスです
 *
 * @reamsid_L DBE-1980-010 xuyongchao
 */
public class HoshushiharaiJumbi {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return HoshushiharaiJumbiDiv
     */
    public ResponseData<HoshushiharaiJumbiDiv> onLoad(HoshushiharaiJumbiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 発行するボタン処理です。
     *
     * @param div 画面情報
     * @return HoshushiharaiJumbiDiv
     */
    public ResponseData<HoshuShiharaiJunbiBatchParameter> onClick_btnHakkou(HoshushiharaiJumbiDiv div) {
        return ResponseData.of(getHandler(div).onClick_btnHakkou()).respond();
    }

    /**
     * チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<HoshushiharaiJumbiDiv>
     */
    public ResponseData<HoshushiharaiJumbiDiv> onClick_Check(HoshushiharaiJumbiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).出力帳票未指定チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).実績期間チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).振込指定日チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private HoshushiharaiJumbiValidationHandler getValidationHandler(HoshushiharaiJumbiDiv div) {
        return new HoshushiharaiJumbiValidationHandler(div);
    }

    private HoshushiharaiJumbiHandler getHandler(HoshushiharaiJumbiDiv div) {
        return new HoshushiharaiJumbiHandler(div);
    }

}
