/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8060001.NinteiShinseiGyomuShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報照会の対象データ出力指示画面の処理を表します。
 *
 * @author N1013 松本直樹
 */
public class NinteiShinseiGyomuShokai {

    /**
     * 認定申請情報照会Divをロードした時の処理を表します。
     *
     * @param div 認定申請情報照会Div
     * @return ResponseData
     */
    public ResponseData onLoadData(NinteiShinseiGyomuShokaiDiv div) {
        ResponseData<NinteiShinseiGyomuShokaiDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("DemoCity.yml"));
        Map map = targetSource.get(0);
        ControlGenerator ymlData = new ControlGenerator(map);
        div.getTxtHokensha().setValue(ymlData.getAsRString("保険者番号"));
        div.getTxtHokenshaMeisho().setValue(ymlData.getAsRString("保険者名称"));

        div.getTxtKyakkabiRange().setDisabled(true);
        div.getTxtShinseibiRange().setDisabled(true);
        div.getTxtKoshinbiRange().setDisabled(true);

        response.data = div;
        return response;
    }

    /**
     * 認定申請モニタリストチェックボックスの処理を表します。
     *
     * @param div 認定申請情報照会Div
     * @return ResponseData
     */
    public ResponseData onClick_chkNinteiShinseiMonitor(NinteiShinseiGyomuShokaiDiv div) {
        ResponseData<NinteiShinseiGyomuShokaiDiv> response = new ResponseData<>();

        if (div.getChkNinteiShinseiMonitor().getSelectedItems().get(0).getKey().equalsIgnoreCase("1")) {
            div.getTxtKoshinbiRange().setDisabled(false);
        } else {
            div.getTxtKoshinbiRange().setDisabled(true);
        }

        response.data = div;
        return response;
    }

    public ResponseData onClick_chkShinseishaIchiran(NinteiShinseiGyomuShokaiDiv div) {
        ResponseData<NinteiShinseiGyomuShokaiDiv> response = new ResponseData<>();

        if (div.getChkShinseishaIchiran().getSelectedItems().get(0).getKey().equalsIgnoreCase("1")) {
            div.getTxtShinseibiRange().setDisabled(false);
        } else {
            div.getTxtShinseibiRange().setDisabled(true);
        }

        response.data = div;
        return response;
    }

    public ResponseData onClick_chkShinseiKyakka(NinteiShinseiGyomuShokaiDiv div) {
        ResponseData<NinteiShinseiGyomuShokaiDiv> response = new ResponseData<>();

        if (div.getChkShinseiKyakka().getSelectedItems().get(0).getKey().equalsIgnoreCase("1")) {
            div.getTxtKyakkabiRange().setDisabled(false);
        } else {
            div.getTxtKyakkabiRange().setDisabled(true);
        }

        response.data = div;
        return response;
    }

}
