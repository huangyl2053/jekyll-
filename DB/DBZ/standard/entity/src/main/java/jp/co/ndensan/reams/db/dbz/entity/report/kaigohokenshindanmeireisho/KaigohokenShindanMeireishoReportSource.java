package jp.co.ndensan.reams.db.dbz.entity.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 介護保険診断命令書のReportSource
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
public class KaigohokenShindanMeireishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD", length = 12, order = 1)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 4)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 5)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 6)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 7)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 8)
    public RString koinMojiretsu;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 10)
    public RString bunshoNo;
    @ReportItem(name = "yubinNo", length = 8, order = 11)
    public RString yubinNo;
    @ReportItem(name = "jushoText", order = 12)
    public RString jushoText;
    @ReportItem(name = "hihokenshaName1", order = 13)
    public RString hihokenshaName1;
    @ReportItem(name = "meishoFuyo", length = 3, order = 14)
    public RString meishoFuyo;
    @ReportItem(name = "customerBarCode", order = 15)
    public RString customerBarCode;
    @ReportItem(name = "pageCount", length = 8, order = 16)
    public RString pageCount;
    @ReportItem(name = "sonota", length = 14, order = 17)
    public RString sonota;
    @ReportItem(name = "title", length = 50, order = 18)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 19)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 20)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 21)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 22)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 23)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 24)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 25)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 26)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 27)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 28)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 29)
    public RString hihokenshaNo10;
    @ReportItem(name = "hihokenshaName2", order = 30)
    public RString hihokenshaName2;
    @ReportItem(name = "iryokikanName", order = 31)
    public RString iryokikanName;
    @ReportItem(name = "tantoIshiName", order = 32)
    public RString tantoIshiName;
    @ReportItem(name = "iryokikanYubinNo", length = 8, order = 33)
    public RString iryokikanYubinNo;
    @ReportItem(name = "iryokikanJusho", order = 34)
    public RString iryokikanJusho;
    @ReportItem(name = "telNo", length = 14, order = 35)
    public RString telNo;
    @ReportItem(name = "jushinKikan", length = 25, order = 36)
    public RString jushinKikan;
    @ReportItem(name = "jushinArea", order = 37)
    public RString jushinArea;
    @ReportItem(name = "tsuchibun2", order = 38)
    public RString tsuchibun2;
    @ReportItem(name = "atenaRemban", order = 39)
    public RString atenaRemban;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    @ReportPerson(id = "X")
    public ShikibetsuCode 識別コード;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation 拡張情報;
// </editor-fold>
}
