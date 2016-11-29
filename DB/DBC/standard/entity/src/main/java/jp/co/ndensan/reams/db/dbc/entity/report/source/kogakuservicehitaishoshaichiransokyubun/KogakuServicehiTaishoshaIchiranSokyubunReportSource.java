// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehitaishoshaichiransokyubun;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBCMN41003_高額介護サービス費対象者一覧表（遡及分）のReportSourceクラスです。
 *
 * @reamsid_L DBC-5750-040 kanghongsong
 */
public class KogakuServicehiTaishoshaIchiranSokyubunReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaNo", length = 6, order = 1)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 2)
    public RString hokenshaName;
    @ReportItem(name = "pageCount", length = 6, order = 3)
    public RString pageCount;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 4)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 5)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 6)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 7)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 8)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 9)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 10)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 11)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 12)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 13)
    public RString kaipage5;
    @ReportItem(name = "printTimeStamp", length = 21, order = 14)
    public RString printTimeStamp;
    @ReportItem(name = "listTaishosha_1", length = 4, order = 15)
    public RString listTaishosha_1;
    @ReportItem(name = "listTaishosha_2", length = 10, order = 16)
    public RString listTaishosha_2;
    @ReportItem(name = "listTaishosha_3", length = 6, order = 17)
    public RString listTaishosha_3;
    @ReportItem(name = "listTaishosha_4", length = 10, order = 18)
    public RString listTaishosha_4;
    @ReportItem(name = "listTaishosha_5", length = 10, order = 19)
    public RString listTaishosha_5;
    @ReportItem(name = "listTaishosha_6", length = 1, order = 20)
    public RString listTaishosha_6;
    @ReportItem(name = "listTaishosha_7", length = 10, order = 21)
    public RString listTaishosha_7;
    @ReportItem(name = "listTaishosha_8", length = 1, order = 22)
    public RString listTaishosha_8;
    @ReportItem(name = "listTaishosha_9", length = 12, order = 23)
    public RString listTaishosha_9;
    @ReportItem(name = "listTaishosha_10", length = 46, order = 24)
    public RString listTaishosha_10;
    @ReportItem(name = "listTaishosha_11", length = 30, order = 25)
    public RString listTaishosha_11;
    @ReportItem(name = "listTaishosha_12", length = 30, order = 25)
    public RString listTaishosha_12;
    @ReportItem(name = "listTaishosha_13", length = 30, order = 25)
    public RString listTaishosha_13;
    @ReportItem(name = "listTaishosha_14", length = 30, order = 25)
    public RString listTaishosha_14;
    @ReportItem(name = "listTaishosha_15", length = 30, order = 25)
    public RString listTaishosha_15;
    @ReportItem(name = "listTaishosha_16", length = 30, order = 25)
    public RString listTaishosha_16;
    @ReportItem(name = "listTaishosha_17", length = 30, order = 25)
    public RString listTaishosha_17;
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
