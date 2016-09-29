/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200008;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 給付額減額把握リストのプロパティです。
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
public class KyufuGengakuHaakuIchiranProerty extends ReportPropertyBase<KyufuGengakuHaakuIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public KyufuGengakuHaakuIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200008.getReportId());
    }

    /**
     * 帳票分類ID「DBD200008_KyufuGengakuHaakuIchiran」（給付額減額把握リスト）出力順設定可能項目です。
     */
    public enum DBD200008ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), new RString("\"tmp_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), new RString("\"\"")), //QA 103476
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"tmp_gyoseikuCode\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("\"tmp_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"tmp_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"tmp_hihokenshaShimeiKana\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"\"")), //QA 103476
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"tmp_hihokenshaNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD200008ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
