/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0700011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.JutakuKaishuJizenShinseiHihokenshaPanelDiv;
//import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author N3317 塚田 萌
 */
public class JutakuKaishuJizenShinseiHihokenshaPanel {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 被保険者panel
     * @return response
     */
    public ResponseData<JutakuKaishuJizenShinseiHihokenshaPanelDiv> onLoad(JutakuKaishuJizenShinseiHihokenshaPanelDiv panel) {

//        ShikibetsuCode 識別コード = new ShikibetsuCode("012345678901234");
//        int rowId = 0;
//        KaigoShikakuKihon.setData(panel.getKaigoAtena(), panel.getKaigoShikakuKihon(), 識別コード, rowId);
        return ResponseData.of(panel).respond();
    }
}
