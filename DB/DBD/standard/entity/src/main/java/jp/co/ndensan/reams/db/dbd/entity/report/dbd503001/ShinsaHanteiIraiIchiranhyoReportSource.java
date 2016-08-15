package jp.co.ndensan.reams.db.dbd.entity.report.dbd503001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査判定依頼一覧表ReportSourceです。
 *
 * @reamsid_L DBD-1480-030 b_liuyang2
 */
public class ShinsaHanteiIraiIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 50, order = 1)
    public RString title;
    @ReportItem(name = "cityName", length = 20, order = 2)
    public RString cityName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "listIraiichiranhyo1_1", length = 3, order = 5)
    public RString listIraiichiranhyo1_1;
    @ReportItem(name = "listIraiichiranhyo1_2", length = 10, order = 6)
    public RString listIraiichiranhyo1_2;
    @ReportItem(name = "listIraiichiranhyo3_1", length = 20, order = 7)
    public RString listIraiichiranhyo3_1;
    @ReportItem(name = "listIraiichiranhyo3_2", length = 25, order = 8)
    public RString listIraiichiranhyo3_2;
    @ReportItem(name = "listIraiichiranhyo3_3", length = 50, order = 9)
    public RString listIraiichiranhyo3_3;
    @ReportItem(name = "listIraiichiranhyo2_1", length = 10, order = 10)
    public RString listIraiichiranhyo2_1;
    @ReportItem(name = "listIraiichiranhyo2_2", length = 2, order = 11)
    public RString listIraiichiranhyo2_2;
    @ReportItem(name = "listIraiichiranhyo2_3", length = 4, order = 12)
    public RString listIraiichiranhyo2_3;
    @ReportItem(name = "listIraiichiranhyo2_4", length = 4, order = 13)
    public RString listIraiichiranhyo2_4;
    @ReportItem(name = "listIraiichiranhyo2_5", length = 10, order = 14)
    public RString listIraiichiranhyo2_5;
    @ReportItem(name = "listIraiichiranhyo2_6", length = 3, order = 15)
    public RString listIraiichiranhyo2_6;
    @ReportItem(name = "listIraiichiranhyo2_7", length = 10, order = 16)
    public RString listIraiichiranhyo2_7;
    @ReportItem(name = "listIraiichiranhyo2_8", length = 10, order = 17)
    public RString listIraiichiranhyo2_8;
    @ReportItem(name = "listIraiichiranhyo2_9", length = 1, order = 18)
    public RString listIraiichiranhyo2_9;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "reportId", order = 19)
    public RString reportId;
// </editor-fold>
}
