/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.util.itemlist;

import java.util.Collection;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IBiConsumer;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.function.ISupplier;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * ある入力要素の集合を、集積用のオブジェクト(コンテナ)に集積して、その後、最終的な結果へと変換して返す、という一連の処理の定義であることを表します。
 *
 * <p>
 * {@link #container() container()}で、集積用のコンテナを生成します。これは{@link List}や{@link Map}等が担当します。<br/>
 * {@link #accumulator() accumulator()}で、コンテナに対して、入力要素をマッピングします。
 * {@link Collection#add(java.lang.Object) Collection#add()}や{@link Map#put(java.lang.Object, java.lang.Object) Map#put()}の様な処理を定義します。<br/>
 * {@link #finisher() finisher()}で、コンテナを最終的な結果へ変換します。コンテナをそのまま{@code return}することもあり得ます。<br/>
 * </p>
 * 以下のコードに当てはめた時に、期待の結果が得られるように実装してください。
 * <pre>{@code
 *
 *   A container = collector.container().get();
 *   for (E t : data) {
 *       accumulator.accept(container, t);
 *   }
 *   return collector.finisher().apply(container);
 * }</pre>
 *
 * {@link IItemCollector}の実装について、{@link RString}の集合を結合して、1つの{@link RString}にしたい場合を例に示します。<br/>
 * コンテナには、{@link RStringBuilder}を用います。{@link ISupplier}に、新しい{@link RStringBuilder}のインスタンスを返す処理を定義します。
 * <pre>{@code
 *
 *   public ISupplier<RStringBuilder> container() {
 *       return new ISupplier<RStringBuilder>() {
 *           public RStringBuilder get() {
 *               return new RStringBuilder();
 *           }
 *       };
 *   }
 * }</pre>
 * アキュムレータには、{@link RStringBuilder#append(jp.co.ndensan.reams.uz.uza.lang.RString) append()}を使って、集積する処理を定義します。<br/>
 * {@link IBiConsumer}の、第1引数はコンテナ、第2引数は入力要素の中のひとつの値、としてロジックを定義します。
 * <pre>{@code
 *
 *   public IBiConsumer<RStringBuilder, RString> accumulator() {
 *       return new IBiConsumer<RStringBuilder, RString>() {
 *           public void accept(RStringBuilder t, RString u) {
 *               t.append(u);
 *           }
 *       };
 *   }
 * }</pre>
 * フィニッシャには、{@link RStringBuilder#toRString() toRString()}で、{@link RString}へ変換する処理を定義します。
 * <pre>
 * {@code
 *
 *   public IFunction<RStringBuilder, RString> finisher() {
 *       return new IFunction<RStringBuilder, RString>() {
 *           public RString apply(RStringBuilder t) {
 *               return t.toRString();
 *           }
 *       };
 *   }
 * }</pre>
 *
 * @author N3327 三浦 凌
 * @param <T> 集積する元要素の型
 * @param <A> 集積先のオブジェクトの型
 * @param <R> 結果の型
 */
public interface IItemCollector<T, A, R> {

    /**
     * 集積用のオブジェクトを生成する{@link ISupplier}を返します。
     *
     * @return 集積用のオブジェクトを生成する{@link ISupplier}
     */
    ISupplier<A> container();

    /**
     * 集積用のオブジェクトへ、入力の要素を集積する処理の定義を返します。
     *
     * @return 集積用のオブジェクトへ，入力の要素を集積する処理の定義
     */
    IBiConsumer<A, T> accumulator();

    /**
     * 集積用のオブジェクトを、結果のオブジェクトへ変換する処理の定義を返します。
     *
     * @return 集積用のオブジェクトを、結果のオブジェクトへ変換する処理の定義
     */
    IFunction<A, R> finisher();
}
