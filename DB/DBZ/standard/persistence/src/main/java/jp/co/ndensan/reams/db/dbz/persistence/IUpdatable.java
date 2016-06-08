/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence;

import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * テーブルデータをアップデートするためのインタフェースです。
 *
 * @author n8223 朴義一
 * @param <T>
 */
public interface IUpdatable<T> {

    /**
     * データのアップデートを行います。
     *
     * @param data 対象のデータ
     * @return アップデート件数
     */
    @Transaction
    int update(T data);
}
