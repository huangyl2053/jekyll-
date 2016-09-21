package jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 共同処理用受給者情報一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBC-2780-030 lishengli
 */
public class KyodoJukyushaKoshinkekkaIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 32, order = 2)
    public RString title;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 10)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 11)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 12)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 13)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 14)
    public RString kaipage5;
    @ReportItem(name = "komokuName1", length = 8, order = 15)
    public RString komokuName1;
    @ReportItem(name = "komokuName2", length = 8, order = 16)
    public RString komokuName2;
    @ReportItem(name = "komokuName3", length = 8, order = 17)
    public RString komokuName3;
    @ReportItem(name = "list1_1", length = 2, order = 18)
    public RString list1_1;
    @ReportItem(name = "list2_1", length = 6, order = 19)
    public RString list2_1;
    @ReportItem(name = "list3_1", length = 40, order = 20)
    public RString list3_1;
    @ReportItem(name = "list4_1", length = 2, order = 21)
    public RString list4_1;
    @ReportItem(name = "list5_1", length = 2, order = 22)
    public RString list5_1;
    @ReportItem(name = "list6_1", length = 10, order = 23)
    public RString list6_1;
    @ReportItem(name = "list1_2", length = 16, order = 24)
    public RString list1_2;
    @ReportItem(name = "list2_2", length = 40, order = 25)
    public RString list2_2;
    @ReportItem(name = "list3_2", length = 12, order = 26)
    public RString list3_2;
    @ReportItem(name = "list4_2", length = 16, order = 27)
    public RString list4_2;
    @ReportItem(name = "list5_2", length = 16, order = 28)
    public RString list5_2;
    @ReportItem(name = "list1_3", length = 10, order = 29)
    public RString list1_3;
    @ReportItem(name = "list2_3", length = 8, order = 30)
    public RString list2_3;
    @ReportItem(name = "list3_3", length = 64, order = 31)
    public RString list3_3;
    @ReportItem(name = "list4_3", length = 10, order = 32)
    public RString list4_3;
    @ReportItem(name = "list5_3", length = 10, order = 33)
    public RString list5_3;
    @ReportItem(name = "list1_4", length = 10, order = 34)
    public RString list1_4;
    @ReportItem(name = "list2_4", length = 11, order = 35)
    public RString list2_4;
    @ReportItem(name = "list4_4", length = 6, order = 36)
    public RString list4_4;
    @ReportItem(name = "list5_4", length = 6, order = 37)
    public RString list5_4;
    @ReportItem(name = "list1_5", length = 6, order = 38)
    public RString list1_5;
    @ReportItem(name = "list2_5", length = 75, order = 39)
    public RString list2_5;
    @ReportItem(name = "list4_5", length = 16, order = 40)
    public RString list4_5;
    @ReportItem(name = "list5_5", length = 16, order = 41)
    public RString list5_5;
    @ReportItem(name = "list1_6", length = 16, order = 42)
    public RString list1_6;
    @ReportItem(name = "list4_6", length = 10, order = 43)
    public RString list4_6;
    @ReportItem(name = "list5_6", length = 10, order = 44)
    public RString list5_6;
    @ReportItem(name = "list1_7", length = 10, order = 45)
    public RString list1_7;
    @ReportItem(name = "list4_7", length = 10, order = 46)
    public RString list4_7;
    @ReportItem(name = "list5_7", length = 10, order = 47)
    public RString list5_7;
    @ReportItem(name = "list1_8", length = 10, order = 48)
    public RString list1_8;
    @ReportItem(name = "list4_8", length = 10, order = 49)
    public RString list4_8;
    @ReportItem(name = "list5_8", length = 10, order = 50)
    public RString list5_8;
    @ReportItem(name = "list1_9", length = 12, order = 51)
    public RString list1_9;
    @ReportItem(name = "list4_9", length = 10, order = 52)
    public RString list4_9;
    @ReportItem(name = "list5_9", length = 26, order = 53)
    public RString list5_9;
    @ReportItem(name = "list1_10", length = 60, order = 54)
    public RString list1_10;
    @ReportItem(name = "list4_10", length = 18, order = 55)
    public RString list4_10;
    @ReportItem(name = "list5_10", length = 22, order = 56)
    public RString list5_10;
    @ReportItem(name = "list1_11", length = 3, order = 57)
    public RString list1_11;
    @ReportItem(name = "list4_11", length = 14, order = 58)
    public RString list4_11;
    @ReportItem(name = "list5_11", length = 10, order = 59)
    public RString list5_11;
    @ReportItem(name = "list5_12", length = 10, order = 60)
    public RString list5_12;
    @ReportItem(name = "list7_1", length = 64, order = 61)
    public RString list7_1;
    @ReportItem(name = "list8_1", length = 64, order = 62)
    public RString list8_1;
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

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hokenshaNo,

    }
}
