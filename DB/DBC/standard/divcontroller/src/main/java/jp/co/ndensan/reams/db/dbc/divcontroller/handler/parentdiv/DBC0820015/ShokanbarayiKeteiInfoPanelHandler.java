/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820015;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い費支給申請決定_償還払決定情報
 *
 * @reamsid_L DBC-1030-180 xuhao
 */
public class ShokanbarayiKeteiInfoPanelHandler {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 照会 = new RString("照会");
    private static final RString 新規 = new RString("新規");
    private static final RString 参照 = new RString("参照");
    private static final RString 業務区分 = new RString("03");

    private final ShokanbarayiKeteiInfoPanelDiv div;
    private static final int 定数_0 = 0;

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
     * initialize
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 画面モード RString
     */
    public void initialize(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            RString 画面モード
    ) {
        if (登録.equals(画面モード)) {
            div.getPanelTwo().getTxtServiceTeikyoYM().clearValue();
            div.getPanelTwo().getTxtSeiriBango().clearValue();
            div.getCcdShokanbaraiketteiJoho().loadInitialize(
                    被保険者番号, サービス年月, 整理番号, 業務区分, 修正);
            div.getPanelTwo().getTxtShoriMode().setValue(新規);
        }
        if (修正.equals(画面モード)) {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki()
                    .toDateString().toString()));
            div.getCcdShokanbaraiketteiJoho().loadInitialize(
                    被保険者番号, サービス年月, 整理番号, 業務区分, 修正);
            div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
            div.getPanelTwo().getTxtShoriMode().setValue(修正);
        }
        if (削除.equals(画面モード)) {
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki()
                    .toDateString().toString()));
            div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
            div.getCcdShokanbaraiketteiJoho().loadInitialize(
                    被保険者番号, サービス年月, 整理番号, 業務区分, 照会);
            div.getPanelTwo().getTxtShoriMode().setValue(参照);
        }
    }

    /**
     * isチェック処理
     *
     * @param paramter ShoukanharaihishinseikensakuParameter
     * @return flag
     */
    public boolean isチェック処理(ShoukanharaihishinseikensakuParameter paramter) {
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        boolean flag = true;
        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete()
                .getDataSource();
        for (dgSyokanbaraikete_Row row : rowList) {
            JigyoshaNo 事業者番号 = new JigyoshaNo(row.getJigyoshaNo());
            RString 様式番号 = row.getYoshikiNo();
            int 件数 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, new RString("2"));
            if (件数 != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 決定日 内容の変更を判断する
     *
     * @param 決定情報 KetteJoho
     * @param ketebi FlexibleDate
     * @return boolean
     */
    private Boolean equal決定日(KetteJoho 決定情報, FlexibleDate ketebi) {
        if (決定情報 != null && ketebi != null) {
            if (!ketebi.equals(決定情報.getKetteiYMD())) {
                return true;
            }
        } else if (決定情報 != null && 決定情報.getKetteiYMD() != null && ketebi == null) {
            return true;
        }
        if ((決定情報 == null && ketebi != null)
                && !ketebi.equals(new FlexibleDate(RDate.getNowDate().toDateString()))) {
            return true;
        }
        return false;
    }

    /**
     * 支給区分 内容の変更を判断する
     *
     * @param 決定情報 KetteJoho
     * @param rdoShikyukubunNew RString
     * @return boolean
     */
    private Boolean equal支給区分(KetteJoho 決定情報, RString rdoShikyukubunNew) {
        if (決定情報 != null && rdoShikyukubunNew != null) {
            if (!rdoShikyukubunNew.equals(決定情報.getShikyuHushikyuKetteiKubun())) {
                return true;
            }
        } else if ((決定情報 != null && 決定情報.getShikyuHushikyuKetteiKubun() != null && rdoShikyukubunNew == null)
                || (決定情報 == null && !rdoShikyukubunNew.isEmpty())) {
            return true;
        }
        return false;
    }

    /**
     * 償還払決定一覧 内容の変更を判断する
     *
     * @param rowList List<dgSyokanbaraikete_Row>
     * @param 償還払決定一覧 Map<RString, Integer>
     * @return boolean
     */
    private Boolean equal償還払決定一覧(List<dgSyokanbaraikete_Row> rowList, Map<RString, Integer> 償還払決定一覧) {
        for (int i = 0; i < rowList.size(); i++) {
            if (償還払決定一覧 != null && 償還払決定一覧.get(rowList.get(i).getNo()) != rowList.get(i).getSagakuKingaku().getValue().intValue()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 内容の変更を判断する
     *
     * @param zogenriyu 増減理由等
     * @param 決定情報 KetteJoho
     * @return Boolean
     */
    private Boolean equalZogenriyu(RString zogenriyu, KetteJoho 決定情報) {
        if (zogenriyu.isEmpty() && 決定情報.getZougenRiyu().isEmpty()) {
            return false;
        }
        if (!zogenriyu.isEmpty() && zogenriyu.equals(決定情報.getZougenRiyu())) {
            return false;
        }
        return true;
    }

    /**
     * 内容の変更を判断する
     *
     * @param fuSyikyuriyu1 不支給理由等①
     * @param 決定情報 KetteJoho
     * @return Boolean
     */
    private Boolean equalFuSyikyuriyu1(RString fuSyikyuriyu1, KetteJoho 決定情報) {
        if (fuSyikyuriyu1.isEmpty() && 決定情報.getHushikyuRiyu().isEmpty()) {
            return false;
        }
        if (!fuSyikyuriyu1.isEmpty() && fuSyikyuriyu1.equals(決定情報.getHushikyuRiyu())) {
            return false;
        }
        return true;
    }

    /**
     * 内容の変更を判断する
     *
     * @param fushikyuriyu2 不支給理由等②
     * @param 決定情報 KetteJoho
     * @return Boolean
     */
    private Boolean equalfushikyuriyu2(RString fushikyuriyu2, KetteJoho 決定情報) {
        if (fushikyuriyu2.isEmpty() && 決定情報.getZougenRiyu().isEmpty()) {
            return false;
        }
        if (!fushikyuriyu2.isEmpty() && fushikyuriyu2.equals(決定情報.getKounyuKaishuRireki())) {
            return false;
        }
        return true;
    }

    /**
     * get内容変更状態
     *
     * @param 償還払決定一覧 Map
     * @param 決定情報 KetteJoho
     * @return Boolean
     */
    public Boolean get内容変更状態(Map<RString, Integer> 償還払決定一覧, KetteJoho 決定情報) {
        boolean flag = false;
        RDate 決定日 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue();
        if (決定日 != null) {
            FlexibleDate ketebi = new FlexibleDate(div.getCcdShokanbaraiketteiJoho().
                    getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toDateString());
            if (equal決定日(決定情報, ketebi)) {
                flag = true;
            }
        }
        RString rdoShikyukubunNew = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        if (equal支給区分(決定情報, rdoShikyukubunNew)) {
            flag = true;
        } else if (決定情報 != null && 決定情報.getShikyuHushikyuKetteiKubun() != null
                && 決定情報.getShikyuHushikyuKetteiKubun().equals(ShikyuFushikyuKubun.支給.getコード())) {
            RString zogenriyu = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
            if (equalZogenriyu(zogenriyu, 決定情報)) {
                flag = true;
            }
            int zogentani = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
            if (決定情報.getZougenten() != null && zogentani != 決定情報.getZougenten()) {
                flag = true;
            }
            int shiharaikingakugoke = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke()
                    .getValue().intValue();
            if (決定情報.getShiharaiKingaku() != null && shiharaikingakugoke != 決定情報.getShiharaiKingaku()) {
                flag = true;
            }
        } else if (決定情報 != null && 決定情報.getShikyuHushikyuKetteiKubun() != null
                && 決定情報.getShikyuHushikyuKetteiKubun().equals(ShikyuFushikyuKubun.不支給.getコード())) {
            RString fuSyikyuriyu1 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
            if (equalFuSyikyuriyu1(fuSyikyuriyu1, 決定情報)) {
                flag = true;
            }
            RString fushikyuriyu2 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
            if (equalfushikyuriyu2(fushikyuriyu2, 決定情報)) {
                flag = true;
            }
        }
        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete().getDataSource();
        if (equal償還払決定一覧(rowList, 償還払決定一覧)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 削除Save
     *
     * @param paramter ShoukanharaihishinseikensakuParameter
     * @param 識別コード ShikibetsuCode
     */
    public void 削除Save(ShoukanharaihishinseikensakuParameter paramter, ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        SyokanbaraihiShikyuShinseiKetteManager.createInstance().delDbT3034ShokanShinsei(被保険者番号,
                サービス年月, 整理番号, 識別コード);
    }

    /**
     * 登録Save
     *
     * @param paramter ShoukanharaihishinseikensakuParameter
     * @param 支払金額合計初期 Decimal
     * @param 画面モード RString
     * @param 識別コード ShikibetsuCode
     */
    public void 登録Save(ShoukanharaihishinseikensakuParameter paramter, Decimal 支払金額合計初期,
            RString 画面モード, ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        FlexibleDate 決定年月日 = new FlexibleDate(div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toString());
        RString 支給区分 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        Decimal 支払金額合計 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue();
        Decimal 差額金額 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtSagakuGoke().getValue();
        RString 増減理由等 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
        RString 不支給理由等1 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
        RString 不支給理由等2 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
        int 増減単位 = div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
        List<SyokanbaraihiShikyuShinseiKetteEntity> entityList = new ArrayList<>();
        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getDgSyokanbaraikete().getDataSource();
        if (rowList != null && !rowList.isEmpty()) {
            for (dgSyokanbaraikete_Row row : rowList) {
                SyokanbaraihiShikyuShinseiKetteEntity entity = SyokanbaraihiShikyuShinseiKetteEntity.createSelectByKeyParam(
                        new JigyoshaNo(row.getJigyoshaNo()),
                        row.getYoshikiNo(),
                        row.getYoshikiNo(),
                        row.getMeisaiNo(),
                        row.getRenban(),
                        row.getSagakuKingaku().getValue().intValue(),
                        row.getTableKubun(),
                        Integer.valueOf(row.getUpdateCount().toString()));
                entityList.add(entity);
            }
            boolean flag = rowList.get(定数_0).getSagakuKingaku().isDisabled();
            boolean 差額金額登録フラグ = true;
            if (flag) {
                差額金額登録フラグ = false;
            }
            SyokanbaraihiShikyuShinseiKetteParameter parameter = SyokanbaraihiShikyuShinseiKetteParameter.createSelectByKeyParam(
                    被保険者番号,
                    サービス提供年月,
                    整理番号,
                    決定年月日,
                    支給区分,
                    支払金額合計初期,
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

}
