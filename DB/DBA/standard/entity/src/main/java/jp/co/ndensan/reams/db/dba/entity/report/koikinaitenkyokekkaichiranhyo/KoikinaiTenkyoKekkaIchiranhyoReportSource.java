package jp.co.ndensan.reams.db.dba.entity.report.koikinaitenkyokekkaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 *
 * 広域内転居結果一覧表のReportSource
 */
public class KoikinaiTenkyoKekkaIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shichosonCode", length = 6, order = 2)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 3)
    public RString shichosonName;
    @ReportItem(name = "listUpper_1", length = 20, order = 4)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 12, order = 5)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 60, order = 6)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 10, order = 7)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 10, order = 8)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 10, order = 9)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 10, order = 10)
    public RString listUpper_7;
    @ReportItem(name = "listHihokenshaNo_1", length = 10, order = 11)
    public RString listHihokenshaNo_1;
    @ReportItem(name = "listLower_1", length = 20, order = 12)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 12, order = 13)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 60, order = 14)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 10, order = 15)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 10, order = 16)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 10, order = 17)
    public RString listLower_6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
