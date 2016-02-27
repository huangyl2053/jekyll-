package jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票　保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】連帳Coverの項目を定義するクラスです。
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "titleNendo", length = 4, order = 1)
    public RString titleNendo;
    @ReportItem(name = "HyojicodeName1", length = 8, order = 2)
    public RString hyojicodeName1;
    @ReportItem(name = "HyojicodeName2", length = 8, order = 3)
    public RString hyojicodeName2;
    @ReportItem(name = "HyojicodeName3", length = 8, order = 4)
    public RString hyojicodeName3;
    @ReportItem(name = "Hyojicode1", length = 12, order = 5)
    public RString hyojicode1;
    @ReportItem(name = "Hyojicode2", length = 12, order = 6)
    public RString hyojicode2;
    @ReportItem(name = "Hyojicode3", length = 12, order = 7)
    public RString hyojicode3;
    @ReportItem(name = "listList1_1", length = 4, order = 8)
    public RString listList1_1;
    @ReportItem(name = "keisanMeisaishoNendo", length = 4, order = 9)
    public RString keisanMeisaishoNendo;
    @ReportItem(name = "TsuchishoNo", order = 10)
    public RString tsuchishoNo;
    @ReportItem(name = "SetaiCode", length = 15, order = 11)
    public RString setaiCode;
    @ReportItem(name = "kaisanMeisaishoSetaiNushiName", order = 12)
    public RString kaisanMeisaishoSetaiNushiName;
    @ReportItem(name = "kaisanMeisaishoHihokenshaName", order = 13)
    public RString kaisanMeisaishoHihokenshaName;
    @ReportItem(name = "bankCodeTitle", length = 7, order = 14)
    public RString bankCodeTitle;
    @ReportItem(name = "kozaShuruiTitle", length = 2, order = 15)
    public RString kozaShuruiTitle;
    @ReportItem(name = "kozaNoTitle", length = 4, order = 16)
    public RString kozaNoTitle;
    @ReportItem(name = "kozaNo", length = 14, order = 17)
    public RString kozaNo;
    @ReportItem(name = "bankCode", length = 8, order = 18)
    public RString bankCode;
    @ReportItem(name = "kozaShurui", length = 3, order = 19)
    public RString kozaShurui;
    @ReportItem(name = "keisanMeisaishoTsuchishoNo", order = 20)
    public RString keisanMeisaishoTsuchishoNo;
    @ReportItem(name = "keisanMeisaishoSetaiCode", length = 15, order = 21)
    public RString keisanMeisaishoSetaiCode;
    @ReportItem(name = "bankNameTitle", length = 4, order = 22)
    public RString bankNameTitle;
    @ReportItem(name = "bankName", length = 19, order = 23)
    public RString bankName;
    @ReportItem(name = "keisanMeisaishoNendo1", length = 6, order = 24)
    public RString keisanMeisaishoNendo1;
    @ReportItem(name = "kozaMeigininTitle", length = 3, order = 25)
    public RString kozaMeigininTitle;
    @ReportItem(name = "kozaMeiginin", length = 15, order = 26)
    public RString kozaMeiginin;
    @ReportItem(name = "keisanMeisaishoGenmenGaku", length = 10, order = 27)
    public RString keisanMeisaishoGenmenGaku;
    @ReportItem(name = "keisanMeisaishoShotokuDankai", length = 5, order = 28)
    public RString keisanMeisaishoShotokuDankai;
    @ReportItem(name = "keisanMeisaishoNendo2", length = 6, order = 29)
    public RString keisanMeisaishoNendo2;
    @ReportItem(name = "kaisanMeisaishoTokuchoGokeiGaku", length = 10, order = 30)
    public RString kaisanMeisaishoTokuchoGokei;
    @ReportItem(name = "keisanMeisaishoKingaku1", length = 10, order = 31)
    public RString keisanMeisaishoKingaku1;
    @ReportItem(name = "ki1", length = 2, order = 32)
    public RString ki1;
    @ReportItem(name = "tsuki1", length = 2, order = 33)
    public RString tsuki1;
    @ReportItem(name = "nofuGaku1", length = 13, order = 34)
    public RString nofuGaku1;
    @ReportItem(name = "Nokigen1", length = 11, order = 35)
    public RString nokigen1;
    @ReportItem(name = "keisanMeisaishoYen1", length = 1, order = 36)
    public RString keisanMeisaishoYen1;
    @ReportItem(name = "keisanMeisaishoKomokuTitle2", length = 8, order = 37)
    public RString keisanMeisaishoKomokuTitle2;
    @ReportItem(name = "keisanMeisaishoNendo3", length = 6, order = 38)
    public RString keisanMeisaishoNendo3;
    @ReportItem(name = "keisanMeisaishoKiTitle1", length = 4, order = 39)
    public RString keisanMeisaishoKiTitle1;
    @ReportItem(name = "ki2", length = 2, order = 40)
    public RString ki2;
    @ReportItem(name = "tsuki2", length = 2, order = 41)
    public RString tsuki2;
    @ReportItem(name = "nofuGaku2", length = 13, order = 42)
    public RString nofuGaku2;
    @ReportItem(name = "Nokigen2", length = 11, order = 43)
    public RString nokigen2;
    @ReportItem(name = "keisanMeisaishoKiNofuGaku1", length = 10, order = 44)
    public RString keisanMeisaishoKiNofuGaku1;
    @ReportItem(name = "keisanMeisaishoKingaku2", length = 10, order = 45)
    public RString keisanMeisaishoKingaku2;
    @ReportItem(name = "keisanMeisaishoYen2", length = 1, order = 46)
    public RString keisanMeisaishoYen2;
    @ReportItem(name = "keisanMeisaishoKomokuTitle3", length = 8, order = 47)
    public RString keisanMeisaishoKomokuTitle3;
    @ReportItem(name = "noutsu-renban", length = 8, order = 48)
    public RString noutsu_renban;
    @ReportItem(name = "ki3", length = 2, order = 49)
    public RString ki3;
    @ReportItem(name = "tsuki3", length = 2, order = 50)
    public RString tsuki3;
    @ReportItem(name = "nofuGaku3", length = 13, order = 51)
    public RString nofuGaku3;
    @ReportItem(name = "Nokigen3", length = 11, order = 52)
    public RString nokigen3;
    @ReportItem(name = "keisanMeisaishoNendo4", length = 6, order = 53)
    public RString keisanMeisaishoNendo4;
    @ReportItem(name = "keisanMeisaishoKiTitle2", length = 4, order = 54)
    public RString keisanMeisaishoKiTitle2;
    @ReportItem(name = "ki4", length = 2, order = 55)
    public RString ki4;
    @ReportItem(name = "tsuki4", length = 2, order = 56)
    public RString tsuki4;
    @ReportItem(name = "nofuGaku4", length = 13, order = 57)
    public RString nofuGaku4;
    @ReportItem(name = "Nokigen4", length = 11, order = 58)
    public RString nokigen4;
    @ReportItem(name = "keisanMeisaishoKiNofuGaku2", length = 10, order = 59)
    public RString keisanMeisaishoKiNofuGaku2;
    @ReportItem(name = "keisanMeisaishoKingaku3", length = 10, order = 60)
    public RString keisanMeisaishoKingaku3;
    @ReportItem(name = "keisanMeisaishoYen3", length = 1, order = 61)
    public RString keisanMeisaishoYen3;
    @ReportItem(name = "keisanMeisaishoKomokuTitle4", length = 8, order = 62)
    public RString keisanMeisaishoKomokuTitle4;
    @ReportItem(name = "ki5", length = 2, order = 63)
    public RString ki5;
    @ReportItem(name = "tsuki5", length = 2, order = 64)
    public RString tsuki5;
    @ReportItem(name = "nofuGaku5", length = 13, order = 65)
    public RString nofuGaku5;
    @ReportItem(name = "Nokigen5", length = 11, order = 66)
    public RString nokigen5;
    @ReportItem(name = "keisanMeisaishoKarisanteiNendo", length = 6, order = 67)
    public RString keisanMeisaishoKarisanteiNendo;
    @ReportItem(name = "keisanMeisaishoKisu", length = 2, order = 68)
    public RString keisanMeisaishoKisu;
    @ReportItem(name = "keisanMeisaishoHokenryoGakuGokei", length = 15, order = 69)
    public RString keisanMeisaishoHokenryoGaku;
    @ReportItem(name = "ki6", length = 2, order = 70)
    public RString ki6;
    @ReportItem(name = "tsuki6", length = 2, order = 71)
    public RString tsuki6;
    @ReportItem(name = "nofuGaku6", length = 13, order = 72)
    public RString nofuGaku6;
    @ReportItem(name = "Nokigen6", length = 11, order = 73)
    public RString nokigen6;
    @ReportItem(name = "kikanSt", length = 11, order = 74)
    public RString kikanSt;
    @ReportItem(name = "kikanEd", length = 11, order = 75)
    public RString kikanEd;
    @ReportItem(name = "notsuShikibtsuBango", length = 12, order = 76)
    public RString notsuShikibtsuBango;
    @ReportItem(name = "keisanMeisaishoShikibtsuBango", length = 12, order = 77)
    public RString keisanMeisaishoShikibtsuBango;
    @ReportItem(name = "yubinNo", length = 8, order = 78)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 79)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 80)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 81)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 82)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 83)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 84)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 85)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 86)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 87)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 88)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 89)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 90)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 91)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 92)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 93)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 94)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 95)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 96)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 97)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 98)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 99)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 100)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 101)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 102)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight1", length = 1, order = 103)
    public RString kakkoRight1;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 104)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 105)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 106)
    public RString samaBun1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 107)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 108)
    public RString customerBarCode;
    @ReportItem(name = "kamokumei", order = 109)
    public RString kamokumei;
    @ReportItem(name = "ryoshushoNendo1", order = 110)
    public RString ryoshushoNendo1;
    @ReportItem(name = "nendoNenbun", order = 111)
    public RString nendoNenbun;
    @ReportItem(name = "kibetsu", order = 112)
    public RString kibetsu;
    @ReportItem(name = "ryoshushoNenbun1", order = 113)
    public RString ryoshushoNenbun1;
    @ReportItem(name = "gokeigaku", length = 15, order = 114)
    public RString gokeigaku;
    @ReportItem(name = "shunoKikanBango1", length = 5, order = 115)
    public RString shunoKikanBango1;
    @ReportItem(name = "nofuBango", length = 20, order = 116)
    public RString nofuBango;
    @ReportItem(name = "kakuninBango1", length = 5, order = 117)
    public RString kakuninBango1;
    @ReportItem(name = "nofuKubun1", length = 3, order = 118)
    public RString nofuKubun1;
    @ReportItem(name = "nokigenTitle", length = 12, order = 119)
    public RString nokigenTitle;
    @ReportItem(name = "ocrId1", length = 3, order = 120)
    public RString ocrId1;
