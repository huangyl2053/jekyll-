/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5510001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 要介護認定進捗状況照会のValidationHandlerです。
 */
public class YokaigoNinteiShinchokuJohoShokaiValidationHandler {
    
        private final YokaigoNinteiShinchokuJohoShokaiDiv div;
        private static final RString KEY0 = new RString("key0");
        private static final RString KEY1 = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiShinchokuJohoShokaiDiv
     */
    public YokaigoNinteiShinchokuJohoShokaiValidationHandler(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        this.div = div;
    }

    /**
     * 「進捗状況一覧表を発行する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 日付チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (KEY1.equals(div.getRadKensakuHoho().getSelectedKey()) && !KEY0.equals(div.getRadHizukeHani().getSelectedKey())) {
            if ((div.getTxtShiteiHizukeRange().getFromValue() == null) || (div.getTxtShiteiHizukeRange().getToValue() == null)) {
                validationMessages.add(new ValidationMessageControlPair(
                        YokaigoNinteiShinchokuJohoShokaiValidationHandler.RRVMessages.必須項目, div.getTxtShiteiHizukeRange()));
            }
        }
        return validationMessages;
    }

    /**
     * 被保険者番号のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 被保険者番号必須チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (KEY0.equals(div.getRadKensakuHoho().getSelectedKey())) {
            if (RString.isNullOrEmpty(div.getTxtHihokenshaNo().getValue())) {
                validationMessages.add(new ValidationMessageControlPair(
                        YokaigoNinteiShinchokuJohoShokaiValidationHandler.RRVMessages.必須項目, div.getTxtHihokenshaNo()));

            }
        }
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        必須項目(UrErrorMessages.必須項目);

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
