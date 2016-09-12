/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 高額介護サービス費給付対象者一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC-0980-490 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaIchiranProperty extends ReportPropertyBase<KogakuKyufuTaishoshaIchiranSource> {

    private final List<RString> pageBreakKeys;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    /**
     * コンストラクタです。
     *
     * @param outputOrder IOutputOrder
     */
    public KogakuKyufuTaishoshaIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200014.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(KogakuKyufuTaishoshaIchiranSource.ReportSourceFields.hokenshaNo.name()));
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        RString 改頁６ = RString.EMPTY;

        if (outputOrder == null) {
            return;
        }
        List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
        if (iSetSortItemList == null) {
            return;
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
        if (INDEX_5 < iSetSortItemList.size() && iSetSortItemList.get(INDEX_5).is改頁項目()) {
            改頁６ = to帳票物理名(iSetSortItemList.get(INDEX_5).get項目ID());
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
        if (!改頁６.isEmpty()) {
            pageBreakKeys.add(改頁６);
        }
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (DBC200014ShutsuryokujunEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuKyufuTaishoshaIchiranSource.ReportSourceFields.listUpper_2.name());
        } else if (DBC200014ShutsuryokujunEnum.サービス提供年月.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuKyufuTaishoshaIchiranSource.ReportSourceFields.listUpper_3.name());
        } else if (DBC200014ShutsuryokujunEnum.通知書番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(KogakuKyufuTaishoshaIchiranSource.ReportSourceFields.listUpper_1.name());
        }
        return 帳票物理名;
    }

    /**
     * 帳票設計_DBC200014_高額介護サービス費給付対象者一覧表 出力順設定可能項目です。
     */
    public enum DBC200014ShutsuryokujunEnum implements IReportItems {

        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("hokenshaNo"), new RString("対象者TBL.\"shokisaiHokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listUpper_2"), new RString("DbWT0001.\"hihokenshaNo\"")),
        /**
         * サービス提供年月
         */
        サービス提供年月(new RString("0364"), new RString("listUpper_3"), new RString("対象者TBL.\"serviceTeikyoYm\"")),
        /**
         * 通知書番号
         */
        通知書番号(new RString("0202"), new RString("listUpper_1"), new RString("対象者TBL.\"tsuchishoNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200014ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名,
                RString myBatis項目名) {
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
