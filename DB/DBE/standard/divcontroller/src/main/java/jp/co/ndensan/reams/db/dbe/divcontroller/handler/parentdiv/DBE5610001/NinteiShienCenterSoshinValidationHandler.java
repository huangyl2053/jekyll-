/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.NinteiShienCenterSoshinDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * センター送信準備のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public class NinteiShienCenterSoshinValidationHandler {

    private final NinteiShienCenterSoshinDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShienCenterSoshinDiv
     */
    public NinteiShienCenterSoshinValidationHandler(NinteiShienCenterSoshinDiv div) {
        this.div = div;
    }

    /**
     * 二次判定日大小関係チェックを行います。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 二次判定日大小関係チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtNijiHanteibi().getFromValue() != null && div.getTxtNijiHanteibi().getToValue() != null
                && div.getTxtNijiHanteibi().getToValue().isBefore(div.getTxtNijiHanteibi().getFromValue())) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShienMessages.二次判定日大小関係チェック));
        }
        return validationMessages;
    }

    private static enum NinteiShienMessages implements IValidationMessage {

        二次判定日大小関係チェック(UrErrorMessages.終了日が開始日以前);
        private final Message message;

        private NinteiShienMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
