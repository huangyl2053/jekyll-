/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.TaJushochiTokureishaKanri;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.TaJushochiTokureishaKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.TaJushochiTokureishaKanriHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.TaJushochiTokureishaKanriValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 他住所地特例者管理のクラス。
 *
 * @reamsid_L DBA-0200-010 linghuhang
 */
public class TaJushochiTokureishaKanri {

    /**
     * 「過去の履歴を追加する」ボタンを押下する場合、他市町村住所地特例情報入力エリア全項目をクリアします。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_BtnAdd(TaJushochiTokureishaKanriDiv requestDiv) {
        getHandler(requestDiv).onClick_BtnAdd();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「選択」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_Selsect(TaJushochiTokureishaKanriDiv requestDiv) {
        getHandler(requestDiv).onClick_Selsect();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_Update(TaJushochiTokureishaKanriDiv requestDiv) {
        getHandler(requestDiv).onClick_Update();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「削除」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_Delete(TaJushochiTokureishaKanriDiv requestDiv) {
        getHandler(requestDiv).onClick_Delete();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 最新適用情報の解除日がある場合、非活性で表示します。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_onBlur(TaJushochiTokureishaKanriDiv requestDiv) {
        RString 親画面状態 = new RString(requestDiv.getMode_DisplayMode().toString());
        getHandler(requestDiv).onClick_onBlur(親画面状態);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「取消する」ボタンを押下する場合、入力の内容をクリアします。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_Torikeshi(TaJushochiTokureishaKanriDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(requestDiv).onClick_Torikeshi();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「異動内容を確認する」ボタンを押下する場合、入力の内容を最新の適用情報に反映します。
     *
     * @param requestDiv 他住所地特例者管理Div
     * @return ResponseData<TaJushochiTokureishaKanriDiv>
     */
    public ResponseData<TaJushochiTokureishaKanriDiv> onClick_BtnKakunin(TaJushochiTokureishaKanriDiv requestDiv) {
        RString 親画面状態 = new RString(requestDiv.getMode_DisplayMode().toString());
        ValidationMessageControlPairs vallidation = getValidationHandler(requestDiv).validateForUpdate(親画面状態);
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(vallidation).respond();
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(requestDiv).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(requestDiv).onClick_BtnKakunin(requestDiv.getDgJushochiTokureiRireki().getActiveRow(), 親画面状態);
            }
        }
        return ResponseData.of(requestDiv).respond();
    }

    private TaJushochiTokureishaKanriHandler getHandler(TaJushochiTokureishaKanriDiv requestDiv) {
        return new TaJushochiTokureishaKanriHandler(requestDiv);
    }

    private TaJushochiTokureishaKanriValidationHandler getValidationHandler(TaJushochiTokureishaKanriDiv requestDiv) {
        return new TaJushochiTokureishaKanriValidationHandler(requestDiv);
    }
}
