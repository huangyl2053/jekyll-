/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.Collections;
import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;

/**
 *
 * @author n3331
 */
public enum ShotokuRirekiIchiranComparators implements Comparator<KaigoShotokuAlive> {

    /**
     * 履歴番号でソートする機能を持ちます。
     */
    orderBy履歴番号 {
                @Override
                public int compare(KaigoShotokuAlive model1, KaigoShotokuAlive model2) {
                    return model1.get履歴番号().compareTo(model2.get履歴番号());
                }
            };

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<KaigoShotokuAlive> asc() {
        return this;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<KaigoShotokuAlive> desc() {
        return Collections.reverseOrder(this);
    }

}
