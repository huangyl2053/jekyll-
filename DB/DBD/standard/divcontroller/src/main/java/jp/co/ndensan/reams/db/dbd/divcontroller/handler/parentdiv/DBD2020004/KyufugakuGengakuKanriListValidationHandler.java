/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020004;

import static jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan.基準日;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004.KyufugakuGengakuKanriListDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付額減額管理リストのバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
public class KyufugakuGengakuKanriListValidationHandler {

    /**
     * 基準日の必須入力と減額日期のチェックを行います。
     *
     * @param div KyufugakuGengakuKanriListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForバッチ実行前チェック(KyufugakuGengakuKanriListDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutuJoken().getTxtKijunDate().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 基準日.toString())));
        }

        if (is期間が不正(div.getTxtGengakuShuryoRange().getFromValue(), div.getTxtGengakuShuryoRange().getToValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.期間が不正)));
        }

        return validPairs;
    }

    private boolean is期間が不正(RDate 開始日, RDate 終了日) {
        if (開始日 == null || 終了日 == null) {
            return false;
        }
        return !開始日.isBeforeOrEquals(終了日);
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
