package jp.co.ndensan.reams.db.dbc.entity.report.seikyumeisai;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 請求明細・給付管理票返戻（保留）一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-2830-030 xuyannan
 */
public class SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYM", length = 8, order = 2)
    public RString shinsaYM;
    @ReportItem(name = "shoHokenshaNo", length = 6, order = 3)
    public RString shoHokenshaNo;
    @ReportItem(name = "shoHokenshaName", length = 12, order = 4)
    public RString shoHokenshaName;
    @ReportItem(name = "kokuhorenName", length = 15, order = 5)
    public RString kokuhorenName;
    @ReportItem(name = "listUpper_1", length = 4, order = 6)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 10, order = 7)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 8)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 1, order = 9)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 6, order = 10)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 2, order = 11)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 10, order = 12)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 1, order = 13)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 105, order = 14)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 4, order = 15)
    public RString listUpper_10;
    @ReportItem(name = "listLower_1", length = 15, order = 16)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 10, order = 17)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 4, order = 18)
    public RString listLower_3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shoHokenshaNo
    }
// </editor-fold>
}
