/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiSearch {

    private final RString DATE_TYPE_NENDO = new RString("nendo");

    public ResponseData<KyufuJissekiSearchDiv> onLoad(KyufuJissekiSearchDiv panel) {
        ResponseData<KyufuJissekiSearchDiv> response = new ResponseData<>();
        initData(panel);
        response.data = panel;
        return response;
    }

    public ResponseData<KyufuJissekiSearchDiv> onClick_btnKyufuJissekiSearchClear(KyufuJissekiSearchDiv panel) {
        ResponseData<KyufuJissekiSearchDiv> response = new ResponseData<>();
        initData(panel);
        response.data = panel;
        return response;
    }

    public ResponseData<KyufuJissekiSearchDiv> onChange_radKyufuJissekiSearchDateType(KyufuJissekiSearchDiv panel) {
        ResponseData<KyufuJissekiSearchDiv> response = new ResponseData<>();
        setDateType(panel);
        response.data = panel;
        return response;
    }

    private void initData(KyufuJissekiSearchDiv panel) {
//        panel.getTxtKyufuJissekiSearchHihokenshaNo().setValue(RString.EMPTY);
        panel.getRadKyufuJissekiSearchDateType().setSelectedItem(DATE_TYPE_NENDO);
        panel.getDdlKyufuJissekiSearchNendo().setDisplayNone(false);
        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisplayNone(true);
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
        panel.getDdlKyufuJissekiSearchNendo().setDisplayNone(!item.equals(DATE_TYPE_NENDO));
        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisplayNone(item.equals(DATE_TYPE_NENDO));
    }
}
