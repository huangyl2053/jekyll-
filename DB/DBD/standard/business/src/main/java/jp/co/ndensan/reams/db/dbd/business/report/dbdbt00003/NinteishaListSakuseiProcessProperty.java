/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbdbt00003;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 結果一覧出力のプロパティです。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishaListSakuseiProcessProperty {

    /**
     * 帳票分類ID「DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran」(DBD介護受給)
     * 出力順設定可能項目です。
     */
    public enum DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("郵便番号"), new RString("")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), new RString("")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), new RString("")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), new RString("")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("")),;

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBD200003_HomonKaigoRiyoshaFutangakuGengakuGaitoshaIchiran(RString 項目ID,
                RString フォームフィールド名, 
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
