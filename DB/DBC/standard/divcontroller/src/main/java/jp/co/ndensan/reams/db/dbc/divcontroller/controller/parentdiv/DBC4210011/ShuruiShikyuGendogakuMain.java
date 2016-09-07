/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4210011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceShuruiShikyuGendoGakuHolder;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.DBC4210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.DBC4210011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4210011.ShuruiShikyuGendogakuMainValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * DBC4210011_種類支給限度額登録のクラスです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ShuruiShikyuGendogakuMain {

    private static int state;
    private static final int 標準 = 1;
    private static final int 保存 = 2;
    private static final int 修正 = 3;
    private static final int 追加 = 4;
    private static final int 削除 = 5;
    private static final LockingKey 排他キー = new LockingKey("DBCShikyuGendoGakuTableDbT7111");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div ShuruiShikyuGendogakuMainDiv
     *
     * @return ResponseData
     */
    public ResponseData<ShuruiShikyuGendogakuMainDiv> onLoand(ShuruiShikyuGendogakuMainDiv div) {
        List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList = getHandler(div).initialize();
        ViewStateHolder.put(ViewStateKeys.サービス種類支給限度額,
                new ServiceShuruiShikyuGendoGakuHolder(shikyuGendoGakuList));
        state = 標準;
        return ResponseData.of(div).setState(DBC4210011StateName.標準);
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
            List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList
                    = ViewStateHolder.get(ViewStateKeys.サービス種類支給限度額, ServiceShuruiShikyuGendoGakuHolder.class)
                    .getServiceShuruiShikyuGendoGakuList();
            switch (state) {
                case 追加:
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
                    getHandler(div).追加する(shikyuGendoGakuList);
                    break;
                case 修正:
                    validationHandler.要支援1入力チェック警告(pairs, div);
                    validationHandler.要支援1入力チェックエラー(pairs, div);
                    validationHandler.要支援2入力チェック警告(pairs, div);
                    validationHandler.要支援2入力チェックエラー(pairs, div);
                    if (pairs.iterator().hasNext()) {
                        return ResponseData.of(div).addValidationMessages(pairs).respond();
                    }
                    getHandler(div).update修正(shikyuGendoGakuList);
                    break;
                case 削除:
                    getHandler(div).update削除(shikyuGendoGakuList);
                    break;
                default:
                    break;
            }
            getHandler(div).btnSave();
            RealInitialLocker.release(排他キー);
            state = 保存;
            return ResponseData.of(div).setState(DBC4210011StateName.保存完了);
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
        List<ServiceShuruiShikyuGendoGaku> shikyuGendoGakuList = getHandler(div).btnContinue();
        ViewStateHolder.put(ViewStateKeys.サービス種類支給限度額,
                new ServiceShuruiShikyuGendoGakuHolder(shikyuGendoGakuList));
        state = 標準;
        return ResponseData.of(div).setState(DBC4210011StateName.標準);
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
        state = 追加;
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
        state = 修正;
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
        state = 削除;
        return ResponseData.of(div).respond();
    }

    private ShuruiShikyuGendogakuMainHandler getHandler(ShuruiShikyuGendogakuMainDiv div) {

        return new ShuruiShikyuGendogakuMainHandler(div);
    }

    private ShuruiShikyuGendogakuMainValidationHandler getValidationHandler() {
        return new ShuruiShikyuGendogakuMainValidationHandler();
    }
}
