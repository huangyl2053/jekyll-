package jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定申請モニタリストのReportSourceです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
public class ShinseiMonitorReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listShinseimonita_1", length = 3, order = 4)
    public RString listShinseimonita_1;
    @ReportItem(name = "listShinseimonita_2", length = 6, order = 5)
    public RString listShinseimonita_2;
    @ReportItem(name = "listShinseimonita_3", length = 7, order = 6)
    public RString listShinseimonita_3;
    @ReportItem(name = "listShinseimonita_4", length = 20, order = 7)
    public RString listShinseimonita_4;
    @ReportItem(name = "listShinseimonita_5", length = 10, order = 8)
    public RString listShinseimonita_5;
    @ReportItem(name = "listShinseimonita_6", length = 9, order = 9)
    public RString listShinseimonita_6;
    @ReportItem(name = "listShinseimonita_7", length = 1, order = 10)
    public RString listShinseimonita_7;
    @ReportItem(name = "listShinseimonita_8", length = 13, order = 11)
    public RString listShinseimonita_8;
    @ReportItem(name = "listShinseimonita_9", length = 3, order = 12)
    public RString listShinseimonita_9;
    @ReportItem(name = "listShinseimonita_10", length = 2, order = 13)
    public RString listShinseimonita_10;
    @ReportItem(name = "listShinseimonita_11", length = 9, order = 14)
    public RString listShinseimonita_11;
    @ReportItem(name = "listShinseimonita_12", length = 9, order = 15)
    public RString listShinseimonita_12;
    @ReportItem(name = "listShinseimonita_13", length = 9, order = 16)
    public RString listShinseimonita_13;
    @ReportItem(name = "listShinseimonita_14", length = 2, order = 17)
    public RString listShinseimonita_14;
    @ReportItem(name = "listShinseimonita_15", length = 9, order = 18)
    public RString listShinseimonita_15;
    @ReportItem(name = "listShinseimonita_16", length = 20, order = 19)
    public RString listShinseimonita_16;
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
