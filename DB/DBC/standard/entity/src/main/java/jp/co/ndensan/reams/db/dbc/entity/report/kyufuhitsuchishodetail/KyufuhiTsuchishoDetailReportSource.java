package jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishodetail;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険給付費通知書(２ページ目以降)のReportSourceクラスです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 */
public class KyufuhiTsuchishoDetailReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaName", length = 22, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 10, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "shukeiserviceSTYM", length = 8, order = 3)
    public RString shukeiserviceSTYM;
    @ReportItem(name = "shukeiserviceEDYM", length = 8, order = 4)
    public RString shukeiserviceEDYM;
    @ReportItem(name = "listServiceIchiranUpper_1", length = 8, order = 5)
    public RString listServiceIchiranUpper_1;
    @ReportItem(name = "listServiceIchiranUpper_2", length = 15, order = 6)
    public RString listServiceIchiranUpper_2;
    @ReportItem(name = "listServiceIchiranUpper_3", length = 16, order = 7)
    public RString listServiceIchiranUpper_3;
    @ReportItem(name = "listServiceIchiranUpper_4", length = 3, order = 8)
    public RString listServiceIchiranUpper_4;
    @ReportItem(name = "listServiceIchiranUpper_5", length = 11, order = 9)
    public RString listServiceIchiranUpper_5;
    @ReportItem(name = "listServiceIchiranUpper_6", length = 11, order = 10)
    public RString listServiceIchiranUpper_6;
    @ReportItem(name = "listServiceIchiranLower_1", length = 15, order = 11)
    public RString listServiceIchiranLower_1;
    @ReportItem(name = "listServiceIchiranLower_2", length = 16, order = 12)
    public RString listServiceIchiranLower_2;
    @ReportItem(name = "tsuchibun1", length = 110, order = 13)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 110, order = 14)
    public RString tsuchibun2;
    @ReportItem(name = "pageBunshi", length = 3, order = 15)
    public RString pageBunshi;
    @ReportItem(name = "pageBunbo", length = 3, order = 16)
    public RString pageBunbo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
