/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaShokaiGrandsonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author N8211 田辺 紘一
 */
public class FukaShokaiGrandson {

    public ResponseData<FukaShokaiGrandsonDiv> onLoad_FukaShokaiGrandson(FukaShokaiGrandsonDiv div) {

        FukaRirekiDiv rirekiDiv = (FukaRirekiDiv) ViewStateHolder.get("賦課履歴", FukaRirekiDiv.class);

        div.setCanOpenAndClose(true);
        div.setIsOpen(true);

        List key = getRirekiKey(rirekiDiv, "select");
        loadData(div, key);

        return returnResponse(div);
    }

    public ResponseData<FukaShokaiGrandsonDiv> onSelect(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {
        div.setCanOpenAndClose(true);
        div.setIsOpen(true);

        List key = getRirekiKey(rirekiDiv, "select");
        loadData(div, key);

        return returnResponse(div);
    }

    public ResponseData<FukaShokaiGrandsonDiv> onClick(FukaShokaiGrandsonDiv div, FukaRirekiDiv rirekiDiv) {
        div.setCanOpenAndClose(true);
        div.setIsOpen(true);

        List key = getRirekiKey(rirekiDiv, "click");
        loadData(div, key);

        return returnResponse(div);
    }

    /**
     * イベント処理後のレスポンスデータをリターン
     *
     * @param div
     * @return
     */
    private ResponseData<FukaShokaiGrandsonDiv> returnResponse(FukaShokaiGrandsonDiv div) {
        ResponseData<FukaShokaiGrandsonDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 履歴一覧から選択行の情報取得
     *
     * @param fukaRirekiDiv
     * @param mode
     * @return
     */
    private List getRirekiKey(FukaRirekiDiv fukaRirekiDiv, String mode) {

        List keyList = new ArrayList();

        switch (mode) {
            case "select":
                // 選択行の情報を取得
                List<dgFukaRirekiFukaRireki_Row> selectedItem = fukaRirekiDiv.getDgFukaRirekiFukaRireki().getSelectedItems();
                for (dgFukaRirekiFukaRireki_Row selectData : selectedItem) {
                    keyList.add(selectData.getTxtTsuchishoNo());
                    keyList.add(selectData.getTxtChoteiNendo());
                    keyList.add(selectData.getTxtKoseiM());
                    keyList.add(selectData.getTxtKoseiYMD());
                }

                break;
            case "click":
                dgFukaRirekiFukaRireki_Row clickedItem = fukaRirekiDiv.getDgFukaRirekiFukaRireki().getClickedItem();
                keyList.add(clickedItem.getTxtTokubetsuChoshu());
                keyList.add(clickedItem.getTxtChoteiNendo());
                keyList.add(clickedItem.getTxtKoseiM());
                keyList.add(clickedItem.getTxtKoseiYMD());

                break;
        }

        return keyList;
    }

    private void loadData(FukaShokaiGrandsonDiv div, List key) {
        div.getTxtChoteiNendo().setValue((RString) key.get(1));
        div.getTxtKoseiM().setValue((RString) key.get(2));
        div.getTxtKoseiYMD().setValue((RString) key.get(3));

    }

//
//    public ResponseData<FukaShokaiGrandsonDiv> onClick_btnInjiNaiyoSettei(FukaShokaiGrandsonDiv fukaShokaiGrandsonDiv, FukaRirekiDiv fukaRirekiDiv) {
//
//        fukaShokaiGrandsonDiv.getFukakonkyoAndKiwari().setDisplayNone(true);
//        fukaShokaiGrandsonDiv.getSetaiinShotoku().setDisplayNone(true);
//        fukaShokaiGrandsonDiv.getTokucho().setDisplayNone(true);
//        fukaShokaiGrandsonDiv.getInjiNaiyoSettei().setDisplayNone(false);
//
//        return returnResponse(fukaShokaiGrandsonDiv);
//    }
}
