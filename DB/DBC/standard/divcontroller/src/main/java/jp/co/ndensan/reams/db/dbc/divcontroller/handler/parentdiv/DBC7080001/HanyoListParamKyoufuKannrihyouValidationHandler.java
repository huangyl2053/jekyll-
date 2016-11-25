/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7080001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001.HanyoListParamKyoufuKannrihyouDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 liwul
 */
public class HanyoListParamKyoufuKannrihyouValidationHandler {

    private final HanyoListParamKyoufuKannrihyouDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamKyoufuKannrihyouDiv
     */
    public HanyoListParamKyoufuKannrihyouValidationHandler(HanyoListParamKyoufuKannrihyouDiv div) {
        this.div = div;
    }

    /**
     * 条件保存チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 条件保存チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getFromValue() != null
                && div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getToValue() != null) {
            if (div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getToValue().isBefore(
                    div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getFromValue())) {
                validPairs.add(new ValidationMessageControlPair(
                        new HanyoListParamKyoufuKannrihyouValidationHandler.IdocheckMessages(
                                UrErrorMessages.期間が不正_追加メッセージあり２.getMessage(),
                                div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getFromValue()
                                .getYearMonth().wareki().toDateString().toString(),
                                div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getToValue()
                                .getYearMonth().wareki().toDateString().toString())));
            }
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(Message message) {
            this.message = message;
        }

        public IdocheckMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
