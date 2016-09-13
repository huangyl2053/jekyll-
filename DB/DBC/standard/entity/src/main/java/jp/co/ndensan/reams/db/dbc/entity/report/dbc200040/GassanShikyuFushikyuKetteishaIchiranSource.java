package jp.co.ndensan.reams.db.dbc.entity.report.dbc200040;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBCMN63004_高額合算支給決定者一覧表source
 *
 * @reamsid_L DBC-2300-045 jiangxiaolong
 */
public class GassanShikyuFushikyuKetteishaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 21, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "chushutsuJoken", length = 27, order = 2)
    public RString chushutsuJoken;
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
    @ReportItem(name = "listCerter_1", length = 6, order = 15)
    public RString listCerter_1;
    @ReportItem(name = "listCerter_2", length = 10, order = 16)
    public RString listCerter_2;
    @ReportItem(name = "listCerter_3", length = 3, order = 17)
    public RString listCerter_3;
    @ReportItem(name = "listCerter_4", length = 2, order = 18)
    public RString listCerter_4;
    @ReportItem(name = "listUpper_1", length = 34, order = 19)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 17, order = 20)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 9, order = 21)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 13, order = 22)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 38, order = 23)
    public RString listUpper_5;
    @ReportItem(name = "listLower_1", length = 34, order = 24)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 5, order = 25)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 4, order = 26)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 9, order = 27)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 13, order = 28)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 38, order = 29)
    public RString listLower_6;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;

    /**
     * GassanShikyuFushikyuKetteishaIchiranSourceのENUM
     */
    public enum ReportSourceFields {

        printTimeStamp,
        chushutsuJoken,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listCerter_1,
        listCerter_2,
        listCerter_3,
        listCerter_4,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6
    }
}
