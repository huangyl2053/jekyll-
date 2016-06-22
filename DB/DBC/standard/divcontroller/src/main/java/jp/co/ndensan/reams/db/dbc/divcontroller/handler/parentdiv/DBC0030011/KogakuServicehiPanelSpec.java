/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.SearchKogakuHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.SearchYMDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックSpecです。
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public enum KogakuServicehiPanelSpec implements IPredicate<KogakuServicehiPanelDiv> {

    /**
     * 「被保険者を指定して検索する」を選択する場合 入力チェックです。
     */
    被保険者を指定入力チェック {
                @Override
                public boolean apply(KogakuServicehiPanelDiv div) {
                    RString 被保番号;
                    RDate 提供年月From;
                    RDate 提供年月To;
                    RDate 申請年月From;
                    RDate 申請年月To;
                    RDate 決定年月From;
                    RDate 決定年月To;
                    SearchKogakuHihokenshaDiv panel = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
                    被保番号 = panel.getTxtHihoNo().getValue();
                    提供年月From = panel.getTxtTeikyoYMRange().getFromValue();
                    提供年月To = panel.getTxtTeikyoYMRange().getToValue();
                    申請年月From = panel.getTxtShinseiYMRange().getFromValue();
                    申請年月To = panel.getTxtShinseiYMRange().getToValue();
                    決定年月From = panel.getTxtKetteiYMRange().getFromValue();
                    決定年月To = panel.getTxtKetteiYMRange().getToValue();
                    if (被保番号 != null && !被保番号.isEmpty()) {
                        return true;
                    }
                    if (提供年月From != null || 提供年月To != null) {
                        return true;
                    }
                    if (申請年月From != null || 申請年月To != null) {
                        return true;
                    }
                    return 決定年月From != null || 決定年月To != null;
                }
            },
    /**
     * 実行するボタンクリック5 住宅改修支給届出日From、住宅改修支給届出日Toの大小関係チェックです。
     */
    年月を指定入力チェック {
                @Override
                public boolean apply(KogakuServicehiPanelDiv div) {
                    RDate 提供年月;
                    RDate 申請年月;
                    RDate 決定年月;
                    SearchYMDiv panel = div.getSearchKogakuServicehiPanel().getSearchYM();
                    提供年月 = panel.getTxtTeikyoYM().getValue();
                    申請年月 = panel.getTxtShinseiYM().getValue();
                    決定年月 = panel.getTxtKetteiYM().getValue();
                    return !(提供年月 == null && 申請年月 == null && 決定年月 == null);
                }
            };
}
