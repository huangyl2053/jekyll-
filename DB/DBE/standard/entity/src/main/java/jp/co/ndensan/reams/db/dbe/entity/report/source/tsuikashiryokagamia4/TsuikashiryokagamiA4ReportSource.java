package jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 追加資料鑑（A4版）のReportSource
 *
 * @reamsid_L DBE-0150-420 wangrenze
 */
public class TsuikashiryokagamiA4ReportSource implements IReportSource {

// <editor-fold defaultstate="collapsed" desc="Generated Code">
    @ReportItem(name = "shinsakaiNo", length = 4, order = 1)
    public RString shinsakaiNo;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 21, order = 2)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "ShinsainName1", length = 20, order = 3)
    public RString shinsainName1;
    @ReportItem(name = "ShinsainName2", length = 20, order = 4)
    public RString shinsainName2;
    @ReportItem(name = "gogitaiNo", length = 2, order = 5)
    public RString gogitaiNo;
    @ReportItem(name = "ShinsainName3", length = 20, order = 6)
    public RString shinsainName3;
    @ReportItem(name = "shinsakaiTsuikasha", length = 2, order = 7)
    public RString shinsakaiTsuikasha;
    @ReportItem(name = "ShinsainName4", length = 20, order = 8)
    public RString shinsainName4;
    @ReportItem(name = "ShinsainName5", length = 20, order = 9)
    public RString shinsainName5;
    @ReportItem(name = "ShinsainName6", length = 20, order = 10)
    public RString shinsainName6;
    @ReportItem(name = "ShinsainName7", length = 20, order = 11)
    public RString shinsainName7;
    @ReportItem(name = "ShinsainName8", length = 20, order = 12)
    public RString shinsainName8;
    @ReportItem(name = "tsuchibun", order = 13)
    public RString tsuchibun;
    @ReportItem(name = "listShinsei_1", length = 2, order = 14)
    public RString listShinsei_1;
    @ReportItem(name = "listShinsei_2", length = 6, order = 15)
    public RString listShinsei_2;
    @ReportItem(name = "listShinsei_3", length = 10, order = 16)
    public RString listShinsei_3;
    @ReportItem(name = "listShinsei_4", length = 30, order = 17)
    public RString listShinsei_4;
    @ReportItem(name = "listShinsei_5", length = 1, order = 18)
    public RString listShinsei_5;
    @ReportItem(name = "listShinsei_6", length = 3, order = 19)
    public RString listShinsei_6;
    @ReportItem(name = "listShinsei_7", length = 3, order = 20)
    public RString listShinsei_7;
    @ReportItem(name = "listShinsei_8", length = 4, order = 21)
    public RString listShinsei_8;
    @ReportItem(name = "listShinsei_9", length = 7, order = 22)
    public RString listShinsei_9;
    @ReportItem(name = "listShinsei_10", length = 1, order = 23)
    public RString listShinsei_10;
    @ReportItem(name = "listShinsei_11", length = 5, order = 24)
    public RString listShinsei_11;
    @ReportItem(name = "listShinsei_12", length = 3, order = 25)
    public RString listShinsei_12;
    @ReportItem(name = "listShinsei_13", length = 4, order = 26)
    public RString listShinsei_13;
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

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shinsakaiNo,
    }
}
