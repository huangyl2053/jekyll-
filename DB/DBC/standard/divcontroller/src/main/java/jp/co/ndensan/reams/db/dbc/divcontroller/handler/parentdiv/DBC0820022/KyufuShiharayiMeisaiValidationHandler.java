/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820022;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細）のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-1030-040 liaoyang
 */
public class KyufuShiharayiMeisaiValidationHandler {

    private final KyufuShiharayiMeisaiPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 仮算定異動賦課Div
     */
    public KyufuShiharayiMeisaiValidationHandler(KyufuShiharayiMeisaiPanelDiv div) {
        this.div = div;
    }

    /**
     * 入所年月日のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 必須チェックValidate() {
        IValidationMessages messages = new KyufuShiharayiMeisaiValidationHandler.ControlValidator(div).サービス種類コードチェックValidate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KyufuShiharayiMeisaiPanelValidationMessages.サービス種類コードチェック).build();
    }

    private static class ControlValidator {

        private final KyufuShiharayiMeisaiPanelDiv div;

        public ControlValidator(KyufuShiharayiMeisaiPanelDiv div) {
            this.div = div;
        }

        /**
         * サービス種類不正のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages サービス種類コードチェックValidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KyufuShiharayiMeisaiSpec.サービス種類コードチェック)
                    .thenAdd(KyufuShiharayiMeisaiValidationHandler.KyufuShiharayiMeisaiPanelValidationMessages.サービス種類コードチェック)
                    .messages());
            return messages;
        }
    }

    private static enum KyufuShiharayiMeisaiPanelValidationMessages implements IValidationMessage {
        サービス種類コードチェック(DbcErrorMessages.サービス種類不正);

        private final Message message;

        KyufuShiharayiMeisaiPanelValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
