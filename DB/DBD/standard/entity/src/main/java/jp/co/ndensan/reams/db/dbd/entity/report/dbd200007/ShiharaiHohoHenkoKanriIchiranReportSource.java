package jp.co.ndensan.reams.db.dbd.entity.report.dbd200007;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 支払方法変更管理リストのReportSource
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
public class ShiharaiHohoHenkoKanriIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 19, order = 2)
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
    @ReportItem(name = "listUpper1_1", length = 10, order = 15)
    public RString listUpper1_1;
    @ReportItem(name = "listUpper1_2", length = 24, order = 16)
    public RString listUpper1_2;
    @ReportItem(name = "listUpper1_3", length = 15, order = 17)
    public RString listUpper1_3;
    @ReportItem(name = "listUpper1_4", length = 9, order = 18)
    public RString listUpper1_4;
    @ReportItem(name = "listUpper1_5", length = 11, order = 19)
    public RString listUpper1_5;
    @ReportItem(name = "listUpper1_6", length = 11, order = 20)
    public RString listUpper1_6;
    @ReportItem(name = "listUpper1_7", length = 6, order = 21)
    public RString listUpper1_7;
    @ReportItem(name = "listUpper1_8", length = 2, order = 22)
    public RString listUpper1_8;
    @ReportItem(name = "listUpper1_9", length = 1, order = 23)
    public RString listUpper1_9;
    @ReportItem(name = "listUpper1_10", length = 1, order = 24)
    public RString listUpper1_10;
    @ReportItem(name = "listUpper1_11", length = 4, order = 25)
    public RString listUpper1_11;
    @ReportItem(name = "listUpper1_12", length = 19, order = 26)
    public RString listUpper1_12;
    @ReportItem(name = "listUpper1_13", length = 3, order = 27)
    public RString listUpper1_13;
    @ReportItem(name = "listUpper1_14", length = 9, order = 28)
    public RString listUpper1_14;
    @ReportItem(name = "listUpper1_15", length = 3, order = 29)
    public RString listUpper1_15;
    @ReportItem(name = "listUpper2_1", length = 15, order = 30)
    public RString listUpper2_1;
    @ReportItem(name = "listUpper2_2", length = 16, order = 31)
    public RString listUpper2_2;
    @ReportItem(name = "listUpper2_3", length = 8, order = 32)
    public RString listUpper2_3;
    @ReportItem(name = "listUpper2_4", length = 11, order = 33)
    public RString listUpper2_4;
    @ReportItem(name = "listUpper2_5", length = 8, order = 34)
    public RString listUpper2_5;
    @ReportItem(name = "listUpper2_6", length = 20, order = 35)
    public RString listUpper2_6;
    @ReportItem(name = "listUpper2_7", length = 9, order = 36)
    public RString listUpper2_7;
    @ReportItem(name = "listUpper2_8", length = 3, order = 37)
    public RString listUpper2_8;
    @ReportItem(name = "listUpper2_9", length = 9, order = 38)
    public RString listUpper2_9;
    @ReportItem(name = "listUpper2_10", length = 10, order = 39)
    public RString listUpper2_10;
    @ReportItem(name = "listUpper2_11", length = 6, order = 40)
    public RString listUpper2_11;
    @ReportItem(name = "listUpper2_12", length = 3, order = 41)
    public RString listUpper2_12;
    @ReportItem(name = "nendoUpper1", length = 11, order = 42)
    public RString nendoUpper1;
    @ReportItem(name = "nendoUpper2", length = 11, order = 43)
    public RString nendoUpper2;
    @ReportItem(name = "nendoUpper3", length = 11, order = 44)
    public RString nendoUpper3;
    @ReportItem(name = "kanriJokyoUpper", length = 8, order = 45)
    public RString kanriJokyoUpper;
    @ReportItem(name = "listUpper6_1", length = 9, order = 46)
    public RString listUpper6_1;
    @ReportItem(name = "listUpper3_1", length = 4, order = 47)
    public RString listUpper3_1;
    @ReportItem(name = "listUpper3_2", length = 7, order = 48)
    public RString listUpper3_2;
    @ReportItem(name = "listUpper3_3", length = 9, order = 49)
    public RString listUpper3_3;
    @ReportItem(name = "listUpper3_4", length = 7, order = 50)
    public RString listUpper3_4;
    @ReportItem(name = "listUpper3_5", length = 1, order = 51)
    public RString listUpper3_5;
    @ReportItem(name = "listUpper3_6", length = 9, order = 52)
    public RString listUpper3_6;
    @ReportItem(name = "listUpper3_7", length = 1, order = 53)
    public RString listUpper3_7;
    @ReportItem(name = "listUpper4_1", length = 4, order = 54)
    public RString listUpper4_1;
    @ReportItem(name = "listUpper4_2", length = 7, order = 55)
    public RString listUpper4_2;
    @ReportItem(name = "listUpper4_3", length = 9, order = 56)
    public RString listUpper4_3;
    @ReportItem(name = "listUpper4_4", length = 7, order = 57)
    public RString listUpper4_4;
    @ReportItem(name = "listUpper4_5", length = 1, order = 58)
    public RString listUpper4_5;
    @ReportItem(name = "listUpper4_6", length = 9, order = 59)
    public RString listUpper4_6;
    @ReportItem(name = "listUpper4_7", length = 1, order = 60)
    public RString listUpper4_7;
    @ReportItem(name = "listUpper5_1", length = 4, order = 61)
    public RString listUpper5_1;
    @ReportItem(name = "listUpper5_2", length = 7, order = 62)
    public RString listUpper5_2;
    @ReportItem(name = "listUpper5_3", length = 9, order = 63)
    public RString listUpper5_3;
    @ReportItem(name = "listUpper5_4", length = 7, order = 64)
    public RString listUpper5_4;
    @ReportItem(name = "listUpper5_5", length = 1, order = 65)
    public RString listUpper5_5;
    @ReportItem(name = "listUpper5_6", length = 9, order = 66)
    public RString listUpper5_6;
    @ReportItem(name = "listUpper5_7", length = 1, order = 67)
    public RString listUpper5_7;
    @ReportItem(name = "kanriEndUpper", length = 8, order = 68)
    public RString kanriEndUpper;
    @ReportItem(name = "shunonashiUpper", length = 50, order = 69)
    public RString shunonashiUpper;
    @ReportItem(name = "saichoKikanUpper", length = 8, order = 70)
    public RString saichoKikanUpper;
    @ReportItem(name = "izenTainogakuUpper", length = 9, order = 71)
    public RString izenTainogakuUpper;
    @ReportItem(name = "izenKbnUpper", length = 1, order = 72)
    public RString izenKbnUpper;
    @ReportItem(name = "hokenryogakuGokeiUpper1", length = 9, order = 73)
    public RString hokenryogakuGokeiUpper1;
    @ReportItem(name = "tainogakuGokeiUpper1", length = 9, order = 74)
    public RString tainogakuGokeiUpper1;
    @ReportItem(name = "hokenryogakuGokeiUpper2", length = 9, order = 75)
    public RString hokenryogakuGokeiUpper2;
    @ReportItem(name = "hokenryogakuGokeiUpper3", length = 9, order = 76)
    public RString hokenryogakuGokeiUpper3;
    @ReportItem(name = "tainogakuGokeiUpper2", length = 9, order = 77)
    public RString tainogakuGokeiUpper2;
    @ReportItem(name = "tainogakuGokeiUpper3", length = 9, order = 78)
    public RString tainogakuGokeiUpper3;
    @ReportItem(name = "listLower1_1", length = 10, order = 79)
    public RString listLower1_1;
    @ReportItem(name = "listLower1_2", length = 24, order = 80)
    public RString listLower1_2;
    @ReportItem(name = "listLower1_3", length = 15, order = 81)
    public RString listLower1_3;
    @ReportItem(name = "listLower1_4", length = 9, order = 82)
    public RString listLower1_4;
    @ReportItem(name = "listLower1_5", length = 11, order = 83)
    public RString listLower1_5;
    @ReportItem(name = "listLower1_6", length = 11, order = 84)
    public RString listLower1_6;
    @ReportItem(name = "listLower1_7", length = 6, order = 85)
    public RString listLower1_7;
    @ReportItem(name = "listLower1_8", length = 2, order = 86)
    public RString listLower1_8;
    @ReportItem(name = "listLower1_9", length = 1, order = 87)
    public RString listLower1_9;
    @ReportItem(name = "listLower1_10", length = 1, order = 88)
    public RString listLower1_10;
    @ReportItem(name = "listLower1_11", length = 4, order = 89)
    public RString listLower1_11;
    @ReportItem(name = "listLower1_12", length = 19, order = 90)
    public RString listLower1_12;
    @ReportItem(name = "listLower1_13", length = 3, order = 91)
    public RString listLower1_13;
    @ReportItem(name = "listLower1_14", length = 9, order = 92)
    public RString listLower1_14;
    @ReportItem(name = "listLower1_15", length = 3, order = 93)
    public RString listLower1_15;
    @ReportItem(name = "listLower2_1", length = 15, order = 94)
    public RString listLower2_1;
    @ReportItem(name = "listLower2_2", length = 16, order = 95)
    public RString listLower2_2;
    @ReportItem(name = "listLower2_3", length = 8, order = 96)
    public RString listLower2_3;
    @ReportItem(name = "listLower2_4", length = 11, order = 97)
    public RString listLower2_4;
    @ReportItem(name = "listLower2_5", length = 8, order = 98)
    public RString listLower2_5;
    @ReportItem(name = "listLower2_6", length = 20, order = 99)
    public RString listLower2_6;
    @ReportItem(name = "listLower2_7", length = 9, order = 100)
    public RString listLower2_7;
    @ReportItem(name = "listLower2_8", length = 3, order = 101)
    public RString listLower2_8;
    @ReportItem(name = "listLower2_9", length = 9, order = 102)
    public RString listLower2_9;
    @ReportItem(name = "listLower2_10", length = 10, order = 103)
    public RString listLower2_10;
    @ReportItem(name = "listLower2_11", length = 6, order = 104)
    public RString listLower2_11;
    @ReportItem(name = "listLower2_12", length = 3, order = 105)
    public RString listLower2_12;
    @ReportItem(name = "nendoLower1", length = 11, order = 106)
    public RString nendoLower1;
    @ReportItem(name = "nendoLower2", length = 11, order = 107)
    public RString nendoLower2;
    @ReportItem(name = "nendoLower3", length = 11, order = 108)
    public RString nendoLower3;
    @ReportItem(name = "kanriJokyoLower", length = 8, order = 109)
    public RString kanriJokyoLower;
    @ReportItem(name = "listLower6_1", length = 9, order = 110)
    public RString listLower6_1;
    @ReportItem(name = "listLower3_1", length = 4, order = 111)
    public RString listLower3_1;
    @ReportItem(name = "listLower3_2", length = 7, order = 112)
    public RString listLower3_2;
    @ReportItem(name = "listLower3_3", length = 9, order = 113)
    public RString listLower3_3;
    @ReportItem(name = "listLower3_4", length = 7, order = 114)
    public RString listLower3_4;
    @ReportItem(name = "listLower3_5", length = 1, order = 115)
    public RString listLower3_5;
    @ReportItem(name = "listLower3_6", length = 9, order = 116)
    public RString listLower3_6;
    @ReportItem(name = "listLower3_7", length = 1, order = 117)
    public RString listLower3_7;
    @ReportItem(name = "listLower4_1", length = 4, order = 118)
    public RString listLower4_1;
    @ReportItem(name = "listLower4_2", length = 7, order = 119)
    public RString listLower4_2;
    @ReportItem(name = "listLower4_3", length = 9, order = 120)
    public RString listLower4_3;
    @ReportItem(name = "listLower4_4", length = 7, order = 121)
    public RString listLower4_4;
    @ReportItem(name = "listLower4_5", length = 1, order = 122)
    public RString listLower4_5;
    @ReportItem(name = "listLower4_6", length = 9, order = 123)
    public RString listLower4_6;
    @ReportItem(name = "listLower4_7", length = 1, order = 124)
    public RString listLower4_7;
    @ReportItem(name = "listLower5_1", length = 4, order = 125)
    public RString listLower5_1;
    @ReportItem(name = "listLower5_2", length = 7, order = 126)
    public RString listLower5_2;
    @ReportItem(name = "listLower5_3", length = 9, order = 127)
    public RString listLower5_3;
    @ReportItem(name = "listLower5_4", length = 7, order = 128)
    public RString listLower5_4;
    @ReportItem(name = "listLower5_5", length = 1, order = 129)
    public RString listLower5_5;
    @ReportItem(name = "listLower5_6", length = 9, order = 130)
    public RString listLower5_6;
    @ReportItem(name = "listLower5_7", length = 1, order = 131)
    public RString listLower5_7;
    @ReportItem(name = "kanriEndLower", length = 8, order = 132)
    public RString kanriEndLower;
    @ReportItem(name = "shunonashiLower", length = 50, order = 133)
    public RString shunonashiLower;
    @ReportItem(name = "saichoKikanLower", length = 8, order = 134)
    public RString saichoKikanLower;
    @ReportItem(name = "izenTainogakuLower", length = 9, order = 135)
    public RString izenTainogakuLower;
    @ReportItem(name = "izenKbnLower", length = 1, order = 136)
    public RString izenKbnLower;
    @ReportItem(name = "hokenryogakuGokeiLower1", length = 9, order = 137)
    public RString hokenryogakuGokeiLower1;
    @ReportItem(name = "tainogakuGokeiLower1", length = 9, order = 138)
    public RString tainogakuGokeiLower1;
    @ReportItem(name = "hokenryogakuGokeiLower2", length = 9, order = 139)
    public RString hokenryogakuGokeiLower2;
    @ReportItem(name = "tainogakuGokeiLower2", length = 9, order = 140)
    public RString tainogakuGokeiLower2;
    @ReportItem(name = "hokenryogakuGokeiLower3", length = 9, order = 141)
    public RString hokenryogakuGokeiLower3;
    @ReportItem(name = "tainogakuGokeiLower3", length = 9, order = 142)
    public RString tainogakuGokeiLower3;
    @ReportItem(name = "formid", length = 9, order = 143)
    public RString formid;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