//    @ReportItem(name = "tsuchishoNo", length = 20, order = 121)
//    public RString tsuchishoNo;
    @ReportItem(name = "nokigenYmd", length = 16, order = 122)
    public RString nokigenYmd;
    @ReportItem(name = "hakkoYmd", length = 16, order = 123)
    public RString hakkoYmd;
    @ReportItem(name = "honzei", length = 15, order = 124)
    public RString honzei;
    @ReportItem(name = "tokusokuTesuryo", length = 5, order = 125)
    public RString tokusokuTesuryo;
    @ReportItem(name = "ocr11", length = 39, order = 126)
    public RString ocr11;
    @ReportItem(name = "ocrCut1", length = 1, order = 127)
    public RString ocrCut1;
    @ReportItem(name = "entaikin", length = 15, order = 128)
    public RString entaikin;
    @ReportItem(name = "ocr21", length = 44, order = 129)
    public RString ocr21;
    @ReportItem(name = "shimei", order = 130)
    public RString shimei;
    @ReportItem(name = "biko11", length = 30, order = 131)
    public RString biko11;
    @ReportItem(name = "biko21", length = 30, order = 132)
    public RString biko21;
    @ReportItem(name = "gimushaShimei", order = 133)
    public RString gimushaShimei;
    @ReportItem(name = "barcodeCvsBarcode1", order = 134)
    public RString barcodeCvsBarcode1;
    @ReportItem(name = "cvsBarcodeNaiyo11", length = 33, order = 135)
    public RString cvsBarcodeNaiyo11;
    @ReportItem(name = "cvsBarcodeNaiyo21", length = 33, order = 136)
    public RString cvsBarcodeNaiyo21;
    @ReportItem(name = "cvsToriatsukaikigen1", length = 16, order = 137)
    public RString cvsToriatsukaikigen1;
    @ReportItem(name = "funyuFukanBango1", length = 12, order = 138)
    public RString funyuFukanBango1;
