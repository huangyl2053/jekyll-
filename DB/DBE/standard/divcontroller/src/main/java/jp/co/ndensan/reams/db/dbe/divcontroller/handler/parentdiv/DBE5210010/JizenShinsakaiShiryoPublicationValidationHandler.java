/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public class JizenShinsakaiShiryoPublicationValidationHandler {

    /**
     * コンストラクタです。
     */
    public JizenShinsakaiShiryoPublicationValidationHandler() {
    }

    /**
     * UrErrorMessages.入力値が不正です。:%1
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs check入力値が不正() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new JizenShinsakaiShiryoPublicationValidationHandler.CheckMessages(
                UrErrorMessages.入力値が不正_追加メッセージあり, "部数")));
        return validPairs;
    }

    /**
     * UrErrorMessages.%1が選択されていません。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs check選択され() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new JizenShinsakaiShiryoPublicationValidationHandler.CheckMessages(
                UrErrorMessages.選択されていない, "選択条件")));
        return validPairs;
    }

    /**
     * UrErrorMessages.対象のデータがありません。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs check対象のデータ() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new JizenShinsakaiShiryoPublicationValidationHandler.CheckMessages(
                UrErrorMessages.対象データなし, "")));
        return validPairs;
    }

    private static class CheckMessages implements IValidationMessage {

        private final Message message;

        public CheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
