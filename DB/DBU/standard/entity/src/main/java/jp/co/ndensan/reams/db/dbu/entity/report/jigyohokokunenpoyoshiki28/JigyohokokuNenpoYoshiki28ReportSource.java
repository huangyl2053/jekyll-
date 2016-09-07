package jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki28;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事業状況報告年報（様式１・２　市町村特別給付）ReportSourceのクラスです。
 *
 * @reamsid_L DBU-5610-050 yaoyahui
 */
public class JigyohokokuNenpoYoshiki28ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yoshiki", length = 7, order = 1)
    public RString yoshiki;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "shukeiKubun", length = 4, order = 3)
    public RString shukeiKubun;
    @ReportItem(name = "shuukeiHani", length = 40, order = 4)
    public RString shuukeiHani;
    @ReportItem(name = "hokenshaNo", length = 6, order = 5)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 13, order = 6)
    public RString hokenshaName;
    @ReportItem(name = "hyoTitle", length = 68, order = 7)
    public RString hyoTitle;
    @ReportItem(name = "hyoSubTitle", length = 68, order = 8)
    public RString hyoSubTitle;
    @ReportItem(name = "list_1", length = 15, order = 9)
    public RString list_1;
    @ReportItem(name = "list_2", length = 12, order = 10)
    public RString list_2;
    @ReportItem(name = "list_3", length = 12, order = 11)
    public RString list_3;
    @ReportItem(name = "list_4", length = 12, order = 12)
    public RString list_4;
    @ReportItem(name = "list_5", length = 12, order = 13)
    public RString list_5;
    @ReportItem(name = "list_6", length = 12, order = 14)
    public RString list_6;
    @ReportItem(name = "list_7", length = 12, order = 15)
    public RString list_7;
    @ReportItem(name = "list_8", length = 12, order = 16)
    public RString list_8;
    @ReportItem(name = "list_9", length = 12, order = 17)
    public RString list_9;
    @ReportItem(name = "list_10", length = 12, order = 18)
    public RString list_10;
    @ReportItem(name = "list_11", length = 12, order = 19)
    public RString list_11;
    @ReportItem(name = "list_12", length = 12, order = 20)
    public RString list_12;
    @ReportItem(name = "jijifanhao", length = 13, order = 21)
    public RString jijifanhao;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
