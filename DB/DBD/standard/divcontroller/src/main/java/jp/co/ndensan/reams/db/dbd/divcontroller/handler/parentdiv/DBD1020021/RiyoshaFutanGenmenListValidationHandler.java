/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020021;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020021.RiyoshaFutanGenmenListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020021.RiyoshaFutanGenmenListDivSpec;
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
 * 利用者負担額減免認定者リスト画面のチェックです。
 *
 * @reamsid_L DBD-3980-010 xuejm
 */
public class RiyoshaFutanGenmenListValidationHandler {

    /**
     * 基準日.所得年度,旧措置者区分,世帯表示の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutanGenmenListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor基準日と所得年度の未入力チェック(ValidationMessageControlPairs pairs,
            RiyoshaFutanGenmenListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RiyoshaFutanGenmenListDivSpec.基準日の未入力チェック)
                .thenAdd(Messagescheck.基準日の未入力チェック)
                .ifNot(RiyoshaFutanGenmenListDivSpec.所得年度の未入力チェック)
                .thenAdd(Messagescheck.所得年度の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.基準日の未入力チェック, div.getTxtKijunYMD())
                .add(Messagescheck.所得年度の未入力チェック, div.getTxtShotokuNendo()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        所得年度の未入力チェック(UrErrorMessages.必須, "所得年度"),
        基準日の未入力チェック(UrErrorMessages.必須, "基準日");

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
