/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

/**
 * 業務Configを取得するためのの機能を持つことを表します。
 *
 * @author N3327 三浦 凌
 * @deprecated 不要のため削除する。
 */
@Deprecated
public interface IBusinessConfigLoader {

    /**
     * 自サブ業務の任意のコンフィグ設定値を取得します。
     * <pre>
     * 以下に該当するConfigを返します。
     * ・指定したキー名に該当するもの
     * ・運用日時点で有効なもの
     * </pre>
     *
     * @param key 列挙型で定義されたキー名称
     * @return キー名に対応する設定値
     */
    IConfigValue load(Enum key);
}
