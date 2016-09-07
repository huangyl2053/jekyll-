package jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC200090_負担割合証発行一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
public class FutanWariaiShoHakkoIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 23, order = 2)
    public RString nendo;
    @ReportItem(name = "joken", length = 23, order = 3)
    public RString joken;
    @ReportItem(name = "chushutsuKikanKaishi", length = 23, order = 4)
    public RString chushutsuKikanKaishi;
    @ReportItem(name = "chushutsuKikanShuryo", length = 23, order = 5)
    public RString chushutsuKikanShuryo;
    @ReportItem(name = "hakkoKubun", length = 23, order = 6)
    public RString hakkoKubun;
    @ReportItem(name = "kofuYmd", length = 23, order = 7)
    public RString kofuYmd;
    @ReportItem(name = "cityCode", length = 6, order = 8)
    public RString cityCode;
    @ReportItem(name = "cityName", length = 12, order = 9)
    public RString cityName;
    @ReportItem(name = "sort1", length = 10, order = 10)
    public RString sort1;
    @ReportItem(name = "sort2", length = 10, order = 11)
    public RString sort2;
    @ReportItem(name = "sort3", length = 10, order = 12)
    public RString sort3;
    @ReportItem(name = "sort4", length = 10, order = 13)
    public RString sort4;
    @ReportItem(name = "sort5", length = 10, order = 14)
    public RString sort5;
    @ReportItem(name = "listFutanWariaisho_1", length = 6, order = 15)
    public RString listFutanWariaisho_1;
    @ReportItem(name = "listFutanWariaisho_2", length = 10, order = 16)
    public RString listFutanWariaisho_2;
    @ReportItem(name = "listFutanWariaisho_3", length = 10, order = 17)
    public RString listFutanWariaisho_3;
    @ReportItem(name = "listFutanWariaisho_4", length = 25, order = 18)
    public RString listFutanWariaisho_4;
    @ReportItem(name = "listFutanWariaisho_5", length = 9, order = 19)
    public RString listFutanWariaisho_5;
    @ReportItem(name = "listFutanWariaisho_6", length = 9, order = 20)
    public RString listFutanWariaisho_6;
    @ReportItem(name = "listFutanWariaisho_7", length = 9, order = 21)
    public RString listFutanWariaisho_7;
    @ReportItem(name = "listFutanWariaisho_8", length = 3, order = 22)
    public RString listFutanWariaisho_8;
    @ReportItem(name = "listFutanWariaisho_9", length = 4, order = 23)
    public RString listFutanWariaisho_9;
    @ReportItem(name = "listFutanWariaisho_10", length = 3, order = 24)
    public RString listFutanWariaisho_10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
