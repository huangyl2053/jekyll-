/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.TokubetsuIryoIken;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken.TokubetsuIryoIkenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken.TokubetsuIryoIkenHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
        div.setHiddenHenSyu(編集設定(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタンを押下する場合、処理なし、本画面を閉じる。
     *
     * @param div TokubetsuIryoIkenDiv
     * @return ResponseData<TokubetsuIryoIkenDiv>
     */
    public ResponseData<TokubetsuIryoIkenDiv> btnCancel(TokubetsuIryoIkenDiv div) {
        if (div.getHiddenHenSyu().equals(編集設定(div))) {
            return ResponseData.of(div).dialogOKClose();
        } else {
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
        if (div.getHiddenHenSyu().equals(編集設定(div))) {
            return ResponseData.of(div).dialogOKClose();
        } else {
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
        }
        return ResponseData.of(div).respond();
    }

    private RString 編集設定(TokubetsuIryoIkenDiv div) {
        RStringBuilder builder = new RStringBuilder();
        List<RString> 処置内容KeyList = div.getChkTokubetsuIryo().getSelectedKeys();
        List<RString> 特別な対応KeyList = div.getChkTokubetsuTaiou().getSelectedKeys();
        List<RString> 失禁への対応KeyList = div.getChkShikkinTaio().getSelectedKeys();
        for (RString 処置内容Key : 処置内容KeyList) {
            builder.append(処置内容Key);
        }
        for (RString 特別な対応Key : 特別な対応KeyList) {
            builder.append(特別な対応Key);
        }
        for (RString 失禁への対応 : 失禁への対応KeyList) {
            builder.append(失禁への対応);
        }
        return builder.toRString();
    }

    private TokubetsuIryoIkenHandler getHandler(TokubetsuIryoIkenDiv div) {
        return new TokubetsuIryoIkenHandler(div);
    }
}
