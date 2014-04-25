/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.HihokenshaFinderDiv;

/**
 * HihokenshaFinderDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaFinder {

    private HihokenshaFinder() {
    }

    /**
     * 内包する編集可能なUI部品の設定値をクリアします。
     *
     * @param div クリアされた{@link HihokenshaFinderDiv HihokenshaFinderDiv}
     */
    public static void clear(HihokenshaFinderDiv div) {
        SearchCriteriaOfHokensha.clear(div.getSearchCriteriaOfHokensha());
        SearchCriteriaOfKojin.clear(div.getSearchCriteriaOfKojin());
        SearchCriteriaOfHihokensha.clear(div.getSearchCriteriaOfHihokensha());
    }
}
