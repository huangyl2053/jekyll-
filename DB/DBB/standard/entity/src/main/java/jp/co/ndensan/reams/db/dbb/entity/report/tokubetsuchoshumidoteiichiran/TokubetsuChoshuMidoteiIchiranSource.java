package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のソースクラスです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 6, order = 2)
    public RString nendo;
    @ReportItem(name = "cityCd", length = 6, order = 3)
    public RString cityCd;
    @ReportItem(name = "cityMei", length = 12, order = 4)
    public RString cityMei;
    @ReportItem(name = "sortJunArea1", length = 10, order = 5)
    public RString sortJunArea1;
    @ReportItem(name = "sortJunArea2", length = 10, order = 6)
    public RString sortJunArea2;
    @ReportItem(name = "sortJunArea3", length = 10, order = 7)
    public RString sortJunArea3;
    @ReportItem(name = "sortJunArea4", length = 10, order = 8)
    public RString sortJunArea4;
    @ReportItem(name = "sortJunArea5", length = 10, order = 9)
    public RString sortJunArea5;
    @ReportItem(name = "kaiPageArea2", length = 20, order = 10)
    public RString kaiPageArea2;
    @ReportItem(name = "kaiPageArea4", length = 20, order = 11)
    public RString kaiPageArea4;
    @ReportItem(name = "kaiPageArea5", length = 20, order = 12)
    public RString kaiPageArea5;
    @ReportItem(name = "kaiPageArea1", length = 20, order = 13)
    public RString kaiPageArea1;
    @ReportItem(name = "kaiPageArea3", length = 20, order = 14)
    public RString kaiPageArea3;
    @ReportItem(name = "listList1_1", length = 10, order = 15)
    public RString listList1_1;
    @ReportItem(name = "listList1_2", length = 4, order = 16)
    public RString listList1_2;
    @ReportItem(name = "listList1_3", length = 15, order = 17)
    public RString listList1_3;
    @ReportItem(name = "listList1_4", length = 1, order = 18)
    public RString listList1_4;
    @ReportItem(name = "listList1_5", length = 50, order = 19)
    public RString listList1_5;
    @ReportItem(name = "listList1_6", length = 8, order = 20)
    public RString listList1_6;
    @ReportItem(name = "listList1_7", length = 30, order = 21)
    public RString listList1_7;
    @ReportItem(name = "listList1_8", length = 3, order = 22)
    public RString listList1_8;
    @ReportItem(name = "listList1_9", length = 3, order = 23)
    public RString listList1_9;
    @ReportItem(name = "listList2_1", length = 9, order = 24)
    public RString listList2_1;
    @ReportItem(name = "listList2_2", length = 30, order = 25)
    public RString listList2_2;
    @ReportItem(name = "listList2_3", length = 30, order = 26)
    public RString listList2_3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "A")
    public ShikibetsuCode shikibetsuCode;

    /**
     * ReportSourceFields
     */
    public enum ReportSourceFields {

        printTimeStamp,
        nendo,
        cityCd,
        cityMei,
        sortJunArea1,
        sortJunArea2,
        sortJunArea3,
        sortJunArea4,
        sortJunArea5,
        kaiPageArea2,
        kaiPageArea4,
        kaiPageArea5,
        kaiPageArea1,
        kaiPageArea3,
        listList1_1,
        listList1_2,
        listList1_3,
        listList1_4,
        listList1_5,
        listList1_6,
        listList1_7,
        listList1_8,
        listList1_9,
        listList2_1,
        listList2_2,
        listList2_3,
        shikibetsuCode
    }
// </editor-fold>
}