//    @ReportItem(name = "kamokumei", order = 139)
//    public RString kamokumei;
//    @ReportItem(name = "ryoshushoNendo2", order = 140)
//    public RString ryoshushoNendo2;
//    @ReportItem(name = "nendoNenbun", order = 141)
//    public RString nendoNenbun;
//    @ReportItem(name = "kibetsu", order = 142)
//    public RString kibetsu;
//    @ReportItem(name = "ryoshushoNenbun2", order = 143)
//    public RString ryoshushoNenbun2;
//    @ReportItem(name = "gokeigaku", length = 15, order = 144)
//    public RString gokeigaku;
//    @ReportItem(name = "shunoKikanBango2", length = 5, order = 145)
//    public RString shunoKikanBango2;
//    @ReportItem(name = "nofuBango", length = 20, order = 146)
//    public RString nofuBango;
//    @ReportItem(name = "kakuninBango2", length = 5, order = 147)
//    public RString kakuninBango2;
//    @ReportItem(name = "nofuKubun2", length = 3, order = 148)
//    public RString nofuKubun2;
//    @ReportItem(name = "nokigenTitle", length = 12, order = 149)
//    public RString nokigenTitle;
//    @ReportItem(name = "ocrId2", length = 3, order = 150)
//    public RString ocrId2;
//    @ReportItem(name = "tsuchishoNo", length = 20, order = 151)
//    public RString tsuchishoNo;
//    @ReportItem(name = "nokigenYmd", length = 16, order = 152)
//    public RString nokigenYmd;
//    @ReportItem(name = "hakkoYmd", length = 16, order = 153)
//    public RString hakkoYmd;
//    @ReportItem(name = "honzei", length = 15, order = 154)
//    public RString honzei;
//    @ReportItem(name = "tokusokuTesuryo", length = 5, order = 155)
//    public RString tokusokuTesuryo;
//    @ReportItem(name = "ocr12", length = 39, order = 156)
//    public RString ocr12;
//    @ReportItem(name = "ocrCut2", length = 1, order = 157)
//    public RString ocrCut2;
//    @ReportItem(name = "entaikin", length = 15, order = 158)
//    public RString entaikin;
//    @ReportItem(name = "ocr22", length = 44, order = 159)
//    public RString ocr22;
//    @ReportItem(name = "shimei", order = 160)
//    public RString shimei;
//    @ReportItem(name = "biko12", length = 30, order = 161)
//    public RString biko12;
//    @ReportItem(name = "biko22", length = 30, order = 162)
//    public RString biko22;
//    @ReportItem(name = "gimushaShimei", order = 163)
//    public RString gimushaShimei;
    @ReportItem(name = "barcodeCvsBarcode2", order = 164)
    public RString barcodeCvsBarcode2;
    @ReportItem(name = "cvsBarcodeNaiyo12", length = 33, order = 165)
    public RString cvsBarcodeNaiyo12;
    @ReportItem(name = "cvsBarcodeNaiyo22", length = 33, order = 166)
    public RString cvsBarcodeNaiyo22;
    @ReportItem(name = "cvsToriatsukaikigen2", length = 16, order = 167)
    public RString cvsToriatsukaikigen2;
    @ReportItem(name = "funyuFukanBango2", length = 12, order = 168)
    public RString funyuFukanBango2;
    @ReportItem(name = "denshiKoin", order = 169)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 170)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 171)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 172)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 173)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 174)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 175)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 176)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 177)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
