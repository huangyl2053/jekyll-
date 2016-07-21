/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import java.util.Collections;
import java.util.Comparator;

/**
 * FukaのComparatorクラスです。
 *
 * @author N8156 宮本 康
 */
public enum FukaComparators implements Comparator<Fuka> {

    /**
     * 賦課年度でソートする機能を持ちます。
     */
    orderBy賦課年度 {
                @Override
                public int compare(Fuka model1, Fuka model2) {
                    return model1.get賦課年度().compareTo(model2.get賦課年度());
                }
            },
    /**
     * 調定年度でソートする機能を持ちます。
     */
    orderBy調定年度 {
                @Override
                public int compare(Fuka model1, Fuka model2) {
                    return model1.get調定年度().compareTo(model2.get調定年度());
                }
            },
    /**
     * 通知書番号でソートする機能を持ちます。
     */
    orderBy通知書番号 {
                @Override
                public int compare(Fuka model1, Fuka model2) {
                    return model1.get通知書番号().compareTo(model2.get通知書番号());
                }
            },
    /**
     * 履歴番号でソートする機能を持ちます。
     */
    orderBy履歴番号 {
        @Override
        public int compare(Fuka model1, Fuka model2) {
            int ret = 0;
            if (model1.get履歴番号() < model2.get履歴番号()) {
                ret = -1;
            } else if (model1.get履歴番号() == model2.get履歴番号()) {
                ret = 0;
            } else {
                ret = 1;
            }

            return ret;
         }
    };

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<Fuka> asc() {
        return this;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<Fuka> desc() {
        return Collections.reverseOrder(this);
    }
}
