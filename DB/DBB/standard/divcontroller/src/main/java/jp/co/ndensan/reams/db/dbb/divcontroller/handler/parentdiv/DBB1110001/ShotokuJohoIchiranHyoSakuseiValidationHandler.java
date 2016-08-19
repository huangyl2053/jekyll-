/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1110001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51003_所得情報一覧表作成ValidationHandlerのクラスです。
 *
 * @reamsid_L DBB-1650-010 lijunjun
 */
public class ShotokuJohoIchiranHyoSakuseiValidationHandler {

    /**
     * 日付のチェックエラーのメソッドです。
     *
     * @param flag boolean
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check日付(boolean flag) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (flag) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.終了日が開始日以前)));
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
