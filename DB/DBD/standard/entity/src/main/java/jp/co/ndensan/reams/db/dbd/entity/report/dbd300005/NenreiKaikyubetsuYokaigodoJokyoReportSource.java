package jp.co.ndensan.reams.db.dbd.entity.report.dbd300005;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 年齢階級別要介護度状況ReportSourceです。
 *
 * @reamsid_L DBD-1790-040 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shichosonName", length = 20, order = 1)
    public RString shichosonName;
    @ReportItem(name = "kijunbi", length = 15, order = 2)
    public RString kijunbi;
    @ReportItem(name = "chiku", length = 40, order = 3)
    public RString chiku;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 24, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 6)
    public RString printTimeStamp;
    @ReportItem(name = "list1_1", length = 3, order = 7)
    public RString list1_1;
    @ReportItem(name = "list2_1", length = 3, order = 8)
    public RString list2_1;
    @ReportItem(name = "list3_1", length = 7, order = 9)
    public RString list3_1;
    @ReportItem(name = "list3_2", length = 7, order = 10)
    public RString list3_2;
    @ReportItem(name = "list3_3", length = 7, order = 11)
    public RString list3_3;
    @ReportItem(name = "list3_4", length = 7, order = 12)
    public RString list3_4;
    @ReportItem(name = "list3_5", length = 7, order = 13)
    public RString list3_5;
    @ReportItem(name = "list3_6", length = 7, order = 14)
    public RString list3_6;
    @ReportItem(name = "list3_7", length = 7, order = 15)
    public RString list3_7;
    @ReportItem(name = "list3_8", length = 7, order = 16)
    public RString list3_8;
    @ReportItem(name = "list3_9", length = 7, order = 17)
    public RString list3_9;
    @ReportItem(name = "list3_10", length = 7, order = 18)
    public RString list3_10;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
