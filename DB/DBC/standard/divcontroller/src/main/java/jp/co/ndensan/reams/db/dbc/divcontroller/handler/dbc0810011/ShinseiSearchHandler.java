/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.ShinseiSearchDiv;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran.ShokanShinseiIchiranRelateEntity;

/**
 * 償還払い状況照会_申請情報検索のHandlerクラス
 */
public class ShinseiSearchHandler {

    private final ShinseiSearchDiv div;

    private ShinseiSearchHandler(ShinseiSearchDiv div) {
        this.div = div;
    }

    public static ShinseiSearchHandler of(ShinseiSearchDiv div) {
        return new ShinseiSearchHandler(div);
    }

//    public ShokanShinseiIchiranRelateEntity set引継ぎデータ(ShinseiSearchDiv div) {
//        ShokanShinseiIchiranRelateEntity 遷移先渡す項目Entity = null;
//        ShokanShinseiIchiranRelateEntity 遷移先渡す項目Entity = new ShokanShinseiIchiranRelateEntity(
//                HihokenshaNo.EMPTY,
//                new FlexibleYearMonth(div.getDgShokanBaraisyokai().getClickedItem().getData1().toString()),
//                new RString(div.getDgShokanBaraisyokai().getClickedItem().getData3().toString()),
//                new FlexibleDate(div.getDgShokanBaraisyokai().getClickedItem().getData2().toString()),
//                new FlexibleYearMonth(div.getDgShokanBaraisyokai().getClickedItem().getData4().toString()),
//                new RString(""),
//                new FlexibleDate(div.getDgShokanBaraisyokai().getClickedItem().getData5().toString()),
//                new FlexibleYearMonth(""),
//                new FlexibleYearMonth("")
//        );
//        return 遷移先渡す項目Entity;
//    }
}
