/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.KanryoMessagePnlDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011.ShoKaishuKanriTaishoshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証回収管理完了メッセージパネルDivを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ShoKaishuKanriKanryoMessage {

    /**
     * 証回収管理完了メッセージ画面の初期処理を表します。
     *
     * @param panel KanryoMessagePnlDiv
     * @param panel2 ShoKaishuKanriTaishoshaJohoDiv
     * @return ResponseData
     */
    public ResponseData<KanryoMessagePnlDiv> onLoad(
            KanryoMessagePnlDiv panel, ShoKaishuKanriTaishoshaJohoDiv panel2) {
        ResponseData<KanryoMessagePnlDiv> response = new ResponseData<>();

        panel.getCcdKaigoKanryoMessage().getKanryoMessage().getLblMessageMain().setText(
                new RString("登録しました。"));

        panel.getCcdKaigoKanryoMessage().getKanryoMessage().getLblTaishoMessage1().setText(
                panel2.getCcdKaigoShikakuKihon().getTxtHihokenshaNo().getValue());

        panel.getCcdKaigoKanryoMessage().getKanryoMessage().getLblTaishoMessage2().setText(
                panel2.getShoKaishuKanriTaishoshaCommonJoho().getTxtAtenaMeisho().getValue());

        response.data = panel;
        return response;

    }

}
