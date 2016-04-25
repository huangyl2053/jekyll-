/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会集計表（現在の状況別）のEditorです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoEditor implements IShinsakaiShukeiGenzainojokyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final ShinsakaiShukeiGenzainojokyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaiShukeiGenzainojokyoItem}
     */
    protected ShinsakaiShukeiGenzainojokyoEditor(ShinsakaiShukeiGenzainojokyoItem item) {
        this.item = item;
    }

    @Override
    public ShinsakaiShukeiGenzainojokyoReportSource edit(ShinsakaiShukeiGenzainojokyoReportSource source) {
        return editSource(source);
    }

    private ShinsakaiShukeiGenzainojokyoReportSource editSource(ShinsakaiShukeiGenzainojokyoReportSource source) {
        source.title = item.getTitle();
        source.shichosonName = item.getShichosonName();
        if (!RString.isNullOrEmpty(item.getYukoKijunYMD())) {
            source.yukoKijunYMD = new RDate(item.getYukoKijunYMD().toString()).wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = RDateTime.now();
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
        source.listShukei1_1 = item.getListShukei1_1();
        source.listShukei1_2 = item.getListShukei1_2();
        source.listShukei1_3 = item.getListShukei1_3();
        source.listShukei1_4 = item.getListShukei1_4();
        source.listShukei1_5 = item.getListShukei1_5();
        source.listShukei1_6 = item.getListShukei1_6();
        source.listShukei1_7 = item.getListShukei1_7();
        source.listShukei1_8 = item.getListShukei1_8();
        source.listShukei2_1 = item.getListShukei2_1();
        source.listShukei2_2 = item.getListShukei2_2();
        source.listShukei2_3 = item.getListShukei2_3();
        source.listShukei2_4 = item.getListShukei2_4();
        source.listShukei2_5 = item.getListShukei2_5();
        source.listShukei2_6 = item.getListShukei2_6();
        source.listShukei2_7 = item.getListShukei2_7();
        source.listShukei2_8 = item.getListShukei2_8();
        source.listShukei3_1 = item.getListShukei3_1();
        source.listShukei3_2 = item.getListShukei3_2();
        source.listShukei3_3 = item.getListShukei3_3();
        source.listShukei3_4 = item.getListShukei3_4();
        source.listShukei3_5 = item.getListShukei3_5();
        source.listShukei3_6 = item.getListShukei3_6();
        source.listShukei3_7 = item.getListShukei3_7();
        source.listShukei3_8 = item.getListShukei3_8();
        source.listShukei4_1 = item.getListShukei4_1();
        source.listShukei4_2 = item.getListShukei4_2();
        source.listShukei4_3 = item.getListShukei4_3();
        source.listShukei4_4 = item.getListShukei4_4();
        source.listShukei4_5 = item.getListShukei4_5();
        source.listShukei4_6 = item.getListShukei4_6();
        source.listShukei4_7 = item.getListShukei4_7();
        source.listShukei4_8 = item.getListShukei4_8();
        source.listShukei5_1 = item.getListShukei5_1();
        source.listShukei5_2 = item.getListShukei5_2();
        source.listShukei5_3 = item.getListShukei5_3();
        source.listShukei5_4 = item.getListShukei5_4();
        source.listShukei5_5 = item.getListShukei5_5();
        source.listShukei5_6 = item.getListShukei5_6();
        source.listShukei5_7 = item.getListShukei5_7();
        source.listShukei5_8 = item.getListShukei5_8();
        return source;
    }
}
