package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiirai;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書依頼未処理者一覧表のReportSourceです。
 *
 * @reamsid_L DBE-1390-130 suguangjun
 */
public class ShujiiIkenshoMiIraiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listIkeniraimishori_1", length = 3, order = 4)
    public RString listIkeniraimishori_1;
    @ReportItem(name = "listIkeniraimishori_2", length = 6, order = 5)
    public RString listIkeniraimishori_2;
    @ReportItem(name = "listIkeniraimishori_3", length = 7, order = 6)
    public RString listIkeniraimishori_3;
    @ReportItem(name = "listIkeniraimishori_4", length = 20, order = 7)
    public RString listIkeniraimishori_4;
    @ReportItem(name = "listIkeniraimishori_5", length = 10, order = 8)
    public RString listIkeniraimishori_5;
    @ReportItem(name = "listIkeniraimishori_6", length = 9, order = 9)
    public RString listIkeniraimishori_6;
    @ReportItem(name = "listIkeniraimishori_7", length = 1, order = 10)
    public RString listIkeniraimishori_7;
    @ReportItem(name = "listIkeniraimishori_8", length = 9, order = 11)
    public RString listIkeniraimishori_8;
    @ReportItem(name = "listIkeniraimishori_9", length = 2, order = 12)
    public RString listIkeniraimishori_9;
    @ReportItem(name = "listIkeniraimishori_10", length = 40, order = 13)
    public RString listIkeniraimishori_10;
    @ReportItem(name = "listIkeniraimishori_11", length = 40, order = 14)
    public RString listIkeniraimishori_11;
    @ReportItem(name = "listIkeniraimishori_12", length = 40, order = 15)
    public RString listIkeniraimishori_12;
    @ReportItem(name = "listIkeniraimishori_13", length = 40, order = 16)
    public RString listIkeniraimishori_13;
    @ReportItem(name = "listIkeniraimishori_14", length = 40, order = 17)
    public RString listIkeniraimishori_14;
    @ReportItem(name = "listIkeniraimishori_15", length = 40, order = 18)
    public RString listIkeniraimishori_15;
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
}
