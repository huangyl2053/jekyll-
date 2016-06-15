/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * {@link PnlTotalPanelDiv}の仕様クラスです。 <br> {@link PnlTotalPanelDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
public enum PnlTotalPanelSpec implements IPredicate<PnlTotalPanelDiv> {

    /**
     * 金額不整合チェック
     */
    金額 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is金額不整合(div);
                }
            };

    private static class SpecHelper {

        public static boolean is金額不整合(PnlTotalPanelDiv div) {
            if (div.getPnlCommon().getPnlDetail()
                    .getPnlKyufuhi().getTxtRiyosyajikofutangaku().getValue() != null) {
                return RStringUtil.isAlphabetAndHalfsizeNumberOnly(new RString(div.getPnlCommon().getPnlDetail()
                        .getPnlKyufuhi().getTxtRiyosyajikofutangaku().getValue().toString()));
            }
            if (div.getPnlCommon().getPnlDetail()
                    .getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue() != null) {
                return RStringUtil.isAlphabetAndHalfsizeNumberOnly(new RString(div.getPnlCommon().getPnlDetail()
                        .getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue().toString()));
            }
            return true;
        }

    }
}
