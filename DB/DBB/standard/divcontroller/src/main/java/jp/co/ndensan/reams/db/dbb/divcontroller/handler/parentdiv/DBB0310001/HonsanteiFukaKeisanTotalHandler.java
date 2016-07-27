/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0310001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.basic.TsuchishoUchiwakeJoken;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.BatchTyouhyouResult;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.HonsanteifukaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka.TyouhyouParameter;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchisho.notsu.ShutsuryokuKiKoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.HonsanteiFukaKeisanTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.dgHonsanteiShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.dgKanrijoho1_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.dgKanrijoho2_Row;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteifuka.Honsanteifuka;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.tsuchisho.notsu.ShutsuryokuKiKohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定賦課計算クラスです。
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonsanteiFukaKeisanTotalHandler {

    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_課税 = new RString("課税");
    private static final RString 定数_非課税 = new RString("非課税");
    private static final RString 定数_徴収する = new RString("徴収する");
    private static final RString 定数_徴収しない = new RString("徴収しない");
    private static final RString FORMAT_M = new RString("_");
    private static final RString 出力方法_別々 = new RString("別々出力");
    private static final RString 出力方法_全件 = new RString("全件出力");
    private static final RString 項目名 = new RString("当初出力_出力方法");
    private static final RString 定数_円 = new RString("円");
    private static final RString FORMAT_L = new RString("円（");
    private static final RString FORMAT_R = new RString("）");
    private static final RString 管理項目名_1 = new RString("年額端数");
    private static final RString 管理項目名_2 = new RString("未申告課税区分");
    private static final RString 管理項目名_3 = new RString("調査中課税区分");
    private static final RString 管理項目名_4 = new RString("課税取消課税区分");
    private static final RString 管理項目名_5 = new RString("特徴_期別端数");
    private static final RString 管理項目名_6 = new RString("特徴ー8月特徴開始前の普通徴収");
    private static final RString 管理項目名_7 = new RString("特徴ー10月特徴開始前の普通徴収");
    private static final RString 管理項目名_8 = new RString("普徴_期別端数");
    private static final int 方法区分_切上げ = 1;
    private static final int 方法区分_切捨て = 2;
    private static final int 方法区分_四捨五入 = 3;
    private static final RString 方法区分_1 = new RString("切上げ");
    private static final RString 方法区分_2 = new RString("切捨て");
    private static final RString 方法区分_3 = new RString("四捨五入");
    private static final RString 実行する_賦課計算 = new RString("btnSantei");
    private static final RString 実行する_通知書 = new RString("btnTsuchishoSakusei");
    private static final RString 状況_未 = new RString("未");
    private static final RString 状況_済 = new RString("済");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private final HonsanteiFukaKeisanTotalDiv div;

    /**
     * コンストメソッドです。
     *
     * @param div div
     */
    public HonsanteiFukaKeisanTotalHandler(HonsanteiFukaKeisanTotalDiv div) {
        this.div = div;
    }

    /**
     * 調定期を設定するメソッドです。
     *
     * @param 更正月 Kitsuki
     */
    public void set調定期(Kitsuki 更正月) {
        RString 調定期 = 更正月.get表記().asX期括弧X月().replace(FORMAT_M, 定数_0);
        List<KeyValueDataSource> keyValueDataSource = new ArrayList<>();
        keyValueDataSource.add(new KeyValueDataSource(更正月.get期(), 調定期));
        div.getShoriJokyo().getHonsanteiShoriNaiyo().getDdlChoteiKi().setDataSource(keyValueDataSource);
        div.getShoriJokyo().getHonsanteiShoriNaiyo().getDdlChoteiKi().setSelectedKey(更正月.get期());
    }

    /**
     * 処理状態を設定するメソッドです。
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     */
    public void set処理状態(RString 遷移元区分, FlexibleYear 調定年度) {

        Honsanteifuka honsanteifuka = Honsanteifuka.createInstance();
        List<ShoriDateKanri> shoriDateKanriList = honsanteifuka.getShoriDateKanriList(遷移元区分, 調定年度);
        List<dgHonsanteiShoriKakunin_Row> dgHonsanteiShoriKakuninList = new ArrayList<>();
        if (shoriDateKanriList == null || shoriDateKanriList.isEmpty()) {
            dgHonsanteiShoriKakunin_Row row = new dgHonsanteiShoriKakunin_Row();
            if (定数_0.equals(遷移元区分)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_賦課計算, true);
                row.setTxtShoriMei(ShoriName.特徴対象者同定.get名称());
                row.setTxtJokyo(状況_未);
                row.setTxtShoriNichiji(RString.EMPTY);
                dgHonsanteiShoriKakuninList.add(row);
                row = new dgHonsanteiShoriKakunin_Row();
                row.setTxtShoriMei(ShoriName.依頼金額計算.get名称());
                row.setTxtJokyo(状況_未);
                row.setTxtShoriNichiji(RString.EMPTY);
                dgHonsanteiShoriKakuninList.add(row);
            } else if (定数_1.equals(遷移元区分)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_通知書, true);
                row.setTxtShoriMei(ShoriName.本算定賦課.get名称());
                row.setTxtJokyo(状況_未);
                row.setTxtShoriNichiji(RString.EMPTY);
                dgHonsanteiShoriKakuninList.add(row);
            }
        } else {
            dgHonsanteiShoriKakuninList = set処理状態詳細(遷移元区分, shoriDateKanriList);
        }
        div.getShoriJokyo().getHonsanteiShoriKakunin().getDgHonsanteiShoriKakunin().setDataSource(dgHonsanteiShoriKakuninList);
    }

    private List<dgHonsanteiShoriKakunin_Row> set処理状態詳細(RString 遷移元区分, List<ShoriDateKanri> shoriDateKanriList) {
        boolean 活性区分 = false;
        List<dgHonsanteiShoriKakunin_Row> dgHonsanteiShoriKakuninList = new ArrayList<>();
        dgHonsanteiShoriKakunin_Row row;
        for (ShoriDateKanri shoriDateKanri : shoriDateKanriList) {
            row = new dgHonsanteiShoriKakunin_Row();
            row.setTxtShoriMei(shoriDateKanri.toEntity().getShoriName());
            if (shoriDateKanri.toEntity().getKijunTimestamp() == null || shoriDateKanri.toEntity().getKijunTimestamp().isEmpty()) {
                row.setTxtJokyo(状況_未);
                row.setTxtShoriNichiji(RString.EMPTY);
                活性区分 = true;
            } else {
                row.setTxtJokyo(状況_済);
                if (shoriDateKanri.toEntity().getKijunTimestamp() != null || !shoriDateKanri.toEntity().getKijunTimestamp().isEmpty()) {
                    row.setTxtShoriNichiji(shoriDateKanri.toEntity().getKijunTimestamp().getDate().wareki().toDateString()
                            .concat(RString.HALF_SPACE).concat(shoriDateKanri.toEntity().getKijunTimestamp().getRDateTime()
                                    .getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
                }
            }
            dgHonsanteiShoriKakuninList.add(row);
        }
        if (!活性区分) {
            if (定数_0.equals(遷移元区分)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_賦課計算, false);
            } else if (定数_1.equals(遷移元区分)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_通知書, false);
            }
        } else {
            if (定数_0.equals(遷移元区分)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_賦課計算, true);
            } else if (定数_1.equals(遷移元区分)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する_通知書, true);
            }
        }
        return dgHonsanteiShoriKakuninList;
    }

    /**
     * 管理情報を設定するメソッドです。
     *
     * @param 賦課年度 賦課年度
     */
    public void set管理情報(FlexibleYear 賦課年度) {

        set保険料(賦課年度);
        RDate 適用基準日 = RDate.getNowDate();
        List<dgKanrijoho2_Row> dgKanrijoho2List = new ArrayList<>();
        dgKanrijoho2_Row row = new dgKanrijoho2_Row();
        RStringBuilder builder = new RStringBuilder();
        row.setTxtKoumoku(管理項目名_1);
        RString 方法 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 年額端数 = builder.append(DecimalFormatter.toコンマ区切りRString(
                new Decimal(Integer.parseInt(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常,
                                        適用基準日, SubGyomuCode.DBB介護賦課).toString())), 0)).append(FORMAT_L)
                .append(get方法(方法)).append(FORMAT_R).toRString();
        row.setTxtNaiyo(年額端数);
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        row.setTxtKoumoku(管理項目名_2);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分, 適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(未申告課税区分)) {
            row.setTxtNaiyo(定数_課税);
        } else if (定数_2.equals(未申告課税区分)) {
            row.setTxtNaiyo(定数_非課税);
        }
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        row.setTxtKoumoku(管理項目名_3);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(所得調査中課税区分)) {
            row.setTxtNaiyo(定数_課税);
        } else if (定数_2.equals(所得調査中課税区分)) {
            row.setTxtNaiyo(定数_非課税);
        }
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        row.setTxtKoumoku(管理項目名_4);
        RString 課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(課税取消課税区分)) {
            row.setTxtNaiyo(定数_課税);
        } else if (定数_2.equals(課税取消課税区分)) {
            row.setTxtNaiyo(定数_非課税);
        }
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        builder = new RStringBuilder();
        row.setTxtKoumoku(管理項目名_5);
        RString 特徴_期別端数 = builder.append(DecimalFormatter.toコンマ区切りRString(
                new Decimal(Integer.parseInt(DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数,
                                        適用基準日, SubGyomuCode.DBB介護賦課).toString())), 0)).append(定数_円).toRString();
        row.setTxtNaiyo(特徴_期別端数);
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        row.setTxtKoumoku(管理項目名_6);
        RString 特徴開始前普通徴収_8月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_8月,
                適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴開始前普通徴収_8月)) {
            row.setTxtNaiyo(定数_徴収する);
        } else if (定数_0.equals(特徴開始前普通徴収_8月)) {
            row.setTxtNaiyo(定数_徴収しない);
        }
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        row.setTxtKoumoku(管理項目名_7);
        RString 特徴開始前普通徴収_10月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_10月,
                適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴開始前普通徴収_10月)) {
            row.setTxtNaiyo(定数_徴収する);
        } else if (定数_0.equals(特徴開始前普通徴収_10月)) {
            row.setTxtNaiyo(定数_徴収しない);
        }
        dgKanrijoho2List.add(row);
        row = new dgKanrijoho2_Row();
        builder = new RStringBuilder();
        row.setTxtKoumoku(管理項目名_8);
        RString 普徴_期別端数 = builder.append(DecimalFormatter.toコンマ区切りRString(
                new Decimal(Integer.parseInt(DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数,
                                        適用基準日, SubGyomuCode.DBB介護賦課).toString())), 0)).append(定数_円).toRString();
        row.setTxtNaiyo(普徴_期別端数);
        dgKanrijoho2List.add(row);
        div.getHonsanteiFukaKakunin().getHonsanteiKanrijoho().getDgKanrijoho2().setDataSource(dgKanrijoho2List);
    }

    private RString get方法(RString 方法) {
        switch (Integer.parseInt(方法.toString())) {
            case 方法区分_切上げ:
                return 方法区分_1;
            case 方法区分_切捨て:
                return 方法区分_2;
            case 方法区分_四捨五入:
                return 方法区分_3;
            default:
                return RString.EMPTY;
        }
    }

    /**
     * 保険料段階と保険料率（円）を設定するメソッドです。
     *
     * @param 賦課年度 賦課年度
     */
    private void set保険料(FlexibleYear 賦課年度) {

        HokenryoDankaiList 保険料段階 = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(賦課年度);
        if (保険料段階 != null && 保険料段階.asList() != null && !保険料段階.asList().isEmpty()) {
            List<HokenryoDankai> 所得段階List = 保険料段階.asList();
            List<dgKanrijoho1_Row> dgKanrijoho1List = new ArrayList<>();
            dgKanrijoho1_Row row;
            for (HokenryoDankai 所得段階 : 所得段階List) {
                row = new dgKanrijoho1_Row();
                row.setTxtHokenryoDankai(所得段階.get表記());
                row.setTxtHokenryoritsu(所得段階.get保険料率() == null ? RString.EMPTY : new RString(所得段階.get保険料率().toString()));
                dgKanrijoho1List.add(row);
            }
            div.getHonsanteiFukaKakunin().getHonsanteiKanrijoho().getDgKanrijoho1().setDataSource(dgKanrijoho1List);
        }
    }

    /**
     * 帳票作成個別情報を設定するメソッドです。
     *
     * @param 期 int
     * @param 算定期 RString
     * @param 遷移元区分 RString
     * @param 調定年度 FlexibleYear
     */
    public void set帳票作成個別情報(int 期, RString 算定期, RString 遷移元区分, FlexibleYear 調定年度) {

        div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getCcdBunshoBangoKetteiTsuchi().get文書番号();
        Honsanteifuka honsanteifuka = Honsanteifuka.createInstance();
        List<TsuchishoUchiwakeJoken> tsuchishoUchiwakeJokenList;
        RString 打ち分け条件 = div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtKetteiTsuchiYousikiSettei().getValue();
        if (打ち分け条件 == null || 打ち分け条件.isEmpty()) {
            tsuchishoUchiwakeJokenList = honsanteifuka.getutiwakehouhoujyoho1();
        } else {
            tsuchishoUchiwakeJokenList = honsanteifuka.getutiwakehouhoujyoho2(打ち分け条件);
        }
        if (tsuchishoUchiwakeJokenList != null && !tsuchishoUchiwakeJokenList.isEmpty()) {
            div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtKetteiTsuchiYousikiSettei()
                    .setValue(tsuchishoUchiwakeJokenList.get(0).get打ち分け条件());
        }
        FukaNokiResearcher 賦課納期取得 = FukaNokiResearcher.createInstance();
        Noki 普徴納期 = 賦課納期取得.get普徴納期(期);
        div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtNotsuHakkoYMD2()
                .setValue(new RDate(普徴納期.get通知書発行日().wareki().toDateString().toString()));
        set出力方法(調定年度);
        set出力期(算定期, 調定年度);
    }

    private void set出力方法(FlexibleYear 調定年度) {
        Honsanteifuka honsanteifuka = Honsanteifuka.createInstance();
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = honsanteifuka.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課,
                納入通知書_帳票分類ID, 調定年度, 項目名);

        if (chohyoSeigyoHanyo != null) {
            if (定数_0.equals(chohyoSeigyoHanyo.get設定値())) {
                div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtShutsuryokuHoho()
                        .setValue(出力方法_別々);
            } else if (定数_1.equals(chohyoSeigyoHanyo.get設定値())) {
                div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtShutsuryokuHoho()
                        .setValue(出力方法_全件);
            }
        }
    }

    private void set出力期(RString 算定期, FlexibleYear 調定年度) {
        List<BatchTyouhyouResult> 帳票IDList = get通知書帳票ID(算定期, 調定年度);
        boolean 期毎タイプフラグ = false;
        if (帳票IDList != null && !帳票IDList.isEmpty()) {
            for (BatchTyouhyouResult 帳票ID : 帳票IDList) {
                if (納入通知書_帳票分類ID.equals(帳票ID.getEntity().get帳票分類ID())
                        && (ReportIdDBB.DBB100045.getReportId().equals(帳票ID.getEntity().get帳票ID())
                        || ReportIdDBB.DBB100046.getReportId().equals(帳票ID.getEntity().get帳票ID())
                        || ReportIdDBB.DBB100063.getReportId().equals(帳票ID.getEntity().get帳票ID())
                        || ReportIdDBB.DBB100064.getReportId().equals(帳票ID.getEntity().get帳票ID()))) {
                    期毎タイプフラグ = true;
                }
            }
        }
        ShutsuryokuKiKohoFactory shutsuryokuKiKohoFactory = ShutsuryokuKiKohoFactory.createInstance(調定年度);
        List<ShutsuryokuKiKoho> 出力期候補List = shutsuryokuKiKohoFactory.create出力期候補(期毎タイプフラグ, false);

        if (出力期候補List != null && !出力期候補List.isEmpty()) {
            List<KeyValueDataSource> keyValueDataSource = new ArrayList<>();
            for (ShutsuryokuKiKoho 出力期候補 : 出力期候補List) {
                keyValueDataSource.add(new KeyValueDataSource(出力期候補.get期月().get期(), 出力期候補.get表示文字列()));
            }
            div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getDdlNotsuShuturyokuki2().setDataSource(keyValueDataSource);
            div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getDdlNotsuShuturyokuki2().setSelectedKey(算定期);
        }
    }

    /**
     * 入力チェックメソッドです。
     *
     * @return エラーメッセージ
     */
    public ValidationMessageControlPairs set入力チェック() {

        return new HonsanteiFukaKeisanTotalValidationHandler(div).set入力チェック();
    }

    /**
     * 各通知書の帳票IDを取得するメソッドです。
     *
     * @param 調定期 RString
     * @param 調定年度 FlexibleYear
     * @return 帳票ID List<BatchTyouhyouResult>
     *
     */
    private List<BatchTyouhyouResult> get通知書帳票ID(RString 調定期, FlexibleYear 調定年度) {

        List<TyouhyouParameter> parameterList = new ArrayList<>();
        TyouhyouParameter chohyoMeter;
        Map<RString, RString> 帳票一覧Map = div.getHonsanteiChohyoHakko2().getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = 帳票一覧Map.entrySet();
        Iterator<Map.Entry<RString, RString>> it = set.iterator();
        while (it.hasNext()) {
            chohyoMeter = new TyouhyouParameter();
            Map.Entry<RString, RString> entry = it.next();
            chohyoMeter.set帳票分類ID(new ReportId(entry.getKey()));
            chohyoMeter.set出力順ID(entry.getValue());
            parameterList.add(chohyoMeter);
        }
        Honsanteifuka honsanteifuka = Honsanteifuka.createInstance();
        return honsanteifuka.getChohyoID(調定年度, 調定期, parameterList);
    }

    /**
     * バッチパラメータの設定するメソッドです。
     *
     * @param 調定年度 RString
     * @param 算定期 RString
     * @param 遷移元区分 RString
     * @return HonsanteifukaBatchParameter バッチパラメータ
     *
     */
    public HonsanteifukaBatchParameter setバッチパラメータ(RString 調定年度, RString 算定期, RString 遷移元区分) {

        List<TyouhyouParameter> parameterList = new ArrayList<>();
        TyouhyouParameter chohyoMeter;
        Map<RString, RString> 帳票一覧Map = div.getHonsanteiChohyoHakko2().getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = 帳票一覧Map.entrySet();
        Iterator<Map.Entry<RString, RString>> it = set.iterator();
        while (it.hasNext()) {
            chohyoMeter = new TyouhyouParameter();
            Map.Entry<RString, RString> entry = it.next();
            chohyoMeter.set帳票分類ID(new ReportId(entry.getKey()));
            chohyoMeter.set出力順ID(entry.getValue());
            parameterList.add(chohyoMeter);
        }
        HonsanteifukaParameter paramter = new HonsanteifukaParameter();
        paramter.set調定年度(new FlexibleYear(調定年度));
        paramter.set賦課年度(new FlexibleYear(調定年度));
        paramter.set資格基準日(FlexibleDate.getNowDate());
        paramter.set特徴_出力対象(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getRadTokuKaishiTsuchiTaisho2().getSelectedValue());
        paramter.set特徴_発行日(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD2().getValue());
        paramter.set文書番号(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getCcdBunshoBangoKetteiTsuchi().get文書番号());
        paramter.set決定変更_発行日(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtKetteTsuchiHakkoYMD2().getValue());
        paramter.set納入_出力方法(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtShutsuryokuHoho().getValue());
        paramter.set出力期(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getDdlNotsuShuturyokuki2().getSelectedValue());
        paramter.set納入_対象者(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getChkNotsuTaishosha2().getSelectedValues());
        paramter.set納入_発行日(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtNotsuHakkoYMD2().getValue());
        paramter.set納入_生活保護対象者をまとめて先頭に出力(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho()
                .getRadNotsuSeikatsuHogo2().getSelectedValue());
        paramter.set納入_ページごとに山分け(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getRadNotsuYamawake2().getSelectedValue());
        paramter.set打分け条件情報(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtKetteiTsuchiYousikiSettei().getValue());

        if (定数_0.equals(遷移元区分)) {
            paramter.set一括発行起動フラグ(false);
        } else if (定数_1.equals(遷移元区分)) {
            paramter.set一括発行起動フラグ(true);
        }
        paramter.set算定期(算定期);
        paramter.set出力帳票一覧List(parameterList);
        Honsanteifuka honsanteifuka = Honsanteifuka.createInstance();
        return honsanteifuka.createhonsanteifukaBatchParameter(paramter);
    }
}
