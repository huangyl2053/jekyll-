/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys;

/**
 * 保険者情報の業務コンフィグに対応した列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ConfigKeysHokenshaJoho {

    /**
     * コンフィグキーが「保険者情報_保険者構成」であることを表します。
     */
    保険者情報_保険者構成,
    /**
     * コンフィグキーが「保険者情報_保険者番号」であることを表します。
     */
    保険者情報_保険者番号,
    /**
     * コンフィグキーが「保険者情報_保険者名称」であることを表します。
     */
    保険者情報_保険者名称,
    /**
     * コンフィグキーが「保険者情報_最優先地区コード」であることを表します。
     */
    保険者情報_最優先地区コード,
    保険者情報_住所,
    保険者情報_電話番号,
    保険者情報_郵便番号;
}
