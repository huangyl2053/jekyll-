/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020005;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005.KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020005.KyufuSeigenTaishoshaIchiranPanelBatchParameterDivSpec;
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
 * 給付制限対象者一覧CSVのValidationHandlerです。
 *
 * @reamsid_L DBD-4300-010 xuejm
 */
public class KyufuSeigenTaishoshaIchiranPanelBatchParameterValidationHandler {

    /**
     * 出力対象選択なしの入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力対象選択なしの入力チェック(ValidationMessageControlPairs pairs,
            KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KyufuSeigenTaishoshaIchiranPanelBatchParameterDivSpec.出力対象選択なしの入力チェック)
                .thenAdd(Messagescheck.出力対象選択なしの入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.出力対象選択なしの入力チェック, div.getChkKobetushitei()).build().check(messages));
        return pairs;
    }

    /**
     * 出力対象選択なしの入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力順未設定チェック(ValidationMessageControlPairs pairs,
            KyufuSeigenTaishoshaIchiranPanelBatchParameterDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KyufuSeigenTaishoshaIchiranPanelBatchParameterDivSpec.出力順未設定の入力チェック)
                .thenAdd(Messagescheck.出力順未設定の入力チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.出力順未設定の入力チェック, div).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        出力対象選択なしの入力チェック(UrErrorMessages.未指定, "給付制限種別"),
        出力順未設定の入力チェック(UrErrorMessages.未指定, "出力順を");
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
