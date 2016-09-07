/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6040001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会委員報酬照会の画面処理ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1920-010 zhaoyao
 */
public class ShinsakauIinHoshuShokaiValidationHandler {

    private final ShinsakauIinHoshuShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面Divデタ
     */
    public ShinsakauIinHoshuShokaiValidationHandler(ShinsakauIinHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 必須引数の設定
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor必須引数() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getShinsakaiKaisaibi().getTxtShinsakaiKaisaiYM().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    ValidationCheckMessages.審査会開催年月必須入力チェック, div.getShinsakaiKaisaibi().getTxtShinsakaiKaisaiYM()));
        }
        return validPairs;
    }

    private static enum ValidationCheckMessages implements IValidationMessage {

        審査会開催年月必須入力チェック(UrErrorMessages.必須, "審査会開催年月");
        private final Message message;

        private ValidationCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
