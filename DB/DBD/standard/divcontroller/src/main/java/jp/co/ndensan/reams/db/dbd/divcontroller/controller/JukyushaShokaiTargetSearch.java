/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.JukyushaData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.JukyushaShokaiTargetSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * JukyushaShokaiTargetSearchDiv用のサーバサイド処理クラスです。
 *
 * @author N3327 三浦 凌
 */
public class JukyushaShokaiTargetSearch {

    /**
     * ロード時の処理です。
     *
     * @param div JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiTargetSearchDiv> onLoad(JukyushaShokaiTargetSearchDiv div) {
        return _createResponseData(div);
    }

    /**
     * 検索ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiTargetSearchDiv> onClick_btnToSearch(JukyushaShokaiTargetSearchDiv div) {
        SearchResultOfHihokensha.setSearchResult(div.getSearchResult(), new JukyushaData().getAll().asConvertedType());
        return _createResponseData(div);
    }

    public ResponseData<JukyushaShokaiTargetSearchDiv> onClick_btnToDecide(JukyushaShokaiTargetSearchDiv div) {
        SearchResultForJukyushaShokai.getInstance().save(div.getSearchResult());
        return _createResponseData(div);
    }

    private ResponseData<JukyushaShokaiTargetSearchDiv> _createResponseData(JukyushaShokaiTargetSearchDiv div) {
        ResponseData<JukyushaShokaiTargetSearchDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

}
