/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001.JukyuIdoJohoRirekiTeseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001.dgJukyuIdoJohoRirekiTeseiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給異動情報履歴訂正一覧のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class JukyuIdoJohoRirekiTeseiList {

    private static final RString YML_RIREKI_TEISEI_LIST = new RString("dbc0200001/JukyuIdoJohoRirekiTeseiList.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyuIdoJohoRirekiTeseiListDiv> onLoad(JukyuIdoJohoRirekiTeseiListDiv panel) {
        ResponseData<JukyuIdoJohoRirekiTeseiListDiv> response = new ResponseData<>();

        setJukyuIdoJohoRirekiTeseiList(panel);

        response.data = panel;
        return response;
    }

    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBC.loadAsList(yamlName);
    }

    private void setJukyuIdoJohoRirekiTeseiList(JukyuIdoJohoRirekiTeseiListDiv panel) {
        List<HashMap> mapList = getYamlData(YML_RIREKI_TEISEI_LIST);
        List<dgJukyuIdoJohoRirekiTeseiList_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            ControlGenerator cg = new ControlGenerator(mapList.get(index));
            list.add(createJukyuIdoJohoRirekiTeseiListRow(
                    cg.getAsRString("被保番号"),
                    cg.getAsRString("被保険者氏名"),
                    cg.getAsRString("異動日"),
                    cg.getAsRString("項目")
            ));
        }
        panel.getDgJukyuIdoJohoRirekiTeseiList().setDataSource(list);
    }

    private dgJukyuIdoJohoRirekiTeseiList_Row createJukyuIdoJohoRirekiTeseiListRow(
            RString txtHihoNo,
            RString txtHihokenshaName,
            RString txtIdoYMD,
            RString txtKomoku) {
        return new dgJukyuIdoJohoRirekiTeseiList_Row(
                txtHihoNo,
                txtHihokenshaName,
                txtIdoYMD,
                txtKomoku);
    }
}
