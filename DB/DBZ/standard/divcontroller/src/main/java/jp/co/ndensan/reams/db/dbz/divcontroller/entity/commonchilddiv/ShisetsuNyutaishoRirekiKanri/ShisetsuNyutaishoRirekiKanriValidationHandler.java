/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 施設入退所履歴のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanriValidationHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 施設入退所履歴DivKyokaisoGaitoshaPanelHandler
     */
    public ShisetsuNyutaishoRirekiKanriValidationHandler(ShisetsuNyutaishoRirekiKanriDiv div) {
        this.div = div;
    }

    /**
     * 「確認する」ボタンを押下します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue() == null
                || div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.入所日, div.getShisetsuNyutaishoInput().getTxtNyushoDate()));
        } else {
            if (div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue() != null
                    && !div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue().isEmpty()
                    && !div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue().
                    isBeforeOrEquals(div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue())) {
                validPairs.add(new ValidationMessageControlPair(
                        RRVMessages.前後関係逆転,
                        div.getShisetsuNyutaishoInput().getTxtTaishoDate(),
                        div.getShisetsuNyutaishoInput().getTxtNyushoDate()));
            }
        }
        if (RString.isNullOrEmpty(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.入所施設コード));
        }
        if (RString.isNullOrEmpty(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設種類));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        入所日(UrErrorMessages.必須, "入所日"),
        入所施設コード(UrErrorMessages.必須, "入所施設コード"),
        施設種類(UrErrorMessages.必須, "施設種類"),
        前後関係逆転(UrErrorMessages.前後関係逆転, "入所日", "退所日");
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
