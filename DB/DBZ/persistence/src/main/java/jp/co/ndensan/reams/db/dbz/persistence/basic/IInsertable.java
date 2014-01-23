/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * テーブルへのデータの挿入をするためのインタフェースです。
 *
 * @author N3327 三浦 凌
 * @param <T> 挿入したいテーブルのEntityクラス
 */
public interface IInsertable<T extends IDbAccessable> {

    /**
     * データをテーブルへ挿入します。
     *
     * @param data 挿入したいデータ
     * @return 挿入件数
     */
    int insert(T data);
}
