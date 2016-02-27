/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0600031;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031.PnlKeteiJohoMsgDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

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
     * @return boolean
     */
    public boolean isget内容変更状態() {
        ShokanbaraiketteiJohoDiv div1 = (ShokanbaraiketteiJohoDiv) div.getPnlTotal().getYoguKonyuhiShikyuShinseiContentsPanel().getCcdKetteiList();
        for (dgSyokanbaraikete_Row ddgList : div1.getDgSyokanbaraikete().getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        return false;
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
