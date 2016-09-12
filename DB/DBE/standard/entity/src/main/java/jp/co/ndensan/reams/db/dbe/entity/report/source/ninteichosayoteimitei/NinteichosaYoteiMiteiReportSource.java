package jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 認定調査予定未定者一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
public class NinteichosaYoteiMiteiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listChosaYoteimitei_1", length = 3, order = 4)
    public RString listChosaYoteimitei_1;
    @ReportItem(name = "listChosaYoteimitei_2", length = 6, order = 5)
    public RString listChosaYoteimitei_2;
    @ReportItem(name = "listChosaYoteimitei_3", length = 7, order = 6)
    public RString listChosaYoteimitei_3;
    @ReportItem(name = "listChosaYoteimitei_4", length = 20, order = 7)
    public RString listChosaYoteimitei_4;
    @ReportItem(name = "listChosaYoteimitei_5", length = 10, order = 8)
    public RString listChosaYoteimitei_5;
    @ReportItem(name = "listChosaYoteimitei_6", length = 9, order = 9)
    public RString listChosaYoteimitei_6;
    @ReportItem(name = "listChosaYoteimitei_7", length = 1, order = 10)
    public RString listChosaYoteimitei_7;
    @ReportItem(name = "listChosaYoteimitei_8", length = 9, order = 11)
    public RString listChosaYoteimitei_8;
    @ReportItem(name = "listChosaYoteimitei_9", length = 2, order = 12)
    public RString listChosaYoteimitei_9;
    @ReportItem(name = "listChosaYoteimitei_10", length = 40, order = 13)
    public RString listChosaYoteimitei_10;
    @ReportItem(name = "listChosaYoteimitei_11", length = 40, order = 14)
    public RString listChosaYoteimitei_11;
    @ReportItem(name = "listChosaYoteimitei_12", length = 40, order = 15)
    public RString listChosaYoteimitei_12;
    @ReportItem(name = "listChosaYoteimitei_13", length = 40, order = 16)
    public RString listChosaYoteimitei_13;
    @ReportItem(name = "listChosaYoteimitei_14", length = 40, order = 17)
    public RString listChosaYoteimitei_14;
    @ReportItem(name = "listChosaYoteimitei_15", length = 40, order = 18)
    public RString listChosaYoteimitei_15;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hokenshaNo;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    /**
     * 改ページ条件です。
     */
    public enum ReportSourceFields {

        shichosonName;
    }

// </editor-fold>
}
