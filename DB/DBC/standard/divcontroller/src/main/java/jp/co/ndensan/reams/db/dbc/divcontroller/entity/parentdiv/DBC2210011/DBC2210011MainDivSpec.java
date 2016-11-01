/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * @author liuyl
 */
public enum DBC2210011MainDivSpec implements IPredicate<DBC2210011MainDiv> {
    特別給付サービス重複チェック {
        /**
         * 資格期間大小関係チェックです。
         *
         * @param div MainPanelDiv
         * @return boolean
         */
        @Override
        public boolean apply(DBC2210011MainDiv div) {
            for (dgTokubetsuKyufuJigyoshaDetailServiceList_Row row : div.getTokubetsuKyufuJigyoshaDetail().
                    getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList().getDataSource()) {
                if (div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService().getSelectedKey().equals(row.getHdnServiceCode())) {
                    return false;
                }
            }
            return true;
        }
    },
    登録終了日チェック {
        /**
         * 保険者適用期間大小関係チェック。
         *
         * @param div MainPanelDiv
         * @return boolean
         */
        @Override
        public boolean apply(DBC2210011MainDiv div) {
            return div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getTokubetsuKyufuJigyoshaDetailJigyosha().
                    getTxtTorokuShuryoYMD().getValue() == null || div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                    getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD().getValue().
                    isAfterOrEquals(div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                            getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD().getValue());

        }
    }
}
