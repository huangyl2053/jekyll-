package jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki151;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5530-080 dangjingjing
 */
public class JigyohokokuCompYoshiki151ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shukeiKubun", length = 4, order = 2)
    public RString shukeiKubun;
    @ReportItem(name = "shuukeiHani", length = 40, order = 3)
    public RString shuukeiHani;
    @ReportItem(name = "hokenshaNo", length = 12, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 13, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "list1_1", length = 10, order = 6)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 10, order = 7)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 10, order = 8)
    public RString list1_3;
    @ReportItem(name = "list2_1", length = 7, order = 9)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 7, order = 10)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 7, order = 11)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 7, order = 12)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 7, order = 13)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 7, order = 14)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 7, order = 15)
    public RString list2_7;
    @ReportItem(name = "list2_8", length = 7, order = 16)
    public RString list2_8;
    @ReportItem(name = "list2_9", length = 7, order = 17)
    public RString list2_9;
    @ReportItem(name = "list2_10", length = 7, order = 18)
    public RString list2_10;
    @ReportItem(name = "list2_11", length = 7, order = 19)
    public RString list2_11;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
