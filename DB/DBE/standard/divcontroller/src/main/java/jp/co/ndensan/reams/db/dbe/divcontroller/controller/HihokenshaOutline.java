/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaOutline {

    /**
     * onStart
     *
     * @param div HihokenshaOutlineDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaOutlineDiv> onStart(HihokenshaOutlineDiv div) {
        dgSearchResult_Row hihokensha = clickedItem();
        div.getShikakuKihon().getTxtHihokenshaNo().setValue(hihokensha.getHihokenshaNo());
        div.getAtenaInfo().getAtenaInfo().getTxtShikibetsuCode().setValue(hihokensha.getShikibetsuCode());
        div.getAtenaInfo().getAtenaInfo().getTxtAtenaKanaMeisho().setValue(hihokensha.getKanaShimsei());
        div.getAtenaInfo().getAtenaInfo().getTxtAtenaMeisho().setValue(hihokensha.getShimei());
        return _createResponseData(div);
    }

    private dgSearchResult_Row clickedItem() {
        return YokaigoNinteiShinseisha.getInstance().get();
    }

    private ResponseData<HihokenshaOutlineDiv> _createResponseData(HihokenshaOutlineDiv div) {
        ResponseData<HihokenshaOutlineDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
