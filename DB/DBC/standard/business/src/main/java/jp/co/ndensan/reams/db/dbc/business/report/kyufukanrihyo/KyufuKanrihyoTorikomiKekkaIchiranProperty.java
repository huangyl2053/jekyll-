/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource.DBC200073SourceFields;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 給付管理票取込結果一覧表帳票のプロパティです。
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuKanrihyoTorikomiKekkaIchiranProperty
        extends ReportPropertyBase<KyufuKanrihyoTorikomiKekkaIchiranSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public KyufuKanrihyoTorikomiKekkaIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200073.getReportId());

        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(DBC200073SourceFields.hokenshaNo.name()));
    }

    /**
     * 帳票設計_DBC200073_給付管理票取込結果一覧表 出力順設定可能項目です。
     */
    public enum DBC200073BreakerFieldsEnum implements IReportItems {

        /**
         * 保険者番号
         */
        保険者番号(new RString("0365"), new RString("hokenshaNo"), new RString("\"DbWT1121KyufuKanrihyo\".\"hokenshaNo\"")),
        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("TEMP.\"yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("TEMP.\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("TEMP.\"gyoseikuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("TEMP.\"shimei50onKana\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("TEMP.\"shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listCenter_4"), new RString("TEMP.\"hihokenshaNo\""));
        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBC200073BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
