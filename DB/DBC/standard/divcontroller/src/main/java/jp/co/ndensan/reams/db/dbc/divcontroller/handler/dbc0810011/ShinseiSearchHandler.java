/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.ShinseiSearchDiv;

/**
 * 償還払い状況照会_申請情報検索のHandlerクラス
 *
 * @reamsid_L DBC-1010-130 panhe
 */
public final class ShinseiSearchHandler {

    private final ShinseiSearchDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinseiSearchDiv
     */
    private ShinseiSearchHandler(ShinseiSearchDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッド
     *
     * @param div ShinseiSearchDiv
     * @return ShinseiSearchHandler
     */
    public static ShinseiSearchHandler of(ShinseiSearchDiv div) {
        return new ShinseiSearchHandler(div);
    }

    /**
     * 引継ぎデータの設定
     */
    public void set引継ぎデータ() {
        div.getPanelShokan().getJpControlName();
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
