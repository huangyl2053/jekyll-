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

    private final List<RString> pageBreakKeys;
    private static final int INDEX_0 = 0;

    /**
     * インスタンスを生成します。
     *
     * @param 並び順 IOutputOrder
     */
    public KyufujissekiKoshinkekkaIchiranProperty(IOutputOrder 並び順) {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200054.getReportId());
        pageBreakKeys = new ArrayList<>();
        List<ISetSortItem> list = 並び順.get設定項目リスト();
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = INDEX_0; i < list.size(); i++) {
            if (list.size() > i && list.get(i).is改頁項目()) {
                RString 改頁 = get帳票物理名(list.get(i).get項目ID());
                if (!改頁.isEmpty()) {
                    pageBreakKeys.add(改頁);
                }
            }
        }

    }

    private RString get帳票物理名(RString 項目ID) {
        RString 帳票物理名 = RString.EMPTY;
        if (DBC200054_KyufujissekiKoshinkekkaIchiran.保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.hokenshaNo.name());
        }
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
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.yubinNo.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.choikiCode.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.gyoseikuCode.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.shimei50onKana.name());
        } else if (DBC200054_KyufujissekiKoshinkekkaIchiran.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString(ReportSourceFields.shichosonCode.name());
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
        保険者番号(new RString("0365"), new RString("hokenshaNo"), new RString("DbWT1111.\"hokenshaNo\"")),
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
         * サービス提供年月
         */
        サービス提供年月(new RString("0364"), new RString("serviceTeikyoYM"), new RString("DbWT1111.\"serviceTeikyoYM\"")),
        /**
         * 事業者番号
         */
        事業者番号(new RString("0366"), new RString("jigyoshoNo"), new RString("DbWT1111.\"jigyoshoNo\"")),
        /**
         * 入力識別番号
         */
        入力識別番号(new RString("0304"), new RString("nyuryokuShikibetsuNo"), new RString("DbWT1111.\"nyuryokuShikibetsuNo\"")),
        /**
         * 整理番号
         */
        整理番号(new RString("0305"), new RString("seiriNo"), new RString("DbWT1111.\"seiriNo\"")),
        /**
         * 現物償還の別
         */
        現物償還の別(new RString("0306"), new RString("kyufuJissekiKubun"), new RString("DbWT1111.\"kyufuJissekiKubun\""));

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
