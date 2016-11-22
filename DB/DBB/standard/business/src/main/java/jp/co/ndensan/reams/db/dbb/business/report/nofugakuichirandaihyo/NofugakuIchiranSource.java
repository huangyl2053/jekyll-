/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirandaihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBRP91003-1_納付額一覧表（確定申告用）のReportSourceクラスです。 帳票設計_DBBRP91003-2_納付額一覧表（識別コード不明分）のReportSourceクラスです。
 *
 * @reamsid_L DBB-1890-040 sunhui
 */
public class NofugakuIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "data1", length = 10, order = 1)
    public RString data1;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "nen", length = 6, order = 3)
    public RString nen;
    @ReportItem(name = "cityCd", length = 6, order = 4)
    public RString cityCd;
    @ReportItem(name = "cityMei", length = 20, order = 5)
    public RString cityMei;
    @ReportItem(name = "sortJunArea1", length = 10, order = 6)
    public RString sortJunArea1;
    @ReportItem(name = "sortJunArea2", length = 10, order = 7)
    public RString sortJunArea2;
    @ReportItem(name = "sortJunArea3", length = 10, order = 8)
    public RString sortJunArea3;
    @ReportItem(name = "sortJunArea4", length = 10, order = 9)
    public RString sortJunArea4;
    @ReportItem(name = "sortJunArea5", length = 10, order = 10)
    public RString sortJunArea5;
    @ReportItem(name = "kaiPageArea1", length = 20, order = 11)
    public RString kaiPageArea1;
    @ReportItem(name = "kaiPageArea2", length = 20, order = 12)
    public RString kaiPageArea2;
    @ReportItem(name = "kaiPageArea3", length = 20, order = 13)
    public RString kaiPageArea3;
    @ReportItem(name = "kaiPageArea4", length = 20, order = 14)
    public RString kaiPageArea4;
    @ReportItem(name = "kaiPageArea5", length = 20, order = 15)
    public RString kaiPageArea5;
    @ReportItem(name = "list1_1", length = 10, order = 16)
    public RString list1_1;
    @ReportItem(name = "list2_1", length = 15, order = 17)
    public RString list2_1;
    @ReportItem(name = "list6_1", length = 40, order = 18)
    public RString list6_1;
    @ReportItem(name = "list6_2", length = 1, order = 19)
    public RString list6_2;
    @ReportItem(name = "list6_3", length = 9, order = 20)
    public RString list6_3;
    @ReportItem(name = "list6_4", length = 4, order = 21)
    public RString list6_4;
    @ReportItem(name = "list10_1", length = 7, order = 22)
    public RString list10_1;
    @ReportItem(name = "list10_2", length = 7, order = 23)
    public RString list10_2;
    @ReportItem(name = "list10_3", length = 7, order = 24)
    public RString list10_3;
    @ReportItem(name = "list10_4", length = 7, order = 25)
    public RString list10_4;
    @ReportItem(name = "list10_5", length = 7, order = 26)
    public RString list10_5;
    @ReportItem(name = "list10_6", length = 7, order = 27)
    public RString list10_6;
    @ReportItem(name = "list10_7", length = 7, order = 28)
    public RString list10_7;
    @ReportItem(name = "list10_8", length = 7, order = 29)
    public RString list10_8;
    @ReportItem(name = "list10_9", length = 7, order = 30)
    public RString list10_9;
    @ReportItem(name = "list10_10", length = 7, order = 31)
    public RString list10_10;
    @ReportItem(name = "list10_11", length = 7, order = 32)
    public RString list10_11;
    @ReportItem(name = "list10_12", length = 7, order = 33)
    public RString list10_12;
    @ReportItem(name = "list10_13", length = 7, order = 34)
    public RString list10_13;
    @ReportItem(name = "list10_14", length = 7, order = 35)
    public RString list10_14;
    @ReportItem(name = "list10_15", length = 8, order = 36)
    public RString list10_15;
    @ReportItem(name = "list3_1", length = 15, order = 37)
    public RString list3_1;
    @ReportItem(name = "list11_1", length = 7, order = 38)
    public RString list11_1;
    @ReportItem(name = "list11_2", length = 7, order = 39)
    public RString list11_2;
    @ReportItem(name = "list11_3", length = 7, order = 40)
    public RString list11_3;
    @ReportItem(name = "list11_4", length = 7, order = 41)
    public RString list11_4;
    @ReportItem(name = "list11_5", length = 7, order = 42)
    public RString list11_5;
    @ReportItem(name = "list11_6", length = 7, order = 43)
    public RString list11_6;
    @ReportItem(name = "list11_7", length = 7, order = 44)
    public RString list11_7;
    @ReportItem(name = "list11_8", length = 7, order = 45)
    public RString list11_8;
    @ReportItem(name = "list11_9", length = 7, order = 46)
    public RString list11_9;
    @ReportItem(name = "list11_10", length = 7, order = 47)
    public RString list11_10;
    @ReportItem(name = "list11_11", length = 7, order = 48)
    public RString list11_11;
    @ReportItem(name = "list11_12", length = 7, order = 49)
    public RString list11_12;
    @ReportItem(name = "list11_13", length = 7, order = 50)
    public RString list11_13;
    @ReportItem(name = "list11_14", length = 7, order = 51)
    public RString list11_14;
    @ReportItem(name = "list11_15", length = 8, order = 52)
    public RString list11_15;
    @ReportItem(name = "list4_1", length = 11, order = 53)
    public RString list4_1;
    @ReportItem(name = "list7_1", length = 50, order = 54)
    public RString list7_1;
    @ReportItem(name = "list8_1", length = 7, order = 55)
    public RString list8_1;
    @ReportItem(name = "list12_1", length = 7, order = 56)
    public RString list12_1;
    @ReportItem(name = "list12_2", length = 7, order = 57)
    public RString list12_2;
    @ReportItem(name = "list12_3", length = 7, order = 58)
    public RString list12_3;
    @ReportItem(name = "list12_4", length = 7, order = 59)
    public RString list12_4;
    @ReportItem(name = "list12_5", length = 7, order = 60)
    public RString list12_5;
    @ReportItem(name = "list12_6", length = 7, order = 61)
    public RString list12_6;
    @ReportItem(name = "list12_7", length = 7, order = 62)
    public RString list12_7;
    @ReportItem(name = "list12_8", length = 7, order = 63)
    public RString list12_8;
    @ReportItem(name = "list12_9", length = 7, order = 64)
    public RString list12_9;
    @ReportItem(name = "list12_10", length = 7, order = 65)
    public RString list12_10;
    @ReportItem(name = "list12_11", length = 7, order = 66)
    public RString list12_11;
    @ReportItem(name = "list12_12", length = 7, order = 67)
    public RString list12_12;
    @ReportItem(name = "list12_13", length = 7, order = 68)
    public RString list12_13;
    @ReportItem(name = "list12_14", length = 7, order = 69)
    public RString list12_14;
    @ReportItem(name = "list12_15", length = 8, order = 70)
    public RString list12_15;
    @ReportItem(name = "list5_1", length = 11, order = 71)
    public RString list5_1;
    @ReportItem(name = "list9_1", length = 7, order = 72)
    public RString list9_1;
    @ReportItem(name = "list13_1", length = 7, order = 73)
    public RString list13_1;
    @ReportItem(name = "list13_2", length = 7, order = 74)
    public RString list13_2;
    @ReportItem(name = "list13_3", length = 7, order = 75)
    public RString list13_3;
    @ReportItem(name = "list13_4", length = 7, order = 76)
    public RString list13_4;
    @ReportItem(name = "list13_5", length = 7, order = 77)
    public RString list13_5;
    @ReportItem(name = "list13_6", length = 7, order = 78)
    public RString list13_6;
    @ReportItem(name = "list13_7", length = 7, order = 79)
    public RString list13_7;
    @ReportItem(name = "list13_8", length = 7, order = 80)
    public RString list13_8;
    @ReportItem(name = "list13_9", length = 7, order = 81)
    public RString list13_9;
    @ReportItem(name = "list13_10", length = 7, order = 82)
    public RString list13_10;
    @ReportItem(name = "list13_11", length = 7, order = 83)
    public RString list13_11;
    @ReportItem(name = "list13_12", length = 7, order = 84)
    public RString list13_12;
    @ReportItem(name = "list13_13", length = 7, order = 85)
    public RString list13_13;
    @ReportItem(name = "list13_14", length = 7, order = 86)
    public RString list13_14;
    @ReportItem(name = "list13_15", length = 8, order = 87)
    public RString list13_15;
    @ReportItem(name = "data2", length = 70, order = 88)
    public RString data2;
    @ReportItem(name = "choikiCode", length = 10, order = 89)
    public RString choikiCode;
    @ReportItem(name = "kanaMeisho", length = 20, order = 90)
    public RString kanaMeisho;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
