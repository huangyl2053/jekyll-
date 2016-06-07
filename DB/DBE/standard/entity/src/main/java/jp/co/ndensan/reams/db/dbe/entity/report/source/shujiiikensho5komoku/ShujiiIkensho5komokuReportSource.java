package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書5項目確認一覧表のReportSourceです。
 *
 * @reamsid_L DBE-1390-170 suguangjun
 */
public class ShujiiIkensho5komokuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listIkengokomoku_1", length = 3, order = 4)
    public RString listIkengokomoku_1;
    @ReportItem(name = "listIkengokomoku_2", length = 6, order = 5)
    public RString listIkengokomoku_2;
    @ReportItem(name = "listIkengokomoku_3", length = 7, order = 6)
    public RString listIkengokomoku_3;
    @ReportItem(name = "listIkengokomoku_4", length = 20, order = 7)
    public RString listIkengokomoku_4;
    @ReportItem(name = "listIkengokomoku_5", length = 10, order = 8)
    public RString listIkengokomoku_5;
    @ReportItem(name = "listIkengokomoku_6", length = 9, order = 9)
    public RString listIkengokomoku_6;
    @ReportItem(name = "listIkengokomoku_7", length = 1, order = 10)
    public RString listIkengokomoku_7;
    @ReportItem(name = "listIkengokomoku_8", length = 9, order = 11)
    public RString listIkengokomoku_8;
    @ReportItem(name = "listIkengokomoku_9", length = 13, order = 12)
    public RString listIkengokomoku_9;
    @ReportItem(name = "listIkengokomoku_10", length = 4, order = 13)
    public RString listIkengokomoku_10;
    @ReportItem(name = "listIkengokomoku_11", length = 4, order = 14)
    public RString listIkengokomoku_11;
    @ReportItem(name = "listIkengokomoku_12", length = 6, order = 15)
    public RString listIkengokomoku_12;
    @ReportItem(name = "listIkengokomoku_13", length = 10, order = 16)
    public RString listIkengokomoku_13;
    @ReportItem(name = "listIkengokomoku_14", length = 16, order = 17)
    public RString listIkengokomoku_14;
    @ReportItem(name = "listIkengokomoku_15", length = 1, order = 18)
    public RString listIkengokomoku_15;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hokenshaNo;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNo;
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

        shichosonName
    }
}
