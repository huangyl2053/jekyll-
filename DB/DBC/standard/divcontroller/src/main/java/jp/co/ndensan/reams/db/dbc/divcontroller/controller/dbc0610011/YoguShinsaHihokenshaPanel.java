/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguShinsaHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 福祉用具購入費支給申請審査の被保険者情報パネルです。
 *
 * @author N3317 塚田 萌
 */
public class YoguShinsaHihokenshaPanel {

    /**
     * 申請一覧から修正ボタンを押したときの処理です。
     *
     * @param panel 被保険者panel
     * @return response
     */
    public ResponseData<YoguShinsaHihokenshaPanelDiv> onLoad(YoguShinsaHihokenshaPanelDiv panel) {
        ResponseData<YoguShinsaHihokenshaPanelDiv> response = new ResponseData<>();

        ShikibetsuCode 識別コード = new ShikibetsuCode("012345678901234");
        int rowId = 0;
        KaigoShikakuKihon.setData(panel.getKaigoAtenaInfo(), panel.getKaigoShikakuKihon(), 識別コード, rowId);
        response.data = panel;
        return response;
    }
}
