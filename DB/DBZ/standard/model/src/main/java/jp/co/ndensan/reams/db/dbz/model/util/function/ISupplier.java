/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.function;

/**
 * ある結果を生成できるオブジェクトです。
 *
 * @author N3327 三浦 凌
 * @param <T> 生成する結果の型
 */
public interface ISupplier<T> {

    /**
     * 結果を返します。
     *
     * @return 結果
     */
    T get();
}
