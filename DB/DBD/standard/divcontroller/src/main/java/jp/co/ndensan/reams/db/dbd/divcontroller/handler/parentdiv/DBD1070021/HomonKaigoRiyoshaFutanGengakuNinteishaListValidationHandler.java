/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070021;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021.HomonKaigoRiyoshaFutanGengakuNinteishaListDivSpec;
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
 * 訪問介護利用者負担額減額認定者リスト画面のチェックです。
 *
 * @reamsid_L DBD-3970-010 xuejm
 */
public class HomonKaigoRiyoshaFutanGengakuNinteishaListValidationHandler {

    /**
     * 対象年度の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor対象年度と課税判定等基準日の未入力チェック(ValidationMessageControlPairs pairs,
            HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuNinteishaListDivSpec.対象年度の未入力チェック)
                .thenAdd(Messagescheck.対象年度の未入力チェック)
                .ifNot(HomonKaigoRiyoshaFutanGengakuNinteishaListDivSpec.課税判定等基準日の未入力チェック)
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
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor基準日の未入力チェック(ValidationMessageControlPairs pairs,
            HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuNinteishaListDivSpec.基準日の未入力チェック)
                .thenAdd(Messagescheck.基準日の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.基準日の未入力チェック, div.getTxtKijunYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 所得年度,旧措置者区分,世帯表示の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor所得年度の未入力チェック(ValidationMessageControlPairs pairs,
            HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HomonKaigoRiyoshaFutanGengakuNinteishaListDivSpec.所得年度の未入力チェック)
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
