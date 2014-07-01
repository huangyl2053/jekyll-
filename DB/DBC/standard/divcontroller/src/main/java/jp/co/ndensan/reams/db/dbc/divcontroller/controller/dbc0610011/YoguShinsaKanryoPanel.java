/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguShinsaKanryoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費支給申請審査の完了画面です。
 *
 * @author N3317 塚田 萌
 */
public class YoguShinsaKanryoPanel {

    /**
     * 完了画面ロード時の処理です。
     *
     * @param panel JutakuShikyuShinseiKanryoPanelDiv
     * @return response
     */
    public ResponseData<YoguShinsaKanryoPanelDiv> onLoad(YoguShinsaKanryoPanelDiv panel) {
        ResponseData<YoguShinsaKanryoPanelDiv> response = new ResponseData<>();

        KaigoKanryoMessage.setMessage(panel.getKanryoMessage(), new RString(" 福祉用具購入費支給申請審査結果登録が完了しました。"));
        response.data = panel;
        return response;
    }
}
