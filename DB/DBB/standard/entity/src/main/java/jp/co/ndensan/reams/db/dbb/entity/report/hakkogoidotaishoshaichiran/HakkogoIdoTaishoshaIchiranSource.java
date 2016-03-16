package jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *  通知書発行後異動把握帳票Source
 */
public class HakkogoIdoTaishoshaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "fukaNendo", length = 6, order = 3)
    public RString fukaNendo;
    @ReportItem(name = "tsuchishoName", length = 20, order = 4)
    public RString tsuchishoName;
    @ReportItem(name = "tsuchishoHakkoTimeStamp", length = 21, order = 5)
    public RString tsuchishoHakkoTimeStamp;
    @ReportItem(name = "lastCalculationTimeStamp", length = 21, order = 6)
    public RString lastCalculationTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 6, order = 7)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 8)
    public RString hokenshaName;
    @ReportItem(name = "listIdosha_1", length = 6, order = 9)
    public RString listIdosha_1;
    @ReportItem(name = "listIdosha_2", length = 10, order = 10)
    public RString listIdosha_2;
    @ReportItem(name = "listIdosha_3", length = 15, order = 11)
    public RString listIdosha_3;
    @ReportItem(name = "listIdosha_4", length = 20, order = 12)
    public RString listIdosha_4;
    @ReportItem(name = "listIdosha_5", length = 30, order = 13)
    public RString listIdosha_5;
    @ReportItem(name = "listIdosha_6", length = 9, order = 14)
    public RString listIdosha_6;
    @ReportItem(name = "listIdosha_7", length = 10, order = 15)
    public RString listIdosha_7;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
