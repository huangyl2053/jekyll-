/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;

/**
 *
 * @author N3327 三浦 凌
 */
class YokaigoNinteiShinseisha {

    private dgSearchResult_Row shinseishaInfo;

    private YokaigoNinteiShinseisha() {
    }

    private static class YokaigoNinteiShinseishaHolder {

        private static final YokaigoNinteiShinseisha instance = new YokaigoNinteiShinseisha();
    }

    static YokaigoNinteiShinseisha getInstance() {
        return YokaigoNinteiShinseishaHolder.instance;
    }

    void save(dgSearchResult_Row shinseishaInfo) {
        this.shinseishaInfo = shinseishaInfo;
    }

    dgSearchResult_Row get() {
        return this.shinseishaInfo;
    }

}
