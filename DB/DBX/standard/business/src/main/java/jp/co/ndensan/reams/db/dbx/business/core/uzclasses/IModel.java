/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.uzclasses;

import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;

/**
 * DBへ永続化するオブジェクトを扱います。DDDでいうところのエンティティに該当します。<br/>
 * IModelsを実装したオブジェクトは識別子を持ちます。<br/>
 * 識別子は{@link #identifier()}で取得でき、この戻り値が同じ値ならば、同じエンティティと判断します。
 *
 * @param <I> 識別子の型
 * @param <E> DbEntityの型
 * @param <T> このオブジェクトを実装する自身の型
 */
public interface IModel<I, E extends DbTableEntityBase<E>, T extends IModel<I, E, T>> extends IIdentifiable<I> {
    //TODO n8178 城間 UzVer1.5リリース時にUZに同じクラスが用意されるまでの代替えクラスです。後に削除されます。

    /**
     * DbEntityへ変換します。
     *
     * @return DbEntity
     */
    E toEntity();

    /**
     * 削除状態となった自身のコピーを返します。
     *
     * @return 削除状態となった自身のコピー
     */
    T deleted();

    /**
     * 保持するEntity及び、Modelsの変更状態を返します。
     *
     * @return true:変更状態有り false:変更状態無し
     */
    boolean hasChanged();
}
