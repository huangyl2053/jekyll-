/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010032;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032.FutanyikkatsuShoninkekkaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032.FutanyikkatsuShoninkekkaListDivSpec;
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
 * 一括承認結果一覧の入力チェックです。
 *
 * @reamsid_L DBD-3710-030 xuejm
 */
public class FutanyikkatsuShoninkekkaListValidationHandler {

    /**
     * 承認確定対象存在チェック
     *
     * @param pairs バリデーションコントロール
     * @param div FutanyikkatsuShoninListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor承認確定対象存在チェック(ValidationMessageControlPairs pairs, FutanyikkatsuShoninkekkaListDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutanyikkatsuShoninkekkaListDivSpec.承認確定対象存在チェック)
                .thenAdd(Messagescheck.承認確定対象存在チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.承認確定対象存在チェック, div.getDatagridhojipanel().getDgNinteiIchiran()).build().check(messages));
        return pairs;
    }

    /**
     * 修正保存対象存在チェック
     *
     * @param pairs バリデーションコントロール
     * @param div FutanyikkatsuShoninListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor修正保存対象存在チェック(ValidationMessageControlPairs pairs, FutanyikkatsuShoninkekkaListDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(FutanyikkatsuShoninkekkaListDivSpec.修正保存対象存在チェック)
                .thenAdd(Messagescheck.修正保存対象存在チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.修正保存対象存在チェック, div.getDatagridhojipanel().getDgNinteiIchiran()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        承認確定対象存在チェック(UrErrorMessages.対象データなし),
        修正保存対象存在チェック(UrErrorMessages.対象データなし);

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
