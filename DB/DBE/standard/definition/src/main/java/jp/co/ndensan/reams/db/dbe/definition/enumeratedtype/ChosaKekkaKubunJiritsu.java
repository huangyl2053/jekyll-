/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査自立度）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubunJiritsu {

    /**
     * 「認知症高齢者の日常生活自立度」の調査結果を表す列挙型です。
     */
    public enum NinchishoNichijoSeikatsu {

        /**
         * 調査結果が「自立」であることを表します。
         */
        自立(1),
        /**
         * 調査結果が「Ｊ１」であることを表します。
         */
        Ｊ１(2),
        /**
         * 調査結果が「Ｊ２」であることを表します。
         */
        Ｊ２(3),
        /**
         * 調査結果が「Ａ１」であることを表します。
         */
        Ａ１(4),
        /**
         * 調査結果が「Ａ２」であることを表します。
         */
        Ａ２(5),
        /**
         * 調査結果が「Ｂ１」であることを表します。
         */
        Ｂ１(6),
        /**
         * 調査結果が「Ｂ２」であることを表します。
         */
        Ｂ２(7),
        /**
         * 調査結果が「Ｃ１」であることを表します。
         */
        Ｃ１(8),
        /**
         * 調査結果が「Ｃ２」であることを表します。
         */
        Ｃ２(9);
        private int code;

        private NinchishoNichijoSeikatsu(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static NinchishoNichijoSeikatsu toValue(RString code) {
            for (NinchishoNichijoSeikatsu data : NinchishoNichijoSeikatsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「障害高齢者の日常生活自立度」の調査結果を表す列挙型です。
     */
    public enum ShogaiNichijoSeikatsu {

        /**
         * 調査結果が「自立」であることを表します。
         */
        自立(1),
        /**
         * 調査結果が「Ⅰ」であることを表します。
         */
        Ⅰ(2),
        /**
         * 調査結果が「Ⅱａ」であることを表します。
         */
        Ⅱａ(3),
        /**
         * 調査結果が「Ⅱｂ」であることを表します。
         */
        Ⅱｂ(4),
        /**
         * 調査結果が「Ⅲａ」であることを表します。
         */
        Ⅲａ(5),
        /**
         * 調査結果が「Ⅲｂ」であることを表します。
         */
        Ⅲｂ(6),
        /**
         * 調査結果が「Ⅳ」であることを表します。
         */
        Ⅳ(7),
        /**
         * 調査結果が「Ｍ」であることを表します。
         */
        Ｍ(8),
        /**
         * 調査結果が「記載なし」であることを表します。
         */
        記載なし(9);
        private int code;

        private ShogaiNichijoSeikatsu(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static ShogaiNichijoSeikatsu toValue(RString code) {
            for (ShogaiNichijoSeikatsu data : ShogaiNichijoSeikatsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
