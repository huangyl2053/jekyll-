package jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBRP36001_2_仮算定異動（一括）結果一覧表
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 6, order = 2)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 4)
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
    @ReportItem(name = "listFuchoki_1", length = 3, order = 15)
    public RString listFuchoki_1;
    @ReportItem(name = "listFuchoki_2", length = 3, order = 16)
    public RString listFuchoki_2;
    @ReportItem(name = "listFuchoki_3", length = 3, order = 17)
    public RString listFuchoki_3;
    @ReportItem(name = "listFuchoki_4", length = 3, order = 18)
    public RString listFuchoki_4;
    @ReportItem(name = "listFuchoki_5", length = 3, order = 19)
    public RString listFuchoki_5;
    @ReportItem(name = "listFuchoki_6", length = 3, order = 20)
    public RString listFuchoki_6;
    @ReportItem(name = "listFuchoki_7", length = 3, order = 21)
    public RString listFuchoki_7;
    @ReportItem(name = "listUpper_1", length = 20, order = 22)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 20, order = 23)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 35, order = 24)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 29, order = 25)
    public RString listUpper_4;
    @ReportItem(name = "listChoteijiyu1_1", length = 10, order = 26)
    public RString listChoteijiyu1_1;
    @ReportItem(name = "listChoteiJiyu2_1", length = 10, order = 27)
    public RString listChoteiJiyu2_1;
    @ReportItem(name = "listCenter_1", length = 13, order = 28)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 10, order = 29)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 10, order = 30)
    public RString listCenter_3;
    @ReportItem(name = "listCenter_4", length = 10, order = 31)
    public RString listCenter_4;
    @ReportItem(name = "listCenter_5", length = 6, order = 32)
    public RString listCenter_5;
    @ReportItem(name = "listCenter_6", length = 6, order = 33)
    public RString listCenter_6;
    @ReportItem(name = "listCenter_7", length = 6, order = 34)
    public RString listCenter_7;
    @ReportItem(name = "listCenter_8", length = 6, order = 35)
    public RString listCenter_8;
    @ReportItem(name = "listCenter_9", length = 6, order = 36)
    public RString listCenter_9;
    @ReportItem(name = "listCenter_10", length = 6, order = 37)
    public RString listCenter_10;
    @ReportItem(name = "listCenter_11", length = 6, order = 38)
    public RString listCenter_11;
    @ReportItem(name = "listCenter_12", length = 6, order = 39)
    public RString listCenter_12;
    @ReportItem(name = "listCenter_13", length = 6, order = 40)
    public RString listCenter_13;
    @ReportItem(name = "listCenter_14", length = 6, order = 41)
    public RString listCenter_14;
    @ReportItem(name = "listCenter_15", length = 2, order = 42)
    public RString listCenter_15;
    @ReportItem(name = "listCenter_16", length = 2, order = 43)
    public RString listCenter_16;
    @ReportItem(name = "listChoteijiyu3_1", length = 10, order = 44)
    public RString listChoteijiyu3_1;
    @ReportItem(name = "listLower_1", length = 13, order = 45)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 10, order = 46)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 10, order = 47)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 10, order = 48)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 6, order = 49)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 6, order = 50)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 6, order = 51)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 6, order = 52)
    public RString listLower_8;
    @ReportItem(name = "listLower_9", length = 6, order = 53)
    public RString listLower_9;
    @ReportItem(name = "listLower_10", length = 6, order = 54)
    public RString listLower_10;
    @ReportItem(name = "listLower_11", length = 6, order = 55)
    public RString listLower_11;
    @ReportItem(name = "listLower_12", length = 6, order = 56)
    public RString listLower_12;
    @ReportItem(name = "listLower_13", length = 6, order = 57)
    public RString listLower_13;
    @ReportItem(name = "listLower_14", length = 6, order = 58)
    public RString listLower_14;
    @ReportItem(name = "listLower_15", length = 2, order = 59)
    public RString listLower_15;
    @ReportItem(name = "listLower_16", length = 2, order = 60)
    public RString listLower_16;
    @ReportItem(name = "listChoteijiyu4_1", length = 10, order = 61)
    public RString listChoteijiyu4_1;

    /**
     * KarisanteiIdoKekkaIchiranSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        nendo,
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
        listFuchoki_1,
        listFuchoki_2,
        listFuchoki_3,
        listFuchoki_4,
        listFuchoki_5,
        listFuchoki_6,
        listFuchoki_7,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listChoteijiyu1_1,
        listChoteiJiyu2_1,
        listCenter_1,
        listCenter_2,
        listCenter_3,
        listCenter_4,
        listCenter_5,
        listCenter_6,
        listCenter_7,
        listCenter_8,
        listCenter_9,
        listCenter_10,
        listCenter_11,
        listCenter_12,
        listCenter_13,
        listCenter_14,
        listCenter_15,
        listCenter_16,
        listChoteijiyu3_1

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

// </editor-fold>
}
