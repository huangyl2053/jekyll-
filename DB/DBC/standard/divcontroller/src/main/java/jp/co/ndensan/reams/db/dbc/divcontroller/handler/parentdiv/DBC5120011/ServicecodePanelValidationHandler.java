/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011.ServicecodePanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * サービスコード別利用状況です
 *
 * @reamsid_L DBC-3340-010 lihang
 */
public class ServicecodePanelValidationHandler {

    private final ServicecodePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinseishoHakkoDiv
     */
    public ServicecodePanelValidationHandler(ServicecodePanelDiv div) {
        this.div = div;
    }

    /**
     * get入力チェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (null != div.getChusyutsuPanel().getTxthani().getToValue()
                && null != div.getChusyutsuPanel().getTxthani().getFromValue()
                && div.getChusyutsuPanel().getTxthani().getToValue().isBefore(div.getChusyutsuPanel().getTxthani().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    new ServicecodePanelValidationHandler.ServicecodePanelValidationMessages(
                            UrErrorMessages.終了日が開始日以前)));
        }
        return validPairs;
    }

    private static class ServicecodePanelValidationMessages implements IValidationMessage {

        private final Message message;

        ServicecodePanelValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
