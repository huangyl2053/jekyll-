package jp.co.ndensan.reams.db.dbd.entity.report.dbd522002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票「要介護認定延期通知書発行一覧表」の項目を定義するクラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public class NinteiEnkiTsuchishoHakkoIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 50, order = 1)
    public RString title;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "shoriMikomiKigen", length = 25, order = 3)
    public RString shoriMikomiKigen;
    @ReportItem(name = "tsuchishoHakkoYMD", length = 11, order = 4)
    public RString tsuchishoHakkoYMD;
    @ReportItem(name = "cityCode", length = 6, order = 5)
    public RString cityCode;
    @ReportItem(name = "cityName", length = 20, order = 6)
    public RString cityName;
    @ReportItem(name = "listHakkoIchiranhyo_1", length = 4, order = 7)
    public RString listHakkoIchiranhyo_1;
    @ReportItem(name = "listHakkoIchiranhyo_2", length = 10, order = 8)
    public RString listHakkoIchiranhyo_2;
    @ReportItem(name = "listHakkoIchiranhyo_3", length = 15, order = 9)
    public RString listHakkoIchiranhyo_3;
    @ReportItem(name = "listHakkoIchiranhyo_4", length = 40, order = 10)
    public RString listHakkoIchiranhyo_4;
    @ReportItem(name = "listHakkoIchiranhyo_5", length = 9, order = 11)
    public RString listHakkoIchiranhyo_5;
    @ReportItem(name = "listHakkoIchiranhyo_6", length = 6, order = 12)
    public RString listHakkoIchiranhyo_6;
    @ReportItem(name = "listHakkoIchiranhyo_7", length = 9, order = 13)
    public RString listHakkoIchiranhyo_7;
    @ReportItem(name = "listHakkoIchiranhyo_8", length = 4, order = 14)
    public RString listHakkoIchiranhyo_8;
    @ReportItem(name = "listHakkoIchiranhyo_9", length = 4, order = 15)
    public RString listHakkoIchiranhyo_9;
    @ReportItem(name = "listHakkoIchiranhyo_10", length = 9, order = 16)
    public RString listHakkoIchiranhyo_10;
    @ReportItem(name = "listHakkoIchiranhyo_11", length = 9, order = 17)
    public RString listHakkoIchiranhyo_11;
    @ReportItem(name = "listHakkoIchiranhyo_12", length = 5, order = 18)
    public RString listHakkoIchiranhyo_12;
    @ReportItem(name = "listHakkoIchiranhyo_13", length = 4, order = 19)
    public RString listHakkoIchiranhyo_13;
    @ReportItem(name = "listHakkoIchiranhyo_14", length = 9, order = 20)
    public RString listHakkoIchiranhyo_14;
    @ReportItem(name = "listHakkoIchiranhyo_15", length = 9, order = 21)
    public RString listHakkoIchiranhyo_15;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
