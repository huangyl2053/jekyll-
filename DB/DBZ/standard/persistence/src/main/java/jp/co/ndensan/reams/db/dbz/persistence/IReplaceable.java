/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence;

/**
 * テーブルへのデータの挿入または更新をするためのインタフェースです。
 *
 * @author N3327 三浦 凌
 *
 * @param <T> 挿入または更新したいテーブルのEntityクラス
 */
public interface IReplaceable<T> extends IInsertable<T>, IUpdatable<T> {

    /**
     * データと同じ内容がすでにテーブルにあれば更新、なければ挿入をします。 <br />
     * 実装する際はデータを挿入か更新かをまず判定し、それぞれ、 {@link #insert(java.lang.Object)  insert()}、
     * {@link #update(java.lang.Object)  update()} を呼び出すようにします。
     *
     * @param data 挿入または更新したいデータ
     * @return 挿入件数または更新件数
     */
    int insertOrUpdate(T data);
}
