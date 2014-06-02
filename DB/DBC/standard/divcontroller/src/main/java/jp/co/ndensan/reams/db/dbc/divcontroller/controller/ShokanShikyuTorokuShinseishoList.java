/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShinseishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuShinseishoList.dgShokanShikyuShinseishoList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 償還支給申請登録の申請書一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuTorokuShinseishoList {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShinseishoListDiv> onLoad(ShokanShikyuTorokuShinseishoListDiv panel) {
        setShinseishoListData(panel);
        ResponseData<ShokanShikyuTorokuShinseishoListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setShinseishoListData(ShokanShikyuTorokuShinseishoListDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShinseishoList.yml"));

        DataGrid<dgShokanShikyuShinseishoList_Row> dgListRow = panel.getShokanShikyuTorokuShinseishoListInfo().getDgShokanShikyuShinseishoList();
        List<dgShokanShikyuShinseishoList_Row> dgList = dgListRow.getDataSource();
        for (HashMap source : sourceList) {
            dgList.add(create申請書情報(
                    source.get("サービス年月").toString(),
                    source.get("申請日").toString(),
                    source.get("整理番号").toString(),
                    source.get("支払金額合計").toString(),
                    source.get("保険請求額合計").toString(),
                    source.get("自己負担額合計").toString()));

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
