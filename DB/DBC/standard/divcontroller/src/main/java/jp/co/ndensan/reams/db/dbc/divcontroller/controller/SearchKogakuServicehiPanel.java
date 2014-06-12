/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SearchKogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費照会
 *
 * @author n8223
 */
public class SearchKogakuServicehiPanel {

    final static String HihokenshaShitei = "被保険者を指定して検索する";
    final static String YMShitei = "年月を指定して検索する";

    /**
     * 高額介護サービス費照会 高額介護サービス費照会画面の初期表示する。
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<SearchKogakuServicehiPanelDiv> onLoad(SearchKogakuServicehiPanelDiv panel) {
        ResponseData<SearchKogakuServicehiPanelDiv> response = new ResponseData<>();

        setSearchKogakuServicehiInfo(panel);

        response.data = panel;
        return response;
    }

    /**
     * 高額介護サービス費照会 一覧画面に戻るボタン押したら、高額介護サービス費照会画面の初期表示する。
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<SearchKogakuServicehiPanelDiv> onClick_ToSearchPanel(SearchKogakuServicehiPanelDiv panel) {
        ResponseData<SearchKogakuServicehiPanelDiv> response = new ResponseData<>();

        setSearchKogakuServicehiInfo(panel);
        setSearchYMClear(panel);
        
        response.data = panel;
        return response;
    }

    private void setSearchKogakuServicehiInfo(SearchKogakuServicehiPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiSearchKogakuServicehi.yml");

        //被保険者を指定して検索する（初期表示）
        panel.getRadSearchKubun().setSelectedItem(new RString(
                ymlData.get(0).get("hihoNo").toString()));

        //被保険者を指定して検索する。 
        panel.getSearchKogakuHihokensha().getTxtHihoNo().setValue(new RString(
                ymlData.get(0).get("hihoNo").toString()));
        panel.getSearchKogakuHihokensha().getTxtHihoName().setValue(new RString(
                ymlData.get(0).get("hihoName").toString()));
        panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setFromValue(new RDate(
                ymlData.get(0).get("teikyoYMRangefrom").toString()));
        panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setToValue(new RDate(
                ymlData.get(0).get("teikyoYMRangeto").toString()));
        panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setFromValue(new RDate(
                ymlData.get(0).get("shinseiYMRangefrom").toString()));
        panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setToValue(new RDate(
                ymlData.get(0).get("shinseiYMRangeto").toString()));
        panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setFromValue(new RDate(
                ymlData.get(0).get("ketteiYMRangefrom").toString()));
        panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setToValue(new RDate(
                ymlData.get(0).get("ketteiYMRangeto").toString()));

    }

    /**
     * 高額介護サービス費照会 被保険者/年月を指定して検索する内容が表示・非表示する。
     *
     * @author n8223
     * @param panel
     * @return
     */
    public ResponseData<SearchKogakuServicehiPanelDiv> onClick_radSearchKubun(SearchKogakuServicehiPanelDiv panel) {
        ResponseData<SearchKogakuServicehiPanelDiv> response = new ResponseData<>();
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiSearchKogakuServicehi.yml");
        switch (panel.getRadSearchKubun().getSelectedValue().toString()) {
            case HihokenshaShitei:
                //被保険者を指定して検索する。
                panel.getSearchKogakuHihokensha().getTxtHihoNo().setValue(new RString(
                        ymlData.get(0).get("hihoNo").toString()));
                panel.getSearchKogakuHihokensha().getTxtHihoName().setValue(new RString(
                        ymlData.get(0).get("hihoName").toString()));
                panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setFromValue(new RDate(
                        ymlData.get(0).get("teikyoYMRangefrom").toString()));
                panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setToValue(new RDate(
                        ymlData.get(0).get("teikyoYMRangeto").toString()));
                panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setFromValue(new RDate(
                        ymlData.get(0).get("shinseiYMRangefrom").toString()));
                panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setToValue(new RDate(
                        ymlData.get(0).get("shinseiYMRangeto").toString()));
                panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setFromValue(new RDate(
                        ymlData.get(0).get("ketteiYMRangefrom").toString()));
                panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setToValue(new RDate(
                        ymlData.get(0).get("ketteiYMRangeto").toString()));
                
                //clear 
                setSearchYMClear(panel);

                
                break;
            case YMShitei:
                
                //年月を指定して検索する。
                panel.getSearchYM().getTxtTeikyoYM().setValue(new RDate(
                        ymlData.get(1).get("teikyoYM").toString()));
                panel.getSearchYM().getTxtShinseiYM().setValue(new RDate(
                        ymlData.get(1).get("shinseiYM").toString()));
                panel.getSearchYM().getTxtKetteiYM().setValue(new RDate(
                        ymlData.get(1).get("ketteiYM").toString()));
                
                //clear 
                setSearchKogakuHihokenshaClear(panel);

                
                break;
        }

        response.data = panel;
        return response;
    }

    private void setSearchYMClear(SearchKogakuServicehiPanelDiv paenl) {

        paenl.getSearchYM().getTxtTeikyoYM().clearValue();
        paenl.getSearchYM().getTxtShinseiYM().clearValue();
        paenl.getSearchYM().getTxtKetteiYM().clearValue();

    }

    private void setSearchKogakuHihokenshaClear(SearchKogakuServicehiPanelDiv panel) {

        panel.getSearchKogakuHihokensha().getTxtHihoNo().clearValue();
        panel.getSearchKogakuHihokensha().getTxtHihoName().clearValue();
        panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().clearFromValue();
        panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().clearToValue();
        panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().clearFromValue();
        panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().clearToValue();
        panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().clearFromValue();
        panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().clearToValue();

    }

    
    
    
    private List<HashMap> ymlData(String ymlData) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlData));
    }





}
