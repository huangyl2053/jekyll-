package jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyojisshitsufutan;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険連絡票_実質負担軽減者用のReportSourceです。
 *
 * @reamsid_L DBA-1290-060 wangrenze
 */
public class KaigohokenRenrakuhyoJisshitsuFutanReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sakuseiDate", length = 16, order = 1)
    public RString sakuseiDate;
    @ReportItem(name = "hihokenshaNo", length = 11, order = 2)
    public RString hihokenshaNo;
    @ReportItem(name = "shimeiFurigana", order = 3)
    public RString shimeiFurigana;
    @ReportItem(name = "shimei", order = 4)
    public RString shimei;
    @ReportItem(name = "seibetsu", length = 2, order = 5)
    public RString seibetsu;
    @ReportItem(name = "birthDay", length = 16, order = 6)
    public RString birthDay;
    @ReportItem(name = "jusho", order = 7)
    public RString jusho;
    @ReportItem(name = "telNo", length = 14, order = 8)
    public RString telNo;
    @ReportItem(name = "yoshienDankai", length = 1, order = 9)
    public RString yoshienDankai;
    @ReportItem(name = "yokaigoDankai", length = 1, order = 10)
    public RString yokaigoDankai;
    @ReportItem(name = "higaitoCheck", length = 1, order = 11)
    public RString higaitoCheck;
    @ReportItem(name = "mininteiCheck", length = 1, order = 12)
    public RString mininteiCheck;
    @ReportItem(name = "yoshienCheck", length = 1, order = 13)
    public RString yoshienCheck;
    @ReportItem(name = "yokaigoCheck", length = 1, order = 14)
    public RString yokaigoCheck;
    @ReportItem(name = "ninteiDate", length = 16, order = 15)
    public RString ninteiDate;
    @ReportItem(name = "kyufuGendogakuKisaiCheck", length = 1, order = 16)
    public RString kyufuGendogakuKisaiCheck;
    @ReportItem(name = "kyufuGendogaku", length = 7, order = 17)
    public RString kyufuGendogaku;
    @ReportItem(name = "kyojuhiCheck", length = 1, order = 18)
    public RString kyojuhiCheck;
    @ReportItem(name = "koshitsu1Check", length = 1, order = 19)
    public RString koshitsu1Check;
    @ReportItem(name = "junKoshitsu1Check", length = 1, order = 20)
    public RString junKoshitsu1Check;
    @ReportItem(name = "tashoshitsu1Check", length = 1, order = 21)
    public RString tashoshitsu1Check;
    @ReportItem(name = "koshitsu1Kingaku", length = 6, order = 22)
    public RString koshitsu1Kingaku;
    @ReportItem(name = "junKoshitsu1Kingaku", length = 6, order = 23)
    public RString junKoshitsu1Kingaku;
    @ReportItem(name = "tashoshitsu1Kingaku", length = 6, order = 24)
    public RString tashoshitsu1Kingaku;
    @ReportItem(name = "tokuyo1Check", length = 1, order = 25)
    public RString tokuyo1Check;
    @ReportItem(name = "tokuyo1Kingaku", length = 6, order = 26)
    public RString tokuyo1Kingaku;
    @ReportItem(name = "koshitsu2Kingaku", length = 6, order = 27)
    public RString koshitsu2Kingaku;
    @ReportItem(name = "junKoshitsu2_1Check", length = 1, order = 28)
    public RString junKoshitsu2_1Check;
    @ReportItem(name = "koshitsu2Check", length = 1, order = 29)
    public RString koshitsu2Check;
    @ReportItem(name = "tashoshitsu2_1Kingaku", length = 6, order = 30)
    public RString tashoshitsu2_1Kingaku;
    @ReportItem(name = "junKoshitsu2_1Kingaku", length = 6, order = 31)
    public RString junKoshitsu2_1Kingaku;
    @ReportItem(name = "tashoshitsu2_1Check", length = 1, order = 32)
    public RString tashoshitsu2_1Check;
    @ReportItem(name = "tokuyo2_1Check", length = 1, order = 33)
    public RString tokuyo2_1Check;
    @ReportItem(name = "tokuyo2_1Kingaku", length = 6, order = 34)
    public RString tokuyo2_1Kingaku;
    @ReportItem(name = "junKoshitsu2_2Check", length = 1, order = 35)
    public RString junKoshitsu2_2Check;
    @ReportItem(name = "junKoshitsu2_2Kingaku", length = 6, order = 36)
    public RString junKoshitsu2_2Kingaku;
    @ReportItem(name = "koshitsu3Check", length = 1, order = 37)
    public RString koshitsu3Check;
    @ReportItem(name = "tokuyo2_2Check", length = 1, order = 38)
    public RString tokuyo2_2Check;
    @ReportItem(name = "tashochitsu2_2Kingaku", length = 6, order = 39)
    public RString tashochitsu2_2Kingaku;
    @ReportItem(name = "tashoshitsu2_2Check", length = 1, order = 40)
    public RString tashoshitsu2_2Check;
    @ReportItem(name = "koshitsu3Kingaku", length = 6, order = 41)
    public RString koshitsu3Kingaku;
    @ReportItem(name = "tokuyo2_2Kingaku", length = 6, order = 42)
    public RString tokuyo2_2Kingaku;
    @ReportItem(name = "junKoshitsu3Check", length = 1, order = 43)
    public RString junKoshitsu3Check;
    @ReportItem(name = "koshitsuKijunCheck", length = 1, order = 44)
    public RString koshitsuKijunCheck;
    @ReportItem(name = "tashoshitsu3Kingaku", length = 6, order = 45)
    public RString tashoshitsu3Kingaku;
    @ReportItem(name = "koshitsuKijunKingaku", length = 6, order = 46)
    public RString koshitsuKijunKingaku;
    @ReportItem(name = "junKoshitsu3Kingaku", length = 6, order = 47)
    public RString junKoshitsu3Kingaku;
    @ReportItem(name = "tashoshitsu3Check", length = 1, order = 48)
    public RString tashoshitsu3Check;
    @ReportItem(name = "tokuyo2_3Check", length = 1, order = 49)
    public RString tokuyo2_3Check;
    @ReportItem(name = "tokuyo2_3Kingaku", length = 6, order = 50)
    public RString tokuyo2_3Kingaku;
    @ReportItem(name = "tokuyo3Check", length = 1, order = 51)
    public RString tokuyo3Check;
    @ReportItem(name = "tashoshitsuKijunKingaku", length = 6, order = 52)
    public RString tashoshitsuKijunKingaku;
    @ReportItem(name = "tokuyo3Kingaku", length = 6, order = 53)
    public RString tokuyo3Kingaku;
    @ReportItem(name = "junKoshitsuKijunKingaku", length = 6, order = 54)
    public RString junKoshitsuKijunKingaku;
    @ReportItem(name = "tashoshitsuKijunCheck", length = 1, order = 55)
    public RString tashoshitsuKijunCheck;
    @ReportItem(name = "junKoshitsuKijunCheck", length = 1, order = 56)
    public RString junKoshitsuKijunCheck;
    @ReportItem(name = "tokuyoKijunCheck", length = 1, order = 57)
    public RString tokuyoKijunCheck;
    @ReportItem(name = "tokuyoKijunKingaku", length = 6, order = 58)
    public RString tokuyoKijunKingaku;
    @ReportItem(name = "shokuhiCheck", length = 1, order = 59)
    public RString shokuhiCheck;
    @ReportItem(name = "shokuhi3Check", length = 1, order = 60)
    public RString shokuhi3Check;
    @ReportItem(name = "shokuhi1Check", length = 1, order = 61)
    public RString shokuhi1Check;
    @ReportItem(name = "shokuhiOtherKingaku", length = 6, order = 62)
    public RString shokuhiOtherKingaku;
    @ReportItem(name = "shokuhi3Kingaku", length = 5, order = 63)
    public RString shokuhi3Kingaku;
    @ReportItem(name = "shokuhi2Kingaku", length = 5, order = 64)
    public RString shokuhi2Kingaku;
    @ReportItem(name = "shokuhi4Check", length = 1, order = 65)
    public RString shokuhi4Check;
    @ReportItem(name = "shokuhi1Kingaku", length = 5, order = 66)
    public RString shokuhi1Kingaku;
    @ReportItem(name = "shokuhi2Check", length = 1, order = 67)
    public RString shokuhi2Check;
    @ReportItem(name = "shokuhi4Kingaku", length = 5, order = 68)
    public RString shokuhi4Kingaku;
    @ReportItem(name = "kogakuKaigoCheck", length = 1, order = 69)
    public RString kogakuKaigoCheck;
    @ReportItem(name = "kogakuKaigo4Kingaku", length = 6, order = 70)
    public RString kogakuKaigo4Kingaku;
    @ReportItem(name = "kogakuKaigoOtherKingaku", length = 6, order = 71)
    public RString kogakuKaigoOtherKingaku;
    @ReportItem(name = "kogakuKaigo4Check", length = 1, order = 72)
    public RString kogakuKaigo4Check;
    @ReportItem(name = "kogakuKaigo2Kingaku", length = 6, order = 73)
    public RString kogakuKaigo2Kingaku;
    @ReportItem(name = "kogakuKaigo3Kingaku", length = 6, order = 74)
    public RString kogakuKaigo3Kingaku;
    @ReportItem(name = "kogakuKaigo3Check", length = 1, order = 75)
    public RString kogakuKaigo3Check;
    @ReportItem(name = "kogakuKaigo1Kingaku", length = 6, order = 76)
    public RString kogakuKaigo1Kingaku;
    @ReportItem(name = "kogakuKaigo2Check", length = 1, order = 77)
    public RString kogakuKaigo2Check;
    @ReportItem(name = "kogakuKaigo1Check", length = 1, order = 78)
    public RString kogakuKaigo1Check;
    @ReportItem(name = "kaigoHokenryoCheck", length = 1, order = 79)
    public RString kaigoHokenryoCheck;
    @ReportItem(name = "hokenryoDankai2", length = 8, order = 80)
    public RString hokenryoDankai2;
    @ReportItem(name = "hokenryoDankai1", length = 8, order = 81)
    public RString hokenryoDankai1;
    @ReportItem(name = "hokenryoDankai5", length = 8, order = 82)
    public RString hokenryoDankai5;
    @ReportItem(name = "hokenryoDankai6", length = 8, order = 83)
    public RString hokenryoDankai6;
    @ReportItem(name = "hokenryoDankai4", length = 8, order = 84)
    public RString hokenryoDankai4;
    @ReportItem(name = "hokenryoDankai3", length = 8, order = 85)
    public RString hokenryoDankai3;
    @ReportItem(name = "kaigoHokenryo1Kingaku", length = 6, order = 86)
    public RString kaigoHokenryo1Kingaku;
    @ReportItem(name = "kaigoHokenryo4Kingaku", length = 6, order = 87)
    public RString kaigoHokenryo4Kingaku;
    @ReportItem(name = "kaigoHokenryo1Check", length = 1, order = 88)
    public RString kaigoHokenryo1Check;
    @ReportItem(name = "kaigoHokenryo5Kingaku", length = 6, order = 89)
    public RString kaigoHokenryo5Kingaku;
    @ReportItem(name = "kaigoHokenryo6Kingaku", length = 6, order = 90)
    public RString kaigoHokenryo6Kingaku;
    @ReportItem(name = "kaigoHokenryo4Check", length = 1, order = 91)
    public RString kaigoHokenryo4Check;
    @ReportItem(name = "kaigoHokenryo2Kingaku", length = 6, order = 92)
    public RString kaigoHokenryo2Kingaku;
    @ReportItem(name = "kaigoHokenryo3Check", length = 1, order = 93)
    public RString kaigoHokenryo3Check;
    @ReportItem(name = "kaigoHokenryo3Kingaku", length = 6, order = 94)
    public RString kaigoHokenryo3Kingaku;
    @ReportItem(name = "kaigoHokenryo2Check", length = 1, order = 95)
    public RString kaigoHokenryo2Check;
    @ReportItem(name = "kaigoHokenryo6Check", length = 1, order = 96)
    public RString kaigoHokenryo6Check;
    @ReportItem(name = "kaigoHokenryo5Check", length = 1, order = 97)
    public RString kaigoHokenryo5Check;
    @ReportItem(name = "hokenryoDankai8", length = 8, order = 98)
    public RString hokenryoDankai8;
    @ReportItem(name = "hokenryoDankai7", length = 8, order = 99)
    public RString hokenryoDankai7;
    @ReportItem(name = "hokenryoDankai11", length = 8, order = 100)
    public RString hokenryoDankai11;
    @ReportItem(name = "hokenryoDankai12", length = 8, order = 101)
    public RString hokenryoDankai12;
    @ReportItem(name = "hokenryoDankai10", length = 8, order = 102)
    public RString hokenryoDankai10;
    @ReportItem(name = "hokenryoDankai9", length = 8, order = 103)
    public RString hokenryoDankai9;
    @ReportItem(name = "kaigoHokenryo7Kingaku", length = 6, order = 104)
    public RString kaigoHokenryo7Kingaku;
    @ReportItem(name = "kaigoHokenryo10Kingaku", length = 6, order = 105)
    public RString kaigoHokenryo10Kingaku;
    @ReportItem(name = "kaigoHokenryo7Check", length = 1, order = 106)
    public RString kaigoHokenryo7Check;
    @ReportItem(name = "kaigoHokenryo11Kingaku", length = 6, order = 107)
    public RString kaigoHokenryo11Kingaku;
    @ReportItem(name = "kaigoHokenryo11Check", length = 1, order = 108)
    public RString kaigoHokenryo11Check;
    @ReportItem(name = "kaigoHokenryoOtherKingaku", length = 6, order = 109)
    public RString kaigoHokenryoOtherKingaku;
    @ReportItem(name = "kaigoHokenryo10Check", length = 1, order = 110)
    public RString kaigoHokenryo10Check;
    @ReportItem(name = "kaigoHokenryo8Kingaku", length = 6, order = 111)
    public RString kaigoHokenryo8Kingaku;
    @ReportItem(name = "kaigoHokenryo9Kingaku", length = 6, order = 112)
    public RString kaigoHokenryo9Kingaku;
    @ReportItem(name = "kaigoHokenryo8Check", length = 1, order = 113)
    public RString kaigoHokenryo8Check;
    @ReportItem(name = "kaigoHokenryoOtherCheck", length = 1, order = 114)
    public RString kaigoHokenryoOtherCheck;
    @ReportItem(name = "kaigoHokenryo9Check", length = 1, order = 115)
    public RString kaigoHokenryo9Check;
    @ReportItem(name = "biko", order = 116)
    public RString biko;
    @ReportItem(name = "hokenryoDankaiUp2", length = 8, order = 117)
    public RString hokenryoDankaiUp2;
    @ReportItem(name = "hokenryoDankaiUp1", length = 8, order = 118)
    public RString hokenryoDankaiUp1;
    @ReportItem(name = "hokenryoDankaiUp5", length = 8, order = 119)
    public RString hokenryoDankaiUp5;
    @ReportItem(name = "hokenryoDankaiUp6", length = 8, order = 120)
    public RString hokenryoDankaiUp6;
    @ReportItem(name = "hokenryoDankaiUp4", length = 8, order = 121)
    public RString hokenryoDankaiUp4;
    @ReportItem(name = "hokenryoDankaiUp3", length = 8, order = 122)
    public RString hokenryoDankaiUp3;
    @ReportItem(name = "hokenryoDankaiDown2", length = 8, order = 123)
    public RString hokenryoDankaiDown2;
    @ReportItem(name = "hokenryoDankaiDown1", length = 8, order = 124)
    public RString hokenryoDankaiDown1;
    @ReportItem(name = "hokenryoDankaiDown5", length = 8, order = 125)
    public RString hokenryoDankaiDown5;
    @ReportItem(name = "hokenryoDankaiDown6", length = 8, order = 126)
    public RString hokenryoDankaiDown6;
    @ReportItem(name = "hokenryoDankaiDown4", length = 8, order = 127)
    public RString hokenryoDankaiDown4;
    @ReportItem(name = "hokenryoDankaiDown3", length = 8, order = 128)
    public RString hokenryoDankaiDown3;
    @ReportItem(name = "hokenryoDankaiUp8", length = 8, order = 129)
    public RString hokenryoDankaiUp8;
    @ReportItem(name = "hokenryoDankaiUp7", length = 8, order = 130)
    public RString hokenryoDankaiUp7;
    @ReportItem(name = "hokenryoDankaiUp11", length = 8, order = 131)
    public RString hokenryoDankaiUp11;
    @ReportItem(name = "hokenryoDankaiUp12", length = 8, order = 132)
    public RString hokenryoDankaiUp12;
    @ReportItem(name = "hokenryoDankaiUp10", length = 8, order = 133)
    public RString hokenryoDankaiUp10;
    @ReportItem(name = "hokenryoDankaiUp9", length = 8, order = 134)
    public RString hokenryoDankaiUp9;
    @ReportItem(name = "hokenryoDankaiDown8", length = 8, order = 135)
    public RString hokenryoDankaiDown8;
    @ReportItem(name = "hokenryoDankaiDown7", length = 8, order = 136)
    public RString hokenryoDankaiDown7;
    @ReportItem(name = "hokenryoDankaiDown11", length = 8, order = 137)
    public RString hokenryoDankaiDown11;
    @ReportItem(name = "hokenryoDankaiDown12", length = 8, order = 138)
    public RString hokenryoDankaiDown12;
    @ReportItem(name = "hokenryoDankaiDown10", length = 8, order = 139)
    public RString hokenryoDankaiDown10;
    @ReportItem(name = "hokenryoDankaiDown9", length = 8, order = 140)
    public RString hokenryoDankaiDown9;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
