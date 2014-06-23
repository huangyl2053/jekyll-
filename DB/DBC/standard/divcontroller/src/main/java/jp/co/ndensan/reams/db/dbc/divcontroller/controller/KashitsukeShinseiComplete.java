/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiCompleteDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金申請登録 処理完了のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KashitsukeShinseiComplete {

    private static final RString YML_COMPLETE = new RString("dbc1800000/KashitsukeShinseiComplete.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiCompleteDiv> onLoad(KashitsukeShinseiCompleteDiv panel) {
        ResponseData<KashitsukeShinseiCompleteDiv> response = new ResponseData<>();

        ControlGenerator cg = new ControlGenerator(getYamlData(YML_COMPLETE).get(0));
        KaigoKanryoMessage.setMessage(panel.getKashitsukeShinseiCompleteInfo(), cg.getAsRString("メッセージ"));

        response.data = panel;
        return response;
    }

    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBC.loadAsList(yamlName);
    }
}
