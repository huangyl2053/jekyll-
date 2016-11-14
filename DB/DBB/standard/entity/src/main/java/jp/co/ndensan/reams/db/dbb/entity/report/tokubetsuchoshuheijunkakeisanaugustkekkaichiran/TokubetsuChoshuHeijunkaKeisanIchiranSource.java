package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 Source
 *
 * @reamsid_L DBB-0860-060 lijian
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "hyodaiTitle", length = 18, order = 2)
    public RString hyodaiTitle;
    @ReportItem(name = "hyodaiNendo", length = 4, order = 3)
    public RString hyodaiNendo;
    @ReportItem(name = "hokenshacd", length = 6, order = 4)
    public RString hokenshacd;
    @ReportItem(name = "hokenshamei", length = 12, order = 5)
    public RString hokenshamei;
    @ReportItem(name = "sortkeyMei1", length = 10, order = 6)
    public RString sortkeyMei1;
    @ReportItem(name = "sortkeyMei2", length = 10, order = 7)
    public RString sortkeyMei2;
    @ReportItem(name = "sortkeyMei3", length = 10, order = 8)
    public RString sortkeyMei3;
    @ReportItem(name = "sortkeyMei4", length = 10, order = 9)
    public RString sortkeyMei4;
    @ReportItem(name = "sortkeyMei5", length = 10, order = 10)
    public RString sortkeyMei5;
    @ReportItem(name = "kaipageMei1", length = 20, order = 11)
    public RString kaipageMei1;
    @ReportItem(name = "kaipageMei2", length = 20, order = 12)
    public RString kaipageMei2;
    @ReportItem(name = "kaipageMei3", length = 20, order = 13)
    public RString kaipageMei3;
    @ReportItem(name = "kaipageMei4", length = 20, order = 14)
    public RString kaipageMei4;
    @ReportItem(name = "kaipageMei5", length = 20, order = 15)
    public RString kaipageMei5;
    @ReportItem(name = "listUpper_1", length = 20, order = 16)
    public RString listUpper_1;
    @ReportPerson(id = "A")
    @ReportItem(name = "listUpper_2", length = 15, order = 17)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 9, order = 18)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 24, order = 19)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 20, order = 20)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 7, order = 21)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 7, order = 22)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 7, order = 23)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 7, order = 24)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 7, order = 25)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 7, order = 26)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 7, order = 27)
    public RString listUpper_12;
    @ReportItem(name = "listCenter_1", length = 2, order = 28)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 7, order = 29)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 7, order = 30)
    public RString listCenter_3;
    @ReportItem(name = "listCenter_4", length = 12, order = 31)
    public RString listCenter_4;
    @ReportItem(name = "listLower_1", length = 10, order = 32)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 15, order = 33)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 11, order = 34)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 20, order = 35)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 20, order = 36)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 7, order = 37)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 7, order = 38)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 7, order = 39)
    public RString listLower_8;
    @ReportItem(name = "listLower_9", length = 7, order = 40)
    public RString listLower_9;
    @ReportItem(name = "listLower_10", length = 7, order = 41)
    public RString listLower_10;
    @ReportItem(name = "listLower_11", length = 7, order = 42)
    public RString listLower_11;
    @ReportItem(name = "listLower_12", length = 7, order = 43)
    public RString listLower_12;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
