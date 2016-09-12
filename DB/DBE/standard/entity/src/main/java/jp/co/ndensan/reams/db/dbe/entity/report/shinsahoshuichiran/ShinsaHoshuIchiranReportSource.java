package jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会委員報酬一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
public class ShinsaHoshuIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shussekiTaishoMM", length = 8, order = 2)
    public RString shussekiTaishoMM;
    @ReportItem(name = "listDD_1", length = 2, order = 3)
    public RString listDD_1;
    @ReportItem(name = "listDD_2", length = 2, order = 4)
    public RString listDD_2;
    @ReportItem(name = "listDD_3", length = 2, order = 5)
    public RString listDD_3;
    @ReportItem(name = "listDD_4", length = 2, order = 6)
    public RString listDD_4;
    @ReportItem(name = "listDD_5", length = 2, order = 7)
    public RString listDD_5;
    @ReportItem(name = "listDD_6", length = 2, order = 8)
    public RString listDD_6;
    @ReportItem(name = "listDD_7", length = 2, order = 9)
    public RString listDD_7;
    @ReportItem(name = "listDD_8", length = 2, order = 10)
    public RString listDD_8;
    @ReportItem(name = "listDD_9", length = 2, order = 11)
    public RString listDD_9;
    @ReportItem(name = "listDD_10", length = 2, order = 12)
    public RString listDD_10;
    @ReportItem(name = "listDD_11", length = 2, order = 13)
    public RString listDD_11;
    @ReportItem(name = "listDD_12", length = 2, order = 14)
    public RString listDD_12;
    @ReportItem(name = "listDD_13", length = 2, order = 15)
    public RString listDD_13;
    @ReportItem(name = "listDD_14", length = 2, order = 16)
    public RString listDD_14;
    @ReportItem(name = "listDD_15", length = 2, order = 17)
    public RString listDD_15;
    @ReportItem(name = "listDD_16", length = 2, order = 18)
    public RString listDD_16;
    @ReportItem(name = "listDD_17", length = 2, order = 19)
    public RString listDD_17;
    @ReportItem(name = "listDD_18", length = 2, order = 20)
    public RString listDD_18;
    @ReportItem(name = "listDD_19", length = 2, order = 21)
    public RString listDD_19;
    @ReportItem(name = "listDD_20", length = 2, order = 22)
    public RString listDD_20;
    @ReportItem(name = "listDD_21", length = 2, order = 23)
    public RString listDD_21;
    @ReportItem(name = "listDD_22", length = 2, order = 24)
    public RString listDD_22;
    @ReportItem(name = "listDD_23", length = 2, order = 25)
    public RString listDD_23;
    @ReportItem(name = "listDD_24", length = 2, order = 26)
    public RString listDD_24;
    @ReportItem(name = "listDD_25", length = 2, order = 27)
    public RString listDD_25;
    @ReportItem(name = "listDD_26", length = 2, order = 28)
    public RString listDD_26;
    @ReportItem(name = "listDD_27", length = 2, order = 29)
    public RString listDD_27;
    @ReportItem(name = "listDD_28", length = 2, order = 30)
    public RString listDD_28;
    @ReportItem(name = "listDD_29", length = 2, order = 31)
    public RString listDD_29;
    @ReportItem(name = "listDD_30", length = 2, order = 32)
    public RString listDD_30;
    @ReportItem(name = "listDD_31", length = 2, order = 33)
    public RString listDD_31;
    @ReportItem(name = "listShukketsu_1", length = 1, order = 34)
    public RString listShukketsu_1;
    @ReportItem(name = "listShukketsu_2", length = 1, order = 35)
    public RString listShukketsu_2;
    @ReportItem(name = "listShukketsu_3", length = 1, order = 36)
    public RString listShukketsu_3;
    @ReportItem(name = "listShukketsu_4", length = 1, order = 37)
    public RString listShukketsu_4;
    @ReportItem(name = "listShukketsu_5", length = 1, order = 38)
    public RString listShukketsu_5;
    @ReportItem(name = "listShukketsu_6", length = 1, order = 39)
    public RString listShukketsu_6;
    @ReportItem(name = "listShukketsu_7", length = 1, order = 40)
    public RString listShukketsu_7;
    @ReportItem(name = "listShukketsu_8", length = 1, order = 41)
    public RString listShukketsu_8;
    @ReportItem(name = "listShukketsu_9", length = 1, order = 42)
    public RString listShukketsu_9;
    @ReportItem(name = "listShukketsu_10", length = 1, order = 43)
    public RString listShukketsu_10;
    @ReportItem(name = "listShukketsu_11", length = 1, order = 44)
    public RString listShukketsu_11;
    @ReportItem(name = "listShukketsu_12", length = 1, order = 45)
    public RString listShukketsu_12;
    @ReportItem(name = "listShukketsu_13", length = 1, order = 46)
    public RString listShukketsu_13;
    @ReportItem(name = "listShukketsu_14", length = 1, order = 47)
    public RString listShukketsu_14;
    @ReportItem(name = "listShukketsu_15", length = 1, order = 48)
    public RString listShukketsu_15;
    @ReportItem(name = "listShukketsu_16", length = 1, order = 49)
    public RString listShukketsu_16;
    @ReportItem(name = "listShukketsu_17", length = 1, order = 50)
    public RString listShukketsu_17;
    @ReportItem(name = "listShukketsu_18", length = 1, order = 51)
    public RString listShukketsu_18;
    @ReportItem(name = "listShukketsu_19", length = 1, order = 52)
    public RString listShukketsu_19;
    @ReportItem(name = "listShukketsu_20", length = 1, order = 53)
    public RString listShukketsu_20;
    @ReportItem(name = "listShukketsu_21", length = 1, order = 54)
    public RString listShukketsu_21;
    @ReportItem(name = "listShukketsu_22", length = 1, order = 55)
    public RString listShukketsu_22;
    @ReportItem(name = "listShukketsu_23", length = 1, order = 56)
    public RString listShukketsu_23;
    @ReportItem(name = "listShukketsu_24", length = 1, order = 57)
    public RString listShukketsu_24;
    @ReportItem(name = "listShukketsu_25", length = 1, order = 58)
    public RString listShukketsu_25;
    @ReportItem(name = "listShukketsu_26", length = 1, order = 59)
    public RString listShukketsu_26;
    @ReportItem(name = "listShukketsu_27", length = 1, order = 60)
    public RString listShukketsu_27;
    @ReportItem(name = "listShukketsu_28", length = 1, order = 61)
    public RString listShukketsu_28;
    @ReportItem(name = "listShukketsu_29", length = 1, order = 62)
    public RString listShukketsu_29;
    @ReportItem(name = "listShukketsu_30", length = 1, order = 63)
    public RString listShukketsu_30;
    @ReportItem(name = "listShukketsu_31", length = 1, order = 64)
    public RString listShukketsu_31;
    @ReportItem(name = "listNo_1", length = 3, order = 65)
    public RString listNo_1;
    @ReportItem(name = "listNo_2", length = 30, order = 66)
    public RString listNo_2;
    @ReportItem(name = "listHiyo_1", length = 3, order = 67)
    public RString listHiyo_1;
    @ReportItem(name = "listHiyo_2", length = 7, order = 68)
    public RString listHiyo_2;
    @ReportItem(name = "listHiyo_3", length = 7, order = 69)
    public RString listHiyo_3;
    @ReportItem(name = "listHiyo_4", length = 7, order = 70)
    public RString listHiyo_4;
    @ReportItem(name = "listHiyo_5", length = 7, order = 71)
    public RString listHiyo_5;
    @ReportItem(name = "listGokei_1", length = 11, order = 72)
    public RString listGokei_1;
    @ReportItem(name = "listGokei_2", length = 11, order = 73)
    public RString listGokei_2;
    @ReportItem(name = "listGokei_3", length = 11, order = 74)
    public RString listGokei_3;
    @ReportItem(name = "listGokei_4", length = 11, order = 75)
    public RString listGokei_4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
