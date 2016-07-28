package jp.co.ndensan.reams.db.dbd.entity.report.dbd300003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定実施状況表（統計表）ReportSourceです。
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
public class YokaigoNinteiJisshiJokyohyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonName", length = 20, order = 1)
    public RString shichosonName;
    @ReportItem(name = "kijunbi", length = 23, order = 2)
    public RString kijunbi;
    @ReportItem(name = "nenrei", length = 23, order = 3)
    public RString nenrei;
    @ReportItem(name = "chiku", length = 40, order = 4)
    public RString chiku;
    @ReportItem(name = "shukeiTani", length = 23, order = 5)
    public RString shukeiTani;
    @ReportItem(name = "nendo", length = 6, order = 6)
    public RString nendo;
    @ReportItem(name = "printTimeStamp", length = 34, order = 7)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaName", length = 24, order = 8)
    public RString hokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 9)
    public RString hokenshaNo;
    @ReportItem(name = "list1_1", length = 10, order = 10)
    public RString list1_1;
    @ReportItem(name = "list3_1", length = 10, order = 11)
    public RString list3_1;
    @ReportItem(name = "list4_1", length = 10, order = 12)
    public RString list4_1;
    @ReportItem(name = "list1_2", length = 12, order = 13)
    public RString list1_2;
    @ReportItem(name = "list3_2", length = 12, order = 14)
    public RString list3_2;
    @ReportItem(name = "list4_2", length = 12, order = 15)
    public RString list4_2;
    @ReportItem(name = "list1_3", length = 12, order = 16)
    public RString list1_3;
    @ReportItem(name = "list3_3", length = 12, order = 17)
    public RString list3_3;
    @ReportItem(name = "list4_3", length = 12, order = 18)
    public RString list4_3;
    @ReportItem(name = "list1_4", length = 12, order = 19)
    public RString list1_4;
    @ReportItem(name = "list3_4", length = 12, order = 20)
    public RString list3_4;
    @ReportItem(name = "list4_4", length = 12, order = 21)
    public RString list4_4;
    @ReportItem(name = "list1_5", length = 12, order = 22)
    public RString list1_5;
    @ReportItem(name = "list3_5", length = 12, order = 23)
    public RString list3_5;
    @ReportItem(name = "list4_5", length = 12, order = 24)
    public RString list4_5;
    @ReportItem(name = "list1_6", length = 12, order = 25)
    public RString list1_6;
    @ReportItem(name = "list3_6", length = 12, order = 26)
    public RString list3_6;
    @ReportItem(name = "list4_6", length = 12, order = 27)
    public RString list4_6;
    @ReportItem(name = "list1_7", length = 12, order = 28)
    public RString list1_7;
    @ReportItem(name = "list3_7", length = 12, order = 29)
    public RString list3_7;
    @ReportItem(name = "list4_7", length = 12, order = 30)
    public RString list4_7;
    @ReportItem(name = "list1_8", length = 12, order = 31)
    public RString list1_8;
    @ReportItem(name = "list3_8", length = 12, order = 32)
    public RString list3_8;
    @ReportItem(name = "list4_8", length = 12, order = 33)
    public RString list4_8;
    @ReportItem(name = "list1_9", length = 12, order = 34)
    public RString list1_9;
    @ReportItem(name = "list3_9", length = 12, order = 35)
    public RString list3_9;
    @ReportItem(name = "list4_9", length = 12, order = 36)
    public RString list4_9;
    @ReportItem(name = "list1_10", length = 12, order = 37)
    public RString list1_10;
    @ReportItem(name = "list3_10", length = 12, order = 38)
    public RString list3_10;
    @ReportItem(name = "list4_10", length = 12, order = 39)
    public RString list4_10;
    @ReportItem(name = "list1_11", length = 12, order = 40)
    public RString list1_11;
    @ReportItem(name = "list3_11", length = 12, order = 41)
    public RString list3_11;
    @ReportItem(name = "list4_11", length = 12, order = 42)
    public RString list4_11;
    @ReportItem(name = "list1_12", length = 12, order = 43)
    public RString list1_12;
    @ReportItem(name = "list3_12", length = 12, order = 44)
    public RString list3_12;
    @ReportItem(name = "list4_12", length = 12, order = 45)
    public RString list4_12;
    @ReportItem(name = "list1_13", length = 12, order = 46)
    public RString list1_13;
    @ReportItem(name = "list3_13", length = 12, order = 47)
    public RString list3_13;
    @ReportItem(name = "list4_13", length = 12, order = 48)
    public RString list4_13;
    @ReportItem(name = "list1_14", length = 14, order = 49)
    public RString list1_14;
    @ReportItem(name = "list3_14", length = 14, order = 50)
    public RString list3_14;
    @ReportItem(name = "list4_14", length = 14, order = 51)
    public RString list4_14;
    @ReportItem(name = "list2_1", length = 10, order = 52)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 12, order = 53)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 12, order = 54)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 12, order = 55)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 12, order = 56)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 12, order = 57)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 12, order = 58)
    public RString list2_7;
    @ReportItem(name = "list2_8", length = 12, order = 59)
    public RString list2_8;
    @ReportItem(name = "list2_9", length = 12, order = 60)
    public RString list2_9;
    @ReportItem(name = "list2_10", length = 12, order = 61)
    public RString list2_10;
    @ReportItem(name = "list2_11", length = 12, order = 62)
    public RString list2_11;
    @ReportItem(name = "list2_12", length = 12, order = 63)
    public RString list2_12;
    @ReportItem(name = "list2_13", length = 12, order = 64)
    public RString list2_13;
    @ReportItem(name = "list2_14", length = 14, order = 65)
    public RString list2_14;
    @ReportItem(name = "label48", order = 66)
    public RString label48;
    @ReportItem(name = "label18", order = 67)
    public RString label18;
    @ReportItem(name = "reportID", order = 68)
    public RString reportID;
    @ReportItem(name = "label17", order = 69)
    public RString label17;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
