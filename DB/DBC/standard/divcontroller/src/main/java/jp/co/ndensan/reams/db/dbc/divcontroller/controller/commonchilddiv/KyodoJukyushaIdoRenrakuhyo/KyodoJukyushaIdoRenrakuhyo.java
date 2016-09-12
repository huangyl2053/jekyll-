/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.KyodoJukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyoDivHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共同処理用受給者異動連絡票共有子Div
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyo {

    /**
     * 訂正区分変更
     *
     * @param div KyodoJukyushaIdoRenrakuhyoDiv
     * @return ResponseData<KyodoJukyushaIdoRenrakuhyoDiv>
     */
    public ResponseData<KyodoJukyushaIdoRenrakuhyoDiv> onClick_onChange(KyodoJukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).setChange();
        return ResponseData.of(div).respond();
    }

    /**
     * chk変更
     *
     * @param div KyodoJukyushaIdoRenrakuhyoDiv
     * @return ResponseData<KyodoJukyushaIdoRenrakuhyoDiv>
     */
    public ResponseData<KyodoJukyushaIdoRenrakuhyoDiv> onClick_chkChange(KyodoJukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).setエリア制御();
        return ResponseData.of(div).respond();
    }

    private KyodoJukyushaIdoRenrakuhyoDivHandler getHandler(KyodoJukyushaIdoRenrakuhyoDiv div) {
        return KyodoJukyushaIdoRenrakuhyoDivHandler.of(div);
    }
}
