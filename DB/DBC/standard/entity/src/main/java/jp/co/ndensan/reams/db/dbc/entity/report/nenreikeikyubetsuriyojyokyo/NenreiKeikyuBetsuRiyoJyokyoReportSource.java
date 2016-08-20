package jp.co.ndensan.reams.db.dbc.entity.report.nenreikeikyubetsuriyojyokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 年齢階級別利用状況作成の帳票ReportSourceクラスです。
 *
 * @reamsid_L DBE-3470-040 dongyabin
 */
public class NenreiKeikyuBetsuRiyoJyokyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "joken1", length = 60, order = 1)
    public RString joken1;
    @ReportItem(name = "joken2", length = 60, order = 2)
    public RString joken2;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "serviceMei1", length = 50, order = 5)
    public RString serviceMei1;
    @ReportItem(name = "printTimeStamp", length = 21, order = 6)
    public RString printTimeStamp;
    @ReportItem(name = "List1_1", length = 7, order = 7)
    public RString list1_1;
    @ReportItem(name = "List1_2", length = 11, order = 8)
    public RString list1_2;
    @ReportItem(name = "List1_3", length = 11, order = 9)
    public RString list1_3;
    @ReportItem(name = "List1_4", length = 11, order = 10)
    public RString list1_4;
    @ReportItem(name = "List1_5", length = 11, order = 11)
    public RString list1_5;
    @ReportItem(name = "List1_6", length = 11, order = 12)
    public RString list1_6;
    @ReportItem(name = "List1_7", length = 11, order = 13)
    public RString list1_7;
    @ReportItem(name = "List1_8", length = 11, order = 14)
    public RString list1_8;
    @ReportItem(name = "List1_9", length = 11, order = 15)
    public RString list1_9;
    @ReportItem(name = "List1_10", length = 11, order = 16)
    public RString list1_10;
    @ReportItem(name = "List1_11", length = 11, order = 17)
    public RString list1_11;
    @ReportItem(name = "serviceMei2", length = 50, order = 18)
    public RString serviceMei2;
    @ReportItem(name = "List2_1", length = 7, order = 19)
    public RString list2_1;
    @ReportItem(name = "List2_2", length = 11, order = 20)
    public RString list2_2;
    @ReportItem(name = "List2_3", length = 11, order = 21)
    public RString list2_3;
    @ReportItem(name = "List2_4", length = 11, order = 22)
    public RString list2_4;
    @ReportItem(name = "List2_5", length = 11, order = 23)
    public RString list2_5;
    @ReportItem(name = "List2_6", length = 11, order = 24)
    public RString list2_6;
    @ReportItem(name = "List2_7", length = 11, order = 25)
    public RString list2_7;
    @ReportItem(name = "List2_8", length = 11, order = 26)
    public RString list2_8;
    @ReportItem(name = "List2_9", length = 11, order = 27)
    public RString list2_9;
    @ReportItem(name = "List2_10", length = 11, order = 28)
    public RString list2_10;
    @ReportItem(name = "List2_11", length = 11, order = 29)
    public RString list2_11;
    @ReportItem(name = "pageCount1", length = 6, order = 30)
    public RString pageCount1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 年齢階級別利用状況作成の改ページ項目です。
     */
    public enum ReportSourceFields {

        pageCount1;
    }
}
