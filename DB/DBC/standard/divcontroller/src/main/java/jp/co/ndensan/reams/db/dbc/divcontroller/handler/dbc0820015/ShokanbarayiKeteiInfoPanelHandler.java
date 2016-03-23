/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820015;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
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
 */
public class ShokanbarayiKeteiInfoPanelHandler {

    private final ShokanbarayiKeteiInfoPanelDiv div;
    private static final int SIX = 6;

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

    public boolean getチェック処理() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
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
        // TODO 処理モード　
        ViewStateHolder.put(ViewStateKeys.処理モード, ViewStateHolder.get(ViewStateKeys.処理モード, RString.class));
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toDateString()
                        .substring(0, SIX)),
                div.getPanelTwo().getTxtSeiriBango().getValue(), null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }

    /**
     * get内容変更状態
     *
     * @return true
     */
    public Boolean get内容変更状態() {
        boolean flag = false;
        KetteJoho 決定情報 = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys.決定情報,
                KetteJoho.class);
        RString zougenRiyuNew = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getTxtZogenriyu().getValue();
        RString zougenRiyuOld = 決定情報.getZougenRiyu();
        if (!zougenRiyuNew.equals(zougenRiyuOld)) {
            flag = true;
        }
        int zougentenNew = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getTxtZogentani().getValue().intValue();
        int zougentenOld = 決定情報.getZougenten().intValue();
        if (zougentenNew != zougentenOld) {
            flag = true;
        }
        RString fuSyikyuriyu1New = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getTxtFuSyikyuriyu1().getValue();
        RString fuSyikyuriyu1Old = 決定情報.getHushikyuRiyu();
        if (!fuSyikyuriyu1New.equals(fuSyikyuriyu1Old)) {
            flag = true;
        }
        RString fuSyikyuriyu2New = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getTxtFushikyuriyu2().getValue();
        RString fuSyikyuriyu2Old = 決定情報.getKounyuKaishuRireki();
        if (!fuSyikyuriyu2New.equals(fuSyikyuriyu2Old)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 削除Save
     */
    public void 削除Save() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delDbT3034ShokanShinsei(被保険者番号,
                サービス年月, 整理番号, 識別コード);
    }

    public void 登録Save() {
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 明細番号 = paramter.getMeisaiNo();
        FlexibleDate 決定年月日 = new FlexibleDate(div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toString());
        RString 支給区分 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedValue();
        Decimal 支払金額合計 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue();
        int 差額金額 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtSagakuGoke().getValue().intValue();
        RString 増減理由等 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
        RString 不支給理由等1 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
        RString 不支給理由等2 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
        int 増減単位 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
        List<dgSyokanbaraikete_Row> entityList = div.getCcdShokanbaraiketteiJoho().
                getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete().getDataSource();
        List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List = new ArrayList<>();
        for (dgSyokanbaraikete_Row row : entityList) {
            JigyoshaNo 事業者番 = new JigyoshaNo(row.getJigyoshaNo());
            RString 証明書コード = row.getShurui();
            RString 明細番号Grid = row.getMeisaiNo();
            RString 連番 = row.getRenban();
            int 差額金額Grid = row.getSagakuKingaku().getValue().intValue();
            RString テーブル区分 = row.getTableKubun();
            SyokanbaraihiShikyuShinseiKetteEntity entity = SyokanbaraihiShikyuShinseiKetteEntity.
                    createSelectByKeyParam(事業者番, 証明書コード, 明細番号Grid, 連番, 差額金額Grid, テーブル区分);
            決定情報一覧List.add(entity);
        }
        boolean 差額金額登録フラグ = true;
        RString 証明書コード = new RString("000000001");
        RString 連番 = new RString("001");
        RString 画面モード = new RString("モード_修正");
        ShikibetsuCode 識別コード = new ShikibetsuCode("00001");
        SyokanbaraihiShikyuShinseiKetteParameter parameter = SyokanbaraihiShikyuShinseiKetteParameter.
                createSelectByKeyParam(被保険者番号, サービス提供年月, 整理番号, 決定年月日, 支給区分, 支払金額合計,
                        差額金額, 増減理由等, 不支給理由等1, 不支給理由等2, 増減単位, 差額金額登録フラグ, 事業者番号,
                        証明書コード, 明細番号, 連番, 画面モード, 識別コード, 決定情報一覧List);
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().updKetteJoho(parameter);
    }
}
