/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.SearchConditionToMishinsaShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

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
        // TODO 未使用のメソッド引数があります。 Checkstyle 対応。
        panel.hashCode();

//        String shikyuShinseiDateFrom = ymlData.get(0).get("shikyuShinseiDateFrom").toString();
//        String shikyuShinseiDateTo = ymlData.get(0).get("shikyuShinseiDateTo").toString();
//
//        panel.getTxtShikyuShinseiDate().setFromValue(new RDate(shikyuShinseiDateFrom));
//        panel.getTxtShikyuShinseiDate().setToValue(new RDate(shikyuShinseiDateTo));
    }
}
