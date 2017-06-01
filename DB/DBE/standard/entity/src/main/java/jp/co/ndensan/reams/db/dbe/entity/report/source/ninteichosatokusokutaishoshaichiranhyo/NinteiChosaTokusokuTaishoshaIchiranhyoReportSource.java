/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 主治医意見書督促対象者一覧表のReportSourceです。
 *
 * @reamsid_L DBE-0060-030 hezhenzhen
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 50, order = 1)
    public RString title;
    @ReportItem(name = "cityCode", length = 6, order = 2)
    public RString cityCode;
    @ReportItem(name = "cityName", length = 20, order = 3)
    public RString cityName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 4)
    public RString printTimeStamp;
    @ReportItem(name = "kikanNameTitle", length = 40, order = 5)
    public RString kikanNameTitle;
    @ReportItem(name = "kikanJushoTitle", length = 40, order = 6)
    public RString kikanJushoTitle;
    @ReportItem(name = "nameTitle", length = 20, order = 7)
    public RString nameTitle;
    @ReportItem(name = "kikanTelTitle", length = 20, order = 8)
    public RString kikanTelTitle;
    @ReportItem(name = "listNo_1", length = 3, order = 9)
    public RString listNo_1;
    @ReportItem(name = "listUpper1_1", length = 10, order = 10)
    public RString listUpper1_1;
    @ReportItem(name = "listUpper1_2", length = 20, order = 11)
    public RString listUpper1_2;
    @ReportItem(name = "listShinseiYMD_1", length = 10, order = 12)
    public RString listShinseiYMD_1;
    @ReportItem(name = "listTokusokujoHakkoYMD_1", length = 10, order = 13)
    public RString listTokusokujoHakkoYMD_1;
    @ReportItem(name = "listUpper2_1", length = 40, order = 14)
    public RString listUpper2_1;
    @ReportItem(name = "listUpper2_2", length = 40, order = 15)
    public RString listUpper2_2;
    @ReportItem(name = "listLower1_1", length = 10, order = 16)
    public RString listLower1_1;
    @ReportItem(name = "listLower1_2", length = 20, order = 17)
    public RString listLower1_2;
    @ReportItem(name = "listLower2_1", length = 30, order = 18)
    public RString listLower2_1;
    @ReportItem(name = "listLower2_2", length = 13, order = 19)
    public RString listLower2_2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation 拡張情報;
// </editor-fold>
}
