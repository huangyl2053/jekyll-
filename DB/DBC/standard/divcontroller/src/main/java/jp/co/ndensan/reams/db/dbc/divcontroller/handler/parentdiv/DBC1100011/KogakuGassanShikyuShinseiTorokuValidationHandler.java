/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuAllPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額合算支給申請書登録のValidationHandlerです。
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuValidationHandler {

    private final KogakuGassanShikyuShinseiTorokuAllPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KogakuGassanShikyuShinseiTorokuAllPanelDiv}
     */
    public KogakuGassanShikyuShinseiTorokuValidationHandler(KogakuGassanShikyuShinseiTorokuAllPanelDiv div) {
        this.div = div;
    }

    /**
     * 「入力内容を確定する」ボタン押下時のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate入力内容を確定する() {
        IValidationMessages message = new KogakuGassanShikyuShinseiTorokuValidator(div).validate入力内容を確定する();
        return create入力内容を確定するDictionary().check(message);
    }

    private ValidationDictionary create入力内容を確定するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.老人所得区分必須項目)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.計算期間年度内範囲制約)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.計算期間加入期間内範囲制約)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.資格喪失1)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.資格喪失2)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.後期保険者番号制約)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.国保保険者番号桁数が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.後期保険者番号桁数が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.後期被保険者番号桁数が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.国保被保険者番号桁数が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.被保険者証番号桁数が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.介護日付が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.被保日付が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.国保日付が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.後期日付が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間1)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間2)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間3)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間4)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間5)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.開始計算期間6)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間1)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間2)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間3)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間4)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間5)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.終了計算期間6)
                .build();
    }

    /**
     * 「加入情報を確定する」ボタン押下時のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate加入情報を確定する() {
        IValidationMessages message = new KogakuGassanShikyuShinseiTorokuValidator(div).validate加入情報を確定する();
        return create加入情報を確定するDictionary().check(message);
    }

    private ValidationDictionary create加入情報を確定するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.保険加入期間が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.証明書整理番号桁数が不正)
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.証明書整理番号既に存在).build();
    }

    /**
     * 「申請情報を保存する」ボタン押下時のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate申請情報を保存する() {
        IValidationMessages message = new KogakuGassanShikyuShinseiTorokuValidator(div).validate申請情報を保存する();
        return create申請情報を保存するDictionary().check(message);
    }

    private ValidationDictionary create申請情報を保存するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.医療支給申請書整理番号入力桁不足).build();
    }
}
