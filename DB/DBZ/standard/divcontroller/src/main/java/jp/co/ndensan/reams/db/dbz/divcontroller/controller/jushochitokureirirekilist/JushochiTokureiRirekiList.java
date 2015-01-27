/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.dgJutoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.JushochiTokureiRirekiListValidationHelper;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICallbackMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「住所地特例履歴List」のイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
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
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.setupToBeforeInput();
        handler.clearInputData();
        handler.setMeisaiInputMode();
        handler.setExecutionStatus(ViewExecutionStatus.Add);
        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
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
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.setupToBeforeInput();
        handler.showSelectedData();

        dgJutoku_Row clickedRow = jutokuRirekiDiv.getDgJutoku().getClickedItem();
        switch (clickedRow.getRowState()) {
            case Added:
            case Modified:
                handler.showSelectedData();
                handler.setMeisaiInputMode();
                break;
            case Deleted:
                handler.showSelectedData();
                handler.setMeisaiDeleteMode();
                break;
            case Unchanged:
            default:
                handler.showSelectedData();
                handler.setMeisaiShokaiMode();
                break;
        }

        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
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
        handler.setupToBeforeInput();
        handler.showSelectedData();
        handler.setMeisaiInputMode();
        handler.setExecutionStatus(ViewExecutionStatus.Modify);
        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
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
        handler.setupToBeforeInput();
        handler.showSelectedData();
        handler.setMeisaiInputMode();
        handler.setExecutionStatus(ViewExecutionStatus.Delete);
        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
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
        ResponseData<JushochiTokureiRirekiListDiv> response = new ResponseData<>();

        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        if (!handler.hasChangedInMeisai()) {
            return this.onClick_btnJutokuTorikeshi_onYes(jutokuRirekiDiv);
        }

        ICallbackMethod methodYes = DivcontrollerMethod.method(SingleButtonType.Free, "onClick_btnJutokuTorikeshi_onYes");
        QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                UrQuestionMessages.入力内容の破棄.getMessage().toString(), "はい", "いいえ");

        ICallbackMethod[] methods = {methodYes};
        message.addInvokeMethod(methods);
        response.addMessage(message);

        response.data = jutokuRirekiDiv;
        return response;
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
        handler.setExecutionStatus(ViewExecutionStatus.None);
        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
    }

    /**
     * 確定ボタンが押下された際に実行される、onClickイベントの前に実行されます。<br/>
     * 明細エリアに入力した値のバリデーションチェックを行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onBeforeClick_btnJutokuKakutei(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        ResponseData<JushochiTokureiRirekiListDiv> response = new ResponseData<>();
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(
                JushochiTokureiRirekiListValidationHelper.validate住所地特例(
                        handler.createEntryData().get(),
                        handler.getEditing被保険者台帳情報(),
                        jutokuRirekiDiv.getTxtTekiyoDate(),
                        jutokuRirekiDiv.getTxtKaijoDate(),
                        jutokuRirekiDiv.getDgJutoku(),
                        JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState()))
        );

        response.addValidationMessages(pairs);
        response.data = jutokuRirekiDiv;
        return response;
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
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.updateEntryData();
        handler.mapping住所地特例履歴();
        handler.clearInputData();
        handler.setMeisaiShokaiMode();
        handler.setupToAfterInput();
        handler.setExecutionStatus(ViewExecutionStatus.None);
        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
    }

}
