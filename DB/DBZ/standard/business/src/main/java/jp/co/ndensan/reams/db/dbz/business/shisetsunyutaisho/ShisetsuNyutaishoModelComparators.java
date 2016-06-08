/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.shisetsunyutaisho;

import java.util.Collections;
import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel 介護保険施設入退所Model}をソートするためのComparatorを提供します。
 *
 * @author n8223 朴義一
 */
public enum ShisetsuNyutaishoModelComparators implements Comparator<DbT1004ShisetsuNyutaishoEntity> {

    /**
     * orderBy入所年月日で施設履歴管理Modelをソートする機能を持ちます。
     */
    orderBy入所年月日 {
                @Override
                public int compare(DbT1004ShisetsuNyutaishoEntity model1, DbT1004ShisetsuNyutaishoEntity model2) {

                    int value;

                    FlexibleDate 入所年月日1 = model1.getNyushoYMD();
                    FlexibleDate 入所年月日2 = model2.getNyushoYMD();

                    value = 入所年月日1.compareTo(入所年月日2);

                    if (value == 0) {

                        FlexibleDate 退所年月日1 = getValueOrDefault(model1.getTaishoYMD());
                        FlexibleDate 退所年月日2 = getValueOrDefault(model2.getTaishoYMD());

                        value = 退所年月日1.compareTo(退所年月日2);
                    }

                    return value;
//                    return model1.get介護保険施設入退所モデル().get入所年月日().compareTo(model2.get介護保険施設入退所モデル().get入所年月日());
                }
            };

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<DbT1004ShisetsuNyutaishoEntity> asc() {
        return this;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<DbT1004ShisetsuNyutaishoEntity> desc() {
        return Collections.reverseOrder(this);
    }

    private static FlexibleDate getValueOrDefault(FlexibleDate defaultValue) {
        return (defaultValue == null) ? FlexibleDate.MAX : defaultValue;
    }
}
