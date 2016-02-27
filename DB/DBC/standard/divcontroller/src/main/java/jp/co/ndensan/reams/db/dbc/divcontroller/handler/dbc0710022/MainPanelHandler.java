/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0710022;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.MainPanelDiv;

/**
 *
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
     *
     * @param div1 div1
     * @return get内容変更状態
     */
    public boolean get内容変更状態(MainPanelDiv div1) {
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv1 = (ShokanbaraiketteiJohoDiv) div1.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        boolean f1 = shokanbaraiketteiJohoDiv.getDgSyokanbaraikete().getDataSource().equals(shokanbaraiketteiJohoDiv1.getDgSyokanbaraikete().getDataSource());
        //   boolean f2 = shokanbaraiketteiJohoDiv.getTxtFuSyikyuriyu1().equals(shokanbaraiketteiJohoDiv1.getTxtFuSyikyuriyu1());
        //  boolean f3 = shokanbaraiketteiJohoDiv.getTxtFushikyuriyu2().equals(shokanbaraiketteiJohoDiv1.getTxtFushikyuriyu2());
        // boolean f4 = shokanbaraiketteiJohoDiv.getTxtKetebi().equals(shokanbaraiketteiJohoDiv1.getTxtKetebi());
        //  boolean f5 = shokanbaraiketteiJohoDiv.getTxtSagakuGoke().equals(shokanbaraiketteiJohoDiv1.getTxtSagakuGoke());
        //  boolean f6 = shokanbaraiketteiJohoDiv.getTxtShiharaikingakugoke().equals(shokanbaraiketteiJohoDiv1.getTxtShiharaikingakugoke());
        //  boolean f7 = shokanbaraiketteiJohoDiv.getTxtZogenriyu().equals(shokanbaraiketteiJohoDiv1.getTxtZogenriyu());
        //  boolean f8 = shokanbaraiketteiJohoDiv.getTxtZogentani().equals(shokanbaraiketteiJohoDiv1.getTxtZogentani());
        //f1 & f2 & f3 & f4 & f5 & f6 & f7 & f8

        return !f1;

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
}
