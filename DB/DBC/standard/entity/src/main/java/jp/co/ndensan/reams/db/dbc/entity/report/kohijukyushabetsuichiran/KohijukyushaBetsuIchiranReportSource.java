package jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 介護給付費公費受給者別一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
public class KohijukyushaBetsuIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shinsaYM", length = 8, order = 2)
    public RString shinsaYM;
    @ReportItem(name = "kohiFutanshaNo", length = 8, order = 3)
    public RString kohiFutanshaNo;
    @ReportItem(name = "kohiFutanshaName", length = 40, order = 4)
    public RString kohiFutanshaName;
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
    @ReportItem(name = "kokuhorenName", length = 15, order = 10)
    public RString kokuhorenName;
    @ReportItem(name = "kaiPege1", length = 20, order = 11)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 20, order = 12)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 20, order = 13)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 20, order = 14)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 20, order = 15)
    public RString kaiPege5;
    @ReportItem(name = "listUpper_1", length = 7, order = 16)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 7, order = 17)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 18)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 8, order = 19)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 8, order = 20)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 2, order = 21)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 16, order = 22)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 16, order = 23)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 15, order = 24)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 10, order = 25)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 6, order = 26)
    public RString listUpper_11;
    @ReportItem(name = "listLower_1", length = 20, order = 27)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 9, order = 28)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 9, order = 29)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 20, order = 30)
    public RString listLower_4;
    @ReportItem(name = "kohiTensuGokei", length = 16, order = 31)
    public RString kohiTensuGokei;
    @ReportItem(name = "kohiFutanGakuGokei", length = 16, order = 32)
    public RString kohiFutanGakuGokei;
    @ReportItem(name = "kohiHoninFutanGakuGokei", length = 15, order = 33)
    public RString kohiHoninFutanGakuGokei;
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

        kohiFutanshaNo
    }
// </editor-fold>
}
