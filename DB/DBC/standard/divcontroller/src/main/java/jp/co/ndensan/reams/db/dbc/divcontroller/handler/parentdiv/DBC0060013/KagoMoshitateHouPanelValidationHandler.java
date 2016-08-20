/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060013;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC0060013_訪問通所サービスの給付管理照会ValidationHandlerクラスです。
 *
 * @reamsid_L DBC-2960-040 lizhuoxuan
 */
public class KagoMoshitateHouPanelValidationHandler {

    /**
     * 被保険者番号チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 被保険者番号チェック(ValidationMessageControlPairs validPairs) {
        validPairs.add(new ValidationMessageControlPair(KagoMoshitateHouPanelValidationHandler.HoshushiharaiJumbiMessages.被保険者番号チェック));
        return validPairs;
    }

    private static enum HoshushiharaiJumbiMessages implements IValidationMessage {

        被保険者番号チェック(DbzErrorMessages.理由付き登録不可, "被保険者番号なし");
        private final Message message;

        private HoshushiharaiJumbiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
