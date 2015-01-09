/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還支給申請決定の基本情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiKihon {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeDetail.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(ShokanShikyuKetteiKihonDiv panel) {
        ResponseData<ShokanShikyuKetteiKihonDiv> response = new ResponseData<>();
        setKihonData(panel);
        response.data = panel;
        return response;
    }

    private void setKihonData(ShokanShikyuKetteiKihonDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        ShikibetsuCode 識別コード = new ShikibetsuCode(cg.getAsRString("識別コード"));
        int rowId = 0;

        KaigoShikakuKihon.setData(panel.getShokanShikyuKetteiKihonAtena(), panel.getShokanShikyuKetteiKaigoKihon(), 識別コード, rowId);
    }

}
