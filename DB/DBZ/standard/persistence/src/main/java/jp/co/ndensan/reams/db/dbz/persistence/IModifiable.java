/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence;

/**
 * テーブルデータの追加、更新と削除を統合したインタフェースです
 *
 * @author LDNS 焦蘇晋
 * @param <T>
 */
public interface IModifiable<T> extends IInsertable<T>, IUpdatable<T>, IDeletable<T> {

}
