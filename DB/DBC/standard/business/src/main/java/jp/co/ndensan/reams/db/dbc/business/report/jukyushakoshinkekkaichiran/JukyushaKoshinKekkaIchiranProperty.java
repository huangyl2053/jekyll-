/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
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
 * 受給者情報更新結果情報取込一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKoshinKekkaIchiranProperty extends ReportPropertyBase<JukyushaKoshinKekkaIchiranSource> {

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
    public JukyushaKoshinKekkaIchiranProperty(IOutputOrder outputOrder) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200055.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name()));
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

        if (DBC120030ShutsuryokujunEnum.保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name());
        } else if (DBC120030ShutsuryokujunEnum.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.listList1_4.name());
        } else if (DBC120030ShutsuryokujunEnum.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name());
        } else if (DBC120030ShutsuryokujunEnum.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name());
        } else if (DBC120030ShutsuryokujunEnum.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.listList1_6.name());
        } else if (DBC120030ShutsuryokujunEnum.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name());
        } else if (DBC120030ShutsuryokujunEnum.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(JukyushaKoshinKekkaIchiranSource.ReportSourceFields.hokenshaNo.name());
        }
        return 帳票物理名;
    }
    
    @Override
    public Breakers<JukyushaKoshinKekkaIchiranSource> defineBreakers(
            Breakers<JukyushaKoshinKekkaIchiranSource> breakers,
            BreakerCatalog<JukyushaKoshinKekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(
            pageBreakKeys) {
            @Override
            public ReportLineRecord<JukyushaKoshinKekkaIchiranSource> occuredBreak(
                    ReportLineRecord<JukyushaKoshinKekkaIchiranSource> currentRecord,
                    ReportLineRecord<JukyushaKoshinKekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
    /**
     * 帳票設計_DBC120030_受給者情報更新結果情報取込一覧表 出力順設定可能項目です。
     */
    public enum DBC120030ShutsuryokujunEnum implements IReportItems {

        /**
         * 保険者番号
         */
        保険者番号(new RString("0365"), new RString("hokenshaNo"), new RString("DbWT5331.\"hokenshaNo\"")),
        
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0164"), new RString("hihokenshaNo"), new RString("DbWT0001.\"hihokenshaNo\"")),
        
        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("yubinNo"), new RString("DbWT0001.\"yubinNo\"")),
        
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("choikiCode"), new RString("DbWT0001.\"choikiCode\"")),
        
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("DbWT0001.\"gyoseikuCode\"")),
        
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("DbWT0001.\"shimei50onKana\"")),
        
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("DbWT0001.\"shichosonCode\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC120030ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名,
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
