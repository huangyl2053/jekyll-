/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査第3群）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubun3 {

    /**
     * 「意思の伝達」の調査結果を表す列挙型です。
     */
    public enum IshiDentatsu {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「ときどきできる」であることを表します。
         */
        ときどきできる(2),
        /**
         * 調査結果が「ほとんど不可」であることを表します。
         */
        ほとんど不可(3),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(4);
        private int code;

        private IshiDentatsu(int code) {
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
        public static IshiDentatsu toValue(RString code) {
            for (IshiDentatsu data : IshiDentatsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「毎日の日課を理解」の調査結果を表す列挙型です。
     */
    public enum Nikka {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(2);
        private int code;

        private Nikka(int code) {
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
        public static Nikka toValue(RString code) {
            for (Nikka data : Nikka.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「生年月日をいう」の調査結果を表す列挙型です。
     */
    public enum Seinengappi {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(2);
        private int code;

        private Seinengappi(int code) {
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
        public static Seinengappi toValue(RString code) {
            for (Seinengappi data : Seinengappi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「短期記憶」の調査結果を表す列挙型です。
     */
    public enum TankiKioku {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(2);
        private int code;

        private TankiKioku(int code) {
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
        public static TankiKioku toValue(RString code) {
            for (TankiKioku data : TankiKioku.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「自分の名前をいう」の調査結果を表す列挙型です。
     */
    public enum Namae {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(2);
        private int code;

        private Namae(int code) {
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
        public static Namae toValue(RString code) {
            for (Namae data : Namae.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「今の季節を理解」の調査結果を表す列挙型です。
     */
    public enum Kisetsu {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(2);
        private int code;

        private Kisetsu(int code) {
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
        public static Kisetsu toValue(RString code) {
            for (Kisetsu data : Kisetsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「場所の理解」の調査結果を表す列挙型です。
     */
    public enum Basho {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(2);
        private int code;

        private Basho(int code) {
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
        public static Basho toValue(RString code) {
            for (Basho data : Basho.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「徘徊」の調査結果を表す列挙型です。
     */
    public enum Haikai {

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

        private Haikai(int code) {
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
        public static Haikai toValue(RString code) {
            for (Haikai data : Haikai.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「外出して戻れない」の調査結果を表す列挙型です。
     */
    public enum Gaishutsu {

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

        private Gaishutsu(int code) {
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
        public static Gaishutsu toValue(RString code) {
            for (Gaishutsu data : Gaishutsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
