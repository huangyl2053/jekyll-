/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Change;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のBodyEditorです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272BodyEditor implements IJigyohokokuCompYoshiki272Editor {

    private final JigyohokokuCompYoshiki272Change change;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");

    /**
     * インスタンスを生成します。
     *
     * @param change JigyohokokuCompYoshiki272Change
     */
    protected JigyohokokuCompYoshiki272BodyEditor(JigyohokokuCompYoshiki272Change change) {
        this.change = change;
    }

    /**
     * レーポトソースのエディトです
     *
     * @param source JigyohokokuCompYoshiki2_7_2ReportSource
     * @return JigyohokokuCompYoshiki2_7_2ReportSource
     */
    @Override
    public JigyohokokuCompYoshiki272ReportSource edit(JigyohokokuCompYoshiki272ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki272ReportSource editSource(JigyohokokuCompYoshiki272ReportSource source) {
        source.listUpper_1 = change.getListUpper_1();
        source.listLower_1 = change.getListLower_1();
        source.printTimeStamp = set処理日時();
        source.shukeiKubun = change.get集計区分();
        source.shuukeiHani = change.get集計範囲();
        source.hokenshaNo = change.get保険者番号();
        source.hokenshaName = change.get保険者名();
        return source;
    }

    private RString set処理日時() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(change.get作成日時().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", change.get作成日時().getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", change.get作成日時().getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", change.get作成日時().getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }
}
