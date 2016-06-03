/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックValidatorです。
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiPanelValidator {

    private final KogakuServicehiPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link DvShokanbaraiJo hoDiv}
     */
    public KogakuServicehiPanelValidator(KogakuServicehiPanelDiv div) {
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
                .ifNot(KogakuServicehiPanelSpec.被保険者を指定入力チェック)
                .thenAdd(KogakuServicehiPanelValidationMessage.被保険者を指定入力チェック)
                .messages());
        return messages;
    }

    /**
     * 提供年月チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate提供年月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuServicehiPanelSpec.提供年月チェック)
                .thenAdd(KogakuServicehiPanelValidationMessage.提供年月チェック)
                .messages());
        return messages;
    }

    /**
     * 申請年月チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate申請年月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuServicehiPanelSpec.申請年月チェック)
                .thenAdd(KogakuServicehiPanelValidationMessage.申請年月チェック)
                .messages());
        return messages;
    }

    /**
     * 決定年月チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate決定年月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuServicehiPanelSpec.決定年月チェック)
                .thenAdd(KogakuServicehiPanelValidationMessage.決定年月チェック)
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
                .ifNot(KogakuServicehiPanelSpec.年月を指定入力チェック)
                .thenAdd(KogakuServicehiPanelValidationMessage.年月を指定入力チェック)
                .messages());
        return messages;
    }
}
