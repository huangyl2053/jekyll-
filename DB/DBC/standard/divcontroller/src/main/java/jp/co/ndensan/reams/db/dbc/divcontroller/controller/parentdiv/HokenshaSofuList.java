/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200000.HokenshaSofuListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200000.dgHokenshaSofuList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 保険者情報送付の保険者情報送付一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
//TODO n3317塚田　Yamlを使わないようにする
public class HokenshaSofuList {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<HokenshaSofuListDiv> onLoad(HokenshaSofuListDiv panel) {

//        ControlGenerator cg = new ControlGenerator(getHokenshaSofuListYaml().get(0));
//        panel.getTxtShoriYM().setValue(cg.getAsRDate("処理年月"));
        setHokenshaSofuList(panel);

        return ResponseData.of(panel).respond();
    }

    private void setHokenshaSofuList(HokenshaSofuListDiv panel) {
        DataGrid<dgHokenshaSofuList_Row> dgRow = panel.getDgHokenshaSofuList();
        List<dgHokenshaSofuList_Row> dgRowList = dgRow.getDataSource();
        //TODO n3317塚田　遷移させるために空の行を表示
        dgRowList.add(new dgHokenshaSofuList_Row());

//        List<HashMap> sourceList = getHokenshaSofuListYaml();
//        dgRowList.clear();
//        for (int i = 1; i < sourceList.size(); i++) {
//            ControlGenerator cg = new ControlGenerator(sourceList.get(i));
//            dgRowList.add(create保険者情報送付一覧アイテム(
//                    cg.getAsRString("送付情報"),
//                    cg.getAsRString("前月"),
//                    cg.getAsRString("前々月"),
//                    cg.getAsRString("当月状態"),
//                    cg.getAsRString("当月処理日時")));
//        }
//        dgRow.setDataSource(dgRowList);
    }

    private dgHokenshaSofuList_Row create保険者情報送付一覧アイテム(
            RString txtSofuJoho,
            RString txtZenZengetsu,
            RString txtZengetsu,
            RString txtTogetsuJotai,
            RString txtShoriNichiji
    ) {
        Button btnSelect = new Button();
        return new dgHokenshaSofuList_Row(
                btnSelect,
                txtSofuJoho,
                txtZenZengetsu,
                txtZengetsu,
                txtTogetsuJotai,
                txtShoriNichiji);
    }
}
