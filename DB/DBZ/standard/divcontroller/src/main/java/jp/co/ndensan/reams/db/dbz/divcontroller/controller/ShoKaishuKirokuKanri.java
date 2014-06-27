/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuJokyoShosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.dgShoKaishuJokyo_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 証回収記録の修正を行うことができる共有子Divのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuKirokuKanri {

    /**
     * 入力モードに合わせて、コントロールの表示非表示を切り替えます。
     *
     * @param kanriDiv 証回収記録管理Div
     * @param mode モード
     */
    public static void setMode(ShoKaishuKirokuKanriDiv kanriDiv, ModeType mode) {

        kanriDiv.setMode(mode.toValue());
        if (ModeType.SHOKAI_MODE.toValue().equals(kanriDiv.getMode())) {
            kanriDiv.getBtnUpdateShoKaishuJokyo().setDisplayNone(true);
            kanriDiv.getShoKaishuJokyoShosai().setDisplayNone(true);
            kanriDiv.getShoKaishuJokyoList().getDgShoKaishuJokyo().getGridSetting().getColumn("btnSelect").setVisible(false);
        } else {

        }
    }

    /**
     * グリッドから対象を選び、その詳細を表示します。
     *
     * @param kanriDiv 証回収記録管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSelect(ShoKaishuKirokuKanriDiv kanriDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();

        DataGrid<dgShoKaishuJokyo_Row> grid = kanriDiv.getShoKaishuJokyoList().getDgShoKaishuJokyo();
        kanriDiv.setSelectRow(new RString(Integer.toString(grid.getClickedRowId())));
        setShosaiDiv(kanriDiv.getShoKaishuJokyoShosai(), grid.getClickedItem());

        response.data = kanriDiv;
        return response;
    }

    private void setShosaiDiv(ShoKaishuJokyoShosaiDiv shosaiDiv, dgShoKaishuJokyo_Row row) {
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

        int selectRowNum = Integer.parseInt(kanriDiv.getSelectRow().toString());
        DataGrid<dgShoKaishuJokyo_Row> grid = kanriDiv.getShoKaishuJokyoList().getDgShoKaishuJokyo();
        setUpdateRow(grid.getDataSource().get(selectRowNum), kanriDiv.getShoKaishuJokyoShosai());

        response.data = kanriDiv;
        return response;
    }

    private void setUpdateRow(dgShoKaishuJokyo_Row row, ShoKaishuJokyoShosaiDiv shosaiDiv) {

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
