/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票　保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】連帳の項目を定義するクラスです。
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoSource implements IReportSource {

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
    public RString kaisanMeisaishoTokuchoGokeiGaku;
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
    @ReportItem(name = "noutsuRenban", length = 8, order = 48)
    public RString noutsuRenban;
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
    public RString keisanMeisaishoHokenryoGakuGokei;
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
    @ReportItem(name = "kamokumei1", order = 109)
    public RString kamokumei1;
    @ReportItem(name = "ryoshushoNendo1", order = 110)
    public RString ryoshushoNendo1;
    @ReportItem(name = "nendoNenbun1", order = 111)
    public RString nendoNenbun1;
    @ReportItem(name = "kibetsu1", order = 112)
    public RString kibetsu1;
    @ReportItem(name = "ryoshushoNenbun1", order = 113)
    public RString ryoshushoNenbun1;
    @ReportItem(name = "gokeigaku1", length = 15, order = 114)
    public RString gokeigaku1;
    @ReportItem(name = "shunoKikanBango1", length = 5, order = 115)
    public RString shunoKikanBango1;
    @ReportItem(name = "nofuBango1", length = 20, order = 116)
    public RString nofuBango1;
    @ReportItem(name = "kakuninBango1", length = 5, order = 117)
    public RString kakuninBango1;
    @ReportItem(name = "nofuKubun1", length = 3, order = 118)
    public RString nofuKubun1;
    @ReportItem(name = "nokigenTitle1", length = 12, order = 119)
    public RString nokigenTitle1;
    @ReportItem(name = "ocrId1", length = 3, order = 120)
    public RString ocrId1;
    @ReportItem(name = "tsuchishoNo1", length = 20, order = 121)
    public RString tsuchishoNo1;
    @ReportItem(name = "nokigenYmd1", length = 16, order = 122)
    public RString nokigenYmd1;
    @ReportItem(name = "hakkoYmd1", length = 16, order = 123)
    public RString hakkoYmd1;
    @ReportItem(name = "honzei1", length = 15, order = 124)
    public RString honzei1;
    @ReportItem(name = "tokusokuTesuryo1", length = 5, order = 125)
    public RString tokusokuTesuryo1;
    @ReportItem(name = "ocr11", length = 39, order = 126)
    public RString ocr11;
    @ReportItem(name = "ocrCut1", length = 1, order = 127)
    public RString ocrCut1;
    @ReportItem(name = "entaikin1", length = 15, order = 128)
    public RString entaikin1;
    @ReportItem(name = "ocr21", length = 44, order = 129)
    public RString ocr21;
    @ReportItem(name = "tsuchishoShimei1", order = 130)
    public RString tsuchishoShimei1;
    @ReportItem(name = "biko11", length = 30, order = 131)
    public RString biko11;
    @ReportItem(name = "biko21", length = 30, order = 132)
    public RString biko21;
    @ReportItem(name = "gimushaShimei1", order = 133)
    public RString gimushaShimei1;
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
    @ReportItem(name = "kamokumei2", order = 139)
    public RString kamokumei2;
    @ReportItem(name = "ryoshushoNendo2", order = 140)
    public RString ryoshushoNendo2;
    @ReportItem(name = "nendoNenbun2", order = 141)
    public RString nendoNenbun2;
    @ReportItem(name = "kibetsu2", order = 142)
    public RString kibetsu2;
    @ReportItem(name = "ryoshushoNenbun2", order = 143)
    public RString ryoshushoNenbun2;
    @ReportItem(name = "gokeigaku2", length = 15, order = 144)
    public RString gokeigaku2;
    @ReportItem(name = "shunoKikanBango2", length = 5, order = 145)
    public RString shunoKikanBango2;
    @ReportItem(name = "nofuBango2", length = 20, order = 146)
    public RString nofuBango2;
    @ReportItem(name = "kakuninBango2", length = 5, order = 147)
    public RString kakuninBango2;
    @ReportItem(name = "nofuKubun2", length = 3, order = 148)
    public RString nofuKubun2;
    @ReportItem(name = "nokigenTitle2", length = 12, order = 149)
    public RString nokigenTitle2;
    @ReportItem(name = "ocrId2", length = 3, order = 150)
    public RString ocrId2;
    @ReportItem(name = "tsuchishoNo2", length = 20, order = 151)
    public RString tsuchishoNo2;
    @ReportItem(name = "nokigenYmd2", length = 16, order = 152)
    public RString nokigenYmd2;
    @ReportItem(name = "hakkoYmd2", length = 16, order = 153)
    public RString hakkoYmd2;
    @ReportItem(name = "honzei2", length = 15, order = 154)
    public RString honzei2;
    @ReportItem(name = "tokusokuTesuryo2", length = 5, order = 155)
    public RString tokusokuTesuryo2;
    @ReportItem(name = "ocr12", length = 39, order = 156)
    public RString ocr12;
    @ReportItem(name = "ocrCut2", length = 1, order = 157)
    public RString ocrCut2;
    @ReportItem(name = "entaikin2", length = 15, order = 158)
    public RString entaikin2;
    @ReportItem(name = "ocr22", length = 44, order = 159)
    public RString ocr22;
    @ReportItem(name = "tsuchishoShimei2", order = 160)
    public RString tsuchishoShimei2;
    @ReportItem(name = "biko12", length = 30, order = 161)
    public RString biko12;
    @ReportItem(name = "biko22", length = 30, order = 162)
    public RString biko22;
    @ReportItem(name = "gimushaShimei2", order = 163)
    public RString gimushaShimei2;
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

    //納付書
    @ReportItem(name = "detail_kamokumei1", order = 201)
    public RString detail_kamokumei1;
    @ReportItem(name = "detail_kamokumei2", order = 202)
    public RString detail_kamokumei2;
    @ReportItem(name = "detail_ryoshushoNendo1", order = 203)
    public RString detail_ryoshushoNendo1;
    @ReportItem(name = "detail_ryoshushoNendo2", order = 204)
    public RString detail_ryoshushoNendo2;
    @ReportItem(name = "detail_nendoNenbun1", order = 205)
    public RString detail_nendoNenbun1;
    @ReportItem(name = "detail_kibetsu1", order = 206)
    public RString detail_kibetsu1;
    @ReportItem(name = "detail_nendoNenbun2", order = 207)
    public RString detail_nendoNenbun2;
    @ReportItem(name = "detail_kibetsu2", order = 208)
    public RString detail_kibetsu2;
    @ReportItem(name = "detail_ryoshushoNenbun1", order = 209)
    public RString detail_ryoshushoNenbun1;
    @ReportItem(name = "detail_ryoshushoNenbun2", order = 210)
    public RString detail_ryoshushoNenbun2;
    @ReportItem(name = "detail_gokeigaku11", length = 15, order = 211)
    public RString detail_gokeigaku11;
    @ReportItem(name = "detail_gokeigaku12", length = 15, order = 212)
    public RString detail_gokeigaku12;
    @ReportItem(name = "detail_shunoKikanBango1", length = 5, order = 213)
    public RString detail_shunoKikanBango1;
    @ReportItem(name = "detail_nofuBango1", length = 20, order = 214)
    public RString detail_nofuBango1;
    @ReportItem(name = "detail_kakuninBango1", length = 5, order = 215)
    public RString detail_kakuninBango1;
    @ReportItem(name = "detail_nofuKubun1", length = 3, order = 216)
    public RString detail_nofuKubun1;
    @ReportItem(name = "detail_shunoKikanBango2", length = 5, order = 217)
    public RString detail_shunoKikanBango2;
    @ReportItem(name = "detail_nofuBango2", length = 20, order = 218)
    public RString detail_nofuBango2;
    @ReportItem(name = "detail_kakuninBango2", length = 5, order = 219)
    public RString detail_kakuninBango2;
    @ReportItem(name = "detail_nofuKubun2", length = 3, order = 220)
    public RString detail_nofuKubun2;
    @ReportItem(name = "detail_nokigenTitle11", length = 12, order = 221)
    public RString detail_nokigenTitle11;
    @ReportItem(name = "detail_nokigenTitle12", length = 12, order = 222)
    public RString detail_nokigenTitle12;
    @ReportItem(name = "detail_ocrId1", length = 3, order = 223)
    public RString detail_ocrId1;
    @ReportItem(name = "detail_ocrId2", length = 3, order = 224)
    public RString detail_ocrId2;
    @ReportItem(name = "detail_tsuchishoNo1", length = 20, order = 225)
    public RString detail_tsuchishoNo1;
    @ReportItem(name = "detail_tsuchishoNo2", length = 20, order = 226)
    public RString detail_tsuchishoNo2;
    @ReportItem(name = "detail_nokigenYmd1", length = 16, order = 227)
    public RString detail_nokigenYmd1;
    @ReportItem(name = "detail_hakkoYmd1", length = 16, order = 228)
    public RString detail_hakkoYmd1;
    @ReportItem(name = "detail_nokigenYmd2", length = 16, order = 229)
    public RString detail_nokigenYmd2;
    @ReportItem(name = "detail_hakkoYmd2", length = 16, order = 230)
    public RString detail_hakkoYmd2;
    @ReportItem(name = "detail_honzei1", length = 15, order = 231)
    public RString detail_honzei1;
    @ReportItem(name = "detail_honzei2", length = 15, order = 232)
    public RString detail_honzei2;
    @ReportItem(name = "detail_tokusokuTesuryo1", length = 5, order = 233)
    public RString detail_tokusokuTesuryo1;
    @ReportItem(name = "detail_tokusokuTesuryo2", length = 5, order = 234)
    public RString detail_tokusokuTesuryo2;
    @ReportItem(name = "detail_ocr11", length = 39, order = 235)
    public RString detail_ocr11;
    @ReportItem(name = "detail_ocrCut1", length = 1, order = 236)
    public RString detail_ocrCut1;
    @ReportItem(name = "detail_ocr12", length = 39, order = 237)
    public RString detail_ocr12;
    @ReportItem(name = "detail_ocrCut2", length = 1, order = 238)
    public RString detail_ocrCut2;
    @ReportItem(name = "detail_entaikin1", length = 15, order = 239)
    public RString detail_entaikin1;
    @ReportItem(name = "detail_entaikin2", length = 15, order = 240)
    public RString detail_entaikin2;
    @ReportItem(name = "detail_ocr21", length = 44, order = 241)
    public RString detail_ocr21;
    @ReportItem(name = "detail_ocr22", length = 44, order = 242)
    public RString detail_ocr22;
    @ReportItem(name = "detail_shimei1", order = 243)
    public RString detail_shimei1;
    @ReportItem(name = "detail_shimei2", order = 244)
    public RString detail_shimei2;
    @ReportItem(name = "detail_biko11", length = 30, order = 245)
    public RString detail_biko11;
    @ReportItem(name = "detail_biko12", length = 30, order = 246)
    public RString detail_biko12;
    @ReportItem(name = "detail_biko21", length = 30, order = 247)
    public RString detail_biko21;
    @ReportItem(name = "detail_biko22", length = 30, order = 248)
    public RString detail_biko22;
    @ReportItem(name = "detail_gimushaShimei1", order = 249)
    public RString detail_gimushaShimei1;
    @ReportItem(name = "detail_gimushaShimei2", order = 250)
    public RString detail_gimushaShimei2;
    @ReportItem(name = "detail_barcodeCvsBarcode1", order = 251)
    public RString detail_barcodeCvsBarcode1;
    @ReportItem(name = "detail_barcodeCvsBarcode2", order = 252)
    public RString detail_barcodeCvsBarcode2;
    @ReportItem(name = "detail_cvsBarcodeNaiyo11", length = 33, order = 253)
    public RString detail_cvsBarcodeNaiyo11;
    @ReportItem(name = "detail_cvsBarcodeNaiyo12", length = 33, order = 254)
    public RString detail_cvsBarcodeNaiyo12;
    @ReportItem(name = "detail_cvsBarcodeNaiyo21", length = 33, order = 255)
    public RString detail_cvsBarcodeNaiyo21;
    @ReportItem(name = "detail_cvsBarcodeNaiyo22", length = 33, order = 256)
    public RString detail_cvsBarcodeNaiyo22;
    @ReportItem(name = "detail_cvsToriatsukaikigen1", length = 16, order = 257)
    public RString detail_cvsToriatsukaikigen1;
    @ReportItem(name = "detail_cvsToriatsukaikigen2", length = 16, order = 258)
    public RString detail_cvsToriatsukaikigen2;
    @ReportItem(name = "detail_funyuFukanBango1", length = 12, order = 259)
    public RString detail_funyuFukanBango1;
    @ReportItem(name = "detail_funyuFukanBango2", length = 12, order = 260)
    public RString detail_funyuFukanBango2;
    @ReportItem(name = "detail_kamokumei3", order = 261)
    public RString detail_kamokumei3;
    @ReportItem(name = "detail_kamokumei4", order = 262)
    public RString detail_kamokumei4;
    @ReportItem(name = "detail_ryoshushoNendo3", order = 263)
    public RString detail_ryoshushoNendo3;
    @ReportItem(name = "detail_ryoshushoNendo4", order = 264)
    public RString detail_ryoshushoNendo4;
    @ReportItem(name = "detail_nendoNenbun3", order = 265)
    public RString detail_nendoNenbun3;
    @ReportItem(name = "detail_kibetsu3", order = 266)
    public RString detail_kibetsu3;
    @ReportItem(name = "detail_nendoNenbun4", order = 267)
    public RString detail_nendoNenbun4;
    @ReportItem(name = "detail_kibetsu4", order = 268)
    public RString detail_kibetsu4;
    @ReportItem(name = "detail_ryoshushoNenbun3", order = 269)
    public RString detail_ryoshushoNenbun3;
    @ReportItem(name = "detail_ryoshushoNenbun4", order = 270)
    public RString detail_ryoshushoNenbun4;
    @ReportItem(name = "detail_gokeigaku13", length = 15, order = 271)
    public RString detail_gokeigaku13;
    @ReportItem(name = "detail_gokeigaku14", length = 15, order = 272)
    public RString detail_gokeigaku14;
    @ReportItem(name = "detail_shunoKikanBango3", length = 5, order = 273)
    public RString detail_shunoKikanBango3;
    @ReportItem(name = "detail_nofuBango3", length = 20, order = 274)
    public RString detail_nofuBango3;
    @ReportItem(name = "detail_kakuninBango3", length = 5, order = 275)
    public RString detail_kakuninBango3;
    @ReportItem(name = "detail_nofuKubun3", length = 3, order = 276)
    public RString detail_nofuKubun3;
    @ReportItem(name = "detail_shunoKikanBango4", length = 5, order = 277)
    public RString detail_shunoKikanBango4;
    @ReportItem(name = "detail_nofuBango4", length = 20, order = 278)
    public RString detail_nofuBango4;
    @ReportItem(name = "detail_kakuninBango4", length = 5, order = 279)
    public RString detail_kakuninBango4;
    @ReportItem(name = "detail_nofuKubun4", length = 3, order = 280)
    public RString detail_nofuKubun4;
    @ReportItem(name = "detail_nokigenTitle13", length = 12, order = 281)
    public RString detail_nokigenTitle13;
    @ReportItem(name = "detail_nokigenTitle14", length = 12, order = 282)
    public RString detail_nokigenTitle14;
    @ReportItem(name = "detail_ocrId3", length = 3, order = 283)
    public RString detail_ocrId3;
    @ReportItem(name = "detail_ocrId4", length = 3, order = 284)
    public RString detail_ocrId4;
    @ReportItem(name = "detail_tsuchishoNo3", length = 20, order = 285)
    public RString detail_tsuchishoNo3;
    @ReportItem(name = "detail_nokigenYmd3", length = 16, order = 286)
    public RString detail_nokigenYmd3;
    @ReportItem(name = "detail_hakkoYmd3", length = 16, order = 287)
    public RString detail_hakkoYmd3;
    @ReportItem(name = "detail_tsuchishoNo4", length = 20, order = 288)
    public RString detail_tsuchishoNo4;
    @ReportItem(name = "detail_nokigenYmd4", length = 16, order = 289)
    public RString detail_nokigenYmd4;
    @ReportItem(name = "detail_hakkoYmd4", length = 16, order = 290)
    public RString detail_hakkoYmd4;
    @ReportItem(name = "detail_honzei3", length = 15, order = 291)
    public RString detail_honzei3;
    @ReportItem(name = "detail_honzei4", length = 15, order = 292)
    public RString detail_honzei4;
    @ReportItem(name = "detail_tokusokuTesuryo3", length = 5, order = 293)
    public RString detail_tokusokuTesuryo3;
    @ReportItem(name = "detail_tokusokuTesuryo4", length = 5, order = 294)
    public RString detail_tokusokuTesuryo4;
    @ReportItem(name = "detail_ocr13", length = 39, order = 295)
    public RString detail_ocr13;
    @ReportItem(name = "detail_ocrCut3", length = 1, order = 296)
    public RString detail_ocrCut3;
    @ReportItem(name = "detail_ocr14", length = 39, order = 297)
    public RString detail_ocr14;
    @ReportItem(name = "detail_ocrCut4", length = 1, order = 298)
    public RString detail_ocrCut4;
    @ReportItem(name = "detail_entaikin3", length = 15, order = 299)
    public RString detail_entaikin3;
    @ReportItem(name = "detail_entaikin4", length = 15, order = 300)
    public RString detail_entaikin4;
    @ReportItem(name = "detail_ocr23", length = 44, order = 301)
    public RString detail_ocr23;
    @ReportItem(name = "detail_ocr24", length = 44, order = 302)
    public RString detail_ocr24;
    @ReportItem(name = "detail_shimei3", order = 303)
    public RString detail_shimei3;
    @ReportItem(name = "detail_shimei4", order = 304)
    public RString detail_shimei4;
    @ReportItem(name = "detail_biko13", length = 30, order = 305)
    public RString detail_biko13;
    @ReportItem(name = "detail_biko14", length = 30, order = 306)
    public RString detail_biko14;
    @ReportItem(name = "detail_biko23", length = 30, order = 307)
    public RString detail_biko23;
    @ReportItem(name = "detail_biko24", length = 30, order = 308)
    public RString detail_biko24;
    @ReportItem(name = "detail_gimushaShimei3", order = 309)
    public RString detail_gimushaShimei3;
    @ReportItem(name = "detail_gimushaShimei4", order = 310)
    public RString detail_gimushaShimei4;
    @ReportItem(name = "detail_barcodeCvsBarcode3", order = 311)
    public RString detail_barcodeCvsBarcode3;
    @ReportItem(name = "detail_barcodeCvsBarcode4", order = 312)
    public RString detail_barcodeCvsBarcode4;
    @ReportItem(name = "detail_cvsBarcodeNaiyo13", length = 33, order = 313)
    public RString detail_cvsBarcodeNaiyo13;
    @ReportItem(name = "detail_cvsBarcodeNaiyo14", length = 33, order = 314)
    public RString detail_cvsBarcodeNaiyo14;
    @ReportItem(name = "detail_cvsBarcodeNaiyo23", length = 33, order = 315)
    public RString detail_cvsBarcodeNaiyo23;
    @ReportItem(name = "detail_cvsBarcodeNaiyo24", length = 33, order = 316)
    public RString detail_cvsBarcodeNaiyo24;
    @ReportItem(name = "detail_cvsToriatsukaikigen3", length = 16, order = 317)
    public RString detail_cvsToriatsukaikigen3;
    @ReportItem(name = "detail_cvsToriatsukaikigen4", length = 16, order = 318)
    public RString detail_cvsToriatsukaikigen4;
    @ReportItem(name = "detail_funyuFukanBango3", length = 12, order = 319)
    public RString detail_funyuFukanBango3;
    @ReportItem(name = "detail_funyuFukanBango4", length = 12, order = 320)
    public RString detail_funyuFukanBango4;

    @ReportItem(name = "layoutBreakItem", length = 10, order = 999)
    public int layoutBreakItem;
    public static final RString LAYOUTBREAKITEM;

    static {
        LAYOUTBREAKITEM = new RString("layoutBreakItem");
    }
}
