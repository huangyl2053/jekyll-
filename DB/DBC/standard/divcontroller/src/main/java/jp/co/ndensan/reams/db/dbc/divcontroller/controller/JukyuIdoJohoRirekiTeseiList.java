/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001.JukyuIdoJohoRirekiTeseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200001.dgJukyuIdoJohoRirekiTeseiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.process.tray.TrayTaskManager;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.process.tray.TrayToTask;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.IdentificationKeyValue;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.IdentificationKeyValues;

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
//        List<dgJukyuIdoJohoRirekiTeseiList_Row> list = panel.getDgJukyuIdoJohoRirekiTeseiList().getDataSource();
//        List<HashMap> mapList = getYamlData(YML_RIREKI_TEISEI_LIST);
//        for (int index = 0; index < mapList.size(); index++) {
//            ControlGenerator cg = new ControlGenerator(mapList.get(index));
//            list.add(createJukyuIdoJohoRirekiTeseiListRow(
//                    cg.getAsRString("被保番号"),
//                    cg.getAsRString("被保険者氏名"),
//                    cg.getAsRString("異動日"),
//                    cg.getAsRString("項目")));
//        }
    }

    private void modifyRirekiTeseiList(JukyuIdoJohoRirekiTeseiListDiv panel) {
        int clickedRowId = panel.getDgJukyuIdoJohoRirekiTeseiList().getClickedRowId();
        if (clickedRowId > -1) {
            panel.getDgJukyuIdoJohoRirekiTeseiList().getDataSource().get(clickedRowId).setRowState(RowState.Modified);
//            completeTrayTask();
        }
    }

    private void completeTrayTask() {
        for (TrayToTask data : TrayTaskManager.getIdentificationValues()) {
            IdentificationKeyValues keyValues = data.getIdKeyVal();
            TrayTaskManager.grabTask(keyValues);
            TrayTaskManager.completeTask(keyValues);
            break;
        }
    }

    private dgJukyuIdoJohoRirekiTeseiList_Row createJukyuIdoJohoRirekiTeseiListRow(
            RString txtHihoNo,
            RString txtHihokenshaName,
            RString txtIdoYMD,
            RString txtKomoku) {
        return new dgJukyuIdoJohoRirekiTeseiList_Row(
                txtHihoNo,
                txtHihokenshaName,
                txtIdoYMD,
                txtKomoku);
    }
}
