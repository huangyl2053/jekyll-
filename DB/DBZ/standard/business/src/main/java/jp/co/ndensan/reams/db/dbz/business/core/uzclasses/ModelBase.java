/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.uzclasses;

import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 業務概念上にて「親」に該当し得ない{@link DbTableEntityBase}を継承したEntityをラップしたBusinessオブジェクトを表現するクラスです。<br/>
 * 該当の「親」となり得ないBusinessオブジェクトに継承させて利用します。
 *
 * @param <I> 識別子の型
 * @param <E> {@link DbTableEntity}を継承したEntityクラスの型
 * @param <T> 参照オブジェクトの型
 */
public abstract class ModelBase<I, E extends DbTableEntityBase<E>, T extends IModel<I, E, T>> implements IModel<I, E, T> {
    //TODO n8178 城間 UzVer1.5リリース時にUZに同じクラスが用意されるまでの代替えクラスです。後に削除されます。

    /**
     * 保持する{@link DbTableEntity}を継承したEntityが更新対象であるかを判定して真理値で返します。
     *
     * @return true：更新対象 false：更新対象でない（{@link EntityDataState#Unchanged}）
     */
    public boolean hasChangedEntity() {
        return !toEntity().getState().equals(EntityDataState.Unchanged);
    }
}
