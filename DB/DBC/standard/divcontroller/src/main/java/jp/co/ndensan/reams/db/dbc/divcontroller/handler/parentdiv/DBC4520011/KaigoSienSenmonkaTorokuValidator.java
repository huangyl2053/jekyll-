/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 介護支援専門員登録画面 のValidatorです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmonkaTorokuValidator {

    private final KaigoSienSenmonkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KaigoSienSenmonkaTorokuDiv Div}
     */
    public KaigoSienSenmonkaTorokuValidator(KaigoSienSenmonkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 負担額情報入力の明細月のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KaigoSienSenmonkaTorokuSpec.介護支援専門員番号の重複チェック)
                .thenAdd(KaigoSienSenmonkaTorokuValidationMessage.介護支援専門員番号の重複チェック)
                .messages());
        return messages;
    }
}
