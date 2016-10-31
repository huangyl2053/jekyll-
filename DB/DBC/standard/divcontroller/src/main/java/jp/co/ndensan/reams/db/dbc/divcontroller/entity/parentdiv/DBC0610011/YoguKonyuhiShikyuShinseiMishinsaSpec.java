/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧画面YoguKonyuhiShikyuShinseiMishinsaSpec
 *
 * @reamsid_L DBC-1020-040 gongliang
 */
public enum YoguKonyuhiShikyuShinseiMishinsaSpec implements IPredicate<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> {

    データ選択のチェック {
        @Override
        public boolean apply(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
            return !div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems().isEmpty();
        }

    },
    決定日のチェック {
        @Override
        public boolean apply(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
            return div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().getValue() != null;
        }
    }
}
