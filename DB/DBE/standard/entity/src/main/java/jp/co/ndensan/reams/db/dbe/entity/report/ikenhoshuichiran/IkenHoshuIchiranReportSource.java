package jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 主治医意見書作成報酬一覧表のReportSourceです。
 *
 * @reamsid_L DBE-1930-030 chenxiangyu
 */
public class IkenHoshuIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "iryokikanNo", length = 12, order = 2)
    public RString iryokikanNo;
    @ReportItem(name = "chushutsuKikan", length = 19, order = 3)
    public RString chushutsuKikan;
    @ReportItem(name = "iryokikanName", length = 40, order = 4)
    public RString iryokikanName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "listIkenshosakuseiryo_1", length = 3, order = 6)
    public RString listIkenshosakuseiryo_1;
    @ReportItem(name = "listIkenshosakuseiryo_2", length = 8, order = 7)
    public RString listIkenshosakuseiryo_2;
    @ReportItem(name = "listIkenshosakuseiryo_3", length = 20, order = 8)
    public RString listIkenshosakuseiryo_3;
    @ReportItem(name = "listIkenshosakuseiryo_4", length = 9, order = 9)
    public RString listIkenshosakuseiryo_4;
    @ReportItem(name = "listIkenshosakuseiryo_5", length = 9, order = 10)
    public RString listIkenshosakuseiryo_5;
    @ReportItem(name = "listIkenshosakuseiryo_6", length = 9, order = 11)
    public RString listIkenshosakuseiryo_6;
    @ReportItem(name = "listIkenshosakuseiryo_7", length = 1, order = 12)
    public RString listIkenshosakuseiryo_7;
    @ReportItem(name = "listIkenshosakuseiryo_8", length = 6, order = 13)
    public RString listIkenshosakuseiryo_8;
    @ReportItem(name = "listIkenshosakuseiryo_9", length = 10, order = 14)
    public RString listIkenshosakuseiryo_9;
    @ReportItem(name = "listIkenshosakuseiryo_10", length = 30, order = 15)
    public RString listIkenshosakuseiryo_10;
    @ReportItem(name = "listIkenshosakuseiryo_11", length = 1, order = 16)
    public RString listIkenshosakuseiryo_11;
    @ReportItem(name = "listIkenshosakuseiryo_12", length = 1, order = 17)
    public RString listIkenshosakuseiryo_12;
    @ReportItem(name = "listIkenshosakuseiryo_13", length = 1, order = 18)
    public RString listIkenshosakuseiryo_13;
    @ReportItem(name = "listIkenshosakuseiryo_14", length = 1, order = 19)
    public RString listIkenshosakuseiryo_14;
    @ReportItem(name = "listIkenshosakuseiryo_15", length = 7, order = 20)
    public RString listIkenshosakuseiryo_15;
    @ReportItem(name = "listIkenshosakuseiryo_16", length = 10, order = 21)
    public RString listIkenshosakuseiryo_16;
    @ReportItem(name = "listIkenshosakuseiryo_17", length = 10, order = 22)
    public RString listIkenshosakuseiryo_17;
    @ReportItem(name = "listGokei_1", length = 4, order = 23)
    public RString listGokei_1;
    @ReportItem(name = "listGokei_2", length = 4, order = 24)
    public RString listGokei_2;
    @ReportItem(name = "listGokei_3", length = 4, order = 25)
    public RString listGokei_3;
    @ReportItem(name = "listGokei_4", length = 4, order = 26)
    public RString listGokei_4;
    @ReportItem(name = "listGokei_5", length = 11, order = 27)
    public RString listGokei_5;
    @ReportItem(name = "listGokei_6", length = 11, order = 28)
    public RString listGokei_6;
    @ReportItem(name = "listGokei_7", length = 11, order = 29)
    public RString listGokei_7;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        iryokikanNo,
    }
}
