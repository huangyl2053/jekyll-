/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.config;

/**
 * 介護共通の業務ConfigKeyの一覧です。
 *
 * @author N3327 三浦 凌
 */
public final class DbzConfigKeys {

    /**
     * 保険者情報
     */
    public enum HokenshaInfo implements IConfigKey {

        /**
         * 単一市町村か、広域市町村か、といった保険者の構成です。
         */
        保険者情報_保険者構成,
        /**
         * 保険者番号です。
         */
        保険者情報_保険者番号,
        /**
         * 保険者の名称です。
         */
        保険者情報_保険者名称,
        /**
         * 最優先地区コードです。
         */
        保険者情報_最優先地区コード,
        /**
         * 保険者の住所です。
         */
        保険者情報_住所,
        /**
         * 保険者の電話番号です。
         */
        保険者情報_電話番号,
        /**
         * 郵便番号です。
         */
        保険者情報_郵便番号,
        /**
         * 広域のタイプです。
         */
        保険者情報_広域タイプ,
        /**
         * 広域保険者のシステム構成です。
         */
        保険者情報_広域システム構成,
        /**
         * 移行タイプです。
         */
        保険者情報_移行タイプ,
        /**
         * 個別事項へ連携するかしないかの区分です。
         */
        保険者情報_個別事項連携有無区分;
    }

    /**
     * 帳票共通住所編集方法_管内住所編集
     */
    public enum KannaiJushoHenshu implements IConfigKey {

        /**
         * 都道府県名を印字するか、しないか、です。
         */
        帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
        /**
         * 群名を印字するか、しないか、です。
         */
        帳票共通住所編集方法_管内住所編集_群名付与有無,
        /**
         * 市町村名を印字するか、しないか、です。
         */
        帳票共通住所編集方法_管内住所編集_市町村名付与有無,
        /**
         * 管内住所をどのように編集するかの指定です。
         */
        帳票共通住所編集方法_管内住所編集_編集方法;
    }

    /**
     * 帳票共通住所編集方法_住所編集
     */
    public enum JushoHenshu implements IConfigKey {

        /**
         * 方書を印字するか、いないか、です。
         */
        帳票共通住所編集方法_住所編集_方書表示有無;
    }
}
