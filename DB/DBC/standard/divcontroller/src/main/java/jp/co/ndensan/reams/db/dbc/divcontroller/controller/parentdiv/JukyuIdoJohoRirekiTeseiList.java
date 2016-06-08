/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200001.JukyuIdoJohoRirekiTeseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200001.dgJukyuIdoJohoRirekiTeseiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 受給異動情報履歴訂正一覧のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class JukyuIdoJohoRirekiTeseiList {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyuIdoJohoRirekiTeseiListDiv> onLoad(JukyuIdoJohoRirekiTeseiListDiv panel) {
        setJukyuIdoJohoRirekiTeseiList(panel);

        return ResponseData.of(panel).respond();
    }

    private void setJukyuIdoJohoRirekiTeseiList(JukyuIdoJohoRirekiTeseiListDiv panel) {
        if (panel.getDgJukyuIdoJohoRirekiTeseiList().getDataSource().isEmpty()) {
            loadRirekiTeseiList(panel);
        } else {
            modifyRirekiTeseiList(panel);
        }
    }

    private void loadRirekiTeseiList(JukyuIdoJohoRirekiTeseiListDiv panel) {
        List<dgJukyuIdoJohoRirekiTeseiList_Row> list = panel.getDgJukyuIdoJohoRirekiTeseiList().getDataSource();
        list.add(createJukyuIdoJohoRirekiTeseiListRow());
    }

    private void modifyRirekiTeseiList(JukyuIdoJohoRirekiTeseiListDiv panel) {
        int clickedRowId = panel.getDgJukyuIdoJohoRirekiTeseiList().getClickedRowId();
        if (clickedRowId > -1) {
            panel.getDgJukyuIdoJohoRirekiTeseiList().getDataSource().get(clickedRowId).setRowState(RowState.Modified);
//            completeTrayTask();
        }
    }

//    private void completeTrayTask() {
//        for (TrayToTask data : TrayTaskManager.getIdentificationValues()) {
//            IdentificationKeyValues keyValues = data.getIdKeyVal();
//            TrayTaskManager.grabTask(keyValues);
//            TrayTaskManager.completeTask(keyValues);
//            break;
//        }
//    }
    private dgJukyuIdoJohoRirekiTeseiList_Row createJukyuIdoJohoRirekiTeseiListRow() {
        //TODO n3317塚田　遷移するために空のリストを作成
        return new dgJukyuIdoJohoRirekiTeseiList_Row();
    }
}
