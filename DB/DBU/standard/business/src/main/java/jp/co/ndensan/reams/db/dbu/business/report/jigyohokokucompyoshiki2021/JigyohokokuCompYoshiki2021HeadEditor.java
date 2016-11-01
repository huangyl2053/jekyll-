/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2021;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2021.JigyohokokuCompYoshiki2021ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事業報告月報様式_02のHeadEditorです。
 *
 * @reamsid_L DBU-5560-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki2021HeadEditor implements IJigyohokokuCompYoshiki2021Editor {

    private static final RString 旧市町村 = new RString("1");
    private static final RString 記号 = new RString("（旧）");
    private static final RString 現物分コード = new RString("1");
    private static final RString 償還分コード = new RString("2");
    private static final RString 現物分内容 = new RString("（１）介護給付・予防給付（現物分）");
    private static final RString 償還分内容 = new RString("（１）介護給付・予防給付（償還分）");
    private static final RString 集計番号_0102 = new RString("0102");
    private static final RString 集計番号_0202 = new RString("0202");
    private static final RString 集計番号_0302 = new RString("0302");
    private static final RString 集計番号_0402 = new RString("0402");
    private static final RString 総数 = new RString("①総　数");
    private static final RString 第２号被保険者分 = new RString("③第２号被保険者分（再掲）");
    private static final RString 総数_再掲 = new RString("④総　数（再掲：介護給付・予防給付の特例分）");
    private static final RString 第２号被保険者分再掲 = new RString("③第２号被保険者分（再掲：介護給付・予防給付の特例分）");
    private static final RString 様式内容２ = new RString("（様式２）");
    private static final RString 様式内容２の２ = new RString("（様式２の２）");
    private static final RString 様式内容２の３ = new RString("（様式２の３）");
    private static final RString 様式内容２の４ = new RString("（様式２の４）");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 月報区分 = new RString("1");
    private static final RString 年報月報 = new RString("月報");
    private final RString 集計番号;
    private final RString 給付実績区分コード;
    private final JigyohokokuCompYoshiki201Business business;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     * @param 集計番号 集計番号
     * @param 給付実績区分コード 給付実績区分コード
     */
    public JigyohokokuCompYoshiki2021HeadEditor(JigyohokokuCompYoshiki201Business business, RString 集計番号, RString 給付実績区分コード) {
        this.business = business;
        this.集計番号 = 集計番号;
        this.給付実績区分コード = 給付実績区分コード;
    }

    /**
     * 事業報告月報様式_02のEditです
     *
     * @param source JigyohokokuCompYoshiki2021ReportSource
     * @return JigyohokokuCompYoshiki2021ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki2021ReportSource edit(JigyohokokuCompYoshiki2021ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki2021ReportSource editSource(JigyohokokuCompYoshiki2021ReportSource source) {
        source.sakuseinichiji = set処理日時();
        if (月報区分.equals(business.get年報月報区分())) {
            source.shorikbn = 年報月報;
        }
        source.shukeihani = business.get集計年月();
        source.hokenjano = business.get保険者コード();
        RStringBuilder builder = new RStringBuilder();
        if (旧市町村.equals(business.get旧市町村区分())) {
            builder.append(記号).append(business.get保険者名());
        } else {
            builder.append(business.get保険者名());
        }
        source.hokenjamei = builder.toRString();
        source.title1 = setTitleOne(給付実績区分コード);
        if (集計番号_0102.equals(集計番号)) {
            source.yoshiki = 様式内容２;
            source.title2 = 総数;
        } else if (集計番号_0202.equals(集計番号)) {
            source.yoshiki = 様式内容２の２;
            source.title2 = 第２号被保険者分;
        } else if (集計番号_0302.equals(集計番号)) {
            source.yoshiki = 様式内容２の３;
            source.title2 = 総数_再掲;
        } else if (集計番号_0402.equals(集計番号)) {
            source.yoshiki = 様式内容２の４;
            source.title2 = 第２号被保険者分再掲;
        } else {
            source.yoshiki = RString.EMPTY;
            source.title2 = RString.EMPTY;
        }
        return source;
    }

    private RString setTitleOne(RString 給付実績区分コード) {
        RString title1;
        if (現物分コード.equals(給付実績区分コード)) {
            title1 = 現物分内容;
        } else if (償還分コード.equals(給付実績区分コード)) {
            title1 = 償還分内容;
        } else {
            title1 = RString.EMPTY;
        }
        return title1;
    }

    private RString set処理日時() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = business.get処理日時();
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
        return printTimeStampSb.toRString();
    }
}
