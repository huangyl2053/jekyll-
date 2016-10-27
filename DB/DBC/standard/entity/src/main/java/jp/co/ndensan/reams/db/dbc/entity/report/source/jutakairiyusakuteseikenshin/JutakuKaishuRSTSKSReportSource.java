package jp.co.ndensan.reams.db.dbc.entity.report.source.jutakairiyusakuteseikenshin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のReportSourceです。
 *
 * @reamsid_L DBC-2860-040 dangjingjing
 */
public class JutakuKaishuRSTSKSReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sofusakiYubinNo", length = 8, order = 1)
    public RString sofusakiYubinNo;
    @ReportItem(name = "jigyoshoJusho", order = 2)
    public RString jigyoshoJusho;
    @ReportItem(name = "jigyoshoName", order = 3)
    public RString jigyoshoName;
    @ReportItem(name = "jigyoshoDaihyoshaShimei", order = 4)
    public RString jigyoshoDaihyoshaShimei;
    @ReportItem(name = "jigyoshaTelNo", length = 20, order = 5)
    public RString jigyoshaTelNo;
    @ReportItem(name = "tsuchoBun", order = 6)
    public RString tsuchoBun;
    @ReportItem(name = "jigyoshaNo", length = 10, order = 7)
    public RString jigyoshaNo;
    @ReportItem(name = "seikyuGaku", length = 9, order = 8)
    public RString seikyuGaku;
    @ReportItem(name = "tanka", length = 6, order = 9)
    public RString tanka;
    @ReportItem(name = "kensu", length = 4, order = 10)
    public RString kensu;
    @ReportItem(name = "hakkoYMD", length = 12, order = 11)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 12)
    public RString ninshoshaYakushokuMei;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
