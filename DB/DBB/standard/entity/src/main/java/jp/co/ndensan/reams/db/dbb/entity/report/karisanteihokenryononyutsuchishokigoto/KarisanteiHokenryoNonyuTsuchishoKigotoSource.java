package jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】Sourceです。
 *
 * @reamsid_L DBB-9110-020 wangjie2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiHokenryoNonyuTsuchishoKigotoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "titleNendo", length = 4, order = 1)
    public RString titleNendo;
    @ReportItem(name = "HyojicodeName1", length = 6, order = 2)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojiKomoku11", length = 8, order = 3)
    public RString hyojiKomoku11;
    @ReportItem(name = "hyojiKomoku21", length = 8, order = 4)
    public RString hyojiKomoku21;
    @ReportItem(name = "HyojicodeName2", length = 6, order = 5)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojiKomoku31", length = 8, order = 6)
    public RString hyojiKomoku31;
    @ReportItem(name = "HyojicodeName3", length = 6, order = 7)
    public RString hyojicodeName3;
    @ReportItem(name = "ki1", length = 2, order = 8)
    public RString ki1;
    @ReportItem(name = "nokiKaishi1", length = 11, order = 9)
    public RString nokiKaishi1;
    @ReportItem(name = "Hyojicode1", length = 15, order = 10)
    public RString hyojicode1;
    @ReportItem(name = "Hyojicode2", length = 15, order = 11)
    public RString hyojicode2;
    @ReportItem(name = "Hyojicode3", length = 15, order = 12)
    public RString hyojicode3;
    @ReportItem(name = "tsuki1", length = 2, order = 13)
    public RString tsuki1;
    @ReportItem(name = "nokiShuryo1", length = 11, order = 14)
    public RString nokiShuryo1;
    @ReportItem(name = "tsuchishoNo", order = 15)
    public RString tsuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 16)
    public RString setaiCode;
    @ReportItem(name = "ki2", length = 2, order = 17)
    public RString ki2;
    @ReportItem(name = "nokiKaishi2", length = 11, order = 18)
    public RString nokiKaishi2;
    @ReportItem(name = "hihokenshaName", order = 19)
    public RString hihokenshaName;
    @ReportItem(name = "tsuki2", length = 2, order = 20)
    public RString tsuki2;
    @ReportItem(name = "nokiShuryo2", length = 11, order = 21)
    public RString nokiShuryo2;
    @ReportItem(name = "ki3", length = 2, order = 22)
    public RString ki3;
    @ReportItem(name = "nokiKaishi3", length = 11, order = 23)
    public RString nokiKaishi3;
    @ReportItem(name = "tsuki3", length = 2, order = 24)
    public RString tsuki3;
    @ReportItem(name = "nokiShuryo3", length = 11, order = 25)
    public RString nokiShuryo3;
    @ReportItem(name = "setaiNushiName", order = 26)
    public RString setaiNushiName;
    @ReportItem(name = "ki4", length = 2, order = 27)
    public RString ki4;
    @ReportItem(name = "nokiKaishi4", length = 11, order = 28)
    public RString nokiKaishi4;
    @ReportItem(name = "tsuki4", length = 2, order = 29)
    public RString tsuki4;
    @ReportItem(name = "nendo1", length = 4, order = 30)
    public RString nendo1;
    @ReportItem(name = "nokiShuryo4", length = 11, order = 31)
    public RString nokiShuryo4;
    @ReportItem(name = "hokenryoGaku", length = 10, order = 32)
    public RString hokenryoGaku;
    @ReportItem(name = "ki5", length = 2, order = 33)
    public RString ki5;
    @ReportItem(name = "nokiKaishi5", length = 11, order = 34)
    public RString nokiKaishi5;
    @ReportItem(name = "nendo2", length = 4, order = 35)
    public RString nendo2;
    @ReportItem(name = "shotokuDankai", length = 5, order = 36)
    public RString shotokuDankai;
    @ReportItem(name = "tsuki5", length = 2, order = 37)
    public RString tsuki5;
    @ReportItem(name = "nokiShuryo5", length = 11, order = 38)
    public RString nokiShuryo5;
    @ReportItem(name = "nendo3", length = 6, order = 39)
    public RString nendo3;
    @ReportItem(name = "ki6", length = 2, order = 40)
    public RString ki6;
    @ReportItem(name = "yen1", length = 1, order = 41)
    public RString yen1;
    @ReportItem(name = "nokiKaishi6", length = 11, order = 42)
    public RString nokiKaishi6;
    @ReportItem(name = "santeiKisoKingaku1", length = 10, order = 43)
    public RString santeiKisoKingaku1;
    @ReportItem(name = "komokuTitle1", length = 8, order = 44)
    public RString komokuTitle1;
    @ReportItem(name = "tsuki6", length = 2, order = 45)
    public RString tsuki6;
    @ReportItem(name = "nokiShuryo6", length = 11, order = 46)
    public RString nokiShuryo6;
    @ReportItem(name = "nendo4", length = 6, order = 47)
    public RString nendo4;
    @ReportItem(name = "yen2", length = 1, order = 48)
    public RString yen2;
    @ReportItem(name = "santeiKisoKingaku2", length = 10, order = 49)
    public RString santeiKisoKingaku2;
    @ReportItem(name = "komokuTitle2", length = 8, order = 50)
    public RString komokuTitle2;
    @ReportItem(name = "bankCode", length = 7, order = 51)
    public RString bankCode;
    @ReportItem(name = "nendo5", length = 6, order = 52)
    public RString nendo5;
    @ReportItem(name = "yen3", length = 1, order = 53)
    public RString yen3;
    @ReportItem(name = "santeiKisoKingaku3", length = 10, order = 54)
    public RString santeiKisoKingaku3;
    @ReportItem(name = "komokuTitle3", length = 8, order = 55)
    public RString komokuTitle3;
    @ReportItem(name = "kozaMeigi", order = 56)
    public RString kozaMeigi;
    @ReportItem(name = "santeiKisoKi", length = 2, order = 57)
    public RString santeiKisoKi;
    @ReportItem(name = "santeiKisoGenmenGaku", length = 10, order = 58)
    public RString santeiKisoGenmenGaku;
    @ReportItem(name = "kozaShurui", length = 3, order = 59)
    public RString kozaShurui;
    @ReportItem(name = "santeiKisoKariGokeiGaku", length = 10, order = 60)
    public RString santeiKisoKariGokeiGaku;
    @ReportItem(name = "kozaNo", length = 14, order = 61)
    public RString kozaNo;
    @ReportItem(name = "santeiKisoKiTitle1", length = 4, order = 62)
    public RString santeiKisoKiTitle1;
    @ReportItem(name = "santeiKisoZanteikiHokenryoGaku1", length = 10, order = 63)
    public RString santeiKisoZanteikiHokenryoGaku1;
    @ReportItem(name = "bankName", order = 64)
    public RString bankName;
    @ReportItem(name = "santeiKisoKiTitle2", length = 4, order = 65)
    public RString santeiKisoKiTitle2;
    @ReportItem(name = "santeiKisoZanteikiHokenryoGaku2", length = 10, order = 66)
    public RString santeiKisoZanteikiHokenryoGaku2;
    @ReportItem(name = "renban", length = 10, order = 67)
    public RString renban;
    @ReportItem(name = "hokenshaName", length = 10, order = 68)
    public RString hokenshaName;
    @ReportItem(name = "yubinNo1", length = 8, order = 69)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 70)
    public RString gyoseiku1;
    @ReportItem(name = "jusho3", length = 20, order = 71)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 72)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 73)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 74)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 75)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 76)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 77)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 78)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 79)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 80)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 81)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 82)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 83)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 84)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 85)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 86)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 87)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 88)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 89)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 90)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 91)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 92)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 93)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 94)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 95)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 96)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 97)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 98)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 99)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 100)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 101)
    public RString hakkoYMD;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 102)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 103)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 104)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 105)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 106)
    public RString koinShoryaku;
    @ReportItem(name = "ryoshushoKanendo", length = 6, order = 107)
    public RString ryoshushoKanendo;
    @ReportItem(name = "ryoshushoNendo", length = 6, order = 108)
    public RString ryoshushoNendo;
    @ReportItem(name = "ryoshushoKanendobun", length = 9, order = 109)
    public RString ryoshushoKanendobun;
    @ReportItem(name = "ryoshushoKi", length = 2, order = 110)
    public RString ryoshushoKi;
    @ReportItem(name = "ryoshushoTsuki", length = 2, order = 111)
    public RString ryoshushoTsuki;
    @ReportItem(name = "ryoshushoYubinNo", length = 8, order = 112)
    public RString ryoshushoYubinNo;
    @ReportItem(name = "ryoshushoGyoseikuName", length = 14, order = 113)
    public RString ryoshushoGyoseikuName;
    @ReportItem(name = "ryoshushoJusho", order = 114)
    public RString ryoshushoJusho;
    @ReportItem(name = "ryoshushoKatagaki", order = 115)
    public RString ryoshushoKatagaki;
    @ReportItem(name = "ryoshushoSofusakiName", order = 116)
    public RString ryoshushoSofusakiName;
    @ReportItem(name = "ryoshushoKakko1", length = 1, order = 117)
    public RString ryoshushoKakko1;
    @ReportItem(name = "ryoshushoHonninName", order = 118)
    public RString ryoshushoHonninName;
    @ReportItem(name = "ryoshushoKakko2", length = 1, order = 119)
    public RString ryoshushoKakko2;
    @ReportItem(name = "ryoshushoKakko3", length = 3, order = 120)
    public RString ryoshushoKakko3;
    @ReportItem(name = "ryoshushoTsuchishoNo", order = 121)
    public RString ryoshushoTsuchishoNo;
    @ReportItem(name = "ryoshushoSetaiCode", length = 15, order = 122)
    public RString ryoshushoSetaiCode;
    @ReportItem(name = "ryoshushohyojicodeName1", order = 123)
    public RString ryoshushohyojicodeName1;
    @ReportItem(name = "ryoshushohyojicode1", length = 20, order = 124)
    public RString ryoshushohyojicode1;
    @ReportItem(name = "ryoshushohyojicodeName2", order = 125)
    public RString ryoshushohyojicodeName2;
    @ReportItem(name = "ryoshushohyojicode2", length = 20, order = 126)
    public RString ryoshushohyojicode2;
    @ReportItem(name = "ryoshushohyojicodeName3", order = 127)
    public RString ryoshushohyojicodeName3;
    @ReportItem(name = "ryoshushoHyojicode3", length = 20, order = 128)
    public RString ryoshushoHyojicode3;
    @ReportItem(name = "ryoshushoNokigen", length = 11, order = 129)
    public RString ryoshushoNokigen;
    @ReportItem(name = "ryoshushoNofugaku", length = 10, order = 130)
    public RString ryoshushoNofugaku;
    @ReportItem(name = "ryoshushoNofuin", length = 2, order = 131)
    public RString ryoshushoNofuin;
    @ReportItem(name = "ryoshushoRyoshuHizukein", length = 4, order = 132)
    public RString ryoshushoRyoshuHizukein;
    @ReportItem(name = "ryoshushoZuiji", length = 2, order = 133)
    public RString ryoshushoZuiji;
    @ReportItem(name = "ryoshushoRenban", length = 10, order = 134)
    public RString ryoshushoRenban;
    @ReportItem(name = "ryoshushoShichosonMei1", length = 10, order = 135)
    public RString ryoshushoShichosonMei1;
    @ReportItem(name = "ryoshushoShichosonMei2", length = 10, order = 136)
    public RString ryoshushoShichosonMei2;
    @ReportItem(name = "nofushoKanendo1", length = 6, order = 137)
    public RString nofushoKanendo1;
    @ReportItem(name = "nofushoNendo1", length = 6, order = 138)
    public RString nofushoNendo1;
    @ReportItem(name = "nofushoKanendobun1", length = 9, order = 139)
    public RString nofushoKanendobun1;
    @ReportItem(name = "nofushoTsuki1", length = 2, order = 140)
    public RString nofushoTsuki1;
    @ReportItem(name = "nofushoKi1", length = 2, order = 141)
    public RString nofushoKi1;
    @ReportItem(name = "nofushoOcr11", length = 6, order = 142)
    public RString nofushoOcr11;
    @ReportItem(name = "nofushoOcr21", length = 16, order = 143)
    public RString nofushoOcr21;
    @ReportItem(name = "nofushoOcr31", length = 17, order = 144)
    public RString nofushoOcr31;
    @ReportItem(name = "nofushoOcr41", length = 12, order = 145)
    public RString nofushoOcr41;
    @ReportItem(name = "nofushoNofugaku1", length = 10, order = 146)
    public RString nofushoNofugaku1;
    @ReportItem(name = "nofushoSofusakiName1", order = 147)
    public RString nofushoSofusakiName1;
    @ReportItem(name = "nofushoHonninName1", order = 148)
    public RString nofushoHonninName1;
    @ReportItem(name = "nofushoKakko11", length = 1, order = 149)
    public RString nofushoKakko11;
    @ReportItem(name = "nofushoKakko21", length = 1, order = 150)
    public RString nofushoKakko21;
    @ReportItem(name = "nofushoKakko31", length = 3, order = 151)
    public RString nofushoKakko31;
    @ReportItem(name = "nofushoTsuchishoNo1", order = 152)
    public RString nofushoTsuchishoNo1;
    @ReportItem(name = "nofushoSetaiCode1", length = 15, order = 153)
    public RString nofushoSetaiCode1;
    @ReportItem(name = "nofushohyojicodeName11", order = 154)
    public RString nofushohyojicodeName11;
    @ReportItem(name = "nofushohyojicode11", length = 20, order = 155)
    public RString nofushohyojicode11;
    @ReportItem(name = "nofushohyojicodeName21", order = 156)
    public RString nofushohyojicodeName21;
    @ReportItem(name = "nofushohyojicode21", length = 20, order = 157)
    public RString nofushohyojicode21;
    @ReportItem(name = "nofushohyojicodeName31", order = 158)
    public RString nofushohyojicodeName31;
    @ReportItem(name = "nofushohyojicode31", length = 20, order = 159)
    public RString nofushohyojicode31;
    @ReportItem(name = "nofushoNokigen1", length = 11, order = 160)
    public RString nofushoNokigen1;
    @ReportItem(name = "nofushoNofuin1", length = 2, order = 161)
    public RString nofushoNofuin1;
    @ReportItem(name = "nofushoRyoshuHizukein1", length = 4, order = 162)
    public RString nofushoRyoshuHizukein1;
    @ReportItem(name = "nofushoZuiji1", length = 2, order = 163)
    public RString nofushoZuiji1;
    @ReportItem(name = "nofushoShichosonMei11", order = 164)
    public RString nofushoShichosonMei11;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
