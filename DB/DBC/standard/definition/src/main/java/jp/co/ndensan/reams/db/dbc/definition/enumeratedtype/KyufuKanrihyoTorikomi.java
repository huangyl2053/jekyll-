/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票取込で使用する列挙型を定義したクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuKanrihyoTorikomi {

    /**
     * 作成区分の列挙型です。
     */
    public enum SakuseiKubun {

        /**
         * 作成区分が「新規」であることを表します。 <br />
         * コード：1
         */
        新規("1"),
        /**
         * 作成区分が「修正」であることを表します。 <br />
         * コード：2
         */
        修正("2"),
        /**
         * 作成区分が「取消」であることを表します。 <br />
         * コード：3
         */
        取消("3"),
        /**
         * 作成区分が「UNKNOWN」であることを表します。 <br />
         * コード：99
         */
        UNKNOWN("99");

        private final RString code;

        private SakuseiKubun(String code) {
            this.code = new RString(code);
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return (this != UNKNOWN) ? code : RString.EMPTY;
        }

        /**
         * 名称を返します。
         *
         * @return 名称
         */
        public RString getName() {
            return (this != UNKNOWN) ? new RString(this.name()) : RString.EMPTY;
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static SakuseiKubun toValue(RString code) {
            for (SakuseiKubun data : values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return UNKNOWN;
        }
    }

    /**
     * 作成種別区分の列挙型です。
     */
    public enum ShubetsuKubun {

        /**
         * 作成種別区分が「訪問通所サービス」であることを表します。 <br />
         * コード：1
         */
        訪問通所サービス("1"),
        /**
         * 作成種別区分が「短期入所サービス」であることを表します。 <br />
         * コード：2
         */
        短期入所サービス("2"),
        /**
         * 作成種別区分が「居宅サービス」であることを表します。 <br />
         * コード：3
         */
        居宅サービス("3"),
        /**
         * 作成種別区分が「UNKNOWN」であることを表します。 <br />
         * コード：99
         */
        UNKNOWN("99");

        private final RString code;

        private ShubetsuKubun(String code) {
            this.code = new RString(code);
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return (this != UNKNOWN) ? code : RString.EMPTY;
        }

        /**
         * 名称を返します。
         *
         * @return 名称
         */
        public RString getName() {
            return (this != UNKNOWN) ? new RString(this.name()) : RString.EMPTY;
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static ShubetsuKubun toValue(RString code) {
            for (ShubetsuKubun data : values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return UNKNOWN;
        }
    }

    /**
     * 計画作成区分の列挙型です。
     */
    public enum KeikakuSakuseiKubun {

        /**
         * 計画作成区分が「自己作成」であることを表します。 <br />
         * コード：2
         */
        自己作成("2"),
        /**
         * 計画作成区分が「UNKNOWN」であることを表します。 <br />
         * コード：99
         */
        UNKNOWN("99");

        private final RString code;

        private KeikakuSakuseiKubun(String code) {
            this.code = new RString(code);
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return (this != UNKNOWN) ? code : RString.EMPTY;
        }

        /**
         * 名称を返します。
         *
         * @return 名称
         */
        public RString getName() {
            return (this != UNKNOWN) ? new RString(this.name()) : RString.EMPTY;
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static KeikakuSakuseiKubun toValue(RString code) {
            for (KeikakuSakuseiKubun data : values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return UNKNOWN;
        }
    }
}
