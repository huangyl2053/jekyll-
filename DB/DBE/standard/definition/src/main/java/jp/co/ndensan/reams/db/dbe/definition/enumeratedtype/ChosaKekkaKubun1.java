/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査第1群）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubun1 {

    /**
     * 「麻痺左上肢」の調査結果を表す列挙型です。
     */
    public enum MahiHidariJoshi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private MahiHidariJoshi(int code) {
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
        public static MahiHidariJoshi toValue(RString code) {
            for (MahiHidariJoshi data : MahiHidariJoshi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「麻痺右上肢」の調査結果を表す列挙型です。
     */
    public enum MahiMigiJoshi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private MahiMigiJoshi(int code) {
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
        public static MahiMigiJoshi toValue(RString code) {
            for (MahiMigiJoshi data : MahiMigiJoshi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「麻痺左下肢」の調査結果を表す列挙型です。
     */
    public enum MahiHidariKashi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private MahiHidariKashi(int code) {
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
        public static MahiHidariKashi toValue(RString code) {
            for (MahiHidariKashi data : MahiHidariKashi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「麻痺右下肢」の調査結果を表す列挙型です。
     */
    public enum MahiMigiKashi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private MahiMigiKashi(int code) {
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
        public static MahiMigiKashi toValue(RString code) {
            for (MahiMigiKashi data : MahiMigiKashi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「麻痺その他」の調査結果を表す列挙型です。
     */
    public enum MahiSonota {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private MahiSonota(int code) {
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
        public static MahiSonota toValue(RString code) {
            for (MahiSonota data : MahiSonota.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「拘縮肩関節」の調査結果を表す列挙型です。
     */
    public enum KoshukuKata {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private KoshukuKata(int code) {
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
        public static KoshukuKata toValue(RString code) {
            for (KoshukuKata data : KoshukuKata.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「拘縮股関節」の調査結果を表す列挙型です。
     */
    public enum KoshukuMata {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private KoshukuMata(int code) {
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
        public static KoshukuMata toValue(RString code) {
            for (KoshukuMata data : KoshukuMata.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「拘縮膝関節」の調査結果を表す列挙型です。
     */
    public enum KoshukuHiza {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private KoshukuHiza(int code) {
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
        public static KoshukuHiza toValue(RString code) {
            for (KoshukuHiza data : KoshukuHiza.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「拘縮その他」の調査結果を表す列挙型です。
     */
    public enum KoshukuSonota {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private KoshukuSonota(int code) {
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
        public static KoshukuSonota toValue(RString code) {
            for (KoshukuSonota data : KoshukuSonota.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「寝返り」の調査結果を表す列挙型です。
     */
    public enum Negaeri {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「つかまれば可」であることを表します。
         */
        つかまれば可(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private Negaeri(int code) {
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
        public static Negaeri toValue(RString code) {
            for (Negaeri data : Negaeri.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「起き上がり」の調査結果を表す列挙型です。
     */
    public enum Okiagari {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「つかまれば可」であることを表します。
         */
        つかまれば可(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private Okiagari(int code) {
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
        public static Okiagari toValue(RString code) {
            for (Okiagari data : Okiagari.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「座位保持」の調査結果を表す列挙型です。
     */
    public enum Zaihoji {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「自分で支えれば可」であることを表します。
         */
        自分で支えれば可(2),
        /**
         * 調査結果が「支えが必要」であることを表します。
         */
        支えが必要(3),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(4);
        private int code;

        private Zaihoji(int code) {
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
        public static Zaihoji toValue(RString code) {
            for (Zaihoji data : Zaihoji.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「両足での立位」の調査結果を表す列挙型です。
     */
    public enum RyoashiRitsui {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「支えが必要」であることを表します。
         */
        支えが必要(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private RyoashiRitsui(int code) {
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
        public static RyoashiRitsui toValue(RString code) {
            for (RyoashiRitsui data : RyoashiRitsui.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「歩行」の調査結果を表す列挙型です。
     */
    public enum Hoko {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「つかまれば可」であることを表します。
         */
        つかまれば可(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private Hoko(int code) {
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
        public static Hoko toValue(RString code) {
            for (Hoko data : Hoko.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「立ち上がり」の調査結果を表す列挙型です。
     */
    public enum Tachiagari {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「つかまれば可」であることを表します。
         */
        つかまれば可(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private Tachiagari(int code) {
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
        public static Tachiagari toValue(RString code) {
            for (Tachiagari data : Tachiagari.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「片足での立位」の調査結果を表す列挙型です。
     */
    public enum KataashiRitsui {

        /**
         * 調査結果が「できる」であることを表します。
         */
        できる(1),
        /**
         * 調査結果が「支えが必要」であることを表します。
         */
        支えが必要(2),
        /**
         * 調査結果が「できない」であることを表します。
         */
        できない(3);
        private int code;

        private KataashiRitsui(int code) {
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
        public static KataashiRitsui toValue(RString code) {
            for (KataashiRitsui data : KataashiRitsui.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「洗身」の調査結果を表す列挙型です。
     */
    public enum Senshin {

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
        全介助(3),
        /**
         * 調査結果が「行っていない」であることを表します。
         */
        行っていない(4);
        private int code;

        private Senshin(int code) {
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
        public static Senshin toValue(RString code) {
            for (Senshin data : Senshin.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「つめ切り」の調査結果を表す列挙型です。
     */
    public enum Tsumekiri {

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

        private Tsumekiri(int code) {
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
        public static Tsumekiri toValue(RString code) {
            for (Tsumekiri data : Tsumekiri.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「視力」の調査結果を表す列挙型です。
     */
    public enum Shiryoku {

        /**
         * 調査結果が「普通」であることを表します。
         */
        普通(1),
        /**
         * 調査結果が「１ｍ先が見える」であることを表します。
         */
        一ｍ先が見える(2),
        /**
         * 調査結果が「目の前が見える」であることを表します。
         */
        目の前が見える(3),
        /**
         * 調査結果が「ほとんど見えず」であることを表します。
         */
        ほとんど見えず(4),
        /**
         * 調査結果が「判断不能」であることを表します。
         */
        判断不能(5);
        private int code;

        private Shiryoku(int code) {
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
        public static Shiryoku toValue(RString code) {
            for (Shiryoku data : Shiryoku.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「聴力」の調査結果を表す列挙型です。
     */
    public enum Choryoku {

        /**
         * 調査結果が「普通」であることを表します。
         */
        普通(1),
        /**
         * 調査結果が「やっと聞こえる」であることを表します。
         */
        やっと聞こえる(2),
        /**
         * 調査結果が「大声が聞こえる」であることを表します。
         */
        大声が聞こえる(3),
        /**
         * 調査結果が「ほとんど聞こえず」であることを表します。
         */
        ほとんど聞こえず(4),
        /**
         * 調査結果が「判断不能」であることを表します。
         */
        判断不能(5);
        private int code;

        private Choryoku(int code) {
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
        public static Choryoku toValue(RString code) {
            for (Choryoku data : Choryoku.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
