package jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護事業状況報告月報・一般状況（別紙） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
public class JigyohokokuGeppoYoshikiBesshiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shukeiKubun", length = 4, order = 1)
    public RString shukeiKubun;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "shuukeiHani", length = 40, order = 3)
    public RString shuukeiHani;
    @ReportItem(name = "hokenshaNo", length = 12, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 13, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "komokuHyodaiRetsu1", length = 16, order = 6)
    public RString komokuHyodaiRetsu1;
    @ReportItem(name = "komokuHyodaiRetsu2", length = 16, order = 7)
    public RString komokuHyodaiRetsu2;
    @ReportItem(name = "komokuHyodaiRetsu3", length = 16, order = 8)
    public RString komokuHyodaiRetsu3;
    @ReportItem(name = "komokuHyodaiRetsu4", length = 16, order = 9)
    public RString komokuHyodaiRetsu4;
    @ReportItem(name = "list_1", length = 11, order = 10)
    public RString list_1;
    @ReportItem(name = "list_2", length = 11, order = 11)
    public RString list_2;
    @ReportItem(name = "list_3", length = 11, order = 12)
    public RString list_3;
    @ReportItem(name = "list_4", length = 11, order = 13)
    public RString list_4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
