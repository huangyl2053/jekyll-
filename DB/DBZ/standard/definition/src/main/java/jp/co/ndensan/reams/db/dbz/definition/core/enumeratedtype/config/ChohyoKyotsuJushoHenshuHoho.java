/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.config;

/**
 * このクラスでは、業務Config 帳票共通住所編集方法 に対応するキーをまとめています。
 *
 * @author N3327 三浦 凌
 */
public final class ChohyoKyotsuJushoHenshuHoho {

    /**
     * 管内住所編集。
     */
    public enum KannaiJushoHenshu implements IConfigKey {

        /**
         * 都道府県名を印字するか、しないか、です。
         */
        帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
        /**
         * 郡名を印字するか、しないか、です。
         */
        帳票共通住所編集方法_管内住所編集_郡名付与有無,
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
     * 住所編集。
     */
    public enum JushoHenshu implements IConfigKey {

        /**
         * 方書を印字するか、しないか、です。
         */
        帳票共通住所編集方法_住所編集_方書表示有無;
    }
}
