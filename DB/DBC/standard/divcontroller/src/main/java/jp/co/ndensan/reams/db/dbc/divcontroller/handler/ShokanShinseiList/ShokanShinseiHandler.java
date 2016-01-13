/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.ShokanShinseiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshinseiichiran.ShokanShinseiIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.dgShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 償還払申請一覧のHandlerクラスです。
 *
 */
public class ShokanShinseiHandler {

    private final ShokanShinseiListDiv div;
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_申請 = new RString("申請");

    public ShokanShinseiHandler(ShokanShinseiListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param 状態
     * @param shokandhinseiichiran
     */
    public void initialize(RString 状態, SearchResult<ShokanShinseiIchiran> shokandhinseiichiran) {

        List<dgShinseiList_Row> dgshinseilistrow = new ArrayList<>();
        if (!shokandhinseiichiran.records().isEmpty()) {
            for (ShokanShinseiIchiran jigyoshaInput : shokandhinseiichiran.records()) {
                dgShinseiList_Row list_Row = new dgShinseiList_Row();
                list_Row.setHiHokenshaNo(jigyoshaInput.get被保険者番号().value());
                list_Row.setServiceTeikyoYM(jigyoshaInput.getサービス年月().wareki().toDateString());
                if (jigyoshaInput.get申請年月日() != null) {
                    list_Row.setShinseiYMD(jigyoshaInput.get申請年月日().wareki().toDateString());
                }
                list_Row.setSeiriNo(jigyoshaInput.get整理番号());
                if (jigyoshaInput.get送付年月() != null) {
                    list_Row.setSofuYM(jigyoshaInput.get送付年月().wareki().toDateString());
                }
                if (jigyoshaInput.get決定年月日() != null) {
                    list_Row.setKetteiYMD(jigyoshaInput.get決定年月日().wareki().toDateString());
                }
                list_Row.setYoshikiNo(jigyoshaInput.get様式番号());
                dgshinseilistrow.add(list_Row);
            }
        }
        this.get状態(状態, dgshinseilistrow);
    }

    private void get状態(RString 状態, List<dgShinseiList_Row> dgshinseilistrow) {
        div.getDgShinseiList().setDataSource(dgshinseilistrow);
        if (状態_照会.equals(状態)) {
            div.getTxtServiceYM().setVisible(false);
            div.getBtnAdd().setVisible(false);
            div.getTxtServiceYMFrom().setVisible(true);
            div.getTxtServiceYMTo().setVisible(true);
            div.getBtnSelect().setVisible(true);
            div.getDgShinseiList().getGridSetting().setIsShowSelectButtonColumn(true);
            div.getDgShinseiList().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgShinseiList().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgShinseiList().getGridSetting().getColumn(new RString("hiHokenshaNo")).setVisible(false);
            div.getDgShinseiList().getGridSetting().getColumn(new RString("yoshikiNo")).setVisible(false);
        }
        if (状態_申請.equals(状態)) {
            RString month = BusinessConfig.get(ConfigNameDBC.初期表示_償還支給申請登録初期, SubGyomuCode.DBC介護給付);
            RDate yearMonth = RDate.getNowDate().minusMonth(Integer.parseInt(month.toString()));
            div.getTxtServiceYM().setValue(yearMonth);
            div.getTxtServiceYM().setVisible(true);
            div.getBtnAdd().setVisible(true);
            div.getTxtServiceYMFrom().setVisible(true);
            div.getTxtServiceYMTo().setVisible(true);
            div.getBtnSelect().setVisible(true);
            div.getDgShinseiList().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getDgShinseiList().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getDgShinseiList().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getDgShinseiList().getGridSetting().getColumn(new RString("hiHokenshaNo")).setVisible(false);
            div.getDgShinseiList().getGridSetting().getColumn(new RString("yoshikiNo")).setVisible(false);

        }
    }
}
