package jp.co.ndensan.reams.db.dbd.entity.report.dbd100008;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "title", length = 40, order = 2)
    public RString title;
    @ReportItem(name = "hihokenshaNameKana", length = 40, order = 3)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 4)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "tsuchibun", order = 6)
    public RString tsuchibun;
    @ReportItem(name = "hakkoYMD", length = 12, order = 7)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 8)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 9)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 10)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 11)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 12)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "denshiKoin", order = 13)
    public RString denshiKoin;
    @ReportItem(name = "koinShoryaku", length = 15, order = 14)
    public RString koinShoryaku;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 15)
    public RString koinMojiretsu;
    @ReportItem(name = "yubinNo", length = 8, order = 16)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 17)
    public RString gyoseiku;
    @ReportItem(name = "jushoText", order = 18)
    public RString jushoText;
    @ReportItem(name = "jusho3", length = 20, order = 19)
    public RString jusho3;
    @ReportItem(name = "jusho1", length = 20, order = 20)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 21)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 22)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 18, order = 23)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 26, order = 24)
    public RString katagakiSmall2;
    @ReportItem(name = "katagakiSmall1", length = 26, order = 25)
    public RString katagakiSmall1;
    @ReportItem(name = "katagaki1", length = 18, order = 26)
    public RString katagaki1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 27)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei2", length = 18, order = 28)
    public RString shimei2;
    @ReportItem(name = "meishoFuyo2", length = 2, order = 29)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiText", order = 30)
    public RString shimeiText;
    @ReportItem(name = "shimeiSmall2", length = 26, order = 31)
    public RString shimeiSmall2;
    @ReportItem(name = "shimei1", length = 18, order = 32)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 2, order = 33)
    public RString meishoFuyo1;
    @ReportItem(name = "shimeiSmall1", length = 26, order = 34)
    public RString shimeiSmall1;
    @ReportItem(name = "samabunShimeiText", order = 35)
    public RString samabunShimeiText;
    @ReportItem(name = "samabunShimeiSmall2", length = 26, order = 36)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 37)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 18, order = 38)
    public RString samabunShimei2;
    @ReportItem(name = "samaBun2", length = 2, order = 39)
    public RString samaBun2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 40)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 41)
    public RString kakkoLeft1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 42)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 26, order = 43)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "samaBun1", length = 2, order = 44)
    public RString samaBun1;
    @ReportItem(name = "samabunShimei1", length = 18, order = 45)
    public RString samabunShimei1;
    @ReportItem(name = "customerBarCode", order = 46)
    public RString customerBarCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
