/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho201;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshikinenno201.JigyohokokuCompYoshikinenho201Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho201.JigyohokokuCompYoshikinenho201ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告年報（様式2）のEditorです。
 *
 * @reamsid_L DBU-5600-180 zhaoran
 */
public class JigyohokokuCompYoshikinenho201Editor implements IJigyohokokuCompYoshikinenho201Editor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private static final RString 現物分 = new RString("1");
    private static final RString 償還審査分 = new RString("2");
    private static final RString 償還決定分 = new RString("3");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshikinenho201Data item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshikinenho201Data
     */
    protected JigyohokokuCompYoshikinenho201Editor(JigyohokokuCompYoshikinenho201Data item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshikinenho201ReportSource edit(JigyohokokuCompYoshikinenho201ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshikinenho201ReportSource editSource(JigyohokokuCompYoshikinenho201ReportSource source) {
        RStringBuilder printTimeStamp = new RStringBuilder();
        RDateTime printdate = item.get処理日時();
        printTimeStamp.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", printdate.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", printdate.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", printdate.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(作成);
        source.sakuseinichiji = printTimeStamp.toRString();
        source.yoshiki = item.get様式();
        if (月報.equals(item.get年報月報区分())) {
            source.shorikbn = new RString("月報");
        } else if (年報.equals(item.get年報月報区分())) {
            source.shorikbn = new RString("年報");
        }
        source.shukeihani = get集計範囲();
        source.hokenjano = item.get保険者番号();
        source.hokenjamei = item.get保険者名();
        source.title1 = item.getタイトル1();
        source.title2 = item.getタイトル2();
        source.title3 = item.getタイトル3();
        return source;
    }

    private RString get集計範囲() {
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("（"));
        集計範囲_SB.append(getパターン107(item.get集計年度()));
        集計範囲_SB.append(new RString("年度分）"));
        集計範囲_SB.append(getパターン62(item.get集計期間FROM()));
        集計範囲_SB.append(new RString("～"));
        集計範囲_SB.append(getパターン62(item.get集計期間TO()));
        if (現物分.equals(item.get給付集計区分())) {
            集計範囲_SB.append(RString.EMPTY);
        } else if (償還審査分.equals(item.get給付集計区分())) {
            集計範囲_SB.append(new RString("(審査)"));
        } else if (償還決定分.equals(item.get給付集計区分())) {
            集計範囲_SB.append(new RString("(決定)"));
        }
        return 集計範囲_SB.toRString();
    }

    private RString getパターン62(FlexibleYearMonth 年月) {
        if (年月 == null || 年月.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString getパターン107(FlexibleYear 集計年度) {
        if (集計年度 == null || 集計年度.isEmpty()) {
            return RString.EMPTY;
        }
        return 集計年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
    }
}
