/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特別徴収開始通知書（本算定） A4縦・オーバレイタイプ帳票Source
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    //SUPPRESS CHECKSTYLE STRING-USE-CHECK//

    public static final String ITEM_TITLENENDO = "titleNendo";
    //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
    public static final String ITEM_TSUCHISHONO = "tuchishoNo";

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
    @ReportExpandedInfo(id = "X")
    @ReportItem(name = "hihokenshaNo", length = 10, order = 8)
    public RString hihokenshaNo;
    @ReportItem(name = "tuchishoNo", order = 9)
    public RString tuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 10)
    public RString setaiCode;
    @ReportPerson(id = "X")
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
    @ReportItem(name = "karisanteiGakuGokei", length = 7, order = 24)
    public RString karisanteiGakuGokei;
    @ReportItem(name = "hokenryoGaku10Gatsu1", length = 6, order = 25)
    public RString hokenryoGaku10Gatsu1;
    @ReportItem(name = "hokenryoGaku12Gatsu1", length = 6, order = 26)
    public RString hokenryoGaku12Gatsu1;
    @ReportItem(name = "hokenryoGaku2Gatsu1", length = 6, order = 27)
    public RString hokenryoGaku2Gatsu1;
    @ReportItem(name = "santeiKisoNendo1", length = 4, order = 28)
    public RString santeiKisoNendo1;
    @ReportItem(name = "santeikisoKikan", length = 23, order = 29)
    public RString santeikisoKikan;
    @ReportItem(name = "santeikisoTsukisu", length = 4, order = 30)
    public RString santeikisoTsukisu;
    @ReportItem(name = "shotokuDankai1", length = 8, order = 31)
    public RString shotokuDankai1;
    @ReportItem(name = "hokenryoGaku4Gatsu", length = 6, order = 32)
    public RString hokenryoGaku4Gatsu;
    @ReportItem(name = "hokenryoGaku10Gatsu2", length = 6, order = 33)
    public RString hokenryoGaku10Gatsu2;
    @ReportItem(name = "hokenryoGaku6Gatsu", length = 6, order = 34)
    public RString hokenryoGaku6Gatsu;
    @ReportItem(name = "hokenryoGaku12Gatsu2", length = 6, order = 35)
    public RString hokenryoGaku12Gatsu2;
    @ReportItem(name = "hokenryoRitsu", length = 6, order = 36)
    public RString hokenryoRitsu;
    @ReportItem(name = "nendoHokenryo", length = 6, order = 37)
    public RString nendoHokenryo;
    @ReportItem(name = "fuchoNofugaku", length = 6, order = 38)
    public RString fuchoNofugaku;
    @ReportItem(name = "hokenryoGaku8Gatsu", length = 6, order = 39)
    public RString hokenryoGaku8Gatsu;
    @ReportItem(name = "hokenryoGaku2Gatsu2", length = 6, order = 40)
    public RString hokenryoGaku2Gatsu2;
    @ReportItem(name = "yokunendoKariTokuchoHokenryogaku", length = 6, order = 41)
    public RString yokunendoKariTokuchoHokenryogaku;
    @ReportItem(name = "tsuchibun", order = 42)
    public RString tsuchibun;
    @ReportItem(name = "denshiKoin", order = 43)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 44)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 45)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 46)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 47)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 48)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 49)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo1", length = 8, order = 50)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 51)
    public RString gyoseiku1;
    @ReportItem(name = "jusho3", length = 20, order = 52)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 53)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 54)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 55)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 56)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 57)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 58)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 59)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 60)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 61)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 62)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 63)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 64)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 65)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 66)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 67)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 68)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 69)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 70)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 71)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 72)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 73)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 74)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 75)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 76)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 77)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 78)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 79)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 80)
    public RString customerBarCode;
    @ReportItem(name = "yubinBango", length = 8, order = 81)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 82)
    public RString shozaichi;
    @ReportItem(name = "tantoName", order = 83)
    public RString tantoName;
    @ReportItem(name = "choshaBushoName", order = 84)
    public RString choshaBushoName;
    @ReportItem(name = "telNo", length = 20, order = 85)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 86)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 87)
    public RString naisenNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
