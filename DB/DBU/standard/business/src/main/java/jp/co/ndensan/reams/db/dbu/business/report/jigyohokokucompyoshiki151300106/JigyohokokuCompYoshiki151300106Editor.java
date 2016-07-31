/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki151300106;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151300106.JigyohokokuCompYoshiki151300106ReportSource;
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
 * 介護事業状況報告年報（様式1-5）のEditorクラスです。
 *
 * @reamsid_L DBU-5600-150 lishengli
 */
public class JigyohokokuCompYoshiki151300106Editor implements IJigyohokokuCompYoshiki151300106Editor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshiki151300106Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki151300106Data
     */
    protected JigyohokokuCompYoshiki151300106Editor(JigyohokokuCompYoshiki151300106Data data) {
        this.data = data;
    }

    @Override
    public JigyohokokuCompYoshiki151300106ReportSource edit(JigyohokokuCompYoshiki151300106ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki151300106ReportSource editSource(JigyohokokuCompYoshiki151300106ReportSource source) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = data.get処理日時();
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
        source.printTimeStamp = printTimeStampSb.toRString();
        if (月報.equals(data.get年報月報区分())) {
            source.shukeiKubun = new RString("月報");
        } else if (年報.equals(data.get年報月報区分())) {
            source.shukeiKubun = new RString("年報");
        }
        source.shuukeiHani = get集計範囲();
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        return source;
    }

    private RString get集計範囲() {
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("（"));
        集計範囲_SB.append(getパターン107(data.get集計年度()));
        集計範囲_SB.append(new RString("年度分）"));
        集計範囲_SB.append(getパターン62(data.get集計期間FROM()));
        集計範囲_SB.append(new RString("～"));
        集計範囲_SB.append(getパターン62(data.get集計期間TO()));
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
