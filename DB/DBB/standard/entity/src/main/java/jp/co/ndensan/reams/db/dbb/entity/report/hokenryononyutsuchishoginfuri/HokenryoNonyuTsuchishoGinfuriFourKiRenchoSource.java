package jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_5期_連帳 HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource
 *
 * @reamsid_L DBB-9110-090 liangbc
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "titleKanendo", length = 4, order = 1)
    public RString titleKanendo;
    @ReportItem(name = "titleNendo", length = 4, order = 2)
    public RString titleNendo;
    @ReportItem(name = "santeiKisoKikanKaishi", length = 12, order = 3)
    public RString santeiKisoKikanKaishi;
    @ReportItem(name = "HyojicodeName1", order = 4)
    public RString hyojicodeName1;
    @ReportItem(name = "HyojicodeName2", order = 5)
    public RString hyojicodeName2;
    @ReportItem(name = "HyojicodeName3", order = 6)
    public RString hyojicodeName3;
    @ReportItem(name = "titleKanendoBun", length = 9, order = 7)
    public RString titleKanendoBun;
    @ReportItem(name = "santeiKisoKiaknShuryo", length = 12, order = 8)
    public RString santeiKisoKiaknShuryo;
    @ReportItem(name = "Hyojicode1", length = 12, order = 9)
    public RString hyojicode1;
    @ReportItem(name = "Hyojicode2", length = 12, order = 10)
    public RString hyojicode2;
    @ReportItem(name = "Hyojicode3", length = 12, order = 11)
    public RString hyojicode3;
    @ReportItem(name = "santeiKisoNokisu", length = 5, order = 12)
    public RString santeiKisoNokisu;
    @ReportItem(name = "tsuchishoNo", order = 13)
    public RString tsuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 14)
    public RString setaiCode;
    @ReportItem(name = "santeiKisoShotokuDankai", length = 5, order = 15)
    public RString santeiKisoShotokuDankai;
    @ReportItem(name = "hihokenshaName", order = 16)
    public RString hihokenshaName;
    @ReportItem(name = "santeiKisoHokenryoRitsu", length = 7, order = 17)
    public RString santeiKisoHokenryoRitsu;
    @ReportItem(name = "setaiNushiName", order = 18)
    public RString setaiNushiName;
    @ReportItem(name = "santeiKisoCalHokenryoGaku", length = 10, order = 19)
    public RString santeiKisoCalHokenryoGaku;
    @ReportItem(name = "nendo1", length = 4, order = 20)
    public RString nendo1;
    @ReportItem(name = "nendoKa", length = 4, order = 21)
    public RString nendoKa;
    @ReportItem(name = "hokenryoGaku", length = 10, order = 22)
    public RString hokenryoGaku;
    @ReportItem(name = "santeiKisoGenmenGaku", length = 10, order = 23)
    public RString santeiKisoGenmenGaku;
    @ReportItem(name = "santeiKisoTokuchoNofuSubekiGaku", length = 10, order = 24)
    public RString santeiKisoTokuchoNofuSubekiGaku;
    @ReportItem(name = "santeiKisoFuchoNofuSubekiGaku", length = 10, order = 25)
    public RString santeiKisoFuchoNofuSubekiGaku;
    @ReportItem(name = "santeiKisoNofuzumiGaku", length = 10, order = 26)
    public RString santeiKisoNofuzumiGaku;
    @ReportItem(name = "santeiKisoKongoNofuSubekiGaku", length = 10, order = 27)
    public RString santeiKisoKongoNofuSubekiGaku;
    @ReportItem(name = "santeiKisoKomokuTitle1", length = 4, order = 28)
    public RString santeiKisoKomokuTitle1;
    @ReportItem(name = "santeiKisoKomokuTitle3", length = 4, order = 29)
    public RString santeiKisoKomokuTitle3;
    @ReportItem(name = "santeiKisoTokiHokenryoGaku1", length = 10, order = 30)
    public RString santeiKisoTokiHokenryoGaku1;
    @ReportItem(name = "santeiKisoJikiHokenryoGaku1", length = 10, order = 31)
    public RString santeiKisoJikiHokenryoGaku1;
    @ReportItem(name = "santeiKisoKomokuTitle2", length = 4, order = 32)
    public RString santeiKisoKomokuTitle2;
    @ReportItem(name = "santeiKisoYen1", length = 1, order = 33)
    public RString santeiKisoYen1;
    @ReportItem(name = "santeiKisoKomokuTitle4", length = 4, order = 34)
    public RString santeiKisoKomokuTitle4;
    @ReportItem(name = "santeiKisoYen2", length = 1, order = 35)
    public RString santeiKisoYen2;
    @ReportItem(name = "renban", length = 10, order = 36)
    public RString renban;
    @ReportItem(name = "santeiKisoTokiHokenryoGaku2", length = 10, order = 37)
    public RString santeiKisoTokiHokenryoGaku2;
    @ReportItem(name = "santeiKisoJikiHokenryoGaku2", length = 10, order = 38)
    public RString santeiKisoJikiHokenryoGaku2;
    @ReportItem(name = "gekihenTitle", length = 20, order = 39)
    public RString gekihenTitle;
    @ReportItem(name = "gekihenMongon", length = 20, order = 40)
    public RString gekihenMongon;
    @ReportItem(name = "hokenshaName", length = 10, order = 41)
    public RString hokenshaName;
    @ReportItem(name = "ryoshushoKanendo", length = 4, order = 42)
    public RString ryoshushoKanendo;
    @ReportItem(name = "ryoshushoNendo", length = 4, order = 43)
    public RString ryoshushoNendo;
    @ReportItem(name = "ryoshushoNofuGaku1", length = 10, order = 44)
    public RString ryoshushoNofuGaku1;
    @ReportItem(name = "ki1", length = 2, order = 45)
    public RString ki1;
    @ReportItem(name = "nokiKaishi1", length = 11, order = 46)
    public RString nokiKaishi1;
    @ReportItem(name = "ryoshushoNofuin1", length = 2, order = 47)
    public RString ryoshushoNofuin1;
    @ReportItem(name = "tsuki1", length = 2, order = 48)
    public RString tsuki1;
    @ReportItem(name = "nokiShuryo1", length = 11, order = 49)
    public RString nokiShuryo1;
    @ReportItem(name = "ryoshushoRyoshuHizukein1", length = 4, order = 50)
    public RString ryoshushoRyoshuHizukein1;
    @ReportItem(name = "ryoshushoKi1", length = 2, order = 51)
    public RString ryoshushoKi1;
    @ReportItem(name = "ki2", length = 2, order = 52)
    public RString ki2;
    @ReportItem(name = "nokiKaishi2", length = 11, order = 53)
    public RString nokiKaishi2;
    @ReportItem(name = "ryoshushoZuiji1", length = 2, order = 54)
    public RString ryoshushoZuiji1;
    @ReportItem(name = "tsuki2", length = 2, order = 55)
    public RString tsuki2;
    @ReportItem(name = "nokiShuryo2", length = 11, order = 56)
    public RString nokiShuryo2;
    @ReportItem(name = "ki3", length = 2, order = 57)
    public RString ki3;
    @ReportItem(name = "nokiKaishi3", length = 11, order = 58)
    public RString nokiKaishi3;
    @ReportItem(name = "tsuki3", length = 2, order = 59)
    public RString tsuki3;
    @ReportItem(name = "nokiShuryo3", length = 11, order = 60)
    public RString nokiShuryo3;
    @ReportItem(name = "ryoshushoNofuGaku2", length = 10, order = 61)
    public RString ryoshushoNofuGaku2;
    @ReportItem(name = "ki4", length = 2, order = 62)
    public RString ki4;
    @ReportItem(name = "nokiKaishi4", length = 11, order = 63)
    public RString nokiKaishi4;
    @ReportItem(name = "ryoshushoNofuin2", length = 2, order = 64)
    public RString ryoshushoNofuin2;
    @ReportItem(name = "ryoshushoRyoshuHizukein2", length = 4, order = 65)
    public RString ryoshushoRyoshuHizukein2;
    @ReportItem(name = "tsuki4", length = 2, order = 66)
    public RString tsuki4;
    @ReportItem(name = "nokiShuryo4", length = 11, order = 67)
    public RString nokiShuryo4;
    @ReportItem(name = "ryoshushoKi2", length = 2, order = 68)
    public RString ryoshushoKi2;
    @ReportItem(name = "ryoshushoZuiji2", length = 2, order = 69)
    public RString ryoshushoZuiji2;
    @ReportItem(name = "bankCode", length = 7, order = 70)
    public RString bankCode;
    @ReportItem(name = "kozaMeigi", order = 71)
    public RString kozaMeigi;
    @ReportItem(name = "ryoshushoNofuGaku3", length = 10, order = 72)
    public RString ryoshushoNofuGaku3;
    @ReportItem(name = "kozaShurui", length = 3, order = 73)
    public RString kozaShurui;
    @ReportItem(name = "ryoshushoNofuin3", length = 2, order = 74)
    public RString ryoshushoNofuin3;
    @ReportItem(name = "ryoshushoRyoshuHizukein3", length = 4, order = 75)
    public RString ryoshushoRyoshuHizukein3;
    @ReportItem(name = "kozaNo", length = 14, order = 76)
    public RString kozaNo;
    @ReportItem(name = "ryoshushoKi3", length = 2, order = 77)
    public RString ryoshushoKi3;
    @ReportItem(name = "bankName", order = 78)
    public RString bankName;
    @ReportItem(name = "ryoshushoZuiji3", length = 2, order = 79)
    public RString ryoshushoZuiji3;
    @ReportItem(name = "ryoshushoNofuGaku4", length = 10, order = 80)
    public RString ryoshushoNofuGaku4;
    @ReportItem(name = "tsuchiKaishiKi", length = 2, order = 81)
    public RString tsuchiKaishiKi;
    @ReportItem(name = "tsuchiShuryoKi", length = 2, order = 82)
    public RString tsuchiShuryoKi;
    @ReportItem(name = "ryoshushoNofuin4", length = 2, order = 83)
    public RString ryoshushoNofuin4;
    @ReportItem(name = "ryoshushoRyoshuHizukein4", length = 4, order = 84)
    public RString ryoshushoRyoshuHizukein4;
    @ReportItem(name = "ryoshushoKi4", length = 2, order = 85)
    public RString ryoshushoKi4;
    @ReportItem(name = "ryoshushoZuiji4", length = 2, order = 86)
    public RString ryoshushoZuiji4;
    @ReportItem(name = "yubinNo1", length = 8, order = 87)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 88)
    public RString gyoseiku1;
    @ReportItem(name = "jusho31", length = 20, order = 89)
    public RString jusho31;
    @ReportItem(name = "jushoText1", order = 90)
    public RString jushoText1;
    @ReportItem(name = "jusho11", length = 20, order = 91)
    public RString jusho11;
    @ReportItem(name = "jusho21", length = 20, order = 92)
    public RString jusho21;
    @ReportItem(name = "katagakiText1", order = 93)
    public RString katagakiText1;
    @ReportItem(name = "katagaki2", length = 20, order = 94)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall21", length = 30, order = 95)
    public RString katagakiSmall21;
    @ReportItem(name = "katagaki1", length = 20, order = 96)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall11", length = 30, order = 97)
    public RString katagakiSmall11;
    @ReportItem(name = "shimei21", length = 20, order = 98)
    public RString shimei21;
    @ReportItem(name = "shimeiSmall21", length = 40, order = 99)
    public RString shimeiSmall21;
    @ReportItem(name = "shimeiText1", order = 100)
    public RString shimeiText1;
    @ReportItem(name = "meishoFuyo21", length = 3, order = 101)
    public RString meishoFuyo21;
    @ReportItem(name = "dainoKubunMei1", length = 8, order = 102)
    public RString dainoKubunMei1;
    @ReportItem(name = "shimei11", length = 20, order = 103)
    public RString shimei11;
    @ReportItem(name = "shimeiSmall11", length = 40, order = 104)
    public RString shimeiSmall11;
    @ReportItem(name = "meishoFuyo11", length = 3, order = 105)
    public RString meishoFuyo11;
    @ReportItem(name = "samabunShimeiText1", order = 106)
    public RString samabunShimeiText1;
    @ReportItem(name = "kakkoLeft21", length = 1, order = 107)
    public RString kakkoLeft21;
    @ReportItem(name = "samabunShimei21", length = 20, order = 108)
    public RString samabunShimei21;
    @ReportItem(name = "samabunShimeiSmall21", length = 40, order = 109)
    public RString samabunShimeiSmall21;
    @ReportItem(name = "samaBun21", length = 3, order = 110)
    public RString samaBun21;
    @ReportItem(name = "kakkoRight21", length = 1, order = 111)
    public RString kakkoRight21;
    @ReportItem(name = "kakkoLeft11", length = 1, order = 112)
    public RString kakkoLeft11;
    @ReportItem(name = "samabunShimei11", length = 20, order = 113)
    public RString samabunShimei11;
    @ReportItem(name = "samabunShimeiSmall11", length = 40, order = 114)
    public RString samabunShimeiSmall11;
    @ReportItem(name = "samaBun11", length = 3, order = 115)
    public RString samaBun11;
    @ReportItem(name = "kakkoRight11", length = 1, order = 116)
    public RString kakkoRight11;
    @ReportItem(name = "customerBarCode1", order = 117)
    public RString customerBarCode1;
    @ReportItem(name = "denshiKoin", order = 118)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 119)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 120)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 121)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 122)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 123)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 124)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 125)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 126)
    public RString koinShoryaku;
    @ReportItem(name = "nofushoKanendo4", length = 6, order = 127)
    public RString nofushoKanendo4;
    @ReportItem(name = "nofushoNendo4", length = 6, order = 128)
    public RString nofushoNendo4;
    @ReportItem(name = "nofushoKanendobun4", length = 9, order = 129)
    public RString nofushoKanendobun4;
    @ReportItem(name = "nofushoKanendo3", length = 6, order = 130)
    public RString nofushoKanendo3;
    @ReportItem(name = "nofushoNendo3", length = 6, order = 131)
    public RString nofushoNendo3;
    @ReportItem(name = "nofushoKanendobun3", length = 9, order = 132)
    public RString nofushoKanendobun3;
    @ReportItem(name = "nofushoKanendo2", length = 6, order = 133)
    public RString nofushoKanendo2;
    @ReportItem(name = "nofushoNendo2", length = 6, order = 134)
    public RString nofushoNendo2;
    @ReportItem(name = "nofushoKanendobun2", length = 9, order = 135)
    public RString nofushoKanendobun2;
    @ReportItem(name = "nofushoKanendo1", length = 6, order = 136)
    public RString nofushoKanendo1;
    @ReportItem(name = "nofushoNendo1", length = 6, order = 137)
    public RString nofushoNendo1;
    @ReportItem(name = "nofushoKanendobun1", length = 9, order = 138)
    public RString nofushoKanendobun1;
    @ReportItem(name = "nofushoKi4", length = 2, order = 139)
    public RString nofushoKi4;
    @ReportItem(name = "nofushoTsuki4", length = 2, order = 140)
    public RString nofushoTsuki4;
    @ReportItem(name = "nofushoKi3", length = 2, order = 141)
    public RString nofushoKi3;
    @ReportItem(name = "nofushoTsuki3", length = 2, order = 142)
    public RString nofushoTsuki3;
    @ReportItem(name = "nofushoKi2", length = 2, order = 143)
    public RString nofushoKi2;
    @ReportItem(name = "nofushoTsuki2", length = 2, order = 144)
    public RString nofushoTsuki2;
    @ReportItem(name = "nofushoKi1", length = 2, order = 145)
    public RString nofushoKi1;
    @ReportItem(name = "nofushoTsuki1", length = 2, order = 146)
    public RString nofushoTsuki1;
    @ReportItem(name = "nofushoOcr14", length = 6, order = 147)
    public RString nofushoOcr14;
    @ReportItem(name = "nofushoOcr13", length = 6, order = 148)
    public RString nofushoOcr13;
    @ReportItem(name = "nofushoOcr12", length = 6, order = 149)
    public RString nofushoOcr12;
    @ReportItem(name = "nofushoOcr11", length = 6, order = 150)
    public RString nofushoOcr11;
    @ReportItem(name = "nofushoOcr24", length = 16, order = 151)
    public RString nofushoOcr24;
    @ReportItem(name = "nofushoOcr23", length = 16, order = 152)
    public RString nofushoOcr23;
    @ReportItem(name = "nofushoOcr22", length = 16, order = 153)
    public RString nofushoOcr22;
    @ReportItem(name = "nofushoOcr21", length = 16, order = 154)
    public RString nofushoOcr21;
    @ReportItem(name = "nofushoOcr34", length = 17, order = 155)
    public RString nofushoOcr34;
    @ReportItem(name = "nofushoOcr33", length = 17, order = 156)
    public RString nofushoOcr33;
    @ReportItem(name = "nofushoOcr32", length = 17, order = 157)
    public RString nofushoOcr32;
    @ReportItem(name = "nofushoOcr31", length = 17, order = 158)
    public RString nofushoOcr31;
    @ReportItem(name = "nofushoOcr44", length = 12, order = 159)
    public RString nofushoOcr44;
    @ReportItem(name = "nofushoOcr43", length = 12, order = 160)
    public RString nofushoOcr43;
    @ReportItem(name = "nofushoOcr42", length = 12, order = 161)
    public RString nofushoOcr42;
    @ReportItem(name = "nofushoOcr41", length = 12, order = 162)
    public RString nofushoOcr41;
    @ReportItem(name = "nofushoNofugaku4", length = 10, order = 163)
    public RString nofushoNofugaku4;
    @ReportItem(name = "nofushoNofugaku3", length = 10, order = 164)
    public RString nofushoNofugaku3;
    @ReportItem(name = "nofushoNofugaku2", length = 10, order = 165)
    public RString nofushoNofugaku2;
    @ReportItem(name = "nofushoNofugaku1", length = 10, order = 166)
    public RString nofushoNofugaku1;
    @ReportItem(name = "nofushoSofusakiName4", order = 167)
    public RString nofushoSofusakiName4;
    @ReportItem(name = "nofushoSofusakiName3", order = 168)
    public RString nofushoSofusakiName3;
    @ReportItem(name = "nofushoSofusakiName2", order = 169)
    public RString nofushoSofusakiName2;
    @ReportItem(name = "nofushoSofusakiName1", order = 170)
    public RString nofushoSofusakiName1;
    @ReportItem(name = "nofushoHonninName4", order = 171)
    public RString nofushoHonninName4;
    @ReportItem(name = "nofushoHonninName3", order = 172)
    public RString nofushoHonninName3;
    @ReportItem(name = "nofushoHonninName2", order = 173)
    public RString nofushoHonninName2;
    @ReportItem(name = "nofushoHonninName1", order = 174)
    public RString nofushoHonninName1;
    @ReportItem(name = "nofushoKakko14", length = 1, order = 175)
    public RString nofushoKakko14;
    @ReportItem(name = "nofushoKakko13", length = 1, order = 176)
    public RString nofushoKakko13;
    @ReportItem(name = "nofushoKakko12", length = 1, order = 177)
    public RString nofushoKakko12;
    @ReportItem(name = "nofushoKakko11", length = 1, order = 178)
    public RString nofushoKakko11;
    @ReportItem(name = "nofushoKakko24", length = 1, order = 179)
    public RString nofushoKakko24;
    @ReportItem(name = "nofushoKakko34", length = 3, order = 180)
    public RString nofushoKakko34;
    @ReportItem(name = "nofushoKakko23", length = 1, order = 181)
    public RString nofushoKakko23;
    @ReportItem(name = "nofushoKakko33", length = 3, order = 182)
    public RString nofushoKakko33;
    @ReportItem(name = "nofushoKakko22", length = 1, order = 183)
    public RString nofushoKakko22;
    @ReportItem(name = "nofushoKakko32", length = 3, order = 184)
    public RString nofushoKakko32;
    @ReportItem(name = "nofushoKakko21", length = 1, order = 185)
    public RString nofushoKakko21;
    @ReportItem(name = "nofushoKakko31", length = 3, order = 186)
    public RString nofushoKakko31;
    @ReportItem(name = "nofushoTsuchishoNo4", order = 187)
    public RString nofushoTsuchishoNo4;
    @ReportItem(name = "nofushoTsuchishoNo3", order = 188)
    public RString nofushoTsuchishoNo3;
    @ReportItem(name = "nofushoTsuchishoNo2", order = 189)
    public RString nofushoTsuchishoNo2;
    @ReportItem(name = "nofushoTsuchishoNo1", order = 190)
    public RString nofushoTsuchishoNo1;
    @ReportItem(name = "nofushoSetaiCode4", length = 15, order = 191)
    public RString nofushoSetaiCode4;
    @ReportItem(name = "nofushoSetaiCode3", length = 15, order = 192)
    public RString nofushoSetaiCode3;
    @ReportItem(name = "nofushoSetaiCode2", length = 15, order = 193)
    public RString nofushoSetaiCode2;
    @ReportItem(name = "nofushoSetaiCode1", length = 15, order = 194)
    public RString nofushoSetaiCode1;
    @ReportItem(name = "nofushohyojicodeName14", order = 195)
    public RString nofushohyojicodeName14;
    @ReportItem(name = "nofushohyojicode14", length = 20, order = 196)
    public RString nofushohyojicode14;
    @ReportItem(name = "nofushohyojicodeName13", order = 197)
    public RString nofushohyojicodeName13;
    @ReportItem(name = "nofushohyojicode13", length = 20, order = 198)
    public RString nofushohyojicode13;
    @ReportItem(name = "nofushohyojicodeName12", order = 199)
    public RString nofushohyojicodeName12;
    @ReportItem(name = "nofushohyojicode12", length = 20, order = 200)
    public RString nofushohyojicode12;
    @ReportItem(name = "nofushohyojicodeName11", order = 201)
    public RString nofushohyojicodeName11;
    @ReportItem(name = "nofushohyojicode11", length = 20, order = 202)
    public RString nofushohyojicode11;
    @ReportItem(name = "nofushohyojicodeName24", order = 203)
    public RString nofushohyojicodeName24;
    @ReportItem(name = "nofushohyojicode24", length = 20, order = 204)
    public RString nofushohyojicode24;
    @ReportItem(name = "nofushohyojicodeName23", order = 205)
    public RString nofushohyojicodeName23;
    @ReportItem(name = "nofushohyojicode23", length = 20, order = 206)
    public RString nofushohyojicode23;
    @ReportItem(name = "nofushohyojicodeName22", order = 207)
    public RString nofushohyojicodeName22;
    @ReportItem(name = "nofushohyojicode22", length = 20, order = 208)
    public RString nofushohyojicode22;
    @ReportItem(name = "nofushohyojicodeName21", order = 209)
    public RString nofushohyojicodeName21;
    @ReportItem(name = "nofushohyojicode21", length = 20, order = 210)
    public RString nofushohyojicode21;
    @ReportItem(name = "nofushohyojicodeName34", order = 211)
    public RString nofushohyojicodeName34;
    @ReportItem(name = "nofushohyojicode34", length = 20, order = 212)
    public RString nofushohyojicode34;
    @ReportItem(name = "nofushohyojicodeName33", order = 213)
    public RString nofushohyojicodeName33;
    @ReportItem(name = "nofushohyojicode33", length = 20, order = 214)
    public RString nofushohyojicode33;
    @ReportItem(name = "nofushohyojicodeName32", order = 215)
    public RString nofushohyojicodeName32;
    @ReportItem(name = "nofushohyojicode32", length = 20, order = 216)
    public RString nofushohyojicode32;
    @ReportItem(name = "nofushohyojicodeName31", order = 217)
    public RString nofushohyojicodeName31;
    @ReportItem(name = "nofushohyojicode31", length = 20, order = 218)
    public RString nofushohyojicode31;
    @ReportItem(name = "nofushoNokigen4", length = 11, order = 219)
    public RString nofushoNokigen4;
    @ReportItem(name = "nofushoNokigen3", length = 11, order = 220)
    public RString nofushoNokigen3;
    @ReportItem(name = "nofushoNokigen2", length = 11, order = 221)
    public RString nofushoNokigen2;
    @ReportItem(name = "nofushoNokigen1", length = 11, order = 222)
    public RString nofushoNokigen1;
    @ReportItem(name = "nofushoNofuin4", length = 2, order = 223)
    public RString nofushoNofuin4;
    @ReportItem(name = "nofushoNofuin3", length = 2, order = 224)
    public RString nofushoNofuin3;
    @ReportItem(name = "nofushoNofuin2", length = 2, order = 225)
    public RString nofushoNofuin2;
    @ReportItem(name = "nofushoNofuin1", length = 2, order = 226)
    public RString nofushoNofuin1;
    @ReportItem(name = "nofushoRyoshuHizukein4", length = 4, order = 227)
    public RString nofushoRyoshuHizukein4;
    @ReportItem(name = "nofushoRyoshuHizukein3", length = 4, order = 228)
    public RString nofushoRyoshuHizukein3;
    @ReportItem(name = "nofushoRyoshuHizukein2", length = 4, order = 229)
    public RString nofushoRyoshuHizukein2;
    @ReportItem(name = "nofushoRyoshuHizukein1", length = 4, order = 230)
    public RString nofushoRyoshuHizukein1;
    @ReportItem(name = "nofushoZuiji4", length = 2, order = 231)
    public RString nofushoZuiji4;
    @ReportItem(name = "nofushoZuiji3", length = 2, order = 232)
    public RString nofushoZuiji3;
    @ReportItem(name = "nofushoZuiji2", length = 2, order = 233)
    public RString nofushoZuiji2;
    @ReportItem(name = "nofushoZuiji1", length = 2, order = 234)
    public RString nofushoZuiji1;
    @ReportItem(name = "mRenban", length = 10, order = 235)
    public RString mRenban;
    @ReportItem(name = "nofushoShichosonMei14", order = 236)
    public RString nofushoShichosonMei14;
    @ReportItem(name = "nofushoShichosonMei13", order = 237)
    public RString nofushoShichosonMei13;
    @ReportItem(name = "nofushoShichosonMei12", order = 238)
    public RString nofushoShichosonMei12;
    @ReportItem(name = "nofushoShichosonMei11", order = 239)
    public RString nofushoShichosonMei11;
    @ReportItem(name = "yubinNo2", length = 8, order = 240)
    public RString yubinNo2;
    @ReportItem(name = "gyoseiku2", length = 14, order = 241)
    public RString gyoseiku2;
    @ReportItem(name = "jusho12", length = 20, order = 242)
    public RString jusho12;
    @ReportItem(name = "jushoText2", order = 243)
    public RString jushoText2;
    @ReportItem(name = "jusho22", length = 20, order = 244)
    public RString jusho22;
    @ReportItem(name = "jusho32", length = 20, order = 245)
    public RString jusho32;
    @ReportItem(name = "katagakiText2", order = 246)
    public RString katagakiText2;
    @ReportItem(name = "katagaki3", length = 20, order = 247)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall12", length = 30, order = 248)
    public RString katagakiSmall12;
    @ReportItem(name = "katagaki4", length = 20, order = 249)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall22", length = 30, order = 250)
    public RString katagakiSmall22;
    @ReportItem(name = "shimei12", length = 20, order = 251)
    public RString shimei12;
    @ReportItem(name = "shimeiSmall12", length = 40, order = 252)
    public RString shimeiSmall12;
    @ReportItem(name = "shimeiText2", order = 253)
    public RString shimeiText2;
    @ReportItem(name = "meishoFuyo22", length = 3, order = 254)
    public RString meishoFuyo22;
    @ReportItem(name = "dainoKubunMei2", length = 8, order = 255)
    public RString dainoKubunMei2;
    @ReportItem(name = "shimei22", length = 20, order = 256)
    public RString shimei22;
    @ReportItem(name = "shimeiSmall22", length = 40, order = 257)
    public RString shimeiSmall22;
    @ReportItem(name = "meishoFuyo12", length = 3, order = 258)
    public RString meishoFuyo12;
    @ReportItem(name = "samabunShimeiText2", order = 259)
    public RString samabunShimeiText2;
    @ReportItem(name = "kakkoLeft12", length = 1, order = 260)
    public RString kakkoLeft12;
    @ReportItem(name = "samabunShimei12", length = 20, order = 261)
    public RString samabunShimei12;
    @ReportItem(name = "samabunShimeiSmall12", length = 40, order = 262)
    public RString samabunShimeiSmall12;
    @ReportItem(name = "samaBun22", length = 3, order = 263)
    public RString samaBun22;
    @ReportItem(name = "kakkoRight22", length = 1, order = 264)
    public RString kakkoRight22;
    @ReportItem(name = "kakkoLeft22", length = 1, order = 265)
    public RString kakkoLeft22;
    @ReportItem(name = "samabunShimei22", length = 20, order = 266)
    public RString samabunShimei22;
    @ReportItem(name = "samabunShimeiSmall22", length = 40, order = 267)
    public RString samabunShimeiSmall22;
    @ReportItem(name = "samaBun12", length = 3, order = 268)
    public RString samaBun12;
    @ReportItem(name = "kakkoRight12", length = 1, order = 269)
    public RString kakkoRight12;
    @ReportItem(name = "customerBarCode2", order = 270)
    public RString customerBarCode2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
