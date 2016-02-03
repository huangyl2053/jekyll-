package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class ShinsaschedulekagamiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD", length = 12, order = 1)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 4)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 5)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 6)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 7)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 8)
    public RString koinMojiretsu;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "title", length = 50, order = 10)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 11)
    public RString tsuchibun1;
    @ReportItem(name = "shoriMikomiKaishiYMD", length = 11, order = 12)
    public RString shoriMikomiKaishiYMD;
    @ReportItem(name = "shoriMikomiShuryoYMD", length = 11, order = 13)
    public RString shoriMikomiShuryoYMD;
    @ReportItem(name = "tsuchibun2", order = 14)
    public RString tsuchibun2;
    @ReportItem(name = "remban", length = 4, order = 15)
    public RString remban;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
