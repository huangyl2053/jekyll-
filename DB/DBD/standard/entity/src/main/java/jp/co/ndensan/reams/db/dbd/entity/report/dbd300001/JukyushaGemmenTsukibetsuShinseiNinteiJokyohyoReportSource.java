package jp.co.ndensan.reams.db.dbd.entity.report.dbd300001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 受給者減免月別申請・認定状況表ReportSourceです。
 *
 * @reamsid_L DBD-3770-040 b_liuyang2
 */
public class JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonName", length = 15, order = 1)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 2)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 6, order = 3)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "list_1", length = 26, order = 6)
    public RString list_1;
    @ReportItem(name = "list_2", length = 7, order = 7)
    public RString list_2;
    @ReportItem(name = "list_3", length = 7, order = 8)
    public RString list_3;
    @ReportItem(name = "list_4", length = 7, order = 9)
    public RString list_4;
    @ReportItem(name = "list_5", length = 7, order = 10)
    public RString list_5;
    @ReportItem(name = "list_6", length = 7, order = 11)
    public RString list_6;
    @ReportItem(name = "list_7", length = 7, order = 12)
    public RString list_7;
    @ReportItem(name = "list_8", length = 7, order = 13)
    public RString list_8;
    @ReportItem(name = "list_9", length = 7, order = 14)
    public RString list_9;
    @ReportItem(name = "list_10", length = 7, order = 15)
    public RString list_10;
    @ReportItem(name = "list_11", length = 7, order = 16)
    public RString list_11;
    @ReportItem(name = "list_12", length = 7, order = 17)
    public RString list_12;
    @ReportItem(name = "list_13", length = 7, order = 18)
    public RString list_13;
    @ReportItem(name = "list_14", length = 8, order = 19)
    public RString list_14;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
