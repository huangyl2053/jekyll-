package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会集計表（現在の状況別）のReportSourceです。
 *
 * @reamsid_L DBE-1450-090 duanzhanli
 */
public class ShinsakaiShukeiGenzainojokyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "yukoKijunYMD", length = 11, order = 3)
    public RString yukoKijunYMD;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "listShukei1_1", length = 9, order = 5)
    public RString listShukei1_1;
    @ReportItem(name = "listShukei1_2", length = 9, order = 6)
    public RString listShukei1_2;
    @ReportItem(name = "listShukei1_3", length = 9, order = 7)
    public RString listShukei1_3;
    @ReportItem(name = "listShukei1_4", length = 9, order = 8)
    public RString listShukei1_4;
    @ReportItem(name = "listShukei1_5", length = 9, order = 9)
    public RString listShukei1_5;
    @ReportItem(name = "listShukei1_6", length = 9, order = 10)
    public RString listShukei1_6;
    @ReportItem(name = "listShukei1_7", length = 9, order = 11)
    public RString listShukei1_7;
    @ReportItem(name = "listShukei1_8", length = 9, order = 12)
    public RString listShukei1_8;
    @ReportItem(name = "listShukei2_1", length = 9, order = 13)
    public RString listShukei2_1;
    @ReportItem(name = "listShukei2_2", length = 9, order = 14)
    public RString listShukei2_2;
    @ReportItem(name = "listShukei2_3", length = 9, order = 15)
    public RString listShukei2_3;
    @ReportItem(name = "listShukei2_4", length = 9, order = 16)
    public RString listShukei2_4;
    @ReportItem(name = "listShukei2_5", length = 9, order = 17)
    public RString listShukei2_5;
    @ReportItem(name = "listShukei2_6", length = 9, order = 18)
    public RString listShukei2_6;
    @ReportItem(name = "listShukei2_7", length = 9, order = 19)
    public RString listShukei2_7;
    @ReportItem(name = "listShukei2_8", length = 9, order = 20)
    public RString listShukei2_8;
    @ReportItem(name = "listShukei3_1", length = 9, order = 21)
    public RString listShukei3_1;
    @ReportItem(name = "listShukei3_2", length = 9, order = 22)
    public RString listShukei3_2;
    @ReportItem(name = "listShukei3_3", length = 9, order = 23)
    public RString listShukei3_3;
    @ReportItem(name = "listShukei3_4", length = 9, order = 24)
    public RString listShukei3_4;
    @ReportItem(name = "listShukei3_5", length = 9, order = 25)
    public RString listShukei3_5;
    @ReportItem(name = "listShukei3_6", length = 9, order = 26)
    public RString listShukei3_6;
    @ReportItem(name = "listShukei3_7", length = 9, order = 27)
    public RString listShukei3_7;
    @ReportItem(name = "listShukei3_8", length = 9, order = 28)
    public RString listShukei3_8;
    @ReportItem(name = "listShukei4_1", length = 9, order = 29)
    public RString listShukei4_1;
    @ReportItem(name = "listShukei4_2", length = 9, order = 30)
    public RString listShukei4_2;
    @ReportItem(name = "listShukei4_3", length = 9, order = 31)
    public RString listShukei4_3;
    @ReportItem(name = "listShukei4_4", length = 9, order = 32)
    public RString listShukei4_4;
    @ReportItem(name = "listShukei4_5", length = 9, order = 33)
    public RString listShukei4_5;
    @ReportItem(name = "listShukei4_6", length = 9, order = 34)
    public RString listShukei4_6;
    @ReportItem(name = "listShukei4_7", length = 9, order = 35)
    public RString listShukei4_7;
    @ReportItem(name = "listShukei4_8", length = 9, order = 36)
    public RString listShukei4_8;
    @ReportItem(name = "listShukei5_1", length = 9, order = 37)
    public RString listShukei5_1;
    @ReportItem(name = "listShukei5_2", length = 9, order = 38)
    public RString listShukei5_2;
    @ReportItem(name = "listShukei5_3", length = 9, order = 39)
    public RString listShukei5_3;
    @ReportItem(name = "listShukei5_4", length = 9, order = 40)
    public RString listShukei5_4;
    @ReportItem(name = "listShukei5_5", length = 9, order = 41)
    public RString listShukei5_5;
    @ReportItem(name = "listShukei5_6", length = 9, order = 42)
    public RString listShukei5_6;
    @ReportItem(name = "listShukei5_7", length = 9, order = 43)
    public RString listShukei5_7;
    @ReportItem(name = "listShukei5_8", length = 9, order = 44)
    public RString listShukei5_8;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shichosonName,

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
