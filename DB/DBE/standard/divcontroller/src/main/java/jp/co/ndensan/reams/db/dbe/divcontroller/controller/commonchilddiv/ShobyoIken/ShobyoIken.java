/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.ShobyoIken;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken.ShobyoIkenDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken.ShobyoIkenHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken.ShobyoIkenValidationHandler;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.Anteisei;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div 「ShobyoIken」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-130 zhengshukai
 */
public class ShobyoIken {

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onLoad(ShobyoIkenDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 不安定を選択したか判定します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onChange_antei(ShobyoIkenDiv div) {
        if (Anteisei.不安定.getコード().equals(div.getRadShojoAnteisei().getSelectedKey())) {
            div.getTxtFuanteiShosaiJokyo().setDisabled(false);
            div.getTxtFuanteiShosaiJokyo().setValue(div.getShojoAnteisei().getFuantei());
        } else {
            div.getTxtFuanteiShosaiJokyo().setDisabled(true);
            div.getTxtFuanteiShosaiJokyo().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「原因疾患を追加する」を押下の処理です。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_tsuika(ShobyoIkenDiv div) {
        getHandler(div).onClick_tsuika();
        return ResponseData.of(div).respond();
    }

    /**
     * 「原因疾患一覧 修正　アイコン」を押下の処理です。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_syusei(ShobyoIkenDiv div) {
        getHandler(div).onClick_syusei();
        return ResponseData.of(div).respond();
    }

    /**
     * 「原因疾患一覧 削除　アイコン」を押下の処理です。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_sakujyo(ShobyoIkenDiv div) {
        getHandler(div).onClick_sakujyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 原因疾患一覧 行ダブルクリック押下します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_double(ShobyoIkenDiv div) {
        getHandler(div).onClick_double();
        return ResponseData.of(div).respond();
    }

    /**
     * 原因疾患詳細エリア 取消する　ボタン押下します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_btnNo(ShobyoIkenDiv div) {
        getHandler(div).clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 原因疾患詳細エリア 確定する　ボタン押下します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_btnOK(ShobyoIkenDiv div) {
        ValidationMessageControlPairs validationMessage = getValidationHandler(div).validateForAction();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        getHandler(div).onClick_btnOK();
        return ResponseData.of(div).respond();
    }

    /**
     * 取消　ボタン押下します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_btnCansel(ShobyoIkenDiv div) {
        if (getHandler(div).編集がある()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).dialogOKClose();
            }
        } else {
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 確定　ボタン押下します。
     *
     * @param div ShobyoIkenDiv
     * @return ResponseData<ShobyoIkenDiv>
     */
    public ResponseData<ShobyoIkenDiv> onClick_btnKakutei(ShobyoIkenDiv div) {
        if (getHandler(div).編集がある()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                        UrQuestionMessages.確定の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).呼び出し元画面への戻り値();
                return ResponseData.of(div).dialogOKClose();
            }
        } else {
            getHandler(div).呼び出し元画面への戻り値();
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    private ShobyoIkenHandler getHandler(ShobyoIkenDiv div) {
        return new ShobyoIkenHandler(div);
    }

    private ShobyoIkenValidationHandler getValidationHandler(ShobyoIkenDiv div) {
        return new ShobyoIkenValidationHandler(div);
    }
}
