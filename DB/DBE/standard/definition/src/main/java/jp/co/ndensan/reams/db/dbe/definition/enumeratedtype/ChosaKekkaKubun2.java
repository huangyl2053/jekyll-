/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査第2群）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubun2 {

    /**
     * 「移乗」の調査結果を表す列挙型です。
     */
    public enum Ijo {

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

        private Ijo(int code) {
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
        public static Ijo toValue(RString code) {
            for (Ijo data : Ijo.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「移動」の調査結果を表す列挙型です。
     */
    public enum Ido {

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

        private Ido(int code) {
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
        public static Ido toValue(RString code) {
            for (Ido data : Ido.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「嚥下」の調査結果を表す列挙型です。
     */
    public enum Enge {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「見守り等」であることを表します。
         */
        見守り等(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private Enge(int code) {
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
        public static Enge toValue(RString code) {
            for (Enge data : Enge.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「食事摂取」の調査結果を表す列挙型です。
     */
    public enum ShokujiSesshu {

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

        private ShokujiSesshu(int code) {
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
        public static ShokujiSesshu toValue(RString code) {
            for (ShokujiSesshu data : ShokujiSesshu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「排尿」の調査結果を表す列挙型です。
     */
    public enum Hainyo {

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

        private Hainyo(int code) {
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
        public static Hainyo toValue(RString code) {
            for (Hainyo data : Hainyo.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「排便」の調査結果を表す列挙型です。
     */
    public enum Haiben {

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

        private Haiben(int code) {
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
        public static Haiben toValue(RString code) {
            for (Haiben data : Haiben.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「口腔清潔」の調査結果を表す列挙型です。
     */
    public enum KokoSeiketsu {

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

        private KokoSeiketsu(int code) {
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
        public static KokoSeiketsu toValue(RString code) {
            for (KokoSeiketsu data : KokoSeiketsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「洗顔」の調査結果を表す列挙型です。
     */
    public enum Sengan {

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

        private Sengan(int code) {
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
        public static Sengan toValue(RString code) {
            for (Sengan data : Sengan.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「整髪」の調査結果を表す列挙型です。
     */
    public enum Seihatsu {

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

        private Seihatsu(int code) {
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
        public static Seihatsu toValue(RString code) {
            for (Seihatsu data : Seihatsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「上衣の着脱」の調査結果を表す列挙型です。
     */
    public enum JoiChakudatsu {

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

        private JoiChakudatsu(int code) {
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
        public static JoiChakudatsu toValue(RString code) {
            for (JoiChakudatsu data : JoiChakudatsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「ズボン等の着脱」の調査結果を表す列挙型です。
     */
    public enum ZubonChakudatsu {

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

        private ZubonChakudatsu(int code) {
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
        public static ZubonChakudatsu toValue(RString code) {
            for (ZubonChakudatsu data : ZubonChakudatsu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「外出頻度」の調査結果を表す列挙型です。
     */
    public enum GaishutsuHindo {

        /**
         * 調査結果が「週１回以上」であることを表します。
         */
        週１回以上(1),
        /**
         * 調査結果が「月１回以上」であることを表します。
         */
        月１回以上(2),
        /**
         * 調査結果が「月１回未満」であることを表します。
         */
        月１回未満(3);
        private int code;

        private GaishutsuHindo(int code) {
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
        public static GaishutsuHindo toValue(RString code) {
            for (GaishutsuHindo data : GaishutsuHindo.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
