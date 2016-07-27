/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14300105;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105ReportSource;
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
 * 介護事業状況報告年報（様式1-4）のEditorクラスです。
 *
 * @reamsid_L DBU-5600-140 lishengli
 */
public class JigyohokokuCompYoshiki14300105Editor implements IJigyohokokuCompYoshiki14300105Editor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshiki14300105Data data;
    private final JigyohokokuCompYoshiki14300105Change change;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki14300105Data
     * @param change JigyohokokuCompYoshiki14300105Change
     */
    protected JigyohokokuCompYoshiki14300105Editor(JigyohokokuCompYoshiki14300105Data data, JigyohokokuCompYoshiki14300105Change change) {
        this.data = data;
        this.change = change;
    }

    @Override
    public JigyohokokuCompYoshiki14300105ReportSource edit(JigyohokokuCompYoshiki14300105ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki14300105ReportSource editSource(JigyohokokuCompYoshiki14300105ReportSource source) {
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
        source.hyo1ShinseishaKensu1 = data.get介護老人福祉施設の申請件数();
        source.hyo1ShinseishaKensu2 = data.get介護老人保健施設の申請件数();
        source.hyo1ShinseishaKensu3 = data.get介護療養型医療施設の申請件数();
        source.hyo1ShinseishaKensu4 = data.get地域密着型介護老人福祉施設入居者生活介護の申請件数();
        source.hyo1ShinseishaKensu5 = data.getその他の申請件数();
        source.hyo1ShinseishaKensu6 = data.get合計の申請件数();
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
