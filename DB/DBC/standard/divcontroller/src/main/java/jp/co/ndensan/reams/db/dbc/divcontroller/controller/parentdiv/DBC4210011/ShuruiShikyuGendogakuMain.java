/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4210011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.DBC4210011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.DBC4220011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * DBC4210011_種類支給限度額登録のクラスです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ShuruiShikyuGendogakuMain {

    private static int state;
    private final int 標準state = 1;
    private final int 保存state = 2;
    private final int 修正state = 3;
    private final int 追加state = 4;
    private final int 削除state = 5;

    /**
     * 画面初期化のメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onLoand(ShuruiShikyuGendogakuMainDiv div) {
        getHandler(div).initialize();
        state = 標準state;
        return ResponseData.of(div).setState(DBC4220011StateName.標準);
    }

    /**
     * 「完了する」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_btnComplete(ShuruiShikyuGendogakuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC4210011TransitionEventName.完了状態).respond();
    }

    /**
     * 「保存する」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_btnUpdate(ShuruiShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            ShuruiShikyuGendogakuMainValidationHandler validationHandler = getValidationHandler();
            switch (state) {
                case 追加state:
                    validationHandler.標準適用開始年月チェック(pairs, div);
                    validationHandler.サービス提供期間チェック(pairs, div);
                    validationHandler.種類支給限度額認定対象チェック(pairs, div);
                    validationHandler.要支援1入力チェック警告(pairs, div);
                    validationHandler.要支援1入力チェックエラー(pairs, div);
                    validationHandler.要支援2入力チェック警告(pairs, div);
                    validationHandler.要支援2入力チェックエラー(pairs, div);
                    if (pairs.iterator().hasNext()) {
                        return ResponseData.of(div).addValidationMessages(pairs).respond();
                    }
                    getHandler(div).追加する();
                    break;
                case 修正state:
                    validationHandler.要支援1入力チェック警告(pairs, div);
                    validationHandler.要支援1入力チェックエラー(pairs, div);
                    validationHandler.要支援2入力チェック警告(pairs, div);
                    validationHandler.要支援2入力チェックエラー(pairs, div);
                    if (pairs.iterator().hasNext()) {
                        return ResponseData.of(div).addValidationMessages(pairs).respond();
                    }
                    getHandler(div).update修正();
                    break;
                case 削除state:
                    getHandler(div).update削除();
                    break;
                default:
                    break;
            }
            getHandler(div).btnSave();
            state = 保存state;
            return ResponseData.of(div).setState(DBC4220011StateName.保存完了);
        } else {
            return ResponseData.of(div).respond();
        }

    }

    /**
     * 「登録処理を続ける」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_btnContinue(ShuruiShikyuGendogakuMainDiv div) {
        getHandler(div).btnContinue();
        state = 標準state;
        return ResponseData.of(div).setState(DBC4220011StateName.標準);
    }

    /**
     * 「入力を破棄する」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_btnCancel(ShuruiShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).btnCancel();
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加する」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_btnAddShikyuGendogaku(ShuruiShikyuGendogakuMainDiv div) {
        getHandler(div).btnAddShikyuGendogaku();
        state = 追加state;
        return ResponseData.of(div).respond();
    }

    /**
     * 支給限度額一覧の「修正」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_modify(ShuruiShikyuGendogakuMainDiv div) {
        getHandler(div).modify();
        state = 修正state;
        return ResponseData.of(div).respond();
    }

    /**
     * 支給限度額一覧の「削除」ボタンのメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onClick_delete(ShuruiShikyuGendogakuMainDiv div) {
        getHandler(div).delete();
        state = 削除state;
        return ResponseData.of(div).respond();
    }

    private ShuruiShikyuGendogakuMainHandler getHandler(ShuruiShikyuGendogakuMainDiv div) {

        return new ShuruiShikyuGendogakuMainHandler(div);
    }

    private ShuruiShikyuGendogakuMainValidationHandler getValidationHandler() {
        return new ShuruiShikyuGendogakuMainValidationHandler();
    }
}
