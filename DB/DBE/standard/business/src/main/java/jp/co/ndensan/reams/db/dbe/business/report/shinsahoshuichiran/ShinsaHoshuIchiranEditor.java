/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran.ShinsaHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会委員報酬一覧表のEditorです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
public class ShinsaHoshuIchiranEditor implements IShinsaHoshuIchiranEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private final ShinsaHoshuIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item ShinsaHoshuIchiranEntity
     */
    public ShinsaHoshuIchiranEditor(ShinsaHoshuIchiranEntity item) {
        this.item = item;
    }

    @Override
    public ShinsaHoshuIchiranReportSource edit(ShinsaHoshuIchiranReportSource source) {
        return editSource(source);
    }

    /**
     * 帳票のReportSource作成
     *
     * @param source
     * @return
     */
    private ShinsaHoshuIchiranReportSource editSource(ShinsaHoshuIchiranReportSource source) {
        source.printTimeStamp = get作成年月日時();
        source.shussekiTaishoMM = item.get出席日();
        source.listDD_1 = new RString("1");
        source.listDD_2 = new RString("2");
        source.listDD_3 = new RString("3");
        source.listDD_4 = new RString("4");
        source.listDD_5 = new RString("5");
        source.listDD_6 = new RString("6");
        source.listDD_7 = new RString("7");
        source.listDD_8 = new RString("8");
        source.listDD_9 = new RString("9");
        source.listDD_10 = new RString("10");
        source.listDD_11 = new RString("11");
        source.listDD_12 = new RString("12");
        source.listDD_13 = new RString("13");
        source.listDD_14 = new RString("14");
        source.listDD_15 = new RString("15");
        source.listDD_16 = new RString("16");
        source.listDD_17 = new RString("17");
        source.listDD_18 = new RString("18");
        source.listDD_19 = new RString("19");
        source.listDD_20 = new RString("20");
        source.listDD_21 = new RString("21");
        source.listDD_22 = new RString("22");
        source.listDD_23 = new RString("23");
        source.listDD_24 = new RString("24");
        source.listDD_25 = new RString("25");
        source.listDD_26 = new RString("26");
        source.listDD_27 = new RString("27");
        source.listDD_28 = new RString("28");
        source.listDD_29 = new RString("29");
        source.listDD_30 = new RString("30");
        source.listDD_31 = new RString("31");
        source.listNo_1 = item.get合議体No();
        source.listNo_2 = item.get審査員氏名();
        source.listShukketsu_1 = item.get出欠_1();
        source.listShukketsu_2 = item.get出欠_2();
        source.listShukketsu_3 = item.get出欠_3();
        source.listShukketsu_4 = item.get出欠_4();
        source.listShukketsu_5 = item.get出欠_5();
        source.listShukketsu_6 = item.get出欠_6();
        source.listShukketsu_7 = item.get出欠_7();
        source.listShukketsu_8 = item.get出欠_8();
        source.listShukketsu_9 = item.get出欠_9();
        source.listShukketsu_10 = item.get出欠_10();
        source.listShukketsu_11 = item.get出欠_11();
        source.listShukketsu_12 = item.get出欠_12();
        source.listShukketsu_13 = item.get出欠_13();
        source.listShukketsu_14 = item.get出欠_14();
        source.listShukketsu_15 = item.get出欠_15();
        source.listShukketsu_16 = item.get出欠_16();
        source.listShukketsu_17 = item.get出欠_17();
        source.listShukketsu_18 = item.get出欠_18();
        source.listShukketsu_19 = item.get出欠_19();
        source.listShukketsu_20 = item.get出欠_20();
        source.listShukketsu_21 = item.get出欠_21();
        source.listShukketsu_22 = item.get出欠_22();
        source.listShukketsu_23 = item.get出欠_23();
        source.listShukketsu_24 = item.get出欠_24();
        source.listShukketsu_25 = item.get出欠_25();
        source.listShukketsu_26 = item.get出欠_26();
        source.listShukketsu_27 = item.get出欠_27();
        source.listShukketsu_28 = item.get出欠_28();
        source.listShukketsu_29 = item.get出欠_29();
        source.listShukketsu_30 = item.get出欠_30();
        source.listShukketsu_31 = item.get出欠_31();
        source.listHiyo_1 = item.get出席回数();
        source.listHiyo_2 = item.get報酬総額();
        source.listHiyo_3 = item.getその他費用();
        source.listHiyo_4 = item.get税額控除();
        source.listHiyo_5 = item.get報酬合計();
        source.listGokei_1 = item.get報酬総額_合計();
        source.listGokei_2 = item.getその他費用_合計();
        source.listGokei_3 = item.get税額控除_合計();
        source.listGokei_4 = item.get報酬合計_合計();
        return source;
    }

    /**
     * 年月日時の作成
     *
     * @return 作成年月日時
     */
    private RString get作成年月日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
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
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(作成);
        return printTimeStampSb.toRString();
    }
}
