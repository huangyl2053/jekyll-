/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820029;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029.ShokujiHiyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(食事費用）の画面クラスです。
 *
 * @reamsid_L DBC-1030-090 lijunjun
 */
public class ShokujiHiyoPanelValidationHandler {

    private final ShokujiHiyoPanelDiv div;
    private static final RString 基本日数 = new RString("基本日数");
    private static final RString 基本単価 = new RString("基本単価");
    private static final RString 特別食日数 = new RString("特別食日数");
    private static final RString 特別食単価 = new RString("特別食単価");
    private static final RString 単位 = new RString("単位");
    private static final RString 回数日数 = new RString("回数／日数");

    /**
     * コンストラクタです。
     *
     * @param div ShokujiHiyoPanelDiv
     */
    ShokujiHiyoPanelValidationHandler(ShokujiHiyoPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックのメソッド
     *
     * @param meisaiPar ShoukanharaihishinseimeisaikensakuParameter
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック(ShoukanharaihishinseimeisaikensakuParameter meisaiPar) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        必須入力チェック(validPairs);
        return validPairs;
    }

    private ValidationMessageControlPairs 必須入力チェック(ValidationMessageControlPairs validPairs) {
        Decimal 入力基本日数 = div.getPanelShokuji().getPanelDetail1().getTxtKihonNissu().getValue();
        Decimal 入力基本単価 = div.getPanelShokuji().getPanelDetail1().getTxtKihonTanka().getValue();
        Decimal 入力特別食日数 = div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuNissu().getValue();
        Decimal 入力特別食単価 = div.getPanelShokuji().getPanelDetail1().getTxtTokubetuSyokuTanka().getValue();
        Decimal 入力単位 = div.getPanelShokuji().getPanelDetail2().getTxtTanyi().getValue();
        Decimal 入力回数日数 = div.getPanelShokuji().getPanelDetail2().getTxtKaisuuNisuu().getValue();
        if (入力基本日数 == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 基本日数.toString())));
        }
        if (入力基本単価 == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 基本単価.toString())));
        }
        if (入力特別食日数 == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 特別食日数.toString())));
        }
        if (入力特別食単価 == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 特別食単価.toString())));
        }
        if (入力単位 == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 単位.toString())));
        }
        if (入力回数日数 == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.未入力, 回数日数.toString())));
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
