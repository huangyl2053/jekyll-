/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuShinsaKanryoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費支給申請審査結果登録完了時の画面です。
 *
 * @author N3317 塚田 萌
 */
public class JutakuShinsaKanryoPanel {

    /**
     * 更新ボタン押下時の処理です。
     *
     * @param panel JutakuShikyuShinseiKanryoPanelDiv
     * @return response
     */
    public ResponseData<JutakuShinsaKanryoPanelDiv> onClick_btnSave(JutakuShinsaKanryoPanelDiv panel) {
        ResponseData<JutakuShinsaKanryoPanelDiv> response = new ResponseData<>();

        KaigoKanryoMessage.setMessage(panel.getKanryoMessage(), new RString("住宅改修費支給申請審査結果を更新しました。"));
        response.data = panel;
        return response;
    }
}
