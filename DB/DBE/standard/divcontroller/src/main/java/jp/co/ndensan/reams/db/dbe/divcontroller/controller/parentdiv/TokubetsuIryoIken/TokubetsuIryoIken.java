/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.TokubetsuIryoIken;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken.TokubetsuIryoIkenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken.TokubetsuIryoIkenHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 特別医療意見のコントローラです。
 */
public class TokubetsuIryoIken {

    /**
     * 画面初期化処理です。
     *
     * @param div TokubetsuIryoIkenDiv
     * @return ResponseData<TokubetsuIryoIkenDiv>
     */
    public ResponseData<TokubetsuIryoIkenDiv> load(TokubetsuIryoIkenDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンを押下する場合、処理なし、本画面を閉じる。
     *
     * @param div TokubetsuIryoIkenDiv
     * @return ResponseData<TokubetsuIryoIkenDiv>
     */
    public ResponseData<TokubetsuIryoIkenDiv> btnCancel(TokubetsuIryoIkenDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 確認ボタンを押下する場合、処理なし、本画面を閉じる。
     *
     * @param div TokubetsuIryoIkenDiv
     * @return ResponseData<TokubetsuIryoIkenDiv>
     */
    public ResponseData<TokubetsuIryoIkenDiv> btnKakutei(TokubetsuIryoIkenDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).btnKakutei();
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private TokubetsuIryoIkenHandler getHandler(TokubetsuIryoIkenDiv div) {
        return new TokubetsuIryoIkenHandler(div);
    }
}
