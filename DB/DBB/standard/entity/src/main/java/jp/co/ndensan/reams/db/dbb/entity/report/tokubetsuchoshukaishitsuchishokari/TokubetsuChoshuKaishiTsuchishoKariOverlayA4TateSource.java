/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 特別徴収開始通知書（仮算定）帳票 A4縦・オーバーレイタイプSource
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "titleNendo", length = 4, order = 1)
    public RString titleNendo;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 2)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 3)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 4)
    public RString hyojicodeName3;
    @ReportItem(name = "hyojicodeCode1", length = 11, order = 5)
    public RString hyojicodeCode1;
    @ReportItem(name = "hyojicodeCode2", length = 11, order = 6)
    public RString hyojicodeCode2;
    @ReportItem(name = "hyojicodeCode3", length = 11, order = 7)
    public RString hyojicodeCode3;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 8)
    public RString hihokenshaNo;
    @ReportItem(name = "tuchishoNo", order = 9)
    public RString tuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 10)
    public RString setaiCode;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 11)
    public RString shikibetsuCode;
    @ReportItem(name = "hihokenshaName", order = 12)
    public RString hihokenshaName;
    @ReportItem(name = "setainushiName", order = 13)
    public RString setainushiName;
    @ReportItem(name = "hihokenshaJusho", order = 14)
    public RString hihokenshaJusho;
    @ReportItem(name = "hihokenshaKatagaki", order = 15)
    public RString hihokenshaKatagaki;
    @ReportItem(name = "birthYYYY", length = 8, order = 16)
    public RString birthYYYY;
    @ReportItem(name = "birthMM", length = 2, order = 17)
    public RString birthMM;
    @ReportItem(name = "birthDD", length = 2, order = 18)
    public RString birthDD;
    @ReportItem(name = "seibetsu", length = 2, order = 19)
    public RString seibetsu;
    @ReportItem(name = "tokuchoGimushaName", length = 20, order = 20)
    public RString tokuchoGimushaName;
    @ReportItem(name = "tokuchoTaishoNenkinName", length = 20, order = 21)
    public RString tokuchoTaishoNenkinName;
    @ReportItem(name = "hokenryoGakuNendo1", length = 4, order = 22)
    public RString hokenryoGakuNendo1;
    @ReportItem(name = "hokenryoGakuNendo2", length = 4, order = 23)
    public RString hokenryoGakuNendo2;
    @ReportItem(name = "karisanteiGakuGokei", length = 11, order = 24)
    public RString karisanteiGakuGokei;
    @ReportItem(name = "hokenryoGaku4Gatsu1", length = 9, order = 25)
    public RString hokenryoGaku4Gatsu1;
    @ReportItem(name = "hokenryoGaku6Gatsu1", length = 9, order = 26)
    public RString hokenryoGaku6Gatsu1;
    @ReportItem(name = "hokenryoGaku8Gatsu1", length = 9, order = 27)
    public RString hokenryoGaku8Gatsu1;
    @ReportItem(name = "SanteiKisoNendo1", length = 4, order = 28)
    public RString SanteiKisoNendo1;
    @ReportItem(name = "SanteiKisoNendo2", length = 4, order = 29)
    public RString SanteiKisoNendo2;
    @ReportItem(name = "SanteiKisoNendo3", length = 4, order = 30)
    public RString SanteiKisoNendo3;
    @ReportItem(name = "shotokuDankai", length = 8, order = 31)
    public RString shotokuDankai;
    @ReportItem(name = "karisanteiGakuGokei1", length = 9, order = 32)
    public RString karisanteiGakuGokei1;
    @ReportItem(name = "hokenryoGaku10Gatsu", length = 6, order = 33)
    public RString hokenryoGaku10Gatsu;
    @ReportItem(name = "hokenryoGaku4Gatsu2", length = 6, order = 34)
    public RString hokenryoGaku4Gatsu2;
    @ReportItem(name = "hokenryoGaku12Gatsu", length = 6, order = 35)
    public RString hokenryoGaku12Gatsu;
    @ReportItem(name = "hokenryoGaku6Gatsu2", length = 6, order = 36)
    public RString hokenryoGaku6Gatsu2;
    @ReportItem(name = "hokenryoGaku2Gatsu", length = 6, order = 37)
    public RString hokenryoGaku2Gatsu;
    @ReportItem(name = "hokenryoGaku8Gatsu2", length = 6, order = 38)
    public RString hokenryoGaku8Gatsu2;
    @ReportItem(name = "tsuchibun", order = 39)
    public RString tsuchibun;
    @ReportItem(name = "Text2", order = 40)
    public RString Text2;
    @ReportItem(name = "denshiKoin", order = 41)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 42)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 43)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 44)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 45)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 46)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 47)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo1", length = 8, order = 48)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 49)
    public RString gyoseiku1;
    @ReportItem(name = "jusho3", length = 20, order = 50)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 51)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 52)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 53)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 54)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 55)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 56)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 57)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 58)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 59)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 60)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 61)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 62)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 63)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 64)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 65)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 66)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 67)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 68)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 69)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 70)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 71)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 72)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 73)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 74)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 75)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 76)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 77)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 78)
    public RString customerBarCode;
    @ReportItem(name = "yubinBango", length = 8, order = 79)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 80)
    public RString shozaichi;
    @ReportItem(name = "tantoName", order = 81)
    public RString tantoName;
    @ReportItem(name = "choshaBushoName", order = 82)
    public RString choshaBushoName;
    @ReportItem(name = "telNo", length = 20, order = 83)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 84)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 85)
    public RString naisenNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
