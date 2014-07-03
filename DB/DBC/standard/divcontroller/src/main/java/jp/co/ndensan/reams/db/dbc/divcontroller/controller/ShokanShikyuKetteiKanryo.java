/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiKanryoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還支給申請決定の介護完了メッセージのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiKanryo {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0810000/ShokanShikyuKetteiKanryo.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(ShokanShikyuKetteiKanryoDiv panel) {
        ResponseData<ShokanShikyuKetteiKanryoDiv> response = new ResponseData<>();
        setKanryoMessage(panel);
        response.data = panel;
        return response;
    }

    private void setKanryoMessage(ShokanShikyuKetteiKanryoDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));

        KaigoKanryoMessage.setMessage(panel.getShokanShikyuKetteiKanryoMessage(),
                cg.getAsRString("完了メッセージ"), cg.getAsRString("識別コード"), cg.getAsRString("氏名"));
    }

}
