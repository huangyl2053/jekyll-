/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410000.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410000.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 国保連情報取込の国保連情報取込一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KokuhorenTorikomiList {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0410000/KokuhorenTorikomiList.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KokuhorenTorikomiListDiv> onLoad(KokuhorenTorikomiListDiv panel) {
        ResponseData<KokuhorenTorikomiListDiv> response = new ResponseData<>();

        HashMap source = getYaml().get(0);
        panel.getTxtShoriYM().setValue(new RDate(source.get("処理年月").toString()));
        setKokuhorenTorikomiList(panel);

        response.data = panel;
        return response;
    }

    private void setKokuhorenTorikomiList(KokuhorenTorikomiListDiv panel) {
        DataGrid<dgKokuhorenTorikomiList_Row> dgRow = panel.getDgKokuhorenTorikomiList();
        List<dgKokuhorenTorikomiList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getYaml();
        dgRowList.clear();
        for (int i = 1; i < 26; i++) {
            dgRowList.add(create国保連情報取込一覧アイテム(
                    sourceList.get(i).get("受取情報取り込み").toString(),
                    sourceList.get(i).get("送付情報").toString(),
                    sourceList.get(i).get("前月").toString(),
                    sourceList.get(i).get("前々月").toString(),
                    sourceList.get(i).get("当月状態").toString(),
                    sourceList.get(i).get("当月処理日時").toString()));
        }
        dgRow.setDataSource(dgRowList);
    }

    private dgKokuhorenTorikomiList_Row create国保連情報取込一覧アイテム(
            String txtUketoriTorikomi,
            String txtSofuJoho,
            String txtZenZengetsu,
            String txtZengetsu,
            String txtTogetsuJotai,
            String txtShoriNichiji
    ) {
        Button btnSelect = new Button();
        return new dgKokuhorenTorikomiList_Row(
                btnSelect,
                new RString(txtUketoriTorikomi),
                new RString(txtSofuJoho),
                new RString(txtZenZengetsu),
                new RString(txtZengetsu),
                new RString(txtTogetsuJotai),
                new RString(txtShoriNichiji));
    }
}
