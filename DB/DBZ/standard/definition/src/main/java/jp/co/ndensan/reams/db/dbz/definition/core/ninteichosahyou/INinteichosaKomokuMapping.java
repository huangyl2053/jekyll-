/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票 基本調査項目マッピングであることを表します。
 */
public interface INinteichosaKomokuMapping {

    /**
     * コード（連番の文字列）を返します。
     *
     * @return コード（連番の文字列）
     */
    RString getコード();

    /**
     * 表示番号を返します。
     *
     * @return の表示番号
     */
    RString get表示番号();

    /**
     * パターンNoを返します。
     *
     * @return パターンNo
     */
    RString getパターンNo();

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    RString get名称();

    /**
     * 特記事項番号を返します。
     *
     * @return 特記事項番号
     */
    RString get特記事項番号();

    /**
     * 群番号を返します。
     *
     * @return 群番号
     */
    RString get群番号();

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    int get連番();
}
