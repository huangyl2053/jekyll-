/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShinseishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuShinseishoList.dgShokanShikyuShinseishoList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 償還支給申請決定の申請書一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiShinseishoList {

    private List<HashMap> getShokanShikyuTorokuShinseishoListYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShinseishoList.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShinseishoListDiv> onLoad(ShokanShikyuKetteiShinseishoListDiv panel) {
        setShinseishoListData(panel);
        ResponseData<ShokanShikyuKetteiShinseishoListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    /**
     * 支給申請書情報で「決定情報を保存する」ボタンを押下した時の申請書一覧パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShinseishoListDiv> onClickKetteiSave(ShokanShikyuKetteiShinseishoListDiv panel) {
        ResponseData<ShokanShikyuKetteiShinseishoListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setShinseishoListData(ShokanShikyuKetteiShinseishoListDiv panel) {
        List<HashMap> sourceList = getShokanShikyuTorokuShinseishoListYaml();
        DataGrid<dgShokanShikyuShinseishoList_Row> dgRow = panel.getShokanShikyuKetteiShinseishoListInfo().getDgShokanShikyuShinseishoList();
        List<dgShokanShikyuShinseishoList_Row> dgRowList = dgRow.getDataSource();

        for (int i = 0; i < 3; i++) {
            dgRowList.add(create申請書情報(
                    sourceList.get(i).get("サービス年月").toString(),
                    sourceList.get(i).get("申請日").toString(),
                    sourceList.get(i).get("整理番号").toString(),
                    sourceList.get(i).get("支払金額合計").toString(),
                    sourceList.get(i).get("保険請求額合計").toString(),
                    sourceList.get(i).get("自己負担額合計").toString()));
        }
        Collections.sort(dgRowList, new DateComparator());
        dgRow.setDataSource(dgRowList);
    }

    private static class DateComparator implements Comparator<dgShokanShikyuShinseishoList_Row> {

        @Override
        public int compare(dgShokanShikyuShinseishoList_Row o1, dgShokanShikyuShinseishoList_Row o2) {
            return new FlexibleDate(o2.getTxtShinseiYMD().replace(".", "")).compareTo(new FlexibleDate(o1.getTxtShinseiYMD().replace(".", "")));
        }
    }

    private dgShokanShikyuShinseishoList_Row create申請書情報(
            String txtServiceYM,
            String txtShinseiYMD,
            String txtSeiriNo,
            String txtShiharaiGokei,
            String txtHokenGokei,
            String txtJikoGokei
    ) {
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();
        dgShokanShikyuShinseishoList_Row item = new dgShokanShikyuShinseishoList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(txtServiceYM),
                new RString(txtShinseiYMD),
                new RString(txtSeiriNo),
                new RString(txtShiharaiGokei),
                new RString(txtHokenGokei),
                new RString(txtJikoGokei)
        );
        return item;
    }
}
