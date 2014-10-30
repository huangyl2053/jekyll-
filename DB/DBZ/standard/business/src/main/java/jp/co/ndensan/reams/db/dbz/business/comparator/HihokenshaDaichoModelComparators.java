/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.Collections;
import java.util.Comparator;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;

/**
 * 被保険者台帳の項目でソートするための比較メソッドを提供します。
 *
 * @author n8178 城間篤人
 */
public enum HihokenshaDaichoModelComparators {

    /**
     * 資格取得日で被保険者台帳Modelをソートする機能を持ちます。
     */
    資格取得日(
            new Comparator<HihokenshaDaichoModel>() {
                @Override
                public int compare(HihokenshaDaichoModel model1, HihokenshaDaichoModel model2) {
                    return model1.get資格取得日().compareTo(model2.get資格取得日());
                }
            }
    );

    private final Comparator<HihokenshaDaichoModel> asc;
    private final Comparator<HihokenshaDaichoModel> desc;

    private HihokenshaDaichoModelComparators(Comparator<HihokenshaDaichoModel> comparator) {
        asc = comparator;
        desc = Collections.reverseOrder(comparator);
    }

    /**
     * 昇順でソートする{@link Comparator}を返します。
     *
     * @return 昇順ソート
     */
    public Comparator<HihokenshaDaichoModel> getAsc() {
        return this.asc;
    }

    /**
     * 降順でソートする{@link Comparator}を返します。
     *
     * @return 降順ソート
     */
    public Comparator<HihokenshaDaichoModel> getDesc() {
        return this.desc;
    }

}
