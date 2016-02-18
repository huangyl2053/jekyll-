/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.KoikiType;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村情報 の項目定義クラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShichosonSecurityJoho {

    /**
     * 空を表す{@link ShichosonSecurityJoho}です。
     */
    public static final ShichosonSecurityJoho EMPTY;

    static {
        EMPTY = new ShichosonSecurityJoho(KaigoDonyuKubun.未導入, false, KoikiType.未設定, RString.EMPTY, null, null);
    }

    private final KaigoDonyuKubun 介護導入区分;
    private final boolean 支所管理有無フラグ;
    private final KoikiType 広域タイプ;
    private final RString 市町村ID有効桁数;
    private final ShichosonJoho 市町村情報;
    private final DonyuKeitaiCode 導入形態コード;

    private ShichosonSecurityJoho(KaigoDonyuKubun 介護導入区分,
            boolean 支所管理有無フラグ,
            KoikiType 広域タイプ,
            RString 市町村ＩＤ有効桁数,
            ShichosonJoho 市町村情報,
            DonyuKeitaiCode 導入形態コード) {
        this.介護導入区分 = 介護導入区分;
        this.支所管理有無フラグ = 支所管理有無フラグ;
        this.広域タイプ = 広域タイプ;
        this.市町村ID有効桁数 = 市町村ＩＤ有効桁数;
        this.市町村情報 = 市町村情報;
        this.導入形態コード = 導入形態コード;
    }

    private ShichosonSecurityJoho(Builder builder) {
        this.介護導入区分 = builder.介護導入区分;
        this.支所管理有無フラグ = builder.支所管理有無フラグ;
        this.広域タイプ = builder.広域タイプ;
        this.市町村ID有効桁数 = builder.市町村ID有効桁数;
        this.市町村情報 = builder.市町村情報;
        this.導入形態コード = builder.導入形態コード;
    }

    /**
     * {@link ShichosonSecurityJoho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private final KaigoDonyuKubun 介護導入区分;
        private final DonyuKeitaiCode 導入形態コード;
        private boolean 支所管理有無フラグ;
        private KoikiType 広域タイプ;
        private RString 市町村ID有効桁数;
        private ShichosonJoho 市町村情報;

        Builder() {
            throw new UnsupportedOperationException("Not supported yet."); //TODO ツールでは生成できない。手で実装する。
        }

        /**
         * 導入形態コードを指定してBuilderを生成します。 {@link #build()}二より生成されるinstanceは、ここで指定された導入形態コードを保持します。
         *
         * @param 導入形態コード 導入形態コード
         */
        public Builder(DonyuKeitaiCode 導入形態コード) {
            this.介護導入区分 = KaigoDonyuKubun.導入済;
            this.導入形態コード = 導入形態コード;
            this.広域タイプ = KoikiType.未設定;
            this.市町村ID有効桁数 = RString.EMPTY;
            this.市町村情報 = new ShichosonJoho();
        }

        /**
         * 支所管理有無フラグを設定します。
         *
         * @param 支所管理有無フラグ 支所管理有無フラグ
         * @return builder
         */
        public Builder set支所管理有無フラグ(boolean 支所管理有無フラグ) {
            this.支所管理有無フラグ = 支所管理有無フラグ;
            return this;
        }

        /**
         * 広域タイプを設定します。
         *
         * @param 広域タイプ 広域タイプ
         * @return builder
         */
        public Builder set広域タイプ(KoikiType 広域タイプ) {
            Objects.requireNonNull(広域タイプ);
            this.広域タイプ = 広域タイプ;
            return this;
        }

        /**
         * 市町村ＩＤ有効桁数を設定します。
         *
         * @param 市町村ID有効桁数 市町村ID有効桁数
         * @return builder
         */
        public Builder set市町村ＩＤ有効桁数(RString 市町村ID有効桁数) {
            Objects.requireNonNull(市町村ID有効桁数);
            this.市町村ID有効桁数 = 市町村ID有効桁数;
            return this;
        }

        /**
         * 市町村情報を設定します。
         *
         * @param 市町村情報 市町村情報
         * @return builder
         */
        public Builder set市町村情報(ShichosonJoho 市町村情報) {
            Objects.requireNonNull(市町村情報);
            this.市町村情報 = 市町村情報;
            return this;
        }

        /**
         * {@link ShichosonSecurityJoho}を生成します。
         *
         * @return {@link ShichosonSecurityJoho}
         */
        public ShichosonSecurityJoho build() {
            return new ShichosonSecurityJoho(this);
        }
    }

}
