/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220002;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220002.HanyoListParamDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM22002_汎用リスト 所得情報のValidationHandlerクラス
 *
 * @reamsid_L DBB-1901-010 surun
 */
public class HanyoListParamValidationHandler {

    private final HanyoListParamDiv div;

    /**
     * 初期化
     *
     * @param div HanyoListParamDiv
     */
    public HanyoListParamValidationHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、チェックを行う。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJokenPanel().getTxtChushutsuKikan() != null
                && div.getChushutsuJokenPanel().getTxtChushutsuKikan().getFromValue() != null
                && div.getChushutsuJokenPanel().getTxtChushutsuKikan().getToValue() != null
                && div.getChushutsuJokenPanel().getTxtChushutsuKikan().getToValue().
                isBefore(div.getChushutsuJokenPanel().getTxtChushutsuKikan().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.終了日が開始日以前),
                    div.getChushutsuJokenPanel().getTxtChushutsuKikan()));
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
