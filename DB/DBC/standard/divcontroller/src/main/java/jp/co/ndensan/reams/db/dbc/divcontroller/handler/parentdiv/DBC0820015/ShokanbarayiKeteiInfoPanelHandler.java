/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820015;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ModoruEntity;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinsei.SyokanbaraihiShikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.InsupdShokanManager;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekkaBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
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
            div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
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
        RString チェック区分 = new RString("2");
        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getDgSyokanbaraikete()
                .getDataSource();
        for (dgSyokanbaraikete_Row row : rowList) {
            JigyoshaNo 事業者番号 = new JigyoshaNo(row.getJigyoshaNo());
            RString 様式番号 = row.getYoshikiNo();
            int 件数 = SyokanbaraihiShikyuShinseiKetteManager.createInstance().getShikibetsuNoKanri(被保険者番号,
                    サービス年月, 整理番号, 事業者番号, 様式番号, チェック区分);
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
    private Boolean equal償還払決定一覧(List<dgSyokanbaraikete_Row> rowList, Map<RString, Decimal> 償還払決定一覧) {
        for (int i = 0; i < rowList.size(); i++) {
            if (償還払決定一覧 != null && 償還払決定一覧.get(rowList.get(i).getNo()) != rowList.get(i).getSagakuKingaku().getValue()) {
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
        if (決定情報 == null && zogenriyu.isEmpty()) {
            return false;
        }

        if (決定情報 != null && zogenriyu.isEmpty() && 決定情報.getZougenRiyu().isEmpty()) {
            return false;
        }
        if (決定情報 != null && !zogenriyu.isEmpty() && zogenriyu.equals(決定情報.getZougenRiyu())) {
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
        if (決定情報 != null && fuSyikyuriyu1.isEmpty() && 決定情報.getHushikyuRiyu().isEmpty()) {
            return false;
        }
        if (決定情報 != null && !fuSyikyuriyu1.isEmpty() && fuSyikyuriyu1.equals(決定情報.getHushikyuRiyu())) {
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
        if (決定情報 != null && fushikyuriyu2.isEmpty() && 決定情報.getZougenRiyu().isEmpty()) {
            return false;
        }
        if (決定情報 != null && !fushikyuriyu2.isEmpty() && fushikyuriyu2.equals(決定情報.getKounyuKaishuRireki())) {
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
    public Boolean get内容変更状態(Map<RString, Decimal> 償還払決定一覧, KetteJoho 決定情報) {
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
     * @param DB情報 DbJohoViewState
     * @param 修正前支給区分 RString
     * @param 決定日 FlexibleDate
     * @param paramter ShoukanharaihishinseikensakuParameter
     * @param 画面モード RString
     * @param 識別コード ShikibetsuCode
     */
    public void 登録Save(DbJohoViewState DB情報, RString 修正前支給区分, FlexibleDate 決定日,
            ShoukanharaihishinseikensakuParameter paramter, RString 画面モード, ShikibetsuCode 識別コード) {
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        InsupdShokanManager manager = InsupdShokanManager.createInstance();
        if (DB情報.get償還払支給判定結果() != null) {
            manager.update償還払支給判定結果(DB情報.get償還払支給判定結果());
        }
        if (DB情報.get償還払請求集計データList() != null
                && !DB情報.get償還払請求集計データList().isEmpty()) {
            manager.update証明書(DB情報, サービス年月);
        }
    }

//    /**
//     * 登録Save
//     *
//     * @param paramter ShoukanharaihishinseikensakuParameter
//     * @param 支払金額合計初期 Decimal
//     * @param 画面モード RString
//     * @param 識別コード ShikibetsuCode
//     * @param 初期情報 ShokiShokanJoho
//     * @param 証明書入力済フラグ ShomeishoNyuryokuFlag
//     */
//    public void 登録Save(ShoukanharaihishinseikensakuParameter paramter, Decimal 支払金額合計初期,
//            RString 画面モード, ShikibetsuCode 識別コード, ShokiShokanJoho 初期情報, ShomeishoNyuryokuFlag 証明書入力済フラグ) {
//        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
//        FlexibleYearMonth サービス提供年月 = paramter.getServiceTeikyoYM();
//        RString 整理番号 = paramter.getSeiriNp();
//        FlexibleDate 決定年月日 = new FlexibleDate(div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toString());
//        RString 支給区分 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
//        Decimal 支払金額合計 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue();
//        Decimal 差額金額 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtSagakuGoke().getValue();
//        RString 増減理由等 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue();
//        RString 不支給理由等1 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue();
//        RString 不支給理由等2 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue();
//        int 増減単位 = div.getCcdShokanbaraiketteiJoho()
//                .getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue();
//        Decimal 前回支払金額 = Decimal.ZERO;
//        if (!div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue()
//                .equals(初期情報.get前回支払金額合計())) {
//            前回支払金額 = 初期情報.get前回支払金額合計();
//        }
//        List<SyokanbaraihiShikyuShinseiKetteEntity> entityList = new ArrayList<>();
//        List<dgSyokanbaraikete_Row> rowList = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
//                .getDgSyokanbaraikete().getDataSource();
//        if (rowList != null && !rowList.isEmpty()) {
//            for (dgSyokanbaraikete_Row row : rowList) {
//                SyokanbaraihiShikyuShinseiKetteEntity entity = SyokanbaraihiShikyuShinseiKetteEntity.createSelectByKeyParam(
//                        new JigyoshaNo(row.getJigyoshaNo()),
//                        row.getYoshikiNo(),
//                        row.getYoshikiNo(),
//                        row.getMeisaiNo(),
//                        row.getRenban(),
//                        row.getSagakuKingaku().getValue().intValue(),
//                        row.getTableKubun(),
//                        Integer.valueOf(row.getUpdateCount().toString()));
//                entityList.add(entity);
//            }
//            boolean flag = rowList.get(定数_0).getSagakuKingaku().isDisabled();
//            boolean 差額金額登録フラグ = true;
//            if (flag) {
//                差額金額登録フラグ = false;
//            }
//            SyokanbaraihiShikyuShinseiKetteParameter parameter = SyokanbaraihiShikyuShinseiKetteParameter.createSelectByKeyParam(
//                    被保険者番号,
//                    サービス提供年月,
//                    整理番号,
//                    決定年月日,
//                    支給区分,
//                    支払金額合計初期,
//                    支払金額合計,
//                    差額金額,
//                    増減理由等,
//                    不支給理由等1,
//                    不支給理由等2,
//                    増減単位,
//                    差額金額登録フラグ,
//                    画面モード,
//                    識別コード,
//                    entityList);
//            SyokanbaraihiShikyuShinseiKetteManager.createInstance().updKetteJoho(parameter, 証明書入力済フラグ, 前回支払金額);
//        }
//    }
    /**
     * 登録処理情報を返します。
     *
     * @param paramter ShoukanharaihishinseikensakuParameter
     * @param 支払金額合計初期 Decimal
     * @param 画面モード RString
     * @param 識別コード ShikibetsuCode
     * @param 証明書入力済フラグ ShomeishoNyuryokuFlag
     * @param dbJoho db情報
     * @return 登録処理情報
     */
    public ModoruEntity return登録処理情報(ShoukanharaihishinseikensakuParameter paramter, Decimal 支払金額合計初期,
            RString 画面モード, ShikibetsuCode 識別コード, ShomeishoNyuryokuFlag 証明書入力済フラグ, DbJohoViewState dbJoho) {
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
            return SyokanbaraihiShikyuShinseiKetteManager.createInstance().updKetteJoho(parameter, 証明書入力済フラグ, dbJoho);
        }
        return null;
    }

    /**
     * 申請書入力済区分の取得です。
     *
     * @param 申請書入力済フラグ
     * @return 申請書入力済区分
     */
    public RString get申請書入力済区分(RString 申請書入力済フラグ) {
        SyokanbaraihiShikyuShinseiManager manager = SyokanbaraihiShikyuShinseiManager.createInstance();
        return manager.償還決定情報InputCheck(申請書入力済フラグ);
    }

    /**
     *
     * @param 戻る情報 保存処理戻るの情報
     * @param dbJoho DB情報
     * @return 更新DB情報
     */
    public DbJohoViewState DB情報保存(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        if (dbJoho.get償還払支給判定結果() != null && 戻る情報.get償還払支給判定結果() != null) {
            更新償還払支給判定結果データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求集計データList() != null
                && !dbJoho.get償還払請求集計データList().isEmpty() && !戻る情報.get償還払請求集計データList().isEmpty()) {
            更新償還払請求集計データ(戻る情報, dbJoho);
        }
        if ((dbJoho.get償還払請求集計データList() == null && !戻る情報.get償還払請求集計データList().isEmpty())) {
            追加償還払請求集計データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求集計データList() != null
                && dbJoho.get償還払請求集計データList().isEmpty() && !戻る情報.get償還払請求集計データList().isEmpty()) {
            追加償還払請求集計データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求サービス計画200904データResultList() != null
                && !dbJoho.get償還払請求サービス計画200904データResultList().isEmpty()
                && !戻る情報.get償還払請求サービス計画200904データList().isEmpty()) {
            更新償還払請求サービス計画200904データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求サービス計画200604データResultList() != null
                && !dbJoho.get償還払請求サービス計画200604データResultList().isEmpty()
                && !戻る情報.get償還払請求サービス計画200604データList().isEmpty()) {
            更新償還払請求サービス計画200604データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求サービス計画200004データResultList() != null
                && !dbJoho.get償還払請求サービス計画200004データResultList().isEmpty()
                && !戻る情報.get償還払請求サービス計画200004データList().isEmpty()) {
            更新償還払請求サービス計画200004データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求食事費用データList() != null
                && !dbJoho.get償還払請求食事費用データList().isEmpty() && !戻る情報.get償還払請求食事費用データList().isEmpty()) {
            更新償還払請求食事費用データ(戻る情報, dbJoho);
        }
        if (dbJoho.get償還払請求特定入所者介護サービス費用データList() != null
                && !dbJoho.get償還払請求特定入所者介護サービス費用データList().isEmpty()
                && !戻る情報.get償還払請求特定入所者介護サービス費用データList().isEmpty()) {
            更新償還払請求特定入所者介護サービス費用データ(戻る情報, dbJoho);
        }
        return dbJoho;
    }

    private void 更新償還払支給判定結果データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        if (戻る情報.get償還払支給判定結果().get被保険者番号().equals(dbJoho.get償還払支給判定結果().get被保険者番号())
                && 戻る情報.get償還払支給判定結果().getサービス提供年月().equals(dbJoho.get償還払支給判定結果().getサービス提供年月())
                && 戻る情報.get償還払支給判定結果().get整理番号().equals(dbJoho.get償還払支給判定結果().get整理番号())) {
            ShokanHanteiKekkaBuilder builder = dbJoho.get償還払支給判定結果().createBuilderForEdit();
            builder.set決定年月日(戻る情報.get償還払支給判定結果().get決定年月日());
            builder.set支給_不支給決定区分(戻る情報.get償還払支給判定結果().get支給_不支給決定区分());
            builder.set支払金額(戻る情報.get償還払支給判定結果().get支払金額());
            builder.set前回支払金額(戻る情報.get償還払支給判定結果().get前回支払金額());
            builder.set差額金額合計(戻る情報.get償還払支給判定結果().get差額金額合計());
            dbJoho.set償還払支給判定結果(builder.build().modified());
        }
    }

    private void 追加償還払請求集計データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        ArrayList<ShokanShukeiResult> results = new ArrayList<>();
        dbJoho.set償還払請求集計データList(results);
        for (ShokanShukei shukeiJoho : 戻る情報.get償還払請求集計データList()) {
            shukeiJoho.added();
            dbJoho.get償還払請求集計データList().add(new ShokanShukeiResult(shukeiJoho,
                    shukeiJoho.getサービス種類コード().value()
                    .concat(ServiceCategoryShurui.toValue(shukeiJoho.getサービス種類コード().value()).get略称())));
        }
    }

    private void 更新償還払請求集計データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        for (ShokanShukei shukeiJoho : 戻る情報.get償還払請求集計データList()) {
            int index = 0;
            for (int i = 0; i < dbJoho.get償還払請求集計データList().size(); i++) {
                if (shukeiJoho.get被保険者番号().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().get被保険者番号())
                        && shukeiJoho.getサービス提供年月().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().getサービス提供年月())
                        && shukeiJoho.get整理番号().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().get整理番号())
                        && shukeiJoho.get事業者番号().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().get事業者番号())
                        && shukeiJoho.get様式番号().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().get様式番号())
                        && shukeiJoho.get明細番号().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().get明細番号())
                        && shukeiJoho.get連番().equals(dbJoho.get償還払請求集計データList().get(i).getShukei().get連番())) {
                    dbJoho.get償還払請求集計データList().add(i, new ShokanShukeiResult(shukeiJoho,
                            dbJoho.get償還払請求集計データList().get(i).getServiceShuruiRyakusho()));
                    dbJoho.get償還払請求集計データList().remove(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                shukeiJoho.added();
                dbJoho.get償還払請求集計データList().add(new ShokanShukeiResult(shukeiJoho,
                        shukeiJoho.getサービス種類コード().value()
                        .concat(ServiceCategoryShurui.toValue(shukeiJoho.getサービス種類コード().value()).get略称())));
            }
        }
    }

    private void 更新償還払請求サービス計画200904データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        for (ShokanServicePlan200904 service200904Joho : 戻る情報.get償還払請求サービス計画200904データList()) {
            int index = 0;
            for (int i = 0; i < dbJoho.get償還払請求サービス計画200904データResultList().size(); i++) {
                if (service200904Joho.get被保険者番号().equals(dbJoho.get償還払請求サービス計画200904データResultList()
                        .get(i).getEntity().get被保険者番号())
                        && service200904Joho.getサービス提供年月().equals(dbJoho.get償還払請求サービス計画200904データResultList()
                                .get(i).getEntity().getサービス提供年月())
                        && service200904Joho.get整理番号().equals(dbJoho.get償還払請求サービス計画200904データResultList()
                                .get(i).getEntity().get整理番号())
                        && service200904Joho.get事業者番号().equals(dbJoho.get償還払請求サービス計画200904データResultList()
                                .get(i).getEntity().get事業者番号())
                        && service200904Joho.get様式番号().equals(dbJoho.get償還払請求サービス計画200904データResultList().get(i)
                                .getEntity().get様式番号())
                        && service200904Joho.get明細番号().equals(dbJoho.get償還払請求サービス計画200904データResultList().get(i)
                                .getEntity().get明細番号())
                        && service200904Joho.get連番().equals(dbJoho.get償還払請求サービス計画200904データResultList().get(i)
                                .getEntity().get連番())) {
                    dbJoho.get償還払請求サービス計画200904データResultList().add(i, new ShokanServicePlan200904Result(service200904Joho,
                            dbJoho.get償還払請求サービス計画200904データResultList()
                            .get(i).getServiceName()));
                    dbJoho.get償還払請求サービス計画200904データResultList().remove(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                service200904Joho.added();
                dbJoho.get償還払請求サービス計画200904データResultList().add(new ShokanServicePlan200904Result(service200904Joho,
                        ServiceBunrui.toValue(service200904Joho.toEntity().getServiceCode().value()).get名称()));
            }
        }
    }

    private void 更新償還払請求サービス計画200604データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        for (ShokanServicePlan200604 service200604Joho : 戻る情報.get償還払請求サービス計画200604データList()) {
            int index = 0;
            for (int i = 0; i < dbJoho.get償還払請求サービス計画200604データResultList().size(); i++) {
                if (service200604Joho.get被保険者番号().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                        .getEntity().get被保険者番号())
                        && service200604Joho.getサービス提供年月().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                                .getEntity().getサービス提供年月())
                        && service200604Joho.get整理番号().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                                .getEntity().get整理番号())
                        && service200604Joho.get事業者番号().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                                .getEntity().get事業者番号())
                        && service200604Joho.get様式番号().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                                .getEntity().get様式番号())
                        && service200604Joho.get明細番号().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                                .getEntity().get明細番号())
                        && service200604Joho.get連番().equals(dbJoho.get償還払請求サービス計画200604データResultList().get(i)
                                .getEntity().get連番())) {
                    dbJoho.get償還払請求サービス計画200604データResultList().add(i, new ShokanServicePlan200604Result(service200604Joho,
                            dbJoho.get償還払請求サービス計画200604データResultList().get(i).getServiceName()));
                    dbJoho.get償還払請求サービス計画200604データResultList().remove(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                service200604Joho.added();
                dbJoho.get償還払請求サービス計画200604データResultList().add(new ShokanServicePlan200604Result(service200604Joho,
                        ServiceBunrui.toValue(service200604Joho.toEntity().getServiceCode().value()).get名称()));
            }
        }
    }

    private void 更新償還払請求サービス計画200004データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        for (ShokanServicePlan200004 service200004Joho : 戻る情報.get償還払請求サービス計画200004データList()) {
            int index = 0;
            for (int i = 0; i < dbJoho.get償還払請求サービス計画200004データResultList().size(); i++) {
                if (service200004Joho.get被保険者番号().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                        .getEntity().get被保険者番号())
                        && service200004Joho.getサービス提供年月().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                                .getEntity().getサービス提供年月())
                        && service200004Joho.get整理番号().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                                .getEntity().get整理番号())
                        && service200004Joho.get事業者番号().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                                .getEntity().get事業者番号())
                        && service200004Joho.get様式番号().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                                .getEntity().get様式番号())
                        && service200004Joho.get明細番号().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                                .getEntity().get明細番号())
                        && service200004Joho.get連番().equals(dbJoho.get償還払請求サービス計画200004データResultList().get(i)
                                .getEntity().get連番())) {
                    dbJoho.get償還払請求サービス計画200004データResultList().add(i, new ShokanServicePlan200004Result(service200004Joho,
                            dbJoho.get償還払請求サービス計画200004データResultList().get(i).getServiceName()));
                    dbJoho.get償還払請求サービス計画200004データResultList().remove(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                service200004Joho.added();
                dbJoho.get償還払請求サービス計画200004データResultList().add(new ShokanServicePlan200004Result(service200004Joho,
                        ServiceBunrui.toValue(service200004Joho.toEntity().getServiceCode().value()).get名称()));
            }
        }
    }

    private void 更新償還払請求食事費用データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        for (ShokanShokujiHiyo shokujiHiyo : 戻る情報.get償還払請求食事費用データList()) {
            int index = 0;
            for (int i = 0; i < dbJoho.get償還払請求食事費用データList().size(); i++) {
                if (shokujiHiyo.get被保険者番号().equals(dbJoho.get償還払請求食事費用データList().get(i).get被保険者番号())
                        && shokujiHiyo.getサービス提供年月().equals(dbJoho.get償還払請求食事費用データList().get(i).getサービス提供年月())
                        && shokujiHiyo.get整理番号().equals(dbJoho.get償還払請求食事費用データList().get(i).get整理番号())
                        && shokujiHiyo.get事業者番号().equals(dbJoho.get償還払請求食事費用データList().get(i).get事業者番号())
                        && shokujiHiyo.get様式番号().equals(dbJoho.get償還払請求食事費用データList().get(i).get様式番号())
                        && shokujiHiyo.get明細番号().equals(dbJoho.get償還払請求食事費用データList().get(i).get明細番号())
                        && shokujiHiyo.get連番().equals(dbJoho.get償還払請求食事費用データList().get(i).get連番())) {
                    dbJoho.get償還払請求食事費用データList().add(i, shokujiHiyo);
                    dbJoho.get償還払請求食事費用データList().remove(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                shokujiHiyo.added();
                dbJoho.get償還払請求食事費用データList().add(shokujiHiyo);
            }
        }
    }

    private void 更新償還払請求特定入所者介護サービス費用データ(ModoruEntity 戻る情報, DbJohoViewState dbJoho) {
        for (ShokanTokuteiNyushoshaKaigoServiceHiyo serviceHiyo : 戻る情報.get償還払請求特定入所者介護サービス費用データList()) {
            int index = 0;
            for (int i = 0; i < dbJoho.get償還払請求特定入所者介護サービス費用データList().size(); i++) {
                if (serviceHiyo.get被保険者番号().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).get被保険者番号())
                        && serviceHiyo.getサービス提供年月().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).getサービス提供年月())
                        && serviceHiyo.get整理番号().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).get整理番号())
                        && serviceHiyo.get事業者番号().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).get事業者番号())
                        && serviceHiyo.get様式番号().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).get様式番号())
                        && serviceHiyo.get明細番号().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).get明細番号())
                        && serviceHiyo.get連番().equals(dbJoho.get償還払請求特定入所者介護サービス費用データList().get(i).get連番())) {
                    dbJoho.get償還払請求特定入所者介護サービス費用データList().add(i, serviceHiyo);
                    dbJoho.get償還払請求特定入所者介護サービス費用データList().remove(i + 1);
                    index++;
                }
            }
            if (index == 0) {
                serviceHiyo.added();
                dbJoho.get償還払請求特定入所者介護サービス費用データList().add(serviceHiyo);
            }
        }
    }
}
