package jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportKojinNo;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 24, order = 3)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 4)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 5)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 6)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 7)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 8)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 9)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 10)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 11)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 12)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 13)
    public RString kaipage5;
    @ReportItem(name = "listFuchoKi_1", length = 3, order = 14)
    public RString listFuchoKi_1;
    @ReportItem(name = "listFuchoKi_2", length = 3, order = 15)
    public RString listFuchoKi_2;
    @ReportItem(name = "listFuchoKi_3", length = 3, order = 16)
    public RString listFuchoKi_3;
    @ReportItem(name = "listFuchoKi_4", length = 3, order = 17)
    public RString listFuchoKi_4;
    @ReportItem(name = "listFuchoKi_5", length = 3, order = 18)
    public RString listFuchoKi_5;
    @ReportItem(name = "listFuchoKi_6", length = 3, order = 19)
    public RString listFuchoKi_6;
    @ReportItem(name = "listFuchoKi_7", length = 3, order = 20)
    public RString listFuchoKi_7;
    @ReportItem(name = "listFuchoKi_8", length = 3, order = 21)
    public RString listFuchoKi_8;
    @ReportItem(name = "listFuchoKi_9", length = 3, order = 22)
    public RString listFuchoKi_9;
    @ReportItem(name = "listFuchoKi_10", length = 3, order = 23)
    public RString listFuchoKi_10;
    @ReportItem(name = "listFuchoKi_11", length = 3, order = 24)
    public RString listFuchoKi_11;
    @ReportItem(name = "listFuchoKi_12", length = 3, order = 25)
    public RString listFuchoKi_12;
    @ReportItem(name = "listFuchoKi_13", length = 3, order = 26)
    public RString listFuchoKi_13;
    @ReportItem(name = "listFuchoKi_14", length = 3, order = 27)
    public RString listFuchoKi_14;
    @ReportItem(name = "list1_1", length = 16, order = 28)
    public RString list1_1;
    @ReportKojinNo(id = "A")
    @ReportItem(name = "list1_2", length = 20, order = 29)
    public RString list1_2;
    @ReportKojinNo(id = "A")
    @ReportItem(name = "list1_3", length = 39, order = 30)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 7, order = 31)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 3, order = 32)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 14, order = 33)
    public RString list1_6;
    @ReportItem(name = "list6_1", length = 10, order = 34)
    public RString list6_1;
    @ReportItem(name = "list2_1", length = 5, order = 35)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 5, order = 36)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 15, order = 37)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 15, order = 38)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 15, order = 39)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 2, order = 40)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 2, order = 41)
    public RString list2_7;
    @ReportItem(name = "list2_8", length = 2, order = 42)
    public RString list2_8;
    @ReportItem(name = "list2_9", length = 2, order = 43)
    public RString list2_9;
    @ReportItem(name = "list2_10", length = 2, order = 44)
    public RString list2_10;
    @ReportItem(name = "list2_11", length = 2, order = 45)
    public RString list2_11;
    @ReportItem(name = "list2_12", length = 2, order = 46)
    public RString list2_12;
    @ReportItem(name = "list2_13", length = 2, order = 47)
    public RString list2_13;
    @ReportItem(name = "list2_14", length = 2, order = 48)
    public RString list2_14;
    @ReportItem(name = "list2_15", length = 2, order = 49)
    public RString list2_15;
    @ReportItem(name = "list2_16", length = 2, order = 50)
    public RString list2_16;
    @ReportItem(name = "list2_17", length = 2, order = 51)
    public RString list2_17;
    @ReportItem(name = "list2_18", length = 15, order = 52)
    public RString list2_18;
    @ReportItem(name = "list2_19", length = 18, order = 53)
    public RString list2_19;
    @ReportItem(name = "list7_1", length = 10, order = 54)
    public RString list7_1;
    @ReportItem(name = "list3_1", length = 5, order = 55)
    public RString list3_1;
    @ReportItem(name = "list3_2", length = 5, order = 56)
    public RString list3_2;
    @ReportItem(name = "list3_3", length = 15, order = 57)
    public RString list3_3;
    @ReportItem(name = "list3_4", length = 15, order = 58)
    public RString list3_4;
    @ReportItem(name = "list3_5", length = 15, order = 59)
    public RString list3_5;
    @ReportItem(name = "list3_6", length = 2, order = 60)
    public RString list3_6;
    @ReportItem(name = "list3_7", length = 2, order = 61)
    public RString list3_7;
    @ReportItem(name = "list3_8", length = 2, order = 62)
    public RString list3_8;
    @ReportItem(name = "list3_9", length = 2, order = 63)
    public RString list3_9;
    @ReportItem(name = "list3_10", length = 2, order = 64)
    public RString list3_10;
    @ReportItem(name = "list3_11", length = 2, order = 65)
    public RString list3_11;
    @ReportItem(name = "list3_12", length = 2, order = 66)
    public RString list3_12;
    @ReportItem(name = "list3_13", length = 2, order = 67)
    public RString list3_13;
    @ReportItem(name = "list3_14", length = 2, order = 68)
    public RString list3_14;
    @ReportItem(name = "list3_15", length = 2, order = 69)
    public RString list3_15;
    @ReportItem(name = "list3_16", length = 2, order = 70)
    public RString list3_16;
    @ReportItem(name = "list3_17", length = 2, order = 71)
    public RString list3_17;
    @ReportItem(name = "list3_18", length = 15, order = 72)
    public RString list3_18;
    @ReportItem(name = "list3_19", length = 18, order = 73)
    public RString list3_19;
    @ReportItem(name = "list8_1", length = 10, order = 74)
    public RString list8_1;
    @ReportItem(name = "list4_1", length = 9, order = 75)
    public RString list4_1;
    @ReportItem(name = "list4_2", length = 7, order = 76)
    public RString list4_2;
    @ReportItem(name = "list4_3", length = 7, order = 77)
    public RString list4_3;
    @ReportItem(name = "list4_4", length = 7, order = 78)
    public RString list4_4;
    @ReportItem(name = "list4_5", length = 7, order = 79)
    public RString list4_5;
    @ReportItem(name = "list4_6", length = 7, order = 80)
    public RString list4_6;
    @ReportItem(name = "list4_7", length = 7, order = 81)
    public RString list4_7;
    @ReportItem(name = "list4_8", length = 7, order = 82)
    public RString list4_8;
    @ReportItem(name = "list4_9", length = 7, order = 83)
    public RString list4_9;
    @ReportItem(name = "list4_10", length = 7, order = 84)
    public RString list4_10;
    @ReportItem(name = "list4_11", length = 7, order = 85)
    public RString list4_11;
    @ReportItem(name = "list4_12", length = 7, order = 86)
    public RString list4_12;
    @ReportItem(name = "list4_13", length = 7, order = 87)
    public RString list4_13;
    @ReportItem(name = "list4_14", length = 7, order = 88)
    public RString list4_14;
    @ReportItem(name = "list4_15", length = 7, order = 89)
    public RString list4_15;
    @ReportItem(name = "list4_16", length = 7, order = 90)
    public RString list4_16;
    @ReportItem(name = "list4_17", length = 7, order = 91)
    public RString list4_17;
    @ReportItem(name = "list4_18", length = 7, order = 92)
    public RString list4_18;
    @ReportItem(name = "list4_19", length = 7, order = 93)
    public RString list4_19;
    @ReportItem(name = "list4_20", length = 7, order = 94)
    public RString list4_20;
    @ReportItem(name = "list4_21", length = 7, order = 95)
    public RString list4_21;
    @ReportItem(name = "list9_1", length = 10, order = 96)
    public RString list9_1;
    @ReportItem(name = "list5_1", length = 9, order = 97)
    public RString list5_1;
    @ReportItem(name = "list5_2", length = 7, order = 98)
    public RString list5_2;
    @ReportItem(name = "list5_3", length = 7, order = 99)
    public RString list5_3;
    @ReportItem(name = "list5_4", length = 7, order = 100)
    public RString list5_4;
    @ReportItem(name = "list5_5", length = 7, order = 101)
    public RString list5_5;
    @ReportItem(name = "list5_6", length = 7, order = 102)
    public RString list5_6;
    @ReportItem(name = "list5_7", length = 7, order = 103)
    public RString list5_7;
    @ReportItem(name = "list5_8", length = 7, order = 104)
    public RString list5_8;
    @ReportItem(name = "list5_9", length = 7, order = 105)
    public RString list5_9;
    @ReportItem(name = "list5_10", length = 7, order = 106)
    public RString list5_10;
    @ReportItem(name = "list5_11", length = 7, order = 107)
    public RString list5_11;
    @ReportItem(name = "list5_12", length = 7, order = 108)
    public RString list5_12;
    @ReportItem(name = "list5_13", length = 7, order = 109)
    public RString list5_13;
    @ReportItem(name = "list5_14", length = 7, order = 110)
    public RString list5_14;
    @ReportItem(name = "list5_15", length = 7, order = 111)
    public RString list5_15;
    @ReportItem(name = "list5_16", length = 7, order = 112)
    public RString list5_16;
    @ReportItem(name = "list5_17", length = 7, order = 113)
    public RString list5_17;
    @ReportItem(name = "list5_18", length = 7, order = 114)
    public RString list5_18;
    @ReportItem(name = "list5_19", length = 7, order = 115)
    public RString list5_19;
    @ReportItem(name = "list5_20", length = 7, order = 116)
    public RString list5_20;
    @ReportItem(name = "list5_21", length = 7, order = 117)
    public RString list5_21;
    @ReportItem(name = "list10_1", length = 10, order = 118)
    public RString list10_1;
    @ReportItem(name = "shikibetsuCode", length = 10, order = 119)
    public RString shikibetsuCode;
    @ReportItem(name = "kanaMeisho", length = 10, order = 120)
    public RString kanaMeisho;
    @ReportItem(name = "seinengappiYMD", length = 10, order = 121)
    public RString seinengappiYMD;
    @ReportItem(name = "seibetsuCode", length = 10, order = 122)
    public RString seibetsuCode;
    @ReportItem(name = "shichosonCode", length = 10, order = 123)
    public RString shichosonCode;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 124)
    public RString hihokenshaNo;
    @ReportItem(name = "nenkinCode", length = 10, order = 125)
    public RString nenkinCode;
    @ReportItem(name = "nenkinNo", length = 10, order = 126)
    public RString nenkinNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * KanendoIdouKekkaIchiranSourceのenum
     */
    public enum DBB200027ReportSourceFields {

        printTimeStamp,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listFuchoKi_1,
        listFuchoKi_2,
        listFuchoKi_3,
        listFuchoKi_4,
        listFuchoKi_5,
        listFuchoKi_6,
        listFuchoKi_7,
        listFuchoKi_8,
        listFuchoKi_9,
        listFuchoKi_10,
        listFuchoKi_11,
        listFuchoKi_12,
        listFuchoKi_13,
        listFuchoKi_14,
        list1_1,
        list1_2,
        list1_3,
        list1_4,
        list1_5,
        list1_6,
        list6_1,
        list2_1,
        list2_2,
        list2_3,
        list2_4,
        list2_5,
        list2_6,
        list2_7,
        list2_8,
        list2_9,
        list2_10,
        list2_11,
        list2_12,
        list2_13,
        list2_14,
        list2_15,
        list2_16,
        list2_17,
        list2_18,
        list2_19,
        list7_1,
        list3_1,
        list3_2,
        list3_3,
        list3_4,
        list3_5,
        list3_6,
        list3_7,
        list3_8,
        list3_9,
        list3_10,
        list3_11,
        list3_12,
        list3_13,
        list3_14,
        list3_15,
        list3_16,
        list3_17,
        list3_18,
        list3_19,
        list8_1,
        list4_1,
        list4_2,
        list4_3,
        list4_4,
        list4_5,
        list4_6,
        list4_7,
        list4_8,
        list4_9,
        list4_10,
        list4_11,
        list4_12,
        list4_13,
        list4_14,
        list4_15,
        list4_16,
        list4_17,
        list4_18,
        list4_19,
        list4_20,
        list4_21,
        list9_1,
        list5_1,
        list5_2,
        list5_3,
        list5_4,
        list5_5,
        list5_6,
        list5_7,
        list5_8,
        list5_9,
        list5_10,
        list5_11,
        list5_12,
        list5_13,
        list5_14,
        list5_15,
        list5_16,
        list5_17,
        list5_18,
        list5_19,
        list5_20,
        list5_21,
        list10_1,
        shikibetsuCode,
        kanaMeisho,
        seinengappiYMD,
        seibetsuCode,
        shichosonCode,
        hihokenshaNo,
        nenkinCode,
        nenkinNo
    }
}
