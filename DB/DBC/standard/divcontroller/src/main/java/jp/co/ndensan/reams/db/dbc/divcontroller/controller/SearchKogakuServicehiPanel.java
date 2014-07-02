/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SearchKogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費照会
 *
 * @author n8223
 * @author n8223 YMLデータ対応 2014.06.26
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
        
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //被保険者を指定して検索する（初期表示）
        panel.getRadSearchKubun().setSelectedItem(ymlDt.getAsRString("hihoNo"));

        //被保険者を指定して検索する。
        //被保険者番号
        panel.getSearchKogakuHihokensha().getTxtHihoNo().setValue(
                ymlDt.getAsRString("hihoNo"));
        //被保険者名
        panel.getSearchKogakuHihokensha().getTxtHihoName().setValue(
                ymlDt.getAsRString("hihoName"));
        //提供年月       
        panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setFromValue(
                ymlDt.getAsRDate("teikyoYMRangefrom"));
        
        panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setToValue(
                ymlDt.getAsRDate("teikyoYMRangeto"));
        //申請年月
        panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setFromValue(
                ymlDt.getAsRDate("shinseiYMRangefrom"));
        panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setToValue(
                ymlDt.getAsRDate("shinseiYMRangeto"));
        
        //決定年月
        panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setFromValue(
                ymlDt.getAsRDate("ketteiYMRangefrom"));
        panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setToValue(
               ymlDt.getAsRDate("ketteiYMRangeto"));

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

        HashMap hashMap;
        ControlGenerator ymlDt;         
       
        switch (panel.getRadSearchKubun().getSelectedValue().toString()) {
            case HihokenshaShitei:
                
                 hashMap = ymlData.get(0);
                 ymlDt = new ControlGenerator(hashMap);
        
                //被保険者を指定して検索する。
                //被保番号 
                panel.getSearchKogakuHihokensha().getTxtHihoNo().setValue(
                        ymlDt.getAsRString("hihoNo"));
                //被保険番号
                panel.getSearchKogakuHihokensha().getTxtHihoName().setValue(
                        ymlDt.getAsRString("hihoName"));
                //提供年月
                panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setFromValue(
                        ymlDt.getAsRDate("teikyoYMRangefrom"));
                panel.getSearchKogakuHihokensha().getTxtTeikyoYMRange().setToValue(
                        ymlDt.getAsRDate("teikyoYMRangeto"));
                //申請年月
                panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setFromValue(
                        ymlDt.getAsRDate("shinseiYMRangefrom"));
                panel.getSearchKogakuHihokensha().getTxtShinseiYMRange().setToValue(
                        ymlDt.getAsRDate("shinseiYMRangeto"));
                //決定年月
                panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setFromValue(
                        ymlDt.getAsRDate("ketteiYMRangefrom"));
                panel.getSearchKogakuHihokensha().getTxtKetteiYMRange().setToValue(
                        ymlDt.getAsRDate("ketteiYMRangeto"));

                //clear 
                setSearchYMClear(panel);

                break;
                
            case YMShitei:

                  hashMap = ymlData.get(1);
                  ymlDt = new ControlGenerator(hashMap);
                //年月を指定して検索する。
                //提供年月
                panel.getSearchYM().getTxtTeikyoYM().setValue(
                        ymlDt.getAsRDate("teikyoYM"));
                //申請年月
                panel.getSearchYM().getTxtShinseiYM().setValue(
                        ymlDt.getAsRDate("shinseiYM"));
                //決定年月
                panel.getSearchYM().getTxtKetteiYM().setValue(
                        ymlDt.getAsRDate("ketteiYM"));

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
        return YamlLoader.DBC.loadAsList(new RString(ymlData));
    }

}
