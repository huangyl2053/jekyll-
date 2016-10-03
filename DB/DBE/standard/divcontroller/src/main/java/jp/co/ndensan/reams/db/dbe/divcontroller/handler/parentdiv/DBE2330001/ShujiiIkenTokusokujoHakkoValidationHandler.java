/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2330001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001.ShujiiIkenshoTokusokujoHakkoDiv;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書督促状発行画面のValidationHandlerクラス
 *
 * @author n3213
 */
public class ShujiiIkenTokusokujoHakkoValidationHandler {

    private final ShujiiIkenshoTokusokujoHakkoDiv div;
    private static final RString OVER_CHOSAIRAI_DAY = new RString("作成期限からの日数には10年以内を設定してください。");

    /**
     * コンストラクタ
     *
     * @param div 画面情報
     */
    public ShujiiIkenTokusokujoHakkoValidationHandler(ShujiiIkenshoTokusokujoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 「督促状発行を実行する」ボタン押下時の、パラメーターチェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check_btnBatchRegisterHakko() {
        ValidationMessageControlPairs message = new ValidationMessageControlPairs();

        check_TxtOverChosaIraiDay(message);

        return message;
    }

    private void check_TxtOverChosaIraiDay(ValidationMessageControlPairs validationMessages) {
        if (div.getShujiiIkenshoTokusokujo().getTxtOverChosaIraiDay().getValue().intValue() < 0
            || div.getShujiiIkenshoTokusokujo().getTxtOverChosaIraiDay().getValue().intValue() > 3653) {
            validationMessages.add(new ValidationMessageControlPair(ShujiiIkenTokusokujoHakkoValidationMessage.ValidateTxtOverChosaIraiDay,
                    div.getShujiiIkenshoTokusokujo().getTxtOverChosaIraiDay()));
        }
    }

    private static enum ShujiiIkenTokusokujoHakkoValidationMessage implements IValidationMessage {

        ValidateTxtOverChosaIraiDay(ShujiiIkenTokusokujoHakkoMessageGettable.ErrorTxtOverChosaIraiDay);

        private final Message message;

        private ShujiiIkenTokusokujoHakkoValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

    private static enum ShujiiIkenTokusokujoHakkoMessageGettable implements IMessageGettable {

        ErrorTxtOverChosaIraiDay(0, OVER_CHOSAIRAI_DAY.toString());

        private final int no;
        private final RString message;

        private ShujiiIkenTokusokujoHakkoMessageGettable(int no, String message) {
            this.no = no;
            this.message = new RString(message);
        }

        @Override
        public Message getMessage() {
            return new ErrorMessage(toCode("E", no), this.message.toString());
        }

    }
}
