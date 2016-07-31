/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のReportSourceです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeReportSource implements IReportSource {
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
    @ReportItem(name = "pageCount", length = 8, order = 16)
    public RString pageCount;
    @ReportItem(name = "sonota", length = 14, order = 17)
    public RString sonota;
    @ReportItem(name = "title", length = 30, order = 18)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 19)
    public RString tsuchibun1;
    @ReportItem(name = "gokeiKingaku", length = 11, order = 20)
    public RString gokeiKingaku;
    @ReportItem(name = "taishoKikan", length = 25, order = 21)
    public RString taishoKikan;
    @ReportItem(name = "shiharaiKensu", length = 4, order = 22)
    public RString shiharaiKensu;
    @ReportItem(name = "furikomiyoteiYMD", length = 11, order = 23)
    public RString furikomiyoteiYMD;
    @ReportItem(name = "kinyukikan", order = 24)
    public RString kinyukikan;
    @ReportItem(name = "shitenName", order = 25)
    public RString shitenName;
    @ReportItem(name = "meiginin", order = 26)
    public RString meiginin;
    @ReportItem(name = "shubetsu", length = 6, order = 27)
    public RString shubetsu;
    @ReportItem(name = "bango", length = 7, order = 28)
    public RString bango;
    @ReportItem(name = "listShiharaiuchiwake_1", length = 3, order = 29)
    public RString listShiharaiuchiwake_1;
    @ReportItem(name = "listShiharaiuchiwake_2", length = 10, order = 30)
    public RString listShiharaiuchiwake_2;
    @ReportItem(name = "listShiharaiuchiwake_3", length = 30, order = 31)
    public RString listShiharaiuchiwake_3;
    @ReportItem(name = "listShiharaiuchiwake_4", length = 30, order = 32)
    public RString listShiharaiuchiwake_4;
    @ReportItem(name = "listShiharaiuchiwake_5", length = 7, order = 33)
    public RString listShiharaiuchiwake_5;
    @ReportItem(name = "tsuchibun2", order = 34)
    public RString tsuchibun2;
    @ReportItem(name = "iryokikanCode", length = 7, order = 35)
    public RString iryokikanCode;
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokenshaNo;
    @ReportItem(name = "hakkoYMD", length = 11, order = 36)
    public RString hakkoYMD;
    @ReportItem(name = "detail_listShiharaiuchiwake_1", length = 3, order = 37)
    public RString detail_listShiharaiuchiwake_1;
    @ReportItem(name = "detail_listShiharaiuchiwake_2", length = 10, order = 38)
    public RString detail_listShiharaiuchiwake_2;
    @ReportItem(name = "detail_listShiharaiuchiwake_3", length = 30, order = 39)
    public RString detail_listShiharaiuchiwake_3;
    @ReportItem(name = "detail_listShiharaiuchiwake_4", length = 30, order = 40)
    public RString detail_listShiharaiuchiwake_4;
    @ReportItem(name = "detail_listShiharaiuchiwake_5", length = 7, order = 41)
    public RString detail_listShiharaiuchiwake_5;

    @ReportItem(name = "layoutBreakItem", length = 10, order = 999)
    public int layoutBreakItem;
    public static final RString LAYOUTBREAKITEM;

    static {
        LAYOUTBREAKITEM = new RString("layoutBreakItem");
    }
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

        iryokikanCode
    }
}
