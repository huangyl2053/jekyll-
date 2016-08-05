package jp.co.ndensan.reams.db.dbd.entity.report.dbd100025;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 障がい者控除対象者認定証ReportSourceです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class NinteishoJohoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD", length = 12, order = 1)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 4)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 5)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 6)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 7)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 8)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo", length = 8, order = 10)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku1", length = 14, order = 11)
    public RString gyoseiku1;
    @ReportItem(name = "jusho4", length = 20, order = 12)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 13)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 14)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 15)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 16)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 17)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 18)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 19)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 20)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei5", length = 20, order = 21)
    public RString shimei5;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 22)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 23)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 24)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 25)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 26)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei6", length = 20, order = 27)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 28)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 29)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 30)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 31)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 32)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 33)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 34)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 35)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 36)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 37)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 38)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 39)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 40)
    public RString customerBarCode;
    @ReportItem(name = "bunshoNo", length = 36, order = 41)
    public RString bunshoNo;
    @ReportItem(name = "title", length = 35, order = 42)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 43)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaName", order = 44)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 45)
    public RString hihokenshaNo;
    @ReportItem(name = "uketsukeYMD", length = 11, order = 46)
    public RString uketsukeYMD;
    @ReportItem(name = "shoninKbn", length = 3, order = 47)
    public RString shoninKbn;
    @ReportItem(name = "shoninYMD", length = 11, order = 48)
    public RString shoninYMD;
    @ReportItem(name = "fushoninRiyu", order = 49)
    public RString fushoninRiyu;
    @ReportItem(name = "kyufuShurui", length = 11, order = 50)
    public RString kyufuShurui;
    @ReportItem(name = "jigyoshaName", order = 51)
    public RString jigyoshaName;
    @ReportItem(name = "daihyoshaName", order = 52)
    public RString daihyoshaName;
    @ReportItem(name = "jigyoshaYubinNo", length = 10, order = 53)
    public RString jigyoshaYubinNo;
    @ReportItem(name = "jigyoshoJusho", order = 54)
    public RString jigyoshoJusho;
    @ReportItem(name = "jigyoshoTelNo", length = 15, order = 55)
    public RString jigyoshoTelNo;
    @ReportItem(name = "hiyogakuGokei", length = 10, order = 56)
    public RString hiyogakuGokei;
    @ReportItem(name = "hokenHiyogaku", length = 10, order = 57)
    public RString hokenHiyogaku;
    @ReportItem(name = "riyoFutangaku", length = 10, order = 58)
    public RString riyoFutangaku;
    @ReportItem(name = "hokenKyufuhigaku", length = 10, order = 59)
    public RString hokenKyufuhigaku;
    @ReportItem(name = "tsuchibun2", order = 60)
    public RString tsuchibun2;
    @ReportItem(name = "pagecnt", length = 5, order = 61)
    public RString pagecnt;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
