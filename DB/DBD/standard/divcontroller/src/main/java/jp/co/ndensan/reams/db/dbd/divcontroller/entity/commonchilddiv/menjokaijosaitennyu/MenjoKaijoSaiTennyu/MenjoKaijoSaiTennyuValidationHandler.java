/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.menjokaijosaitennyu.MenjoKaijoSaiTennyu;

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
 *
 * @author x_wangtt2
 */
public class MenjoKaijoSaiTennyuValidationHandler {

    /**
     * 1号償還払い化ダイアログの適用期間チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額適用期間チェック(ValidationMessageControlPairs pairs, MenjoKaijoSaiTennyuDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(MenjoKaijoSaiTennyuDivSpec.適用期間チェック)
                .thenAdd(MenjoKaijoSaiTennyuValidationHandler.MenjoKaijoSaiTennyuMessages.期間が不正_追加メッセージあり2).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                MenjoKaijoSaiTennyuValidationHandler.MenjoKaijoSaiTennyuMessages.期間が不正_追加メッセージあり2,
                div.getTxtGengakuTekiyoKikanKaishiYMD()).build().check(messages));

        return pairs;
    }

    private static enum MenjoKaijoSaiTennyuMessages implements IValidationMessage {

        期間が不正_追加メッセージあり2(UrErrorMessages.期間が不正_追加メッセージあり２, "適用期間(開始)", "適用期間(終了)");
        private final Message message;

        private MenjoKaijoSaiTennyuMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

}
