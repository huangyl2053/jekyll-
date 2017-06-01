package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書作成料請求一覧表のReportSourceです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
public class ShujiiIkenshoSeikyuIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonName", length = 20, order = 2)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "listIkeniraimishori_1", length = 3, order = 4)
    public RString listIkeniraimishori_1;
    @ReportItem(name = "listIkeniraimishori_2", length = 6, order = 5)
    public RString listIkeniraimishori_2;
    @ReportItem(name = "listIkeniraimishori_3", length = 7, order = 6)
    public RString listIkeniraimishori_3;
    @ReportItem(name = "listIkeniraimishori_4", length = 20, order = 7)
    public RString listIkeniraimishori_4;
    @ReportItem(name = "listIkeniraimishori_5", length = 10, order = 8)
    public RString listIkeniraimishori_5;
    @ReportItem(name = "listIkeniraimishori_6", length = 9, order = 9)
    public RString listIkeniraimishori_6;
    @ReportItem(name = "listIkeniraimishori_7", length = 1, order = 10)
    public RString listIkeniraimishori_7;
    @ReportItem(name = "listIkeniraimishori_8", length = 9, order = 11)
    public RString listIkeniraimishori_8;
    @ReportItem(name = "listIkeniraimishori_9", length = 2, order = 12)
    public RString listIkeniraimishori_9;
    @ReportItem(name = "listIkeniraimishori_10", length = 40, order = 13)
    public RString listIkeniraimishori_10;
    @ReportItem(name = "listIkeniraimishori_11", length = 9, order = 14)
    public RString listIkeniraimishori_11;
    @ReportItem(name = "listIkeniraimishori_12", length = 9, order = 15)
    public RString listIkeniraimishori_12;
    @ReportItem(name = "listIkeniraimishori_13", length = 7, order = 16)
    public RString listIkeniraimishori_13;
    @ReportItem(name = "listIkeniraimishori_14", length = 8, order = 17)
    public RString listIkeniraimishori_14;
    @ReportItem(name = "listIkeniraimishori_15", length = 9, order = 18)
    public RString listIkeniraimishori_15;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation 拡張情報;
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        shichosonName
    }
}
