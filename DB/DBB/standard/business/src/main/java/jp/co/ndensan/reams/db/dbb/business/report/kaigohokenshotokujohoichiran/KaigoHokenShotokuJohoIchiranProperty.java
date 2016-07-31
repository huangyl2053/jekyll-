/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource.KaigoHoken;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimplePageBreaker;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のProperty
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranProperty extends ReportPropertyBase<KaigoHokenShotokuJohoIchiranSource> {

    private static final RString FORMAT = new RString("\"");
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
    public KaigoHokenShotokuJohoIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200008.getReportId());

        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        if (outputOrder == null) {
            return;
        }
        List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
        if (iSetSortItemList == null) {
            return;
        }

        if (INDEX_0 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_0).is改頁項目()) {
            改頁１ = to帳票物理名(iSetSortItemList.get(0).get項目ID());
        }
        if (INDEX_1 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_1).is改頁項目()) {
            改頁２ = to帳票物理名(iSetSortItemList.get(INDEX_1).get項目ID());
        }
        if (INDEX_2 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_2).is改頁項目()) {
            改頁３ = to帳票物理名(iSetSortItemList.get(INDEX_2).get項目ID());
        }
        if (INDEX_3 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_3).is改頁項目()) {
            改頁４ = to帳票物理名(iSetSortItemList.get(INDEX_3).get項目ID());
        }
        if (INDEX_4 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_4).is改頁項目()) {
            改頁５ = to帳票物理名(iSetSortItemList.get(INDEX_4).get項目ID());
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

    @Override
    public Breakers<KaigoHokenShotokuJohoIchiranSource> defineBreakers(
            Breakers<KaigoHokenShotokuJohoIchiranSource> breakers,
            BreakerCatalog<KaigoHokenShotokuJohoIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(





            pageBreakKeys) {
            @Override
            public ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> occuredBreak(
                    ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> currentRecord,
                    ReportLineRecord<KaigoHokenShotokuJohoIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (DBB200008ShutsuryokujunEnum.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHoken.listIchiranhyoUpper_2.name());
        } else if (DBB200008ShutsuryokujunEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHoken.listIchiranhyoLower_1.name());
        } else if (DBB200008ShutsuryokujunEnum.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KaigoHoken.listIchiranhyoUpper_3.name());
        }

        return 帳票物理名;
    }

    /**
     * 帳票分類ID「DBB200008_KaigoHokenShotokuJohoIchiran」（介護保険所得情報一覧表）出力順設定可能項目です。
     */
    public enum DBB200008ShutsuryokujunEnum implements IReportItems {

        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), FORMAT.concat(new RString("setaiCode")).concat(FORMAT)),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), FORMAT.concat(new RString("shikibetsuCode")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), FORMAT.concat(new RString("hihokenshaNo")).concat(FORMAT));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200008ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
