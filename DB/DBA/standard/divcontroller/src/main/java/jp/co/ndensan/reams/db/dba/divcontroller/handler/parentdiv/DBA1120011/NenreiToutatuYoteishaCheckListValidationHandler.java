/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1120011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1120011.NenreiToutatuYoteishaCheckListDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author n8407
 */
public class NenreiToutatuYoteishaCheckListValidationHandler {
    
    private final NenreiToutatuYoteishaCheckListDiv div;
        /**
     * コンストラクタです。
     *
     * @param div IdochekkurisutoDiv
     */
    public NenreiToutatuYoteishaCheckListValidationHandler(NenreiToutatuYoteishaCheckListDiv div) {
        this.div = div;
    }
    
        /**
     * 今回開始日と今回終了日の順番の整合性をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs checkShuryoToValueInput() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtKonkaiRange().getToValue()==null||div.getTxtKonkaiRange().getToValue().toString().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    NenreiToutatuYoteishaCheckListValidationHandler.IdocheckMessages.今回終了日必須, div.getTxtKonkaiRange()));
        }
        
        return validationMessages;
    }
    
    private static enum IdocheckMessages implements IValidationMessage {

        今回開始日必須(UrErrorMessages.必須, "今回開始日"),
        今回終了日必須(UrErrorMessages.必須, "今回終了日");

        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
