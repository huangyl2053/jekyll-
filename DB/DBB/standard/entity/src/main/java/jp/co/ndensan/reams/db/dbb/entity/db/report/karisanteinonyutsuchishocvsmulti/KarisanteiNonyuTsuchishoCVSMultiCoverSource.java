package jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票　保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】Coverの項目を定義するクラスです。
 */
public class KarisanteiNonyuTsuchishoCVSMultiCoverSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "listList1_1", length = 2, order = 1)
    public RString listList1_1;
    @ReportItem(name = "HyojicodeName1", order = 2)
    public RString hyojicodeName1;
    @ReportItem(name = "HyojicodeName2", order = 3)
    public RString hyojicodeName2;
    @ReportItem(name = "HyojicodeName3", order = 4)
    public RString hyojicodeName3;
    @ReportItem(name = "titleNendo", length = 4, order = 5)
    public RString titleNendo;
    @ReportItem(name = "Hyojicode1", length = 12, order = 6)
    public RString hyojicode1;
    @ReportItem(name = "Hyojicode2", length = 12, order = 7)
    public RString hyojicode2;
    @ReportItem(name = "Hyojicode3", length = 12, order = 8)
    public RString hyojicode3;
    @ReportItem(name = "SetaiCode", length = 15, order = 9)
    public RString setaiCode;
    @ReportItem(name = "TsuchishoNo", order = 10)
    public RString tsuchishoNo;
    @ReportItem(name = "bankCodeTitle", length = 7, order = 11)
    public RString bankCodeTitle;
    @ReportItem(name = "kozaShuruiTitle", length = 2, order = 12)
    public RString kozaShuruiTitle;
    @ReportItem(name = "kozaNoTitle", length = 4, order = 13)
    public RString kozaNoTitle;
    @ReportItem(name = "bankCode", length = 8, order = 14)
    public RString bankCode;
    @ReportItem(name = "kozaShurui", length = 3, order = 15)
    public RString kozaShurui;
    @ReportItem(name = "kozaNo", length = 14, order = 16)
    public RString kozaNo;
    @ReportItem(name = "bankNameTitle", length = 4, order = 17)
    public RString bankNameTitle;
    @ReportItem(name = "bankName", length = 19, order = 18)
    public RString bankName;
    @ReportItem(name = "kozaMeigininTitle", length = 3, order = 19)
    public RString kozaMeigininTitle;
    @ReportItem(name = "kozaMeiginin", length = 15, order = 20)
    public RString kozaMeiginin;
    @ReportItem(name = "ki1", length = 2, order = 21)
    public RString ki1;
    @ReportItem(name = "tsuki1", length = 2, order = 22)
    public RString tsuki1;
    @ReportItem(name = "nofuGaku1", length = 13, order = 23)
    public RString nofuGaku1;
    @ReportItem(name = "Nokigen1", length = 11, order = 24)
    public RString nokigen1;
    @ReportItem(name = "ki2", length = 2, order = 25)
    public RString ki2;
    @ReportItem(name = "tsuki2", length = 2, order = 26)
    public RString tsuki2;
    @ReportItem(name = "nofuGaku2", length = 13, order = 27)
    public RString nofuGaku2;
    @ReportItem(name = "Nokigen2", length = 11, order = 28)
    public RString nokigen2;
    @ReportItem(name = "noutsu-renban", length = 8, order = 29)
    public RString noutsu_renban;
    @ReportItem(name = "nofuGaku3", length = 13, order = 30)
    public RString nofuGaku3;
    @ReportItem(name = "Nokigen3", length = 11, order = 31)
    public RString nokigen3;
    @ReportItem(name = "ki3", length = 2, order = 32)
    public RString ki3;
    @ReportItem(name = "tsuki3", length = 2, order = 33)
    public RString tsuki3;
    @ReportItem(name = "nofuGaku4", length = 13, order = 34)
    public RString nofuGaku4;
    @ReportItem(name = "Nokigen4", length = 11, order = 35)
    public RString nokigen4;
    @ReportItem(name = "ki4", length = 2, order = 36)
    public RString ki4;
    @ReportItem(name = "tsuki4", length = 2, order = 37)
    public RString tsuki4;
    @ReportItem(name = "nofuGaku5", length = 13, order = 38)
    public RString nofuGaku5;
    @ReportItem(name = "Nokigen5", length = 11, order = 39)
    public RString nokigen5;
    @ReportItem(name = "ki5", length = 2, order = 40)
    public RString ki5;
    @ReportItem(name = "tsuki5", length = 2, order = 41)
    public RString tsuki5;
    @ReportItem(name = "nofuGaku6", length = 13, order = 42)
    public RString nofuGaku6;
    @ReportItem(name = "Nokigen6", length = 11, order = 43)
    public RString nokigen6;
    @ReportItem(name = "ki6", length = 2, order = 44)
    public RString ki6;
    @ReportItem(name = "tsuki6", length = 2, order = 45)
    public RString tsuki6;
    @ReportItem(name = "notsuRenban1", length = 10, order = 46)
    public RString notsuRenban1;
    @ReportItem(name = "pageCount1", length = 10, order = 47)
    public RString pageCount1;
    @ReportItem(name = "keisanMeisaishoNendo", length = 4, order = 48)
    public RString keisanMeisaishoNendo;
    @ReportItem(name = "kaisanMeisaishoHihokenshaName", order = 49)
    public RString kaisanMeisaishoHihokenshaName;
    @ReportItem(name = "kaisanMeisaishoSetaiNushiName", order = 50)
    public RString kaisanMeisaishoSetaiNushiName;
    @ReportItem(name = "keisanMeisaishoSetaiCode", length = 15, order = 51)
    public RString keisanMeisaishoSetaiCode;
    @ReportItem(name = "keisanMeisaishoTsuchishoNo", order = 52)
    public RString keisanMeisaishoTsuchishoNo;
    @ReportItem(name = "keisanMeisaishoNendo1", length = 6, order = 53)
    public RString keisanMeisaishoNendo1;
    @ReportItem(name = "keisanMeisaishoShotokuDankai", length = 5, order = 54)
    public RString keisanMeisaishoShotokuDankai;
    @ReportItem(name = "keisanMeisaishoGenmenGaku", length = 10, order = 55)
    public RString keisanMeisaishoGenmenGaku;
    @ReportItem(name = "keisanMeisaishoNendo2", length = 6, order = 56)
    public RString keisanMeisaishoNendo2;
    @ReportItem(name = "keisanMeisaishoKingaku1", length = 10, order = 57)
    public RString keisanMeisaishoKingaku1;
    @ReportItem(name = "kaisanMeisaishoTokuchoGokeiGaku", length = 10, order = 58)
    public RString kaisanMeisaishoTokuchoGokei;
    @ReportItem(name = "keisanMeisaishoKomokuTitle2", length = 8, order = 59)
    public RString keisanMeisaishoKomokuTitle2;
    @ReportItem(name = "keisanMeisaishoYen1", length = 1, order = 60)
    public RString keisanMeisaishoYen1;
    @ReportItem(name = "keisanMeisaishoNendo3", length = 6, order = 61)
    public RString keisanMeisaishoNendo3;
    @ReportItem(name = "keisanMeisaishoKiTitle1", length = 4, order = 62)
    public RString keisanMeisaishoKiTitle1;
    @ReportItem(name = "kaisanMeisaishoKingaku2", length = 10, order = 63)
    public RString kaisanMeisaishoKingaku2;
    @ReportItem(name = "keisanMeisaishoKiNofuGaku1", length = 10, order = 64)
    public RString keisanMeisaishoKiNofuGaku1;
    @ReportItem(name = "keisanMeisaishoKomokuTitle3", length = 8, order = 65)
    public RString keisanMeisaishoKomokuTitle3;
    @ReportItem(name = "keisanMeisaishoYen2", length = 1, order = 66)
    public RString keisanMeisaishoYen2;
    @ReportItem(name = "keisanMeisaishoNendo4", length = 6, order = 67)
    public RString keisanMeisaishoNendo4;
    @ReportItem(name = "keisanMeisaishoKiTitle2", length = 4, order = 68)
    public RString keisanMeisaishoKiTitle2;
    @ReportItem(name = "keisanMeisaishoKingaku3", length = 10, order = 69)
    public RString keisanMeisaishoKingaku3;
    @ReportItem(name = "keisanMeisaishoKiNofuGaku2", length = 10, order = 70)
    public RString keisanMeisaishoKiNofuGaku2;
    @ReportItem(name = "keisanMeisaishoKomokuTitle4", length = 8, order = 71)
    public RString keisanMeisaishoKomokuTitle4;
    @ReportItem(name = "keisanMeisaishoYen3", length = 1, order = 72)
    public RString keisanMeisaishoYen3;
    @ReportItem(name = "keisanMeisaishoKarisanteiNendo", length = 6, order = 73)
    public RString keisanMeisaishoKarisanteiNendo;
    @ReportItem(name = "keisanMeisaishoKisu", length = 2, order = 74)
    public RString keisanMeisaishoKisu;
    @ReportItem(name = "keisanMeisaishoHokenryoGakuGokei", length = 15, order = 75)
    public RString keisanMeisaishoHokenryoGaku;
    @ReportItem(name = "notsuRenban2", length = 10, order = 76)
    public RString notsuRenban2;
    @ReportItem(name = "pageCount2", length = 10, order = 77)
    public RString pageCount2;
    @ReportItem(name = "renban", length = 10, order = 78)
    public RString renban;
    @ReportItem(name = "hokenshaName", length = 10, order = 79)
    public RString hokenshaName;
    @ReportItem(name = "notsuRenban3", length = 10, order = 80)
    public RString notsuRenban3;
    @ReportItem(name = "pageCount3", length = 10, order = 81)
    public RString pageCount3;
    @ReportItem(name = "denshiKoin", order = 82)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 83)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 84)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 85)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 86)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 87)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 88)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 89)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 90)
    public RString koinShoryaku;
    @ReportItem(name = "kamokumei", order = 91)
    public RString kamokumei;
    @ReportItem(name = "ryoshushoNendo", order = 92)
    public RString ryoshushoNendo;
    @ReportItem(name = "nendoNenbun", order = 93)
    public RString nendoNenbun;
    @ReportItem(name = "kibetsu", order = 94)
    public RString kibetsu;
    @ReportItem(name = "ryoshushoNenbun", order = 95)
    public RString ryoshushoNenbun;
    @ReportItem(name = "gokeigaku", length = 15, order = 96)
    public RString gokeigaku;
    @ReportItem(name = "shunoKikanBango", length = 5, order = 97)
    public RString shunoKikanBango;
    @ReportItem(name = "nofuBango", length = 20, order = 98)
    public RString nofuBango;
    @ReportItem(name = "kakuninBango", length = 5, order = 99)
    public RString kakuninBango;
    @ReportItem(name = "nofuKubun", length = 3, order = 100)
    public RString nofuKubun;
    @ReportItem(name = "nokigenTitle", length = 12, order = 101)
    public RString nokigenTitle;
    @ReportItem(name = "ocrId", length = 3, order = 102)
    public RString ocrId;
