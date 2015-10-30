/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.YoguShinsaHihokenshaPanelDiv;
//import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 福祉用具購入費支給申請審査の被保険者情報パネルです。
 *
 * @author N3317 塚田 萌
 */
//TODO n3317塚田　Yamlを使わないようにする
public class YoguShinsaHihokenshaPanel {

    /**
     * 申請一覧から修正ボタンを押したときの処理です。
     *
     * @param panel 被保険者panel
     * @return response
     */
    public ResponseData<YoguShinsaHihokenshaPanelDiv> onLoad(YoguShinsaHihokenshaPanelDiv panel) {
//        ResponseData<YoguShinsaHihokenshaPanelDiv> response = new ResponseData<>();

//        ControlGenerator targetSource = new ControlGenerator(targetSourceList.get(0));
//        ShikibetsuCode 識別コード = new ShikibetsuCode(targetSource.getAsRString("識別コード"));
//        int rowId = 0;
        return ResponseData.of(panel).respond();
    }
}
