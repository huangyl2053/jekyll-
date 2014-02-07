/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査特別医療）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubunIryo {

    /**
     * 「点滴の管理」の調査結果を表す列挙型です。
     */
    public enum Tenteki {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private Tenteki(int code) {
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
        public static Tenteki toValue(RString code) {
            for (Tenteki data : Tenteki.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「中心静脈栄養」の調査結果を表す列挙型です。
     */
    public enum ChushinJomyakuEiyo {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private ChushinJomyakuEiyo(int code) {
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
        public static ChushinJomyakuEiyo toValue(RString code) {
            for (ChushinJomyakuEiyo data : ChushinJomyakuEiyo.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「透析」の調査結果を表す列挙型です。
     */
    public enum Toseki {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private Toseki(int code) {
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
        public static Toseki toValue(RString code) {
            for (Toseki data : Toseki.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「ストーマの処置」の調査結果を表す列挙型です。
     */
    public enum StomaShochi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private StomaShochi(int code) {
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
        public static StomaShochi toValue(RString code) {
            for (StomaShochi data : StomaShochi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「酸素療法」の調査結果を表す列挙型です。
     */
    public enum SansoRyoho {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private SansoRyoho(int code) {
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
        public static SansoRyoho toValue(RString code) {
            for (SansoRyoho data : SansoRyoho.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「レスピレーター」の調査結果を表す列挙型です。
     */
    public enum Respirator {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private Respirator(int code) {
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
        public static Respirator toValue(RString code) {
            for (Respirator data : Respirator.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「気管切開の処置」の調査結果を表す列挙型です。
     */
    public enum KikanSekkai {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private KikanSekkai(int code) {
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
        public static KikanSekkai toValue(RString code) {
            for (KikanSekkai data : KikanSekkai.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「疼痛の看護」の調査結果を表す列挙型です。
     */
    public enum TotsuKango {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private TotsuKango(int code) {
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
        public static TotsuKango toValue(RString code) {
            for (TotsuKango data : TotsuKango.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「経管栄養」の調査結果を表す列挙型です。
     */
    public enum KeikanEiyo {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private KeikanEiyo(int code) {
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
        public static KeikanEiyo toValue(RString code) {
            for (KeikanEiyo data : KeikanEiyo.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「モニター測定」の調査結果を表す列挙型です。
     */
    public enum MonitorSokutei {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private MonitorSokutei(int code) {
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
        public static MonitorSokutei toValue(RString code) {
            for (MonitorSokutei data : MonitorSokutei.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「じょくそうの処置」の調査結果を表す列挙型です。
     */
    public enum JokusoShochi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private JokusoShochi(int code) {
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
        public static JokusoShochi toValue(RString code) {
            for (JokusoShochi data : JokusoShochi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「カテーテル」の調査結果を表す列挙型です。
     */
    public enum Catheter {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(2);
        private int code;

        private Catheter(int code) {
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
        public static Catheter toValue(RString code) {
            for (Catheter data : Catheter.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
