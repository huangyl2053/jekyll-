/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のプロパティです。
 *
 * @reamsid_L DBB-0880-080 zhangrui
 *
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranProperty {

    /**
     * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), new RString("\"ShikibetsuTaisho\".\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"ShikibetsuTaisho\".\"setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), new RString("master.\"dbT2002Fuka_fukaShichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("master.\"dbT2002Fuka_hihokenshaNo\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
