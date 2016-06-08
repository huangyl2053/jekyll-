/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

        DataGrid<dgKoufuKaishu_Row> grid = kanriDiv.getPanelKoufuList().getDgKoufuKaishu();
        setShosaiDiv(kanriDiv, grid.getClickedItem());

        response.data = kanriDiv;
        return response;
    }

    private void setShosaiDiv(ShoKaishuKirokuKanriDiv kanriDiv, dgKoufuKaishu_Row row) {
        kanriDiv.getTxtKoufuType().setValue(row.getKoufuType());
        kanriDiv.getTxtKoufuDate().setValue(new RDate(row.getKoufuDate().toString()));
        kanriDiv.getDdlKoufuJiyu().setSelectedValue(row.getKoufuJiyu());
        kanriDiv.getTxtKaisyuDate().setValue(new RDate(row.getKaishuDate().toString()));
        kanriDiv.getDdlKaisyuJiyu().setSelectedValue(row.getKaishuJiyu());
        kanriDiv.getTxtYukouKigen().setValue(new RDate(row.getYukoKigen().toString()));

    }

    /**
     * 確定ボタンを押した際に実行され、入力した内容をグリッドに反映します。
     *
     * @param kanriDiv 証回収状況管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateShoKaishuJokyo(ShoKaishuKirokuKanriDiv kanriDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();

        DataGrid<dgKoufuKaishu_Row> grid = kanriDiv.getPanelKoufuList().getDgKoufuKaishu();
        //TODO n8178 入力を確定して、明細情報をグリッドに反映する際、選択していた行を見つける実装法が決定した後に修正が必要。　2014年12月
        int index = grid.getClickedRowId();
        setUpdateRow(grid.getDataSource().get(index), kanriDiv);

        response.data = kanriDiv;
        return response;
    }

    private void setUpdateRow(dgKoufuKaishu_Row row, ShoKaishuKirokuKanriDiv shosaiDiv) {

        row.setRowState(RowState.Modified);
        row.setKoufuType(shosaiDiv.getTxtKoufuType().getValue());
        row.setKoufuDate(shosaiDiv.getTxtKoufuDate().getValue().toDateString());
        row.setKoufuJiyu(shosaiDiv.getDdlKoufuJiyu().getSelectedValue());
        row.setKaishuDate(shosaiDiv.getTxtKoufuDate().getValue().toDateString());
        row.setKaishuJiyu(shosaiDiv.getDdlKaisyuJiyu().getSelectedValue());
        row.setYukoKigen(shosaiDiv.getTxtYukouKigen().getValue().toDateString());
    }

}
