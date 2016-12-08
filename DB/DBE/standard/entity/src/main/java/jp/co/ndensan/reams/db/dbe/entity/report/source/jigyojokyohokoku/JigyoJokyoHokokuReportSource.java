package jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定事業状況報告のReportSourceクラスです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
public class JigyoJokyoHokokuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "listJigyojokyoHokoku_1", length = 20, order = 1)
    public RString listJigyojokyoHokoku_1;
    @ReportItem(name = "listJigyojokyoHokoku_2", length = 5, order = 2)
    public RString listJigyojokyoHokoku_2;
    @ReportItem(name = "listJigyojokyoHokoku_3", length = 5, order = 3)
    public RString listJigyojokyoHokoku_3;
    @ReportItem(name = "listJigyojokyoHokoku_4", length = 5, order = 4)
    public RString listJigyojokyoHokoku_4;
    @ReportItem(name = "listJigyojokyoHokoku_5", length = 5, order = 5)
    public RString listJigyojokyoHokoku_5;
    @ReportItem(name = "listJigyojokyoHokoku_6", length = 5, order = 6)
    public RString listJigyojokyoHokoku_6;
    @ReportItem(name = "listJigyojokyoHokoku_7", length = 5, order = 7)
    public RString listJigyojokyoHokoku_7;
    @ReportItem(name = "listJigyojokyoHokoku_8", length = 5, order = 8)
    public RString listJigyojokyoHokoku_8;
    @ReportItem(name = "listJigyojokyoHokoku_9", length = 5, order = 9)
    public RString listJigyojokyoHokoku_9;
    @ReportItem(name = "listJigyojokyoHokoku_10", length = 5, order = 9)
    public RString listJigyojokyoHokoku_10;
    @ReportItem(name = "title", length = 20, order = 10)
    public RString title;
    @ReportItem(name = "jigyoTaishoYM", length = 20, order = 11)
    public RString jigyoTaishoYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 12)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 13)
    public RString hokenshaName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 14)
    public RString printTimeStamp;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        jigyoTaishoYM,

    }
}
