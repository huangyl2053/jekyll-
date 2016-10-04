/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4220011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShuruiShikyuGendoGakuHolder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseShokanShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseShokanShuruiShikyuGendoGakuHolder;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.ShikyuGendogakuTableKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.DBC4220011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.DBC4220011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.ShokanShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4220011.ShokanShikyuGendogakuMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4220011.ShokanShikyuGendogakuMainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShokanShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.UwanoseShokanShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還支給限度額登録のクラスです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuMain {

    private static final RString 排他キー = new RString("DBCShikyuGendoGakuTableDbT7112");
    private static final RString 完了メッセージメイン = new RString("償還支給限度額の登録が完了しました。");
    private static final RString 省略_空 = new RString("");
    private static final RString 共通ボタン = new RString("btnUpdate");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onLoad(ShokanShikyuGendogakuMainDiv div) {
        div.getShokanShikyuGendogakuIchiran().setDisabled(true);
        LockingKey key = new LockingKey(排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }

        ShokanShuruiShikyuGendoGakuManager 償還manager = new ShokanShuruiShikyuGendoGakuManager();
        List<ShokanShuruiShikyuGendoGaku> 償還list = 償還manager.get償還払い給付種類支給限度額データ();
        UwanoseShokanShuruiShikyuGendoGakuManager 上乗せ償還manager
                = new UwanoseShokanShuruiShikyuGendoGakuManager();
        List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還list
                = 上乗せ償還manager.get上乗せ償還払い給付種類支給限度額データ();

        ViewStateHolder.put(ViewStateKeys.償還払い給付種類支給限度額,
                new ShokanShuruiShikyuGendoGakuHolder(償還list));
        ViewStateHolder.put(ViewStateKeys.上乗せ償還払い給付種類支給限度額,
                new UwanoseShokanShuruiShikyuGendoGakuHolder(上乗せ償還list));

        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.initializeDisplay(償還list, 上乗せ償還list);

        return ResponseData.of(div).setState(DBC4220011StateName.標準);
    }

    /**
     * 「追加する」ボタン押下の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnAdd(
            ShokanShikyuGendogakuMainDiv div) {
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態５();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の「修正」が選択状態の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnModify(
            ShokanShikyuGendogakuMainDiv div) {
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態３();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の「削除」が選択状態の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnDelete(
            ShokanShikyuGendogakuMainDiv div) {
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態４();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力を破棄する」ボタンクリック時の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnCancel(
            ShokanShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            ShokanShikyuGendogakuMainHandler handler = getHandler(div);
            handler.状態１画面制御();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンクリック時の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onClick_btnUpdate(
            ShokanShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        ShokanShikyuGendogakuMainHandler handler = getHandler(div);

        ShokanShuruiShikyuGendoGakuHolder 償還 = ViewStateHolder.get(
                ViewStateKeys.償還払い給付種類支給限度額, ShokanShuruiShikyuGendoGakuHolder.class);
        UwanoseShokanShuruiShikyuGendoGakuHolder 上乗せ償還 = ViewStateHolder.get(
                ViewStateKeys.上乗せ償還払い給付種類支給限度額, UwanoseShokanShuruiShikyuGendoGakuHolder.class);

        List<ShokanShuruiShikyuGendoGaku> 償還list = 償還.getShokanShuruiShikyuGendoGakuList();
        List<UwanoseShokanShuruiShikyuGendoGaku> 上乗せ償還list = 上乗せ償還.getuwanoseShokanShuruiShiList();

        if (!(div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                || div.getBtnCancel().isDisabled())) {
            ShokanShikyuGendogakuMainValidationHandler validationhandler = getValidatioHandler(div);
            ValidationMessageControlPairs 保存Pairs = validationhandler.validate保存する();
            if (保存Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(保存Pairs).respond();
            }
            handler.insertAndUpdate(償還list, 上乗せ償還list);
        }
        if (div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                && !div.getBtnCancel().isDisabled()) {
            handler.update(償還list, 上乗せ償還list);
        }
        if (div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                && div.getBtnCancel().isDisabled()) {
            handler.deleteAndUpdate(償還list, 上乗せ償還list);
        }
        div.getCcdKanryoMessage().setMessage(完了メッセージメイン, 省略_空, 省略_空, true);
        LockingKey key = new LockingKey(排他キー);
        RealInitialLocker.release(key);
        return ResponseData.of(div).setState(DBC4220011StateName.保存完了);
    }

    /**
     * 支給限度額テーブル区分onChangeの事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onChange_Kubun(
            ShokanShikyuGendogakuMainDiv div) {
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue())) {
            div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
            div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        }
        if (ShikyuGendogakuTableKubun.上乗せ後.get名称().equals(
                div.getShokanShikyuGendogakuShosai().getRadTableKubun().getSelectedValue())) {
            div.getShokanShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 状態遷移の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> onStateTransition(
            ShokanShikyuGendogakuMainDiv div) {
        if (CommonButtonHolder.isVisible(共通ボタン)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 状態遷移の事件です。
     *
     * @param div ShokanShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuGendogakuMainDiv> btn_Complete(
            ShokanShikyuGendogakuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(
                DBC4220011TransitionEventName.完了状態).respond();
    }

    private ShokanShikyuGendogakuMainHandler getHandler(ShokanShikyuGendogakuMainDiv div) {
        return ShokanShikyuGendogakuMainHandler.of(div);
    }

    private ShokanShikyuGendogakuMainValidationHandler getValidatioHandler(
            ShokanShikyuGendogakuMainDiv div) {
        return new ShokanShikyuGendogakuMainValidationHandler(div);
    }
}
