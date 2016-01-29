// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class BemmeisyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sofusakiYubinNo", length = 8, order = 1)
    public RString sofusakiYubinNo;
    @ReportItem(name = "sofusakiJusho", order = 2)
    public RString sofusakiJusho;
    @ReportItem(name = "sofusakiName", order = 3)
    public RString sofusakiName;
    @ReportItem(name = "bemmeisyoSakuseiYMD", length = 16, order = 4)
    public RString bemmeisyoSakuseiYMD;
    @ReportItem(name = "midashi", order = 5)
    public RString midashi;
    @ReportItem(name = "bemmeisyoName", length = 18, order = 6)
    public RString bemmeisyoName;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 7)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 8)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaYubinNo", length = 8, order = 9)
    public RString hihokenshaYubinNo;
    @ReportItem(name = "hihokenshaJusho", order = 10)
    public RString hihokenshaJusho;
    @ReportItem(name = "birthYMD", length = 11, order = 11)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 12)
    public RString seibetsu;
    @ReportItem(name = "bemmeiNaiyo", order = 13)
    public RString bemmeiNaiyo;
    @ReportItem(name = "denshiKoin", order = 14)
    public RString denshiKoin;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 15)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 16)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 17)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 18)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 19)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
