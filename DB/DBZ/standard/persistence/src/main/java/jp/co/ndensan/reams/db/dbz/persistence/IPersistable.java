/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence;

/**
 * あるオブジェクトを永続化する機能をもつことを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 永続化するオブジェクトの型
 */
public interface IPersistable<T> extends IInsertable<T>, IUpdatable<T>, IDeletable<T> {
}
