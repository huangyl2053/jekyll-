/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchToKyufujissekiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223
 */
public class SearchToKyufujissekiPanel {

    /**
     * 介護給付費過誤申立書登録 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(SearchToKyufujissekiPanelDiv panel) {
        ResponseData<SearchToKyufujissekiPanelDiv> response = new ResponseData<>();
        setSearchData(panel);

        response.data = panel;
        return response;
    }

    private void setSearchData(SearchToKyufujissekiPanelDiv panel) {

        List<HashMap> ymlData = ymlData();

        //事業者NO
        panel.getTxtJigyoshaNo().setValue(new RString(
                ymlData.get(0).get("jigyoshaNo").toString()));
        //事業者名
        panel.getTxtJigyoshaName().setValue(new RString(
                ymlData.get(0).get("jigyoshaName").toString()));

        //被保険番号
        panel.getTxtHihoNo().setValue(new RString(
                ymlData.get(0).get("hihoNo").toString()));
        //事業者名
        panel.getTxtHihoName().setValue(new RString(
                ymlData.get(0).get("hihoName").toString()));

        //提供年月 from
        panel.getTxtTeikyoYMRange().setFromValue(new RDate(
                ymlData.get(0).get("teikyoYMRangefromPlaceHolder").toString()));
        //提供年月 to
        panel.getTxtTeikyoYMRange().setToValue(new RDate(
                ymlData.get(0).get("teikyoYMRangetoPlaceHolder").toString()));
    }

    private List<HashMap> ymlData() {
        return YamlLoader.DBC.loadAsList(new RString("dbc1400011/KagoMoshitateSearchToKyufujisseki.yml"));
    }
}
