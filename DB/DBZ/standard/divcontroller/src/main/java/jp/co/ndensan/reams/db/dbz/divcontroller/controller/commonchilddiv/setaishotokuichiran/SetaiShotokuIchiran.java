/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.setaishotokuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv.DisplayMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.SetaiShotokuIchiranHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 世帯所得一覧の共有子Divのコントローラクラスです。
 */
public class SetaiShotokuIchiran {

    /**
     * 初期処理です。
     *
     * @param div 世帯所得一覧Div
     * @return 世帯所得一覧Divの処理結果
     */
    public ResponseData<SetaiShotokuIchiranDiv> onLoad(SetaiShotokuIchiranDiv div) {
        return ResponseData.of(div).respond();
    }

    private SetaiShotokuIchiranHandler getHandler(SetaiShotokuIchiranDiv div) {
        return new SetaiShotokuIchiranHandler(div);
    }

    /**
     * 再表示するボタン押下処理です。<br/>
     *
     * @param div 世帯所得一覧Div
     * @return ResponseData<SetaiShotokuIchiranDiv>
     */
    public ResponseData<SetaiShotokuIchiranDiv> onClick_Saihyoji(SetaiShotokuIchiranDiv div) {
        SetaiShotokuIchiranHandler handler = getHandler(div);
        List<SetaiinShotoku> setaiinShotokuList = handler.get世帯員所得Data(new ShikibetsuCode(div.getTxtShikibetsuCode()), YMDHMS.now());
        handler.set住民税減免前_後表示制御情報TO世帯一覧();
        handler.set激変緩和表示制御情報TO世帯一覧();
        handler.load世帯員所得一覧(setaiinShotokuList);
        handler.set世帯一覧行選択制御();
        handler.accessLog(setaiinShotokuList);
        return ResponseData.of(div).respond();
    }

    /**
     * 最新を表示するチェックボックス押下処理です。<br/>
     *
     * @param div 世帯所得一覧Div
     * @return ResponseData<SetaiShotokuIchiranDiv>
     */
    public ResponseData<SetaiShotokuIchiranDiv> onClick_chkSetaiIchiranAll(SetaiShotokuIchiranDiv div) {
        SetaiShotokuIchiranHandler handler = getHandler(div);
        List<SetaiinShotoku> setaiinShotokuList = handler.set最新世帯員所得情報(new ShikibetsuCode(div.getTxtShikibetsuCode()));
        handler.set住民税減免前_後表示制御情報TO世帯一覧();
        handler.set激変緩和表示制御情報TO世帯一覧();
        handler.load世帯員所得一覧(setaiinShotokuList);
        handler.set世帯一覧行選択制御();
        handler.accessLog(setaiinShotokuList);
        return ResponseData.of(div).respond();
    }

    /**
     * 行選択ボタンがクリックもしくはダブルクリックされた時の処理です。<br/>
     *
     * @param div 世帯所得一覧Div
     * @return ResponseData<SetaiShotokuIchiranDiv>
     */
    public ResponseData<SetaiShotokuIchiranDiv> onClick_SetaiinSentaku(SetaiShotokuIchiranDiv div) {
        if (!div.getMode_DisplayMode().equals(DisplayMode.ShotokuShokai)) {
            return ResponseData.of(div).respond();
        }

        div.setMode_DisplayMode(DisplayMode.ShotokuRirekiShokai);
        dgSetaiShotoku_Row clickedItem = div.getDgSetaiShotoku().getClickedItem();
        if (clickedItem == null) {
            return ResponseData.of(div).respond();
        }
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(clickedItem.getHdnShikibetsuCode());
        SetaiShotokuIchiranHandler handler = getHandler(div);
        List<KaigoShotokuAlive> 介護所得情報 = handler.get所得情報履歴(shikibetsuCode);
        handler.set激変緩和表示制御情報TO所得履歴一覧();
        handler.load所得情報履歴(介護所得情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 履歴を閉じるボタン押下処理です。<br/>
     *
     * @param div 世帯所得一覧Div
     * @return ResponseData<SetaiShotokuIchiranDiv>
     */
    public ResponseData<SetaiShotokuIchiranDiv> onClick_btnRirekiClose(SetaiShotokuIchiranDiv div) {
        div.setMode_DisplayMode(DisplayMode.ShotokuShokai);
        return ResponseData.of(div).respond();
    }
}
