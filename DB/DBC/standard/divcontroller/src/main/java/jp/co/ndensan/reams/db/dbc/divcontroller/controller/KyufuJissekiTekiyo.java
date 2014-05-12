/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiTekiyoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiTekiyo {

    public ResponseData<KyufuJissekiTekiyoDiv> onLoad(KyufuJissekiTekiyoDiv panel) {
        ResponseData<KyufuJissekiTekiyoDiv> response = new ResponseData<>();
        panel.getTxtTekiyo().setValue(new RString("摘要１"));
        response.data = panel;
        return response;
    }

}