//    @ReportItem(name = "tsuchishoNo", length = 20, order = 103)
//    public RString tsuchishoNo;
    @ReportItem(name = "nokigenYmd", length = 16, order = 104)
    public RString nokigenYmd;
    @ReportItem(name = "hakkoYmd", length = 16, order = 105)
    public RString hakkoYmd;
    @ReportItem(name = "honzei", length = 15, order = 106)
    public RString honzei;
    @ReportItem(name = "tokusokuTesuryo", length = 5, order = 107)
    public RString tokusokuTesuryo;
    @ReportItem(name = "ocr1", length = 39, order = 108)
    public RString ocr1;
    @ReportItem(name = "ocrCut", length = 1, order = 109)
    public RString ocrCut;
    @ReportItem(name = "entaikin", length = 15, order = 110)
    public RString entaikin;
    @ReportItem(name = "ocr2", length = 44, order = 111)
    public RString ocr2;
    @ReportItem(name = "shimei", order = 112)
    public RString shimei;
    @ReportItem(name = "biko1", length = 30, order = 113)
    public RString biko1;
    @ReportItem(name = "biko2", length = 30, order = 114)
    public RString biko2;
    @ReportItem(name = "gimushaShimei", order = 115)
    public RString gimushaShimei;
    @ReportItem(name = "barcodeCvsBarcode", order = 116)
    public RString barcodeCvsBarcode;
    @ReportItem(name = "cvsBarcodeNaiyo1", length = 33, order = 117)
    public RString cvsBarcodeNaiyo1;
    @ReportItem(name = "cvsBarcodeNaiyo2", length = 33, order = 118)
    public RString cvsBarcodeNaiyo2;
    @ReportItem(name = "cvsToriatsukaikigen", length = 16, order = 119)
    public RString cvsToriatsukaikigen;
    @ReportItem(name = "funyuFukanBango", length = 12, order = 120)
    public RString funyuFukanBango;
    @ReportItem(name = "yubinNo", length = 8, order = 121)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 122)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 123)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 124)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 125)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 126)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 127)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 128)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 129)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 130)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 131)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 132)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 133)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 134)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 135)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 136)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 137)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 138)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 139)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 140)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 141)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 142)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 143)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 144)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 145)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 146)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 147)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 148)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 149)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 150)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 151)
    public RString customerBarCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
