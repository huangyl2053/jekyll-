package jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 認定調査報酬請求書のチェックリストのReportSourceクラスです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
public class ChosahoshuseikyuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD", length = 11, order = 1)
    public RString hakkoYMD;
    @ReportItem(name = "chosaItakusakiYubimNo", length = 8, order = 2)
    public RString chosaItakusakiYubimNo;
    @ReportItem(name = "chosaItakusakiJusho", length = 30, order = 3)
    public RString chosaItakusakiJusho;
    @ReportItem(name = "chosaItakusakiName", length = 30, order = 4)
    public RString chosaItakusakiName;
    @ReportItem(name = "daihyoshaName", length = 30, order = 5)
    public RString daihyoshaName;
    @ReportItem(name = "title", length = 30, order = 6)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 7)
    public RString tsuchibun1;
    @ReportItem(name = "taishoKikan", length = 25, order = 8)
    public RString taishoKikan;
    @ReportItem(name = "gokeiKingaku2", length = 10, order = 9)
    public RString gokeiKingaku2;
    @ReportItem(name = "listGokei_1", length = 3, order = 10)
    public RString listGokei_1;
    @ReportItem(name = "listGokei_2", length = 8, order = 11)
    public RString listGokei_2;
    @ReportItem(name = "listGokei_3", length = 9, order = 12)
    public RString listGokei_3;
    @ReportItem(name = "shokeiKingaku", length = 10, order = 13)
    public RString shokeiKingaku;
    @ReportItem(name = "sakuseiKensuKei", length = 3, order = 14)
    public RString sakuseiKensuKei;
    @ReportItem(name = "shohizei", length = 8, order = 15)
    public RString shohizei;
    @ReportItem(name = "gokeiKingaku1", length = 10, order = 16)
    public RString gokeiKingaku1;
    @ReportItem(name = "tsuchibun2", order = 17)
    public RString tsuchibun2;
    @ReportItem(name = "ninteichosaItakusakiCode", order = 18)
    public RString ninteichosaItakusakiCode;
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

        ninteichosaItakusakiCode
    }
}
