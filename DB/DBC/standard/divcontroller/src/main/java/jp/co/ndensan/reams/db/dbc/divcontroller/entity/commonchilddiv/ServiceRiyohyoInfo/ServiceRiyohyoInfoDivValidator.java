/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * サービス利用票情報のValidatorです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfoDivValidator {

    private final ServiceRiyohyoInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public ServiceRiyohyoInfoDivValidator(ServiceRiyohyoInfoDiv div) {
        this.div = div;
    }

    /**
     * 「明細の計算」ボタンのチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate明細計算() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
//                .ifNot(ServiceRiyohyoInfoDivSpec.事業者コード必須入力のチェックです)
//                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.事業者必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.サービスコード必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.サービスコード必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.単位必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.単位必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.回数必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.回数必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.サービス単位必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.サービス単位必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.割引適用後率入力値が不正チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.割引適用後率入力値が不正チェック)
                .messages());
        return messages;
    }
    
    /**
     * 事業者必須入力のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate事業者必須入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.事業者コード必須入力のチェックです)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.事業者必須項目)
                .messages());
        return messages;
    }

    /**
     * 割引適用後率のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate割引適用後率() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.割引適用後率入力値が不正チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.割引適用後率入力値が不正チェック)
                .messages());
        return messages;
    }

    /**
     * 回数のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate回数() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.回数入力値が不正チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.回数入力値が不正)
                .messages());
        return messages;
    }

    /**
     * 単位数単価のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate単位数単価() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.単位数単価力値が不正チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.単位数単価入力値が不正)
                .messages());
        return messages;
    }

    /**
     * 給付率のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate給付率() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.給付率入力値が不正チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.給付率入力値が不正)
                .messages());
        return messages;
    }

    /**
     * サービス単位必須のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validateサービス単位必須() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.サービス単位必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.サービス単位必須項目)
                .messages());
        return messages;
    }

    /**
     * サービス種類必須のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validateサービス種類必須() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.サービス種類必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.サービス種類コード必須項目)
                .messages());
        return messages;
    }

    /**
     * サービス単位必須以外のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validateサービス単位必須以外() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.サービス種類必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.サービス種類コード必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.単位必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.単位必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.回数必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.回数必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.単位数単価必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.単位数単価必須項目)
                .ifNot(ServiceRiyohyoInfoDivSpec.区分限度内単位必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.区分限度内単位必須項目)
                .messages());
        return messages;
    }

    /**
     * 給付率必須のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate給付率必須() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ServiceRiyohyoInfoDivSpec.給付率必須入力チェック)
                .thenAdd(ServiceRiyohyoInfoDivValidationMessage.給付率必須項目)
                .messages());
        return messages;
    }
}
