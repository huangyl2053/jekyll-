package jp.co.ndensan.reams.db.dbe.entity.report.source.iinhoshushiharai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会委員報酬支払通知書のReportSourceクラスです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
public class IinhoshushiharaiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD1", length = 12, order = 1)
    public RString hakkoYMD1;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 4)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 5)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 6)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 7)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 8)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo", length = 8, order = 10)
    public RString yubinNo;
    @ReportItem(name = "jushoText", order = 11)
    public RString jushoText;
    @ReportItem(name = "kikanNameText", order = 12)
    public RString kikanNameText;
    @ReportItem(name = "shimeiText", order = 13)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo", length = 3, order = 14)
    public RString meishoFuyo;
    @ReportItem(name = "customerBarCode", order = 15)
    public RString customerBarCode;
    @ReportItem(name = "sonota", length = 14, order = 16)
    public RString sonota;
    @ReportItem(name = "pageCount", length = 8, order = 17)
    public RString pageCount;
    @ReportItem(name = "title", length = 30, order = 18)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 19)
    public RString tsuchibun1;
    @ReportItem(name = "IshiName", length = 30, order = 20)
    public RString ishiName;
    @ReportItem(name = "listHoshuhi_1", length = 8, order = 21)
    public RString listHoshuhi_1;
    @ReportItem(name = "listGokei_1", length = 8, order = 22)
    public RString listGokei_1;
    @ReportItem(name = "furikomiyoteiYMD", length = 11, order = 23)
    public RString furikomiyoteiYMD;
    @ReportItem(name = "kinyukikan", length = 40, order = 24)
    public RString kinyukikan;
    @ReportItem(name = "shubetsu", length = 6, order = 25)
    public RString shubetsu;
    @ReportItem(name = "bango", length = 7, order = 26)
    public RString bango;
    @ReportItem(name = "meiginin", length = 40, order = 27)
    public RString meiginin;
    @ReportItem(name = "taishoKikan", length = 25, order = 28)
    public RString taishoKikan;
    @ReportItem(name = "shinsakaiShussekiCount", length = 3, order = 29)
    public RString shinsakaiShussekiCount;
    @ReportItem(name = "tsuchibun2", order = 30)
    public RString tsuchibun2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
