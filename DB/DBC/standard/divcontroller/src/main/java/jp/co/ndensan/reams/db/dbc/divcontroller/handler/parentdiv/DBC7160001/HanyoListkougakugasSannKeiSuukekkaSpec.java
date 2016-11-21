/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)Specです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public enum HanyoListkougakugasSannKeiSuukekkaSpec implements IPredicate<HanyoListkougakugasSannKeiSuukekkaDiv> {

    /**
     * 出力順未指定チェックのcheckです。
     */
    出力順未指定チェック {
        @Override
        public boolean apply(HanyoListkougakugasSannKeiSuukekkaDiv div) {
            return div.getCcdShutsuryokujun().get出力順ID() != null;
        }
    }
}
