/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.util.Collections;
import java.util.Comparator;

/**
 * FukaModelのComparatorクラスです。
 *
 * @author N8156 宮本 康
 */
public enum FukaModelComparators implements Comparator<FukaModel> {

    /**
     * 賦課年度でソートする機能を持ちます。
     */
    orderBy賦課年度 {
                @Override
                public int compare(FukaModel model1, FukaModel model2) {
                    return model1.get賦課年度().compareTo(model2.get賦課年度());
                }
            },
    /**
     * 調定年度でソートする機能を持ちます。
     */
    orderBy調定年度 {
                @Override
                public int compare(FukaModel model1, FukaModel model2) {
                    return model1.get調定年度().compareTo(model2.get調定年度());
                }
            },
    /**
     * 通知書番号でソートする機能を持ちます。
     */
    orderBy通知書番号 {
                @Override
                public int compare(FukaModel model1, FukaModel model2) {
                    return model1.get通知書番号().compareTo(model2.get通知書番号());
                }
            };

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<FukaModel> asc() {
        return this;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<FukaModel> desc() {
        return Collections.reverseOrder(this);
    }
}
