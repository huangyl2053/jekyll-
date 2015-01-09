/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.config;

/**
 * 業務Config 保険者情報 のキーです。
 *
 * @author N3327 三浦 凌
 */
public enum HokenshaJoho implements IConfigKey {

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
