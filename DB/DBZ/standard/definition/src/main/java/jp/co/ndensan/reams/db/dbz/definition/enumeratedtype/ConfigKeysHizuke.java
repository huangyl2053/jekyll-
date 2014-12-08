/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

/**
 * 日付のコンフィグキーです。
 *
 * @author N8156 宮本 康
 */
public enum ConfigKeysHizuke {

    /**
     * コンフィグキーが「日付関連_調定年度」であることを表します。
     */
    日付関連_調定年度,
    /**
     * コンフィグキーが「日付関連_当初年度」であることを表します。
     */
    日付関連_当初年度,
    /**
     * コンフィグキーが「日付関連_遡及年度」であることを表します。
     */
    日付関連_遡及年度,
    /**
     * コンフィグキーが「日付関連_所得年度」であることを表します。
     */
    日付関連_所得年度;
}
