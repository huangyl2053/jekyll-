/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050021;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021.SFKTishoshaIchiranPanelBatchParameterDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021.SFKTishoshaIchiranPanelBatchParameterDivSpec;
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
 * 事業所向け社会福祉法人軽減対象者一覧発行画面の入力チェックです
 *
 * @reamsid_L DBD-3810-010 xuejm
 */
public class SFKTishoshaIchiranPanelBatchParameterValidationHandler {

    /**
     * 出力順未設定チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div SFKTishoshaIchiranPanelBatchParameterDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力順未設定チェック(ValidationMessageControlPairs pairs,
            SFKTishoshaIchiranPanelBatchParameterDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SFKTishoshaIchiranPanelBatchParameterDivSpec.出力順未設定チェック)
                .thenAdd(Messagescheck.出力順未設定チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.出力順未設定チェック, div).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        出力順未設定チェック(UrErrorMessages.未指定, "出力順");

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
