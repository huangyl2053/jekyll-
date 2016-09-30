package jp.co.ndensan.reams.db.dbc.entity.report.dbc200095;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMNF1001_1_国保連送付データエラーリストsource
 *
 * @reamsid_L DBC-2720-060 jiangxiaolong
 */
public class KokuhorenSofuDataErrorIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "shoriYm", length = 12, order = 2)
    public RString shoriYm;
    @ReportItem(name = "cityCd", length = 6, order = 3)
    public RString cityCd;
    @ReportItem(name = "cityMei", length = 40, order = 4)
    public RString cityMei;
    @ReportItem(name = "listList2_1", length = 10, order = 5)
    public RString listList2_1;
    @ReportItem(name = "listList2_2", length = 26, order = 6)
    public RString listList2_2;
    @ReportItem(name = "listList2_3", length = 26, order = 7)
    public RString listList2_3;
    @ReportItem(name = "listList2_4", length = 10, order = 8)
    public RString listList2_4;
    @ReportItem(name = "listList2_5", length = 10, order = 9)
    public RString listList2_5;
    @ReportItem(name = "listList2_6", length = 10, order = 10)
    public RString listList2_6;
    @ReportItem(name = "listList2_7", length = 10, order = 11)
    public RString listList2_7;
    @ReportItem(name = "listList2_8", length = 10, order = 12)
    public RString listList2_8;
    @ReportItem(name = "listList2_9", length = 10, order = 13)
    public RString listList2_9;
    @ReportItem(name = "listList2_10", length = 10, order = 14)
    public RString listList2_10;
    @ReportItem(name = "listList2_11", length = 10, order = 15)
    public RString listList2_11;
    @ReportItem(name = "listList2_12", length = 10, order = 16)
    public RString listList2_12;
    @ReportItem(name = "listList2_13", length = 10, order = 17)
    public RString listList2_13;
    @ReportItem(name = "listList1_1", length = 4, order = 18)
    public RString listList1_1;
    @ReportItem(name = "listList3_1", length = 2, order = 19)
    public RString listList3_1;
    @ReportItem(name = "listList3_2", length = 58, order = 20)
    public RString listList3_2;
    @ReportItem(name = "listList3_3", length = 10, order = 21)
    public RString listList3_3;
    @ReportItem(name = "listList3_4", length = 10, order = 22)
    public RString listList3_4;
    @ReportItem(name = "listList3_5", length = 10, order = 23)
    public RString listList3_5;
    @ReportItem(name = "listList3_6", length = 10, order = 24)
    public RString listList3_6;
    @ReportItem(name = "listList3_7", length = 10, order = 25)
    public RString listList3_7;
    @ReportItem(name = "listList3_8", length = 10, order = 26)
    public RString listList3_8;
    @ReportItem(name = "listList3_9", length = 10, order = 27)
    public RString listList3_9;
    @ReportItem(name = "listList3_10", length = 10, order = 28)
    public RString listList3_10;
    @ReportItem(name = "listList3_11", length = 10, order = 29)
    public RString listList3_11;
    @ReportItem(name = "listList3_12", length = 10, order = 30)
    public RString listList3_12;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * JukyushaIdoRirekiTeiseiIchiranSourceのENUM
     */
    public enum ReportSourceFields {

        cityCd,
        cityMei,
        listList1_1,
        listList2_1,
        listList2_2,
        listList2_3,
        listList2_4,
        listList2_5,
        listList2_6,
        listList2_7,
        listList2_8,
        listList2_9,
        listList2_10,
        listList2_11,
        listList2_12,
        listList2_13,
        listList3_1,
        listList3_2,
        listList3_3,
        listList3_4,
        listList3_5,
        listList3_6,
        listList3_7,
        listList3_8,
        listList3_9,
        listList3_10,
        listList3_11,
        listList3_12,
        pageCount,
        printTimeStamp,
        shoriYm
    }
}
