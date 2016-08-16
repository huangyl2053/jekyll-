/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.ichijisashitome1go;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go.IchijiSashitome1GoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go.IchijiSashitome1GoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IDialogResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】1号一時差止ダイアログのcontrolクラスです。
 *
 * @reamsid_L DBD-3620-042 panxiaobo
 */
public class IchijiSashitome1Go {

    /**
     * 画面初期化です。
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onLoad(IchijiSashitome1GoDiv div) {
        Message message = getHandler(div).onLoad();
        if (message != null) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消」ボタンを押下します。
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_BtnTorikeshi(IchijiSashitome1GoDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        if (!ResponseHolder.isReRequest()) {
            return dialogResponse.addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("処理中のデータ")).respond();
        }
        return dialogResponse.dialogNGClose();
    }

    /**
     * 「確定」ボタンを押下します。
     *
     * @param div IchijiSashitome2GoDiv
     * @return ResponseData<IchijiSashitome2GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_BtnKakutei(IchijiSashitome1GoDiv div) {
        IDialogResponse dialogResponse = ResponseData.of(div);
        getHandler(div).onClick_IchijiSashitome1GoKakutei();
        return dialogResponse.dialogOKClose();
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onBeforeOpenDialog_BtnTainoJokyo(IchijiSashitome1GoDiv div) {
        getHandler(div).onBeforeOpenDialog_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 滞納状況ダイアログが確定クローズイベントで閉じられたときにダイアログが完全に閉じた後に実行されるイベントを設定します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onOkClose_BtnTainoJokyo(IchijiSashitome1GoDiv div) {
        getHandler(div).onOkClose_BtnTainoJokyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 「差止登録」ボタンを押下します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_SashitomeToRoku(IchijiSashitome1GoDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).onClick_SashitomeToRoku();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「控除登録」ボタンを押下します。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_KaijoToRoku(IchijiSashitome1GoDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).onClick_KaijoToRoku();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付一時差止登録一覧(ﾃﾞｰﾀｸﾞﾘｯﾄﾞ)明細。
     *
     * @param div KyufuGengaku1GoDiv
     * @return ResponseData<KyufuGengaku1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_SelectedItem(IchijiSashitome1GoDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).onClick_SelectedItem();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンを押下します。
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_DeleteItem(IchijiSashitome1GoDiv div) {
        getHandler(div).onClick_DeleteItem();
        return ResponseData.of(div).respond();
    }

    /**
     * 「解除」ボタンを押下します。
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_KaijoItem(IchijiSashitome1GoDiv div) {
        getHandler(div).onClick_KaijoItem();
        return ResponseData.of(div).respond();
    }

    /**
     * 「差止／控除状況照会」ボタンを押下します。
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_SashitomeKojo(IchijiSashitome1GoDiv div) {
        getHandler(div).onClick_SashitomeKojo();
        return ResponseData.of(div).respond();
    }

    /**
     * 「(差止登録)取消」ボタンの処理です
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_SashitomeToRokuToRiKeShi(IchijiSashitome1GoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrWarningMessages.未保存情報の破棄確認.getMessage().replace("処理中のデータ")).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「(差止登録)確定」ボタンの処理です
     *
     * @param div IchijiSashitome1GoDiv
     * @return ResponseData<IchijiSashitome1GoDiv>
     */
    public ResponseData<IchijiSashitome1GoDiv> onClick_SashitomeToRokuKaKuTei(IchijiSashitome1GoDiv div) {
        ResponseData<IchijiSashitome1GoDiv> response = new ResponseData();
        ValidationMessageControlPairs pairs = getHandler(div).onClick_SashitomeToRokuKaKuTei();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        response.data = div;
        return ResponseData.of(div).dialogOKClose();
    }

    private IchijiSashitome1GoHandler getHandler(IchijiSashitome1GoDiv div) {
        return new IchijiSashitome1GoHandler(div);
    }
}
