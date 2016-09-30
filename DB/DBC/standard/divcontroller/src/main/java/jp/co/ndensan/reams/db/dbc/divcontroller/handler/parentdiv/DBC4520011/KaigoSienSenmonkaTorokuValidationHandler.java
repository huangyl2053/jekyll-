/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護支援専門員登録画面 のValidationHandlerです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmonkaTorokuValidationHandler {

    private final KaigoSienSenmonkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KaigoSienSenmonkaTorokuDiv}
     */
    public KaigoSienSenmonkaTorokuValidationHandler(KaigoSienSenmonkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 様式番号一覧チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages message = new KaigoSienSenmonkaTorokuValidator(div).validate();
        return createDictionary().check(message);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KaigoSienSenmonkaTorokuValidationMessage.介護支援専門員番号の重複チェック,
                        div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango()).build();
    }
}
