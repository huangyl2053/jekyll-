/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SearchCriteriaOfKojinDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class SearchCriteriaOfKojin {

    private SearchCriteriaOfKojin() {
    }

    /**
     * 内包する編集可能なUI部品への設定値をクリアします。
     *
     * @param div
     * クリアされた{@link SearchCriteriaOfKojinDiv SearchCriteriaOfKojinDiv}
     */
    public static void clear(SearchCriteriaOfKojinDiv div) {
        div.getTxtBirthDay().clearValue();
        div.getTxtJusho().clearValue();
        div.getTxtKojinNo().clearValue();
        div.getTxtSetaiCode().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtYubinNo().clearValue();
        div.getChkGender().setSelectedItems(Collections.EMPTY_LIST);
        div.getRadSearchPatternOfShimei().setSelectedItem(RString.EMPTY);
        div.getDdlJuminShubetsu().setSelectedItem(RString.EMPTY);
    }
}
