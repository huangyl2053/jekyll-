package jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 認定調査依頼履歴一覧表Sourceクラスです。
 *
 * @reamsid_L DBE-1590-031 sunhaidi
 */
public class ChosairairirekiIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "listChokkinKubun_1", length = 2, order = 2)
    public RString listChokkinKubun_1;
    @ReportItem(name = "listHihokenshaNo_1", length = 10, order = 3)
    public RString listHihokenshaNo_1;
    @ReportItem(name = "listHihokenshaKana_1", length = 30, order = 4)
    public RString listHihokenshaKana_1;
    @ReportItem(name = "listHihokenshaJusho_1", length = 50, order = 5)
    public RString listHihokenshaJusho_1;
    @ReportItem(name = "listChosakikanName_1", length = 30, order = 6)
    public RString listChosakikanName_1;
    @ReportItem(name = "listChosairaiYMD_1", length = 9, order = 7)
    public RString listChosairaiYMD_1;
    @ReportItem(name = "listShinseiKubun_1", length = 2, order = 8)
    public RString listShinseiKubun_1;
    @ReportItem(name = "listHihokenshaName_1", length = 20, order = 9)
    public RString listHihokenshaName_1;
    @ReportItem(name = "listChosainName_1", length = 30, order = 10)
    public RString listChosainName_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;
}
