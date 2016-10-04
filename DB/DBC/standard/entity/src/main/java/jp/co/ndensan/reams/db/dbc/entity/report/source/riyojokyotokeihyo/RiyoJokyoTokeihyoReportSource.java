/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.riyojokyotokeihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 利用状況統計表のReportSourceクラスです。
 *
 * @reamsid_L DBC-3500-050 jinjue
 */
public class RiyoJokyoTokeihyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 3)
    public RString hokenshaName;
    @ReportItem(name = "kyuShichoson", length = 19, order = 4)
    public RString kyuShichoson;
    @ReportItem(name = "list1_1", length = 6, order = 5)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 15, order = 6)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 15, order = 7)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 15, order = 8)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 15, order = 9)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 15, order = 10)
    public RString list1_6;
    @ReportItem(name = "list1_7", length = 15, order = 11)
    public RString list1_7;
    @ReportItem(name = "list1_8", length = 15, order = 12)
    public RString list1_8;
    @ReportItem(name = "list1_9", length = 15, order = 13)
    public RString list1_9;
    @ReportItem(name = "list1_10", length = 15, order = 14)
    public RString list1_10;
    @ReportItem(name = "list1_11", length = 15, order = 15)
    public RString list1_11;
    @ReportItem(name = "list2_1", length = 6, order = 16)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 15, order = 17)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 15, order = 18)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 15, order = 19)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 15, order = 20)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 15, order = 21)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 15, order = 22)
    public RString list2_7;
    @ReportItem(name = "list2_8", length = 15, order = 23)
    public RString list2_8;
    @ReportItem(name = "list2_9", length = 15, order = 24)
    public RString list2_9;
    @ReportItem(name = "list2_10", length = 15, order = 25)
    public RString list2_10;
    @ReportItem(name = "list2_11", length = 15, order = 26)
    public RString list2_11;
    @ReportItem(name = "list3_1", length = 3, order = 27)
    public RString list3_1;
    @ReportItem(name = "list3_2", length = 8, order = 28)
    public RString list3_2;
    @ReportItem(name = "list3_3", length = 6, order = 29)
    public RString list3_3;
    @ReportItem(name = "list3_4", length = 15, order = 30)
    public RString list3_4;
    @ReportItem(name = "list3_5", length = 15, order = 31)
    public RString list3_5;
    @ReportItem(name = "list3_6", length = 15, order = 32)
    public RString list3_6;
    @ReportItem(name = "list3_7", length = 15, order = 33)
    public RString list3_7;
    @ReportItem(name = "list3_8", length = 15, order = 34)
    public RString list3_8;
    @ReportItem(name = "list3_9", length = 15, order = 35)
    public RString list3_9;
    @ReportItem(name = "list3_10", length = 15, order = 36)
    public RString list3_10;
    @ReportItem(name = "list3_11", length = 15, order = 37)
    public RString list3_11;
    @ReportItem(name = "list3_12", length = 15, order = 38)
    public RString list3_12;
    @ReportItem(name = "list3_13", length = 15, order = 39)
    public RString list3_13;
    @ReportItem(name = "list4_1", length = 8, order = 40)
    public RString list4_1;
    @ReportItem(name = "list4_2", length = 6, order = 41)
    public RString list4_2;
    @ReportItem(name = "list4_3", length = 15, order = 42)
    public RString list4_3;
    @ReportItem(name = "list4_4", length = 15, order = 43)
    public RString list4_4;
    @ReportItem(name = "list4_5", length = 15, order = 44)
    public RString list4_5;
    @ReportItem(name = "list4_6", length = 15, order = 45)
    public RString list4_6;
    @ReportItem(name = "list4_7", length = 15, order = 46)
    public RString list4_7;
    @ReportItem(name = "list4_8", length = 15, order = 47)
    public RString list4_8;
    @ReportItem(name = "list4_9", length = 15, order = 48)
    public RString list4_9;
    @ReportItem(name = "list4_10", length = 15, order = 49)
    public RString list4_10;
    @ReportItem(name = "list4_11", length = 15, order = 50)
    public RString list4_11;
    @ReportItem(name = "list4_12", length = 15, order = 51)
    public RString list4_12;
    @ReportItem(name = "list5_1", length = 8, order = 52)
    public RString list5_1;
    @ReportItem(name = "list5_2", length = 6, order = 53)
    public RString list5_2;
    @ReportItem(name = "list5_3", length = 15, order = 54)
    public RString list5_3;
    @ReportItem(name = "list5_4", length = 15, order = 55)
    public RString list5_4;
    @ReportItem(name = "list5_5", length = 15, order = 56)
    public RString list5_5;
    @ReportItem(name = "list5_6", length = 15, order = 57)
    public RString list5_6;
    @ReportItem(name = "list5_7", length = 15, order = 58)
    public RString list5_7;
    @ReportItem(name = "list5_8", length = 15, order = 59)
    public RString list5_8;
    @ReportItem(name = "list5_9", length = 15, order = 60)
    public RString list5_9;
    @ReportItem(name = "list5_10", length = 15, order = 61)
    public RString list5_10;
    @ReportItem(name = "list5_11", length = 15, order = 62)
    public RString list5_11;
    @ReportItem(name = "list5_12", length = 15, order = 63)
    public RString list5_12;
    @ReportItem(name = "list6_1", length = 6, order = 64)
    public RString list6_1;
    @ReportItem(name = "list6_2", length = 15, order = 65)
    public RString list6_2;
    @ReportItem(name = "list6_3", length = 15, order = 66)
    public RString list6_3;
    @ReportItem(name = "list6_4", length = 15, order = 67)
    public RString list6_4;
    @ReportItem(name = "list6_5", length = 15, order = 68)
    public RString list6_5;
    @ReportItem(name = "list6_6", length = 15, order = 69)
    public RString list6_6;
    @ReportItem(name = "list6_7", length = 15, order = 70)
    public RString list6_7;
    @ReportItem(name = "list6_8", length = 15, order = 71)
    public RString list6_8;
    @ReportItem(name = "list6_9", length = 15, order = 72)
    public RString list6_9;
    @ReportItem(name = "list6_10", length = 15, order = 73)
    public RString list6_10;
    @ReportItem(name = "list6_11", length = 15, order = 74)
    public RString list6_11;
    @ReportItem(name = "list7_1", length = 6, order = 75)
    public RString list7_1;
    @ReportItem(name = "list7_2", length = 15, order = 76)
    public RString list7_2;
    @ReportItem(name = "list7_3", length = 15, order = 77)
    public RString list7_3;
    @ReportItem(name = "list7_4", length = 15, order = 78)
    public RString list7_4;
    @ReportItem(name = "list7_5", length = 15, order = 79)
    public RString list7_5;
    @ReportItem(name = "list7_6", length = 15, order = 80)
    public RString list7_6;
    @ReportItem(name = "list7_7", length = 15, order = 81)
    public RString list7_7;
    @ReportItem(name = "list7_8", length = 15, order = 82)
    public RString list7_8;
    @ReportItem(name = "list7_9", length = 15, order = 83)
    public RString list7_9;
    @ReportItem(name = "list7_10", length = 15, order = 84)
    public RString list7_10;
    @ReportItem(name = "list7_11", length = 15, order = 85)
    public RString list7_11;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        kyuShichoson,
    }
}
