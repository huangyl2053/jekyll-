/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence;

/**
 * テーブルへのデータの挿入をするためのインタフェースです。
 *
 * @author N3327 三浦 凌
 * @param <T> 挿入したいテーブルのEntityクラス
 */
public interface IInsertable<T> {

    /**
     * データをテーブルへ挿入します。
     *
     * @param data 挿入したいデータ
     * @return 挿入件数
     */
    int insert(T data);
}
