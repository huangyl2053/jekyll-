/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307ReportSource;
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
 * 介護事業状況報告年報・一般状況（様式1-5）のEditorです。
 *
 * @reamsid_L DBU-5600-170 wangrenze
 */
public class JigyohokokuCompYoshiki15307Editor implements IJigyohokokuCompYoshiki15307Editor {

    private final JigyohokokuCompYoshiki15307Entity item;
    private static final RString 給付集計区分が1 = new RString("1");
    private static final RString 給付集計区分が2 = new RString("2");
    private static final RString 給付集計区分が3 = new RString("3");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JigyohokokuCompYoshiki15307Entity}
     */
    protected JigyohokokuCompYoshiki15307Editor(JigyohokokuCompYoshiki15307Entity item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki15307ReportSource edit(JigyohokokuCompYoshiki15307ReportSource source) {
        source.printTimeStamp = get作成日時();
        source.shukeiKubun = new RString("年報");
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("("));
        builder.append(getパターン107(item.get集計年度()));
        builder.append(new RString("年度分）"));
        builder.append(getパターン62(item.get集計期間FROM()));
        builder.append(new RString("～"));
        builder.append(getパターン62(item.get集計期間TO()));
        if (給付集計区分が1.equals(item.get給付集計区分())) {
            source.shuukeiHani = builder.toRString();
            source.kyufuKubun = new RString("現物分");
        } else if (給付集計区分が2.equals(item.get給付集計区分())) {
            builder.append(new RString("(審査)"));
            source.shuukeiHani = builder.toRString();
            source.kyufuKubun = new RString("償還審査分");
        } else if (給付集計区分が3.equals(item.get給付集計区分())) {
            builder.append(new RString("(決定)"));
            source.shuukeiHani = builder.toRString();
            source.kyufuKubun = new RString("償還決定分");
        }
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        return source;
    }

    private RString get作成日時() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = item.get作成日時();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(作成);
        return printTimeStampSb.toRString();
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
