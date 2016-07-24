/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4530011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.KanryoMessagePanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額補正・支払場所の完了メッセージDivを制御します。
 *
 * @reamsid_L DBC-3360-010 xuxin
 */
public class KanryoMessagePanel {

    private static final RString 完了メッセージ = new RString("更新が完了しました。");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KanryoMessagePanelDiv
     * @return ResponseData<KanryoMessagePanelDiv>
     */
    public ResponseData<KanryoMessagePanelDiv> onLoad(KanryoMessagePanelDiv div) {

        div.getCcdKanryoMessage().setMessage(完了メッセージ, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).respond();
    }

}
