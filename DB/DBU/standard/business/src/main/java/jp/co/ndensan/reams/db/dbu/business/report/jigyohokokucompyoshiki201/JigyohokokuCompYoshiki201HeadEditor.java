/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事業報告月報様式_01のHeadEditorです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
public class JigyohokokuCompYoshiki201HeadEditor implements IJigyohokokuCompYoshiki201Editor {

    private static final RString 旧市町村 = new RString("1");
    private static final RString 記号 = new RString("（旧）");
    private static final RString 現物分コード = new RString("1");
    private static final RString 償還分コード = new RString("2");
    private static final RString 現物分内容 = new RString("（１）介護給付・予防給付（現物分）");
    private static final RString 償還分内容 = new RString("（１）介護給付・予防給付（償還分）");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final JigyohokokuCompYoshiki201Business business;

    /**
     * インスタンスを生成します。
     *
     * @param business JigyohokokuCompYoshiki201Business
     */
    protected JigyohokokuCompYoshiki201HeadEditor(JigyohokokuCompYoshiki201Business business) {
        this.business = business;
    }

    @Override
    public JigyohokokuCompYoshiki201ReportSource edit(JigyohokokuCompYoshiki201ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki201ReportSource editSource(JigyohokokuCompYoshiki201ReportSource source) {
        source.sakuseinichiji = set処理日時(business.get処理日時());
        source.shorikbn = business.get年報月報区分();
        source.shukeihani = business.get集計年月();
        source.hokenjano = business.get保険者コード();
        RStringBuilder builder = new RStringBuilder();
        if (旧市町村.equals(business.get旧市町村区分())) {
            builder.append(記号).append(business.get保険者名());
        } else {
            builder.append(business.get保険者名());
        }
        source.hokenjamei = builder.toRString();
        source.title1 = getTitleOne(business.get給付実績区分コード());
        return source;
    }

    private RString getTitleOne(RString 給付実績区分コード) {
        RString title;
        if (現物分コード.equals(給付実績区分コード)) {
            title = 現物分内容;
        } else if (償還分コード.equals(給付実績区分コード)) {
            title = 償還分内容;
        } else {
            title = RString.EMPTY;
        }
        return title;
    }

    private RString set処理日時(RDateTime date) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(date.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", date.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", date.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", date.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }
}
