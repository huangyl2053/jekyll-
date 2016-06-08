/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author n3331
 */
public enum SetaiShotokuIchiranComparators implements Comparator<SetaiinShotoku> {

    /**
     * 賦課年度でソートする機能を持ちます。
     */
    orderBy本人区分 {
                @Override
                public int compare(SetaiinShotoku model1, SetaiinShotoku model2) {
                    return model1.get本人区分().compareTo(model2.get本人区分());
                }
            },
    /**
     * 住民票表示順でソートする機能を持ちます。
     */
    orderBy住民票表示順 {
                @Override
                public int compare(SetaiinShotoku model1, SetaiinShotoku model2) {
                    return Integer.toString(model1.get住民票表示順()).compareTo(Integer.toString(model2.get住民票表示順()));
                }
            };

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<SetaiinShotoku> asc() {
        return this;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<SetaiinShotoku> desc() {
        return Collections.reverseOrder(this);
    }

}
