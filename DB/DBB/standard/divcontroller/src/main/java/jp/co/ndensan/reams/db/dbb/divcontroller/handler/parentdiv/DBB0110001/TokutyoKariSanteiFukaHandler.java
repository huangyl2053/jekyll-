/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.FukaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoKariOutputJoken;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.DBB0110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.TokutyoKariSanteiFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.dgKanrijoho1_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.dgKanrijoho2_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.dgTokutyoKariSanteiShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFuka;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.dgOutputChohyoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 画面設計_DBBGM33001_特徴仮算定賦課
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public final class TokutyoKariSanteiFukaHandler {

    private final TokutyoKariSanteiFukaDiv div;
    private final TokuchoKariSanteiFuka tokuchokarisanteifuka;
    private static final RString 状況済 = new RString("済");
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");
    private static final RString 状況未 = new RString("未");
    private static final RString 特徴仮算定賦課 = new RString("DBB0110001");
    private static final RString 特徴仮算定通知書一括発行 = new RString("DBB0110003");
    private static final RString 実行する = new RString("btnSantei");
    private static final RString 実行する1 = new RString("btnTsuchishoSakusei");
    private static final RString 年額基準年度 = new RString("年額基準年度");
    private static final RString 特徴開始計算方法6月 = new RString("6月特徴開始計算方法");
    private static final RString 当年度 = new RString("当年度");
    private static final RString 翌年度 = new RString("翌年度");
    private static final RString 年度 = new RString("年度");
    private static final RString 定値_L = new RString("(");
    private static final RString 定値_R = new RString(")");
//    private static final RString 特別徴収仮算定結果一覧表_帳票分類ID = new RString("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
//    private static final RString 特別徴収開始通知書_仮算定_帳票分類ID = new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM11 = 11;
    private static final int NUM19 = 19;

    private TokutyoKariSanteiFukaHandler(TokutyoKariSanteiFukaDiv div) {
        this.div = div;
        this.tokuchokarisanteifuka = TokuchoKariSanteiFuka.createInstance();
    }

    /**
     * TokutyoKariSanteiFukaHandlerを取得します。
     *
     * @param div 画面DIV
     * @return TokutyoKariSanteiFukaHandler
     */
    public static TokutyoKariSanteiFukaHandler of(TokutyoKariSanteiFukaDiv div) {
        return new TokutyoKariSanteiFukaHandler(div);
    }

    /**
     * 初期化のンメソッドです。
     *
     */
    public void initialize() {
        RDate nowDate = RDate.getNowDate();
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                nowDate, SubGyomuCode.DBB介護賦課));
        div.getShoriJokyo().getTokutyoKariSanteiShoriNaiyo().getTxtChoteiNendo().setDomain(調定年度);
        div.getShoriJokyo().getTokutyoKariSanteiShoriNaiyo().getTxtFukaNendo().setDomain(調定年度);
        RString 遷移元区分 = RString.EMPTY;
        if (DBB0110001StateName.特徴仮算定賦課.getName().equals(ResponseHolder.getState())) {
            遷移元区分 = 遷移元区分_0;
        } else if (DBB0110001StateName.通知書一括発行.getName().equals(ResponseHolder.getState())) {
            遷移元区分 = 遷移元区分_1;
        }
        HokenryoDankaiSettings 保険料段階取得Mgr = HokenryoDankaiSettings.createInstance();
        HokenryoDankaiList 保険料段階List = 保険料段階取得Mgr.get保険料段階ListIn(調定年度);
        List<KeyValueDataSource> list = new ArrayList();
        for (TokuchoKaishiTsuhishoKariOutputJoken tokuchokai : TokuchoKaishiTsuhishoKariOutputJoken.values()) {
            KeyValueDataSource keyvaluedatasource = new KeyValueDataSource();
            keyvaluedatasource.setKey(tokuchokai.get名称());
            keyvaluedatasource.setValue(tokuchokai.get名称());
            list.add(keyvaluedatasource);
        }
        div.getTokutyoKariSanteiFukaChohyoHakko().getTokutyoKariTsuchiKobetsuJoho().getRadTokuKaishiTsuchiTaisho2().setDataSource(list);
        div.getTokutyoKariSanteiFukaChohyoHakko().getTokutyoKariTsuchiKobetsuJoho().getRadTokuKaishiTsuchiTaisho2().setSelectedIndex(NUM0);
        List<ShoriDateKanri> 処理状況list = tokuchokarisanteifuka.getShoriDateKanriList(遷移元区分, 調定年度);
        List<dgTokutyoKariSanteiShoriKakunin_Row> rowlist = new ArrayList();
        if (遷移元区分_0.equals(遷移元区分)) {
            List<dgKanrijoho1_Row> 保険料RowLists = new ArrayList<>();
            for (HokenryoDankai hokenryodankai : 保険料段階List.asList()) {
                dgKanrijoho1_Row row = new dgKanrijoho1_Row();
                row.setTxtHokenryoDankai(hokenryodankai.get表記());
                row.setTxtHokenryoritsu(new RString(hokenryodankai.get保険料率().toString()));
                保険料RowLists.add(row);
            }
            div.getTokutyoKariSanteiKanriInfo().getDgKanrijoho1().setDataSource(保険料RowLists);
            List<dgKanrijoho2_Row> list2 = new ArrayList<>();
            dgKanrijoho2_Row 年額基準年度row = new dgKanrijoho2_Row();
            年額基準年度row.setTxtKoumoku(年額基準年度);
            if (TokuchoNengakuKijunNendo6Gatsu.当年度.getコード().equals(
                    DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_6月開始, nowDate.minusYear(
                                    nowDate.getYearValue() + NUM1 - 調定年度.getYearValue()), SubGyomuCode.DBB介護賦課))) {
                年額基準年度row.setTxtNaiyo(当年度.concat(定値_L).concat(new FlexibleYear(調定年度.minusYear(NUM1).toDateString().toString())
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString()).concat(年度).concat(定値_R));
            } else if (TokuchoNengakuKijunNendo6Gatsu.翌年度.getコード().equals(
                    DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_6月開始, nowDate.minusYear(
                                    nowDate.getYearValue() + NUM1 - 調定年度.getYearValue()), SubGyomuCode.DBB介護賦課))) {
                年額基準年度row.setTxtNaiyo(翌年度.concat(定値_L).concat(new FlexibleYear(調定年度.toDateString().toString())
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString()).concat(年度).concat(定値_R));
            }
            dgKanrijoho2_Row 特徴開始計算方法6月row = new dgKanrijoho2_Row();
            特徴開始計算方法6月row.setTxtKoumoku(特徴開始計算方法6月);
            特徴開始計算方法6月row.setTxtNaiyo(TokuchoIraikingakuKeisanHoho6Gatsu.toValue(DbBusinessConfig.get(
                    ConfigNameDBB.特別徴収_依頼金額計算方法_6月開始, nowDate, SubGyomuCode.DBB介護賦課)).get略称());
            list2.add(年額基準年度row);
            list2.add(特徴開始計算方法6月row);
            div.getTokutyoKariSanteiKanriInfo().getDgKanrijoho2().setDataSource(list2);
            div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 特徴仮算定賦課);
