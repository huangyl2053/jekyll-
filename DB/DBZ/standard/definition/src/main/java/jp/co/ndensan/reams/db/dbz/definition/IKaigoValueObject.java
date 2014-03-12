/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;

/**
 * ドメインオブジェクトの最小単位を表すインターフェースです。<br />
 * {@link IValueObject}, {@link　Comparable}の各インタフェースの実装を強制します。<br />
 * 二番目の型変数には、このインタフェースを実装したクラス自身を指定します。
 * そうすることで、{@link Comparable#compareTo(java.lang.Object) Comparable#compareTo( )}による比較対象が実装クラス自身になります。
 *
 * @author N3327 三浦 凌
 * @param <V> このオブジェクトが保持するオブジェクトの型
 * @param <T> このインターフェースを実装したオブジェクトの型
 */
public interface IKaigoValueObject<V, T extends IKaigoValueObject<V, T>> extends IValueObject<V>, Comparable<T> {
}
