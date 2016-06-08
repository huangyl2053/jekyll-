package jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigoback;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書のReportSource
 *
 * @reamsid_L DBA-0540-700 suguangjun
 */
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
