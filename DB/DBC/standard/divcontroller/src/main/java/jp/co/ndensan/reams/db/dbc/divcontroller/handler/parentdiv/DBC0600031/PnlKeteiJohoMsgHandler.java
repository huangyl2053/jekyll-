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
        if ((支払金額合計New != null && 支払金額合計Old != null && !支払金額合計New.equals(支払金額合計Old))
                || (支払金額合計New != null && 支払金額合計Old == null)
                || 支払金額合計New == null && 支払金額合計Old != null) {
            return true;
        }
        RString 増減理由New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogenriyu().getValue();
        RString 増減理由Old = ViewStateHolder.get(ViewStateKeys.増減理由, RString.class);
        if ((増減理由New != null && 増減理由Old != null && !増減理由New.equals(増減理由Old))
                || (増減理由New != null && 増減理由Old == null)
                || 増減理由New == null && 増減理由Old != null) {
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
        if (equal決定日(決定日New, 決定日Old)) {
            return true;
        }
        RString 支給区分New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                getRdoShikyukubun().getSelectedKey();
        RString 支給区分Old = ViewStateHolder.get(ViewStateKeys.支給区分, RString.class);
        if (equal支給区分(支給区分New, 支給区分Old)) {
            return true;
        }
        RString fuSyikyuriyu1New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFuSyikyuriyu1().getValue();
        RString fuSyikyuriyu1Old = ViewStateHolder.get(ViewStateKeys.fuSyikyuriyu1, RString.class);
        if (equalFuSyikyuriyu1(fuSyikyuriyu1New, fuSyikyuriyu1Old)) {
            return true;
        }
        RString fuSyikyuriyu2New = div.getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFushikyuriyu2().getValue();
        RString fuSyikyuriyu2Old = ViewStateHolder.get(ViewStateKeys.fuSyikyuriyu2, RString.class);
        return equalFuSyikyuriyu2(fuSyikyuriyu2New, fuSyikyuriyu2Old);
    }

    /**
     * 決定日 内容の変更を判断する
     *
     * @param 決定日New RDate
     * @param 決定日Old RDate
     * @return boolean
     */
    public boolean equal決定日(RDate 決定日New, RDate 決定日Old) {
        if (決定日New != null && 決定日Old != null) {
            if (!決定日New.equals(決定日Old)) {
                return true;
            }
        } else if ((決定日New != null && 決定日Old == null)
                || (決定日New == null && 決定日Old != null)) {
            return true;
        }
        return false;
    }

    /**
     * 支給区分 内容の変更を判断する
     *
     * @param 支給区分New RString
     * @param 支給区分Old RString
     * @return boolean
     */
    public boolean equal支給区分(RString 支給区分New, RString 支給区分Old) {
        if (支給区分New != null && 支給区分Old != null) {
            if (!支給区分New.equals(支給区分Old)) {
                return true;
            }
        } else if ((支給区分New != null && 支給区分Old == null)
                || (支給区分New == null && 支給区分Old != null)) {
            return true;
        }
        return false;
    }

    /**
     * fuSyikyuriyu1 内容の変更を判断する
     *
     * @param fuSyikyuriyu1New RString
     * @param fuSyikyuriyu1Old RString
     * @return boolean
     */
    public boolean equalFuSyikyuriyu1(RString fuSyikyuriyu1New, RString fuSyikyuriyu1Old) {
        if (fuSyikyuriyu1New != null && fuSyikyuriyu1Old != null) {
            if (!fuSyikyuriyu1New.equals(fuSyikyuriyu1Old)) {
                return true;
            }
        } else if ((fuSyikyuriyu1New != null && fuSyikyuriyu1Old == null)
                || (fuSyikyuriyu1New == null && fuSyikyuriyu1Old != null)) {
            return true;
        }
        return false;
    }

    /**
     * fuSyikyuriyu2 内容の変更を判断する
     *
     * @param fuSyikyuriyu2New RString
     * @param fuSyikyuriyu2Old RString
     * @return boolean
     */
    public boolean equalFuSyikyuriyu2(RString fuSyikyuriyu2New, RString fuSyikyuriyu2Old) {
        if (fuSyikyuriyu2New != null && fuSyikyuriyu2Old != null) {
            if (!fuSyikyuriyu2New.equals(fuSyikyuriyu2Old)) {
                return true;
            }
        } else if ((fuSyikyuriyu2New != null && fuSyikyuriyu2Old == null)
                || (fuSyikyuriyu2New == null && fuSyikyuriyu2Old != null)) {
            return true;
        }
        return false;
    }
}
