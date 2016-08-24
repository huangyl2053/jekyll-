/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author slzheng
 */
public class KogakuShikyuValidationHandler {

    private final KogakuShikyuShinseishoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuShikyuValidationHandler(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KogakuKyufuTaishoListDiv
     */
    public static KogakuShikyuValidationHandler of(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        return new KogakuShikyuValidationHandler(div);
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
