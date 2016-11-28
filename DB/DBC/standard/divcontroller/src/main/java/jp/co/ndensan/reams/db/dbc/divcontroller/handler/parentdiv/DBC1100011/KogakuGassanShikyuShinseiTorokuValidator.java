/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 高額合算支給申請書登録のValidatorです。
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuValidator {

    private final KogakuGassanShikyuShinseiTorokuAllPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public KogakuGassanShikyuShinseiTorokuValidator(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        this.div = div;
    }

    /**
     * 「入力内容を確定する」ボタン押下時のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate入力内容を確定する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.老人所得区分必須入力チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.老人所得区分必須項目)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.年度内範囲チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.計算期間年度内範囲制約)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.加入期間範囲チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.計算期間加入期間内範囲制約)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.資格喪失チェック1)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.資格喪失1)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.資格喪失チェック2)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.資格喪失2)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.後期資格情報保険者番号チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.後期保険者番号制約)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.国保保険者番号桁数チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.国保保険者番号桁数が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.後期保険者番号桁数チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.後期保険者番号桁数が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.後期被保険者番号桁数チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.後期被保険者番号桁数が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.被保険者証記号桁数チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.国保被保険者番号桁数が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.被保険者証番号桁数チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.被保険者証番号桁数が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.介護日付チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.介護日付が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.被保日付チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.被保日付が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.国保日付チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.国保日付が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.後期日付チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.後期日付が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.開始計算期間チェック1)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間1)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.開始計算期間チェック2)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間2)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.開始計算期間チェック3)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間3)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.開始計算期間チェック4)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間4)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.開始計算期間チェック5)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間5)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.開始計算期間チェック6)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間6)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.終了計算期間チェック1)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間1)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.終了計算期間チェック2)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間2)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.終了計算期間チェック3)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間3)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.終了計算期間チェック4)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間4)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.終了計算期間チェック5)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間5)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.終了計算期間チェック6)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間6)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.所得区分入力チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.所得区分必須項目)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.加入期間FROM入力チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.加入期間必須項目)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.加入期間TO入力チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.加入期間必須項目)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.備考文字種チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.備考文字種)
                .messages());
        return messages;
    }

    /**
     * 「加入情報を確定する」ボタン押下時のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate加入情報を確定する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.保険加入期間が不正チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.保険加入期間が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.自己負担額証明書整理番号桁数チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.証明書整理番号桁数が不正)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.自己負担額証明書整理番号既に存在チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.証明書整理番号既に存在)
                .messages());
        return messages;
    }

    /**
     * 「申請情報を保存する」ボタン押下時のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate申請情報を保存する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KogakuGassanShikyuShinseiTorokuSpec.医療支給申請書整理番号入力チェック)
                .thenAdd(KogakuGassanShikyuShinseiTorokuValidationMessage.医療支給申請書整理番号入力桁不足)
                .messages());
        return messages;
    }
}
