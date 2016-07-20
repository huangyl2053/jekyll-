package jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 認定調査報酬支払明細書のチェックリストのReportSourceクラスです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
public class ChosaHoshumeisaiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 25, order = 1)
    public RString title;
    @ReportItem(name = "taishoKikan", length = 25, order = 2)
    public RString taishoKikan;
    @ReportItem(name = "hokenshaName", length = 20, order = 3)
    public RString hokenshaName;
    @ReportItem(name = "chosaItakusakiName", length = 40, order = 4)
    public RString chosaItakusakiName;
    @ReportItem(name = "chosainName", length = 20, order = 5)
    public RString chosainName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 6)
    public RString printTimeStamp;
    @ReportItem(name = "listChosaSakusei_1", length = 2, order = 7)
    public RString listChosaSakusei_1;
    @ReportItem(name = "listChosaSakusei_2", length = 10, order = 8)
    public RString listChosaSakusei_2;
    @ReportItem(name = "listChosaSakusei_3", length = 20, order = 9)
    public RString listChosaSakusei_3;
    @ReportItem(name = "listChosaSakusei_4", length = 9, order = 10)
    public RString listChosaSakusei_4;
    @ReportItem(name = "listChosaSakusei_5", length = 9, order = 11)
    public RString listChosaSakusei_5;
    @ReportItem(name = "listChosaSakusei_6", length = 1, order = 12)
    public RString listChosaSakusei_6;
    @ReportItem(name = "listChosaSakusei_7", length = 1, order = 13)
    public RString listChosaSakusei_7;
    @ReportItem(name = "listChosaSakusei_8", length = 1, order = 14)
    public RString listChosaSakusei_8;
    @ReportItem(name = "listChosaSakusei_9", length = 1, order = 15)
    public RString listChosaSakusei_9;
    @ReportItem(name = "listChosaSakusei_10", length = 5, order = 16)
    public RString listChosaSakusei_10;
    @ReportItem(name = "listGokeikensu_1", length = 3, order = 17)
    public RString listGokeikensu_1;
    @ReportItem(name = "listGokeikensu_2", length = 3, order = 18)
    public RString listGokeikensu_2;
    @ReportItem(name = "listGokeikensu_3", length = 3, order = 19)
    public RString listGokeikensu_3;
    @ReportItem(name = "listGokeikensu_4", length = 3, order = 20)
    public RString listGokeikensu_4;
    @ReportItem(name = "gokeiKingaku", length = 9, order = 21)
    public RString gokeiKingaku;
    @ReportItem(name = "shouhiZei", length = 9, order = 22)
    public RString shouhiZei;
    @ReportItem(name = "gokeiSeikyuKingaku", length = 9, order = 23)
    public RString gokeiSeikyuKingaku;
    @ReportItem(name = "ninteichosainCode", length = 9, order = 24)
    public RString ninteichosainCode;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        chosaItakusakiName,
        ninteichosainCode
    }
}
