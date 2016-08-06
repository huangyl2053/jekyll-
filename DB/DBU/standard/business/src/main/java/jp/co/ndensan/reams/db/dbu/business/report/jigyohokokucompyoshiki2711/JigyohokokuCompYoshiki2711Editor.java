/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2711;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711ReportSource;
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
 * 介護事業状況報告年報（様式2-7）Editorです。
 *
 * @reamsid_L DBU-5600-280 guoqilin
 */
public class JigyohokokuCompYoshiki2711Editor implements IJigyohokokuCompYoshiki2711Editor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshiki2711 data;
    private final JigyohokokuCompYoshiki2711Change change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki2711
     * @param change JigyohokokuCompYoshiki2711Change
     */
    protected JigyohokokuCompYoshiki2711Editor(JigyohokokuCompYoshiki2711 data, JigyohokokuCompYoshiki2711Change change) {
        this.data = data;
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki2711ReportSource edit(JigyohokokuCompYoshiki2711ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki2711ReportSource editSource(JigyohokokuCompYoshiki2711ReportSource source) {
        RDateTime printdate = data.get処理日時();
        source.printTimeStamp = get作成日時(printdate).toRString();
        source.shuukeiHani = get集計範囲();
        if (月報.equals(data.get年報月報区分())) {
            source.shukeiKubun = new RString("月報");
        } else if (年報.equals(data.get年報月報区分())) {
            source.shukeiKubun = new RString("年報");
        }
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.listLower_1 = change.getListLower_1();
        source.listLower_2 = change.getListLower_2();
        source.listLower_3 = change.getListLower_3();
        source.listUpper_1 = change.getListUpper_1();
        source.listUpper_2 = change.getListUpper_2();
        source.listUpper_3 = change.getListUpper_3();
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

    private RStringBuilder get作成日時(RDateTime time) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        if (time != null) {
            printTimeStampSb.append(time.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
            printTimeStampSb.append(RString.HALF_SPACE);
            printTimeStampSb.append(String.format("%02d", time.getHour()));
            printTimeStampSb.append(DATE_時);
            printTimeStampSb.append(String.format("%02d", time.getMinute()));
            printTimeStampSb.append(DATE_分);
            printTimeStampSb.append(String.format("%02d", time.getSecond()));
            printTimeStampSb.append(DATE_秒);
            printTimeStampSb.append(作成).toRString();
        }
        return printTimeStampSb;
    }
}
