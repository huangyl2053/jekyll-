/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiShikyuKetteishaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223
 */    
public class JutakuKaishuhiShikyuKetteishaListPanel {
    
        /**
     * 住宅改修費支給申請決定 償還払支給（不支給）決定者一覧表の初期値をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
        public ResponseData<JutakuKaishuhiShikyuKetteishaListPanelDiv> onLoad(JutakuKaishuhiShikyuKetteishaListPanelDiv panel) {
        ResponseData<JutakuKaishuhiShikyuKetteishaListPanelDiv> response = new ResponseData<>();

        //出力順序・改頁の初期値を設定する。
        setHakkoDateOutputOrderForKetteishaList(panel);

        response.data = panel;
        return response;

    }

    private void setHakkoDateOutputOrderForKetteishaList(JutakuKaishuhiShikyuKetteishaListPanelDiv panel) {
        
        String ymlDataName = "ShinsazumiShikyuShinseiJutakuKaishuhiShikyuKetteishaList.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

           //　発行日の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteishaListHakkoDate().getTxtIssueDate().setValue(new RDate(
                ymlData.get(0).get("issueDate").toString()
        ));

        //　出力順序・改頁の情の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder()
                .getTxtNewPageItem().setValue(new RString(
                                ymlData.get(0).get("newPageItem").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder()
                .getTxt1().setValue(new RString(
                                ymlData.get(0).get("txt1").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder()
                .getTxt2().setValue(new RString(
                                ymlData.get(0).get("txt2").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder()
                .getTxt3().setValue(new RString(
                                ymlData.get(0).get("txt3").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder()
                .getTxt4().setValue(new RString(
                                ymlData.get(0).get("txt4").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder()
                .getTxt5().setValue(new RString(
                                ymlData.get(0).get("txt5").toString()
                        ));

    }
    
    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }
}
