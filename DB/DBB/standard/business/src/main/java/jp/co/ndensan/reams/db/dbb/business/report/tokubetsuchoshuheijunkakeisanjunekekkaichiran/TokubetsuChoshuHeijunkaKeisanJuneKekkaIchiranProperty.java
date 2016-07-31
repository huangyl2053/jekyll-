/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource.KaiPage;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
public class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty extends ReportPropertyBase<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200003.getReportId();
    private static final RString ENCLOSURE = new RString("\"");
    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ID);
        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        List<ISetSortItem> list = outputOrder.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = get帳票物理名(list.get(0).get項目ID());
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = get帳票物理名(list.get(INDEX_1).get項目ID());
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = get帳票物理名(list.get(INDEX_2).get項目ID());
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = get帳票物理名(list.get(INDEX_3).get項目ID());
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = get帳票物理名(list.get(INDEX_4).get項目ID());
        }

        if (!改頁１.isEmpty()) {
            pageBreakKeys.add(改頁１);
        }
        if (!改頁２.isEmpty()) {
            pageBreakKeys.add(改頁２);
        }
        if (!改頁３.isEmpty()) {
            pageBreakKeys.add(改頁３);
        }
        if (!改頁４.isEmpty()) {
            pageBreakKeys.add(改頁４);
        }
        if (!改頁５.isEmpty()) {
            pageBreakKeys.add(改頁５);
        }
    }

    private RString get帳票物理名(RString 項目ID) {
        RString 帳票物理名 = new RString(KaiPage.listLower_3.name());
        if (DBB200003_HeijunkaKeisanJuneKekkaIchiran.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaiPage.listUpper_3.name());
        } else if (DBB200003_HeijunkaKeisanJuneKekkaIchiran.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaiPage.listLower_2.name());
        } else if (DBB200003_HeijunkaKeisanJuneKekkaIchiran.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaiPage.listUpper_2.name());
        } else if (DBB200003_HeijunkaKeisanJuneKekkaIchiran.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaiPage.listLower_1.name());
        }
        return 帳票物理名;
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource>
     * @param catalog BreakerCatalog<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource>
     * @return Breaker
     */
    @Override
    public Breakers<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> defineBreakers(
            Breakers<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> breakers,
            BreakerCatalog<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            pageBreakKeys) {
            @Override
            public ReportLineRecord<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> currentRecord,
                    ReportLineRecord<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票分類ID「DBB200003_TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiran」（特別徴収平準化計算（特別徴収6月分）結果一覧表）出力順設定可能項目です。
     */
    public enum DBB200003_HeijunkaKeisanJuneKekkaIchiran implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_choikiCode").concat(ENCLOSURE))),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_gyoseikuCode").concat(ENCLOSURE))),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), ENCLOSURE.concat(new RString("setaiCode").concat(ENCLOSURE))),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), ENCLOSURE.concat(new RString("shikibetsuCode").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), ENCLOSURE.concat(new RString("dtCityCode").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), ENCLOSURE.concat(new RString("hihokenshaNo").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200003_HeijunkaKeisanJuneKekkaIchiran(
                RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }

    }
}
