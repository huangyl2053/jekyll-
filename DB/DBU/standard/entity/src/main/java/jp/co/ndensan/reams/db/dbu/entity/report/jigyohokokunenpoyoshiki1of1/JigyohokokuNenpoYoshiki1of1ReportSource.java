package jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki1of1;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事業状況報告年報（様式１・２　被保険者数）のReportSourceクラスです。
 *
 * @reamsid_L DBU-5610-030 sunhaidi
 */
public class JigyohokokuNenpoYoshiki1of1ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shuukeiHani", length = 40, order = 2)
    public RString shuukeiHani;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 13, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "list1_1", length = 11, order = 5)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 11, order = 6)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 11, order = 7)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 11, order = 8)
    public RString list1_4;
    @ReportItem(name = "list2_1", length = 11, order = 9)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 11, order = 10)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 11, order = 11)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 11, order = 12)
    public RString list2_4;
    @ReportItem(name = "list3Upper_1", length = 11, order = 13)
    public RString list3Upper_1;
    @ReportItem(name = "list3Upper_2", length = 11, order = 14)
    public RString list3Upper_2;
    @ReportItem(name = "list3Upper_3", length = 11, order = 15)
    public RString list3Upper_3;
    @ReportItem(name = "list3Upper_4", length = 11, order = 16)
    public RString list3Upper_4;
    @ReportItem(name = "list3Upper_5", length = 11, order = 17)
    public RString list3Upper_5;
    @ReportItem(name = "list3Upper_6", length = 11, order = 18)
    public RString list3Upper_6;
    @ReportItem(name = "list3Lower_1", length = 11, order = 19)
    public RString list3Lower_1;
    @ReportItem(name = "list3Lower_2", length = 11, order = 20)
    public RString list3Lower_2;
    @ReportItem(name = "list3Lower_3", length = 11, order = 21)
    public RString list3Lower_3;
    @ReportItem(name = "list3Lower_4", length = 11, order = 22)
    public RString list3Lower_4;
    @ReportItem(name = "list3Lower_5", length = 11, order = 23)
    public RString list3Lower_5;
    @ReportItem(name = "list3Lower_6", length = 11, order = 24)
    public RString list3Lower_6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
