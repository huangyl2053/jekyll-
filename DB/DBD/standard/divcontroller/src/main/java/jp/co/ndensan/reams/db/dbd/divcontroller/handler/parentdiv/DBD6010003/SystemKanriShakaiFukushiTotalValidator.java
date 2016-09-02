/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * システム管理登録（社会福祉法人確認番号）画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-3762-010 tz_chengpeng
 */
public class SystemKanriShakaiFukushiTotalValidator implements IValidatable {

    private final SystemKanriShakaiFukushiTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriShakaiFukushiTotalDiv
     */
    public SystemKanriShakaiFukushiTotalValidator(SystemKanriShakaiFukushiTotalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.有効桁数必須入力チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.有効桁数が未入力)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.減免率の分子必須入力チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.減免率の分子が未入力)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.減免率の分母必須入力チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.減免率の分母が未入力)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.軽減率の分子必須入力チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分子が未入力)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.軽減率の分母必須入力チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分母が未入力)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.有効桁数の有効性チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.有効桁数入力値が不正)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.減免率の有効性チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.減免率入力値が不正)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.軽減率の分子の有効性チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分子入力値が不正)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.軽減率の分母の有効性チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.軽減率の分母入力値が不正)
                .ifNot(SystemKanriShakaiFukushiTotalSpec.変更有無チェック)
                .thenAdd(SystemKanriShakaiFukushiTotalValidationMessage.更新対象のデータがない)
                .messages());
        return messages;
    }
}
