/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv.DisplayMode;
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
        List<SetaiinShotoku> setaiinShotokuList = getHandler(div).get世帯員所得Data(new ShikibetsuCode(div.getTxtShikibetsuCode()), YMDHMS.now());
        getHandler(div).set住民税減免前_後表示制御情報TO世帯一覧();
        getHandler(div).set激変緩和表示制御情報TO世帯一覧();
        getHandler(div).load世帯員所得一覧(setaiinShotokuList);
        getHandler(div).set世帯一覧行選択制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 最新を表示するチェックボックス押下処理です。<br/>
     *
     * @param div 世帯所得一覧Div
     * @return ResponseData<SetaiShotokuIchiranDiv>
     */
    public ResponseData<SetaiShotokuIchiranDiv> onClick_chkSetaiIchiranAll(SetaiShotokuIchiranDiv div) {
        List<SetaiinShotoku> setaiinShotokuList = getHandler(div).set最新世帯員所得情報(new ShikibetsuCode(div.getTxtShikibetsuCode()));
        getHandler(div).set住民税減免前_後表示制御情報TO世帯一覧();
        getHandler(div).set激変緩和表示制御情報TO世帯一覧();
        getHandler(div).load世帯員所得一覧(setaiinShotokuList);
        getHandler(div).set世帯一覧行選択制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 行選択ボタンがクリックもしくはダブルクリックされた時の処理です。<br/>
     *
     * @param div 世帯所得一覧Div
     * @return ResponseData<SetaiShotokuIchiranDiv>
     */
    public ResponseData<SetaiShotokuIchiranDiv> onClick_SetaiinSentaku(SetaiShotokuIchiranDiv div) {
        DisplayMode mode = div.getMode_DisplayMode();
        if (mode.equals(DisplayMode.ShotokuShokai)) {
            div.setMode_DisplayMode(DisplayMode.ShotokuRirekiShokai);
            List<KaigoShotokuAlive> 介護所得情報 = getHandler(div).get所得情報履歴(new ShikibetsuCode(div.getTxtShikibetsuCode()));
            getHandler(div).set激変緩和表示制御情報TO所得履歴一覧();
            getHandler(div).load所得情報履歴(介護所得情報);
        }
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
