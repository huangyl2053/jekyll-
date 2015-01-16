/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import java.util.Collections;
import java.util.Comparator;

/**
 * {@link jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel 被保険者台帳Model}をソートするためのComparatorを提供します。
 *
 * @author n8178 城間篤人
 */
public enum HihokenshaDaichoModelComparators implements Comparator<HihokenshaDaichoModel> {

    /**
     * orderBy資格取得年月日で被保険者台帳Modelをソートする機能を持ちます。
     */
    orderBy資格取得年月日 {
                @Override
                public int compare(HihokenshaDaichoModel model1, HihokenshaDaichoModel model2) {
                    return model1.get資格取得年月日().compareTo(model2.get資格取得年月日());
                }
            };

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<HihokenshaDaichoModel> asc() {
        return this;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<HihokenshaDaichoModel> desc() {
        return Collections.reverseOrder(this);
    }

}
