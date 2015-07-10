/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 複数の{@link Comparator Comparator}を利用できるcomaratorです。
 *
 * @author N3327 三浦 凌
 * @param <T> 複数のcomparatorを適用する対象のオブジェクト
 */
@Deprecated
public class MultiComparator<T> implements Comparator<T> {

    private final List<Comparator<? super T>> comparatorList = new ArrayList<>();

    /**
     * comparatorを優先順に列挙することで、新しいMultiComparatorを生成します。
     *
     * @param comparator 最も優先するcomparator
     * @param comparators 順に優先するcomparator
     */
    public MultiComparator(Comparator<? super T> comparator, Comparator<? super T>... comparators) {
        comparatorList.add(comparator);
        comparatorList.addAll((List<Comparator<? super T>>) Arrays.asList(comparators));
    }

    @Override
    public int compare(T target1, T target2) {
        int result;
        for (Comparator comparator : comparatorList) {
            result = comparator.compare(target1, target2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
