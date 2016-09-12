/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックValidatorです。
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiTaishoshaKensakuMainValidator {

    private final KogakuServicehiTaishoshaKensakuMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link DvShokanbaraiJo hoDiv}
     */
    public KogakuServicehiTaishoshaKensakuMainValidator(KogakuServicehiTaishoshaKensakuMainDiv div) {
        this.div = div;
    }

    /**
     * 被保険者を指定入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate被保険者を指定入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuServicehiTaishoshaKensakuMainSpec.被保険者を指定入力チェック)
                .thenAdd(KogakuServicehiTaishoshaKensakuMainMessage.被保険者を指定入力チェック)
                .messages());
        return messages;
    }

    /**
     * 年月を指定入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate年月を指定入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuServicehiTaishoshaKensakuMainSpec.年月を指定入力チェック)
                .thenAdd(KogakuServicehiTaishoshaKensakuMainMessage.年月を指定入力チェック)
                .messages());
        return messages;
    }
}
