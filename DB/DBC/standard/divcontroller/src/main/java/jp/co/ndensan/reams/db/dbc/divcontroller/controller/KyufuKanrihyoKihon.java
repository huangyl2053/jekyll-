/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票情報照会の介護宛名情報のコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuKanrihyoKihon {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyoKihon.yml"));
    }

    /**
     * 画面ロード時の処理。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyufuKanrihyoKihonDiv panel) {
        ResponseData<KyufuKanrihyoKihonDiv> response = new ResponseData<>();
        setData(panel);

        response.data = panel;
        return response;
    }

    private void setData(KyufuKanrihyoKihonDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        AtenaShokaiSimple.setData(panel.getKyufuKanrihyoKaigoAtena().getAtenaInfo(), new ShikibetsuCode(cg.getAsRString("識別コード")));
    }
}
