/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.NinteiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * 要介護認定通知書発行画面のチェックロジックです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public enum NinteiTsuchishoHakkoSpec implements IPredicate<NinteiTsuchishoHakkoDiv> {

    /**
     * 個別印刷0件チェック。
     */
    個別印刷0件チェック {
                @Override
                public boolean apply(NinteiTsuchishoHakkoDiv div) {
                    return div.getDgTaishoshaIchiran().getDataSource().size() > 0;
                }
            },
    /**
     * 個別印刷選択0件チェック。
     */
    個別印刷選択0件チェック {
                @Override
                public boolean apply(NinteiTsuchishoHakkoDiv div) {
                    return div.getDgTaishoshaIchiran().getSelectedItems().size() > 0;
                }
            },
    /**
     * 個別印刷選択複数件チェック。
     */
    個別印刷選択複数件チェック {
                @Override
                public boolean apply(NinteiTsuchishoHakkoDiv div) {
                    return div.getDgTaishoshaIchiran().getSelectedItems().size() == 1;
                }
            };
}
