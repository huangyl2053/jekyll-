// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigoback;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tsuchiBun", order = 1)
    public RString tsuchiBun;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 2)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
