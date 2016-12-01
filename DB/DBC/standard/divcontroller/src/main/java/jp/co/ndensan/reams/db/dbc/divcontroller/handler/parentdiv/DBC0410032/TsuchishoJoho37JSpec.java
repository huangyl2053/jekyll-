/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0410032;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410032.TsuchishoJoho37JDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 国保連情報受取データ取込_[37J]高額合算自己負担額確認情報のSpecです。
 *
 * @reamsid_L DBC-0980-090 tangkai
 */
public enum TsuchishoJoho37JSpec implements IPredicate<TsuchishoJoho37JDiv> {

    /**
     * 出力順入力チェック
     */
    出力順入力チェック {
        @Override
        public boolean apply(TsuchishoJoho37JDiv div) {
            return div.getCcdKokurenJohoTorikomi().is出力順Selected();
        }
    };

}
