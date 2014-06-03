/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.DataGridUtil;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * SearchResultOfHihokenshaDivのControllerです。
 *
 * @author N3327 三浦 凌
 */
public final class SearchResultOfHihokensha {

    private SearchResultOfHihokensha() {
    }

    /**
     * 検索結果をDataGridへ反映します。
     *
     * @param div
     * 検索結果を反映する{@link SearchResultOfHihokenshaDiv SearchResultOfHihokenshaDiv}
     * @param results
     * 検索結果に対応する{@link IHihokenshaForSearchResult IHihokenshaForSearchResult}のlist
     */
    public static void setSearchResult(SearchResultOfHihokenshaDiv div, List<? extends IHihokenshaForSearchResult> results) {
        List<dgSearchResult_Row> searchResults = new ArrayList<>();
        for (IHihokenshaForSearchResult hihokensha : results) {
            searchResults.add(to_dgSearchResult_Row(hihokensha));
        }
        div.getDgSearchResult().setDataSource(searchResults);
    }

    /**
     * 内包する編集可能なUI部品への設定値をクリアします。
     *
     * @param div
     * {@link SearchResultOfHihokenshaDiv SearchResultOfHihokenshaDiv}
     */
    public static void clear(SearchResultOfHihokenshaDiv div) {
        div.getDgSearchResult().setDataSource(Collections.EMPTY_LIST);
    }

    private static dgSearchResult_Row to_dgSearchResult_Row(IHihokenshaForSearchResult hihokensha) {
        TextBoxDate forBrithDay = new TextBoxDate();
        forBrithDay.setValue(hihokensha.birthDay());
        return new dgSearchResult_Row(new Button(),
                hihokensha.hihokenshaNo(),
                hihokensha.shikibetsuCode(),
                hihokensha.hihokenshaKubun(),
                hihokensha.shimei(),
                hihokensha.kanaShimei(),
                DataGridUtil.lineFeedBetween(hihokensha.kanaShimei(), hihokensha.shimei()),
                hihokensha.gender(),
                forBrithDay,
                hihokensha.yubinNo().value(),
                hihokensha.jusho(),
                hihokensha.kojinNo(),
                hihokensha.juminShubetsu(),
                hihokensha.setaiCode());
    }
}
