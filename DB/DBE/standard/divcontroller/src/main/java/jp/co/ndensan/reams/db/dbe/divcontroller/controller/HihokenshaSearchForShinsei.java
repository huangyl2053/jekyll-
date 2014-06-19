/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.YokaigoninteiShinseishaData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 要介護認定申請時に、対象となる被保険者を検索するDivを制御します。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaSearchForShinsei {

    /**
     * onLoad
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onLoad(HihokenshaSearchForShinseiDiv panel) {
        HihokenshaFinder.setMode(HihokenshaFinder.Mode.NORMAL, panel.getSearchCriteriaForShinsei());
        return _createResponseData(panel);
    }

    /**
     * 検索ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClick_btnToSearch(HihokenshaSearchForShinseiDiv panel) {
        SearchResultOfHihokensha.setSearchResult(panel.getSearchResultForShinsei(),
                new YokaigoninteiShinseishaData().get要介護認定申請者List().asConvetedType());
        return _createResponseData(panel);
    }

    private ResponseData<HihokenshaSearchForShinseiDiv> _createResponseData(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }
}
