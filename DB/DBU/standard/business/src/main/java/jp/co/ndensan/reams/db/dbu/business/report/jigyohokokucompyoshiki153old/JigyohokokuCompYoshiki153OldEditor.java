/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153old;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldChange;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldReportSource;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.HokenshaJohoConfig;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のEditorです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153OldEditor implements IJigyohokokuCompYoshiki153OldEditor {

    private static final int 年度 = 4;
    private final JigyohokokuCompYoshiki153OldData data;
    private final JigyohokokuCompYoshiki153OldChange change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki153OldData
     * @param change JigyohokokuCompYoshiki153OldChange
     */
    public JigyohokokuCompYoshiki153OldEditor(JigyohokokuCompYoshiki153OldData data, JigyohokokuCompYoshiki153OldChange change) {
        this.change = change;
        this.data = data;
    }

    @Override
    public JigyohokokuCompYoshiki153OldReportSource edit(JigyohokokuCompYoshiki153OldReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki153OldReportSource editSource(JigyohokokuCompYoshiki153OldReportSource source) {
        List<RString> 保険者 = get保険者();
        source.printTimeStamp = data.getプリント日時();
        source.shukeiKubun = data.get集計区分();
        source.shuukeiHani = set集計範囲(data.get集計範囲());
        source.hokenshaNo = 保険者.get(1);
        source.hokenshaName = 保険者.get(0);
        source.kyufuKubun = set給付集計区分(data.get給付区分());
        source.list_1 = change.getList_1();
        source.list_2 = change.getList_2();
        source.list_3 = change.getList_3();
        source.list_4 = change.getList_4();
        source.list_5 = change.getList_5();
        source.list_6 = change.getList_6();
        source.list_7 = change.getList_7();
        source.list_8 = change.getList_8();
        source.list_9 = change.getList_9();
        source.list_10 = change.getList_10();
        source.list_11 = change.getList_11();
        source.list_12 = change.getList_12();
        return source;
    }

    private RString set集計範囲(RString 集計範囲) {
        if (RString.isNullOrEmpty(集計範囲)) {
            return RString.EMPTY;
        }
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("("));
        FlexibleYear 集計範囲_年度 = new FlexibleYear(集計範囲.substring(0, 年度));
        FlexibleYearMonth 集計範囲_M = new FlexibleYearMonth(集計範囲);
        集計範囲_SB.append(集計範囲_年度.wareki().eraType(EraType.KANJI).getYear());
        集計範囲_SB.append(new RString("年度"));
        集計範囲_SB.append(集計範囲_M.wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).getMonth());
        集計範囲_SB.append(new RString("分)"));
        return 集計範囲_SB.toRString();
    }

    private RString set給付集計区分(RString 給付区分) {
        RStringBuilder 給付集計区分_GF = new RStringBuilder();
        if (new RString("1").equals(給付区分)) {
            給付集計区分_GF.append(new RString("現物"));
        } else if (new RString("2").equals(給付区分)) {
            給付集計区分_GF.append(new RString("償還(審査年月)"));
        } else if (new RString("3").equals(給付区分)) {
            給付集計区分_GF.append(new RString("償還(決定年月)"));
        }
        return 給付集計区分_GF.toRString();
    }

    private List<RString> get保険者() {
        List<RString> 保険者 = new ArrayList<>();
        HokenshaJohoConfig config = new HokenshaJohoConfig();
        if (config.get保険者名() != null) {
            保険者.add(config.get保険者名().value());
        } else {
            保険者.add(RString.EMPTY);
        }
        if (config.get保険者番号() != null) {
            保険者.add(config.get保険者番号().value());
        } else {
            保険者.add(RString.EMPTY);
        }
        return 保険者;
    }
}
