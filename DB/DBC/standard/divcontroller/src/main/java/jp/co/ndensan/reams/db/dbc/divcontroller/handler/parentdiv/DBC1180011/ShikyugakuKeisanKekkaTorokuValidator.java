/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 高額合算支給額計算結果登録のValidatorです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuValidator {

    private final ShikyugakuKeisanKekkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public ShikyugakuKeisanKekkaTorokuValidator(ShikyugakuKeisanKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 「計算結果を保存する」ボタン押下時のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate計算結果を保存する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.明細グリッドチェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.明細グリッド必須項目)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.按分後支給額チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.按分後支給額)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.うち70歳以上分チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.以上の者に係る所得区分必須項目)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.介護等合算算定基準額チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.介護等合算算定基準額必須項目)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.対象計算期間終了年月日チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.対象計算期間終了年月日入力値が不正)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.年度内範囲チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.計算期間年度内範囲制約)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.金額チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.金額入力値が不正)
                .messages());
        return messages;
    }

    /**
     * 整合性チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate整合性チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.高額合算支給不支給決定データの存在チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.高額合算支給不支給決定データの存在)
                .messages());
        return messages;
    }

    /**
     * 「計算結果を追加する」ボタン押下時のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate計算結果を追加する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.連絡票整理番号チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.連絡票整理番号必須項目)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.重複チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.連絡票整理番号既に存在)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.年度チェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.連絡票整理番号年度が不正)
                .messages());
        return messages;
    }

    /**
     * 「内訳を確定する」ボタン押下時のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate内訳を確定する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.既に存在のチェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.自己負担額証明書整理番号既に存在)
                .messages());
        return messages;
    }

    /**
     * 内訳入力途中のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate内訳入力途中() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShikyugakuKeisanKekkaTorokuSpec.内訳入力途中のチェック)
                .thenAdd(ShikyugakuKeisanKekkaTorokuMessage.内訳入力途中)
                .messages());
        return messages;
    }
}
