/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6020001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001.IkenshoSakuseiJissekiShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 意見書作成報酬照会のチェッククラスです。
 *
 */
public class IkenshoSakuseiJissekiValidationHandler {

    private final IkenshoSakuseiJissekiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IkenshoSakuseiJissekiShokaiDiv
     */
    public IkenshoSakuseiJissekiValidationHandler(IkenshoSakuseiJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * データの必須選択チェックを実施します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForCheckedDataCount() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgIkenshoSakuseiJisseki().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.対象行を選択)));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
