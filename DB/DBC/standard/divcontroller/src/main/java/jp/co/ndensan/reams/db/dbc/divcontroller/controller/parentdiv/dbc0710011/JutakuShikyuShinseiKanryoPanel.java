/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0710011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuKaishuShinseiHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuShikyuShinseiKanryoPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 住宅改修費支給申請登録完了時の画面です。
 *
 * @author N3317 塚田 萌
 */
public class JutakuShikyuShinseiKanryoPanel {

    /**
     * 更新ボタン押下時に完了画面にデータをセットします。
     *
     * @param kanryoPanel JutakuShikyuShinseiKanryoPanelDiv
     * @param atenaDiv JutakuShikyuShinseiKanryoPanelDiv
     * @return response
     */
    public ResponseData<JutakuShikyuShinseiKanryoPanelDiv> onClick_btnSave(
            JutakuShikyuShinseiKanryoPanelDiv kanryoPanel, JutakuKaishuShinseiHihokenshaPanelDiv atenaDiv) {

//        KaigoKanryoMessage.setMessage(kanryoPanel.getKanryoMessage(),
//                new RString("住宅改修費支給申請を更新しました。"),
//                atenaDiv.getKaigoShikakuKihon().getTxtHihokenshaNo().getValue(),
//                atenaDiv.getKaigoAtenaInfo().getAtenaInfo().getTxtAtenaMeisho().getValue());
        return ResponseData.of(kanryoPanel).respond();
    }
}
