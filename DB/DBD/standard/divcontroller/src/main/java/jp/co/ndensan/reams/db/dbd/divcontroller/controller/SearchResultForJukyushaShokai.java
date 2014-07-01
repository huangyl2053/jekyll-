/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;

/**
 * 受給者照会の検索結果を保持します。 この実装は、規約違反なので、デモ後に消します。
 *
 * @author N3327 三浦 凌
 */
final class SearchResultForJukyushaShokai {

    private SearchResultOfHihokenshaDiv searchResult;

    private SearchResultForJukyushaShokai() {
    }

    private static class SearchResultHolder {

        private static final SearchResultForJukyushaShokai instance = new SearchResultForJukyushaShokai();
    }

    static SearchResultForJukyushaShokai getInstance() {
        return SearchResultHolder.instance;
    }

    void save(SearchResultOfHihokenshaDiv searchResultDiv) {
        this.searchResult = searchResultDiv;
    }

    SearchResultOfHihokenshaDiv get() {
        return this.searchResult;
    }
}
