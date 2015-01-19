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
import jp.co.ndensan.reams.db.dbz.divcontroller.util.KaigoRowState;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICallbackMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;

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
        //１）明細エリアの情報が変更されているかを確認する。
        //１－１）変更がない場合は、onClick_btnJutokuTorikeshi_onYesの処理を実行する。
        //１－２）変更が存在する場合は、２）の処理を実行する。
        //メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //      Yes：２の処理に進む。（明細エリアの値を破棄する）
        //      No : ダイアログを閉じる
        ResponseData<JushochiTokureiRirekiListDiv> response = new ResponseData<>();

        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        if (!handler.hasChangedInMeisai()) {
            return this.onClick_btnJutokuTorikeshi_onYes(jutokuRirekiDiv);
        }

        ICallbackMethod methodYes = DivcontrollerMethod.method(SingleButtonType.Free, "onClick_btnJutokuTorikeshi_onYes");
        QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                UrQuestionMessages.入力内容の破棄.getMessage().toString(), "はい", "いいえ");

        ICallbackMethod[] methods = {methodYes}; //ユーザー選択時の動作を規定する
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
        //TODO #55852 n8178 城間篤人 バリデーション実装時に回収が必要 2014/12/24
        //１）JuchochiTokureiValidatorを用いて、バリデーションをチェックする。
        //２）適用処理を行う場合、さらにJuchochiTokureiTekiyoTorokuValidatorを用いてチェックを行う。
        //３）解除処理を行う場合、さらにJuchochiTokureiKaijoTorokuValidatorを用いてチェックを行う。
        //４）JushochiTokureiDuplicateValidatorを用いて、
        //    住所地特例情報・他市町村住所地特例・適用除外者それぞれの情報に対して、期間の重複がないかをチェックします。
        //５）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
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
        //TODO #55852
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.updateEntryData();
        handler.clearInputData();
        handler.setMeisaiShokaiMode();
        handler.setupToAfterInput();
        handler.setExecutionStatus(ViewExecutionStatus.None);
        return ResponseDatas.createSettingDataTo(jutokuRirekiDiv);
    }

}
