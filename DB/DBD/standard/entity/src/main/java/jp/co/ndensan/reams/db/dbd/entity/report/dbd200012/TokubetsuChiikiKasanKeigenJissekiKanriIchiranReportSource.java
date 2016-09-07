package jp.co.ndensan.reams.db.dbd.entity.report.dbd200012;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 特別地域加算軽減実績管理リストのReportSource
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public class TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 3)
    public RString hokenshaName;
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
    @ReportItem(name = "kaiPege1", length = 20, order = 9)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 20, order = 10)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 20, order = 11)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 20, order = 12)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 20, order = 13)
    public RString kaiPege5;
    @ReportItem(name = "list_1", length = 16, order = 14)
    public RString list_1;
    @ReportItem(name = "list_2", length = 11, order = 15)
    public RString list_2;
    @ReportItem(name = "list_3", length = 20, order = 16)
    public RString list_3;
    @ReportItem(name = "list_4", length = 6, order = 17)
    public RString list_4;
    @ReportItem(name = "list_5", length = 1, order = 18)
    public RString list_5;
    @ReportItem(name = "list_6", length = 2, order = 19)
    public RString list_6;
    @ReportItem(name = "list_7", length = 2, order = 20)
    public RString list_7;
    @ReportItem(name = "list_8", length = 4, order = 21)
    public RString list_8;
    @ReportItem(name = "list_9", length = 30, order = 22)
    public RString list_9;
    @ReportItem(name = "list_10", length = 5, order = 23)
    public RString list_10;
    @ReportItem(name = "list_11", length = 2, order = 24)
    public RString list_11;
    @ReportItem(name = "list_12", length = 7, order = 25)
    public RString list_12;
    @ReportItem(name = "list_13", length = 13, order = 26)
    public RString list_13;
    @ReportItem(name = "list_14", length = 12, order = 27)
    public RString list_14;
    @ReportItem(name = "list_15", length = 1, order = 28)
    public RString list_15;
    @ReportItem(name = "list_16", length = 11, order = 29)
    public RString list_16;
    @ReportItem(name = "list_17", length = 11, order = 30)
    public RString list_17;
    @ReportItem(name = "list_18", length = 11, order = 31)
    public RString list_18;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "title", order = 32)
    public RString title;
// </editor-fold>
}
