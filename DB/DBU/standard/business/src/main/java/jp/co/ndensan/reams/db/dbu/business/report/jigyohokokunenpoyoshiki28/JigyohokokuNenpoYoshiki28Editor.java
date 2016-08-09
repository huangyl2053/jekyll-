/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki28;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28ReportSource;
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
 * 事業状況報告年報（様式１・２　市町村特別給付）Editorクラスです。
 *
 * @reamsid_L DBU-5610-050 yaoyahui
 */
public class JigyohokokuNenpoYoshiki28Editor implements IJigyohokokuNenpoYoshiki28Editor {

    private static final RString 集計番号_0601 = new RString("0601");
    private static final RString 集計番号_0602 = new RString("0602");
    private static final RString 集計番号_0603 = new RString("0603");
    private static final RString 様式２ = new RString("様式２");
    private static final RString 年報 = new RString("年報");
    private static final RString 市町村特別給付 = new RString("市町村特別給付");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 件数 = new RString("件数");
    private static final RString 費用額 = new RString("費用額");
    private static final RString 給付額 = new RString("給付額");

    private final JigyohokokuNenpoYoshiki28Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuNenpoYoshiki28Entity
     */
    protected JigyohokokuNenpoYoshiki28Editor(JigyohokokuNenpoYoshiki28Entity entity) {

        this.entity = entity;
    }

    @Override
    public JigyohokokuNenpoYoshiki28ReportSource edit(JigyohokokuNenpoYoshiki28ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuNenpoYoshiki28ReportSource editSource(JigyohokokuNenpoYoshiki28ReportSource source) {

        if (集計番号_0601.equals(entity.get集計番号())) {
            source.jijifanhao = entity.get集計番号();
            source.hyoSubTitle = 件数;
            setValue(source);
        }
        if (集計番号_0602.equals(entity.get集計番号())) {
            source.jijifanhao = entity.get集計番号();
            source.hyoSubTitle = 費用額;
            setValue(source);
        }
        if (集計番号_0603.equals(entity.get集計番号())) {
            source.jijifanhao = entity.get集計番号();
            source.hyoSubTitle = 給付額;
            setValue(source);
        }
        return source;
    }

    private void setValue(JigyohokokuNenpoYoshiki28ReportSource source) {
        source.yoshiki = 様式２;
        source.shukeiKubun = 年報;
        source.hyoTitle = 市町村特別給付;
        source.hokenshaName = entity.get保険者名();
        source.hokenshaNo = entity.get保険者番号();
        source.list_1 = entity.get種類();
        source.list_2 = entity.get要支援１();
        source.list_3 = entity.get要支援２();
        source.list_4 = entity.get要介護計();
        source.list_5 = entity.get要介護１();
        source.list_6 = entity.get横番号();
        source.list_7 = entity.get要介護2();
        source.list_8 = entity.get要介護3();
        source.list_9 = entity.get要介護4();
        source.list_10 = entity.get要介護5();
        source.list_11 = entity.get要介護計();
        source.list_12 = entity.get合計();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = entity.getプリント日時();
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
        source.shuukeiHani = get集計範囲();
    }

    private RString get集計範囲() {
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("（"));
        集計範囲_SB.append(getパターン107(entity.get集計年度()));
        集計範囲_SB.append(new RString("年度分）"));
        集計範囲_SB.append(getパターン62(entity.get集計期間FROM()));
        集計範囲_SB.append(new RString("～"));
        集計範囲_SB.append(getパターン62(entity.get集計期間TO()));
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
