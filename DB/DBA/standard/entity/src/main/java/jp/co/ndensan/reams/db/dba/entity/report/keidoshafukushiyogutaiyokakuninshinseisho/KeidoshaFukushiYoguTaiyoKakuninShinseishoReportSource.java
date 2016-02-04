// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tsuchiBun1", order = 1)
    public RString tsuchiBun1;
    @ReportItem(name = "jusho", order = 2)
    public RString jusho;
    @ReportItem(name = "shimei", order = 3)
    public RString shimei;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 4)
    public RString hihokenshaNo;
    @ReportItem(name = "tsuchiBun2", order = 5)
    public RString tsuchiBun2;
    @ReportItem(name = "remban", length = 4, order = 6)
    public RString remban;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 7)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
