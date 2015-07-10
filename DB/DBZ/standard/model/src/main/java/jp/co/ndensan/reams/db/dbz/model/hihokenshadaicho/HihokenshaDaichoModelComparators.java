/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import java.util.Collections;
import java.util.Comparator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel 被保険者台帳Model}をソートするためのComparatorを提供します。
 *
 * @author n8178 城間篤人
 */
public enum HihokenshaDaichoModelComparators implements Comparator<HihokenshaDaichoModel> {

    /**
     * 資格取得日で被保険者台帳Modelをソートする機能を持ちます。
     */
    orderBy資格取得年月日 {
                @Override
                public int compare(HihokenshaDaichoModel model1, HihokenshaDaichoModel model2) {
                    return compareToFlexibleDate(model1.get資格取得年月日(), model2.get資格取得年月日());
                }
            },
    /**
     * 処理日時で被保険者台帳Modelをソートする機能を持ちます。
     */
    orderBy処理日時 {
                @Override
                public int compare(HihokenshaDaichoModel model1, HihokenshaDaichoModel model2) {
                    return model1.get処理日時().compareTo(model2.get処理日時());
                }
            },
    /**
     * orderBy資格変更年月日で被保険者台帳Modelをソートする機能を持ちます。
     */
    orderBy資格変更年月日 {
                @Override
                public int compare(HihokenshaDaichoModel model1, HihokenshaDaichoModel model2) {
                    return compareToFlexibleDate(model1.get資格変更年月日(), model2.get資格変更年月日());
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

    private static int compareToFlexibleDate(FlexibleDate model1Date, FlexibleDate model2Date) {
        //TODO n8178 城間篤人 Emptyが日付に入っていた場合、どのようにソートするかを決める必要がある。 2015年2月

        if (isNullOrEmpty(model1Date)) {
            model1Date = FlexibleDate.MAX;
        }
        if (isNullOrEmpty(model2Date)) {
            model2Date = FlexibleDate.MAX;
        }
        return model1Date.compareTo(model2Date);
    }

    private static boolean isNullOrEmpty(FlexibleDate date) {
        return date == null || date.isEmpty();
    }

}
