/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000.KyotakuJikoRiyohyoKanryoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス自己作成サービス利用票登録の介護完了メッセージのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoRiyohyoKanryo {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0120000/KyotakuJikoRiyohyoKanryo.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoKanryoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoKanryoDiv> response = new ResponseData<>();
        setKanryoMessage(panel);
        response.data = panel;
        return response;
    }

    private void setKanryoMessage(KyotakuJikoRiyohyoKanryoDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));

        KaigoKanryoMessage.setMessage(panel.getKyotakuJikoRiyohyoKanryoMessage(),
                cg.getAsRString("完了メッセージ"), cg.getAsRString("識別コード"), cg.getAsRString("氏名"));
    }
}
