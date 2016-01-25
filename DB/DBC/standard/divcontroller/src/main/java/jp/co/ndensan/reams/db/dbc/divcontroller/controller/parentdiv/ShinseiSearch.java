/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.DBC0810011TransitionEventName.住宅改修費支給申請;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.DBC0810011TransitionEventName.償還払い費支給申請;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.DBC0810011TransitionEventName.福祉用具購入費支給;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.ShinseiSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810011.ShinseiSearchHandler;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran.ShokanShinseiIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author SE1007
 */
public class ShinseiSearch {

    private static final RString 様式番号21C = new RString("21C");
    private static final RString 様式番号21D = new RString("21D");

    public ResponseData<ShinseiSearchDiv> onLoad(ShinseiSearchDiv div) {
        ResponseData<ShinseiSearchDiv> responseData = new ResponseData<>();
        // 介護宛名情報（DBZ.KaigoAtenaInfo）初期化 引数:該当者検索画面ViewState．識別コード
//        div.getPanelAtenaShikaku().getCcdKaigoAtenalInfo().load(new ShikibetsuCode("000000003"));
        // 介護資格系基本情報（DBZ.KaigoShikakuKihon）初期化 引数:引き継ぎデータEntity．被保険者番号
//        div.getPanelAtenaShikaku().getCcdKaigoShikakuKihon().initialize(new HihokenshaNo("000000003"));
        // 償還払決定一覧（DBC.ShokanShinseiList）初期化 QA中

        responseData.data = div;
        return responseData;
    }

    public ResponseData<ShinseiSearchDiv> onClick_btnSelect(ShinseiSearchDiv div) {
        ShinseiSearchHandler handler = getHandler(div);
        // ViewStateに書き込み、遷移先画面に渡す
        ShokanShinseiIchiranRelateEntity 遷移先渡す項目Entity = handler.set引継ぎデータ(div);
        ViewStateHolder.put("遷移先渡す項目Entity", 遷移先渡す項目Entity);

        if (様式番号21C.equals(div.getDgShokanBaraisyokai().getClickedItem().getData3().substring(0, 3))) {
            ViewStateHolder.put("被保番号", new RString(div.getPanelAtenaShikaku().getCcdKaigoShikakuKihon().get被保険者番号().toString()));
            ViewStateHolder.put("サービス提供年月", new RString(div.getDgShokanBaraisyokai().getClickedItem().getData1().toString()));
            ViewStateHolder.put("整理番号", div.getDgShokanBaraisyokai().getClickedItem().getData3());
            return ResponseData.of(div).forwardWithEventName(福祉用具購入費支給).respond();
        } else if (様式番号21D.equals(div.getDgShokanBaraisyokai().getClickedItem().getData3().substring(0, 3))) {
            ViewStateHolder.put("被保番号", new RString(div.getPanelAtenaShikaku().getCcdKaigoShikakuKihon().get被保険者番号().toString()));
            ViewStateHolder.put("サービス提供年月", new RString(div.getDgShokanBaraisyokai().getClickedItem().getData1().toString()));
            ViewStateHolder.put("整理番号", div.getDgShokanBaraisyokai().getClickedItem().getData3());
            return ResponseData.of(div).forwardWithEventName(住宅改修費支給申請).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(償還払い費支給申請).respond();
        }

    }

    private ShinseiSearchHandler getHandler(ShinseiSearchDiv div) {
        return ShinseiSearchHandler.of(div);
    }
}
