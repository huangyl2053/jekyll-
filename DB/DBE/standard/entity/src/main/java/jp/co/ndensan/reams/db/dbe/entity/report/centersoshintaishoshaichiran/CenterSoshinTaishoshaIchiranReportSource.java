package jp.co.ndensan.reams.db.dbe.entity.report.centersoshintaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

public class CenterSoshinTaishoshaIchiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "listTaishoshaIchiran_1", length = 6, order = 2)
    public RString listTaishoshaIchiran_1;
    @ReportItem(name = "listTaishoshaIchiran_2", length = 10, order = 3)
    public RString listTaishoshaIchiran_2;
    @ReportItem(name = "listTaishoshaIchiran_3", length = 10, order = 4)
    public RString listTaishoshaIchiran_3;
    @ReportItem(name = "listTaishoshaIchiran_4", length = 20, order = 5)
    public RString listTaishoshaIchiran_4;
    @ReportItem(name = "listTaishoshaIchiran_5", length = 9, order = 6)
    public RString listTaishoshaIchiran_5;
    @ReportItem(name = "listTaishoshaIchiran_6", length = 6, order = 7)
    public RString listTaishoshaIchiran_6;
    @ReportItem(name = "listTaishoshaIchiran_7", length = 6, order = 8)
    public RString listTaishoshaIchiran_7;
    @ReportItem(name = "listTaishoshaIchiran_8", length = 6, order = 9)
    public RString listTaishoshaIchiran_8;
    @ReportItem(name = "listTaishoshaIchiran_9", length = 4, order = 10)
    public RString listTaishoshaIchiran_9;
    @ReportItem(name = "listTaishoshaIchiran_10", length = 9, order = 11)
    public RString listTaishoshaIchiran_10;
    @ReportItem(name = "listTaishoshaIchiran_11", length = 9, order = 12)
    public RString listTaishoshaIchiran_11;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation 拡張情報;
// </editor-fold>
}
