/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0600011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.dgShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 */
public final class PnlTotalHandler {

    private final PnlTotalDiv div;

    private PnlTotalHandler(PnlTotalDiv div) {
        this.div = div;
    }

    /**
     *
     * @param div 画面DIV
     * @return PnlTotalHandler
     */
    public static PnlTotalHandler of(PnlTotalDiv div) {
        return new PnlTotalHandler(div);
    }

    /**
     * initializedgShikyuShinseiList
     *
     * @param shinseis shinseis
     */
    public void initializedgShikyuShinseiList(List<FukushiyouguKonyuhiShikyuShinseiResult> shinseis) {
        List<dgShikyuShinseiList_Row> lists = new ArrayList<>();
        for (FukushiyouguKonyuhiShikyuShinseiResult shinsei : shinseis) {
            dgShikyuShinseiList_Row row = new dgShikyuShinseiList_Row();
            if (shinsei.getサービス提供年月() != null) {
                row.setTxtTeikyoYM(new RString(shinsei.getサービス提供年月().toString()));
            }
            if (shinsei.get申請年月日() != null) {
                row.setTxtShinseiYMD(new RString(shinsei.get申請年月日().toString()));
            }
            if (shinsei.get支給_不支給決定区分() != null) {
                row.setTxtShikyuKubun(new RString(shinsei.get支給_不支給決定区分().toString()));
            }
            if (shinsei.get決定日() != null) {
                row.setTxtKetteiYMD(new RString(shinsei.get決定日().toString()));
            }
            if (shinsei.get整理番号() != null) {
                row.setTxtSerialNo(new RString(shinsei.get整理番号().toString()));
            }
            if (shinsei.get商品名() != null) {
                row.setTxtShohinmei(new RString(shinsei.get商品名().toString()));
            }
            if (shinsei.get購入金額合計() != null) {
                row.setTxtKonyuKingaku(new RString(shinsei.get購入金額合計().toString()));
            }
            if (shinsei.get事業者番号() != null) {
                row.setTxtJigyosyaNo(new RString(shinsei.get事業者番号().toString()));
            }
            if (shinsei.get様式番号() != null) {
                row.setTxtYoshikiNo(new RString(shinsei.get様式番号().toString()));
            }
            if (shinsei.get明細番号() != null) {
                row.setTxtMeisaiNo(new RString(shinsei.get明細番号().toString()));
            }
            lists.add(row);
        }
        div.getYoguKonyuhiShikyuShinseiList().getDgShikyuShinseiList().setDataSource(lists);
    }

    /**
     * ヘッダ_エリア
     *
     * @param 状態 状態
     * @param 被保険者番号 被保険者番号
     */
    public void putViewStateHolder(RString 状態, RString 被保険者番号) {
        dgShikyuShinseiList_Row row = div.getYoguKonyuhiShikyuShinseiList().getDgShikyuShinseiList().getClickedItem();
        PnlTotalParameter parameter = new PnlTotalParameter(被保険者番号, row.getTxtTeikyoYM(), row.getTxtSerialNo(),
                row.getTxtJigyosyaNo(), row.getTxtYoshikiNo(), row.getTxtMeisaiNo());
        ViewStateHolder.put(ViewStateKeys.支給申請情報検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
//div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号()
    }

}
