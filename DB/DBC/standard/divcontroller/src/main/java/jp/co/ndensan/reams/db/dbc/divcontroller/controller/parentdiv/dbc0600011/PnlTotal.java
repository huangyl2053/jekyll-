/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0600011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0600011.PnlTotalHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
//import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 */
public class PnlTotal {

    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 差額登録 = new RString("差額登録");
    private static final RString 削除 = new RString("削除");
    private static final RString 参照 = new RString("参照");

    private final RString 被保険者番号 = new RString("1");

    /**
     * 福祉用具購入費支給申請の検索
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請
     */
    public ResponseData<PnlTotalDiv> onLoad(PnlTotalDiv div) {

        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("123456")));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo("51"));
        //div.getKaigoCommonPanel().getCcdAtenaInfo().load(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        //div.getKaigoCommonPanel().getCcdShikakuKihon().initialize(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        PnlTotalHandler handler = getHandler(div);
        //FukushiyoguKonyuhiShikyuGendogaku fu = FukushiyoguKonyuhiShikyuGendogaku.createInstance();

        //List<FukushiyouguKonyuhiShikyuShinsei> list = fu.getShokanShikyuShinseiList(HihokenshaNo.EMPTY);
        //handler.initializedgShikyuShinseiList(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請を追加
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_btnAddShikyuShinsei(PnlTotalDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        // ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号());
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請グレードの選択
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_byselectbutton(PnlTotalDiv div) {
        getHandler(div).putViewStateHolder(参照, 被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請グレードの修正
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_dgShikyuShinseiList_modify(PnlTotalDiv div) {
        //差額登録
        RString 登録状態 = 修正;
        if (登録状態.equals(修正)) {
            getHandler(div).putViewStateHolder(修正, 被保険者番号);
        }
        if (登録状態.equals(差額登録)) {
            getHandler(div).putViewStateHolder(差額登録, 被保険者番号);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の申請グレードの削除
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請_登録画面へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_dgShikyuShinseiList_delete(PnlTotalDiv div) {
        getHandler(div).putViewStateHolder(削除, 被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の該当者検索へ戻る
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の検索へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_retrieval(PnlTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 福祉用具購入費支給申請の該当者一覧へ戻る
     *
     * @param div 画面DIV
     * @return 福祉用具購入費支給申請の検索へ遷移
     */
    public ResponseData<PnlTotalDiv> onClick_browse(PnlTotalDiv div) {
        return ResponseData.of(div).respond();
    }

    private PnlTotalHandler getHandler(PnlTotalDiv div) {
        return PnlTotalHandler.of(div);
    }
}
