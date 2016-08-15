/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource.ReportSourceFields;
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
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Property
 *
 * @reamsid_L DBC-2470-030 surun
 */
public class KyufujissekiKoshinkekkaIchiranProperty extends ReportPropertyBase<KyufujissekiKoshinkekkaIchiranSource> {

    private static final RString ENCLOSURE = new RString("\"");
    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * インスタンスを生成します。
     *
     * @param 並び順 IOutputOrder
     */
    public KyufujissekiKoshinkekkaIchiranProperty(IOutputOrder 並び順) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200054.getReportId());
        pageBreakKeys = new ArrayList<>();

        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;

        List<ISetSortItem> list = 並び順.get設定項目リスト();
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
        RString 帳票物理名 = new RString(ReportSourceFields.hokenshaNo.name());
        if (DBC200054_KyufujissekiKoshinkekkaIchiran.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_5.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.サービス提供年月.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_7.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.事業者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_9.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.入力識別番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_2.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.整理番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.listUpper_10.name());
        }
        return 帳票物理名;
    }

    @Override
    public Breakers<KyufujissekiKoshinkekkaIchiranSource> defineBreakers(
            Breakers<KyufujissekiKoshinkekkaIchiranSource> breakers,
            BreakerCatalog<KyufujissekiKoshinkekkaIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            pageBreakKeys) {
            @Override
            public ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> occuredBreak(
                    ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> currentRecord,
                    ReportLineRecord<KyufujissekiKoshinkekkaIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票分類ID「DBC200054_KyufujissekiKoshinkekkaIchiran」（給付実績更新結果情報一覧表）出力順設定可能項目です。
     */
    public enum DBC200054_KyufujissekiKoshinkekkaIchiran implements IReportItems {

        /**
         * 保険者番号
         */
        保険者番号(new RString("0365"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * サービス提供年月
         */
        サービス提供年月(new RString("0364"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 事業者番号
         */
        事業者番号(new RString("0366"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 入力識別番号
         */
        入力識別番号(new RString("0304"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 整理番号
         */
        整理番号(new RString("0305"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 現物償還の別
         */
        現物償還の別(new RString("0306"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200054_KyufujissekiKoshinkekkaIchiran(
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
