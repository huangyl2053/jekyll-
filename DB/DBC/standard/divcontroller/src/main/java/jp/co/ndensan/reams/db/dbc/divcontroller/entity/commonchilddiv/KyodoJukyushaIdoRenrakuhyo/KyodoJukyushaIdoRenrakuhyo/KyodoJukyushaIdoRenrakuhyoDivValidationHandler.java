/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共同処理用受給者異動連絡票共有子Divのバリデーション
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoDivValidationHandler {

    private final KyodoJukyushaIdoRenrakuhyoDiv div;
    private static final RString MSG_一時差止開始日 = new RString("一時差止開始日");

    /**
     * コンストラクタです。
     *
     * @param div KyodoJukyushaIdoRenrakuhyoDiv
     */
    public KyodoJukyushaIdoRenrakuhyoDivValidationHandler(KyodoJukyushaIdoRenrakuhyoDiv div) {
        this.div = div;
    }

    /**
     * 一時差止開始日＞一時差止終了日、エラーとする
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一時差止日の入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getFromValue() == null
                && div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getToValue() != null) {
            validPairs.add(new ValidationMessageControlPair(ValidationMessages.一時差止日のチェック));
        }
        return validPairs;
    }

    /**
     * 「一時差止開始日」が未入力で「一時差止終了日」が入力済み、エラーとする
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一時差止日の関連チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RDate 一時差止開始日 = div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getFromValue();
        RDate 一時差止終了日 = div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getToValue();
        if (一時差止終了日 != null && 一時差止終了日.isBefore(一時差止開始日)) {
            validPairs.add(new ValidationMessageControlPair(ValidationMessages.一時差止日の関連チェック));
        }
        return validPairs;
    }

    private static enum ValidationMessages implements IValidationMessage {

        一時差止日の関連チェック(UrErrorMessages.終了日が開始日以前),
        一時差止日のチェック(UrErrorMessages.未入力, MSG_一時差止開始日.toString());

        private final Message message;

        ValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
