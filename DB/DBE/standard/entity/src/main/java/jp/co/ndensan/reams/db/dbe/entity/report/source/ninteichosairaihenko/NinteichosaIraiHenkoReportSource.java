package jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 認定調査依頼先変更者一覧表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
public class NinteichosaIraiHenkoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listChosaIraihenko_1", length = 3, order = 4)
    public RString listChosaIraihenko_1;
    @ReportItem(name = "listChosaIraihenko_2", length = 6, order = 5)
    public RString listChosaIraihenko_2;
    @ReportItem(name = "listChosaIraihenko_3", length = 7, order = 6)
    public RString listChosaIraihenko_3;
    @ReportItem(name = "listChosaIraihenko_4", length = 20, order = 7)
    public RString listChosaIraihenko_4;
    @ReportItem(name = "listChosaIraihenko_5", length = 10, order = 8)
    public RString listChosaIraihenko_5;
    @ReportItem(name = "listChosaIraihenko_6", length = 9, order = 9)
    public RString listChosaIraihenko_6;
    @ReportItem(name = "listChosaIraihenko_7", length = 1, order = 10)
    public RString listChosaIraihenko_7;
    @ReportItem(name = "listChosaIraihenko_8", length = 9, order = 11)
    public RString listChosaIraihenko_8;
    @ReportItem(name = "listChosaIraihenko_9", length = 2, order = 12)
    public RString listChosaIraihenko_9;
    @ReportItem(name = "listChosaIraihenko_10", length = 2, order = 13)
    public RString listChosaIraihenko_10;
    @ReportItem(name = "listChosaIraihenko_11", length = 40, order = 14)
    public RString listChosaIraihenko_11;
    @ReportItem(name = "listChosaIraihenko_12", length = 40, order = 15)
    public RString listChosaIraihenko_12;
    @ReportItem(name = "listChosaIraihenko_13", length = 40, order = 16)
    public RString listChosaIraihenko_13;
    @ReportItem(name = "listChosaIraihenko_14", length = 40, order = 17)
    public RString listChosaIraihenko_14;
    @ReportItem(name = "listChosaIraihenko_15", length = 9, order = 18)
    public RString listChosaIraihenko_15;
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
