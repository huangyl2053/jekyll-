/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateChangeState;

/**
 * {@link ViewStateHolder ViewStateHolder}により、{@code ViewState}へ保持されたり、取得されたりする値であることを表します。
 *
 * @author N3327 三浦 凌
 * @param <T> 扱うオブジェクトの型
 */
public interface IViewStateValue<T extends Serializable> {

    /**
     * {@code ViewState}へ保持されている値を取得します。ただし、値は保持されていないこともあります。
     *
     * @return ViewStateに保持されている値(ただし、保持していないかもしれない。)
     */
    Optional<T> tryToGet();

    /**
     * 引数の値を、{@code ViewState}へ保持します。
     *
     * @param value ViewStateへ保持する値
     */
    void put(T value);

    /**
     * 値を消去します。
     */
    void remove();

    /**
     * 値の状態を返します。
     *
     * @return 状態
     */
    ViewStateChangeState state();

    /**
     * 値が空かどうかを返します。
     *
     * @return 値が空なら{@code true}
     */
    boolean isEmpty();

    /**
     * 値が削除されているかどうかを返します。
     *
     * @return 値が削除されているなら{@code true}
     */
    boolean isDeleted();

    /**
     * 値が変更されているかどうかを返します。
     *
     * @return 値が変更されているなら{@code true}
     */
    boolean isModified();

    /**
     * 値が変更されていないかどうかを返します。
     *
     * @return 値が変更されていないなら{@code true}
     */
    boolean isNoChange();
}
