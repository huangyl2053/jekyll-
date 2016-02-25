package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 事業者・施設選択入力ガイドのチェッククラスです。
 */
public class ValidationHandler {

    public static ValidationMessageControlPairs 終了日が開始日以前のチェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.終了日が開始日以前));
        return validationMessages;
    }
     private static enum RRVMessages implements IValidationMessage {

        終了日が開始日以前(UrErrorMessages.終了日が開始日以前);
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
