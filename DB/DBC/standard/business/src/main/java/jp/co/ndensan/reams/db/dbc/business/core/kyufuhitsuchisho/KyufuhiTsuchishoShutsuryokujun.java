/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufuhitsuchisho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知書作成(一括)のビジネスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoShutsuryokujun {

    /**
     * 帳票分類ID「DBC200044_KyufuhiTuchiHakkoIchiran」利用状況一覧表出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("shutsuryokujun_1"), new RString("\"yubinno\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("shutsuryokujun_2"), new RString("\"choikicode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("shutsuryokujun_3"), new RString("\"gyoseikucode\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("shutsuryokujun_4"), new RString("\"setaicode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("shutsuryokujun_5"), new RString("\"kanameisho\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shutsuryokujun_6"), new RString("\"shichosoncode\"")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString("shutsuryokujun_7"), new RString("\"証記載保険者番号\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("shutsuryokujun_8"), new RString("\"被保険者番号\"")),
        /**
         * 資格状態区分
         */
        資格状態区分(new RString("0131"), new RString("shutsuryokujun_9"), new RString("\"shikakujotaikubun\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
