package jp.co.ndensan.reams.db.dbc.entity.report.riyojokyoichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200004_利用状況一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-3500-040 lizhuoxuan
 */
public class RiyoJokyoIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hokensahNo", length = 6, order = 2)
    public RString hokensahNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 3)
    public RString hokenshaName;
    @ReportItem(name = "kyuShichoson", length = 19, order = 4)
    public RString kyuShichoson;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaiPege1", length = 20, order = 10)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 20, order = 11)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 20, order = 12)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 20, order = 13)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 20, order = 14)
    public RString kaiPege5;
    @ReportItem(name = "list1Lower_1", length = 15, order = 15)
    public RString list1Lower_1;
    @ReportItem(name = "list1Upper_1", length = 10, order = 16)
    public RString list1Upper_1;
    @ReportItem(name = "list1Lower_2", length = 12, order = 17)
    public RString list1Lower_2;
    @ReportItem(name = "list1Upper_2", length = 25, order = 18)
    public RString list1Upper_2;
    @ReportItem(name = "list1Lower_3", length = 6, order = 19)
    public RString list1Lower_3;
    @ReportItem(name = "list1Upper_3", length = 2, order = 20)
    public RString list1Upper_3;
    @ReportItem(name = "list1Lower_4", length = 10, order = 21)
    public RString list1Lower_4;
    @ReportItem(name = "list1Upper_4", length = 4, order = 22)
    public RString list1Upper_4;
    @ReportItem(name = "list1Lower_5", length = 15, order = 23)
    public RString list1Lower_5;
    @ReportItem(name = "listGokeiJoho_1", length = 6, order = 24)
    public RString listGokeiJoho_1;
    @ReportItem(name = "listMeisaiJoho_1", length = 2, order = 25)
    public RString listMeisaiJoho_1;
    @ReportItem(name = "listGokeiJoho_2", length = 6, order = 26)
    public RString listGokeiJoho_2;
    @ReportItem(name = "listMeisaiJoho_2", length = 2, order = 27)
    public RString listMeisaiJoho_2;
    @ReportItem(name = "listGokeiJoho_3", length = 19, order = 28)
    public RString listGokeiJoho_3;
    @ReportItem(name = "listMeisaiJoho_3", length = 15, order = 29)
    public RString listMeisaiJoho_3;
    @ReportItem(name = "listRiyoJokyo1_1", length = 4, order = 30)
    public RString listRiyoJokyo1_1;
    @ReportItem(name = "listRiyoJokyo2_1", length = 4, order = 31)
    public RString listRiyoJokyo2_1;
    @ReportItem(name = "listRiyoJokyo3_1", length = 5, order = 32)
    public RString listRiyoJokyo3_1;
    @ReportItem(name = "listRiyoJokyo1_2", length = 4, order = 33)
    public RString listRiyoJokyo1_2;
    @ReportItem(name = "listRiyoJokyo2_2", length = 9, order = 34)
    public RString listRiyoJokyo2_2;
    @ReportItem(name = "listRiyoJokyo3_2", length = 11, order = 35)
    public RString listRiyoJokyo3_2;
    @ReportItem(name = "listRiyoJokyo1_3", length = 11, order = 36)
    public RString listRiyoJokyo1_3;
    @ReportItem(name = "listRiyoJokyo2_3", length = 11, order = 37)
    public RString listRiyoJokyo2_3;
    @ReportItem(name = "listRiyoJokyo3_3", length = 11, order = 38)
    public RString listRiyoJokyo3_3;
    @ReportItem(name = "listRiyoJokyo1_4", length = 11, order = 39)
    public RString listRiyoJokyo1_4;
    @ReportItem(name = "listRiyoJokyo2_4", length = 11, order = 40)
    public RString listRiyoJokyo2_4;
    @ReportItem(name = "listRiyoJokyo3_4", length = 11, order = 41)
    public RString listRiyoJokyo3_4;
    @ReportItem(name = "listRiyoJokyo1_5", length = 11, order = 42)
    public RString listRiyoJokyo1_5;
    @ReportItem(name = "listRiyoJokyo2_5", length = 11, order = 43)
    public RString listRiyoJokyo2_5;
    @ReportItem(name = "listRiyoJokyo3_5", length = 7, order = 44)
    public RString listRiyoJokyo3_5;
    @ReportItem(name = "listRiyoJokyo1_6", length = 3, order = 45)
    public RString listRiyoJokyo1_6;
    @ReportItem(name = "listRiyoJokyo2_6", length = 7, order = 46)
    public RString listRiyoJokyo2_6;
    @ReportItem(name = "listRiyoJokyo3_6", length = 7, order = 47)
    public RString listRiyoJokyo3_6;
    @ReportItem(name = "listRiyoJokyo1_7", length = 7, order = 48)
    public RString listRiyoJokyo1_7;
    @ReportItem(name = "listRiyoJokyo2_7", length = 7, order = 49)
    public RString listRiyoJokyo2_7;
    @ReportItem(name = "listRiyoJokyo3_7", length = 4, order = 50)
    public RString listRiyoJokyo3_7;
    @ReportItem(name = "listRiyoJokyo1_8", length = 7, order = 51)
    public RString listRiyoJokyo1_8;
    @ReportItem(name = "listRiyoJokyo2_8", length = 4, order = 52)
    public RString listRiyoJokyo2_8;
    @ReportItem(name = "listRiyoJokyo1_9", length = 4, order = 53)
    public RString listRiyoJokyo1_9;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokennshaNo;
}
