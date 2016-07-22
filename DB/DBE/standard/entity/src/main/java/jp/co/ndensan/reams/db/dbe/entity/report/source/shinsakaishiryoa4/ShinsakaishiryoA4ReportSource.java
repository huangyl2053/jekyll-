package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 介護認定審査対象者一覧表のReportSourceです。
 *
 * @reamsid_L DBE-0150-260 lishengli
 */
public class ShinsakaishiryoA4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shinsakaiNo", length = 4, order = 1)
    public RString shinsakaiNo;
    @ReportItem(name = "year", length = 21, order = 2)
    public RString year;
    @ReportItem(name = "listshinsainName_1", length = 20, order = 3)
    public RString listshinsainName_1;
    @ReportItem(name = "gogitaiNo", length = 2, order = 4)
    public RString gogitaiNo;
    @ReportItem(name = "shinsaTaishoshaCount", length = 2, order = 5)
    public RString shinsaTaishoshaCount;
    @ReportItem(name = "list1_1", length = 2, order = 6)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 6, order = 7)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 10, order = 8)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 30, order = 9)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 1, order = 10)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 3, order = 11)
    public RString list1_6;
    @ReportItem(name = "list1_7", length = 4, order = 12)
    public RString list1_7;
    @ReportItem(name = "list1_8", length = 4, order = 13)
    public RString list1_8;
    @ReportItem(name = "list1_9", length = 7, order = 14)
    public RString list1_9;
    @ReportItem(name = "list1_10", length = 1, order = 15)
    public RString list1_10;
    @ReportItem(name = "list1_11", length = 5, order = 16)
    public RString list1_11;
    @ReportItem(name = "list1_12", length = 3, order = 17)
    public RString list1_12;
    @ReportItem(name = "list1_13", length = 4, order = 18)
    public RString list1_13;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation shinseishoKanriNo;
}
