/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 画面入力のチェック。
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public enum KokuhuShikakuInfoPanelSpec implements IPredicate<KokuhoShikakuInfoPanelDiv> {

    資格期間大小関係チェック {
                /**
                 * 資格期間大小関係チェックです。
                 *
                 * @param div MainPanelDiv
                 * @return boolean
                 */
                @Override
                public boolean apply(jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.KokuhoShikakuInfoPanelDiv div) {
                    if (div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().getValue() != null && div.getMeisaiPanel().
                    getTxtShikakuShutokuYMD().getValue() != null) {
                        return div.getMeisaiPanel().getTxtShikakuShutokuYMD().getValue().isBeforeOrEquals(div.getMeisaiPanel().
                                getTxtShikakuSoshitsuYMD().getValue());
                    }
                    return true;
                }
            }
}
