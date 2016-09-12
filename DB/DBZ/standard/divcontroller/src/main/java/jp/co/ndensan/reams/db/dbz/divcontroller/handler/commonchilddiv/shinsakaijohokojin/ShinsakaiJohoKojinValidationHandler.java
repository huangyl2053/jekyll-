/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shinsakaijohokojin;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.ShinsakaiJohoKojinDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.ShinsakaiJohoKojinDivSpec;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「ShinsakaiJohoKojin」の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public class ShinsakaiJohoKojinValidationHandler {

    private final ShinsakaiJohoKojinDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiJohoKojinDiv
     */
    public ShinsakaiJohoKojinValidationHandler(ShinsakaiJohoKojinDiv div) {
        this.div = div;
    }

    /**
     * 画面項目の初期化を行するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShinsakaiJohoKojinDivSpec.審査会未割当チェック)
                .thenAdd(IdocheckMessages.審査会未割当).messages());
        validationMessage.add(new ValidationMessageControlDictionaryBuilder().
                add(IdocheckMessages.審査会未割当, div).build().check(messages));
        return validationMessage;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        審査会未割当(DbzErrorMessages.審査会未割当);

        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
