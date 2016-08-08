/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki26;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki26.JigyohokokuCompYoshiki26;
import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki26.JigyohokokuCompYoshiki26ReportSource;
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
 *
 * 介護事業状況報告月報（様式2-6）のEditorです。
 *
 * @reamsid_L DBU-5600-270 guoqilin
 */
public class JigyohokokuCompYoshiki26Editor implements IJigyohokokuCompYoshiki26Editor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private static final RString 現物分 = new RString("1");
    private static final RString 償還審査分 = new RString("2");
    private static final RString 償還決定分 = new RString("3");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshiki26 item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshiki26
     */
    protected JigyohokokuCompYoshiki26Editor(JigyohokokuCompYoshiki26 item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki26ReportSource edit(JigyohokokuCompYoshiki26ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki26ReportSource editSource(JigyohokokuCompYoshiki26ReportSource source) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = item.get処理日時();
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
        source.printTimeStamp = printTimeStampSb.toRString();
        source.yoshiki = item.get様式();
        if (月報.equals(item.get年報月報区分())) {
            source.shukeiKubun = new RString("月報");
        } else if (年報.equals(item.get年報月報区分())) {
            source.shukeiKubun = new RString("年報");
        }
        source.shuukeiHani = get集計範囲();
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        source.hyoTitle = item.getタイトル1();
        source.hyoSubTitle = item.getタイトル2();
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
