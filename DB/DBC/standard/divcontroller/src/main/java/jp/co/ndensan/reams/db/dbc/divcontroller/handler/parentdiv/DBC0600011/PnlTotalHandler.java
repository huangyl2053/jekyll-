/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011.dgShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費支給申請_検索のHandlerです
 *
 * @reamsid_L DBC-1020-020 yangchenbing
 */
public final class PnlTotalHandler {

    private final PnlTotalDiv div;

    private PnlTotalHandler(PnlTotalDiv div) {
        this.div = div;
    }

    /**
     * 生成されたインタフェースを返します
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
                row.setTxtTeikyoYM(shinsei.getサービス提供年月().wareki().toDateString());
            }
            if (shinsei.get申請年月日() != null) {
                row.setTxtShinseiYMD(shinsei.get申請年月日().wareki().toDateString());
            }
            if (shinsei.get支給_不支給決定区分() != null && !shinsei.get支給_不支給決定区分().isEmpty()) {
                row.setTxtShikyuKubun(ShikyuFushikyuKubun.toValue(new RString(shinsei.
                        get支給_不支給決定区分().toString())).get名称());
            }
            if (shinsei.get決定日() != null) {
                row.setTxtKetteiYMD(shinsei.get決定日().wareki().toDateString());
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
                row.setTxtJigyosyaNo(shinsei.get事業者番号().value());
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
     * getViesStateParameter
     *
     * @param 被保険者番号 HihokenshaNo
     * @return parameter PnlTotalParameter
     */
    public PnlTotalParameter getViesStateParameter(HihokenshaNo 被保険者番号) {
        dgShikyuShinseiList_Row row = div.getYoguKonyuhiShikyuShinseiList().getDgShikyuShinseiList().getClickedItem();
        FlexibleYearMonth eMonth = new FlexibleYearMonth(new RDate(row.getTxtTeikyoYM().
                toString()).getYearMonth().toString());
        return new PnlTotalParameter(被保険者番号, eMonth, row.getTxtSerialNo(),
                new JigyoshaNo(row.getTxtJigyosyaNo()), row.getTxtYoshikiNo(), row.getTxtMeisaiNo());

    }
}