//            List<dgOutputChohyoIchiran_Row> 帳票作成List = div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧();
//            for (dgOutputChohyoIchiran_Row row : 帳票作成List) {
//                if (特別徴収仮算定結果一覧表_帳票分類ID.compareTo(row.getChohyoID()) == NUM0) {
            //TODO 特別徴収仮算定結果一覧表を選択し、チェックが外せない。
//                }
//            }
            RString shoriname = ShoriName.年度切替.get名称();
            dgTokutyoKariSanteiShoriKakunin_Row 処理状況row = getGridDate(処理状況list, shoriname);
            if (状況未.equals(処理状況row.getTxtJokyo())) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, true);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, false);
            }
            rowlist.add(処理状況row);
            div.getShoriJokyo().getTokuchoKarisanteiShoriKakunin().getDgTokutyoKariSanteiShoriKakunin().setDataSource(rowlist);
        } else if (遷移元区分_1.equals(遷移元区分)) {
            div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 特徴仮算定通知書一括発行);
//            List<dgOutputChohyoIchiran_Row> 帳票作成List = div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧();
//            for (dgOutputChohyoIchiran_Row row : 帳票作成List) {
//                if (特別徴収開始通知書_仮算定_帳票分類ID.compareTo(row.getChohyoID()) == NUM0) {
            //TODO  特別徴収開始通知書（仮算定）を選択し、チェックが外せない。
