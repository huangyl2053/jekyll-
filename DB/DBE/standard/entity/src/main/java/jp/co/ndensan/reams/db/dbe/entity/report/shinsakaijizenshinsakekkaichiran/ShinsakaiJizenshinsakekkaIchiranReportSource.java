package jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 事前審査結果一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1640-040 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "gogitaiNo", length = 2, order = 2)
    public RString gogitaiNo;
    @ReportItem(name = "shinsakaiNo", length = 4, order = 3)
    public RString shinsakaiNo;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 21, order = 4)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "printTimeStamp", length = 34, order = 5)
    public RString printTimeStamp;
    @ReportItem(name = "cityName", length = 20, order = 6)
    public RString cityName;
    @ReportItem(name = "listShinsain_1", length = 20, order = 7)
    public RString listShinsain_1;
    @ReportItem(name = "listShinsain_2", length = 20, order = 8)
    public RString listShinsain_2;
    @ReportItem(name = "listShinsain_3", length = 20, order = 9)
    public RString listShinsain_3;
    @ReportItem(name = "listShinsain_4", length = 20, order = 10)
    public RString listShinsain_4;
    @ReportItem(name = "listShinsain_5", length = 20, order = 11)
    public RString listShinsain_5;
    @ReportItem(name = "listShukeihyo_1", length = 2, order = 12)
    public RString listShukeihyo_1;
    @ReportItem(name = "listShukeihyo_2", length = 1, order = 13)
    public RString listShukeihyo_2;
    @ReportItem(name = "listShukeihyo_3", length = 10, order = 14)
    public RString listShukeihyo_3;
    @ReportItem(name = "listShukeihyo_4", length = 2, order = 15)
    public RString listShukeihyo_4;
    @ReportItem(name = "listShukeihyo_5", length = 15, order = 16)
    public RString listShukeihyo_5;
    @ReportItem(name = "listShukeihyo_6", length = 2, order = 17)
    public RString listShukeihyo_6;
    @ReportItem(name = "listShukeihyo_7", length = 2, order = 18)
    public RString listShukeihyo_7;
    @ReportItem(name = "listShukeihyo_8", length = 15, order = 19)
    public RString listShukeihyo_8;
    @ReportItem(name = "listShukeihyo_9", length = 2, order = 20)
    public RString listShukeihyo_9;
    @ReportItem(name = "listShukeihyo_10", length = 2, order = 21)
    public RString listShukeihyo_10;
    @ReportItem(name = "listShukeihyo_11", length = 15, order = 22)
    public RString listShukeihyo_11;
    @ReportItem(name = "listShukeihyo_12", length = 2, order = 23)
    public RString listShukeihyo_12;
    @ReportItem(name = "listShukeihyo_13", length = 2, order = 24)
    public RString listShukeihyo_13;
    @ReportItem(name = "listShukeihyo_14", length = 15, order = 25)
    public RString listShukeihyo_14;
    @ReportItem(name = "listShukeihyo_15", length = 2, order = 26)
    public RString listShukeihyo_15;
    @ReportItem(name = "listShukeihyo_16", length = 2, order = 27)
    public RString listShukeihyo_16;
    @ReportItem(name = "listShukeihyo_17", length = 15, order = 28)
    public RString listShukeihyo_17;
    @ReportItem(name = "listShukeihyo_18", length = 2, order = 29)
    public RString listShukeihyo_18;
    @ReportItem(name = "listShukeihyo_19", length = 2, order = 30)
    public RString listShukeihyo_19;
    @ReportItem(name = "listShukeihyo_20", length = 2, order = 31)
    public RString listShukeihyo_20;
    @ReportItem(name = "listShukeihyo_21", length = 5, order = 32)
    public RString listShukeihyo_21;
    @ReportItem(name = "listShukeihyo_22", length = 5, order = 33)
    public RString listShukeihyo_22;
    @ReportItem(name = "listShukeihyo_23", length = 13, order = 34)
    public RString listShukeihyo_23;
    @ReportItem(name = "listShukeihyo_24", length = 4, order = 35)
    public RString listShukeihyo_24;
    @ReportItem(name = "listShukeihyo_25", length = 9, order = 36)
    public RString listShukeihyo_25;
    @ReportItem(name = "listShukeihyo_26", length = 9, order = 37)
    public RString listShukeihyo_26;
    @ReportItem(name = "listShukeihyo_27", length = 15, order = 38)
    public RString listShukeihyo_27;
    @ReportItem(name = "itchiKensu", length = 2, order = 39)
    public RString itchiKensu;
    @ReportItem(name = "shinsaKensu", length = 2, order = 40)
    public RString shinsaKensu;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
