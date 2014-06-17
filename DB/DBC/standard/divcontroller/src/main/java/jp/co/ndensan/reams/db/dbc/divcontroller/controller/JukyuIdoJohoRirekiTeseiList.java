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
            HashMap map = mapList.get(index);
            list.add(createJukyuIdoJohoRirekiTeseiListRow(
                    map.get("被保番号").toString(),
                    map.get("被保険者氏名").toString(),
                    map.get("異動日").toString(),
                    map.get("項目").toString()
            ));
        }
        panel.getDgJukyuIdoJohoRirekiTeseiList().setDataSource(list);
    }

    private dgJukyuIdoJohoRirekiTeseiList_Row createJukyuIdoJohoRirekiTeseiListRow(
            String txtHihoNo,
            String txtHihokenshaName,
            String txtIdoYMD,
            String txtKomoku) {
        return new dgJukyuIdoJohoRirekiTeseiList_Row(
                new RString(txtHihoNo),
                new RString(txtHihokenshaName),
                new RString(txtIdoYMD),
                new RString(txtKomoku));
    }
}
