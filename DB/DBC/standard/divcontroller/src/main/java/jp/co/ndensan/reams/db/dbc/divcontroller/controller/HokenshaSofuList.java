/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200000.HokenshaSofuListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200000.dgHokenshaSofuList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 保険者情報送付の保険者情報送付一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class HokenshaSofuList {

    private List<HashMap> getHokenshaSofuListYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0200000/HokenshaSofuList.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<HokenshaSofuListDiv> onLoad(HokenshaSofuListDiv panel) {
        ResponseData<HokenshaSofuListDiv> response = new ResponseData<>();

        HashMap source = getHokenshaSofuListYaml().get(0);
        panel.getTxtShoriYM().setValue(new RDate(source.get("処理年月").toString()));
        setHokenshaSofuList(panel);

        response.data = panel;
        return response;
    }

    private void setHokenshaSofuList(HokenshaSofuListDiv panel) {
        DataGrid<dgHokenshaSofuList_Row> dgRow = panel.getDgHokenshaSofuList();
        List<dgHokenshaSofuList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getHokenshaSofuListYaml();
        dgRowList.clear();
        for (int i = 1; i < 4; i++) {
            dgRowList.add(create保険者情報送付一覧アイテム(
                    sourceList.get(i).get("送付情報").toString(),
                    sourceList.get(i).get("前月").toString(),
                    sourceList.get(i).get("前々月").toString(),
                    sourceList.get(i).get("当月状態").toString(),
                    sourceList.get(i).get("当月処理日時").toString()));
        }
        dgRow.setDataSource(dgRowList);
    }

    private dgHokenshaSofuList_Row create保険者情報送付一覧アイテム(
            String txtSofuJoho,
            String txtZenZengetsu,
            String txtZengetsu,
            String txtTogetsuJotai,
            String txtShoriNichiji
    ) {
        Button btnSelect = new Button();
        return new dgHokenshaSofuList_Row(
                btnSelect,
                new RString(txtSofuJoho),
                new RString(txtZenZengetsu),
                new RString(txtZengetsu),
                new RString(txtTogetsuJotai),
                new RString(txtShoriNichiji));
    }
}
