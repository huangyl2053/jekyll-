/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000.KyotakuJikoTodokedeKanryoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス自己作成届出情報登録の介護完了メッセージのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoTodokedeKanryo {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0110000/KyotakuJikoTodokedeKanryo.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoTodokedeKanryoDiv panel) {
        ResponseData<KyotakuJikoTodokedeKanryoDiv> response = new ResponseData<>();
        setKanryoMessage(panel);
        response.data = panel;
        return response;
    }

    private void setKanryoMessage(KyotakuJikoTodokedeKanryoDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));

        KaigoKanryoMessage.setMessage(panel.getKyotakuJikoTodokedeKanryoMessage(), cg.getAsRString("完了メッセージ"));
    }
}
