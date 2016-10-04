package jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishosealer;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC100042_介護保険給付費通知書(ｼｰﾗﾀｲﾌﾟ)のReportSourceクラスです。
 *
 * @reamsid_L DBC-2280-070 lizhuoxuan
 */
public class KyufuhiTsuchishoSealerReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "yubinNo2", length = 1, order = 2)
    public RString yubinNo2;
    @ReportItem(name = "yubinNo3", length = 1, order = 3)
    public RString yubinNo3;
    @ReportItem(name = "yubinNo4", length = 1, order = 4)
    public RString yubinNo4;
    @ReportItem(name = "yubinNo5", length = 1, order = 5)
    public RString yubinNo5;
    @ReportItem(name = "yubinNo6", length = 1, order = 6)
    public RString yubinNo6;
    @ReportItem(name = "yubinNo7", length = 1, order = 7)
    public RString yubinNo7;
    @ReportItem(name = "yubinNo1", length = 1, order = 8)
    public RString yubinNo1;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 9)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 22, order = 10)
    public RString hihokenshaName;
    @ReportItem(name = "shukeiserviceSTYM", length = 8, order = 11)
    public RString shukeiserviceSTYM;
    @ReportItem(name = "shukeiserviceEDYM", length = 8, order = 12)
    public RString shukeiserviceEDYM;
    @ReportItem(name = "listServiceIchiran_1", length = 8, order = 13)
    public RString listServiceIchiran_1;
    @ReportItem(name = "listServiceIchiran_2", length = 20, order = 14)
    public RString listServiceIchiran_2;
    @ReportItem(name = "listServiceIchiran_3", length = 12, order = 15)
    public RString listServiceIchiran_3;
    @ReportItem(name = "listServiceIchiran_4", length = 3, order = 16)
    public RString listServiceIchiran_4;
    @ReportItem(name = "listServiceIchiran_5", length = 12, order = 17)
    public RString listServiceIchiran_5;
    @ReportItem(name = "listServiceIchiran_6", length = 11, order = 18)
    public RString listServiceIchiran_6;
    @ReportItem(name = "toiawasesakiTitle", length = 25, order = 19)
    public RString toiawasesakiTitle;
    @ReportItem(name = "pageBunshi", length = 4, order = 20)
    public RString pageBunshi;
    @ReportItem(name = "pageBunbo", length = 4, order = 21)
    public RString pageBunbo;
    @ReportItem(name = "tsuchibun1", length = 110, order = 22)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 110, order = 23)
    public RString tsuchibun2;
    @ReportItem(name = "hakkoYMD", length = 12, order = 24)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 25)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 26)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 27)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 28)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 29)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 30)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 31)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 32)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo", length = 8, order = 33)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku1", length = 14, order = 34)
    public RString gyoseiku1;
    @ReportItem(name = "jusho4", length = 20, order = 35)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 36)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 37)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 38)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 39)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 40)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 41)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 42)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 43)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei5", length = 20, order = 44)
    public RString shimei5;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 45)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 46)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 47)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 48)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 49)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei6", length = 20, order = 50)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 51)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 52)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 53)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 54)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 55)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 56)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 57)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 58)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 59)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 60)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 61)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 62)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 63)
    public RString customerBarCode;
    @ReportItem(name = "yubinBango", length = 8, order = 64)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 65)
    public RString shozaichi;
    @ReportItem(name = "choshaBushoName", order = 66)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", order = 67)
    public RString tantoName;
    @ReportItem(name = "telNo", length = 20, order = 68)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 69)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 70)
    public RString naisenNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
