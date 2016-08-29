/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0350011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0350011.JuryoIninKeiyakuJigyoshaIchiranhyoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 受領委任契約事業者一覧表です。
 *
 * @reamsid_L DBC-2110-010 lihang
 */
public class JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler {

    private final JuryoIninKeiyakuJigyoshaIchiranhyoDiv div;
    private static final RString 契約事業者番号の範囲 = new RString("契約事業者番号の範囲");
    private static final RString 契約開始日の範囲 = new RString("契約開始日の範囲");

    /**
     * コンストラクタです。
     *
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     */
    public JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler(JuryoIninKeiyakuJigyoshaIchiranhyoDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 契約事業者番号FROM = div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuBangoFrom().getValue();
        RString 契約事業者番号TO = div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuBangoTo().getValue();
        if ((!契約事業者番号FROM.isNullOrEmpty())
                && (!契約事業者番号TO.isNullOrEmpty())
                && 0 < (契約事業者番号FROM.compareTo(契約事業者番号TO))) {
            validPairs.add(new ValidationMessageControlPair(
                    new JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler.IdocheckMessages(
                            UrErrorMessages.不正, 契約事業者番号の範囲.toString())));
        }
        RDate 契約開始日FROM = div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuYMD().getFromValue();
        RDate 契約開始日TO = div.getJuryoininbaraiChushutsuJoken().getTxtKeiyakuYMD().getToValue();
        if ((契約開始日FROM != null && 契約開始日TO != null)
                && 契約開始日TO.isBefore(契約開始日FROM)) {
            validPairs.add(new ValidationMessageControlPair(
                    new JuryoIninKeiyakuJigyoshaIchiranhyoValidationHandler.IdocheckMessages(
                            UrErrorMessages.不正, 契約開始日の範囲.toString())));
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
