/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0600011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.dgShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author ycb
 */
public class PnlTotalHandler {

    private final PnlTotalDiv div;

    private PnlTotalHandler(PnlTotalDiv div) {
        this.div = div;
    }

    /**
     *
     * @param div
     * @return
     */
    public static PnlTotalHandler of(PnlTotalDiv div) {
        return new PnlTotalHandler(div);
    }

    public void initializedgShikyuShinseiList(List<FukushiyouguKonyuhiShikyuShinsei> shinseis) {
        List<dgShikyuShinseiList_Row> lists = new ArrayList<>();
        for (FukushiyouguKonyuhiShikyuShinsei shinsei : shinseis) {
            dgShikyuShinseiList_Row row = new dgShikyuShinseiList_Row();
            row.getTxtTeikyoYM().setValue(new RDate(shinsei.getサービス提供年月().toString()));// row.getTxtTeikyoYM().setValue(new RDate(shinsei.getサービス提供年月().toString()));
            row.getTxtShinseiYMD().setValue(new RDate(shinsei.get申請年月日().toString()));
            row.setTxtShikyuKubun(shinsei.get支払区分());
            row.getTxtKetteiYMD().setValue(new RDate(shinsei.get決定日().toString()));
            row.setTxtSerialNo(shinsei.get整理番号());
            row.setTxtShohinmei(shinsei.get商品名());
            row.setTxtKonyuKingaku(shinsei.get購入金額合計());
            row.setTxtSeiriNo(shinsei.get被保険者番号());
            row.setTxtJigyosyaNo(shinsei.get事業者番号());
            row.setTxtYoshikiNo(shinsei.get様式番号());
            row.setTxtMeisaiNo(shinsei.get明細番号());
            lists.add(row);
        }
        div.getYoguKonyuhiShikyuShinseiList().getDgShikyuShinseiList().setDataSource(lists);
    }

    /**
     *
     * @param 状態
     */
    public void putViewStateHolder(RString 状態, RString 被保険者番号) {
        dgShikyuShinseiList_Row row = div.getYoguKonyuhiShikyuShinseiList().getDgShikyuShinseiList().getClickedItem();
        PnlTotalParameter parameter = new PnlTotalParameter(被保険者番号, row.getTxtTeikyoYM().getValue().toFlexibleDate(), row.getTxtSerialNo(),
                row.getTxtJigyosyaNo(), row.getTxtYoshikiNo(), row.getTxtMeisaiNo());
        ViewStateHolder.put(ViewStateKeys.支給申請情報検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);//div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号()

    }

}
