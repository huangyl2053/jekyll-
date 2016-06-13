/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.KihonInfoMainPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給申請_サービス提供証明書_基本情報の入力チェックSpecです。
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
public enum KihonInfoMainPanelSpec implements IPredicate<KihonInfoMainPanelDiv> {

    /**
     * 入所年月日
     */
    入所年月日 {
                @Override
                public boolean apply(KihonInfoMainPanelDiv div) {
                    return SpecHelper.is入所年月日(div);
                }
            },
    /**
     * 明細番号
     */
    明細番号 {
                @Override
                public boolean apply(KihonInfoMainPanelDiv div) {
                    return SpecHelper.is明細番号(div);
                }
            };

    private static class SpecHelper {

        public static boolean is入所年月日(KihonInfoMainPanelDiv div) {
            RDate 入所年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue();
            return 入所年月日 != null;
        }

        public static boolean is明細番号(KihonInfoMainPanelDiv div) {
            RString 明細番号 = div.getPanelTwo().getTxtMeisaiBango().getValue();
            return 明細番号 != null && !明細番号.isEmpty();
        }
    }
}
