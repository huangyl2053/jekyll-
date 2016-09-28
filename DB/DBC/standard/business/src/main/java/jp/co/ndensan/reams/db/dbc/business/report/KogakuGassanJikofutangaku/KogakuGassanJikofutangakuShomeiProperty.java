/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.KogakuGassanJikofutangaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.GassanJikofutangakuShomeishoTorikomiIchiranSource;
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
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表 Property
 *
 * @reamsid_L DBC-2640-030 zhengshenlei
 */
public class KogakuGassanJikofutangakuShomeiProperty extends ReportPropertyBase<GassanJikofutangakuShomeishoTorikomiIchiranSource> {

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
    public KogakuGassanJikofutangakuShomeiProperty(IOutputOrder 並び順) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200034.getReportId());
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
        RString 帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.hokenshaNo.name());
        if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.証記載保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.shoKisaiHokenshaNo.name());
        } else if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.自己負担額の差異.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.list_14.name());
        } else if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.list_3.name());
        } else if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.対象年度.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.list_2.name());
        } else if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.申請年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.list_7.name());
        } else if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.申請書整理番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.list_5.name());
        } else if (DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran.証明書整理番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(GassanJikofutangakuShomeishoTorikomiIchiranSource.ReportSourceFields.list_11.name());
        }
        return 帳票物理名;
    }

    @Override
    public Breakers<GassanJikofutangakuShomeishoTorikomiIchiranSource> defineBreakers(
            Breakers<GassanJikofutangakuShomeishoTorikomiIchiranSource> breakers,
            BreakerCatalog<GassanJikofutangakuShomeishoTorikomiIchiranSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            pageBreakKeys) {
            @Override
            public ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> occuredBreak(
                    ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> currentRecord,
                    ReportLineRecord<GassanJikofutangakuShomeishoTorikomiIchiranSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }

    /**
     * 帳票分類ID「DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran」（高額合算自己負担額証明書情報取込一覧表）出力順設定可能項目です。
     */
    public enum DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran implements IReportItems {

        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("shoKisaiHokenshaNo"), new RString("DbWT37H1.\"hokenshaNoIn\"")),
        /**
         * 自己負担額の差異
         */
        自己負担額の差異(new RString("0372"), new RString("jikoFutangakuSaiFlag"), new RString("DbWT37H1.\"jikoFutangakuSaiFlag\"")),
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
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("DbWT0001.\"shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("DbWT0001.\"hihokenshaNo\"")),
        /**
         * 対象年度
         */
        対象年度(new RString("0334"), new RString("taishoNendo"), new RString("DbWT37H1.\"taishoNendo\"")),
        /**
         * 申請年月日
         */
        申請年月日(new RString("0333"), new RString("shinseiYMD"), new RString("DbWT37H1.\"shinseiYMD\"")),
        /**
         * 申請書整理番号
         */
        申請書整理番号(new RString("'0337"), new RString("shinseiYMD"), new RString("DbWT37H1.\"shikyuShinseishoSeiriNo\"")),
        /**
         * 証明書整理番号
         */
        証明書整理番号(new RString("'0338"), new RString("shinseiYMD"), new RString("DbWT37H1.\"jikoFutanSeiriNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200034_GassanJikofutangakuShomeishoTorikomiIchiran(
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
