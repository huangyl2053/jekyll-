/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0600031;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 */
public final class PnlKeteiJohoMsgHandler {

    private final PnlKeteiJohoMsgDiv div;

    private PnlKeteiJohoMsgHandler(PnlKeteiJohoMsgDiv div) {
        this.div = div;
    }

    /**
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
     * @param divs divs
     * @return boolean
     */
    public boolean is内容変更状態(PnlKeteiJohoMsgDiv divs) {
        boolean flag = false;
        PnlKeteiJohoMsgDiv 決定情報 = divs;
        Decimal 支払金額合計New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtShiharaikingakugoke().getValue();
        Decimal 支払金額合計Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtShiharaikingakugoke().getValue();
        if (!支払金額合計New.equals(支払金額合計Old)) {
            flag = true;
        }
        RString 増減理由New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogenriyu().getValue();
        RString 増減理由Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogenriyu().getValue();
        if (!増減理由New.equals(増減理由Old)) {
            flag = true;
        }
        int 増減単位New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogentani().getValue().intValue();
        int 増減単位Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtZogentani().getValue().intValue();
        if (増減単位New != 増減単位Old) {
            flag = true;
        }
        RDate 決定日New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtKetebi().getValue();
        RDate 決定日Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtKetebi().getValue();
        if (!決定日New.equals(決定日Old)) {
            flag = true;
        }
        RString 支給区分New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                getRdoShikyukubun().getSelectedKey();
        RString 支給区分Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv().
                getRdoShikyukubun().getSelectedKey();
        if (!支給区分New.equals(支給区分Old)) {
            flag = true;
        }
        RString fuSyikyuriyu1New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFuSyikyuriyu1().getValue();
        RString fuSyikyuriyu1Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFuSyikyuriyu1().getValue();
        if (!fuSyikyuriyu1New.equals(fuSyikyuriyu1Old)) {
            flag = true;
        }
        RString fuSyikyuriyu2New = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFushikyuriyu2().getValue();
        RString fuSyikyuriyu2Old = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().getShokanbaraiketteiJohoDiv()
                .getTxtFushikyuriyu2().getValue();
        if (!fuSyikyuriyu2New.equals(fuSyikyuriyu2Old)) {
            flag = true;
        }
        //    ShokanShinsei 償還払支給申請 = get償還払支給申請(被保険者番号, サービス年月, 整理番号);
//        償還払支給申請 = 償還払支給申請.createBuilderForEdit().
//                set受付年月日(
//                        new FlexibleDate(this.parentDiv.getPnlShinsei().getTxtUketsukeYMD().getValue().toString())).
//                set申請年月日(
//                        new FlexibleDate(this.parentDiv.getPnlShinsei().getTxtShinseiYMD().getValue().toString())).
//                set申請理由(this.parentDiv.getPnlShinsei().getTxtMulShinseiRiyu().getValue()).
//                set申請者区分(this.parentDiv.getPnlShinsei().getRdoShinseisyaKubun().getSelectedValue()).
//                set申請者氏名(this.parentDiv.getPnlShinsei().getTxtShimeiKanji().getDomain().value()).
//                set申請者氏名カナ(this.parentDiv.getPnlShinsei().getTxtShimeikana().getDomain().value()).
//                set支払金額合計(this.parentDiv.getPnlShinsei().getTxtNumShiharaKingakuGk().getValue()).build();
//        return 償還払支給申請.hasChanged();
//        DataGrid<dgSyokanbaraikete_Row> datagridnew = div.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().
//                getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete();
//        DataGrid<dgSyokanbaraikete_Row> datagridold = 決定情報.getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList().
//                getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete();
//        if (!datagridold.equals(datagridold)) {
//            flag = true;
//        }
        return flag;
    }
}
