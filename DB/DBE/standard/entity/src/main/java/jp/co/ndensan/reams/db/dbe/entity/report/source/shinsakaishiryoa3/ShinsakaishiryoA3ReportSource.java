package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 介護認定審査対象者一覧表A3のReportSourceです。
 *
 * @reamsid_L DBE-0150-230 lishengli
 */
public class ShinsakaishiryoA3ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shinsakaiNo", length = 4, order = 1)
    public RString shinsakaiNo;
    @ReportItem(name = "listShinsainName_1", length = 20, order = 2)
    public RString listShinsainName_1;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 21, order = 3)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "gogitaiNo", length = 2, order = 4)
    public RString gogitaiNo;
    @ReportItem(name = "shinsaTaishoshaCount", length = 2, order = 5)
    public RString shinsaTaishoshaCount;
    @ReportItem(name = "listShinsei1_1", length = 2, order = 6)
    public RString listShinsei1_1;
    @ReportItem(name = "listShinsei1_2", length = 6, order = 7)
    public RString listShinsei1_2;
    @ReportItem(name = "listShinsei1_3", length = 10, order = 8)
    public RString listShinsei1_3;
    @ReportItem(name = "listShinsei1_4", length = 30, order = 9)
    public RString listShinsei1_4;
    @ReportItem(name = "listShinsei1_5", length = 1, order = 10)
    public RString listShinsei1_5;
    @ReportItem(name = "listShinsei1_6", length = 3, order = 11)
    public RString listShinsei1_6;
    @ReportItem(name = "listShinsei1_7", length = 3, order = 12)
    public RString listShinsei1_7;
    @ReportItem(name = "listShinsei1_8", length = 4, order = 13)
    public RString listShinsei1_8;
    @ReportItem(name = "listShinsei1_9", length = 7, order = 14)
    public RString listShinsei1_9;
    @ReportItem(name = "listShinsei1_10", length = 3, order = 15)
    public RString listShinsei1_10;
    @ReportItem(name = "listShinsei1_11", length = 4, order = 16)
    public RString listShinsei1_11;
    @ReportItem(name = "listShinsei2_1", length = 2, order = 17)
    public RString listShinsei2_1;
    @ReportItem(name = "listShinsei2_2", length = 6, order = 18)
    public RString listShinsei2_2;
    @ReportItem(name = "listShinsei2_3", length = 10, order = 19)
    public RString listShinsei2_3;
    @ReportItem(name = "listShinsei2_4", length = 30, order = 20)
    public RString listShinsei2_4;
    @ReportItem(name = "listShinsei2_5", length = 1, order = 21)
    public RString listShinsei2_5;
    @ReportItem(name = "listShinsei2_6", length = 3, order = 22)
    public RString listShinsei2_6;
    @ReportItem(name = "listShinsei2_7", length = 3, order = 23)
    public RString listShinsei2_7;
    @ReportItem(name = "listShinsei2_8", length = 4, order = 24)
    public RString listShinsei2_8;
    @ReportItem(name = "listShinsei2_9", length = 7, order = 25)
    public RString listShinsei2_9;
    @ReportItem(name = "listShinsei2_10", length = 3, order = 26)
    public RString listShinsei2_10;
    @ReportItem(name = "listShinsei2_11", length = 4, order = 27)
    public RString listShinsei2_11;
    @ReportItem(name = "listZenkaiｙukokikan1_1", length = 19, order = 28)
    public RString listZenkaiｙukokikan1_1;
    @ReportItem(name = "listYukokikan1_1", length = 19, order = 29)
    public RString listYukokikan1_1;
    @ReportItem(name = "listZenkaiｙukokikan2_1", length = 19, order = 30)
    public RString listZenkaiｙukokikan2_1;
    @ReportItem(name = "listYukokikan2_1", length = 19, order = 31)
    public RString listYukokikan2_1;
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
