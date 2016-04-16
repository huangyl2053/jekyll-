/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820015;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_償還払決定情報
 *
 * @reamsid_L DBC-1030-180 xuhao
 */
public class ShokanbarayiKeteiInfoPanelHandler {

    private final ShokanbarayiKeteiInfoPanelDiv div;
    private static final int SIX = 6;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    /**
     * ShokanbarayiKeteiInfoPanelHandler
     *
     * @param div 画面DIV
     */
    public ShokanbarayiKeteiInfoPanelHandler(ShokanbarayiKeteiInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * of
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public static ShokanbarayiKeteiInfoPanelHandler of(ShokanbarayiKeteiInfoPanelDiv div) {
        return new ShokanbarayiKeteiInfoPanelHandler(div);
    }

    /**
     * isチェック処理
     *
     * @return flag
     */
    public boolean isチェック処理() {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 様式番号 = paramter.getYoshikiNo();
        boolean flag = false;
        int 件数 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(被保険者番号,
                サービス年月, 整理番号, 事業者番号, 様式番号);
        if (件数 == 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * putViewState
     */
    public void putViewState() {
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toDateString()
                        .substring(0, SIX)),
                div.getPanelTwo().getTxtSeiriBango().getValue(), null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

    /**
     * get内容変更状態
     *
     * @param 償還払決定一覧 償還払決定一覧
     * @param 決定情報 決定情報
     * @return flag
     */
    public Boolean get内容変更状態(List<dgSyokanbaraikete_Row> 償還払決定一覧, KetteJoho 決定情報) {
        boolean flag = false;
        FlexibleDate ketebi = new FlexibleDate(div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtKetebi()
                .getValue().toDateString());
        if (!ketebi.equals(決定情報.getKetteiYMD())) {
            flag = true;
        }
        RString rdoShikyukubunNew = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        if (!rdoShikyukubunNew.equals(決定情報.getShikyuHushikyuKetteiKubun())) {
            flag = true;
        } else if (決定情報.getShikyuHushikyuKetteiKubun().equals(ONE)) {
            RString zogenriyu = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
            if (!zogenriyu.equals(決定情報.getZougenRiyu())) {
                flag = true;
            }
            int zogentani = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
            if (zogentani != 決定情報.getZougenten()) {
                flag = true;
            }
            int shiharaikingakugoke = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke()
                    .getValue().intValue();
            if (shiharaikingakugoke != 決定情報.getShiharaiKingaku()) {
                flag = true;
            }
        } else if (決定情報.getShikyuHushikyuKetteiKubun().equals(TWO)) {
            RString fuSyikyuriyu1 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
            if (!fuSyikyuriyu1.equals(決定情報.getHushikyuRiyu())) {
                flag = true;
            }
            RString fushikyuriyu2 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
            if (!fushikyuriyu2.equals(決定情報.getKounyuKaishuRireki())) {
                flag = true;
            }
        }
        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete().getDataSource();
        for (int i = 0; i < rowList.size(); i++) {
            if (償還払決定一覧.get(i).getSagakuKingaku().getValue().intValue() != rowList.get(i).getSagakuKingaku().getValue().intValue()) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 削除Save
     */
    public void 削除Save() {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delDbT3034ShokanShinsei(被保険者番号,
                サービス年月, 整理番号, 識別コード);
    }

    /**
     * 登録Save
     */
    public void 登録Save() {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        FlexibleDate 決定年月日 = new FlexibleDate(div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toString());
        RString 支給区分 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        Decimal 支払金額合計 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue();
        int 差額金額 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtSagakuGoke().getValue().intValue();
        RString 増減理由等 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
        RString 不支給理由等1 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
        RString 不支給理由等2 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
        int 増減単位 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
        boolean flag = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete()
                .getGridSetting().getColumn("sagakuKingaku").isVisible();
        boolean 差額金額登録フラグ = true;
        if (flag) {
            差額金額登録フラグ = false;
        }
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");

        List<SyokanbaraihiShikyuShinseiKetteEntity> entityList = new ArrayList<>();
        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getDgSyokanbaraikete().getDataSource();
        for (dgSyokanbaraikete_Row row : rowList) {
            SyokanbaraihiShikyuShinseiKetteEntity entity = SyokanbaraihiShikyuShinseiKetteEntity.createSelectByKeyParam(
                    new JigyoshaNo(row.getJigyoshaNo()),
                    row.getYoshikiNo(),
                    row.getMeisaiNo(),
                    row.getRenban(),
                    row.getSagakuKingaku().getValue().intValue(),
                    row.getTableKubun(),
                    Integer.valueOf(row.getUpdateCount().toString()));
            entityList.add(entity);
        }
        SyokanbaraihiShikyuShinseiKetteParameter parameter = SyokanbaraihiShikyuShinseiKetteParameter.createSelectByKeyParam(
                被保険者番号,
                サービス提供年月,
                整理番号,
                決定年月日,
                支給区分,
                支払金額合計,
                差額金額,
                増減理由等,
                不支給理由等1,
                不支給理由等2,
                増減単位,
                差額金額登録フラグ,
                画面モード,
                識別コード,
                entityList);
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updKetteJoho(parameter);
    }

}
