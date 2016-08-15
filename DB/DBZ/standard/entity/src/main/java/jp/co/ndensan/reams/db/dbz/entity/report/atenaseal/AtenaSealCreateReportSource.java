package jp.co.ndensan.reams.db.dbz.entity.report.atenaseal;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 宛名シールのReportSourceです。
 *
 * @reamsid_L DBA-1210-050 zhengsongling
 */
public class AtenaSealCreateReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonCode", length = 12, order = 1)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 24, order = 2)
    public RString shichosonName;
    @ReportItem(name = "title", length = 20, order = 3)
    public RString title;
    @ReportItem(name = "printTimeStamp", length = 30, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "yubinNo1", length = 8, order = 5)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 6)
    public RString gyoseiku1;
    @ReportItem(name = "yubinNo", length = 8, order = 7)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 8)
    public RString gyoseiku;
    @ReportItem(name = "jushoText1", order = 9)
    public RString jushoText1;
    @ReportItem(name = "jushoText", order = 10)
    public RString jushoText;
    @ReportItem(name = "jusho4", length = 20, order = 11)
    public RString jusho4;
    @ReportItem(name = "jusho3", length = 20, order = 12)
    public RString jusho3;
    @ReportItem(name = "jusho5", length = 20, order = 13)
    public RString jusho5;
    @ReportItem(name = "jusho1", length = 20, order = 14)
    public RString jusho1;
    @ReportItem(name = "jusho6", length = 20, order = 15)
    public RString jusho6;
    @ReportItem(name = "jusho2", length = 20, order = 16)
    public RString jusho2;
    @ReportItem(name = "katagakiText1", order = 17)
    public RString katagakiText1;
    @ReportItem(name = "katagakiText", order = 18)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 18, order = 19)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall3", length = 26, order = 20)
    public RString katagakiSmall3;
    @ReportItem(name = "katagaki2", length = 18, order = 21)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 26, order = 22)
    public RString katagakiSmall2;
    @ReportItem(name = "katagakiSmall4", length = 26, order = 23)
    public RString katagakiSmall4;
    @ReportItem(name = "katagakiSmall1", length = 26, order = 24)
    public RString katagakiSmall1;
    @ReportItem(name = "katagaki4", length = 18, order = 25)
    public RString katagaki4;
    @ReportItem(name = "katagaki1", length = 18, order = 26)
    public RString katagaki1;
    @ReportItem(name = "dainoKubunMei1", length = 8, order = 27)
    public RString dainoKubunMei1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 28)
    public RString dainoKubunMei;
    @ReportItem(name = "shimeiSmall2", length = 26, order = 29)
    public RString shimeiSmall2;
    @ReportItem(name = "shimei3", length = 18, order = 30)
    public RString shimei3;
    @ReportItem(name = "meishoFuyo4", length = 2, order = 31)
    public RString meishoFuyo4;
    @ReportItem(name = "shimei2", length = 18, order = 32)
    public RString shimei2;
    @ReportItem(name = "meishoFuyo2", length = 2, order = 33)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiText1", order = 34)
    public RString shimeiText1;
    @ReportItem(name = "shimeiText", order = 35)
    public RString shimeiText;
    @ReportItem(name = "shimeiSmall3", length = 26, order = 36)
    public RString shimeiSmall3;
    @ReportItem(name = "shimei4", length = 18, order = 37)
    public RString shimei4;
    @ReportItem(name = "meishoFuyo3", length = 2, order = 38)
    public RString meishoFuyo3;
    @ReportItem(name = "shimeiSmall4", length = 26, order = 39)
    public RString shimeiSmall4;
    @ReportItem(name = "shimei1", length = 18, order = 40)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 2, order = 41)
    public RString meishoFuyo1;
    @ReportItem(name = "shimeiSmall1", length = 26, order = 42)
    public RString shimeiSmall1;
    @ReportItem(name = "samabunShimeiText1", order = 43)
    public RString samabunShimeiText1;
    @ReportItem(name = "samabunShimeiSmall3", length = 26, order = 44)
    public RString samabunShimeiSmall3;
    @ReportItem(name = "kakkoLeft3", length = 1, order = 45)
    public RString kakkoLeft3;
    @ReportItem(name = "samabunShimei3", length = 18, order = 46)
    public RString samabunShimei3;
    @ReportItem(name = "samaBun4", length = 2, order = 47)
    public RString samaBun4;
    @ReportItem(name = "kakkoRight4", length = 1, order = 48)
    public RString kakkoRight4;
    @ReportItem(name = "samabunShimeiText", order = 49)
    public RString samabunShimeiText;
    @ReportItem(name = "samabunShimeiSmall2", length = 26, order = 50)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 51)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 18, order = 52)
    public RString samabunShimei2;
    @ReportItem(name = "samaBun2", length = 2, order = 53)
    public RString samaBun2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 54)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft4", length = 1, order = 55)
    public RString kakkoLeft4;
    @ReportItem(name = "kakkoRight3", length = 1, order = 56)
    public RString kakkoRight3;
    @ReportItem(name = "samabunShimeiSmall4", length = 26, order = 57)
    public RString samabunShimeiSmall4;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 58)
    public RString kakkoLeft1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 59)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 26, order = 60)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "samaBun3", length = 2, order = 61)
    public RString samaBun3;
    @ReportItem(name = "samabunShimei4", length = 18, order = 62)
    public RString samabunShimei4;
    @ReportItem(name = "samaBun1", length = 2, order = 63)
    public RString samaBun1;
    @ReportItem(name = "samabunShimei1", length = 18, order = 64)
    public RString samabunShimei1;
    @ReportItem(name = "customerBarCode1", order = 65)
    public RString customerBarCode1;
    @ReportItem(name = "customerBarCode", order = 66)
    public RString customerBarCode;
    @ReportItem(name = "yubinNo3", length = 8, order = 67)
    public RString yubinNo3;
    @ReportItem(name = "gyoseiku3", length = 14, order = 68)
    public RString gyoseiku3;
    @ReportItem(name = "yubinNo2", length = 8, order = 69)
    public RString yubinNo2;
    @ReportItem(name = "gyoseiku2", length = 14, order = 70)
    public RString gyoseiku2;
    @ReportItem(name = "jushoText3", order = 71)
    public RString jushoText3;
    @ReportItem(name = "jushoText2", order = 72)
    public RString jushoText2;
    @ReportItem(name = "jusho10", length = 20, order = 73)
    public RString jusho10;
    @ReportItem(name = "jusho7", length = 20, order = 74)
    public RString jusho7;
    @ReportItem(name = "jusho11", length = 20, order = 75)
    public RString jusho11;
    @ReportItem(name = "jusho8", length = 20, order = 76)
    public RString jusho8;
    @ReportItem(name = "jusho12", length = 20, order = 77)
    public RString jusho12;
    @ReportItem(name = "jusho9", length = 20, order = 78)
    public RString jusho9;
    @ReportItem(name = "katagakiText3", order = 79)
    public RString katagakiText3;
    @ReportItem(name = "katagakiText2", order = 80)
    public RString katagakiText2;
    @ReportItem(name = "katagaki7", length = 18, order = 81)
    public RString katagaki7;
    @ReportItem(name = "katagakiSmall7", length = 26, order = 82)
    public RString katagakiSmall7;
    @ReportItem(name = "katagaki5", length = 18, order = 83)
    public RString katagaki5;
    @ReportItem(name = "katagakiSmall5", length = 26, order = 84)
    public RString katagakiSmall5;
    @ReportItem(name = "katagakiSmall8", length = 26, order = 85)
    public RString katagakiSmall8;
    @ReportItem(name = "katagakiSmall6", length = 26, order = 86)
    public RString katagakiSmall6;
    @ReportItem(name = "katagaki8", length = 18, order = 87)
    public RString katagaki8;
    @ReportItem(name = "katagaki6", length = 18, order = 88)
    public RString katagaki6;
    @ReportItem(name = "dainoKubunMei3", length = 8, order = 89)
    public RString dainoKubunMei3;
    @ReportItem(name = "dainoKubunMei2", length = 8, order = 90)
    public RString dainoKubunMei2;
    @ReportItem(name = "shimeiSmall5", length = 26, order = 91)
    public RString shimeiSmall5;
    @ReportItem(name = "shimei7", length = 18, order = 92)
    public RString shimei7;
    @ReportItem(name = "meishoFuyo8", length = 2, order = 93)
    public RString meishoFuyo8;
    @ReportItem(name = "shimei5", length = 18, order = 94)
    public RString shimei5;
    @ReportItem(name = "meishoFuyo6", length = 2, order = 95)
    public RString meishoFuyo6;
    @ReportItem(name = "shimeiText3", order = 96)
    public RString shimeiText3;
    @ReportItem(name = "shimeiText2", order = 97)
    public RString shimeiText2;
    @ReportItem(name = "shimeiSmall7", length = 26, order = 98)
    public RString shimeiSmall7;
    @ReportItem(name = "shimei8", length = 18, order = 99)
    public RString shimei8;
    @ReportItem(name = "meishoFuyo7", length = 2, order = 100)
    public RString meishoFuyo7;
    @ReportItem(name = "shimeiSmall8", length = 26, order = 101)
    public RString shimeiSmall8;
    @ReportItem(name = "shimei6", length = 18, order = 102)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo5", length = 2, order = 103)
    public RString meishoFuyo5;
    @ReportItem(name = "shimeiSmall6", length = 26, order = 104)
    public RString shimeiSmall6;
    @ReportItem(name = "samabunShimeiText3", order = 105)
    public RString samabunShimeiText3;
    @ReportItem(name = "samabunShimeiSmall7", length = 26, order = 106)
    public RString samabunShimeiSmall7;
    @ReportItem(name = "kakkoLeft7", length = 1, order = 107)
    public RString kakkoLeft7;
    @ReportItem(name = "samabunShimei7", length = 18, order = 108)
    public RString samabunShimei7;
    @ReportItem(name = "samaBun8", length = 2, order = 109)
    public RString samaBun8;
    @ReportItem(name = "kakkoRight8", length = 1, order = 110)
    public RString kakkoRight8;
    @ReportItem(name = "samabunShimeiText2", order = 111)
    public RString samabunShimeiText2;
    @ReportItem(name = "samabunShimeiSmall5", length = 26, order = 112)
    public RString samabunShimeiSmall5;
    @ReportItem(name = "kakkoLeft5", length = 1, order = 113)
    public RString kakkoLeft5;
    @ReportItem(name = "samabunShimei5", length = 18, order = 114)
    public RString samabunShimei5;
    @ReportItem(name = "samaBun6", length = 2, order = 115)
    public RString samaBun6;
    @ReportItem(name = "kakkoRight6", length = 1, order = 116)
    public RString kakkoRight6;
    @ReportItem(name = "kakkoLeft8", length = 1, order = 117)
    public RString kakkoLeft8;
    @ReportItem(name = "kakkoRight7", length = 1, order = 118)
    public RString kakkoRight7;
    @ReportItem(name = "samabunShimeiSmall8", length = 26, order = 119)
    public RString samabunShimeiSmall8;
    @ReportItem(name = "kakkoLeft6", length = 1, order = 120)
    public RString kakkoLeft6;
    @ReportItem(name = "kakkoRight5", length = 1, order = 121)
    public RString kakkoRight5;
    @ReportItem(name = "samabunShimeiSmall6", length = 26, order = 122)
    public RString samabunShimeiSmall6;
    @ReportItem(name = "samaBun7", length = 2, order = 123)
    public RString samaBun7;
    @ReportItem(name = "samaBun5", length = 2, order = 124)
    public RString samaBun5;
    @ReportItem(name = "samabunShimei8", length = 18, order = 125)
    public RString samabunShimei8;
    @ReportItem(name = "samabunShimei6", length = 18, order = 126)
    public RString samabunShimei6;
    @ReportItem(name = "customerBarCode3", order = 127)
    public RString customerBarCode3;
    @ReportItem(name = "customerBarCode2", order = 128)
    public RString customerBarCode2;
    @ReportItem(name = "yubinNo5", length = 8, order = 129)
    public RString yubinNo5;
    @ReportItem(name = "gyoseiku5", length = 14, order = 130)
    public RString gyoseiku5;
    @ReportItem(name = "yubinNo4", length = 8, order = 131)
    public RString yubinNo4;
    @ReportItem(name = "gyoseiku4", length = 14, order = 132)
    public RString gyoseiku4;
    @ReportItem(name = "jushoText5", order = 133)
    public RString jushoText5;
    @ReportItem(name = "jushoText4", order = 134)
    public RString jushoText4;
    @ReportItem(name = "jusho16", length = 20, order = 135)
    public RString jusho16;
    @ReportItem(name = "jusho13", length = 20, order = 136)
    public RString jusho13;
    @ReportItem(name = "jusho17", length = 20, order = 137)
    public RString jusho17;
    @ReportItem(name = "jusho14", length = 20, order = 138)
    public RString jusho14;
    @ReportItem(name = "jusho18", length = 20, order = 139)
    public RString jusho18;
    @ReportItem(name = "jusho15", length = 20, order = 140)
    public RString jusho15;
    @ReportItem(name = "katagakiText5", order = 141)
    public RString katagakiText5;
    @ReportItem(name = "katagakiText4", order = 142)
    public RString katagakiText4;
    @ReportItem(name = "katagaki11", length = 18, order = 143)
    public RString katagaki11;
    @ReportItem(name = "katagakiSmall11", length = 26, order = 144)
    public RString katagakiSmall11;
    @ReportItem(name = "katagaki9", length = 18, order = 145)
    public RString katagaki9;
    @ReportItem(name = "katagakiSmall9", length = 26, order = 146)
    public RString katagakiSmall9;
    @ReportItem(name = "katagakiSmall12", length = 26, order = 147)
    public RString katagakiSmall12;
    @ReportItem(name = "katagakiSmall10", length = 26, order = 148)
    public RString katagakiSmall10;
    @ReportItem(name = "katagaki12", length = 18, order = 149)
    public RString katagaki12;
    @ReportItem(name = "katagaki10", length = 18, order = 150)
    public RString katagaki10;
    @ReportItem(name = "dainoKubunMei5", length = 8, order = 151)
    public RString dainoKubunMei5;
    @ReportItem(name = "dainoKubunMei4", length = 8, order = 152)
    public RString dainoKubunMei4;
    @ReportItem(name = "shimeiSmall9", length = 26, order = 153)
    public RString shimeiSmall9;
    @ReportItem(name = "shimei11", length = 18, order = 154)
    public RString shimei11;
    @ReportItem(name = "meishoFuyo12", length = 2, order = 155)
    public RString meishoFuyo12;
    @ReportItem(name = "shimei9", length = 18, order = 156)
    public RString shimei9;
    @ReportItem(name = "meishoFuyo10", length = 2, order = 157)
    public RString meishoFuyo10;
    @ReportItem(name = "shimeiText5", order = 158)
    public RString shimeiText5;
    @ReportItem(name = "shimeiText4", order = 159)
    public RString shimeiText4;
    @ReportItem(name = "shimeiSmall11", length = 26, order = 160)
    public RString shimeiSmall11;
    @ReportItem(name = "shimei12", length = 18, order = 161)
    public RString shimei12;
    @ReportItem(name = "meishoFuyo11", length = 2, order = 162)
    public RString meishoFuyo11;
    @ReportItem(name = "shimeiSmall12", length = 26, order = 163)
    public RString shimeiSmall12;
    @ReportItem(name = "shimei10", length = 18, order = 164)
    public RString shimei10;
    @ReportItem(name = "meishoFuyo9", length = 2, order = 165)
    public RString meishoFuyo9;
    @ReportItem(name = "shimeiSmall10", length = 26, order = 166)
    public RString shimeiSmall10;
    @ReportItem(name = "kakkoLeft11", length = 1, order = 167)
    public RString kakkoLeft11;
    @ReportItem(name = "samabunShimeiText5", order = 168)
    public RString samabunShimeiText5;
    @ReportItem(name = "kakkoLeft9", length = 1, order = 169)
    public RString kakkoLeft9;
    @ReportItem(name = "samabunShimeiSmall11", length = 26, order = 170)
    public RString samabunShimeiSmall11;
    @ReportItem(name = "samabunShimei11", length = 18, order = 171)
    public RString samabunShimei11;
    @ReportItem(name = "samaBun12", length = 2, order = 172)
    public RString samaBun12;
    @ReportItem(name = "kakkoRight12", length = 1, order = 173)
    public RString kakkoRight12;
    @ReportItem(name = "samabunShimeiText4", order = 174)
    public RString samabunShimeiText4;
    @ReportItem(name = "samabunShimeiSmall9", length = 26, order = 175)
    public RString samabunShimeiSmall9;
    @ReportItem(name = "samabunShimei9", length = 18, order = 176)
    public RString samabunShimei9;
    @ReportItem(name = "samaBun10", length = 2, order = 177)
    public RString samaBun10;
    @ReportItem(name = "kakkoRight10", length = 1, order = 178)
    public RString kakkoRight10;
    @ReportItem(name = "kakkoLeft10", length = 1, order = 179)
    public RString kakkoLeft10;
    @ReportItem(name = "kakkoLeft12", length = 1, order = 180)
    public RString kakkoLeft12;
    @ReportItem(name = "kakkoRight11", length = 1, order = 181)
    public RString kakkoRight11;
    @ReportItem(name = "samabunShimeiSmall12", length = 26, order = 182)
    public RString samabunShimeiSmall12;
    @ReportItem(name = "samabunShimeiSmall10", length = 26, order = 183)
    public RString samabunShimeiSmall10;
    @ReportItem(name = "kakkoRight9", length = 1, order = 184)
    public RString kakkoRight9;
    @ReportItem(name = "samaBun11", length = 2, order = 185)
    public RString samaBun11;
    @ReportItem(name = "samabunShimei12", length = 18, order = 186)
    public RString samabunShimei12;
    @ReportItem(name = "samaBun9", length = 2, order = 187)
    public RString samaBun9;
    @ReportItem(name = "samabunShimei10", length = 18, order = 188)
    public RString samabunShimei10;
    @ReportItem(name = "customerBarCode5", order = 189)
    public RString customerBarCode5;
    @ReportItem(name = "customerBarCode4", order = 190)
    public RString customerBarCode4;
    @ReportItem(name = "yubinNo7", length = 8, order = 191)
    public RString yubinNo7;
    @ReportItem(name = "gyoseiku7", length = 14, order = 192)
    public RString gyoseiku7;
    @ReportItem(name = "yubinNo6", length = 8, order = 193)
    public RString yubinNo6;
    @ReportItem(name = "gyoseiku6", length = 14, order = 194)
    public RString gyoseiku6;
    @ReportItem(name = "jushoText7", order = 195)
    public RString jushoText7;
    @ReportItem(name = "jushoText6", order = 196)
    public RString jushoText6;
    @ReportItem(name = "jusho22", length = 20, order = 197)
    public RString jusho22;
    @ReportItem(name = "jusho19", length = 20, order = 198)
    public RString jusho19;
    @ReportItem(name = "jusho23", length = 20, order = 199)
    public RString jusho23;
    @ReportItem(name = "jusho20", length = 20, order = 200)
    public RString jusho20;
    @ReportItem(name = "jusho24", length = 20, order = 201)
    public RString jusho24;
    @ReportItem(name = "jusho21", length = 20, order = 202)
    public RString jusho21;
    @ReportItem(name = "katagakiText7", order = 203)
    public RString katagakiText7;
    @ReportItem(name = "katagakiText6", order = 204)
    public RString katagakiText6;
    @ReportItem(name = "katagaki15", length = 18, order = 205)
    public RString katagaki15;
    @ReportItem(name = "katagakiSmall15", length = 26, order = 206)
    public RString katagakiSmall15;
    @ReportItem(name = "katagaki13", length = 18, order = 207)
    public RString katagaki13;
    @ReportItem(name = "katagakiSmall13", length = 26, order = 208)
    public RString katagakiSmall13;
    @ReportItem(name = "katagakiSmall16", length = 26, order = 209)
    public RString katagakiSmall16;
    @ReportItem(name = "katagakiSmall14", length = 26, order = 210)
    public RString katagakiSmall14;
    @ReportItem(name = "katagaki16", length = 18, order = 211)
    public RString katagaki16;
    @ReportItem(name = "katagaki14", length = 18, order = 212)
    public RString katagaki14;
    @ReportItem(name = "dainoKubunMei7", length = 8, order = 213)
    public RString dainoKubunMei7;
    @ReportItem(name = "dainoKubunMei6", length = 8, order = 214)
    public RString dainoKubunMei6;
    @ReportItem(name = "shimeiSmall13", length = 26, order = 215)
    public RString shimeiSmall13;
    @ReportItem(name = "shimei15", length = 18, order = 216)
    public RString shimei15;
    @ReportItem(name = "meishoFuyo16", length = 2, order = 217)
    public RString meishoFuyo16;
    @ReportItem(name = "shimei13", length = 18, order = 218)
    public RString shimei13;
    @ReportItem(name = "meishoFuyo14", length = 2, order = 219)
    public RString meishoFuyo14;
    @ReportItem(name = "shimeiText7", order = 220)
    public RString shimeiText7;
    @ReportItem(name = "shimeiText6", order = 221)
    public RString shimeiText6;
    @ReportItem(name = "shimeiSmall15", length = 26, order = 222)
    public RString shimeiSmall15;
    @ReportItem(name = "shimei16", length = 18, order = 223)
    public RString shimei16;
    @ReportItem(name = "meishoFuyo15", length = 2, order = 224)
    public RString meishoFuyo15;
    @ReportItem(name = "shimeiSmall16", length = 26, order = 225)
    public RString shimeiSmall16;
    @ReportItem(name = "shimei14", length = 18, order = 226)
    public RString shimei14;
    @ReportItem(name = "meishoFuyo13", length = 2, order = 227)
    public RString meishoFuyo13;
    @ReportItem(name = "shimeiSmall14", length = 26, order = 228)
    public RString shimeiSmall14;
    @ReportItem(name = "samabunShimeiText7", order = 229)
    public RString samabunShimeiText7;
    @ReportItem(name = "samabunShimeiSmall15", length = 26, order = 230)
    public RString samabunShimeiSmall15;
    @ReportItem(name = "samabunShimei15", length = 18, order = 231)
    public RString samabunShimei15;
    @ReportItem(name = "samaBun16", length = 2, order = 232)
    public RString samaBun16;
    @ReportItem(name = "kakkoRight16", length = 1, order = 233)
    public RString kakkoRight16;
    @ReportItem(name = "samabunShimeiText6", order = 234)
    public RString samabunShimeiText6;
    @ReportItem(name = "kakkoLeft15", length = 1, order = 235)
    public RString kakkoLeft15;
    @ReportItem(name = "samabunShimeiSmall13", length = 26, order = 236)
    public RString samabunShimeiSmall13;
    @ReportItem(name = "samabunShimei13", length = 18, order = 237)
    public RString samabunShimei13;
    @ReportItem(name = "kakkoLeft13", length = 1, order = 238)
    public RString kakkoLeft13;
    @ReportItem(name = "samaBun14", length = 2, order = 239)
    public RString samaBun14;
    @ReportItem(name = "kakkoRight14", length = 1, order = 240)
    public RString kakkoRight14;
    @ReportItem(name = "kakkoLeft16", length = 1, order = 241)
    public RString kakkoLeft16;
    @ReportItem(name = "kakkoRight15", length = 1, order = 242)
    public RString kakkoRight15;
    @ReportItem(name = "samabunShimeiSmall16", length = 26, order = 243)
    public RString samabunShimeiSmall16;
    @ReportItem(name = "kakkoLeft14", length = 1, order = 244)
    public RString kakkoLeft14;
    @ReportItem(name = "kakkoRight13", length = 1, order = 245)
    public RString kakkoRight13;
    @ReportItem(name = "samabunShimeiSmall14", length = 26, order = 246)
    public RString samabunShimeiSmall14;
    @ReportItem(name = "samaBun15", length = 2, order = 247)
    public RString samaBun15;
    @ReportItem(name = "samabunShimei16", length = 18, order = 248)
    public RString samabunShimei16;
    @ReportItem(name = "samaBun13", length = 2, order = 249)
    public RString samaBun13;
    @ReportItem(name = "samabunShimei14", length = 18, order = 250)
    public RString samabunShimei14;
    @ReportItem(name = "customerBarCode7", order = 251)
    public RString customerBarCode7;
    @ReportItem(name = "customerBarCode6", order = 252)
    public RString customerBarCode6;
    @ReportItem(name = "yubinNo9", length = 8, order = 253)
    public RString yubinNo9;
    @ReportItem(name = "gyoseiku9", length = 14, order = 254)
    public RString gyoseiku9;
    @ReportItem(name = "yubinNo8", length = 8, order = 255)
    public RString yubinNo8;
    @ReportItem(name = "gyoseiku8", length = 14, order = 256)
    public RString gyoseiku8;
    @ReportItem(name = "jushoText9", order = 257)
    public RString jushoText9;
    @ReportItem(name = "jushoText8", order = 258)
    public RString jushoText8;
    @ReportItem(name = "jusho28", length = 20, order = 259)
    public RString jusho28;
    @ReportItem(name = "jusho25", length = 20, order = 260)
    public RString jusho25;
    @ReportItem(name = "jusho29", length = 20, order = 261)
    public RString jusho29;
    @ReportItem(name = "jusho26", length = 20, order = 262)
    public RString jusho26;
    @ReportItem(name = "jusho30", length = 20, order = 263)
    public RString jusho30;
    @ReportItem(name = "jusho27", length = 20, order = 264)
    public RString jusho27;
    @ReportItem(name = "katagakiText9", order = 265)
    public RString katagakiText9;
    @ReportItem(name = "katagakiText8", order = 266)
    public RString katagakiText8;
    @ReportItem(name = "katagaki19", length = 18, order = 267)
    public RString katagaki19;
    @ReportItem(name = "katagakiSmall19", length = 26, order = 268)
    public RString katagakiSmall19;
    @ReportItem(name = "katagaki17", length = 18, order = 269)
    public RString katagaki17;
    @ReportItem(name = "katagakiSmall17", length = 26, order = 270)
    public RString katagakiSmall17;
    @ReportItem(name = "katagakiSmall20", length = 26, order = 271)
    public RString katagakiSmall20;
    @ReportItem(name = "katagakiSmall18", length = 26, order = 272)
    public RString katagakiSmall18;
    @ReportItem(name = "katagaki20", length = 18, order = 273)
    public RString katagaki20;
    @ReportItem(name = "katagaki18", length = 18, order = 274)
    public RString katagaki18;
    @ReportItem(name = "dainoKubunMei9", length = 8, order = 275)
    public RString dainoKubunMei9;
    @ReportItem(name = "dainoKubunMei8", length = 8, order = 276)
    public RString dainoKubunMei8;
    @ReportItem(name = "shimeiSmall17", length = 26, order = 277)
    public RString shimeiSmall17;
    @ReportItem(name = "shimei19", length = 18, order = 278)
    public RString shimei19;
    @ReportItem(name = "meishoFuyo20", length = 2, order = 279)
    public RString meishoFuyo20;
    @ReportItem(name = "shimei17", length = 18, order = 280)
    public RString shimei17;
    @ReportItem(name = "meishoFuyo18", length = 2, order = 281)
    public RString meishoFuyo18;
    @ReportItem(name = "shimeiText9", order = 282)
    public RString shimeiText9;
    @ReportItem(name = "shimeiText8", order = 283)
    public RString shimeiText8;
    @ReportItem(name = "shimeiSmall19", length = 26, order = 284)
    public RString shimeiSmall19;
    @ReportItem(name = "shimei20", length = 18, order = 285)
    public RString shimei20;
    @ReportItem(name = "meishoFuyo19", length = 2, order = 286)
    public RString meishoFuyo19;
    @ReportItem(name = "shimeiSmall20", length = 26, order = 287)
    public RString shimeiSmall20;
    @ReportItem(name = "shimei18", length = 18, order = 288)
    public RString shimei18;
    @ReportItem(name = "meishoFuyo17", length = 2, order = 289)
    public RString meishoFuyo17;
    @ReportItem(name = "shimeiSmall18", length = 26, order = 290)
    public RString shimeiSmall18;
    @ReportItem(name = "samabunShimeiText9", order = 291)
    public RString samabunShimeiText9;
    @ReportItem(name = "samabunShimeiSmall19", length = 26, order = 292)
    public RString samabunShimeiSmall19;
    @ReportItem(name = "samabunShimei19", length = 18, order = 293)
    public RString samabunShimei19;
    @ReportItem(name = "kakkoLeft19", length = 1, order = 294)
    public RString kakkoLeft19;
    @ReportItem(name = "samaBun20", length = 2, order = 295)
    public RString samaBun20;
    @ReportItem(name = "kakkoRight20", length = 1, order = 296)
    public RString kakkoRight20;
    @ReportItem(name = "samabunShimeiText8", order = 297)
    public RString samabunShimeiText8;
    @ReportItem(name = "samabunShimeiSmall17", length = 26, order = 298)
    public RString samabunShimeiSmall17;
    @ReportItem(name = "kakkoLeft17", length = 1, order = 299)
    public RString kakkoLeft17;
    @ReportItem(name = "samabunShimei17", length = 18, order = 300)
    public RString samabunShimei17;
    @ReportItem(name = "samaBun18", length = 2, order = 301)
    public RString samaBun18;
    @ReportItem(name = "kakkoRight18", length = 1, order = 302)
    public RString kakkoRight18;
    @ReportItem(name = "kakkoLeft20", length = 1, order = 303)
    public RString kakkoLeft20;
    @ReportItem(name = "kakkoRight19", length = 1, order = 304)
    public RString kakkoRight19;
    @ReportItem(name = "samabunShimeiSmall20", length = 26, order = 305)
    public RString samabunShimeiSmall20;
    @ReportItem(name = "kakkoLeft18", length = 1, order = 306)
    public RString kakkoLeft18;
    @ReportItem(name = "kakkoRight17", length = 1, order = 307)
    public RString kakkoRight17;
    @ReportItem(name = "samabunShimeiSmall18", length = 26, order = 308)
    public RString samabunShimeiSmall18;
    @ReportItem(name = "samaBun19", length = 2, order = 309)
    public RString samaBun19;
    @ReportItem(name = "samaBun17", length = 2, order = 310)
    public RString samaBun17;
    @ReportItem(name = "samabunShimei20", length = 18, order = 311)
    public RString samabunShimei20;
    @ReportItem(name = "samabunShimei18", length = 18, order = 312)
    public RString samabunShimei18;
    @ReportItem(name = "customerBarCode9", order = 313)
    public RString customerBarCode9;
    @ReportItem(name = "customerBarCode8", order = 314)
    public RString customerBarCode8;
    @ReportItem(name = "yubinNo11", length = 8, order = 315)
    public RString yubinNo11;
    @ReportItem(name = "gyoseiku11", length = 14, order = 316)
    public RString gyoseiku11;
    @ReportItem(name = "yubinNo10", length = 8, order = 317)
    public RString yubinNo10;
    @ReportItem(name = "gyoseiku10", length = 14, order = 318)
    public RString gyoseiku10;
    @ReportItem(name = "jushoText11", order = 319)
    public RString jushoText11;
    @ReportItem(name = "jushoText10", order = 320)
    public RString jushoText10;
    @ReportItem(name = "jusho34", length = 20, order = 321)
    public RString jusho34;
    @ReportItem(name = "jusho31", length = 20, order = 322)
    public RString jusho31;
    @ReportItem(name = "jusho35", length = 20, order = 323)
    public RString jusho35;
    @ReportItem(name = "jusho32", length = 20, order = 324)
    public RString jusho32;
    @ReportItem(name = "jusho36", length = 20, order = 325)
    public RString jusho36;
    @ReportItem(name = "jusho33", length = 20, order = 326)
    public RString jusho33;
    @ReportItem(name = "katagakiText11", order = 327)
    public RString katagakiText11;
    @ReportItem(name = "katagakiText10", order = 328)
    public RString katagakiText10;
    @ReportItem(name = "katagaki23", length = 18, order = 329)
    public RString katagaki23;
    @ReportItem(name = "katagakiSmall23", length = 26, order = 330)
    public RString katagakiSmall23;
    @ReportItem(name = "katagaki21", length = 18, order = 331)
    public RString katagaki21;
    @ReportItem(name = "katagakiSmall21", length = 26, order = 332)
    public RString katagakiSmall21;
    @ReportItem(name = "katagakiSmall24", length = 26, order = 333)
    public RString katagakiSmall24;
    @ReportItem(name = "katagakiSmall22", length = 26, order = 334)
    public RString katagakiSmall22;
    @ReportItem(name = "katagaki24", length = 18, order = 335)
    public RString katagaki24;
    @ReportItem(name = "katagaki22", length = 18, order = 336)
    public RString katagaki22;
    @ReportItem(name = "dainoKubunMei11", length = 8, order = 337)
    public RString dainoKubunMei11;
    @ReportItem(name = "dainoKubunMei10", length = 8, order = 338)
    public RString dainoKubunMei10;
    @ReportItem(name = "shimeiSmall21", length = 26, order = 339)
    public RString shimeiSmall21;
    @ReportItem(name = "shimei23", length = 18, order = 340)
    public RString shimei23;
    @ReportItem(name = "meishoFuyo24", length = 2, order = 341)
    public RString meishoFuyo24;
    @ReportItem(name = "shimei21", length = 18, order = 342)
    public RString shimei21;
    @ReportItem(name = "meishoFuyo22", length = 2, order = 343)
    public RString meishoFuyo22;
    @ReportItem(name = "shimeiText11", order = 344)
    public RString shimeiText11;
    @ReportItem(name = "shimeiText10", order = 345)
    public RString shimeiText10;
    @ReportItem(name = "shimeiSmall23", length = 26, order = 346)
    public RString shimeiSmall23;
    @ReportItem(name = "shimei24", length = 18, order = 347)
    public RString shimei24;
    @ReportItem(name = "meishoFuyo23", length = 2, order = 348)
    public RString meishoFuyo23;
    @ReportItem(name = "shimeiSmall24", length = 26, order = 349)
    public RString shimeiSmall24;
    @ReportItem(name = "shimei22", length = 18, order = 350)
    public RString shimei22;
    @ReportItem(name = "meishoFuyo21", length = 2, order = 351)
    public RString meishoFuyo21;
    @ReportItem(name = "shimeiSmall22", length = 26, order = 352)
    public RString shimeiSmall22;
    @ReportItem(name = "samabunShimeiText11", order = 353)
    public RString samabunShimeiText11;
    @ReportItem(name = "samabunShimeiSmall23", length = 26, order = 354)
    public RString samabunShimeiSmall23;
    @ReportItem(name = "samabunShimei23", length = 18, order = 355)
    public RString samabunShimei23;
    @ReportItem(name = "kakkoLeft23", length = 1, order = 356)
    public RString kakkoLeft23;
    @ReportItem(name = "samaBun24", length = 2, order = 357)
    public RString samaBun24;
    @ReportItem(name = "kakkoRight24", length = 1, order = 358)
    public RString kakkoRight24;
    @ReportItem(name = "samabunShimeiText10", order = 359)
    public RString samabunShimeiText10;
    @ReportItem(name = "samabunShimeiSmall21", length = 26, order = 360)
    public RString samabunShimeiSmall21;
    @ReportItem(name = "kakkoLeft21", length = 1, order = 361)
    public RString kakkoLeft21;
    @ReportItem(name = "samabunShimei21", length = 18, order = 362)
    public RString samabunShimei21;
    @ReportItem(name = "samaBun22", length = 2, order = 363)
    public RString samaBun22;
    @ReportItem(name = "kakkoRight22", length = 1, order = 364)
    public RString kakkoRight22;
    @ReportItem(name = "kakkoLeft24", length = 1, order = 365)
    public RString kakkoLeft24;
    @ReportItem(name = "kakkoRight23", length = 1, order = 366)
    public RString kakkoRight23;
    @ReportItem(name = "samabunShimeiSmall24", length = 26, order = 367)
    public RString samabunShimeiSmall24;
    @ReportItem(name = "kakkoLeft22", length = 1, order = 368)
    public RString kakkoLeft22;
    @ReportItem(name = "kakkoRight21", length = 1, order = 369)
    public RString kakkoRight21;
    @ReportItem(name = "samabunShimeiSmall22", length = 26, order = 370)
    public RString samabunShimeiSmall22;
    @ReportItem(name = "samaBun23", length = 2, order = 371)
    public RString samaBun23;
    @ReportItem(name = "samaBun21", length = 2, order = 372)
    public RString samaBun21;
    @ReportItem(name = "samabunShimei24", length = 18, order = 373)
    public RString samabunShimei24;
    @ReportItem(name = "samabunShimei22", length = 18, order = 374)
    public RString samabunShimei22;
    @ReportItem(name = "customerBarCode11", order = 375)
    public RString customerBarCode11;
    @ReportItem(name = "customerBarCode10", order = 376)
    public RString customerBarCode10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
