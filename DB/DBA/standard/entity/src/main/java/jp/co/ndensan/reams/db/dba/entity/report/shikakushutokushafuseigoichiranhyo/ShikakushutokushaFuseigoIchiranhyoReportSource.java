package jp.co.ndensan.reams.db.dba.entity.report.shikakushutokushafuseigoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 資格取得者不整合リストのReportSourceクラスです。
 *
 * @reamsid_L DBU-4020-040 lishengli
 */
public class ShikakushutokushaFuseigoIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 50, order = 2)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 4)
    public RString shichosonName;
    @ReportItem(name = "listMaeJusho_1", length = 30, order = 5)
    public RString listMaeJusho_1;
    @ReportItem(name = "listShimeiKana_1", length = 20, order = 6)
    public RString listShimeiKana_1;
    @ReportItem(name = "listHihokensha_1", length = 10, order = 7)
    public RString listHihokensha_1;
    @ReportItem(name = "listHihokensha_2", length = 15, order = 8)
    public RString listHihokensha_2;
    @ReportItem(name = "listHihokensha_3", length = 10, order = 9)
    public RString listHihokensha_3;
    @ReportItem(name = "listHihokensha_4", length = 6, order = 10)
    public RString listHihokensha_4;
    @ReportItem(name = "listHihokensha_5", length = 2, order = 11)
    public RString listHihokensha_5;
    @ReportItem(name = "listHihokensha_6", length = 1, order = 12)
    public RString listHihokensha_6;
    @ReportItem(name = "listHihokensha_7", length = 12, order = 13)
    public RString listHihokensha_7;
    @ReportItem(name = "listShimei_1", length = 10, order = 14)
    public RString listShimei_1;
    @ReportItem(name = "listGenJusho_1", length = 30, order = 15)
    public RString listGenJusho_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
