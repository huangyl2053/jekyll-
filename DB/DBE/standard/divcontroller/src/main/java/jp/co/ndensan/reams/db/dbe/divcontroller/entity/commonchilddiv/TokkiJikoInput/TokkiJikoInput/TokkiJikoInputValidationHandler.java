/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;

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
 * 特記事項入力ダイアログのバリデーションハンドラークラスです。
 * 
 * @author n3423
 */
public class TokkiJikoInputValidationHandler {
    
    /**
     * 特記事項の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokkiJikoInputDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特記事項の必須入力(ValidationMessageControlPairs pairs, TokkiJikoInputDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokkiJikoInputDivSpec.特記事項日の非空チェック)
                .thenAdd(NoInputMessages.特記事項の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.特記事項の必須入力,
                div.getTokkiJikoNyuryoku().getTxtTokkiJiko()).build().check(messages));
        return pairs;
    }
    
    private static enum NoInputMessages implements IValidationMessage {

        特記事項の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "特記事項");
        
        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
