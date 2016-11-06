/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1170011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 自己負担額証明書作成ののValidationHandlerです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public class JikoFutangakushomeishoValidationHandler {

    /**
     *
     * @param 対象者データ 対象者データ
     * @return validPairs validPairs
     */
    public ValidationMessageControlPairs 対象者チェック(KogakuGassanShinseisho 対象者データ) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (対象者データ == null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.対象者チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        対象者チェック(DbcInformationMessages.自己負担額データなし),
        発行済みチェック(DbcWarningMessages.発行済み負担額証明書),
        再計算区分チェック(DbcWarningMessages.高額合算申請書情報の再計算前);
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
