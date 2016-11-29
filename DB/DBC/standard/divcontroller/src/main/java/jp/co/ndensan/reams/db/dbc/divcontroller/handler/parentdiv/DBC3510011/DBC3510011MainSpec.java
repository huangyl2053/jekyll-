/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.DBC3510011MainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 保険者情報送付のバリデーションです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public enum DBC3510011MainSpec implements IPredicate<DBC3510011MainDiv> {

    /**
     * ダウンロード対象選択チェックのcheckです。
     */
    ダウンロード対象選択チェック {
        @Override
        public boolean apply(DBC3510011MainDiv div) {
            return div.getDgSofuDataIchiran().getClickedItem() != null;
        }
    }
}
