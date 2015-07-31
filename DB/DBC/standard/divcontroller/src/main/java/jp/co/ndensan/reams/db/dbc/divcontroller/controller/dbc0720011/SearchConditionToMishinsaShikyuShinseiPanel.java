/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0720011;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchConditionToMishinsaShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223 朴
 */
//TODO n3317塚田　Yamlを使わないようにする
public class SearchConditionToMishinsaShikyuShinseiPanel {

    /**
     * 住宅改修費支給申請審査 審査支給申請検索条件の情報を設定する。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    //デモでは初期値を出しておかないので、requestSettingsにセットしていない。
    public ResponseData<SearchConditionToMishinsaShikyuShinseiPanelDiv> onLoad(SearchConditionToMishinsaShikyuShinseiPanelDiv panel) {
        setMSearchConditionToMishinsaShikyuShinsei(panel);

        return ResponseData.of(panel).respond();
    }

    /*
     *  住宅改修費支給申請審査 審査支給申請検索条件の情報を設定する。(YMLDATA)
     */
    private void setMSearchConditionToMishinsaShikyuShinsei(SearchConditionToMishinsaShikyuShinseiPanelDiv panel) {

//        String shikyuShinseiDateFrom = ymlData.get(0).get("shikyuShinseiDateFrom").toString();
//        String shikyuShinseiDateTo = ymlData.get(0).get("shikyuShinseiDateTo").toString();
//
//        panel.getTxtShikyuShinseiDate().setFromValue(new RDate(shikyuShinseiDateFrom));
//        panel.getTxtShikyuShinseiDate().setToValue(new RDate(shikyuShinseiDateTo));
    }
}
