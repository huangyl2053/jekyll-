/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiRirekiListHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;

/**
 * 共有子Div「住所地特例履歴List」のイベントを定義したDivControllerクラスです。
 *
 * @reamsid_L DBA-0150-011 huangh
 */
public class JushochiTokureiRirekiList {

    /**
     * 追加ボタンが押下された際に実行されます。<br/>
     * 住所地特例の情報を追加するための前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnAdd(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {

        jutokuRirekiDiv.setupToBeforeInput(new RString("add"));
        jutokuRirekiDiv.clearInputData();
        jutokuRirekiDiv.setMeisaiInputMode();
        jutokuRirekiDiv.setExecutionStatus(ViewExecutionStatus.Add);
        return ResponseData.of(jutokuRirekiDiv).respond();
    }

    /**
     * 住所地特例履歴上の1行を選択した際に実行されます。<br/>
     * 選択行の内容を明細エリアに表示し、選択行の状態に応じて、修正・照会の前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onSelect_dgJutoku(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {

        return ResponseData.of(jutokuRirekiDiv).respond();
    }

    /**
     * 住所地特例履歴上の修正ボタンを押下した際に実行されます。<br/>
     * 選択行の内容を明細エリアに表示し、選択行の状態に応じて、住所地特例情報を修正するための前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onSelectByModifyButton_dgJutoku(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.setupToBeforeInput(new RString("modify"));
        handler.showSelectedData();
        handler.setMeisaiInputMode();
        handler.setExecutionStatus(ViewExecutionStatus.Modify);
        return ResponseData.of(jutokuRirekiDiv).respond();
    }

    /**
     * 住所地特例履歴上の削除ボタンを押下した際に実行されます。<br/>
     * 選択行の内容を明細エリアに表示し、選択行の状態に応じて、住所地特例情報を削除するための前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onSelectByDeleteButton_dgJutoku(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.setupToBeforeInput(new RString("delete"));
        handler.showSelectedData();
        handler.setMeisaiInputMode();
        handler.setExecutionStatus(ViewExecutionStatus.Delete);
        return ResponseData.of(jutokuRirekiDiv).respond();
    }

    /**
     * 取消ボタンが押下された際に実行します。<br/>
     * 入力を取りやめる際、明細エリアに入力した情報を初期化してよいか確認するダイアログを表示します。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnJutokuTorikeshi(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(jutokuRirekiDiv).addMessage(message).respond();

        }

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

            return this.onClick_btnJutokuTorikeshi_onYes(jutokuRirekiDiv);
        }

        return ResponseData.of(jutokuRirekiDiv).respond();
    }

    /**
     * 取消ボタンを押下した時に表示される、ダイアログ上のはいを選択した際に実行されます。<br/>
     * 明細エリアの情報を破棄し、追加・修正等の処理が可能な状態にします。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnJutokuTorikeshi_onYes(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);

        handler.clearInputData();
        handler.setupToAfterInput();
        return ResponseData.of(jutokuRirekiDiv).respond();
    }

    /**
     * 確定ボタンが押下された際に実行されます。<br/>
     * 明細エリアの情報を、住所地特例履歴Listに反映させます。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     *
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnJutokuKakutei(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(jutokuRirekiDiv.getJutokuInput().getTxtTekiyoDate()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(jutokuRirekiDiv.getJutokuInput().getTxtTekiyoTodokedeDate()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(jutokuRirekiDiv.getJutokuInput().getTxtKaijoDate()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(jutokuRirekiDiv.getJutokuInput().getTxtKaijoTodokedeDate()));
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(jutokuRirekiDiv).addValidationMessages(validPairs).respond();
        }

        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.updateEntryData();
        handler.clearInputData();
        handler.setMeisaiShokaiMode();
        handler.setupToAfterInput();
        handler.setExecutionStatus(ViewExecutionStatus.None);
        return ResponseData.of(jutokuRirekiDiv).respond();
    }

}
