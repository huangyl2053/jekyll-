package jp.co.ndensan.reams.db.dbc.entity.report.dbc200061;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMNJ2006_サービスコード一覧表のsource
 *
 * @reamsid_L DBC-3310-040 jiangxiaolong
 */
public class ServiceCodeIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hokenshaNo", length = 8, order = 1)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 8, order = 2)
    public RString hokenshaName;
    @ReportItem(name = "kijunYM", length = 8, order = 3)
    public RString kijunYM;
    @ReportItem(name = "chushutsuJoken", length = 100, order = 4)
    public RString chushutsuJoken;
    @ReportItem(name = "serviceShurui", length = 15, order = 5)
    public RString serviceShurui;
    @ReportItem(name = "printTimeStamp", length = 21, order = 6)
    public RString printTimeStamp;
    @ReportItem(name = "List1_1", length = 2, order = 7)
    public RString List1_1;
    @ReportItem(name = "List1_2", length = 4, order = 8)
    public RString List1_2;
    @ReportItem(name = "List1_3", length = 30, order = 9)
    public RString List1_3;
    @ReportItem(name = "List1_4", length = 6, order = 10)
    public RString List1_4;
    @ReportItem(name = "List1_5", length = 6, order = 11)
    public RString List1_5;
    @ReportItem(name = "List1_6", length = 7, order = 12)
    public RString List1_6;
    @ReportItem(name = "List1_7", length = 2, order = 13)
    public RString List1_7;
    @ReportItem(name = "List1_8", length = 4, order = 14)
    public RString List1_8;
    @ReportItem(name = "List1_9", length = 3, order = 15)
    public RString List1_9;
    @ReportItem(name = "List1_10", length = 6, order = 16)
    public RString List1_10;
    @ReportItem(name = "List1_11", length = 1, order = 17)
    public RString List1_11;
    @ReportItem(name = "List1_12", length = 1, order = 18)
    public RString List1_12;
    @ReportItem(name = "List1_13", length = 1, order = 19)
    public RString List1_13;
    @ReportItem(name = "List1_14", length = 1, order = 20)
    public RString List1_14;
    @ReportItem(name = "List1_15", length = 2, order = 21)
    public RString List1_15;
    @ReportItem(name = "List1_16", length = 2, order = 22)
    public RString List1_16;
    @ReportItem(name = "List1_17", length = 2, order = 23)
    public RString List1_17;
    @ReportItem(name = "List2_1", length = 7, order = 24)
    public RString List2_1;
    @ReportItem(name = "List2_2", length = 2, order = 25)
    public RString List2_2;
    @ReportItem(name = "List2_3", length = 2, order = 26)
    public RString List2_3;
    @ReportItem(name = "taniSetsumei", length = 150, order = 27)
    public RString taniSetsumei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * ServiceCodeIchiranSourceのENUM
     */
    public enum ReportSourceFields {

        hokenshaNo,
        hokenshaName,
        kijunYM,
        chushutsuJoken,
        serviceShurui,
        printTimeStamp,
        List1_1,
        List1_2,
        List1_3,
        List1_4,
        List1_5,
        List1_6,
        List1_7,
        List1_8,
        List1_9,
        List1_10,
        List1_11,
        List1_12,
        List1_13,
        List1_14,
        List1_15,
        List1_16,
        List1_17,
        List2_1,
        List2_2,
        List2_3,
        taniSetsumei
    }
}
