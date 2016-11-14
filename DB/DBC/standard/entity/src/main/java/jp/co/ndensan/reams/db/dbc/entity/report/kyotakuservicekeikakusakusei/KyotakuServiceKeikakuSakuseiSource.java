package jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 計画届出状況チェックリストSourceクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSakuseiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "joken1", length = 23, order = 1)
    public RString joken1;
    @ReportItem(name = "joken2", length = 10, order = 2)
    public RString joken2;
    @ReportItem(name = "joken3", length = 12, order = 3)
    public RString joken3;
    @ReportItem(name = "kijunYmd", length = 11, order = 4)
    public RString kijunYmd;
    @ReportItem(name = "cityCd", length = 6, order = 5)
    public RString cityCd;
    @ReportItem(name = "cityMei", length = 12, order = 6)
    public RString cityMei;
    @ReportItem(name = "sortJunArea1", length = 10, order = 7)
    public RString sortJunArea1;
    @ReportItem(name = "sortJunArea2", length = 10, order = 8)
    public RString sortJunArea2;
    @ReportItem(name = "sortJunArea3", length = 10, order = 9)
    public RString sortJunArea3;
    @ReportItem(name = "sortJunArea4", length = 10, order = 10)
    public RString sortJunArea4;
    @ReportItem(name = "sortJunArea5", length = 10, order = 11)
    public RString sortJunArea5;
    @ReportItem(name = "kaiPageArea1", length = 20, order = 12)
    public RString kaiPageArea1;
    @ReportItem(name = "kaiPageArea2", length = 20, order = 13)
    public RString kaiPageArea2;
    @ReportItem(name = "kaiPageArea3", length = 20, order = 14)
    public RString kaiPageArea3;
    @ReportItem(name = "kaiPageArea4", length = 20, order = 15)
    public RString kaiPageArea4;
    @ReportItem(name = "kaiPageArea5", length = 20, order = 16)
    public RString kaiPageArea5;
    @ReportItem(name = "shoriYmdHms", length = 21, order = 17)
    public RString shoriYmdHms;
    @ReportItem(name = "listList1_1", length = 10, order = 18)
    public RString listList1_1;
    @ReportItem(name = "listList1_2", length = 22, order = 19)
    public RString listList1_2;
    @ReportItem(name = "listList1_3", length = 11, order = 20)
    public RString listList1_3;
    @ReportItem(name = "listList1_4", length = 9, order = 21)
    public RString listList1_4;
    @ReportItem(name = "listList1_5", length = 9, order = 22)
    public RString listList1_5;
    @ReportItem(name = "listList1_6", length = 9, order = 23)
    public RString listList1_6;
    @ReportItem(name = "listList1_7", length = 6, order = 24)
    public RString listList1_7;
    @ReportItem(name = "listList1_8", length = 5, order = 25)
    public RString listList1_8;
    @ReportItem(name = "listList1_9", length = 9, order = 26)
    public RString listList1_9;
    @ReportItem(name = "listList1_10", length = 9, order = 27)
    public RString listList1_10;
    @ReportItem(name = "listList1_11", length = 9, order = 28)
    public RString listList1_11;
    @ReportItem(name = "listList1_12", length = 5, order = 29)
    public RString listList1_12;
    @ReportItem(name = "listList2_1", length = 12, order = 30)
    public RString listList2_1;
    @ReportItem(name = "listList2_2", length = 11, order = 31)
    public RString listList2_2;
    @ReportItem(name = "listList2_3", length = 20, order = 32)
    public RString listList2_3;
    @ReportItem(name = "listList2_4", length = 9, order = 33)
    public RString listList2_4;
    @ReportItem(name = "listList2_5", length = 9, order = 34)
    public RString listList2_5;
    @ReportItem(name = "listList2_6", length = 9, order = 35)
    public RString listList2_6;
    @ReportItem(name = "listList2_7", length = 9, order = 36)
    public RString listList2_7;
    @ReportItem(name = "listList2_8", length = 10, order = 37)
    public RString listList2_8;
    @ReportItem(name = "listList2_9", length = 15, order = 38)
    public RString listList2_9;
    @ReportItem(name = "listList2_10", length = 9, order = 39)
    public RString listList2_10;
    @ReportItem(name = "listList3_1", length = 10, order = 40)
    public RString listList3_1;
    @ReportItem(name = "listList3_2", length = 20, order = 41)
    public RString listList3_2;
    @ReportItem(name = "listList3_3", length = 5, order = 42)
    public RString listList3_3;
    @ReportItem(name = "listList3_4", length = 24, order = 43)
    public RString listList3_4;
    @ReportItem(name = "listList3_5", length = 25, order = 44)
    public RString listList3_5;
    @ReportItem(name = "listList3_6", length = 5, order = 45)
    public RString listList3_6;

    @ReportItem(name = "yubinNo", length = 50, order = 46)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 50, order = 47)
    public RString choikiCode;
    @ReportItem(name = "banchiCode1", length = 50, order = 48)
    public RString banchiCode1;
    @ReportItem(name = "banchiCode2", length = 50, order = 49)
    public RString banchiCode2;
    @ReportItem(name = "banchiCode3", length = 50, order = 50)
    public RString banchiCode3;
    @ReportItem(name = "banchiCode4", length = 50, order = 51)
    public RString banchiCode4;
    @ReportItem(name = "kanaMeisho", length = 50, order = 52)
    public RString kanaMeisho;
    @ReportItem(name = "seibetsuCode", length = 50, order = 53)
    public RString seibetsuCode;
    @ReportItem(name = "shichosonCode", length = 50, order = 54)
    public RString shichosonCode;
    @ReportItem(name = "keikakuJigyoshaNo", length = 50, order = 55)
    public RString keikakuJigyoshaNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
