package jp.co.ndensan.reams.db.dbc.entity.report.dbc200013;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMN32002_受領委任契約承認確認書発行一覧表のsource
 *
 * @reamsid_L DBC-1910-070 jiangxiaolong
 */
public class JuryoIninShoninKakuninshoIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 21, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 3)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 4)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 5)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 6)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 7)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 8)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage2", length = 20, order = 9)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 10)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 11)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 12)
    public RString kaipage5;
    @ReportItem(name = "kaipage1", length = 20, order = 13)
    public RString kaipage1;
    @ReportItem(name = "ListUpper_1", length = 5, order = 14)
    public RString ListUpper_1;
    @ReportItem(name = "ListUpper_2", length = 10, order = 15)
    public RString ListUpper_2;
    @ReportItem(name = "ListUpper_3", length = 15, order = 16)
    public RString ListUpper_3;
    @ReportItem(name = "ListUpper_4", length = 40, order = 17)
    public RString ListUpper_4;
    @ReportItem(name = "ListUpper_5", length = 10, order = 18)
    public RString ListUpper_5;
    @ReportItem(name = "ListUpper_6", length = 10, order = 19)
    public RString ListUpper_6;
    @ReportItem(name = "ListUpper_7", length = 10, order = 20)
    public RString ListUpper_7;
    @ReportItem(name = "ListUpper_8", length = 4, order = 21)
    public RString ListUpper_8;
    @ReportItem(name = "ListLower_1", length = 15, order = 22)
    public RString ListLower_1;
    @ReportItem(name = "ListLower_2", length = 40, order = 23)
    public RString ListLower_2;
    @ReportItem(name = "ListLower_3", length = 10, order = 24)
    public RString ListLower_3;
    @ReportItem(name = "ListLower_4", length = 15, order = 25)
    public RString ListLower_4;
    @ReportItem(name = "契約申請年月日", length = 15, order = 26)
    public RString 契約申請年月日;
    @ReportItem(name = "契約事業者番号", length = 15, order = 27)
    public RString 契約事業者番号;
    @ReportItem(name = "受領委任契約番号", length = 15, order = 28)
    public RString 受領委任契約番号;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * JuryoIninShoninKakuninshoIchiranSourceのENUM
     */
    public enum ReportSourceFields {

        shichosonCd,
        shichosonName,
        sortkjun1,
        sortkjun2,
        sortkjun3,
        sortkjun4,
        sortkjun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        printTimeStamp,
        pageCount,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listUpper_6,
        listUpper_7,
        listUpper_8,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4

    }
}
