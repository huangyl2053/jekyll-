package jp.co.ndensan.reams.db.dbd.entity.report.dbd200008;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 給付額減額把握リストReportSourceです。
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
public class KyufuGengakuHaakuIchiranReportSource implements IReportSource {
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
    @ReportItem(name = "listUpper1_2", length = 44, order = 16)
    public RString listUpper1_2;
    @ReportItem(name = "listUpper1_3", length = 15, order = 17)
    public RString listUpper1_3;
    @ReportItem(name = "listUpper1_4", length = 9, order = 18)
    public RString listUpper1_4;
    @ReportItem(name = "listUpper1_5", length = 9, order = 19)
    public RString listUpper1_5;
    @ReportItem(name = "listUpper1_6", length = 9, order = 20)
    public RString listUpper1_6;
    @ReportItem(name = "listUpper1_7", length = 6, order = 21)
    public RString listUpper1_7;
    @ReportItem(name = "listUpper1_8", length = 2, order = 22)
    public RString listUpper1_8;
    @ReportItem(name = "listUpper1_9", length = 1, order = 23)
    public RString listUpper1_9;
    @ReportItem(name = "listUpper1_10", length = 1, order = 24)
    public RString listUpper1_10;
    @ReportItem(name = "listUpper1_11", length = 5, order = 25)
    public RString listUpper1_11;
    @ReportItem(name = "listUpper1_12", length = 21, order = 26)
    public RString listUpper1_12;
    @ReportItem(name = "shometsuKikan", length = 6, order = 27)
    public RString shometsuKikan;
    @ReportItem(name = "nofusumiKikan", length = 6, order = 28)
    public RString nofusumiKikan;
    @ReportItem(name = "gengakuKikan", length = 3, order = 29)
    public RString gengakuKikan;
    @ReportItem(name = "listUpper2_1", length = 15, order = 30)
    public RString listUpper2_1;
    @ReportItem(name = "listUpper2_2", length = 22, order = 31)
    public RString listUpper2_2;
    @ReportItem(name = "listUpper2_3", length = 8, order = 32)
    public RString listUpper2_3;
    @ReportItem(name = "listUpper2_4", length = 11, order = 33)
    public RString listUpper2_4;
    @ReportItem(name = "listUpper2_5", length = 8, order = 34)
    public RString listUpper2_5;
    @ReportItem(name = "listUpper2_6", length = 21, order = 35)
    public RString listUpper2_6;
    @ReportItem(name = "listUpper2_7", length = 10, order = 36)
    public RString listUpper2_7;
    @ReportItem(name = "listUpper2_8", length = 3, order = 37)
    public RString listUpper2_8;
    @ReportItem(name = "listUpper2_9", length = 10, order = 38)
    public RString listUpper2_9;
    @ReportItem(name = "nendoUpper1", length = 19, order = 39)
    public RString nendoUpper1;
    @ReportItem(name = "nendoUpper2", length = 19, order = 40)
    public RString nendoUpper2;
    @ReportItem(name = "nendoUpper3", length = 19, order = 41)
    public RString nendoUpper3;
    @ReportItem(name = "nendoUpper4", length = 19, order = 42)
    public RString nendoUpper4;
    @ReportItem(name = "nendoUpper5", length = 19, order = 43)
    public RString nendoUpper5;
    @ReportItem(name = "listNendoBun1_1", length = 4, order = 44)
    public RString listNendoBun1_1;
    @ReportItem(name = "listNendoBun1_2", length = 7, order = 45)
    public RString listNendoBun1_2;
    @ReportItem(name = "listNendoBun1_3", length = 7, order = 46)
    public RString listNendoBun1_3;
    @ReportItem(name = "listNendoBun1_4", length = 1, order = 47)
    public RString listNendoBun1_4;
    @ReportItem(name = "listNendoBun1_5", length = 10, order = 48)
    public RString listNendoBun1_5;
    @ReportItem(name = "listNendoBun1_6", length = 1, order = 49)
    public RString listNendoBun1_6;
    @ReportItem(name = "listNendoBun2_1", length = 4, order = 50)
    public RString listNendoBun2_1;
    @ReportItem(name = "listNendoBun2_2", length = 7, order = 51)
    public RString listNendoBun2_2;
    @ReportItem(name = "listNendoBun2_3", length = 7, order = 52)
    public RString listNendoBun2_3;
    @ReportItem(name = "listNendoBun2_4", length = 1, order = 53)
    public RString listNendoBun2_4;
    @ReportItem(name = "listNendoBun2_5", length = 10, order = 54)
    public RString listNendoBun2_5;
    @ReportItem(name = "listNendoBun2_6", length = 1, order = 55)
    public RString listNendoBun2_6;
    @ReportItem(name = "listNendoBun3_1", length = 4, order = 56)
    public RString listNendoBun3_1;
    @ReportItem(name = "listNendoBun3_2", length = 7, order = 57)
    public RString listNendoBun3_2;
    @ReportItem(name = "listNendoBun3_3", length = 7, order = 58)
    public RString listNendoBun3_3;
    @ReportItem(name = "listNendoBun3_4", length = 1, order = 59)
    public RString listNendoBun3_4;
    @ReportItem(name = "listNendoBun3_5", length = 10, order = 60)
    public RString listNendoBun3_5;
    @ReportItem(name = "listNendoBun3_6", length = 1, order = 61)
    public RString listNendoBun3_6;
    @ReportItem(name = "listNendoBun4_1", length = 4, order = 62)
    public RString listNendoBun4_1;
    @ReportItem(name = "listNendoBun4_2", length = 7, order = 63)
    public RString listNendoBun4_2;
    @ReportItem(name = "listNendoBun4_3", length = 7, order = 64)
    public RString listNendoBun4_3;
    @ReportItem(name = "listNendoBun4_4", length = 1, order = 65)
    public RString listNendoBun4_4;
    @ReportItem(name = "listNendoBun4_5", length = 10, order = 66)
    public RString listNendoBun4_5;
    @ReportItem(name = "listNendoBun4_6", length = 1, order = 67)
    public RString listNendoBun4_6;
    @ReportItem(name = "listNendoBun5_1", length = 4, order = 68)
    public RString listNendoBun5_1;
    @ReportItem(name = "listNendoBun5_2", length = 7, order = 69)
    public RString listNendoBun5_2;
    @ReportItem(name = "listNendoBun5_3", length = 7, order = 70)
    public RString listNendoBun5_3;
    @ReportItem(name = "listNendoBun5_4", length = 1, order = 71)
    public RString listNendoBun5_4;
    @ReportItem(name = "listNendoBun5_5", length = 10, order = 72)
    public RString listNendoBun5_5;
    @ReportItem(name = "listNendoBun5_6", length = 1, order = 73)
    public RString listNendoBun5_6;
    @ReportItem(name = "shunonashiUpper5", length = 20, order = 74)
    public RString shunonashiUpper5;
    @ReportItem(name = "shunonashiUpper3", length = 20, order = 75)
    public RString shunonashiUpper3;
    @ReportItem(name = "shunonashiUpper1", length = 20, order = 76)
    public RString shunonashiUpper1;
    @ReportItem(name = "shunonashiUpper2", length = 20, order = 77)
    public RString shunonashiUpper2;
    @ReportItem(name = "shunonashiUpper4", length = 20, order = 78)
    public RString shunonashiUpper4;
    @ReportItem(name = "hokenryogakuGokei1", length = 7, order = 79)
    public RString hokenryogakuGokei1;
    @ReportItem(name = "tainogakuGokei1", length = 7, order = 80)
    public RString tainogakuGokei1;
    @ReportItem(name = "soGokei1", length = 10, order = 81)
    public RString soGokei1;
    @ReportItem(name = "hokenryogakuGokei2", length = 7, order = 82)
    public RString hokenryogakuGokei2;
    @ReportItem(name = "tainogakuGokei2", length = 7, order = 83)
    public RString tainogakuGokei2;
    @ReportItem(name = "soGokei2", length = 10, order = 84)
    public RString soGokei2;
    @ReportItem(name = "hokenryogakuGokei3", length = 7, order = 85)
    public RString hokenryogakuGokei3;
    @ReportItem(name = "tainogakuGokei3", length = 7, order = 86)
    public RString tainogakuGokei3;
    @ReportItem(name = "soGokei3", length = 10, order = 87)
    public RString soGokei3;
    @ReportItem(name = "hokenryogakuGokei4", length = 7, order = 88)
    public RString hokenryogakuGokei4;
    @ReportItem(name = "tainogakuGokei4", length = 7, order = 89)
    public RString tainogakuGokei4;
    @ReportItem(name = "soGokei4", length = 10, order = 90)
    public RString soGokei4;
    @ReportItem(name = "hokenryogakuGokei5", length = 7, order = 91)
    public RString hokenryogakuGokei5;
    @ReportItem(name = "tainogakuGokei5", length = 7, order = 92)
    public RString tainogakuGokei5;
    @ReportItem(name = "soGokei5", length = 10, order = 93)
    public RString soGokei5;
    @ReportItem(name = "nendoLower1", length = 19, order = 94)
    public RString nendoLower1;
    @ReportItem(name = "nendoLower2", length = 19, order = 95)
    public RString nendoLower2;
    @ReportItem(name = "nendoLower3", length = 19, order = 96)
    public RString nendoLower3;
    @ReportItem(name = "nendoLower4", length = 19, order = 97)
    public RString nendoLower4;
    @ReportItem(name = "nendoLower5", length = 19, order = 98)
    public RString nendoLower5;
    @ReportItem(name = "listNendoBun6_1", length = 4, order = 99)
    public RString listNendoBun6_1;
    @ReportItem(name = "listNendoBun6_2", length = 7, order = 100)
    public RString listNendoBun6_2;
    @ReportItem(name = "listNendoBun6_3", length = 7, order = 101)
    public RString listNendoBun6_3;
    @ReportItem(name = "listNendoBun6_4", length = 1, order = 102)
    public RString listNendoBun6_4;
    @ReportItem(name = "listNendoBun6_5", length = 10, order = 103)
    public RString listNendoBun6_5;
    @ReportItem(name = "listNendoBun6_6", length = 1, order = 104)
    public RString listNendoBun6_6;
    @ReportItem(name = "listNendoBun7_1", length = 4, order = 105)
    public RString listNendoBun7_1;
    @ReportItem(name = "listNendoBun7_2", length = 7, order = 106)
    public RString listNendoBun7_2;
    @ReportItem(name = "listNendoBun7_3", length = 7, order = 107)
    public RString listNendoBun7_3;
    @ReportItem(name = "listNendoBun7_4", length = 1, order = 108)
    public RString listNendoBun7_4;
    @ReportItem(name = "listNendoBun7_5", length = 10, order = 109)
    public RString listNendoBun7_5;
    @ReportItem(name = "listNendoBun7_6", length = 1, order = 110)
    public RString listNendoBun7_6;
    @ReportItem(name = "listNendoBun8_1", length = 4, order = 111)
    public RString listNendoBun8_1;
    @ReportItem(name = "listNendoBun8_2", length = 7, order = 112)
    public RString listNendoBun8_2;
    @ReportItem(name = "listNendoBun8_3", length = 7, order = 113)
    public RString listNendoBun8_3;
    @ReportItem(name = "listNendoBun8_4", length = 1, order = 114)
    public RString listNendoBun8_4;
    @ReportItem(name = "listNendoBun8_5", length = 10, order = 115)
    public RString listNendoBun8_5;
    @ReportItem(name = "listNendoBun8_6", length = 1, order = 116)
    public RString listNendoBun8_6;
    @ReportItem(name = "listNendoBun9_1", length = 4, order = 117)
    public RString listNendoBun9_1;
    @ReportItem(name = "listNendoBun9_2", length = 7, order = 118)
    public RString listNendoBun9_2;
    @ReportItem(name = "listNendoBun9_3", length = 7, order = 119)
    public RString listNendoBun9_3;
    @ReportItem(name = "listNendoBun9_4", length = 1, order = 120)
    public RString listNendoBun9_4;
    @ReportItem(name = "listNendoBun9_5", length = 10, order = 121)
    public RString listNendoBun9_5;
    @ReportItem(name = "listNendoBun9_6", length = 1, order = 122)
    public RString listNendoBun9_6;
    @ReportItem(name = "listNendoBun10_1", length = 4, order = 123)
    public RString listNendoBun10_1;
    @ReportItem(name = "listNendoBun10_2", length = 7, order = 124)
    public RString listNendoBun10_2;
    @ReportItem(name = "listNendoBun10_3", length = 7, order = 125)
    public RString listNendoBun10_3;
    @ReportItem(name = "listNendoBun10_4", length = 1, order = 126)
    public RString listNendoBun10_4;
    @ReportItem(name = "listNendoBun10_5", length = 10, order = 127)
    public RString listNendoBun10_5;
    @ReportItem(name = "listNendoBun10_6", length = 1, order = 128)
    public RString listNendoBun10_6;
    @ReportItem(name = "shunonashiLower1", length = 20, order = 129)
    public RString shunonashiLower1;
    @ReportItem(name = "shunonashiLower2", length = 20, order = 130)
    public RString shunonashiLower2;
    @ReportItem(name = "shunonashiLower3", length = 20, order = 131)
    public RString shunonashiLower3;
    @ReportItem(name = "shunonashiLower4", length = 20, order = 132)
    public RString shunonashiLower4;
    @ReportItem(name = "shunonashiLower5", length = 20, order = 133)
    public RString shunonashiLower5;
    @ReportItem(name = "hokenryogakuGokei6", length = 7, order = 134)
    public RString hokenryogakuGokei6;
    @ReportItem(name = "tainogakuGokei6", length = 7, order = 135)
    public RString tainogakuGokei6;
    @ReportItem(name = "soGokei6", length = 10, order = 136)
    public RString soGokei6;
    @ReportItem(name = "hokenryogakuGokei7", length = 7, order = 137)
    public RString hokenryogakuGokei7;
    @ReportItem(name = "tainogakuGokei7", length = 7, order = 138)
    public RString tainogakuGokei7;
    @ReportItem(name = "soGokei7", length = 10, order = 139)
    public RString soGokei7;
    @ReportItem(name = "hokenryogakuGokei8", length = 7, order = 140)
    public RString hokenryogakuGokei8;
    @ReportItem(name = "tainogakuGokei8", length = 7, order = 141)
    public RString tainogakuGokei8;
    @ReportItem(name = "soGokei8", length = 10, order = 142)
    public RString soGokei8;
    @ReportItem(name = "hokenryogakuGokei9", length = 7, order = 143)
    public RString hokenryogakuGokei9;
    @ReportItem(name = "tainogakuGokei9", length = 7, order = 144)
    public RString tainogakuGokei9;
    @ReportItem(name = "soGokei9", length = 10, order = 145)
    public RString soGokei9;
    @ReportItem(name = "hokenryogakuGokei10", length = 7, order = 146)
    public RString hokenryogakuGokei10;
    @ReportItem(name = "tainogakuGokei10", length = 7, order = 147)
    public RString tainogakuGokei10;
    @ReportItem(name = "soGokei10", length = 10, order = 148)
    public RString soGokei10;
    @ReportItem(name = "listGengakuJohoUpper_1", length = 2, order = 149)
    public RString listGengakuJohoUpper_1;
    @ReportItem(name = "listGengakuJohoUpper_2", length = 6, order = 150)
    public RString listGengakuJohoUpper_2;
    @ReportItem(name = "listGengakuJohoUpper_3", length = 6, order = 151)
    public RString listGengakuJohoUpper_3;
    @ReportItem(name = "listGengakuJohoUpper_4", length = 3, order = 152)
    public RString listGengakuJohoUpper_4;
    @ReportItem(name = "listGengakuJohoUpper_5", length = 2, order = 153)
    public RString listGengakuJohoUpper_5;
    @ReportItem(name = "listGengakuJohoUpper_6", length = 6, order = 154)
    public RString listGengakuJohoUpper_6;
    @ReportItem(name = "listGengakuJohoUpper_7", length = 6, order = 155)
    public RString listGengakuJohoUpper_7;
    @ReportItem(name = "listGengakuJohoUpper_8", length = 3, order = 156)
    public RString listGengakuJohoUpper_8;
    @ReportItem(name = "listGengakuJohoUpper_9", length = 2, order = 157)
    public RString listGengakuJohoUpper_9;
    @ReportItem(name = "listGengakuJohoUpper_10", length = 6, order = 158)
    public RString listGengakuJohoUpper_10;
    @ReportItem(name = "listGengakuJohoUpper_11", length = 6, order = 159)
    public RString listGengakuJohoUpper_11;
    @ReportItem(name = "listGengakuJohoUpper_12", length = 3, order = 160)
    public RString listGengakuJohoUpper_12;
    @ReportItem(name = "listGengakuJohoUpper_13", length = 2, order = 161)
    public RString listGengakuJohoUpper_13;
    @ReportItem(name = "listGengakuJohoUpper_14", length = 6, order = 162)
    public RString listGengakuJohoUpper_14;
    @ReportItem(name = "listGengakuJohoUpper_15", length = 6, order = 163)
    public RString listGengakuJohoUpper_15;
    @ReportItem(name = "listGengakuJohoUpper_16", length = 3, order = 164)
    public RString listGengakuJohoUpper_16;
    @ReportItem(name = "listGengakuJohoLower_1", length = 22, order = 165)
    public RString listGengakuJohoLower_1;
    @ReportItem(name = "listGengakuJohoLower_2", length = 22, order = 166)
    public RString listGengakuJohoLower_2;
    @ReportItem(name = "listGengakuJohoLower_3", length = 22, order = 167)
    public RString listGengakuJohoLower_3;
    @ReportItem(name = "listGengakuJohoLower_4", length = 22, order = 168)
    public RString listGengakuJohoLower_4;
    @ReportItem(name = "chohyoID", length = 9, order = 169)
    public RString chohyoID;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    public RString hihokenshaNo;
    @ReportPerson(id = "A")
    public RString shikibetsuCode;

// </editor-fold>
}
