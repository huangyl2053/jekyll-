/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1400011.SearchToKyufujissekiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

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
        setSearchData();

        return ResponseData.of(panel).respond();
    }

    private void setSearchData() {

//        //事業者NO
//        panel.getTxtJigyoshaNo().setValue(new RString(
//                ymlData.get(0).get("jigyoshaNo").toString()));
//        //事業者名
//        panel.getTxtJigyoshaName().setValue(new RString(
//                ymlData.get(0).get("jigyoshaName").toString()));
//
//        //被保険番号
//        panel.getTxtHihoNo().setValue(new RString(
//                ymlData.get(0).get("hihoNo").toString()));
//        //事業者名
//        panel.getTxtHihoName().setValue(new RString(
//                ymlData.get(0).get("hihoName").toString()));
//
//        //提供年月 from
//        panel.getTxtTeikyoYMRange().setFromValue(new RDate(
//                ymlData.get(0).get("teikyoYMRangefromPlaceHolder").toString()));
//        //提供年月 to
//        panel.getTxtTeikyoYMRange().setToValue(new RDate(
//                ymlData.get(0).get("teikyoYMRangetoPlaceHolder").toString()));
    }
}
