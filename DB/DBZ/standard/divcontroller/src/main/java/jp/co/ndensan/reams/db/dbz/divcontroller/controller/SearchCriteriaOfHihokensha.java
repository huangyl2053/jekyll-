/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchCriteriaOfHihokenshaDiv;

/**
 * SearchCriteriaOfHihokenshaDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class SearchCriteriaOfHihokensha {

    private SearchCriteriaOfHihokensha() {
    }

    /**
     * 内包する編集可能なUI部品への設定値をクリアします。
     *
     * @param div
     * クリアされた{@link SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokenshaDiv}
     */
    public static void clear(SearchCriteriaOfHihokenshaDiv div) {
        div.getTxtHihokenshaNo().clearValue();
        div.getChkHihokenshaKubun().setSelectedItems(Collections.EMPTY_LIST);
    }
}
