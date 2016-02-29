package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会スケジュール表のReportSourceです。
 */
public class ShinsakaisukejuruhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "hokenshaName", length = 20, order = 2)
    public RString hokenshaName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listShinsakaiSukejuru_1", length = 3, order = 4)
    public RString listShinsakaiSukejuru_1;
    @ReportItem(name = "listShinsakaiSukejuru_2", length = 5, order = 5)
    public RString listShinsakaiSukejuru_2;
    @ReportItem(name = "listShinsakaiSukejuru_3", length = 9, order = 6)
    public RString listShinsakaiSukejuru_3;
    @ReportItem(name = "listShinsakaiSukejuru_4", length = 11, order = 7)
    public RString listShinsakaiSukejuru_4;
    @ReportItem(name = "listShinsakaiSukejuru_5", length = 10, order = 8)
    public RString listShinsakaiSukejuru_5;
    @ReportItem(name = "listShinsakaiSukejuru_6", length = 20, order = 9)
    public RString listShinsakaiSukejuru_6;
    @ReportItem(name = "listShinsakaiSukejuru_7", length = 40, order = 10)
    public RString listShinsakaiSukejuru_7;
    @ReportItem(name = "listShinsakaiSukejuru_8", length = 13, order = 11)
    public RString listShinsakaiSukejuru_8;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
