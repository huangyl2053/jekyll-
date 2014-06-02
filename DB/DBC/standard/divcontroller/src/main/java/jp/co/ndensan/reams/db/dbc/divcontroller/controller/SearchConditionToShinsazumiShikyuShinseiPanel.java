/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchConditionToShinsazumiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223
 */
public class SearchConditionToShinsazumiShikyuShinseiPanel {

    /**
     * 住宅改修費支給申請決定 審査済支給申請検索条件の情報を設定する。
     *
     * @param panel JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<SearchConditionToShinsazumiShikyuShinseiPanelDiv> onLoad(SearchConditionToShinsazumiShikyuShinseiPanelDiv panel) {
        ResponseData<SearchConditionToShinsazumiShikyuShinseiPanelDiv> response = new ResponseData<>();

        //TO DO 
        setSearchConditionToShinsazumiShikyuShinsei(panel);

        response.data = panel;
        return response;

    }

    /* 
     *  住宅改修費支給申請決定 審査済支給申請検索条件の情報を設定する。(YMLDATA)
     */
    private void setSearchConditionToShinsazumiShikyuShinsei(SearchConditionToShinsazumiShikyuShinseiPanelDiv panel) {

        //TO DO 
        String ymlDataName = "ShinsazumiShikyuShinseiSearchCondition.yml";
        //TO DO 
        List<HashMap> ymlData = ymlData(ymlDataName);

        String shinsaDateFrom = ymlData.get(0).get("shinsaDateFrom").toString();
        String shinsaDateTo = ymlData.get(0).get("shinsaDateTo").toString();

        panel.getTxtShinsaDate().setFromValue(new RDate(shinsaDateFrom));
        panel.getTxtShinsaDate().setToValue(new RDate(shinsaDateTo));

    }

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }

}
