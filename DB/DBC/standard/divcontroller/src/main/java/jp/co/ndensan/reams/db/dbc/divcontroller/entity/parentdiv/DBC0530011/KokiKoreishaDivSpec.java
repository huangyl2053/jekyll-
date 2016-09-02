/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public enum KokiKoreishaDivSpec implements IPredicate<KokiKoreishaDiv> {
    資格期間大小関係チェック {
        /**
         * 資格期間大小関係チェックです。
         *
         * @param div MainPanelDiv
         * @return boolean
         */
        @Override
        public boolean apply(KokiKoreishaDiv div) {
            if (div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().getValue() != null && div.getMeisaiPanel().
                    getTxtShikakuShutokuYMD().getValue() != null) {
                return div.getMeisaiPanel().getTxtShikakuShutokuYMD().getValue().isBeforeOrEquals(div.getMeisaiPanel().
                        getTxtShikakuSoshitsuYMD().getValue());
            }
            return true;
        }
    },
    保険者適用期間大小関係チェック {
        /**
         * 保険者適用期間大小関係チェック。
         *
         * @param div MainPanelDiv
         * @return boolean
         */
        @Override
        public boolean apply(KokiKoreishaDiv div) {
            if (div.getMeisaiPanel().getTxtHokenshaKaishiYMD().getValue() != null && div.getMeisaiPanel().
                    getTxtHokenshaShuryoYMD().getValue() != null) {
                return div.getMeisaiPanel().getTxtHokenshaKaishiYMD().getValue().isBeforeOrEquals(div.getMeisaiPanel().
                        getTxtHokenshaShuryoYMD().getValue());
            }
            return true;
        }
    }
}
