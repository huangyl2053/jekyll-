/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1170001;

import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.DBB1170001TransitionEventName.完了;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.DBB1170001TransitionEventName.選択;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1170001.ShotokuShokaiTaishoshaIchiranHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1170001.ShotokuShokaiTaishoshaIchiranValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51001_所得照会状況一覧
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public class ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiran {

    /**
     * 画面のonLoadイベント
     *
     * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
     * @return 所得照会状況一覧Divを持つResponseData
     */
    public ResponseData<ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv> onLoad(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象者を抽出する」ボタンを押下する。<br/>
     *
     * @param div {@link ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv 所得照会状況一覧Div}
     * @return 所得照会状況一覧Divを持つResponseData
     */
    public ResponseData<ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv> onClick_btnChushutsu(
            ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        ValidationMessageControlPairs messages = getValidationHandler(div).validate();
        if (messages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(messages).respond();
        }
        getHandler(div).do対象者を抽出する();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧Gridの行ダブルクリック処理です。
     *
     * @param div {@link ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv 対象者一覧Div}
     * @return 所得照会状況一覧Divを持つResponseData
     */
    public ResponseData<ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv> onDoubleClick_dgTaishoshaIchiran(
            ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        getHandler(div).do遷移前データ準備();
        return ResponseData.of(div).forwardWithEventName(選択).respond();
    }

    /**
     * 「完了」ボタンを押下する。<br/>
     *
     * @param div {@link ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv 対象者一覧Div}
     * @return 所得照会状況一覧Divを持つResponseData
     */
    public ResponseData<ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv> onClick_btnBack(
            ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        return ResponseData.of(div).forwardWithEventName(完了).respond();
    }

    private ShotokuShokaiTaishoshaIchiranHandler getHandler(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        return ShotokuShokaiTaishoshaIchiranHandler.of(div);
    }

    private ShotokuShokaiTaishoshaIchiranValidationHandler getValidationHandler(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        return new ShotokuShokaiTaishoshaIchiranValidationHandler(div);
    }
}
