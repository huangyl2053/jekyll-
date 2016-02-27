package jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 月別推移表（帳票）の項目を定義するクラスです。
 */
public class TsukibetsuSuiihyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "gengo", length = 2, order = 2)
    public RString gengo;
    @ReportItem(name = "nendo", length = 2, order = 3)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 40, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "listTitle_1", length = 6, order = 6)
    public RString listTitle_1;
    @ReportItem(name = "list_1", length = 14, order = 7)
    public RString list_1;
    @ReportItem(name = "list_2", length = 14, order = 8)
    public RString list_2;
    @ReportItem(name = "list_3", length = 14, order = 9)
    public RString list_3;
    @ReportItem(name = "list_4", length = 14, order = 10)
    public RString list_4;
    @ReportItem(name = "list_5", length = 14, order = 11)
    public RString list_5;
    @ReportItem(name = "list_6", length = 14, order = 12)
    public RString list_6;
    @ReportItem(name = "list_7", length = 14, order = 13)
    public RString list_7;
    @ReportItem(name = "list_8", length = 14, order = 14)
    public RString list_8;
    @ReportItem(name = "list_9", length = 14, order = 15)
    public RString list_9;
    @ReportItem(name = "list_10", length = 14, order = 16)
    public RString list_10;
    @ReportItem(name = "list_11", length = 14, order = 17)
    public RString list_11;
    @ReportItem(name = "list_12", length = 14, order = 18)
    public RString list_12;
    @ReportItem(name = "list_13", length = 14, order = 19)
    public RString list_13;
    @ReportItem(name = "list_14", length = 14, order = 20)
    public RString list_14;
    @ReportItem(name = "list_15", length = 17, order = 21)
    public RString list_15;
    @ReportItem(name = "list_16", length = 14, order = 22)
    public RString list_16;
    @ReportItem(name = "choshuHouhouTitle", length = 4, order = 23)
    public RString choshuHouhouTitle;
    @ReportItem(name = "ninsuGokeiTitle", length = 2, order = 24)
    public RString ninsuGokeiTitle;
    @ReportItem(name = "kingakuGokeiTitle", length = 2, order = 25)
    public RString kingakuGokeiTitle;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
