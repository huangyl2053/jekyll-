package jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkajohoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定判定結果一覧表Sourceクラスです。
 *
 * @reamsid_L DBE-0170-020 wangkun
 */
public class HanteiKekkaIchiranA4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 15, order = 1)
    public RString title;
    @ReportItem(name = "hakkoYMD", length = 21, order = 2)
    public RString hakkoYMD;
    @ReportItem(name = "pageCount1", length = 10, order = 3)
    public RString pageCount1;
    @ReportItem(name = "taishoHokenshaName", length = 20, order = 4)
    public RString taishoHokenshaName;
    @ReportItem(name = "listYukokikan_1", length = 4, order = 5)
    public RString listYukokikan_1;
    @ReportItem(name = "listYukokikan_2", length = 2, order = 6)
    public RString listYukokikan_2;
    @ReportItem(name = "listHokenshaNo_1", length = 6, order = 7)
    public RString listHokenshaNo_1;
    @ReportItem(name = "listNo_1", length = 3, order = 8)
    public RString listNo_1;
    @ReportItem(name = "listNo_2", length = 3, order = 9)
    public RString listNo_2;
    @ReportItem(name = "listNo_3", length = 2, order = 10)
    public RString listNo_3;
    @ReportItem(name = "listNo_4", length = 2, order = 11)
    public RString listNo_4;
    @ReportItem(name = "listNo_5", length = 9, order = 12)
    public RString listNo_5;
    @ReportItem(name = "listNo_6", length = 9, order = 13)
    public RString listNo_6;
    @ReportItem(name = "listHihokenshaNo_1", length = 10, order = 14)
    public RString listHihokenshaNo_1;
    @ReportItem(name = "listHihokenshaNo_2", length = 40, order = 15)
    public RString listHihokenshaNo_2;
    @ReportItem(name = "listHihokenshaNo_3", length = 5, order = 16)
    public RString listHihokenshaNo_3;
    @ReportItem(name = "listHihokenshaNo_4", length = 5, order = 17)
    public RString listHihokenshaNo_4;
    @ReportItem(name = "listHihokenshaNo_5", length = 6, order = 18)
    public RString listHihokenshaNo_5;
    @ReportItem(name = "listHihokenshaNo_6", length = 6, order = 19)
    public RString listHihokenshaNo_6;
    @ReportItem(name = "listHihokenshaNo_7", length = 2, order = 20)
    public RString listHihokenshaNo_7;
    @ReportItem(name = "listShinsakaiiken_1", length = 100, order = 21)
    public RString listShinsakaiiken_1;
    @ReportItem(name = "listHokenshaName_1", length = 7, order = 22)
    public RString listHokenshaName_1;
    @ReportItem(name = "listTokuteishippei_1", length = 19, order = 23)
    public RString listTokuteishippei_1;
    @ReportItem(name = "listTokuteishippei_2", length = 30, order = 24)
    public RString listTokuteishippei_2;
    @ReportItem(name = "reportID", length = 8, order = 25)
    public RString reportID;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
