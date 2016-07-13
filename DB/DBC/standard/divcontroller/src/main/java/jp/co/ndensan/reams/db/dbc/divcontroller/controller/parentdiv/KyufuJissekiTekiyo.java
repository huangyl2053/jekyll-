/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiTekiyoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiTekiyo {

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel KyufuJissekiTekiyoDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiTekiyoDiv> onLoad(KyufuJissekiTekiyoDiv panel) {
        ResponseData<KyufuJissekiTekiyoDiv> response = new ResponseData<>();

        //摘要情報取得、設定
        HashMap hashMap = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJissekiTekiyo.yml")).get(0);

        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtTekiyo().setValue(ymlData.getAsRString("Tekiyo"));
        response.data = panel;
        return response;
    }

}
