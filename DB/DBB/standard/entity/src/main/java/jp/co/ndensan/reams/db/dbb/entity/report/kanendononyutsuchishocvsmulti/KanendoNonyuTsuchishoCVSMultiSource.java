/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvsmulti;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】の項目を定義するクラスです
 *
 * @reamsid_L DBB-9110-170 huangh
 */
public class KanendoNonyuTsuchishoCVSMultiSource implements IReportSource {

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
    @ReportItem(name = "titleNendoBun", length = 9, order = 9)
    public RString titleNendoBun;
    @ReportItem(name = "TsuchishoNo", order = 10)
    public RString tsuchishoNo;
    @ReportItem(name = "SetaiCode", length = 15, order = 11)
    public RString setaiCode;
    @ReportItem(name = "bankCodeTitle", length = 7, order = 12)
    public RString bankCodeTitle;
    @ReportItem(name = "kozaShuruiTitle", length = 2, order = 13)
    public RString kozaShuruiTitle;
    @ReportItem(name = "kozaNoTitle", length = 4, order = 14)
    public RString kozaNoTitle;
    @ReportItem(name = "bankCode", length = 8, order = 15)
    public RString bankCode;
    @ReportItem(name = "kozaShurui", length = 3, order = 16)
    public RString kozaShurui;
    @ReportItem(name = "kozaNo", length = 14, order = 17)
    public RString kozaNo;
    @ReportItem(name = "bankNameTitle", length = 4, order = 18)
    public RString bankNameTitle;
    @ReportItem(name = "bankName", length = 19, order = 19)
    public RString bankName;
    @ReportItem(name = "kozaMeigininTitle", length = 3, order = 20)
    public RString kozaMeigininTitle;
    @ReportItem(name = "kozaMeiginin", length = 15, order = 21)
    public RString kozaMeiginin;
    @ReportItem(name = "ki1", length = 2, order = 22)
    public RString ki1;
    @ReportItem(name = "tsuki1", length = 2, order = 23)
    public RString tsuki1;
    @ReportItem(name = "nofuGaku1", length = 13, order = 24)
    public RString nofuGaku1;
    @ReportItem(name = "Nokigen1", length = 11, order = 25)
    public RString nokigen1;
    @ReportItem(name = "ki2", length = 2, order = 26)
    public RString ki2;
    @ReportItem(name = "tsuki2", length = 2, order = 27)
    public RString tsuki2;
    @ReportItem(name = "nofuGaku2", length = 13, order = 28)
    public RString nofuGaku2;
    @ReportItem(name = "Nokigen2", length = 11, order = 29)
    public RString nokigen2;
    @ReportItem(name = "notsuRenban", length = 8, order = 30)
    public RString notsuRenban;
    @ReportItem(name = "ki3", length = 2, order = 31)
    public RString ki3;
    @ReportItem(name = "tsuki3", length = 2, order = 32)
    public RString tsuki3;
    @ReportItem(name = "nofuGaku3", length = 13, order = 33)
    public RString nofuGaku3;
    @ReportItem(name = "Nokigen3", length = 11, order = 34)
    public RString nokigen3;
    @ReportItem(name = "ki4", length = 2, order = 35)
    public RString ki4;
    @ReportItem(name = "tsuki4", length = 2, order = 36)
    public RString tsuki4;
    @ReportItem(name = "nofuGaku4", length = 13, order = 37)
    public RString nofuGaku4;
    @ReportItem(name = "Nokigen4", length = 11, order = 38)
    public RString nokigen4;
    @ReportItem(name = "ki5", length = 2, order = 39)
    public RString ki5;
    @ReportItem(name = "tsuki5", length = 2, order = 40)
    public RString tsuki5;
    @ReportItem(name = "nofuGaku5", length = 13, order = 41)
    public RString nofuGaku5;
    @ReportItem(name = "Nokigen5", length = 11, order = 42)
    public RString nokigen5;
    @ReportItem(name = "ki6", length = 2, order = 43)
    public RString ki6;
    @ReportItem(name = "tsuki6", length = 2, order = 44)
    public RString tsuki6;
    @ReportItem(name = "nofuGaku6", length = 13, order = 45)
    public RString nofuGaku6;
    @ReportItem(name = "Nokigen6", length = 11, order = 46)
    public RString nokigen6;
    @ReportItem(name = "ki7", length = 2, order = 47)
    public RString ki7;
    @ReportItem(name = "tsuki7", length = 2, order = 48)
    public RString tsuki7;
    @ReportItem(name = "nofuGaku7", length = 13, order = 49)
    public RString nofuGaku7;
    @ReportItem(name = "Nokigen7", length = 11, order = 50)
    public RString nokigen7;
    @ReportItem(name = "ki8", length = 2, order = 51)
    public RString ki8;
    @ReportItem(name = "tsuki8", length = 2, order = 52)
    public RString tsuki8;
    @ReportItem(name = "nofuGaku8", length = 13, order = 53)
    public RString nofuGaku8;
    @ReportItem(name = "Nokigen8", length = 11, order = 54)
    public RString nokigen8;
    @ReportItem(name = "ki9", length = 2, order = 55)
    public RString ki9;
    @ReportItem(name = "tsuki9", length = 2, order = 56)
    public RString tsuki9;
    @ReportItem(name = "nofuGaku9", length = 13, order = 57)
    public RString nofuGaku9;
    @ReportItem(name = "Nokigen9", length = 11, order = 58)
    public RString nokigen9;
    @ReportItem(name = "ki10", length = 2, order = 59)
    public RString ki10;
    @ReportItem(name = "tsuki10", length = 2, order = 60)
    public RString tsuki10;
    @ReportItem(name = "nofuGaku10", length = 13, order = 61)
    public RString nofuGaku10;
    @ReportItem(name = "Nokigen10", length = 11, order = 62)
    public RString nokigen10;
    @ReportItem(name = "notsuRenban1", length = 10, order = 63)
    public RString notsuRenban1;
    @ReportItem(name = "pageCount1", length = 10, order = 64)
    public RString pageCount1;
    @ReportItem(name = "keisanMeisaishoNendo", length = 4, order = 65)
    public RString keisanMeisaishoNendo;
    @ReportItem(name = "keisanMeisaishoNendoBun", length = 9, order = 66)
    public RString keisanMeisaishoNendoBun;
    @ReportItem(name = "kaisanMeisaishoHihokenshaName1", order = 67)
    public RString kaisanMeisaishoHihokenshaName1;
    @ReportItem(name = "kaisanMeisaishoHihokenshaName", order = 68)
    public RString kaisanMeisaishoHihokenshaName;
    @ReportItem(name = "keisanMeisaishoTsuchishoNo", order = 69)
    public RString keisanMeisaishoTsuchishoNo;
    @ReportItem(name = "keisanMeisaishoSetaiCode", length = 15, order = 70)
    public RString keisanMeisaishoSetaiCode;
    @ReportItem(name = "kaisanMeisaishoTokuchoGokeiGaku", length = 10, order = 71)
    public RString kaisanMeisaishoTokuchoGokeiGaku;
    @ReportItem(name = "keisanMeisaishoKikanKaishi", length = 11, order = 72)
    public RString keisanMeisaishoKikanKaishi;
    @ReportItem(name = "kaisanMeisaishoFuchoGokeiGaku", length = 10, order = 73)
    public RString kaisanMeisaishoFuchoGokeiGaku;
    @ReportItem(name = "keisanMeisaishoKikanShuryo", length = 11, order = 74)
    public RString keisanMeisaishoKikanShuryo;
    @ReportItem(name = "keisanMeisaishoNofuZumiGaku", length = 10, order = 75)
    public RString keisanMeisaishoNofuZumiGaku;
    @ReportItem(name = "keisanMeisaishoTsukisu", length = 4, order = 76)
    public RString keisanMeisaishoTsukisu;
    @ReportItem(name = "keisanMeisaishoKongoNofuSubekiGaku", length = 10, order = 77)
    public RString keisanMeisaishoKongoNofuSubekiGaku;
    @ReportItem(name = "keisanMeisaishoShotokuDankai", length = 5, order = 78)
    public RString keisanMeisaishoShotokuDankai;
    @ReportItem(name = "keisanMeisaishoHokenryoRitsu", length = 10, order = 79)
    public RString keisanMeisaishoHokenryoRitsu;
    @ReportItem(name = "keisanMeisaishoKomokuTitle1", length = 10, order = 80)
    public RString keisanMeisaishoKomokuTitle1;
    @ReportItem(name = "keisanMeisaishoNofuGaku1", length = 10, order = 81)
    public RString keisanMeisaishoNofuGaku1;
    @ReportItem(name = "keisanMeisaishYen1", length = 1, order = 82)
    public RString keisanMeisaishYen1;
    @ReportItem(name = "keisanMeisaishoKomokuTitle2", length = 10, order = 83)
    public RString keisanMeisaishoKomokuTitle2;
    @ReportItem(name = "keisanMeisaishoNofuGaku2", length = 10, order = 84)
    public RString keisanMeisaishoNofuGaku2;
    @ReportItem(name = "keisanMeisaishoCalHokenryoGaku", length = 10, order = 85)
    public RString keisanMeisaishoCalHokenryoGaku;
    @ReportItem(name = "keisanMeisaishYen2", length = 1, order = 86)
    public RString keisanMeisaishYen2;
    @ReportItem(name = "keisanMeisaishoGenmenGaku", length = 10, order = 87)
    public RString keisanMeisaishoGenmenGaku;
    @ReportItem(name = "keisanMeisaishoKomokuTitle3", length = 10, order = 88)
    public RString keisanMeisaishoKomokuTitle3;
    @ReportItem(name = "keisanMeisaishoNofuGaku3", length = 10, order = 89)
    public RString keisanMeisaishoNofuGaku3;
    @ReportItem(name = "keisanMeisaishYen3", length = 1, order = 90)
    public RString keisanMeisaishYen3;
    @ReportItem(name = "keisanMeisaishoGekihenTitle", length = 20, order = 91)
    public RString keisanMeisaishoGekihenTitle;
    @ReportItem(name = "keisanMeisaishoGekihenMongon", length = 20, order = 92)
    public RString keisanMeisaishoGekihenMongon;
    @ReportItem(name = "keisanMeisaishoKomokuTitle4", length = 10, order = 93)
    public RString keisanMeisaishoKomokuTitle4;
    @ReportItem(name = "keisanMeisaishoNofuGaku4", length = 10, order = 94)
    public RString keisanMeisaishoNofuGaku4;
    @ReportItem(name = "keisanMeisaishYen4", length = 1, order = 95)
    public RString keisanMeisaishYen4;
    @ReportItem(name = "keisanMeisaishoKakuteiShinkokuGaku", length = 13, order = 96)
    public RString keisanMeisaishoKakuteiShinkokuGaku;
    @ReportItem(name = "keisanMeisaishoHokenryoGaku", length = 15, order = 97)
    public RString keisanMeisaishoHokenryoGaku;
    @ReportItem(name = "keisanMeisaishoNendo3", length = 4, order = 98)
    public RString keisanMeisaishoNendo3;
    @ReportItem(name = "keisanMeisaishoNendo2", length = 4, order = 99)
    public RString keisanMeisaishoNendo2;
    @ReportItem(name = "keisanMeisaishoTsuchiBun1", length = 12, order = 100)
    public RString keisanMeisaishoTsuchiBun1;
    @ReportItem(name = "keisanMeisaishoTsuchiBun2", length = 14, order = 101)
    public RString keisanMeisaishoTsuchiBun2;
    @ReportItem(name = "keisanMeisaishYen", length = 1, order = 102)
    public RString keisanMeisaishYen;
    @ReportItem(name = "keisanMeisaishoTsuchiBun3", length = 14, order = 103)
    public RString keisanMeisaishoTsuchiBun3;
    @ReportItem(name = "notsuRenban2", length = 10, order = 104)
    public RString notsuRenban2;
    @ReportItem(name = "pageCount2", length = 10, order = 105)
    public RString pageCount2;
    @ReportItem(name = "renban", length = 10, order = 106)
    public RString renban;
    @ReportItem(name = "hokenshaName", length = 10, order = 107)
    public RString hokenshaName;
    @ReportItem(name = "notsuRenban3", length = 10, order = 108)
    public RString notsuRenban3;
    @ReportItem(name = "pageCount3", length = 10, order = 109)
    public RString pageCount3;
    @ReportItem(name = "kamokumei", order = 110)
    public RString kamokumei;
    @ReportItem(name = "ryoshushoNendo", order = 111)
    public RString ryoshushoNendo;
    @ReportItem(name = "nendoNenbun", order = 112)
    public RString nendoNenbun;
    @ReportItem(name = "kibetsu", order = 113)
    public RString kibetsu;
    @ReportItem(name = "ryoshushoNenbun", order = 114)
    public RString ryoshushoNenbun;
    @ReportItem(name = "gokeigaku", length = 15, order = 115)
    public RString gokeigaku;
    @ReportItem(name = "shunoKikanBango", length = 5, order = 116)
    public RString shunoKikanBango;
    @ReportItem(name = "nofuBango", length = 20, order = 117)
    public RString nofuBango;
    @ReportItem(name = "kakuninBango", length = 5, order = 118)
    public RString kakuninBango;
    @ReportItem(name = "nofuKubun", length = 3, order = 119)
    public RString nofuKubun;
    @ReportItem(name = "nokigenTitle", length = 12, order = 120)
    public RString nokigenTitle;
    @ReportItem(name = "ocrId1", length = 3, order = 121)
    public RString ocrId1;
    @ReportItem(name = "tsuchishoNo", length = 20, order = 122)
    public RString coverNofu_tsuchishoNo;
    @ReportItem(name = "nokigenYmd", length = 16, order = 123)
    public RString nokigenYmd;
    @ReportItem(name = "hakkoYmd", length = 16, order = 124)
    public RString hakkoYmd;
    @ReportItem(name = "honzei", length = 15, order = 125)
    public RString honzei;
    @ReportItem(name = "tokusokuTesuryo", length = 5, order = 126)
    public RString tokusokuTesuryo;
    @ReportItem(name = "ocr1", length = 39, order = 127)
    public RString ocr1;
    @ReportItem(name = "ocrCut", length = 1, order = 128)
    public RString ocrCut;
    @ReportItem(name = "entaikin", length = 15, order = 129)
    public RString entaikin;
    @ReportItem(name = "ocr2", length = 44, order = 130)
    public RString ocr2;
    @ReportItem(name = "shimei", order = 131)
    public RString shimei;
    @ReportItem(name = "biko1", length = 30, order = 132)
    public RString biko1;
    @ReportItem(name = "biko2", length = 30, order = 133)
    public RString biko2;
    @ReportItem(name = "gimushaShimei", order = 134)
    public RString gimushaShimei;
    @ReportItem(name = "barcodeCvsBarcode1", order = 135)
    public RString barcodeCvsBarcode1;
    @ReportItem(name = "cvsBarcodeNaiyo3", length = 33, order = 136)
    public RString cvsBarcodeNaiyo3;
    @ReportItem(name = "cvsBarcodeNaiyo4", length = 33, order = 137)
    public RString cvsBarcodeNaiyo4;
    @ReportItem(name = "cvsToriatsukaikigen", length = 16, order = 138)
    public RString cvsToriatsukaikigen;
    @ReportItem(name = "funyuFukanBango", length = 12, order = 139)
    public RString funyuFukanBango;
    @ReportItem(name = "yubinNo", length = 8, order = 140)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 141)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 142)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 143)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 144)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 145)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 146)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 147)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 148)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 149)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 150)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei14", length = 20, order = 151)
    public RString shimei14;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 152)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 153)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 154)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 155)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 156)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei15", length = 20, order = 157)
    public RString shimei15;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 158)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 159)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 160)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 161)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 162)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 163)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 164)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 165)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 166)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 167)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 168)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 169)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 170)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 171)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 172)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 173)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 174)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 175)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 176)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 177)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 178)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 179)
    public RString koinShoryaku;
}
