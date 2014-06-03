/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchConditionToMishinsaShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223
 */
public class SearchConditionToMishinsaShikyuShinseiPanel {

    /**
     * 住宅改修費支給申請審査 審査支給申請検索条件の情報を設定する。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchConditionToMishinsaShikyuShinseiPanelDiv> onLoad(SearchConditionToMishinsaShikyuShinseiPanelDiv panel) {
        ResponseData<SearchConditionToMishinsaShikyuShinseiPanelDiv> response = new ResponseData<>();

        //TO DO 
        setMSearchConditionToMishinsaShikyuShinsei(panel);

        response.data = panel;
        return response;

    }


    /* 
     *  住宅改修費支給申請審査 審査支給申請検索条件の情報を設定する。(YMLDATA)
     */
    private void setMSearchConditionToMishinsaShikyuShinsei(SearchConditionToMishinsaShikyuShinseiPanelDiv panel) {

        //TO DO 
        String ymlDataName = "MishinsaShikyuShinseSearchCondition.yml";
        //TO DO 
        List<HashMap> ymlData = ymlData(ymlDataName);

      
        String shikyuShinseiDateFrom = ymlData.get(0).get("shikyuShinseiDateFrom").toString();
        String shikyuShinseiDateTo = ymlData.get(0).get("shikyuShinseiDateTo").toString();

        panel.getTxtShikyuShinseiDate().setFromValue(new RDate(shikyuShinseiDateFrom));
        panel.getTxtShikyuShinseiDate().setToValue(new RDate(shikyuShinseiDateTo));

    }

    /*
     * YML DATA 設定する
     */
    private List<HashMap> ymlData(String ymlDataName) {

        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }
}
