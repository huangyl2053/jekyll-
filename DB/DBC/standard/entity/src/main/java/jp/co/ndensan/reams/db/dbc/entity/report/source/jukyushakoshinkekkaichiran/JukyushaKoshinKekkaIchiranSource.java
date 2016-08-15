/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 受給者情報更新結果情報一覧表帳票Source
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaIchiranSource implements IReportSource {
    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 10, order = 2)
    public RString title;
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
    @ReportItem(name = "kaiPege1", length = 20, order = 10)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 20, order = 11)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 20, order = 12)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 20, order = 13)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 20, order = 14)
    public RString kaiPege5;
    @ReportItem(name = "komokuName1", length = 10, order = 15)
    public RString komokuName1;
    @ReportItem(name = "komokuName2", length = 10, order = 16)
    public RString komokuName2;
    @ReportItem(name = "komokuName3", length = 18, order = 17)
    public RString komokuName3;
    @ReportItem(name = "listList1_1", length = 9, order = 18)
    public RString listList1_1;
    @ReportItem(name = "listList1_2", length = 9, order = 19)
    public RString listList1_2;
    @ReportItem(name = "listList1_3", length = 8, order = 20)
    public RString listList1_3;
    @ReportItem(name = "listList1_4", length = 10, order = 21)
    public RString listList1_4;
    @ReportItem(name = "listList1_5", length = 40, order = 22)
    public RString listList1_5;
    @ReportItem(name = "listList1_6", length = 9, order = 23)
    public RString listList1_6;
    @ReportItem(name = "listList1_7", length = 30, order = 24)
    public RString listList1_7;
    @ReportItem(name = "listList1_8", length = 9, order = 25)
    public RString listList1_8;
    @ReportItem(name = "listList1_9", length = 9, order = 26)
    public RString listList1_9;
    @ReportItem(name = "listList2_1", length = 8, order = 27)
    public RString listList2_1;
    @ReportItem(name = "listList2_2", length = 8, order = 28)
    public RString listList2_2;
    @ReportItem(name = "listList2_3", length = 20, order = 29)
    public RString listList2_3;
    @ReportItem(name = "listList2_4", length = 8, order = 30)
    public RString listList2_4;
    @ReportItem(name = "listList2_5", length = 30, order = 31)
    public RString listList2_5;
    @ReportItem(name = "listList2_6", length = 4, order = 32)
    public RString listList2_6;
    @ReportItem(name = "listList2_7", length = 9, order = 33)
    public RString listList2_7;
    @ReportItem(name = "listList3_1", length = 12, order = 34)
    public RString listList3_1;
    @ReportItem(name = "listList3_2", length = 9, order = 35)
    public RString listList3_2;
    @ReportItem(name = "listList3_3", length = 7, order = 36)
    public RString listList3_3;
    @ReportItem(name = "listList3_4", length = 9, order = 37)
    public RString listList3_4;
    @ReportItem(name = "listList3_5", length = 9, order = 38)
    public RString listList3_5;
    @ReportItem(name = "listList3_6", length = 9, order = 39)
    public RString listList3_6;
    @ReportItem(name = "listList3_7", length = 10, order = 40)
    public RString listList3_7;
    @ReportItem(name = "listList3_8", length = 9, order = 41)
    public RString listList3_8;
    @ReportItem(name = "listList3_9", length = 10, order = 42)
    public RString listList3_9;
    @ReportItem(name = "listList3_10", length = 9, order = 43)
    public RString listList3_10;
    @ReportItem(name = "listList3_11", length = 7, order = 44)
    public RString listList3_11;
    @ReportItem(name = "listList3_12", length = 9, order = 45)
    public RString listList3_12;
    @ReportItem(name = "listList3_13", length = 9, order = 46)
    public RString listList3_13;
    @ReportItem(name = "listList4_1", length = 10, order = 47)
    public RString listList4_1;
    @ReportItem(name = "listList4_2", length = 9, order = 48)
    public RString listList4_2;
    @ReportItem(name = "listList4_3", length = 7, order = 49)
    public RString listList4_3;
    @ReportItem(name = "listList4_4", length = 10, order = 50)
    public RString listList4_4;
    @ReportItem(name = "listList4_5", length = 9, order = 51)
    public RString listList4_5;
    @ReportItem(name = "listList4_6", length = 9, order = 52)
    public RString listList4_6;
    @ReportItem(name = "listList4_7", length = 9, order = 53)
    public RString listList4_7;
    @ReportItem(name = "listList4_8", length = 10, order = 54)
    public RString listList4_8;
    @ReportItem(name = "listList4_9", length = 9, order = 55)
    public RString listList4_9;
    @ReportItem(name = "listList5_1", length = 12, order = 56)
    public RString listList5_1;
    @ReportItem(name = "listList5_2", length = 9, order = 57)
    public RString listList5_2;
    @ReportItem(name = "listList5_3", length = 6, order = 58)
    public RString listList5_3;
    @ReportItem(name = "listList5_4", length = 9, order = 59)
    public RString listList5_4;
    @ReportItem(name = "listList5_5", length = 9, order = 60)
    public RString listList5_5;
    @ReportItem(name = "listList5_6", length = 9, order = 61)
    public RString listList5_6;
    @ReportItem(name = "listList5_7", length = 9, order = 62)
    public RString listList5_7;
    @ReportItem(name = "listList5_8", length = 10, order = 63)
    public RString listList5_8;
    @ReportItem(name = "listList5_9", length = 9, order = 64)
    public RString listList5_9;
    @ReportItem(name = "listList5_10", length = 9, order = 65)
    public RString listList5_10;
    @ReportItem(name = "listList6_1", length = 10, order = 66)
    public RString listList6_1;
    @ReportItem(name = "listList6_2", length = 9, order = 67)
    public RString listList6_2;
    @ReportItem(name = "listList6_3", length = 10, order = 68)
    public RString listList6_3;
    @ReportItem(name = "listList6_4", length = 9, order = 69)
    public RString listList6_4;
    @ReportItem(name = "listList6_5", length = 9, order = 70)
    public RString listList6_5;
    @ReportItem(name = "listList6_6", length = 6, order = 71)
    public RString listList6_6;
    @ReportItem(name = "listList6_7", length = 9, order = 72)
    public RString listList6_7;
    @ReportItem(name = "listList6_8", length = 10, order = 73)
    public RString listList6_8;
    @ReportItem(name = "listList6_9", length = 10, order = 74)
    public RString listList6_9;
    @ReportItem(name = "listList6_10", length = 6, order = 75)
    public RString listList6_10;
    @ReportItem(name = "listList6_11", length = 9, order = 76)
    public RString listList6_11;
    @ReportItem(name = "listList7_1", length = 12, order = 77)
    public RString listList7_1;
    @ReportItem(name = "listList7_2", length = 12, order = 78)
    public RString listList7_2;
    @ReportItem(name = "listList7_3", length = 9, order = 79)
    public RString listList7_3;
    @ReportItem(name = "listList7_4", length = 6, order = 80)
    public RString listList7_4;
    @ReportItem(name = "listList7_5", length = 6, order = 81)
    public RString listList7_5;
    @ReportItem(name = "listList7_6", length = 6, order = 82)
    public RString listList7_6;
    @ReportItem(name = "listList7_7", length = 6, order = 83)
    public RString listList7_7;
    @ReportItem(name = "listList7_8", length = 9, order = 84)
    public RString listList7_8;
    @ReportItem(name = "listList7_9", length = 9, order = 85)
    public RString listList7_9;
    @ReportItem(name = "listList7_10", length = 8, order = 86)
    public RString listList7_10;
    @ReportItem(name = "listList7_11", length = 8, order = 87)
    public RString listList7_11;
    @ReportItem(name = "listList7_12", length = 10, order = 88)
    public RString listList7_12;
    @ReportItem(name = "listList8_1", length = 9, order = 89)
    public RString listList8_1;
    @ReportItem(name = "listList8_2", length = 9, order = 90)
    public RString listList8_2;
    @ReportItem(name = "listList8_3", length = 6, order = 91)
    public RString listList8_3;
    @ReportItem(name = "listList8_4", length = 6, order = 92)
    public RString listList8_4;
    @ReportItem(name = "listList8_5", length = 6, order = 93)
    public RString listList8_5;
    @ReportItem(name = "listList8_6", length = 6, order = 94)
    public RString listList8_6;
    @ReportItem(name = "listList8_7", length = 6, order = 95)
    public RString listList8_7;
    @ReportItem(name = "listList8_8", length = 9, order = 96)
    public RString listList8_8;
    @ReportItem(name = "listList8_9", length = 9, order = 97)
    public RString listList8_9;
    @ReportItem(name = "listList8_10", length = 9, order = 98)
    public RString listList8_10;
    @ReportItem(name = "listList8_11", length = 9, order = 99)
    public RString listList8_11;
    @ReportItem(name = "listList8_12", length = 8, order = 100)
    public RString listList8_12;
    @ReportItem(name = "listList8_13", length = 20, order = 101)
    public RString listList8_13;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    /**
     * KogakuKyufuTaishoshaIchiranSourceのENUM
     */
    public enum ReportSourceFields {
        printTimeStamp,
        title,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaiPege1,
        kaiPege2,
        kaiPege3,
        kaiPege4,
        kaiPege5,
        komokuName1,
        komokuName2,
        komokuName3,
        listList1_1,
        listList1_2,
        listList1_3,
        listList1_4,
        listList1_5,
        listList1_6,
        listList1_7,
        listList1_8,
        listList1_9,
        listList2_1,
        listList2_2,
        listList2_3,
        listList2_4,
        listList2_5,
        listList2_6,
        listList2_7,
        listList3_1,
        listList3_2,
        listList3_3,
        listList3_4,
        listList3_5,
        listList3_6,
        listList3_7,
        listList3_8,
        listList3_9,
        listList3_10,
        listList3_11,
        listList3_12,
        listList3_13,
        listList4_1,
        listList4_2,
        listList4_3,
        listList4_4,
        listList4_5,
        listList4_6,
        listList4_7,
        listList4_8,
        listList4_9,
        listList5_1,
        listList5_2,
        listList5_3,
        listList5_4,
        listList5_5,
        listList5_6,
        listList5_7,
        listList5_8,
        listList5_9,
        listList5_10,
        listList6_1,
        listList6_2,
        listList6_3,
        listList6_4,
        listList6_5,
        listList6_6,
        listList6_7,
        listList6_8,
        listList6_9,
        listList6_10,
        listList6_11,
        listList7_1,
        listList7_2,
        listList7_3,
        listList7_4,
        listList7_5,
        listList7_6,
        listList7_7,
        listList7_8,
        listList7_9,
        listList7_10,
        listList7_11,
        listList7_12,
        listList8_1,
        listList8_2,
        listList8_3,
        listList8_4,
        listList8_5,
        listList8_6,
        listList8_7,
        listList8_8,
        listList8_9,
        listList8_10,
        listList8_11,
        listList8_12,
        listList8_13;
    }
}
