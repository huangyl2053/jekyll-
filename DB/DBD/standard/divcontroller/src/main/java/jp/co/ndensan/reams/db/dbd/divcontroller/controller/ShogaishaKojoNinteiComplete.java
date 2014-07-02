/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4030011.ShogaishaKojoNinteiCompleteDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.process.tray.TrayTaskManager;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.process.tray.TrayToTaskSingle;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.IdentificationKeyValue;

/**
 * 障害者控除対象者一括認定 処理完了のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class ShogaishaKojoNinteiComplete {

    private static final RString YML_COMPLETE = new RString("dbd4030011/Complete.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShogaishaKojoNinteiCompleteDiv> onLoad(ShogaishaKojoNinteiCompleteDiv panel) {
        ResponseData<ShogaishaKojoNinteiCompleteDiv> response = new ResponseData<>();

        ControlGenerator cg = new ControlGenerator(getYamlData(YML_COMPLETE).get(0));
        KaigoKanryoMessage.setMessage(panel.getShogaishaKojoNinteiCompleteInfo(), cg.getAsRString("メッセージ"));

//        completeTrayTask();
        response.data = panel;
        return response;
    }

    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBD.loadAsList(yamlName);
    }

    private void completeTrayTask() {
        TrayTaskManager mgr = new TrayTaskManager();
        for (TrayToTaskSingle data : mgr.getAllIdentificationValues()) {
            IdentificationKeyValue keyValue = data.getIdKeyVal();
            mgr.completeTask(keyValue);
            break;
        }
    }

}
