package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshumeisai;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBE622001_主治医意見書作成報酬支払明細書のReportSourceです。
 *
 * @reamsid_L DBE-1980-044 xuyongchao
 */
public class ShujiiHoshumeisaiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 25, order = 1)
    public RString title;
    @ReportItem(name = "taishoKikan", length = 25, order = 2)
    public RString taishoKikan;
    @ReportItem(name = "hokenshaName", length = 20, order = 3)
    public RString hokenshaName;
    @ReportItem(name = "iryokikanName", length = 40, order = 4)
    public RString iryokikanName;
    @ReportItem(name = "ishiName", length = 20, order = 5)
    public RString ishiName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 6)
    public RString printTimeStamp;
    @ReportItem(name = "listIkenshosakuseiryo_1", length = 2, order = 7)
    public RString listIkenshosakuseiryo_1;
    @ReportItem(name = "listIkenshosakuseiryo_2", length = 10, order = 8)
    public RString listIkenshosakuseiryo_2;
    @ReportItem(name = "listIkenshosakuseiryo_3", length = 20, order = 9)
    public RString listIkenshosakuseiryo_3;
    @ReportItem(name = "listIkenshosakuseiryo_4", length = 9, order = 10)
    public RString listIkenshosakuseiryo_4;
    @ReportItem(name = "listIkenshosakuseiryo_5", length = 9, order = 11)
    public RString listIkenshosakuseiryo_5;
    @ReportItem(name = "listIkenshosakuseiryo_6", length = 1, order = 12)
    public RString listIkenshosakuseiryo_6;
    @ReportItem(name = "listIkenshosakuseiryo_7", length = 1, order = 13)
    public RString listIkenshosakuseiryo_7;
    @ReportItem(name = "listIkenshosakuseiryo_8", length = 1, order = 14)
    public RString listIkenshosakuseiryo_8;
    @ReportItem(name = "listIkenshosakuseiryo_9", length = 1, order = 15)
    public RString listIkenshosakuseiryo_9;
    @ReportItem(name = "listIkenshosakuseiryo_10", length = 5, order = 16)
    public RString listIkenshosakuseiryo_10;
    @ReportItem(name = "listGokeikensu_1", length = 3, order = 17)
    public RString listGokeikensu_1;
    @ReportItem(name = "listGokeikensu_2", length = 3, order = 18)
    public RString listGokeikensu_2;
    @ReportItem(name = "listGokeikensu_3", length = 3, order = 19)
    public RString listGokeikensu_3;
    @ReportItem(name = "listGokeikensu_4", length = 3, order = 20)
    public RString listGokeikensu_4;
    @ReportItem(name = "gokeiKingaku", length = 9, order = 21)
    public RString gokeiKingaku;
    @ReportItem(name = "shouhiZei", length = 9, order = 22)
    public RString shouhiZei;
    @ReportItem(name = "gokeiSeikyuKingaku", length = 9, order = 23)
    public RString gokeiSeikyuKingaku;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNo;
    @ReportItem(name = "shujiiCode", length = 40, order = 24)
    public RString shujiiCode;
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

        iryokikanName,
        shujiiCode
    }
}
