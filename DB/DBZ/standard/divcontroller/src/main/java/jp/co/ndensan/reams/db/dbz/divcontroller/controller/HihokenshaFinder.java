/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaFinderDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaFinder {

    private final Criterias criterias;

    HihokenshaFinder() {
        this.criterias = new Criterias();
    }

    public ResponseData<HihokenshaFinderDiv> onLoad(HihokenshaFinderDiv div) {
        ResponseData<HihokenshaFinderDiv> response = new ResponseData<>();
        _init(div);
        response.data = div;
        return response;
    }

    private void _init(HihokenshaFinderDiv div) {

    }

    /**
     * 内包する編集可能なUI部品の設定値をクリアします。
     *
     * @param div クリアされた{@link HihokenshaFinderDiv HihokenshaFinderDiv}
     */
    public static void clear(HihokenshaFinderDiv div) {
        new Criterias().clear(div);
    }

    //btnToClear
    public ResponseData<HihokenshaFinderDiv> onClick_btnToClear(HihokenshaFinderDiv div) {
        ResponseData<HihokenshaFinderDiv> response = new ResponseData<>();

        criterias.clear(div);

        response.data = div;
        return response;
    }

    private static class Criterias {

        private Criterias() {
        }

        private void clear(HihokenshaFinderDiv div) {
            clear(div.getSearchCriteriaOfHihokensha());
            clear(div.getSearchCriteriaOfHokensha());
            clear(div.getSearchCriteriaOfKojin());
        }

        private void clear(SearchCriteriaOfHihokenshaDiv div) {
            div.getTxtHihokenshaNo().clearValue();
            div.getChkHihokenshaKubun().setSelectedItems(Collections.EMPTY_LIST);
        }

        private void clear(SearchCriteriaOfHokenshaDiv div) {
            div.getDdlHokensha().setSelectedItem(RString.EMPTY);
        }

        private void clear(SearchCriteriaOfKojinDiv div) {
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
}
