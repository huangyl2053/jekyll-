/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査第5群）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubun5 {

    /**
     * 「薬の内服」の調査結果を表す列挙型です。
     */
    public enum Kusuri {

        /**
         * 調査結果が「自立」であることを表します。
         */
        自立(1),
        /**
         * 調査結果が「一部介助」であることを表します。
         */
        一部介助(2),
        /**
         * 調査結果が「全介助」であることを表します。
         */
        全介助(3);
        private int code;

        private Kusuri(int code) {
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
        public static Kusuri toValue(RString code) {
            for (Kusuri data : Kusuri.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「金銭の管理」の調査結果を表す列挙型です。
     */
    public enum KinsenKanri {

        /**
         * 調査結果が「自立」であることを表します。
         */
        自立(1),
        /**
         * 調査結果が「一部介助」であることを表します。
         */
        一部介助(2),
        /**
         * 調査結果が「全介助」であることを表します。
         */
        全介助(3);
        private int code;

        private KinsenKanri(int code) {
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
        public static KinsenKanri toValue(RString code) {
            for (KinsenKanri data : KinsenKanri.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「日常の意思決定」の調査結果を表す列挙型です。
     */
    public enum IshiKettei {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「特別な場合を除いてできる」であることを表します。
         */
        特別な場合を除いてできる(2),
        /**
         * 調査結果が「日常的に困難」であることを表します。
         */
        日常的に困難(3),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(4);
        private int code;

        private IshiKettei(int code) {
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
        public static IshiKettei toValue(RString code) {
            for (IshiKettei data : IshiKettei.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「集団への不適応」の調査結果を表す列挙型です。
     */
    public enum ShudanFutekio {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private ShudanFutekio(int code) {
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
        public static ShudanFutekio toValue(RString code) {
            for (ShudanFutekio data : ShudanFutekio.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「買い物」の調査結果を表す列挙型です。
     */
    public enum Kaimono {

        /**
         * 調査結果が「自立」であることを表します。
         */
        自立(1),
        /**
         * 調査結果が「見守り等」であることを表します。
         */
        見守り等(2),
        /**
         * 調査結果が「一部介助」であることを表します。
         */
        一部介助(3),
        /**
         * 調査結果が「全介助」であることを表します。
         */
        全介助(4);
        private int code;

        private Kaimono(int code) {
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
        public static Kaimono toValue(RString code) {
            for (Kaimono data : Kaimono.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「簡単な調理」の調査結果を表す列挙型です。
     */
    public enum Chori {

        /**
         * 調査結果が「自立」であることを表します。
         */
        自立(1),
        /**
         * 調査結果が「見守り等」であることを表します。
         */
        見守り等(2),
        /**
         * 調査結果が「一部介助」であることを表します。
         */
        一部介助(3),
        /**
         * 調査結果が「全介助」であることを表します。
         */
        全介助(4);
        private int code;

        private Chori(int code) {
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
        public static Chori toValue(RString code) {
            for (Chori data : Chori.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
