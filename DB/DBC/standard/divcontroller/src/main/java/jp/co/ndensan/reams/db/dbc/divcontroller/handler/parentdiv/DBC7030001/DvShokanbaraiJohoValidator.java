/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 「実行する」ボタンを押下時の入力チェックValidatorです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJohoValidator {

    private final DvShokanbaraiJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link DvShokanbaraiJo hoDiv}
     */
    public DvShokanbaraiJohoValidator(DvShokanbaraiJohoDiv div) {
        this.div = div;
    }

    /**
     * 様式番号一覧チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate様式番号一覧() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.様式番号一覧チェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.様式番号一覧データ未指定)
                .messages());
        return messages;
    }

    /**
     * 支払方法と金融機関コード制御チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate金融機関コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.金融機関コードチェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.金融機関コードは未指定でなければなりません)
                .messages());
        return messages;
    }

    /**
     * サービス提供年月From、サービス提供年月Toの大小関係チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validateサービス提供年月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.サービス提供年月チェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.サービス提供年月期間が不正)
                .messages());
        return messages;
    }

    /**
     * サービス提供年月From、サービス提供年月Toの大小関係チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate申請日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.申請日チェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.申請日期間が不正)
                .messages());
        return messages;
    }

    /**
     * 住宅改修支給届出日From、住宅改修支給届出日Toの大小関係チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate住宅改修支給届出日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.住宅改修支給届出日チェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.住宅改修支給届出日期間が不正)
                .messages());
        return messages;
    }

    /**
     * 決定日From、決定日Toの大小関係チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate決定日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.決定日チェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.決定日期間が不正)
                .messages());
        return messages;
    }

    /**
     * 国保連送付年月From、国保連送付年月Toの大小関係チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate国保連送付年月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.国保連送付年月チェック)
                .thenAdd(DvShokanbaraiJohoValidationMessage.国保連送付年月期間が不正)
                .messages());
        return messages;
    }

    /**
     * 対象のデータがありませんcheckです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validateCommonButton() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvShokanbaraiJohoSpec.isCommonButtonVisible)
                .thenAdd(DvShokanbaraiJohoValidationMessage.対象のデータがありません)
                .messages());
        return messages;
    }
}
