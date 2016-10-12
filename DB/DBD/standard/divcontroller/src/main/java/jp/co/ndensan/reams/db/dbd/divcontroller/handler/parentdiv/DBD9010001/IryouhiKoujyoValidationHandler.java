/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001.IryouhiKoujyoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 医療費控除登録画面のValidationHandlerです。
 *
 * @reamsid_L DBD-5770-010 tz_chengpeng
 */
public class IryouhiKoujyoValidationHandler {

    /**
     * 申請年月日、対象年の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div IryouhiKoujyoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請年月日と対象年の未入力チェック(ValidationMessageControlPairs pairs,
            IryouhiKoujyoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(IryouhiKoujyoSpec.申請年月日の未入力チェック)
                .thenAdd(Messagescheck.申請年月日の未入力チェック)
                .ifNot(IryouhiKoujyoSpec.対象年の未入力チェック)
                .thenAdd(Messagescheck.対象年の未入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.申請年月日の未入力チェック, div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD())
                .add(Messagescheck.対象年の未入力チェック, div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        申請年月日の未入力チェック(UrErrorMessages.必須, "申請年月日"),
        対象年の未入力チェック(UrErrorMessages.必須, "対象年");

        private final Message message;

        private Messagescheck(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static enum IryouhiKoujyoSpec implements IPredicate<IryouhiKoujyoDiv> {

        /**
         * 申請年月日の未入力チェック。
         */
        申請年月日の未入力チェック {
                    @Override
                    public boolean apply(IryouhiKoujyoDiv div) {
                        return div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().getValue() != null;
                    }
                },
        /**
         * 対象年の未入力チェック。
         */
        対象年の未入力チェック {
                    @Override
                    public boolean apply(IryouhiKoujyoDiv div) {
                        return div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().getValue() != null;
                    }
                };

    }
}
