/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0220011.OutputJukyushaTeiseiRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動連絡票変更登録 受給者訂正連絡票のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class OutputJukyushaTeiseiRenrakuhyo {

    private static final RString YML_NAME = new RString("dbc0220011/OutputJukyushaTeiseiRenrakuhyo.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<OutputJukyushaTeiseiRenrakuhyoDiv> onLoad(OutputJukyushaTeiseiRenrakuhyoDiv panel) {
        ResponseData<OutputJukyushaTeiseiRenrakuhyoDiv> response = new ResponseData<>();

        setOutputJukyushaTeiseiRenrakuhyo(panel);

        response.data = panel;
        return response;
    }

    private void setOutputJukyushaTeiseiRenrakuhyo(OutputJukyushaTeiseiRenrakuhyoDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYmlData().get(0));
        panel.getOutputJukyushaTeiseiRenrakuhyoPrintSetting().getTxtIssueDate().setValue(cg.getAsRDate("発行日"));
    }

    private List<HashMap> getYmlData() {
        return YamlLoader.DBC.loadAsList(YML_NAME);
    }
}
