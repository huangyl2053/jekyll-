/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiSearchDiv;
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
        panel.getTxtKyufuJissekiSearchHihokenshaNo().setValue(RString.EMPTY);
        panel.getRadKyufuJissekiSearchDateType().setSelectedItem(DATE_TYPE_NENDO);
        panel.getDdlKyufuJissekiSearchNendo().setDisplayNone(false);
        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisplayNone(true);
//        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setFromValue(RString.EMPTY);
//        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setToValue(RString.EMPTY);
    }

    private void setDateType(KyufuJissekiSearchDiv panel) {
        RString item = panel.getRadKyufuJissekiSearchDateType().getSelectedItem();
        panel.getDdlKyufuJissekiSearchNendo().setDisplayNone(!item.equals(DATE_TYPE_NENDO));
        panel.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisplayNone(item.equals(DATE_TYPE_NENDO));
    }
}
