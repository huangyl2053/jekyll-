/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152old;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReportSource;
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
 * @reamsid_L DBU-5550-040 dangjingjing
 */
public class JigyohokokuCompYoshiki152OldEditor implements IJigyohokokuCompYoshiki152OldEditor {

    private static final int 年度 = 4;
    private final JigyohokokuCompYoshiki152OldData data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki152OldData
     */
    public JigyohokokuCompYoshiki152OldEditor(JigyohokokuCompYoshiki152OldData data) {
        this.data = data;
    }

    @Override
    public JigyohokokuCompYoshiki152OldReportSource edit(JigyohokokuCompYoshiki152OldReportSource source) {
        return editsSource(source);
    }

    private JigyohokokuCompYoshiki152OldReportSource editsSource(JigyohokokuCompYoshiki152OldReportSource source) {
        source.printTimeStamp = data.getプリント日時();
        source.shukeiKubun = data.get集計区分();
        source.shuukeiHani = set集計範囲(data.get集計範囲());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.kyufuKubun = set給付集計区分(data.get給付区分());
        return source;
    }

    private RString set集計範囲(RString 集計範囲) {
        if (RString.isNullOrEmpty(集計範囲)) {
            return RString.EMPTY;
        }
        RStringBuilder 集計範囲_SJ = new RStringBuilder();
        集計範囲_SJ.append(new RString("("));
        FlexibleYear 集計範囲_年度 = new FlexibleYear(集計範囲.substring(0, 年度));
        FlexibleYearMonth 集計範囲_M = new FlexibleYearMonth(集計範囲);
        集計範囲_SJ.append(集計範囲_年度.wareki().eraType(EraType.KANJI).getYear());
        集計範囲_SJ.append(new RString("年度"));
        集計範囲_SJ.append(集計範囲_M.wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).getMonth());
        集計範囲_SJ.append(new RString("分)"));
        return 集計範囲_SJ.toRString();
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

}
