/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600031;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請_決定情報登録 Handler
 *
 * @reamsid_L DBC-1020-010 yangchenbing
 */
public final class PnlKeteiJohoMsgHandler {

    private final PnlKeteiJohoMsgDiv div;

    private PnlKeteiJohoMsgHandler(PnlKeteiJohoMsgDiv div) {
        this.div = div;
    }

    /**
     * 戻り対象
     *
     * @param div div
     * @return PnlKeteiJohoMsgHandler
     */
    public static PnlKeteiJohoMsgHandler of(PnlKeteiJohoMsgDiv div) {
        return new PnlKeteiJohoMsgHandler(div);
    }

    /**
     * get内容変更状態
     *
     * @return boolean
     */
    public boolean is内容変更状態() {
        Decimal 支払金額合計New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtShiharaikingakugoke().getValue();
        Decimal 支払金額合計Old = ViewStateHolder.get(ViewStateKeys.支払金額合計, Decimal.class);
        if (!支払金額合計New.equals(支払金額合計Old)) {
            return true;
        }
        RString 増減理由New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogenriyu().getValue();
        RString 増減理由Old = ViewStateHolder.get(ViewStateKeys.増減理由, RString.class);
        if (!増減理由New.equals(増減理由Old)) {
            return true;
        }
        int 増減単位New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogentani().getValue().intValue();
        int 増減単位Old = ViewStateHolder.get(ViewStateKeys.増減単位, int.class);
        if (増減単位New != 増減単位Old) {
            return true;
        }
        RDate 決定日New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtKetebi().getValue();
        RDate 決定日Old = ViewStateHolder.get(ViewStateKeys.決定日, RDate.class);
        if (!決定日New.equals(決定日Old)) {
            return true;
        }
        RString 支給区分New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                getRdoShikyukubun().getSelectedKey();
        RString 支給区分Old = ViewStateHolder.get(ViewStateKeys.支給区分, RString.class);
        if (!支給区分New.equals(支給区分Old)) {
            return true;
        }
        RString fuSyikyuriyu1New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFuSyikyuriyu1().getValue();
        RString fuSyikyuriyu1Old = ViewStateHolder.get(ViewStateKeys.fuSyikyuriyu1, RString.class);
        if (!fuSyikyuriyu1New.equals(fuSyikyuriyu1Old)) {
            return true;
        }
        RString fuSyikyuriyu2New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFushikyuriyu2().getValue();
        RString fuSyikyuriyu2Old = ViewStateHolder.get(ViewStateKeys.fuSyikyuriyu2, RString.class);
        return !fuSyikyuriyu2New.equals(fuSyikyuriyu2Old);
    }
}
