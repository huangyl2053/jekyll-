/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PaymentMethod.PaymentMethodDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払い方法選択ラジオボタンによる処理です。
 *
 * @author N3317 塚田 萌
 */
public class PaymentMethod {

    private PaymentMethod() {
    }

    /**
     * 支払い方法選択ラジオボタン変更に伴う表示を切り替えます。
     *
     * @param panel PaymentMethodDiv
     */
    public static void showSelectedPaymentMethod(PaymentMethodDiv panel) {

        if (isPayToKoza(panel.getRadPayMethod().getSelectedValue())) {
            panel.getJuryoininJoho().setDisplayNone(true);
            panel.getMadoguchiPayment().setDisplayNone(true);
            panel.getKozaPayment().setDisplayNone(false);
            panel.getKozaPayment().setTitle(new RString(""));
        } else if (isPayToJuryoinin(panel.getRadPayMethod().getSelectedValue())) {
            panel.getJuryoininJoho().setDisplayNone(false);
            panel.getMadoguchiPayment().setDisplayNone(true);
            panel.getKozaPayment().setDisplayNone(false);
            panel.getKozaPayment().setTitle(new RString("口座情報"));
        } else {
            panel.getJuryoininJoho().setDisplayNone(true);
            panel.getKozaPayment().setDisplayNone(true);
            panel.getMadoguchiPayment().setDisplayNone(false);
            panel.getMadoguchiPayment().setReadOnly(true);
        }
    }

    private static boolean isPayToJuryoinin(RString value) {
        return value.equals(new RString("受領委任払い"));
    }

    private static boolean isPayToKoza(RString value) {
        return value.equals(new RString("口座払い"));
    }
}