//                }
//            }
            RString shoriname = ShoriName.特徴仮算定賦課.get名称();
            dgTokutyoKariSanteiShoriKakunin_Row row = getGridDate(処理状況list, shoriname);
            rowlist.add(row);
            shoriname = ShoriName.特徴平準化_6月分_確定.get名称();
            dgTokutyoKariSanteiShoriKakunin_Row rowt = getGridDate(処理状況list, shoriname);
            if (状況済.equals(row.getTxtJokyo()) && 状況済.equals(rowt.getTxtJokyo())) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する1, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する1, true);
            }
            rowlist.add(rowt);
            div.getShoriJokyo().getTokuchoKarisanteiShoriKakunin().getDgTokutyoKariSanteiShoriKakunin().setDataSource(rowlist);
        }
    }

    private dgTokutyoKariSanteiShoriKakunin_Row getGridDate(List<ShoriDateKanri> 処理状況list, RString shoriname) {
        if (処理状況list == null || 処理状況list.isEmpty()) {
            return データがない制御(shoriname);
        }
        for (ShoriDateKanri shoridatekanri : 処理状況list) {
            if (shoriname.equals(shoridatekanri.get処理名())) {
                dgTokutyoKariSanteiShoriKakunin_Row newRow = new dgTokutyoKariSanteiShoriKakunin_Row();
                newRow.setTxtShoriMei(shoriname);
                if (shoridatekanri.get基準年月日() == null || shoridatekanri.get基準年月日().isEmpty()) {
                    newRow.setTxtJokyo(状況未);
                    newRow.setTxtShoriNichiji(RString.EMPTY);
                } else {
                    newRow.setTxtJokyo(状況済);
                    RString dateTemp = shoridatekanri.get基準日時().getDate().wareki().toDateString();
                    RString timeTemp = new RString(shoridatekanri.get基準日時().getRDateTime().toString().substring(NUM11, NUM19));
                    newRow.setTxtShoriNichiji(dateTemp.concat(RString.HALF_SPACE).concat(timeTemp));
                }
                return newRow;
            }
        }
        return データがない制御(shoriname);
    }

    private dgTokutyoKariSanteiShoriKakunin_Row データがない制御(RString shoriname) {
        dgTokutyoKariSanteiShoriKakunin_Row newRow = new dgTokutyoKariSanteiShoriKakunin_Row();
        newRow.setTxtShoriMei(shoriname);
        newRow.setTxtJokyo(状況未);
        newRow.setTxtShoriNichiji(RString.EMPTY);
        return newRow;
    }

    /**
     * parameterを生成する.
     *
     * @param div TokutyoKariSanteiFukaDiv
     * @return TokuchoKariSanteiParameter
     */
    public TokuchoKariSanteiParameter btncommon(TokutyoKariSanteiFukaDiv div) {
        FukaParameter param = new FukaParameter();
        param.set出力対象(div.getTokutyoKariSanteiFukaChohyoHakko().
                getTokutyoKariTsuchiKobetsuJoho().getRadTokuKaishiTsuchiTaisho2().getSelectedValue());
        if (div.getTokutyoKariSanteiFukaChohyoHakko().
                getTokutyoKariTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD2().getValue() != null) {
            param.set発行日(new FlexibleDate(div.getTokutyoKariSanteiFukaChohyoHakko().
                    getTokutyoKariTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD2().getValue().toDateString()));
        }
        param.set調定年度(div.getShoriJokyo().getTokutyoKariSanteiShoriNaiyo().getTxtChoteiNendo().getDomain());
        param.set賦課年度(div.getShoriJokyo().getTokutyoKariSanteiShoriNaiyo().getTxtFukaNendo().getDomain());
        List<dgOutputChohyoIchiran_Row> 出力帳票一覧List = div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧();
        param.set出力帳票一覧List(listChange(出力帳票一覧List));
        return tokuchokarisanteifuka.createTokuchoKariSanteiParameter(param);
    }

    private List<TokuchoKariSanteiEntity> listChange(List<dgOutputChohyoIchiran_Row> 出力帳票一覧List) {
        List<TokuchoKariSanteiEntity> 帳票InfoList = new ArrayList();
        for (dgOutputChohyoIchiran_Row row : 出力帳票一覧List) {
            if (row.getSelected()) {
                TokuchoKariSanteiEntity tokuchokarisanteientity = new TokuchoKariSanteiEntity();
                tokuchokarisanteientity.set出力順ID(row.getShutsuryokujunID());
                tokuchokarisanteientity.set帳票分類ID(new ReportId(row.getChohyoID()));
                tokuchokarisanteientity.set帳票名(row.getChohyoName());
                帳票InfoList.add(tokuchokarisanteientity);
            }
        }
        return 帳票InfoList;
    }
}
