/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchCriteriaOfHokenshaDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SearchCriteriaOfHokenshaDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class SearchCriteriaOfHokensha {

    private SearchCriteriaOfHokensha() {
    }

    /**
     * 内包する編集可能なUI部品への設定値をクリアします。
     *
     * @param div
     * クリアされた{@link SearchCriteriaOfHokenshaDiv SearchCriteriaOfHokenshaDiv}
     */
    public static void clear(SearchCriteriaOfHokenshaDiv div) {
        div.getDdlHokensha().setSelectedItem(RString.EMPTY);
    }
}
