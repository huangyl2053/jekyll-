// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class HokenryoNonyuTsuchishoKigotoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "mNendo", length = 4, order = 1)
    public RString mNendo;
    @ReportItem(name = "titleNendo", length = 4, order = 2)
    public RString titleNendo;
    @ReportItem(name = "titleKanendobun", length = 9, order = 3)
    public RString titleKanendobun;
    @ReportItem(name = "HyojicodeName1", length = 8, order = 4)
    public RString HyojicodeName1;
    @ReportItem(name = "hyojiKomoku1", length = 6, order = 5)
    public RString hyojiKomoku1;
    @ReportItem(name = "HyojicodeName2", length = 8, order = 6)
    public RString HyojicodeName2;
    @ReportItem(name = "hyojiKomoku2", length = 6, order = 7)
    public RString hyojiKomoku2;
    @ReportItem(name = "HyojicodeName3", length = 8, order = 8)
    public RString HyojicodeName3;
    @ReportItem(name = "hyojiKomoku3", length = 6, order = 9)
    public RString hyojiKomoku3;
    @ReportItem(name = "ki1", length = 2, order = 10)
    public RString ki1;
    @ReportItem(name = "nokiKaishi1", length = 11, order = 11)
    public RString nokiKaishi1;
    @ReportItem(name = "Hyojicode1", length = 15, order = 12)
    public RString Hyojicode1;
    @ReportItem(name = "Hyojicode2", length = 15, order = 13)
    public RString Hyojicode2;
    @ReportItem(name = "Hyojicode3", length = 15, order = 14)
    public RString Hyojicode3;
    @ReportItem(name = "tsuki1", length = 2, order = 15)
    public RString tsuki1;
    @ReportItem(name = "nokiShuryo1", length = 11, order = 16)
    public RString nokiShuryo1;
    @ReportItem(name = "tsuchishoNo", order = 17)
    public RString tsuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 18)
    public RString setaiCode;
    @ReportItem(name = "ki2", length = 2, order = 19)
    public RString ki2;
    @ReportItem(name = "nokiKaishi2", length = 11, order = 20)
    public RString nokiKaishi2;
    @ReportItem(name = "hihokenshaName", order = 21)
    public RString hihokenshaName;
    @ReportItem(name = "tsuki2", length = 2, order = 22)
    public RString tsuki2;
    @ReportItem(name = "nokiShuryo2", length = 11, order = 23)
    public RString nokiShuryo2;
    @ReportItem(name = "ki3", length = 2, order = 24)
    public RString ki3;
    @ReportItem(name = "nokiKaishi3", length = 11, order = 25)
    public RString nokiKaishi3;
    @ReportItem(name = "setaiNushiName", order = 26)
    public RString setaiNushiName;
    @ReportItem(name = "tsuki3", length = 2, order = 27)
    public RString tsuki3;
    @ReportItem(name = "nokiShuryo3", length = 11, order = 28)
    public RString nokiShuryo3;
    @ReportItem(name = "nendo", length = 4, order = 29)
    public RString nendo;
    @ReportItem(name = "nendo1", length = 4, order = 30)
    public RString nendo1;
    @ReportItem(name = "hokenryoGaku", length = 10, order = 31)
    public RString hokenryoGaku;
    @ReportItem(name = "ki4", length = 2, order = 32)
    public RString ki4;
    @ReportItem(name = "nokiKaishi4", length = 11, order = 33)
    public RString nokiKaishi4;
    @ReportItem(name = "kisoKikanKaishi", length = 12, order = 34)
    public RString kisoKikanKaishi;
    @ReportItem(name = "tsuki4", length = 2, order = 35)
    public RString tsuki4;
    @ReportItem(name = "nokiShuryo4", length = 11, order = 36)
    public RString nokiShuryo4;
    @ReportItem(name = "kisoTsukisu", length = 4, order = 37)
    public RString kisoTsukisu;
    @ReportItem(name = "kisoKikanShuryo", length = 12, order = 38)
    public RString kisoKikanShuryo;
    @ReportItem(name = "ki5", length = 2, order = 39)
    public RString ki5;
    @ReportItem(name = "nokiKaishi5", length = 11, order = 40)
    public RString nokiKaishi5;
    @ReportItem(name = "kisoShotokuDankai", length = 5, order = 41)
    public RString kisoShotokuDankai;
    @ReportItem(name = "kisoHokenryoRitsu", length = 7, order = 42)
    public RString kisoHokenryoRitsu;
    @ReportItem(name = "tsuki5", length = 2, order = 43)
    public RString tsuki5;
    @ReportItem(name = "nokiShuryo5", length = 11, order = 44)
    public RString nokiShuryo5;
    @ReportItem(name = "ki6", length = 2, order = 45)
    public RString ki6;
    @ReportItem(name = "nokiKaishi6", length = 11, order = 46)
    public RString nokiKaishi6;
    @ReportItem(name = "kisoCalHokenryoGaku", length = 10, order = 47)
    public RString kisoCalHokenryoGaku;
    @ReportItem(name = "kisoGenmenGaku", length = 10, order = 48)
    public RString kisoGenmenGaku;
    @ReportItem(name = "tsuki6", length = 2, order = 49)
    public RString tsuki6;
    @ReportItem(name = "nokiShuryo6", length = 11, order = 50)
    public RString nokiShuryo6;
    @ReportItem(name = "tokuchoNofuSubekiGaku", length = 10, order = 51)
    public RString tokuchoNofuSubekiGaku;
    @ReportItem(name = "fuchoNofuSubekiGaku", length = 10, order = 52)
    public RString fuchoNofuSubekiGaku;
    @ReportItem(name = "ki7", length = 2, order = 53)
    public RString ki7;
    @ReportItem(name = "nokiKaishi7", length = 11, order = 54)
    public RString nokiKaishi7;
    @ReportItem(name = "tsuki7", length = 2, order = 55)
    public RString tsuki7;
    @ReportItem(name = "nokiShuryo7", length = 11, order = 56)
    public RString nokiShuryo7;
    @ReportItem(name = "nofuZumiGaku", length = 10, order = 57)
    public RString nofuZumiGaku;
    @ReportItem(name = "kongoNofuSubekiGaku", length = 10, order = 58)
    public RString kongoNofuSubekiGaku;
    @ReportItem(name = "ki8", length = 2, order = 59)
    public RString ki8;
    @ReportItem(name = "nokiKaishi8", length = 11, order = 60)
    public RString nokiKaishi8;
    @ReportItem(name = "santeiKisoTokiTitle", length = 7, order = 61)
    public RString santeiKisoTokiTitle;
    @ReportItem(name = "santeiKisoJikiTitle", length = 8, order = 62)
    public RString santeiKisoJikiTitle;
    @ReportItem(name = "santeiKisoTokiHokenryoGaku", length = 10, order = 63)
    public RString santeiKisoTokiHokenryoGaku;
    @ReportItem(name = "santeiKisoJikoHokenryoGaku", length = 10, order = 64)
    public RString santeiKisoJikoHokenryoGaku;
    @ReportItem(name = "tsuki8", length = 2, order = 65)
    public RString tsuki8;
    @ReportItem(name = "nokiShuryo8", length = 11, order = 66)
    public RString nokiShuryo8;
    @ReportItem(name = "santeiKisoKi1", length = 7, order = 67)
    public RString santeiKisoKi1;
    @ReportItem(name = "santeiKisoYen1", length = 1, order = 68)
    public RString santeiKisoYen1;
    @ReportItem(name = "santeiKisoKi2", length = 7, order = 69)
    public RString santeiKisoKi2;
    @ReportItem(name = "santeiKisoYen2", length = 1, order = 70)
    public RString santeiKisoYen2;
    @ReportItem(name = "ki9", length = 2, order = 71)
    public RString ki9;
    @ReportItem(name = "nokiKaishi9", length = 11, order = 72)
    public RString nokiKaishi9;
    @ReportItem(name = "gekihenTitle", length = 20, order = 73)
    public RString gekihenTitle;
    @ReportItem(name = "santeiKisoKiHokenryoGaku1", length = 10, order = 74)
    public RString santeiKisoKiHokenryoGaku1;
    @ReportItem(name = "gekihenMongon", length = 20, order = 75)
    public RString gekihenMongon;
    @ReportItem(name = "santeiKisoKiHokenryoGaku2", length = 10, order = 76)
    public RString santeiKisoKiHokenryoGaku2;
    @ReportItem(name = "tsuki9", length = 2, order = 77)
    public RString tsuki9;
    @ReportItem(name = "nokiShuryo9", length = 11, order = 78)
    public RString nokiShuryo9;
    @ReportItem(name = "bankCode", length = 7, order = 79)
    public RString bankCode;
    @ReportItem(name = "kozaShurui", length = 3, order = 80)
    public RString kozaShurui;
    @ReportItem(name = "kozaNo", length = 14, order = 81)
    public RString kozaNo;
    @ReportItem(name = "ki10", length = 2, order = 82)
    public RString ki10;
    @ReportItem(name = "nokiKaishi10", length = 11, order = 83)
    public RString nokiKaishi10;
    @ReportItem(name = "bankName", order = 84)
    public RString bankName;
    @ReportItem(name = "tsuki10", length = 2, order = 85)
    public RString tsuki10;
    @ReportItem(name = "nokiShuryo10", length = 11, order = 86)
    public RString nokiShuryo10;
    @ReportItem(name = "kozaMeigi", order = 87)
    public RString kozaMeigi;
    @ReportItem(name = "renban", length = 10, order = 88)
    public RString renban;
    @ReportItem(name = "hokenshaName", length = 10, order = 89)
    public RString hokenshaName;
    @ReportItem(name = "yubinNo", length = 8, order = 90)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 91)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 92)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 93)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 94)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 95)
    public RString jusho2;
    @ReportItem(name = "katagaki2", length = 20, order = 96)
    public RString katagaki2;
    @ReportItem(name = "katagakiText", order = 97)
    public RString katagakiText;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 98)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 99)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 100)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 101)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 102)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 103)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 104)
    public RString meishoFuyo2;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 105)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 106)
    public RString shimei1;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 107)
    public RString shimeiSmall1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 108)
    public RString meishoFuyo1;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 109)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 110)
    public RString samabunShimei2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 111)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "samabunShimeiText", order = 112)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 113)
    public RString samaBun2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 114)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 115)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 116)
    public RString samabunShimei1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 117)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "samaBun1", length = 3, order = 118)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 119)
    public RString kakkoRight1;
    @ReportItem(name = "customerBarCode", order = 120)
    public RString customerBarCode;
    @ReportItem(name = "ryoshushoKanendo", length = 6, order = 121)
    public RString ryoshushoKanendo;
    @ReportItem(name = "ryoshushoNendo", length = 6, order = 122)
    public RString ryoshushoNendo;
    @ReportItem(name = "ryoshushoKanendobun", length = 9, order = 123)
    public RString ryoshushoKanendobun;
    @ReportItem(name = "ryoshushoKi", length = 2, order = 124)
    public RString ryoshushoKi;
    @ReportItem(name = "ryoshushoTsuki", length = 2, order = 125)
    public RString ryoshushoTsuki;
    @ReportItem(name = "ryoshushoYubinNo", length = 8, order = 126)
    public RString ryoshushoYubinNo;
    @ReportItem(name = "ryoshushoGyoseikuName", length = 14, order = 127)
    public RString ryoshushoGyoseikuName;
    @ReportItem(name = "ryoshushoJusho", order = 128)
    public RString ryoshushoJusho;
    @ReportItem(name = "ryoshushoKatagaki", order = 129)
    public RString ryoshushoKatagaki;
    @ReportItem(name = "ryoshushoSofusakiName", order = 130)
    public RString ryoshushoSofusakiName;
    @ReportItem(name = "ryoshushoKakko1", length = 1, order = 131)
    public RString ryoshushoKakko1;
    @ReportItem(name = "ryoshushoHonninName", order = 132)
    public RString ryoshushoHonninName;
    @ReportItem(name = "ryoshushoKakko2", length = 1, order = 133)
    public RString ryoshushoKakko2;
    @ReportItem(name = "ryoshushoKakko3", length = 3, order = 134)
    public RString ryoshushoKakko3;
    @ReportItem(name = "ryoshushoTsuchishoNo", order = 135)
    public RString ryoshushoTsuchishoNo;
    @ReportItem(name = "ryoshushoSetaiCode", length = 15, order = 136)
    public RString ryoshushoSetaiCode;
    @ReportItem(name = "ryoshushohyojicodeName1", order = 137)
    public RString ryoshushohyojicodeName1;
    @ReportItem(name = "ryoshushohyojicode1", length = 20, order = 138)
    public RString ryoshushohyojicode1;
    @ReportItem(name = "ryoshushohyojicodeName2", order = 139)
    public RString ryoshushohyojicodeName2;
    @ReportItem(name = "ryoshushohyojicode2", length = 20, order = 140)
    public RString ryoshushohyojicode2;
    @ReportItem(name = "ryoshushohyojicodeName3", order = 141)
    public RString ryoshushohyojicodeName3;
    @ReportItem(name = "ryoshushoHyojicode3", length = 20, order = 142)
    public RString ryoshushoHyojicode3;
    @ReportItem(name = "ryoshushoNokigen", length = 11, order = 143)
    public RString ryoshushoNokigen;
    @ReportItem(name = "ryoshushoNofugaku", length = 10, order = 144)
    public RString ryoshushoNofugaku;
    @ReportItem(name = "ryoshushoNofuin", length = 2, order = 145)
    public RString ryoshushoNofuin;
    @ReportItem(name = "ryoshushoRyoshuHizukein", length = 4, order = 146)
    public RString ryoshushoRyoshuHizukein;
    @ReportItem(name = "ryoshushoZuiji", length = 2, order = 147)
    public RString ryoshushoZuiji;
    @ReportItem(name = "ryoshushoRenban", length = 10, order = 148)
    public RString ryoshushoRenban;
    @ReportItem(name = "ryoshushoShichosonMei1", length = 10, order = 149)
    public RString ryoshushoShichosonMei1;
    @ReportItem(name = "ryoshushoShichosonMei2", length = 10, order = 150)
    public RString ryoshushoShichosonMei2;
    @ReportItem(name = "nofushoKanendo", length = 6, order = 151)
    public RString nofushoKanendo;
    @ReportItem(name = "nofushoNendo", length = 6, order = 152)
    public RString nofushoNendo;
    @ReportItem(name = "nofushoKanendobun", length = 9, order = 153)
    public RString nofushoKanendobun;
    @ReportItem(name = "nofushoKi", length = 2, order = 154)
    public RString nofushoKi;
    @ReportItem(name = "nofushoTsuki", length = 2, order = 155)
    public RString nofushoTsuki;
    @ReportItem(name = "nofushoOcr1", length = 6, order = 156)
    public RString nofushoOcr1;
    @ReportItem(name = "nofushoOcr2", length = 16, order = 157)
    public RString nofushoOcr2;
    @ReportItem(name = "nofushoOcr3", length = 17, order = 158)
    public RString nofushoOcr3;
    @ReportItem(name = "nofushoOcr4", length = 12, order = 159)
    public RString nofushoOcr4;
    @ReportItem(name = "nofushoNofugaku", length = 10, order = 160)
    public RString nofushoNofugaku;
    @ReportItem(name = "nofushoSofusakiName", order = 161)
    public RString nofushoSofusakiName;
    @ReportItem(name = "nofushoKakko1", length = 1, order = 162)
    public RString nofushoKakko1;
    @ReportItem(name = "nofushoHonninName1", order = 163)
    public RString nofushoHonninName1;
    @ReportItem(name = "nofushoKakko2", length = 1, order = 164)
    public RString nofushoKakko2;
    @ReportItem(name = "nofushoKakko3", length = 3, order = 165)
    public RString nofushoKakko3;
    @ReportItem(name = "nofushoTsuchishoNo", order = 166)
    public RString nofushoTsuchishoNo;
    @ReportItem(name = "nofushoSetaiCode", length = 15, order = 167)
    public RString nofushoSetaiCode;
    @ReportItem(name = "nofushohyojicodeName1", order = 168)
    public RString nofushohyojicodeName1;
    @ReportItem(name = "nofushohyojicode1", length = 20, order = 169)
    public RString nofushohyojicode1;
    @ReportItem(name = "nofushohyojicodeName2", order = 170)
    public RString nofushohyojicodeName2;
    @ReportItem(name = "nofushohyojicode2", length = 20, order = 171)
    public RString nofushohyojicode2;
    @ReportItem(name = "nofushohyojicodeName3", order = 172)
    public RString nofushohyojicodeName3;
    @ReportItem(name = "nofushohyojicode3", length = 20, order = 173)
    public RString nofushohyojicode3;
    @ReportItem(name = "nofushoNokigen", length = 11, order = 174)
    public RString nofushoNokigen;
    @ReportItem(name = "nofushoNofuin", length = 2, order = 175)
    public RString nofushoNofuin;
    @ReportItem(name = "nofushoRyoshuHizukein", length = 4, order = 176)
    public RString nofushoRyoshuHizukein;
    @ReportItem(name = "nofushoZuiji", length = 2, order = 177)
    public RString nofushoZuiji;
    @ReportItem(name = "nofushoShichosonMei", order = 178)
    public RString nofushoShichosonMei;
    @ReportItem(name = "denshiKoin", order = 179)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 180)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 181)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 182)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 183)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 184)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 185)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 186)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 187)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
