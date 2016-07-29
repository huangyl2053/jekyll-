/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteiidokekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteiidokekkaichiran.KarisanteiIdoKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBRP36001_2_仮算定異動（一括）結果一覧表のプロパティです。
 *
 * @reamsid_L DBB-0850-030 zhaowei
 */
public class KarisanteiIdoKekkaIchiranProperty extends ReportPropertyBase<KarisanteiIdoKekkaIchiranSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString FORMAT = new RString("\"");

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public KarisanteiIdoKekkaIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200013.getReportId());

        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }

            if (INDEX_0 < list.size() && list.get(INDEX_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(0).get項目ID());
            }
            if (INDEX_1 < list.size() && list.get(INDEX_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(INDEX_1).get項目ID());
            }
            if (INDEX_2 < list.size() && list.get(INDEX_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(INDEX_2).get項目ID());
            }
            if (INDEX_3 < list.size() && list.get(INDEX_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(INDEX_3).get項目ID());
            }
            if (INDEX_4 < list.size() && list.get(INDEX_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(INDEX_4).get項目ID());
            }
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

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (KarisanteiIdoKekkaIchiranProperty.BreakerFieldsEnum.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KarisanteiIdoKekkaIchiranSource.ReportSourceFields.listUpper_2.name());
        } else if (KarisanteiIdoKekkaIchiranProperty.BreakerFieldsEnum.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KarisanteiIdoKekkaIchiranSource.ReportSourceFields.hokenshaNo.name());
        } else if (KarisanteiIdoKekkaIchiranProperty.BreakerFieldsEnum.通知書番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KarisanteiIdoKekkaIchiranSource.ReportSourceFields.listUpper_1.name());
        }

        return 帳票物理名;
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<KarisanteiIdoKekkaIchiranSource>
     * @param catalog BreakerCatalog<KarisanteiIdoKekkaIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<KarisanteiIdoKekkaIchiranSource> defineBreakers(
            Breakers<KarisanteiIdoKekkaIchiranSource> breakers,
            BreakerCatalog<KarisanteiIdoKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            pageBreakKeys) {
            @Override
            public ReportLineRecord<KarisanteiIdoKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<KarisanteiIdoKekkaIchiranSource> currentRecord,
                    ReportLineRecord<KarisanteiIdoKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票設計_DBBRP36001_2_仮算定異動（一括）結果一覧表 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT)),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT)),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT)),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT)),
        /**
         * 通知書番号
         */
        通知書番号(new RString("0202"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT)),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), FORMAT.concat(new RString("")).concat(FORMAT));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
