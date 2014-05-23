/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuHihokenshaSearchPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

/**
 * 住宅改修費事前申請登録 被保険者検索条件パネルです。
 * @author n8223
 */
public class JutakuHihokenshaSearchPanel {
        /**
     * 住宅改修費事前申請登録 被保険者検索条件情報の初期値をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuHihokenshaSearchPanelDiv> onLoad(JutakuHihokenshaSearchPanelDiv panel) {
        ResponseData<JutakuHihokenshaSearchPanelDiv> response = new ResponseData<>();

       /////////////////////////////////////////////////////////////////////////////////////////
       //TO DO  JutakuData.xml ①
       List<HashMap> ymlData = YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData.yml"));
       
       //TO DO  JutakuData.xml Read　②
       String searchShimei = ymlData.get(0).get("searchShimei").toString();
       String searchDateOfBirth = ymlData.get(0).get("searchDateOfBirth").toString();
       String searchShichosonCode =   ymlData.get(0).get("searchShichosonCode").toString();
       String searchShikibetsuCode =  ymlData.get(0).get("searchShikibetsuCode").toString();
       String searchSetaiCode =  ymlData.get(0).get("searchSetaiCode").toString();
       String searchHihokenshaNo =   ymlData.get(0).get("searchHihokenshaNo").toString();
       /////////////////////////////////////////////////////////////////////////////////////////
       
       //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShimei().setValue(new RString(searchShimei));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchDateOfBirth().setValue(new RString(searchDateOfBirth));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShichosonCode().setValue(new RString(searchShichosonCode));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShikibetsuCode().setValue(new RString(searchShikibetsuCode));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchSetaiCode().setValue(new RString(searchSetaiCode));
        panel.getDBCommonSearchInfoPanel().getTxtSearchHihokenshaNo().setValue(new RString(searchHihokenshaNo));

        response.data = panel;
        return response;
    }

    
}
