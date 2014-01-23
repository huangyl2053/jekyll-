/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * テーブルのデータを更新するためのインタフェースです。
 *
 * @author N3327 三浦 凌
 * @param <T> 更新したいテーブルのEntityクラス
 */
public interface IUpdatable<T extends IDbAccessable> {

    /**
     * データでテーブルを更新します。
     *
     * @param data 更新したいデータ
     * @return 更新件数
     */
    int update(T data);
}
