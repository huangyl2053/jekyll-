/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010041;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041.FutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041.FutanGengakuNinteishaListDivSpec;
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
 * 負担限度額認定者リスト画面の入力チェックです。
 *
 * @reamsid_L DBD-3960-010 xuejm
 */
public class FutanGengakuNinteishaListValidationHandler {

    /**
     * 対象年度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div FutanGengakuNinteishaListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor対象年度と課税判定等基準日の未入力チェック(ValidationMessageControlPairs pairs,
            FutanGengakuNinteishaListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutanGengakuNinteishaListDivSpec.対象年度の未入力チェック)
                .thenAdd(Messagescheck.対象年度の未入力チェック)
                .ifNot(FutanGengakuNinteishaListDivSpec.課税判定等基準日の未入力チェック)
                .thenAdd(Messagescheck.課税判定等基準日の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.対象年度の未入力チェック, div.getTxtTaishoYM())
                .add(Messagescheck.課税判定等基準日の未入力チェック, div.getTxtKazeiHanteiToKijunDate()).build().check(messages));
        return pairs;
    }

    /**
     * 基準日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div FutanGengakuNinteishaListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor基準日の未入力チェック(ValidationMessageControlPairs pairs,
            FutanGengakuNinteishaListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutanGengakuNinteishaListDivSpec.基準日の未入力チェック)
                .thenAdd(Messagescheck.基準日の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.基準日の未入力チェック, div.getTxtKijunYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 所得年度未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div FutanGengakuNinteishaListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor所得年度の未入力チェック(ValidationMessageControlPairs pairs,
            FutanGengakuNinteishaListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutanGengakuNinteishaListDivSpec.所得年度の未入力チェック)
                .thenAdd(Messagescheck.所得年度の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.所得年度の未入力チェック, div.getTxtShotokuNendo()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        対象年度の未入力チェック(UrErrorMessages.必須, "対象年度"),
        所得年度の未入力チェック(UrErrorMessages.必須, "所得年度"),
        基準日の未入力チェック(UrErrorMessages.必須, "基準日"),
        課税判定等基準日の未入力チェック(UrErrorMessages.必須, "課税判定等基準日");

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
