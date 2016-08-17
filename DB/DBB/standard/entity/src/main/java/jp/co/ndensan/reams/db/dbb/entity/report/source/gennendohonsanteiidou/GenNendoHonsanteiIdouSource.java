/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 本算定異動（現年度）結果一覧表帳票Source
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouSource implements IReportSource {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 4, order = 2)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "fuchoKi1", length = 3, order = 10)
    public RString fuchoKi1;
    @ReportItem(name = "fuchoKi2", length = 3, order = 11)
    public RString fuchoKi2;
    @ReportItem(name = "fuchoKi3", length = 3, order = 12)
    public RString fuchoKi3;
    @ReportItem(name = "fuchoKi4", length = 3, order = 13)
    public RString fuchoKi4;
    @ReportItem(name = "fuchoKi5", length = 3, order = 14)
    public RString fuchoKi5;
    @ReportItem(name = "fuchoKi6", length = 3, order = 15)
    public RString fuchoKi6;
    @ReportItem(name = "fuchoKi7", length = 3, order = 16)
    public RString fuchoKi7;
    @ReportItem(name = "fuchoKi8", length = 3, order = 17)
    public RString fuchoKi8;
    @ReportItem(name = "fuchoKi9", length = 3, order = 18)
    public RString fuchoKi9;
    @ReportItem(name = "fuchoKi10", length = 3, order = 19)
    public RString fuchoKi10;
    @ReportItem(name = "fuchoKi11", length = 3, order = 20)
    public RString fuchoKi11;
    @ReportItem(name = "fuchoKi12", length = 3, order = 21)
    public RString fuchoKi12;
    @ReportItem(name = "fuchoKi13", length = 3, order = 22)
    public RString fuchoKi13;
    @ReportItem(name = "fuchoKi14", length = 3, order = 23)
    public RString fuchoKi14;
    @ReportExpandedInfo(id = "X")
    @ReportItem(name = "list1_1", length = 10, order = 24)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 20, order = 25)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 20, order = 26)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 20, order = 27)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 40, order = 28)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 20, order = 29)
    public RString list1_6;
    @ReportItem(name = "list2_1", length = 9, order = 30)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 15, order = 31)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 15, order = 32)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 15, order = 33)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 2, order = 34)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 2, order = 35)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 2, order = 36)
    public RString list2_7;
    @ReportItem(name = "list2_8", length = 2, order = 37)
    public RString list2_8;
    @ReportItem(name = "list2_9", length = 2, order = 38)
    public RString list2_9;
    @ReportItem(name = "list2_10", length = 2, order = 39)
    public RString list2_10;
    @ReportItem(name = "list2_11", length = 2, order = 40)
    public RString list2_11;
    @ReportItem(name = "list2_12", length = 2, order = 41)
    public RString list2_12;
    @ReportItem(name = "list2_13", length = 2, order = 42)
    public RString list2_13;
    @ReportItem(name = "list2_14", length = 2, order = 43)
    public RString list2_14;
    @ReportItem(name = "list2_15", length = 2, order = 44)
    public RString list2_15;
    @ReportItem(name = "list2_16", length = 2, order = 45)
    public RString list2_16;
    @ReportItem(name = "list2_17", length = 2, order = 46)
    public RString list2_17;
    @ReportItem(name = "list2_18", length = 20, order = 47)
    public RString list2_18;
    @ReportItem(name = "list3_1", length = 9, order = 48)
    public RString list3_1;
    @ReportItem(name = "list3_2", length = 15, order = 49)
    public RString list3_2;
    @ReportItem(name = "list3_3", length = 15, order = 50)
    public RString list3_3;
    @ReportItem(name = "list3_4", length = 15, order = 51)
    public RString list3_4;
    @ReportItem(name = "list3_5", length = 2, order = 52)
    public RString list3_5;
    @ReportItem(name = "list3_6", length = 2, order = 53)
    public RString list3_6;
    @ReportItem(name = "list3_7", length = 2, order = 54)
    public RString list3_7;
    @ReportItem(name = "list3_8", length = 2, order = 55)
    public RString list3_8;
    @ReportItem(name = "list3_9", length = 2, order = 56)
    public RString list3_9;
    @ReportItem(name = "list3_10", length = 2, order = 57)
    public RString list3_10;
    @ReportItem(name = "list3_11", length = 2, order = 58)
    public RString list3_11;
    @ReportItem(name = "list3_12", length = 2, order = 59)
    public RString list3_12;
    @ReportItem(name = "list3_13", length = 2, order = 60)
    public RString list3_13;
    @ReportItem(name = "list3_14", length = 2, order = 61)
    public RString list3_14;
    @ReportItem(name = "list3_15", length = 2, order = 62)
    public RString list3_15;
    @ReportItem(name = "list3_16", length = 2, order = 63)
    public RString list3_16;
    @ReportItem(name = "list3_17", length = 2, order = 64)
    public RString list3_17;
    @ReportItem(name = "list3_18", length = 20, order = 65)
    public RString list3_18;
    @ReportItem(name = "list4_1", length = 7, order = 66)
    public RString list4_1;
    @ReportItem(name = "list4_2", length = 7, order = 67)
    public RString list4_2;
    @ReportItem(name = "list4_3", length = 7, order = 68)
    public RString list4_3;
    @ReportItem(name = "list4_4", length = 7, order = 69)
    public RString list4_4;
    @ReportItem(name = "list4_5", length = 7, order = 70)
    public RString list4_5;
    @ReportItem(name = "list4_6", length = 7, order = 71)
    public RString list4_6;
    @ReportItem(name = "list4_7", length = 7, order = 72)
    public RString list4_7;
    @ReportItem(name = "list4_8", length = 7, order = 73)
    public RString list4_8;
    @ReportItem(name = "list4_9", length = 7, order = 74)
    public RString list4_9;
    @ReportItem(name = "list4_10", length = 7, order = 75)
    public RString list4_10;
    @ReportItem(name = "list4_11", length = 7, order = 76)
    public RString list4_11;
    @ReportItem(name = "list4_12", length = 7, order = 77)
    public RString list4_12;
    @ReportItem(name = "list4_13", length = 7, order = 78)
    public RString list4_13;
    @ReportItem(name = "list4_14", length = 7, order = 79)
    public RString list4_14;
    @ReportItem(name = "list4_15", length = 7, order = 80)
    public RString list4_15;
    @ReportItem(name = "list4_16", length = 7, order = 81)
    public RString list4_16;
    @ReportItem(name = "list4_17", length = 7, order = 82)
    public RString list4_17;
    @ReportItem(name = "list4_18", length = 7, order = 83)
    public RString list4_18;
    @ReportItem(name = "list4_19", length = 7, order = 84)
    public RString list4_19;
    @ReportItem(name = "list4_20", length = 7, order = 85)
    public RString list4_20;
    @ReportItem(name = "list4_21", length = 2, order = 86)
    public RString list4_21;
    @ReportItem(name = "list4_22", length = 20, order = 87)
    public RString list4_22;
    @ReportItem(name = "list5_1", length = 7, order = 88)
    public RString list5_1;
    @ReportItem(name = "list5_2", length = 7, order = 89)
    public RString list5_2;
    @ReportItem(name = "list5_3", length = 7, order = 90)
    public RString list5_3;
    @ReportItem(name = "list5_4", length = 7, order = 91)
    public RString list5_4;
    @ReportItem(name = "list5_5", length = 7, order = 92)
    public RString list5_5;
    @ReportItem(name = "list5_6", length = 7, order = 93)
    public RString list5_6;
    @ReportItem(name = "list5_7", length = 7, order = 94)
    public RString list5_7;
    @ReportItem(name = "list5_8", length = 7, order = 95)
    public RString list5_8;
    @ReportItem(name = "list5_9", length = 7, order = 96)
    public RString list5_9;
    @ReportItem(name = "list5_10", length = 7, order = 97)
    public RString list5_10;
    @ReportItem(name = "list5_11", length = 7, order = 98)
    public RString list5_11;
    @ReportItem(name = "list5_12", length = 7, order = 99)
    public RString list5_12;
    @ReportItem(name = "list5_13", length = 7, order = 100)
    public RString list5_13;
    @ReportItem(name = "list5_14", length = 7, order = 101)
    public RString list5_14;
    @ReportItem(name = "list5_15", length = 7, order = 102)
    public RString list5_15;
    @ReportItem(name = "list5_16", length = 7, order = 103)
    public RString list5_16;
    @ReportItem(name = "list5_17", length = 7, order = 104)
    public RString list5_17;
    @ReportItem(name = "list5_18", length = 7, order = 105)
    public RString list5_18;
    @ReportItem(name = "list5_19", length = 7, order = 106)
    public RString list5_19;
    @ReportItem(name = "list5_20", length = 7, order = 107)
    public RString list5_20;
    @ReportItem(name = "list5_21", length = 2, order = 108)
    public RString list5_21;
    @ReportItem(name = "list5_22", length = 20, order = 109)
    public RString list5_22;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
