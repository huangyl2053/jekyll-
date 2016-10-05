package jp.co.ndensan.reams.db.dbc.entity.report.jutakukaishuriyushosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書のReportSourceクラスです。
 *
 * @reamsid_L DBC-2850-040 lizhuoxuan
 */
public class JutakuKaishuRiyushoSakuseiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "sofusakiYubinNo", length = 8, order = 2)
    public RString sofusakiYubinNo;
    @ReportItem(name = "sofusakiJusho", order = 3)
    public RString sofusakiJusho;
    @ReportItem(name = "sofusakiShimei", order = 4)
    public RString sofusakiShimei;
    @ReportItem(name = "jigyoshoCustomerBarCode", order = 5)
    public RString jigyoshoCustomerBarCode;
    @ReportItem(name = "tsuchoBun", order = 6)
    public RString tsuchoBun;
    @ReportItem(name = "uketsukeYMD", length = 11, order = 7)
    public RString uketsukeYMD;
    @ReportItem(name = "ketteiYMD", length = 11, order = 8)
    public RString ketteiYMD;
    @ReportItem(name = "ketteiKekka", length = 3, order = 9)
    public RString ketteiKekka;
    @ReportItem(name = "tesuryo", length = 10, order = 10)
    public RString tesuryo;
    @ReportItem(name = "fushikyuRiyu", order = 11)
    public RString fushikyuRiyu;
    @ReportItem(name = "shiharaiHouhou", length = 8, order = 12)
    public RString shiharaiHouhou;
    @ReportItem(name = "shiharaiYoteiYMD", length = 11, order = 13)
    public RString shiharaiYoteiYMD;
    @ReportItem(name = "tsuchiBun", order = 14)
    public RString tsuchiBun;
    @ReportItem(name = "hakkoYMD", length = 12, order = 15)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 16)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "denshiKoin", order = 17)
    public RString denshiKoin;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 18)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 19)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 20)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 21)
    public RString koinShoryaku;
    @ReportItem(name = "choshaBushoName", length = 50, order = 22)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", length = 20, order = 23)
    public RString tantoName;
    @ReportItem(name = "yubinBango", length = 8, order = 24)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", length = 50, order = 25)
    public RString shozaichi;
    @ReportItem(name = "telNo", length = 20, order = 26)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 27)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 28)
    public RString naisenNo;
    @ReportItem(name = "faxNo", length = 20, order = 29)
    public RString faxNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
