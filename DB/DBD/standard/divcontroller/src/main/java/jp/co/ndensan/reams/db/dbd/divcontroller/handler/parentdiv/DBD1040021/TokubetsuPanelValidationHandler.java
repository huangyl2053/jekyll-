/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040021;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDivSpec;
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
 * 特別地域加算軽減実績管理リストのチェックです。
 *
 * @reamsid_L DBD-3880-010 xuejm
 */
public class TokubetsuPanelValidationHandler {

    /**
     * 年月範囲開始が非空チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokubetsuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor年月範囲が非空チェック(ValidationMessageControlPairs pairs, TokubetsuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TokubetsuPanelDivSpec.年月範囲開始が非空必須チェック)
                .thenAdd(Messagescheck.年月範囲開始が非空必須チェック)
                .ifNot(TokubetsuPanelDivSpec.年月範囲終了が非空必須チェック)
                .thenAdd(Messagescheck.年月範囲終了が非空必須チェック).messages()
        );
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.年月範囲開始が非空必須チェック, div.getTxtRangeYM())
                .add(Messagescheck.年月範囲終了が非空必須チェック, div.getTxtRangeYM()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        年月範囲開始が非空必須チェック(UrErrorMessages.必須, "年月範囲開始"),
        年月範囲終了が非空必須チェック(UrErrorMessages.必須, "年月範囲終了");

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
