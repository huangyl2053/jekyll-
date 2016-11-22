/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021;

import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.KihonInfoMainPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
     * 入所院実日数
     */
    入所院実日数 {
        @Override
        public boolean apply(KihonInfoMainPanelDiv div) {
            return SpecHelper.is入所院実日数(div);
        }
    },
    /**
     * 入所院前の状況
     */
    入所院前の状況 {
        @Override
        public boolean apply(KihonInfoMainPanelDiv div) {
            return SpecHelper.is入所院前の状況(div);
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
    },
    /**
     * 入所と退所間の日数チェック
     */
    入所と退所間の日数チェック {
        @Override
        public boolean apply(KihonInfoMainPanelDiv div) {
            if (null != div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue()
                    && null != div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue()) {
                int 日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue()
                        .getBetweenDays(div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue());
                return !(日数 > 日数_30);
            }
            return true;
        }
    },
    /**
     * 入所日と退所日の期間日数チェック
     */
    入所日と退所日の期間日数チェック {
        @Override
        public boolean apply(KihonInfoMainPanelDiv div) {
            if (null != div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue()
                    && null != div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue()
                    && null != div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().getValue()
                    && null != div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().getValue()) {
                int 日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().getValue()
                        .getBetweenDays(div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue());
                int 期間日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().getValue().intValue()
                        + div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().getValue().intValue();
                return !(日数 < 期間日数);
            }
            return true;
        }
    };

    private static final int 日数_30 = 30;

    private static class SpecHelper {

        public static boolean is入所年月日(KihonInfoMainPanelDiv div) {
            RDate 入所年月日 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().getValue();
            return 入所年月日 != null;
        }

        public static boolean is入所院実日数(KihonInfoMainPanelDiv div) {
            Decimal 入所院実日数 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().getValue();
            return 入所院実日数 != null;
        }

        public static boolean is入所院前の状況(KihonInfoMainPanelDiv div) {
            RString 入所院前の状況 = div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().getSelectedKey();
            return 入所院前の状況 != null && !入所院前の状況.isEmpty();
        }

        public static boolean is明細番号(KihonInfoMainPanelDiv div) {
            ShoukanharaihishinseimeisaikensakuParameter parameter
                    = ViewStateHolder.get(ViewStateKeys.明細検索キー, ShoukanharaihishinseimeisaikensakuParameter.class);
            return !RString.isNullOrEmpty(parameter.get明細番号());
        }
    }
}
