/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820012;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.ShikyuShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012.pnlShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面入力のチェックHandler。
 */
public class ShikyuShinseiDetailValidationHandler {

    private final ShikyuShinseiDetailDiv div;
    private static final RString MODEL_ADD = new RString("新規");
    private static final RString SHIBARAIKINGAKUGOKEI = new RString("支払金額合計");
    private static final RString GEKEKESANKEKKA = new RString("合計計算結果");
    private static final RString SHOUKANSIKYUUSINSEI = new RString("償還払支給申請");

    /**
     * コンストラクタです。
     *
     * @param div 償還払支給申請の支給申請Div
     */
    public ShikyuShinseiDetailValidationHandler(ShikyuShinseiDetailDiv div) {
        this.div = div;
    }

    /**
     * 申請既存チェック
     *
     * @return バリデーション結果 ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor申請既存チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 処理モード = div.getPanelHead().getTxtShoriMode().getValue();
        if (MODEL_ADD.equals(処理モード)) {
            if (is入力()) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない, SHOUKANSIKYUUSINSEI.toString())));
            }
        } else {
            ShokanShinsei 償還払支給申請 = ViewStateHolder.get(ViewStateKeys.償還払支給申請詳細データ, ShokanShinsei.class);
            if (償還払支給申請 == null) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない, SHOUKANSIKYUUSINSEI.toString())));
            }
        }
        return validPairs;
    }

    private boolean is入力() {
        pnlShinseiDiv pnlDiv = div.getPnlShinsei();
        if (pnlDiv.getTxtShinseiYMD() == null) {
            return true;
        }
        if (pnlDiv.getTxtUketsukeYMD() == null) {
            return true;
        }
        if (pnlDiv.getTxtKisaiHokensyaBango() == null) {
            return true;
        }
        if (pnlDiv.getTxtShimeikana() == null) {
            return true;
        }
        if (pnlDiv.getTxtShimeiKanji() == null) {
            return true;
        }
        if (pnlDiv.getTxtTelNo() == null) {
            return true;
        }
        if (pnlDiv.getTxtMulShinseiRiyu() == null) {
            return true;
        }
        if (pnlDiv.getTxtNumShiharaKingakuGk() == null) {
            return true;
        }
        return false;
    }

    /**
     * 支払金額合計未入力 保険請求金額、自己負担額合計にデータがある場合、支払金額合計がデータが空白の場合、エラー
     *
     * @return バリデーション結果 ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor支払金額合計未入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        Decimal 保険請求金額 = div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().getValue();
        Decimal 自己負担額合計 = div.getPnlShinsei().getTxtNumHokenKyufuGaku().getValue();
        Decimal 支払金額合計 = div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue();
        if (null == 保険請求金額 || null == 自己負担額合計) {
            return validPairs;
        }
        if (null == 支払金額合計) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, SHIBARAIKINGAKUGOKEI.toString())));
        }
        return validPairs;
    }

    /**
     * 支払金額合計整合性チェック 支払金額合計≠保険請求額合計＋自分負担額合計の場合、警告メッセージを表示します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor支払金額合計整合性チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        Decimal 保険請求金額 = div.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku().getValue();
        Decimal 自己負担額合計 = div.getPnlShinsei().getTxtNumHokenKyufuGaku().getValue();
        Decimal 支払金額合計 = div.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue();
        保険請求金額 = null == 保険請求金額 ? Decimal.ZERO : 保険請求金額;
        自己負担額合計 = null == 自己負担額合計 ? Decimal.ZERO : 自己負担額合計;
        支払金額合計 = null == 支払金額合計 ? Decimal.ZERO : 支払金額合計;
        if (!支払金額合計.equals(保険請求金額.add(自己負担額合計))) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrWarningMessages.相違, SHIBARAIKINGAKUGOKEI.toString(), GEKEKESANKEKKA.toString())));
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
