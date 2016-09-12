/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki300103;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103ReportSource;
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
 * 介護事業状況報告年報（様式1-2）のEditorです。
 *
 * @reamsid_L DBU-5600-120 lishengli
 */
public class JigyohokokuCompYoshiki300103Editor implements IJigyohokokuCompYoshiki300103Editor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshiki300103Data item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshiki300103Data
     */
    protected JigyohokokuCompYoshiki300103Editor(JigyohokokuCompYoshiki300103Data item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki300103ReportSource edit(JigyohokokuCompYoshiki300103ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki300103ReportSource editSource(JigyohokokuCompYoshiki300103ReportSource source) {
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
        source.hyo1Title = item.get表1のタイトル();
        source.hyo2Title1 = item.get表2のタイトル1();
        source.hyo3Title = item.get表3のタイトル();
        source.hyo2Title2 = item.get表2のタイトル2();
        source.hyo1ShinseishaKensu1 = item.get介護老人福祉施設の申請件数();
        source.hyo1ShinseishaKensu2 = item.get介護老人保健施設の申請件数();
        source.hyo1ShinseishaKensu3 = item.get介護療養型医療施設の申請件数();
        source.hyo1ShinseishaKensu4 = item.get地域密着型介護老人福祉施設入居者生活介護の申請件数();
        source.hyo1ShinseishaKensu5 = item.getその他の申請件数();
        source.hyo1ShinseishaKensu6 = item.get合計の申請件数();
        source.hyo3ShinseishaKensu = item.get特定負担限度額の申請件数();
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
