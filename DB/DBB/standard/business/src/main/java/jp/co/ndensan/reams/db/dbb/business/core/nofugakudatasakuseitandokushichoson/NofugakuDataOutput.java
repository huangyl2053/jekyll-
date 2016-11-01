/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額一覧表 Output
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public class NofugakuDataOutput {

    private static final RString FORMAT = new RString("\"");

    /**
     * 納付額一覧表 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("町域コード"), FORMAT
                .concat(new RString("ShikibetsuTaisho_choikiCode")).concat(FORMAT)),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("行政区コード"), FORMAT
                .concat(new RString("ShikibetsuTaisho_gyoseikuCode")).concat(FORMAT)),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("世帯コード"), FORMAT
                .concat(new RString("ShikibetsuTaisho_setaiCode")).concat(FORMAT)),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("識別コード"), FORMAT
                .concat(new RString("ShikibetsuTaisho_shikibetsuCode")).concat(FORMAT)),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("生年月日"), FORMAT
                .concat(new RString("ShikibetsuTaisho_seinengappiYMD")).concat(FORMAT)),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString("性別"), FORMAT
                .concat(new RString("ShikibetsuTaisho_seibetsuCode")).concat(FORMAT)),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("市町村コード"), FORMAT
                .concat(new RString("dbT2016NofugakuJohoTemp_fukaShichosonCode")).concat(FORMAT)),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("被保険者番号"), FORMAT
                .concat(new RString("dbT2016NofugakuJohoTemp_hihokenshaNo")).concat(FORMAT)),
        /**
         * 徴収方法
         */
        徴収方法(new RString("0209"), new RString("徴収方法"), new RString(""));

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
