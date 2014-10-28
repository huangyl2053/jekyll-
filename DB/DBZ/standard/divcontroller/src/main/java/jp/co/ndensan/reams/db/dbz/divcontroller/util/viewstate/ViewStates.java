/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * {@literal ViewState}を扱うユーティリティです。
 *
 * @author N3327 三浦 凌
 */
public final class ViewStates {

    private static final IViewStateAccessors ACCESSORS;

    static {
        ACCESSORS = new _ViewStateAccessors();
    }

    private ViewStates() {
    }

    /**
     * {@literal ViewState}へアクセスするためのインスタンスを生成します。<br/>
     * ViewStateHolderを用いる時とこのメソッドを用いる時の違いを、実装例で示します。
     * <p>
     * 取得時 :
     * <pre>
     *  ViewStateHolder.get("key",HihokenshaNo.class);
     *  ViewStates.access().valueAssignedTo(ViewStateKey.被保番号, HihokenshaNo.class).tryToGet();
     *
     *   ※HihokenshaNo は Serializable を実装するクラスです。
     *   ※ViewStateKey は IViewStateKey を実装するenumです。
     *
     *  ■「取得」メソッドの戻り値
     *    get()      : 引数で指定したClass
     *    tryToGet() : {@link IOptional IOptional}
     *
     *  ■ViewStateに保持されている値がnullの場合
     *    get()      : nullを返します。
     *    tryToGet() : isPresent()が{@code false}を返します。
     * </pre>
     * </p>
     * <p>
     * 設定時 :
     * <pre>
     *  ViewStateHolder.put("key", new HihokenshaNo("1234567890");
     *  ViewStates.access().valueAssignedTo(ViewStateKey.被保番号, HihokenshaNo.class).put(new HihokenshaNo("1234567890"));
     *
     *   ※HihokenshaNo は Serializable を実装するクラスです。
     *   ※ViewStateKey は IViewStateKey を実装するenumです。
     *
     *  ViewStates.access() から生成したインスタンスでは、設定時にも型を指定する必要があります。
     *
     * </pre>
     * </p>
     *
     * @return {@literal ViewState}へアクセスするためのインスタンス
     */
    public static IViewStateAccessors access() {
        return ACCESSORS;
    }

    /**
     * 指定のキーが存在するかどうかを返します。
     *
     * @param key キー
     * @return キーが存在する時は{@literal true}
     * @throws NullPointerException 引数がnullのとき
     */
    public static boolean containsKey(IViewStateKey key) throws NullPointerException {
        Objects.requireNonNull(key);
        return ViewStateHolder.containsKey(key.toString());
    }
}
