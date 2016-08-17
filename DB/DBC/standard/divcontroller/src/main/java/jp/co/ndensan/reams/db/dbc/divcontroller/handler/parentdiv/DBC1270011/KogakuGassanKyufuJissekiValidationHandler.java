/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1270011;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額合算給付実績照会のコントローラです。
 *
 * @reamsid_L DBC-3010-010 linghuhang
 */
public class KogakuGassanKyufuJissekiValidationHandler {

    /**
     * 受給者または総合事業対象者チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs do受給共通チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(RRVMessages.受給共通));
        return validPairs;
    }

    /**
     * 受給者または総合事業対象者チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs do高額合算給付実績チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        受給共通(DbdErrorMessages.受給共通_受給者_事業対象者登録なし),
        該当データなし(UrErrorMessages.該当データなし);
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
