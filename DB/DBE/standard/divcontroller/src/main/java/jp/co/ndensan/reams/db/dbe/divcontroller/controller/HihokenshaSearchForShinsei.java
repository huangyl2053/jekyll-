/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.YokaigoninteiShinseishaData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaSearchForShinseiDiv;
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
     * 検索ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToSearch(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        SearchResultOfHihokensha.setSearchResult(panel.getSearchResultForShinsei(),
                new YokaigoninteiShinseishaData().get要介護認定申請者List().asConvetedType());

        response.data = panel;
        return response;
    }

    /**
     * 検索条件クリアボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToClear(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        HihokenshaFinder.clear(panel.getSearchCriteriaForShinsei());

        response.data = panel;
        return response;
    }

    /**
     * 再建策ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToResearch(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        HihokenshaFinder.clear(panel.getSearchCriteriaForShinsei());
        SearchResultOfHihokensha.clear(panel.getSearchResultForShinsei());

        response.data = panel;
        return response;
    }

    /**
     * データグリッド内の確定ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToDecideOfGridData(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        response.data = panel;
        return response;
    }
}
