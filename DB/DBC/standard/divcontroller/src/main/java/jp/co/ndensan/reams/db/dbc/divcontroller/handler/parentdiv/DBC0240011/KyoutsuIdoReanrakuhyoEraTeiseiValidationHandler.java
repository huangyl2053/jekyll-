/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0240011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共同処理用受給者異動連絡票エラー訂正の検証ハンドラクラスです。
 *
 * @reamsid_L DBC-2770-010 chenxiangyu
 */
public class KyoutsuIdoReanrakuhyoEraTeiseiValidationHandler {

    private static final RString メッセージ引数 = new RString("履歴訂正データなし");

    /**
     * 対象データなしメッセージを取得します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get対象データなしメッセージ() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(
                new IdocheckMessages(UrErrorMessages.対象データなし_追加メッセージあり, メッセージ引数.toString())));
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
