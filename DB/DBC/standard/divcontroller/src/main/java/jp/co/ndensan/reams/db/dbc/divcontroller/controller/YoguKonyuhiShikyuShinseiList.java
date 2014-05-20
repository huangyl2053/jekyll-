/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShikyuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 福祉用具購入費支給申請 支給申請一覧のパネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiList {

    public ResponseData<YoguKonyuhiShikyuShinseiListDiv> onClick_btnAddShinsei(YoguKonyuhiShikyuShinseiListDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiListDiv> response = new ResponseData<>();

        setiShikyuShinseiData(panel);
        panel.getBtnSave().setDisabled(false);
  
        response.data = panel;
        return response;

    }

    /**
     * 福祉用具購入費支給申請 支給申請一覧の情報を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    private void setiShikyuShinseiData(YoguKonyuhiShikyuShinseiListDiv panel) {

        List<dgShikyuShinseiList_Row> arraydata = createRowShikyuShinseiTestData();
        DataGrid<dgShikyuShinseiList_Row> grid = panel.getDgShikyuShinseiList();
        grid.setDataSource(arraydata);

    }

    /*
     支給申請一覧の期値をセットします。
     */
    private List<dgShikyuShinseiList_Row> createRowShikyuShinseiTestData() {

        List<dgShikyuShinseiList_Row> arrayData = new ArrayList<>();

        dgShikyuShinseiList_Row item;
        item = createRowShikyuShinseiListData(
                "追加",
                "201406",
                "20140701",
                "",
                "",
                "",
                "",
                "",
                "",
                "0000000001"
        );

        arrayData.add(item);
        return arrayData;

    }

    /*
     引数を元にデータグリッド内に挿入する支給申請データを作成します。
     */
    private dgShikyuShinseiList_Row createRowShikyuShinseiListData(
            String 状態,
            String 提供年月,
            String 申請日,
            String 判定区分,
            String 判定決定日,
            String 審査結果,
            String 審査日,
            String 支給区分,
            String 決定日,
            String 整理番号
    ) {

        dgShikyuShinseiList_Row rowShikyuShinseiListData = new dgShikyuShinseiList_Row(
                new Button(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowShikyuShinseiListData.setTxtState(new RString(状態));
        rowShikyuShinseiListData.setTxtTeikyoYM(new RString(提供年月));
        rowShikyuShinseiListData.setTxtShinseiYMD(new RString(申請日));
        rowShikyuShinseiListData.setTxtSerialNo(new RString(整理番号));

        return rowShikyuShinseiListData;
    }

}
