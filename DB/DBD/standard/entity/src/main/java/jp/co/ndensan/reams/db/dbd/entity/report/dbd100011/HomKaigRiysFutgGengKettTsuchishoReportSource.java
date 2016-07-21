package jp.co.ndensan.reams.db.dbd.entity.report.dbd100011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 訪問介護等利用者負担額減額決定通知書のReportSource
 *
 * @reamsid_L DBD-3540-090 wangchao
 */
public class HomKaigRiysFutgGengKettTsuchishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportPerson(id = "001")
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "001", code = "003", name = "被保険者番号")
    public RString hihokenshaNo;
    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "title1", length = 28, order = 2)
    public RString title1;
    @ReportItem(name = "title2", length = 28, order = 3)
    public RString title2;
    @ReportItem(name = "tsuchibun1", length = 48, order = 4)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 45, order = 5)
    public RString tsuchibun2;
    @ReportItem(name = "hihokenshaName", order = 6)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 7)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 8)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 9)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 10)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 11)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 12)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 13)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 14)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 15)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 16)
    public RString hihokenshaNo10;
    @ReportItem(name = "ketteiYMD", length = 11, order = 17)
    public RString ketteiYMD;
    @ReportItem(name = "tekiyoYMD", length = 11, order = 18)
    public RString tekiyoYMD;
    @ReportItem(name = "ninteiKekka1", length = 15, order = 19)
    public RString ninteiKekka1;
    @ReportItem(name = "shoninSuru", length = 1, order = 20)
    public RString shoninSuru;
    @ReportItem(name = "ninteiKekka2", length = 20, order = 21)
    public RString ninteiKekka2;
    @ReportItem(name = "yukoYMD", length = 11, order = 22)
    public RString yukoYMD;
    @ReportItem(name = "ninteiKekka3", length = 15, order = 23)
    public RString ninteiKekka3;
    @ReportItem(name = "ninteiKekka4", length = 15, order = 24)
    public RString ninteiKekka4;
    @ReportItem(name = "futanshaNo4", length = 1, order = 25)
    public RString futanshaNo4;
    @ReportItem(name = "futanshaNo1", length = 1, order = 26)
    public RString futanshaNo1;
    @ReportItem(name = "futanshaNo2", length = 1, order = 27)
    public RString futanshaNo2;
    @ReportItem(name = "futanshaNo3", length = 1, order = 28)
    public RString futanshaNo3;
    @ReportItem(name = "futanshaNo5", length = 1, order = 29)
    public RString futanshaNo5;
    @ReportItem(name = "futanshaNo6", length = 1, order = 30)
    public RString futanshaNo6;
    @ReportItem(name = "futanshaNo7", length = 1, order = 31)
    public RString futanshaNo7;
    @ReportItem(name = "futanshaNo8", length = 1, order = 32)
    public RString futanshaNo8;
    @ReportItem(name = "ninteiKekka5", length = 15, order = 33)
    public RString ninteiKekka5;
    @ReportItem(name = "jukyushaNo1", length = 1, order = 34)
    public RString jukyushaNo1;
    @ReportItem(name = "jukyushaNo2", length = 1, order = 35)
    public RString jukyushaNo2;
    @ReportItem(name = "jukyushaNo3", length = 1, order = 36)
    public RString jukyushaNo3;
    @ReportItem(name = "jukyushaNo4", length = 1, order = 37)
    public RString jukyushaNo4;
    @ReportItem(name = "jukyushaNo5", length = 1, order = 38)
    public RString jukyushaNo5;
    @ReportItem(name = "jukyushaNo6", length = 1, order = 39)
    public RString jukyushaNo6;
    @ReportItem(name = "jukyushaNo7", length = 1, order = 40)
    public RString jukyushaNo7;
    @ReportItem(name = "ninteiKekka6", length = 15, order = 41)
    public RString ninteiKekka6;
    @ReportItem(name = "ninteiKekka7", length = 15, order = 42)
    public RString ninteiKekka7;
    @ReportItem(name = "shoninNg", length = 1, order = 43)
    public RString shoninNg;
    @ReportItem(name = "riyu1", length = 42, order = 44)
    public RString riyu1;
    @ReportItem(name = "riyu2", length = 42, order = 45)
    public RString riyu2;
    @ReportItem(name = "riyu3", length = 42, order = 46)
    public RString riyu3;
    @ReportItem(name = "riyu4", length = 42, order = 47)
    public RString riyu4;
    @ReportItem(name = "riyu5", length = 42, order = 48)
    public RString riyu5;
    @ReportItem(name = "tsuchibun3", length = 62, order = 49)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 62, order = 50)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 62, order = 51)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 62, order = 52)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", length = 62, order = 53)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 62, order = 54)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 62, order = 55)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 62, order = 56)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 62, order = 57)
    public RString tsuchibun11;
    @ReportItem(name = "tsuchibun12", length = 62, order = 58)
    public RString tsuchibun12;
    @ReportItem(name = "tsuchibun13", length = 62, order = 59)
    public RString tsuchibun13;
    @ReportItem(name = "tsuchibun14", length = 62, order = 60)
    public RString tsuchibun14;
    @ReportItem(name = "tsuchibun15", length = 62, order = 61)
    public RString tsuchibun15;
    @ReportItem(name = "tsuchibun16", length = 62, order = 62)
    public RString tsuchibun16;
    @ReportItem(name = "tsuchibun17", length = 62, order = 63)
    public RString tsuchibun17;
    @ReportItem(name = "tsuchibun18", length = 62, order = 64)
    public RString tsuchibun18;
    @ReportItem(name = "tsuchibun19", length = 62, order = 65)
    public RString tsuchibun19;
    @ReportItem(name = "tsuchibun20", length = 62, order = 66)
    public RString tsuchibun20;
    @ReportItem(name = "tsuchibun21", length = 62, order = 67)
    public RString tsuchibun21;
    @ReportItem(name = "tsuchibun22", length = 62, order = 68)
    public RString tsuchibun22;
    @ReportItem(name = "tsuchibun23", length = 62, order = 69)
    public RString tsuchibun23;
    @ReportItem(name = "tsuchibun24", length = 62, order = 70)
    public RString tsuchibun24;
    @ReportItem(name = "tsuchibunLarge3", length = 45, order = 71)
    public RString tsuchibunLarge3;
    @ReportItem(name = "tsuchibunLarge4", length = 45, order = 72)
    public RString tsuchibunLarge4;
    @ReportItem(name = "tsuchibunLarge5", length = 45, order = 73)
    public RString tsuchibunLarge5;
    @ReportItem(name = "tsuchibunLarge6", length = 45, order = 74)
    public RString tsuchibunLarge6;
    @ReportItem(name = "tsuchibunLarge7", length = 45, order = 75)
    public RString tsuchibunLarge7;
    @ReportItem(name = "tsuchibunLarge8", length = 45, order = 76)
    public RString tsuchibunLarge8;
    @ReportItem(name = "tsuchibunLarge9", length = 45, order = 77)
    public RString tsuchibunLarge9;
    @ReportItem(name = "tsuchibunLarge10", length = 45, order = 78)
    public RString tsuchibunLarge10;
    @ReportItem(name = "tsuchibunLarge11", length = 45, order = 79)
    public RString tsuchibunLarge11;
    @ReportItem(name = "tsuchibunLarge12", length = 45, order = 80)
    public RString tsuchibunLarge12;
    @ReportItem(name = "tsuchibunLarge13", length = 45, order = 81)
    public RString tsuchibunLarge13;
    @ReportItem(name = "tsuchibunLarge14", length = 45, order = 82)
    public RString tsuchibunLarge14;
    @ReportItem(name = "tsuchibunLarge15", length = 45, order = 83)
    public RString tsuchibunLarge15;
    @ReportItem(name = "tsuchibunLarge16", length = 45, order = 84)
    public RString tsuchibunLarge16;
    @ReportItem(name = "tsuchibunLarge17", length = 45, order = 85)
    public RString tsuchibunLarge17;
    @ReportItem(name = "tsuchibunLarge18", length = 45, order = 86)
    public RString tsuchibunLarge18;
    @ReportItem(name = "tsuchibunLarge19", length = 45, order = 87)
    public RString tsuchibunLarge19;
    @ReportItem(name = "tsuchibunLarge20", length = 45, order = 88)
    public RString tsuchibunLarge20;
    @ReportItem(name = "tsuchibunMix3", length = 62, order = 89)
    public RString tsuchibunMix3;
    @ReportItem(name = "tsuchibunMix4", length = 62, order = 90)
    public RString tsuchibunMix4;
    @ReportItem(name = "tsuchibunMix5", length = 62, order = 91)
    public RString tsuchibunMix5;
    @ReportItem(name = "tsuchibunMix6", length = 62, order = 92)
    public RString tsuchibunMix6;
    @ReportItem(name = "tsuchibunMix7", length = 62, order = 93)
    public RString tsuchibunMix7;
    @ReportItem(name = "tsuchibunMix8", length = 62, order = 94)
    public RString tsuchibunMix8;
    @ReportItem(name = "tsuchibunMix9", length = 62, order = 95)
    public RString tsuchibunMix9;
    @ReportItem(name = "tsuchibunMix10", length = 62, order = 96)
    public RString tsuchibunMix10;
    @ReportItem(name = "tsuchibunMix11", length = 62, order = 97)
    public RString tsuchibunMix11;
    @ReportItem(name = "tsuchibunMix12", length = 62, order = 98)
    public RString tsuchibunMix12;
    @ReportItem(name = "tsuchibunMix13", length = 62, order = 99)
    public RString tsuchibunMix13;
    @ReportItem(name = "tsuchibunMix14", length = 62, order = 100)
    public RString tsuchibunMix14;
    @ReportItem(name = "tsuchibunMix15", length = 62, order = 101)
    public RString tsuchibunMix15;
    @ReportItem(name = "tsuchibunMix16", length = 45, order = 102)
    public RString tsuchibunMix16;
    @ReportItem(name = "tsuchibunMix17", length = 45, order = 103)
    public RString tsuchibunMix17;
    @ReportItem(name = "tsuchibunMix18", length = 45, order = 104)
    public RString tsuchibunMix18;
    @ReportItem(name = "tsuchibunMix19", length = 45, order = 105)
    public RString tsuchibunMix19;
    @ReportItem(name = "tsuchibunMix20", length = 45, order = 106)
    public RString tsuchibunMix20;
    @ReportItem(name = "tsuchibunMix21", length = 45, order = 107)
    public RString tsuchibunMix21;
    @ReportItem(name = "tsuchibunMix22", length = 45, order = 108)
    public RString tsuchibunMix22;
    @ReportItem(name = "tsuchibunMixtwo3", length = 45, order = 109)
    public RString tsuchibunMixtwo3;
    @ReportItem(name = "tsuchibunMixtwo4", length = 45, order = 110)
    public RString tsuchibunMixtwo4;
    @ReportItem(name = "tsuchibunMixtwo5", length = 45, order = 111)
    public RString tsuchibunMixtwo5;
    @ReportItem(name = "tsuchibunMixtwo6", length = 45, order = 112)
    public RString tsuchibunMixtwo6;
    @ReportItem(name = "tsuchibunMixtwo7", length = 45, order = 113)
    public RString tsuchibunMixtwo7;
    @ReportItem(name = "tsuchibunMixtwo8", length = 45, order = 114)
    public RString tsuchibunMixtwo8;
    @ReportItem(name = "tsuchibunMixtwo9", length = 45, order = 115)
    public RString tsuchibunMixtwo9;
    @ReportItem(name = "tsuchibunMixtwo10", length = 62, order = 116)
    public RString tsuchibunMixtwo10;
    @ReportItem(name = "tsuchibunMixtwo11", length = 62, order = 117)
    public RString tsuchibunMixtwo11;
    @ReportItem(name = "tsuchibunMixtwo12", length = 62, order = 118)
    public RString tsuchibunMixtwo12;
    @ReportItem(name = "tsuchibunMixtwo13", length = 62, order = 119)
    public RString tsuchibunMixtwo13;
    @ReportItem(name = "tsuchibunMixtwo14", length = 62, order = 120)
    public RString tsuchibunMixtwo14;
    @ReportItem(name = "tsuchibunMixtwo15", length = 62, order = 121)
    public RString tsuchibunMixtwo15;
    @ReportItem(name = "tsuchibunMixtwo16", length = 62, order = 122)
    public RString tsuchibunMixtwo16;
    @ReportItem(name = "tsuchibunMixtwo17", length = 62, order = 123)
    public RString tsuchibunMixtwo17;
    @ReportItem(name = "tsuchibunMixtwo18", length = 62, order = 124)
    public RString tsuchibunMixtwo18;
    @ReportItem(name = "tsuchibunMixtwo19", length = 62, order = 125)
    public RString tsuchibunMixtwo19;
    @ReportItem(name = "tsuchibunMixtwo20", length = 62, order = 126)
    public RString tsuchibunMixtwo20;
    @ReportItem(name = "tsuchibunMixtwo21", length = 62, order = 127)
    public RString tsuchibunMixtwo21;
    @ReportItem(name = "tsuchibunMixtwo22", length = 62, order = 128)
    public RString tsuchibunMixtwo22;
    @ReportItem(name = "yubinNo", length = 8, order = 129)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku1", length = 14, order = 130)
    public RString gyoseiku1;
    @ReportItem(name = "jusho4", length = 20, order = 131)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 132)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 133)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 134)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 135)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 136)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 137)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 138)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 139)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei3", length = 20, order = 140)
    public RString shimei3;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 141)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 142)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 143)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 144)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 145)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei4", length = 20, order = 146)
    public RString shimei4;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 147)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 148)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 149)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 150)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 151)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 152)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 153)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 154)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 155)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 156)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 157)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 158)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 159)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 160)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 161)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 162)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 163)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 164)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 165)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 166)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 167)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 168)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
