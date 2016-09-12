/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.shokanshinseilisthandler;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshinseiichiran.ShokanShinseiIchiran;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList.ShokanShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshinseiichiran.ShokanShinseiIchiranManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 償還払申請一覧のHandlerクラスです。
 *
 * @reamsid_L DBC-0960-010 hezhenzhen
 *
 */
public class ShokanShinseiHandler {

    private final ShokanShinseiListDiv div;
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_申請 = new RString("申請");
    private static final RString 照会 = new RString("照会");

    /**
     * コンストラクタです。
     *
     * @param div ShokanShinseiListDiv
     */
    public ShokanShinseiHandler(ShokanShinseiListDiv div) {
        this.div = div;
    }

    /**
     * 償還払申請一覧の初期化です。
     *
     * @param 状態 状態
     * @param 被保険者番号 被保険者番号
     * @param サービス年月From サービス年月From
     * @param サービス年月To サービス年月To
     */
    public void onLoad(RString 状態, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月From, FlexibleYearMonth サービス年月To) {
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
        SearchResult<ShokanShinseiIchiran> shokandhinseiichiran;
        if (照会.equals(状態)) {
            shokandhinseiichiran = ShokanShinseiIchiranManager.
                    createInstance().getShokanShinseiListSyokai(被保険者番号, サービス年月From, サービス年月To);
        } else {
            shokandhinseiichiran = ShokanShinseiIchiranManager.
                    createInstance().getShokanShinseiListShinsei(被保険者番号, サービス年月From, サービス年月To);
        }
        initialize(状態, shokandhinseiichiran);
    }

    /**
     * 画面初期化処理します。
     *
     * @param 状態 状態
     * @param shokandhinseiichiran SearchResult<ShokanShinseiIchiran>
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
                if (jigyoshaInput.get事業者番号() != null && !jigyoshaInput.get事業者番号().isEmpty()) {
                    list_Row.setJigyoshaNo(jigyoshaInput.get事業者番号().value());
                }
                list_Row.setMeisaiNo(jigyoshaInput.get明細番号());
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
            RString month = DbBusinessConfig.get(ConfigNameDBC.初期表示_償還支給申請登録初期, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
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
