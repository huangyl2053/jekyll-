/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.gemmen;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険料減免決定通知書 A4縦タイプSourceするクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class KaigoHokenryoGenmenKetteiTsuchishoTateSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "choteiNendo", length = 4, order = 2)
    public RString choteiNendo;
    @ReportItem(name = "fukaNendo", length = 4, order = 3)
    public RString fukaNendo;
    @ReportItem(name = "ketteiKekka", length = 4, order = 4)
    public RString ketteiKekka;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 5)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 6)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 7)
    public RString hyojicodeName3;
    @ReportItem(name = "genmenKetteiYMD", length = 11, order = 8)
    public RString genmenKetteiYMD;
    @ReportItem(name = "hyojicode1", length = 11, order = 9)
    public RString hyojicode1;
    @ReportItem(name = "hyojicode2", length = 9, order = 10)
    public RString hyojicode2;
    @ReportItem(name = "hyojicode3", length = 9, order = 11)
    public RString hyojicode3;
    @ReportItem(name = "tsuchisjoNo", order = 12)
    public RString tsuchisjoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 13)
    public RString setaiCode;
    @ReportItem(name = "hokenSanshutsuMae", length = 10, order = 14)
    public RString hokenSanshutsuMae;
    @ReportItem(name = "hokenSanshutsuAto", length = 10, order = 15)
    public RString hokenSanshutsuAto;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 16)
    public RString hihokenshaNo;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 17)
    public RString shikibetsuCode;
    @ReportItem(name = "genmenGakuMae", length = 10, order = 18)
    public RString genmenGakuMae;
    @ReportItem(name = "genmenGakuAto", length = 10, order = 19)
    public RString genmenGakuAto;
    @ReportItem(name = "hokenGakuMae", length = 10, order = 20)
    public RString hokenGakuMae;
    @ReportItem(name = "hokenGakuAto", length = 10, order = 21)
    public RString hokenGakuAto;
    @ReportItem(name = "genmenRiyu1", length = 30, order = 22)
    public RString genmenRiyu1;
    @ReportItem(name = "genmenRiyu2", length = 30, order = 23)
    public RString genmenRiyu2;
    @ReportItem(name = "listKibetsu_1", length = 2, order = 24)
    public RString listKibetsu_1;
    @ReportItem(name = "listKibetsu_2", length = 2, order = 25)
    public RString listKibetsu_2;
    @ReportItem(name = "listKibetsu_3", length = 7, order = 26)
    public RString listKibetsu_3;
    @ReportItem(name = "listKibetsu_4", length = 7, order = 27)
    public RString listKibetsu_4;
    @ReportItem(name = "listKibetsu_5", length = 2, order = 28)
    public RString listKibetsu_5;
    @ReportItem(name = "listKibetsu_6", length = 2, order = 29)
    public RString listKibetsu_6;
    @ReportItem(name = "listKibetsu_7", length = 7, order = 30)
    public RString listKibetsu_7;
    @ReportItem(name = "listKibetsu_8", length = 7, order = 31)
    public RString listKibetsu_8;
    @ReportItem(name = "listZuiji_1", length = 2, order = 32)
    public RString listZuiji_1;
    @ReportItem(name = "bikoTitle", order = 33)
    public RString bikoTitle;
    @ReportItem(name = "biko", order = 34)
    public RString biko;
    @ReportItem(name = "yubinNo", length = 8, order = 35)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 36)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 37)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 38)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 39)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 40)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 41)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 42)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 43)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 44)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 45)
    public RString katagakiSmall1;
    @ReportItem(name = "kakkoRight2", length = 1, order = 46)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoRight1", length = 1, order = 47)
    public RString kakkoRight1;
    @ReportItem(name = "shimei2", length = 20, order = 48)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 49)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 50)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 51)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 52)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 53)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 54)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 55)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 56)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 57)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 58)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 59)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 60)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 61)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 62)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 63)
    public RString samaBun1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 64)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 65)
    public RString customerBarCode;
    @ReportItem(name = "hakkoYMD", length = 12, order = 66)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 67)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 68)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 69)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 70)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 71)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 72)
    public RString koinShoryaku;
    @ReportItem(name = "yubinBango", length = 8, order = 73)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 74)
    public RString shozaichi;
    @ReportItem(name = "choshaBushoName", order = 75)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", order = 76)
    public RString tantoName;
    @ReportItem(name = "telNo", length = 20, order = 77)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 78)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 79)
    public RString naisenNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
