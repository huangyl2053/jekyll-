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
                    SearchKogakuHihokenshaDiv panel = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha();
                    if (panel.getTxtHihoNo().getValue() != null && !panel.getTxtHihoNo().getValue().isEmpty()) {
                        return true;
                    }
                    if (panel.getTxtTeikyoYMRange().getFromValue() != null || panel.getTxtTeikyoYMRange().getToValue() != null) {
                        return true;
                    }
                    if (panel.getTxtShinseiYMRange().getFromValue() != null || panel.getTxtShinseiYMRange().getToValue() != null) {
                        return true;
                    }
                    return panel.getTxtKetteiYMRange().getFromValue() != null || panel.getTxtKetteiYMRange().getToValue() != null;
                }
            },
    /**
     * 「被保険者を指定して検索する」を選択する場合 提供年月From、提供年月Toの比較です。
     */
    提供年月チェック {
                @Override
                public boolean apply(KogakuServicehiPanelDiv div) {
                    RDate 提供年月From = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange().getFromValue();
                    RDate 提供年月To = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtTeikyoYMRange().getToValue();
                    if (提供年月From != null && 提供年月To != null) {
                        return 提供年月From.isBeforeOrEquals(提供年月To);
                    }
                    return true;
                }
            },
    /**
     * 「被保険者を指定して検索する」を選択する場合 提供年月From、申請年月Toの比較です。
     */
    申請年月チェック {
                @Override
                public boolean apply(KogakuServicehiPanelDiv div) {
                    RDate 申請年月From = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange().getFromValue();
                    RDate 申請年月To = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtShinseiYMRange().getToValue();
                    if (申請年月From != null && 申請年月To != null) {
                        return 申請年月From.isBeforeOrEquals(申請年月To);
                    }
                    return true;
                }
            },
    /**
     * 「被保険者を指定して検索する」を選択する場合 提供年月From、決定年月From、決定年月Toの比較です。
     */
    決定年月チェック {
                @Override
                public boolean apply(KogakuServicehiPanelDiv div) {
                    RDate 決定年月From = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange().getFromValue();
                    RDate 決定年月To = div.getSearchKogakuServicehiPanel().getSearchKogakuHihokensha().getTxtKetteiYMRange().getToValue();
                    if (決定年月From != null && 決定年月To != null) {
                        return 決定年月From.isBeforeOrEquals(決定年月To);
                    }
                    return true;
                }
            },
    /**
     * 実行するボタンクリック5 住宅改修支給届出日From、住宅改修支給届出日Toの大小関係チェックです。
     */
    年月を指定入力チェック {
                @Override
                public boolean apply(KogakuServicehiPanelDiv div) {
                    SearchYMDiv panel = div.getSearchKogakuServicehiPanel().getSearchYM();
                    return !(panel.getTxtTeikyoYM().getValue() == null && panel.getTxtShinseiYM() == null && panel.getTxtKetteiYM() == null);
                }
            };
}
