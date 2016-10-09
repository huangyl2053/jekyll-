/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010031;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031.FutangendogakuShoninMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031.FutangendogakuShoninMainDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 負担限度額認定申請承認（一括）の入力チェックです。
 *
 * @reamsid_L DBD-3710-010 xuejm
 */
public class FutangendogakuShoninMainValidationHandler {

    /**
     * 作成年度,決定日,申請日終了と申請日開始の比較,発行日のの未入力チェック
     *
     * @param pairs バリデーションコントロール
     * @param div FutangendogakuShoninMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForの未入力チェック(ValidationMessageControlPairs pairs, FutangendogakuShoninMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutangendogakuShoninMainDivSpec.作成年度の未入力チェック)
                .thenAdd(Messagescheck.作成年度の未入力チェック)
                .ifNot(FutangendogakuShoninMainDivSpec.決定日の未入力チェック)
                .thenAdd(Messagescheck.決定日の未入力チェック).messages()
        );
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.作成年度の未入力チェック, div.getTxtSakuseiNendo())
                .add(Messagescheck.決定日の未入力チェック, div.getTxtKetteibi()).build().check(messages));
        return pairs;
    }

    /**
     * 発行日の未入力チェック
     *
     * @param pairs バリデーションコントロール
     * @param div FutangendogakuShoninMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor発行日の未入力チェック(ValidationMessageControlPairs pairs, FutangendogakuShoninMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutangendogakuShoninMainDivSpec.発行日の未入力チェック)
                .thenAdd(Messagescheck.発行日の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.発行日の未入力チェック, div.getTxtHakkoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 申請日開始の比較入力チェック
     *
     * @param pairs バリデーションコントロール
     * @param div FutangendogakuShoninMainDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請日終了と申請日開始の比較チェック(ValidationMessageControlPairs pairs, FutangendogakuShoninMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutangendogakuShoninMainDivSpec.申請日終了と申請日開始の比較チェック)
                .thenAdd(Messagescheck.申請日終了と申請日開始の比較チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.申請日終了と申請日開始の比較チェック, div.getTxtShinseibiJoken()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        作成年度の未入力チェック(UrErrorMessages.必須, "作成年度"),
        決定日の未入力チェック(UrErrorMessages.必須, "決定日"),
        申請日終了と申請日開始の比較チェック(UrErrorMessages.必須, "申請日終了と申請日開始"),
        発行日の未入力チェック(UrErrorMessages.必須, "発行日");

        private final Message message;

        private Messagescheck(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
