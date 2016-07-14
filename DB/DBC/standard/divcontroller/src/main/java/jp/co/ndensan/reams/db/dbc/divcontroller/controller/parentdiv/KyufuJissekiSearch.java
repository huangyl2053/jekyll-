/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiSearch {

    private static final RString DATE_TYPE_YM = new RString("serviceTeikyoYM");

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel KyufuJissekiSearchDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiSearchDiv> onLoad(KyufuJissekiSearchDiv panel) {
        ResponseData<KyufuJissekiSearchDiv> response = new ResponseData<>();
        initData(panel);
        response.data = panel;
        return response;
    }

    /**
     * onClick_btnKyufuJissekiSearchClearメソッドです。
     *
     * @param panel KyufuJissekiSearchDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiSearchDiv> onClick_btnKyufuJissekiSearchClear(KyufuJissekiSearchDiv panel) {
        ResponseData<KyufuJissekiSearchDiv> response = new ResponseData<>();
        initData(panel);
        response.data = panel;
        return response;
    }

    /**
     * onChange_radKyufuJissekiSearchDateTypeメソッドです。
     *
     * @param panel KyufuJissekiSearchDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiSearchDiv> onChange_radKyufuJissekiSearchDateType(KyufuJissekiSearchDiv panel) {
        ResponseData<KyufuJissekiSearchDiv> response = new ResponseData<>();
        setDateType(panel);
        response.data = panel;
        return response;
    }

    private void initData(KyufuJissekiSearchDiv panel) {
//        panel.getTxtKyufuJissekiSearchHihokenshaNo().setValue(RString.EMPTY);
        panel.getRadKyufuJissekiSearchDateType().setSelectedItem(DATE_TYPE_YM);
        panel.getDdlKyufuJissekiSearchNendo().setDisplayNone(true);
        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisplayNone(false);
//        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setFromValue(RString.EMPTY);
//        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setToValue(RString.EMPTY);

        HashMap hashMap = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJissekiSearch.yml")).get(0);

        //検索被保番号取得、設定
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtKyufuJissekiSearchHihokenshaNo().setValue(ymlData.getAsRString("HihokenshaNo"));
    }

    private void setDateType(KyufuJissekiSearchDiv panel) {
        RString item = panel.getRadKyufuJissekiSearchDateType().getSelectedItem();
        panel.getDdlKyufuJissekiSearchNendo().setDisplayNone(item.equals(DATE_TYPE_YM));
        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisplayNone(!item.equals(DATE_TYPE_YM));
    }
}
