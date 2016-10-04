/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010004;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010004.SystemKanriTokubetsuChiikiTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * システム管理登録（社会福祉法人確認番号）画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-3763-010 tz_chengpeng
 */
public class SystemKanriTokubetsuChiikiTotalValidator implements IValidatable {

    private final SystemKanriTokubetsuChiikiTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriTokubetsuChiikiTotalDiv
     */
    public SystemKanriTokubetsuChiikiTotalValidator(SystemKanriTokubetsuChiikiTotalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.有効桁数必須入力チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.有効桁数が未入力)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.減額率の分子必須入力チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分子が未入力)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.減額率の分母必須入力チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分母が未入力)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.有効桁数の有効性チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.有効桁数入力値が不正)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.減額率の有効性チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率入力値が不正)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.減額率の分子の有効性チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分子入力値が不正)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.減額率の分母の有効性チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.減額率の分母入力値が不正)
                .ifNot(SystemKanriTokubetsuChiikiTotalSpec.変更有無チェック)
                .thenAdd(SystemKanriTokubetsuChiikiTotalValidationMessage.更新対象のデータがない)
                .messages());
        return messages;
    }
}
