/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額サービス費給付お知らせ通知書作成です。
 *
 * @reamsid_L DBC-4770-010 zhengshenlei
 */
public class KogakuShikyuValidationHandler {

    /**
     * コンストラクタです。
     *
     * @return KogakuShikyuValidationHandler
     */
    public static KogakuShikyuValidationHandler of() {
        return new KogakuShikyuValidationHandler();
    }

    /**
     * 確定チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 確定チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new KogakuShikyuValidationHandler.IdocheckMessages(
                        DbcErrorMessages.被保険者の高額介護サービス支給申請情報が無い.getMessage())));
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(Message message) {
            this.message = message;
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
