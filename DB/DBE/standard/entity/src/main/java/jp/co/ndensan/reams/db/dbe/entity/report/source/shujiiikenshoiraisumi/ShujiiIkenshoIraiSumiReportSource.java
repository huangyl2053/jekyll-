package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoiraisumi;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書依頼済み一覧表のReportSourceです。
 *
 * @reamsid_L DBE-1390-160 suguangjun
 */
public class ShujiiIkenshoIraiSumiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listIkemmiteishutsu_1", length = 3, order = 4)
    public RString listIkemmiteishutsu_1;
    @ReportItem(name = "listIkemmiteishutsu_2", length = 6, order = 5)
    public RString listIkemmiteishutsu_2;
    @ReportItem(name = "listIkemmiteishutsu_3", length = 7, order = 6)
    public RString listIkemmiteishutsu_3;
    @ReportItem(name = "listIkemmiteishutsu_4", length = 20, order = 7)
    public RString listIkemmiteishutsu_4;
    @ReportItem(name = "listIkemmiteishutsu_5", length = 10, order = 8)
    public RString listIkemmiteishutsu_5;
    @ReportItem(name = "listIkemmiteishutsu_6", length = 9, order = 9)
    public RString listIkemmiteishutsu_6;
    @ReportItem(name = "listIkemmiteishutsu_7", length = 1, order = 10)
    public RString listIkemmiteishutsu_7;
    @ReportItem(name = "listIkemmiteishutsu_8", length = 9, order = 11)
    public RString listIkemmiteishutsu_8;
    @ReportItem(name = "listIkemmiteishutsu_9", length = 13, order = 12)
    public RString listIkemmiteishutsu_9;
    @ReportItem(name = "listIkemmiteishutsu_10", length = 40, order = 13)
    public RString listIkemmiteishutsu_10;
    @ReportItem(name = "listIkemmiteishutsu_11", length = 40, order = 14)
    public RString listIkemmiteishutsu_11;
    @ReportItem(name = "listIkemmiteishutsu_12", length = 9, order = 15)
    public RString listIkemmiteishutsu_12;
    @ReportItem(name = "listIkemmiteishutsu_13", length = 9, order = 16)
    public RString listIkemmiteishutsu_13;
    @ReportItem(name = "listIkemmiteishutsu_14", length = 9, order = 17)
    public RString listIkemmiteishutsu_14;
    @ReportItem(name = "listIkemmiteishutsu_15", length = 9, order = 18)
    public RString listIkemmiteishutsu_15;
    @ReportItem(name = "listIkemmiteishutsu_16", length = 9, order = 19)
    public RString listIkemmiteishutsu_16;
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
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shichosonName
    }
}
