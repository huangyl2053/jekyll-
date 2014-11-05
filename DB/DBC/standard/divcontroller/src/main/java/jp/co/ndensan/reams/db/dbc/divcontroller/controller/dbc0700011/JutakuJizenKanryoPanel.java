/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0700011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuJizenKanryoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 住宅改修費事前申請登録完了画面です。
 *
 * @author N3317 塚田 萌
 */
public class JutakuJizenKanryoPanel {

    /**
     * 完了画面ロード時の処理です。
     *
     * @param kanryoPanel
     * @param hihoPanel
     * @return response
     */
    public ResponseData<JutakuJizenKanryoPanelDiv> onLoad(
            JutakuJizenKanryoPanelDiv kanryoPanel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuJizenKanryoPanelDiv> response = new ResponseData<>();

//        KaigoKanryoMessage.setMessage(kanryoPanel.getKanryoMessage(),
//                new RString("住宅改修費事前申請を更新しました。"),
//                hihoPanel.getKaigoShikakuKihon().getTxtHihokenshaNo().getValue(),
//                hihoPanel.getKaigoAtena().getAtenaInfo().getTxtAtenaMeisho().getValue());
        response.data = kanryoPanel;
        return response;
    }
}
