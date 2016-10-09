package jp.co.ndensan.reams.db.dbc.entity.report.dbc200031;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMN62002_高額合算自己負担額補正結果一覧表のsource
 *
 * @reamsid_L DBC-2320-040 jiangxiaolong
 */
public class GassanJikofutangakuHoseiIchiranSource implements IReportSource {
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
    @ReportItem(name = "kaipage1", length = 20, order = 9)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 10)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 11)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 12)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 13)
    public RString kaipage5;
    @ReportItem(name = "listList1_1", length = 10, order = 14)
    public RString listList1_1;
    @ReportItem(name = "listList1_2", length = 13, order = 15)
    public RString listList1_2;
    @ReportItem(name = "listList1_3", length = 10, order = 16)
    public RString listList1_3;
    @ReportItem(name = "listList1_4", length = 1, order = 17)
    public RString listList1_4;
    @ReportItem(name = "listList1_5", length = 17, order = 18)
    public RString listList1_5;
    @ReportItem(name = "listList1_6", length = 6, order = 19)
    public RString listList1_6;
    @ReportItem(name = "listList1_7", length = 24, order = 20)
    public RString listList1_7;
    @ReportItem(name = "listList1_8", length = 13, order = 21)
    public RString listList1_8;
    @ReportItem(name = "listList1_9", length = 13, order = 22)
    public RString listList1_9;
    @ReportItem(name = "listList1_10", length = 13, order = 23)
    public RString listList1_10;
    @ReportItem(name = "listList1_11", length = 13, order = 24)
    public RString listList1_11;
    @ReportItem(name = "listList1_12", length = 13, order = 25)
    public RString listList1_12;
    @ReportItem(name = "listList1_13", length = 13, order = 26)
    public RString listList1_13;
    @ReportItem(name = "listList1_14", length = 2, order = 27)
    public RString listList1_14;
    @ReportItem(name = "listList1_15", length = 2, order = 28)
    public RString listList1_15;
    @ReportItem(name = "listList1_16", length = 1, order = 29)
    public RString listList1_16;
    @ReportItem(name = "listList1_17", length = 1, order = 30)
    public RString listList1_17;
    @ReportItem(name = "add_hokenshaNo", length = 38, order = 31)
    public RString add_hokenshaNo;
    @ReportItem(name = "add_shichosonCode", length = 38, order = 32)
    public RString add_shichosonCode;
    @ReportItem(name = "add_kanaMeisho", length = 38, order = 33)
    public RString add_kanaMeisho;
    @ReportItem(name = "add_choikiCode", length = 38, order = 34)
    public RString add_choikiCode;
    @ReportItem(name = "add_gyoseikuCode", length = 38, order = 35)
    public RString add_gyoseikuCode;
    @ReportItem(name = "add_yubinNo", length = 38, order = 36)
    public RString add_yubinNo;
    @ReportItem(name = "add_shinnseiYMD", length = 38, order = 37)
    public RString add_shinnseiYMD;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * GassanJikofutangakuHoseiIchiranSourceのENUM
     */
    public enum ReportSourceFields {

        printTimeStamp,
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
        listList1_1,
        listList1_2,
        listList1_3,
        listList1_4,
        listList1_5,
        listList1_6,
        listList1_7,
        listList1_8,
        listList1_9,
        listList1_10,
        listList1_11,
        listList1_12,
        listList1_13,
        listList1_14,
        listList1_15,
        listList1_16,
        listList1_17
    }
}
