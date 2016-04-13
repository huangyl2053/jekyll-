/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0710022;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN52002_住宅改修費支給申請_償還払決定情報登録
 *
 * @reamsid_L DBC-0992-110 yangchenbing
 */
public final class MainPanelHandler {

    private final MainPanelDiv div;

    private MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     *
     * @param div div
     * @return MainPanelHandler
     */
    public static MainPanelHandler of(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    /**
     * 内容変更状態
     *
     * @return boolean
     */
    public boolean is内容変更状態() {
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        Decimal 支払金額合計New = shokanbaraiketteiJohoDiv.getTxtShiharaikingakugoke().getValue();
        Decimal 支払金額合計Old = ViewStateHolder.get(ViewStateKeys.支払金額合計, Decimal.class);
        if (!支払金額合計New.equals(支払金額合計Old)) {
            return true;
        }
        RString 増減理由New = shokanbaraiketteiJohoDiv.getTxtZogenriyu().getValue();
        RString 増減理由Old = ViewStateHolder.get(ViewStateKeys.増減理由, RString.class);
        if (!増減理由New.equals(増減理由Old)) {
            return true;
        }
        int 増減単位New = shokanbaraiketteiJohoDiv.getTxtZogentani().getValue().intValue();
        int 増減単位Old = ViewStateHolder.get(ViewStateKeys.増減単位, int.class);
        if (増減単位New != 増減単位Old) {
            return true;
        }
        RDate 決定日New = shokanbaraiketteiJohoDiv.getTxtKetebi().getValue();
        RDate 決定日Old = ViewStateHolder.get(ViewStateKeys.決定日, RDate.class);
        if (!決定日New.equals(決定日Old)) {
            return true;
        }
        RString 支給区分New = shokanbaraiketteiJohoDiv.getRdoShikyukubun().getSelectedKey();
        RString 支給区分Old = ViewStateHolder.get(ViewStateKeys.支給区分, RString.class);
        if (!支給区分New.equals(支給区分Old)) {
            return true;
        }
        RString fuSyikyuriyu1New = shokanbaraiketteiJohoDiv.getTxtFuSyikyuriyu1().getValue();
        RString fuSyikyuriyu1Old = ViewStateHolder.get(ViewStateKeys.fuSyikyuriyu1, RString.class);
        if (!fuSyikyuriyu1New.equals(fuSyikyuriyu1Old)) {
            return true;
        }
        RString fuSyikyuriyu2New = shokanbaraiketteiJohoDiv.getTxtFushikyuriyu2().getValue();
        RString fuSyikyuriyu2Old = ViewStateHolder.get(ViewStateKeys.fuSyikyuriyu2, RString.class);
        return !fuSyikyuriyu2New.equals(fuSyikyuriyu2Old);
    }

}
