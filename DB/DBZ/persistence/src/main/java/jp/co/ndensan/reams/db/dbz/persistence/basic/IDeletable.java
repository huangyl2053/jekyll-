/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * テーブルからのデータの削除をするためのインタフェースです。
 *
 * @author N3327 三浦 凌
 * @param <T> 削除したいテーブルのEntityクラス
 */
public interface IDeletable<T extends IDbAccessable> {

    /**
     * データをテーブルから削除します。
     *
     * @param data 削除したいデータ
     * @return 削除件数
     */
    @Transaction
    int delete(T data);
}
