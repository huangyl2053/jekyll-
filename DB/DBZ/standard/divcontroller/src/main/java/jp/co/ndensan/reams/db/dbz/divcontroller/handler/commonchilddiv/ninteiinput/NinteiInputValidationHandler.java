/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * DBZ.NinteiInput_認定情報のValidationHandlerです。
 *
 * @reamsid_L DBE-1300-080 yaodongsheng
 */
public class NinteiInputValidationHandler {

    private final NinteiInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiInputDiv
     */
    public NinteiInputValidationHandler(NinteiInputDiv div) {
        this.div = div;
    }

    /**
     * 有効開始日checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 有効開始日check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getTxtNinteiYMD().getValue() == null) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation有効開始日, div.getTxtNinteiYMD()));
        }
        return validationMessage;
    }

    /**
     * 開始終了日の前後順checkを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs 開始終了日の前後順check() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getTxtYukoShuryoYMD().getValue().isBefore(div.getTxtYukoKaishiYMD().getValue())) {
            validationMessage.add(new ValidationMessageControlPair(NinteiInputCheckMessages.validation開始日と終了日の前後順,
                    div.getTxtYukoKaishiYMD(), div.getTxtYukoShuryoYMD()));
        }
        return validationMessage;
    }

    private static enum NinteiInputCheckMessages implements IValidationMessage {

        validation有効開始日(UrErrorMessages.対象データなし_追加メッセージあり, "有効開始日"),
        validation開始日と終了日の前後順(UrWarningMessages.日付の前後関係逆転以降, "開始日", "終了日");
        private final Message message;

        private NinteiInputCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
