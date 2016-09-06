/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0320011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0320011.JuryoIninKeiyakuShoninKakuninshoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険受領委任契約承認（不承認）確認書です。
 *
 * @reamsid_L DBC-1910-010 lihang
 */
public class JuryoIninKeiyakuShoninKakuninshoValidationHandler {

    private final JuryoIninKeiyakuShoninKakuninshoDiv div;
    private static final RString 契約申請年月日の範囲 = new RString("契約申請年月日の範囲");
    private static final RString 契約決定年月日の範囲 = new RString("契約決定年月日の範囲");

    /**
     * コンストラクタです。
     *
     *
     * @param div JuryoIninKeiyakuShoninKakuninshoDiv
     */
    public JuryoIninKeiyakuShoninKakuninshoValidationHandler(JuryoIninKeiyakuShoninKakuninshoDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RDate 契約申請日終了 = div.getJuryoininChushutsuJoken().getTxtKeiyakuShinseiYMD().getToValue();
        RDate 契約申請日開始 = div.getJuryoininChushutsuJoken().getTxtKeiyakuShinseiYMD().getFromValue();
        if (契約申請日終了 != null && 契約申請日開始 != null && 契約申請日終了.isBefore(契約申請日開始)) {
            validPairs.add(new ValidationMessageControlPair(
                    new JuryoIninKeiyakuShoninKakuninshoValidationHandler.IdocheckMessages(
                            UrErrorMessages.不正, 契約申請年月日の範囲.toString())));
        }
        RDate 契約決定日終了 = div.getJuryoininChushutsuJoken().getTxtKeiyakuKetteiYMD().getToValue();
        RDate 契約決定日開始 = div.getJuryoininChushutsuJoken().getTxtKeiyakuKetteiYMD().getFromValue();
        if (契約決定日終了 != null && 契約決定日開始 != null && 契約決定日終了.isBefore(契約決定日開始)) {
            validPairs.add(new ValidationMessageControlPair(
                    new JuryoIninKeiyakuShoninKakuninshoValidationHandler.IdocheckMessages(
                            UrErrorMessages.不正, 契約決定年月日の範囲.toString())));
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
