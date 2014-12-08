/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyoshosai.IShoKaishuJokyoShosaiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 証回収記録の修正を行うことができる共有子Divのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuKirokuKanri {

    /**
     * グリッドから対象を選び、その詳細を表示します。
     *
     * @param kanriDiv 証回収記録管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSelect(ShoKaishuKirokuKanriDiv kanriDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();

        DataGrid<dgShoKaishuJokyo_Row> grid = kanriDiv.getCcdShoKaishuJokyoList().getDgShoKaishuJokyo();
        setShosaiDiv(kanriDiv.getCcdShoKaishuJokyoShosai(), grid.getClickedItem());

        response.data = kanriDiv;
        return response;
    }

    private void setShosaiDiv(IShoKaishuJokyoShosaiDiv shosaiDiv, dgShoKaishuJokyo_Row row) {
        shosaiDiv.getTxtShoKofuShurui().setValue(row.getKofushoShurui());
        shosaiDiv.getTxtKofuDate().setValue(row.getKofuDate().getValue());
        shosaiDiv.getTxtYukoKigen().setValue(row.getYukoKigen().getValue());
        shosaiDiv.getTxtKofuJiyu().setValue(row.getKofuJiyu());
        shosaiDiv.getTxtKofuRiyu().setValue(row.getKofuRiyu());
        shosaiDiv.getTxtKaishuDate().setValue(row.getKaishuDate().getValue());
        shosaiDiv.getDdlKaishuJiyu().setSelectedItem(row.getKaishuJiyuKey());
        shosaiDiv.getTxtKaishuRiyu().setValue(row.getKaishuRiyu());
    }

    /**
     * 確定ボタンを押した際に実行され、入力した内容をグリッドに反映します。
     *
     * @param kanriDiv 証回収状況管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateShoKaishuJokyo(ShoKaishuKirokuKanriDiv kanriDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();

        DataGrid<dgShoKaishuJokyo_Row> grid = kanriDiv.getCcdShoKaishuJokyoList().getDgShoKaishuJokyo();
        //TODO n8178 入力を確定して、明細情報をグリッドに反映する際、選択していた行を見つける実装法が決定した後に修正が必要。　2014年12月
        int index = grid.getClickedRowId();
        setUpdateRow(grid.getDataSource().get(index), kanriDiv.getCcdShoKaishuJokyoShosai());

        response.data = kanriDiv;
        return response;
    }

    private void setUpdateRow(dgShoKaishuJokyo_Row row, IShoKaishuJokyoShosaiDiv shosaiDiv) {

        row.setRowState(RowState.Modified);
        row.setKofushoShurui(shosaiDiv.getTxtShoKofuShurui().getValue());
        row.getKofuDate().setValue(shosaiDiv.getTxtKofuDate().getValue());
        row.getYukoKigen().setValue(shosaiDiv.getTxtYukoKigen().getValue());
        row.setKofuJiyu(shosaiDiv.getTxtKofuJiyu().getValue());
        row.setKofuRiyu(shosaiDiv.getTxtKofuRiyu().getValue());
        row.getKaishuDate().setValue(shosaiDiv.getTxtKaishuDate().getValue());
        row.setKaishuJiyuKey(shosaiDiv.getDdlKaishuJiyu().getSelectedItem());
        row.setKaishuJiyu(shosaiDiv.getDdlKaishuJiyu().getSelectedValue());
        row.setKaishuRiyu(shosaiDiv.getTxtKaishuRiyu().getValue());
    }

}
