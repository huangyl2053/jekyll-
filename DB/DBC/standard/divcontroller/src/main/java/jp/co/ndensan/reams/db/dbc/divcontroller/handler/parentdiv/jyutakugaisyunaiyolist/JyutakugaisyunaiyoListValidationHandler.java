/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 住宅改修内容一覧のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-0940-010 yaodongsheng
 */
public class JyutakugaisyunaiyoListValidationHandler {

    private static final RString JIGYOSYA = new RString("事業者");
    private final JyutakugaisyunaiyoListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 住宅改修内容一覧Div
     */
    public JyutakugaisyunaiyoListValidationHandler(JyutakugaisyunaiyoListDiv div) {
        this.div = div;
    }

    /**
     * 確定ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor着工日と完成日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtTyakkoyotebi().getValue() == null || div.getTxtKanseyotebi().getValue() == null) {
            return validPairs;
        }
        FlexibleDate 比較着工日 = new FlexibleDate(div.getTxtTyakkoyotebi().getValue().toDateString().toString());
        FlexibleDate 比較完成日 = new FlexibleDate(div.getTxtKanseyotebi().getValue().toDateString().toString());
        if (比較完成日.isBefore(比較着工日)) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, div.getTxtTyakkoyotebi().getValue().toDateString().toString(),
                    div.getTxtKanseyotebi().getValue().toDateString().toString()), div.getTxtTyakkoyotebi(), div.getTxtKanseyotebi()));
        }
        return validPairs;
    }

    /**
     * 確定ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor事業者() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 事業者 = div.getTxtJigyosya().getValue();
        if (事業者 == null || 事業者.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, JIGYOSYA.toString()), div.getTxtJigyosya()));
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
