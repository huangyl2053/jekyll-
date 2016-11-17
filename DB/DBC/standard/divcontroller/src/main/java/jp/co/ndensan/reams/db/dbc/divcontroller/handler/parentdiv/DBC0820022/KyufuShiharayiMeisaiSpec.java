/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820022;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820022.KyufuShiharayiMeisaiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い費支給申請決定_サービス提供証明書(給付費明細）の入力チェックSpecです。
 *
 * @reamsid_L DBC-1030-040 liaoyang
 */
public enum KyufuShiharayiMeisaiSpec implements IPredicate<KyufuShiharayiMeisaiPanelDiv> {
    /**
     * サービス種類コードチェック
     */
    サービス種類コードチェック {
        @Override
        public boolean apply(KyufuShiharayiMeisaiPanelDiv div) {
            return SpecHelper.is入所年月日(div);
        }
    };

    private static class SpecHelper {

        public static boolean is入所年月日(KyufuShiharayiMeisaiPanelDiv div) {
            RString サービス種類コード = div.getPanelThree().getPanelFour().getCcdServiceCodeInput().getサービスコード1();
            return !(new RString("50").equals(サービス種類コード));
        }
    }
}
