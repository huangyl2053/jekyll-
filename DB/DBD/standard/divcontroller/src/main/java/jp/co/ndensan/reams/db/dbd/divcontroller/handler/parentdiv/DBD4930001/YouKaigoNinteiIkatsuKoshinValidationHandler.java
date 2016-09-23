/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4930001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4930001.YouKaigoNinteiIkatsuKoshinDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4930001.YouKaigoNinteiIkatsuKoshinDivSpec;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定一括更新のValidationHandlerです。
 *
 * @reamsid_L DBD-2120-010 x_liuwei
 */
public class YouKaigoNinteiIkatsuKoshinValidationHandler {

    private final YouKaigoNinteiIkatsuKoshinDiv div;
    private final int days = 60;

    /**
     * コンストラクターです。
     *
     * @param div YouKaigoNinteiIkatsuKoshinValidationHandler
     */
    public YouKaigoNinteiIkatsuKoshinValidationHandler(YouKaigoNinteiIkatsuKoshinDiv div) {
        this.div = div;
    }

    /**
     * 認定日チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor認定日(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.期間が不正_未来日付不可, div.getTxtNinteibi().getValue().toString(), RDate.getNowDate().plusDay(days).toString());
        messages.add(ValidateChain.validateStart(div).ifNot(YouKaigoNinteiIkatsuKoshinDivSpec.認定日チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtNinteibi()).build().check(messages));
        return pairs;
    }

    private static final class NoInputMessages implements IValidationMessage {

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
