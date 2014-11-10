/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * ValueObjectをチェックする{@link IValueObjectCheckable IValueObjectCheckable}なオブジェクトをリストを保持します。
 *
 * @author N3327 三浦 凌
 * @param <T> ValueObjectが持つ値の型
 */
public final class ValueObjectCheckList<T> implements Iterable<IValueObjectCheckable<T>> {

    private final List<IValueObjectCheckable<T>> list;

    private ValueObjectCheckList(List<IValueObjectCheckable<T>> list) {
        this.list = Collections.unmodifiableList(list);
    }

    /**
     * {@link IValueObjectCheckable IValueObjectCheckable}なオブジェクトを1つ以上指定して、
     * それらを保持するインスタンスを生成します。
     *
     * @param <T> ValueObjectが保持する型
     * @param checks
     * {@link IValueObjectCheckable IValueObjectCheckable}を実装したオブジェクト
     * @return {@link ValueObjectCheckList ValueObjectCheckList}
     * @throws NullPointerException 第1引数がnullの時
     */
    public static <T> ValueObjectCheckList<T> checks(IValueObjectCheckable<T>... checks) throws NullPointerException {
        Objects.requireNonNull(checks);
        List<IValueObjectCheckable<T>> list = Arrays.asList(checks);
        if (list.contains(null)) {
            throw new IllegalArgumentException("引数にnullの要素を含みます。");
        }
        return new ValueObjectCheckList<>(list);
    }

    @Override
    public Iterator<IValueObjectCheckable<T>> iterator() {
        return this.list.iterator();
    }

    /**
     * 保持する要素の数を返します。
     *
     * @return 保持する要素の数
     */
    public int size() {
        return this.list.size();
    }
}
