/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuHihokenshaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費事前申請登録 被保険者検索条件パネルです。
 *
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
        RString searchShimei = (RString) ymlData.get(0).get("searchShimei");
        RString searchDateOfBirth = (RString) ymlData.get(0).get("searchDateOfBirth");
        RString searchShichosonCode = (RString) ymlData.get(0).get("searchShichosonCode");
        RString searchShikibetsuCode = (RString) ymlData.get(0).get("searchShikibetsuCode");
        RString searchSetaiCode = (RString) ymlData.get(0).get("searchSetaiCode");
        RString searchHihokenshaNo = (RString) ymlData.get(0).get("searchHihokenshaNo");
       /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShimei().setValue(searchShimei);
        panel.getReamsCommonSearchInfoPanel().getTxtSearchDateOfBirth().setValue(searchDateOfBirth);
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShichosonCode().setValue(searchShichosonCode);
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShikibetsuCode().setValue(searchShikibetsuCode);
        panel.getReamsCommonSearchInfoPanel().getTxtSearchSetaiCode().setValue(searchSetaiCode);
        panel.getDBCommonSearchInfoPanel().getTxtSearchHihokenshaNo().setValue(searchHihokenshaNo);

        response.data = panel;
        return response;
    }

}
