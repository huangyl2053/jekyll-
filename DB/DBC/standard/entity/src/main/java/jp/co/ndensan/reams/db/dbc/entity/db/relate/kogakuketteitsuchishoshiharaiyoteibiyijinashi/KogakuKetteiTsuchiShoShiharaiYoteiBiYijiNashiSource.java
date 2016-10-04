/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のReportSourceクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "testPrint", length = 5, order = 2)
    public RString testPrint;
    @ReportItem(name = "renban", length = 9, order = 3)
    public RString renban;
    @ReportItem(name = "title", length = 70, order = 4)
    public RString title;
    @ReportItem(name = "title3_1", length = 13, order = 5)
    public RString title3_1;
    @ReportItem(name = "title2_1", length = 13, order = 6)
    public RString title2_1;
    @ReportItem(name = "title3_2_1", length = 2, order = 7)
    public RString title3_2_1;
    @ReportItem(name = "title3_2_2", length = 2, order = 8)
    public RString title3_2_2;
    @ReportItem(name = "title3_3_1", length = 5, order = 9)
    public RString title3_3_1;
    @ReportItem(name = "title3_3_2", length = 5, order = 10)
    public RString title3_3_2;
    @ReportItem(name = "title2_2_1", length = 2, order = 11)
    public RString title2_2_1;
    @ReportItem(name = "title2_2_2", length = 2, order = 12)
    public RString title2_2_2;
    @ReportItem(name = "title2_3_1", length = 5, order = 13)
    public RString title2_3_1;
    @ReportItem(name = "title2_3_2", length = 5, order = 14)
    public RString title2_3_2;
    @ReportItem(name = "title3_4", length = 9, order = 15)
    public RString title3_4;
    @ReportItem(name = "title2_4", length = 5, order = 16)
    public RString title2_4;
    @ReportItem(name = "tsuchibun1", length = 90, order = 17)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 90, order = 18)
    public RString tsuchibun2;
    @ReportItem(name = "hihokenshaName", order = 19)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 20)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 21)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 22)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 23)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 24)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 25)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 26)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 27)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 28)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 29)
    public RString hihokenshaNo10;
    @ReportItem(name = "uketsukeYMD", length = 11, order = 30)
    public RString uketsukeYMD;
    @ReportItem(name = "ketteiYMD", length = 11, order = 31)
    public RString ketteiYMD;
    @ReportItem(name = "honninShiharaiGaku", length = 14, order = 32)
    public RString honninShiharaiGaku;
    @ReportItem(name = "taishoYM", length = 11, order = 33)
    public RString taishoYM;
    @ReportItem(name = "kyufuShu1", length = 76, order = 34)
    public RString kyufuShu1;
    @ReportItem(name = "kyufuShu2", length = 76, order = 35)
    public RString kyufuShu2;
    @ReportItem(name = "kyufuShu3", length = 76, order = 36)
    public RString kyufuShu3;
    @ReportItem(name = "ketteiGaku", length = 8, order = 37)
    public RString ketteiGaku;
    @ReportItem(name = "kekka", length = 30, order = 38)
    public RString kekka;
    @ReportItem(name = "shikyuGaku", length = 14, order = 39)
    public RString shikyuGaku;
    @ReportItem(name = "riyuTitle", length = 12, order = 40)
    public RString riyuTitle;
    @ReportItem(name = "riyu1", length = 76, order = 41)
    public RString riyu1;
    @ReportItem(name = "riyu2", length = 76, order = 42)
    public RString riyu2;
    @ReportItem(name = "riyu3", length = 76, order = 43)
    public RString riyu3;
    @ReportItem(name = "torikeshi1", length = 14, order = 44)
    public RString torikeshi1;
    @ReportItem(name = "torikeshi2", length = 14, order = 45)
    public RString torikeshi2;
    @ReportItem(name = "mochimono1", length = 30, order = 46)
    public RString mochimono1;
    @ReportItem(name = "bankName", length = 30, order = 47)
    public RString bankName;
    @ReportItem(name = "torikeshiMochimono1", length = 12, order = 48)
    public RString torikeshiMochimono1;
    @ReportItem(name = "mochimono2", length = 30, order = 49)
    public RString mochimono2;
    @ReportItem(name = "torikeshiMochimono2", length = 12, order = 50)
    public RString torikeshiMochimono2;
    @ReportItem(name = "branchBankName", order = 51)
    public RString branchBankName;
    @ReportItem(name = "mochimono3", length = 30, order = 52)
    public RString mochimono3;
    @ReportItem(name = "shiharaiBasho", order = 53)
    public RString shiharaiBasho;
    @ReportItem(name = "torikeshiShiharaibasho", length = 12, order = 54)
    public RString torikeshiShiharaibasho;
    @ReportItem(name = "shumokuTitle", length = 8, order = 55)
    public RString shumokuTitle;
    @ReportItem(name = "kouzaShu", length = 30, order = 56)
    public RString kouzaShu;
    @ReportItem(name = "bangoTitle", length = 8, order = 57)
    public RString bangoTitle;
    @ReportItem(name = "kouzaNo", length = 10, order = 58)
    public RString kouzaNo;
    @ReportItem(name = "shiharaiStartYMD", length = 17, order = 59)
    public RString shiharaiStartYMD;
    @ReportItem(name = "torikeshiShiharaikikan", length = 12, order = 60)
    public RString torikeshiShiharaikikan;
    @ReportItem(name = "kouzaMeigi", order = 61)
    public RString kouzaMeigi;
    @ReportItem(name = "shiharaiEndYMD", length = 14, order = 62)
    public RString shiharaiEndYMD;
    @ReportItem(name = "karaFugo", length = 2, order = 63)
    public RString karaFugo;
    @ReportItem(name = "shiharaiEndHMS", length = 12, order = 64)
    public RString shiharaiEndHMS;
    @ReportItem(name = "shiharaiStartHMS", length = 12, order = 65)
    public RString shiharaiStartHMS;
    @ReportItem(name = "tsuchibun3", length = 62, order = 66)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 62, order = 67)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 62, order = 68)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 62, order = 69)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", length = 62, order = 70)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 62, order = 71)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 62, order = 72)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 62, order = 73)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 62, order = 74)
    public RString tsuchibun11;
    @ReportItem(name = "tsuchibun12", length = 62, order = 75)
    public RString tsuchibun12;
    @ReportItem(name = "tsuchibun13", length = 62, order = 76)
    public RString tsuchibun13;
    @ReportItem(name = "tsuchibun14", length = 62, order = 77)
    public RString tsuchibun14;
    @ReportItem(name = "tsuchibun15", length = 62, order = 78)
    public RString tsuchibun15;
    @ReportItem(name = "tsuchibun16", length = 62, order = 79)
    public RString tsuchibun16;
    @ReportItem(name = "tsuchibun17", length = 62, order = 80)
    public RString tsuchibun17;
    @ReportItem(name = "tsuchibun18", length = 62, order = 81)
    public RString tsuchibun18;
    @ReportItem(name = "tsuchibun19", length = 62, order = 82)
    public RString tsuchibun19;
    @ReportItem(name = "tsuchibun20", length = 62, order = 83)
    public RString tsuchibun20;
    @ReportItem(name = "tsuchibun21", length = 62, order = 84)
    public RString tsuchibun21;
    @ReportItem(name = "tsuchibun22", length = 62, order = 85)
    public RString tsuchibun22;
    @ReportItem(name = "tsuchibun23", length = 62, order = 86)
    public RString tsuchibun23;
    @ReportItem(name = "tsuchibun24", length = 62, order = 87)
    public RString tsuchibun24;
    @ReportItem(name = "tsuchino", length = 6, order = 88)
    public RString tsuchino;
    @ReportItem(name = "tsuban", length = 4, order = 89)
    public RString tsuban;
    @ReportItem(name = "tsuchibunLarge3", length = 45, order = 90)
    public RString tsuchibunLarge3;
    @ReportItem(name = "tsuchibunLarge4", length = 45, order = 91)
    public RString tsuchibunLarge4;
    @ReportItem(name = "tsuchibunLarge5", length = 45, order = 92)
    public RString tsuchibunLarge5;
    @ReportItem(name = "tsuchibunLarge6", length = 45, order = 93)
    public RString tsuchibunLarge6;
    @ReportItem(name = "tsuchibunLarge7", length = 45, order = 94)
    public RString tsuchibunLarge7;
    @ReportItem(name = "tsuchibunLarge8", length = 45, order = 95)
    public RString tsuchibunLarge8;
    @ReportItem(name = "tsuchibunLarge9", length = 45, order = 96)
    public RString tsuchibunLarge9;
    @ReportItem(name = "tsuchibunLarge10", length = 45, order = 97)
    public RString tsuchibunLarge10;
    @ReportItem(name = "tsuchibunLarge11", length = 45, order = 98)
    public RString tsuchibunLarge11;
    @ReportItem(name = "tsuchibunLarge12", length = 45, order = 99)
    public RString tsuchibunLarge12;
    @ReportItem(name = "tsuchibunLarge13", length = 45, order = 100)
    public RString tsuchibunLarge13;
    @ReportItem(name = "tsuchibunLarge14", length = 45, order = 101)
    public RString tsuchibunLarge14;
    @ReportItem(name = "tsuchibunLarge15", length = 45, order = 102)
    public RString tsuchibunLarge15;
    @ReportItem(name = "tsuchibunLarge16", length = 45, order = 103)
    public RString tsuchibunLarge16;
    @ReportItem(name = "tsuchibunLarge17", length = 45, order = 104)
    public RString tsuchibunLarge17;
    @ReportItem(name = "tsuchibunLarge18", length = 45, order = 105)
    public RString tsuchibunLarge18;
    @ReportItem(name = "tsuchibunLarge19", length = 45, order = 106)
    public RString tsuchibunLarge19;
    @ReportItem(name = "tsuchibunMix3", length = 62, order = 107)
    public RString tsuchibunMix3;
    @ReportItem(name = "tsuchibunMix4", length = 62, order = 108)
    public RString tsuchibunMix4;
    @ReportItem(name = "tsuchibunMix5", length = 62, order = 109)
    public RString tsuchibunMix5;
    @ReportItem(name = "tsuchibunMix6", length = 62, order = 110)
    public RString tsuchibunMix6;
    @ReportItem(name = "tsuchibunMix7", length = 62, order = 111)
    public RString tsuchibunMix7;
    @ReportItem(name = "tsuchibunMix8", length = 62, order = 112)
    public RString tsuchibunMix8;
    @ReportItem(name = "tsuchibunMix9", length = 62, order = 113)
    public RString tsuchibunMix9;
    @ReportItem(name = "tsuchibunMix10", length = 62, order = 114)
    public RString tsuchibunMix10;
    @ReportItem(name = "tsuchibunMix11", length = 62, order = 115)
    public RString tsuchibunMix11;
    @ReportItem(name = "tsuchibunMix12", length = 62, order = 116)
    public RString tsuchibunMix12;
    @ReportItem(name = "tsuchibunMix13", length = 62, order = 117)
    public RString tsuchibunMix13;
    @ReportItem(name = "tsuchibunMix14", length = 62, order = 118)
    public RString tsuchibunMix14;
    @ReportItem(name = "tsuchibunMix15", length = 62, order = 119)
    public RString tsuchibunMix15;
    @ReportItem(name = "tsuchibunMix16", length = 45, order = 120)
    public RString tsuchibunMix16;
    @ReportItem(name = "tsuchibunMix17", length = 45, order = 121)
    public RString tsuchibunMix17;
    @ReportItem(name = "tsuchibunMix18", length = 45, order = 122)
    public RString tsuchibunMix18;
    @ReportItem(name = "tsuchibunMix19", length = 45, order = 123)
    public RString tsuchibunMix19;
    @ReportItem(name = "tsuchibunMix20", length = 45, order = 124)
    public RString tsuchibunMix20;
    @ReportItem(name = "tsuchibunMix21", length = 45, order = 125)
    public RString tsuchibunMix21;
    @ReportItem(name = "tsuchibunMix22", length = 45, order = 126)
    public RString tsuchibunMix22;
    @ReportItem(name = "tsuchibunMixtwo3", length = 45, order = 127)
    public RString tsuchibunMixtwo3;
    @ReportItem(name = "tsuchibunMixtwo4", length = 45, order = 128)
    public RString tsuchibunMixtwo4;
    @ReportItem(name = "tsuchibunMixtwo5", length = 45, order = 129)
    public RString tsuchibunMixtwo5;
    @ReportItem(name = "tsuchibunMixtwo6", length = 45, order = 130)
    public RString tsuchibunMixtwo6;
    @ReportItem(name = "tsuchibunMixtwo7", length = 45, order = 131)
    public RString tsuchibunMixtwo7;
    @ReportItem(name = "tsuchibunMixtwo8", length = 45, order = 132)
    public RString tsuchibunMixtwo8;
    @ReportItem(name = "tsuchibunMixtwo9", length = 45, order = 133)
    public RString tsuchibunMixtwo9;
    @ReportItem(name = "tsuchibunMixtwo10", length = 62, order = 134)
    public RString tsuchibunMixtwo10;
    @ReportItem(name = "tsuchibunMixtwo11", length = 62, order = 135)
    public RString tsuchibunMixtwo11;
    @ReportItem(name = "tsuchibunMixtwo12", length = 62, order = 136)
    public RString tsuchibunMixtwo12;
    @ReportItem(name = "tsuchibunMixtwo13", length = 62, order = 137)
    public RString tsuchibunMixtwo13;
    @ReportItem(name = "tsuchibunMixtwo14", length = 62, order = 138)
    public RString tsuchibunMixtwo14;
    @ReportItem(name = "tsuchibunMixtwo15", length = 62, order = 139)
    public RString tsuchibunMixtwo15;
    @ReportItem(name = "tsuchibunMixtwo16", length = 62, order = 140)
    public RString tsuchibunMixtwo16;
    @ReportItem(name = "tsuchibunMixtwo17", length = 62, order = 141)
    public RString tsuchibunMixtwo17;
    @ReportItem(name = "tsuchibunMixtwo18", length = 62, order = 142)
    public RString tsuchibunMixtwo18;
    @ReportItem(name = "tsuchibunMixtwo19", length = 62, order = 143)
    public RString tsuchibunMixtwo19;
    @ReportItem(name = "tsuchibunMixtwo20", length = 62, order = 144)
    public RString tsuchibunMixtwo20;
    @ReportItem(name = "tsuchibunMixtwo21", length = 62, order = 145)
    public RString tsuchibunMixtwo21;
    @ReportItem(name = "tsuchibunMixtwo22", length = 62, order = 146)
    public RString tsuchibunMixtwo22;
    @ReportItem(name = "yubinNo", length = 8, order = 147)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku2", length = 14, order = 148)
    public RString gyoseiku2;
    @ReportItem(name = "jusho4", length = 20, order = 149)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 150)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 151)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 152)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 153)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 154)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 155)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 156)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 157)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei5", length = 20, order = 158)
    public RString shimei5;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 159)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 160)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 161)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 162)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 163)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei6", length = 20, order = 164)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 165)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 166)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 167)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 168)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 169)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 170)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 171)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight1", length = 1, order = 172)
    public RString kakkoRight1;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 173)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 174)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 175)
    public RString samaBun1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 176)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 177)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 178)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 179)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 180)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 181)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 182)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 183)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 184)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 185)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 186)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
