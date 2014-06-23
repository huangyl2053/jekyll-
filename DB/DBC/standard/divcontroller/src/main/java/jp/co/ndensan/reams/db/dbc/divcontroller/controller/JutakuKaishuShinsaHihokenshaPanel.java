/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author N3317 塚田 萌
 */
public class JutakuKaishuShinsaHihokenshaPanel {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 被保険者panel
     * @return response
     */
    public ResponseData<JutakuKaishuShinsaHihokenshaPanelDiv> onLoad(JutakuKaishuShinsaHihokenshaPanelDiv panel) {
        ResponseData<JutakuKaishuShinsaHihokenshaPanelDiv> response = new ResponseData<>();

        ShikibetsuCode 識別コード = new ShikibetsuCode("012345678901234");
        int rowId = 0;
        KaigoShikakuKihon.setData(panel.getKaigoAtena(), panel.getKaigoShikakuKihon(), 識別コード, rowId);
        response.data = panel;
        return response;
    }
}
