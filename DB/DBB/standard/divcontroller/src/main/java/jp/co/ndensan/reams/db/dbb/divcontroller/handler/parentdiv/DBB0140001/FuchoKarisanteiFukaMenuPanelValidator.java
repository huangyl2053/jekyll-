/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックValidatorです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaMenuPanelValidator {

    private final FuchoKarisanteiFukaMenuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link FuchoKarisanteiFukaMenuPanelDiv hoDiv}
     */
    public FuchoKarisanteiFukaMenuPanelValidator(FuchoKarisanteiFukaMenuPanelDiv div) {
        this.div = div;
    }

    /**
     * 発行日未入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate発行日入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FuchoKarisanteiFukaMenuPanelSpec.発行日未入力入力チェック)
                .thenAdd(FuchoKarisanteiFukaMenuPanelValidationMessage.発行日チェック)
                .messages());
        return messages;
    }

    /**
     * 対象者入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate対象者入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FuchoKarisanteiFukaMenuPanelSpec.対象者未選択チェック)
                .thenAdd(FuchoKarisanteiFukaMenuPanelValidationMessage.対象者チェック)
                .messages());
        return messages;
    }

    /**
     * 帳票IDのチェック_型0です。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate帳票IDのチェック_型0() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FuchoKarisanteiFukaMenuPanelSpec.帳票IDのチェック_型0)
                .thenAdd(FuchoKarisanteiFukaMenuPanelValidationMessage.帳票IDのチェック_型0)
                .messages());
        return messages;
    }

    /**
     * 帳票IDのチェック_型2です。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate帳票IDのチェック_型2() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FuchoKarisanteiFukaMenuPanelSpec.帳票IDのチェック_型2)
                .thenAdd(FuchoKarisanteiFukaMenuPanelValidationMessage.帳票IDのチェック_型2)
                .messages());
        return messages;
    }

}
