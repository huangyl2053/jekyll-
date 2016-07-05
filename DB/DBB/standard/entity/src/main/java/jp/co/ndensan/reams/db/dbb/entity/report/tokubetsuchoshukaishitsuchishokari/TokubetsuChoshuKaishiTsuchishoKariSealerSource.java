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
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプSource
 *
 * @reamsid_L DBB-0790-060 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    //SUPPRESS CHECKSTYLE STRING-USE-CHECK//

    public static final String ITEM_NENDO = "nendo";
    //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
    public static final String ITEM_TSUCHISHONO = "tsuchishoNo";

    @ReportItem(name = "nendo2", length = 4, order = 1)
    public RString nendo2;
    @ReportItem(name = "nendo3", length = 4, order = 2)
    public RString nendo3;
    @ReportItem(name = "hokenryoGokei", length = 11, order = 3)
    public RString hokenryoGokei;
    @ReportItem(name = "nendo4", length = 4, order = 4)
    public RString nendo4;
    @ReportItem(name = "tsuchishoNo", order = 5)
    public RString tsuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 6)
    public RString setaiCode;
    @ReportItem(name = "hihokenshaName", order = 7)
    public RString hihokenshaName;
    @ReportItem(name = "nendo5", length = 4, order = 8)
    public RString nendo5;
    @ReportItem(name = "nendo6", length = 4, order = 9)
    public RString nendo6;
    @ReportItem(name = "hihokenshaJusho", order = 10)
    public RString hihokenshaJusho;
    @ReportItem(name = "hokenryoGakuZen10Gatsu", length = 7, order = 11)
    public RString hokenryoGakuZen10Gatsu;
    @ReportItem(name = "hokenryoGaku4Gatsu2", length = 7, order = 12)
    public RString hokenryoGaku4Gatsu2;
    @ReportItem(name = "hihokenshaKatagaki", order = 13)
    public RString hihokenshaKatagaki;
    @ReportItem(name = "hokenryoGakuZen12Gatsu", length = 7, order = 14)
    public RString hokenryoGakuZen12Gatsu;
    @ReportItem(name = "hokenryoGaku6Gatsu2", length = 7, order = 15)
    public RString hokenryoGaku6Gatsu2;
    @ReportItem(name = "hokenryoGakuZen2Gatsu", length = 7, order = 16)
    public RString hokenryoGakuZen2Gatsu;
    @ReportItem(name = "hokenryoGaku8Gatsu2", length = 7, order = 17)
    public RString hokenryoGaku8Gatsu2;
    @ReportItem(name = "birthYMD", length = 16, order = 18)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 19)
    public RString seibetsu;
    @ReportItem(name = "setainushiName", order = 20)
    public RString setainushiName;
    @ReportItem(name = "nendo7", length = 4, order = 21)
    public RString nendo7;
    @ReportItem(name = "nendo8", length = 4, order = 22)
    public RString nendo8;
    @ReportItem(name = "tokuchoGimushaName", length = 20, order = 23)
    public RString tokuchoGimushaName;
    @ReportItem(name = "tokuchoTaishoNenkinName", length = 20, order = 24)
    public RString tokuchoTaishoNenkinName;
    @ReportItem(name = "nendo", length = 4, order = 25)
    public RString nendo;
    @ReportItem(name = "nendo9", length = 4, order = 26)
    public RString nendo9;
    @ReportItem(name = "hokenryoGaku4Gatsu1", length = 7, order = 27)
    public RString hokenryoGaku4Gatsu1;
    @ReportItem(name = "hokenryoGaku6Gatsu1", length = 7, order = 28)
    public RString hokenryoGaku6Gatsu1;
    @ReportItem(name = "hokenryoGaku8Gatsu1", length = 7, order = 29)
    public RString hokenryoGaku8Gatsu1;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 30)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 31)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 32)
    public RString hyojicodeName3;
    @ReportItem(name = "hyojicode1", length = 11, order = 33)
    public RString hyojicode1;
    @ReportItem(name = "hyojicode2", length = 9, order = 34)
    public RString hyojicode2;
    @ReportItem(name = "hyojicode3", length = 9, order = 35)
    public RString hyojicode3;
    @ReportItem(name = "pageCount1", length = 6, order = 36)
    public RString pageCount1;
    @ReportItem(name = "denshiKoin", order = 37)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 38)
    public RString hakkoYMD;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 39)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 40)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 41)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 42)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 43)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo1", length = 8, order = 44)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 45)
    public RString gyoseiku1;
    @ReportItem(name = "jusho3", length = 20, order = 46)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 47)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 48)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 49)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 50)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 51)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 52)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 53)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 54)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 55)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 56)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 57)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 58)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 59)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 60)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 61)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 62)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 63)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 64)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 65)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 66)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 67)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 68)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 69)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 70)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 71)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 72)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 73)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 74)
    public RString customerBarCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
