/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4200011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.UwanoseKubunShikyuGendoGakuHolder;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyugendogaku.ShikyuGendogakuTableKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.DBC4200011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.DBC4200011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.KubunShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4200011.KubunShikyuGendogakuMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4200011.KubunShikyuGendogakuMainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.UwanoseKubunShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KubunShikyuGendoGakuHolder;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KubunShikyuGendoGakuManager;
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
 * 区分支給限度額登録のクラスです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuMain {

    private static final RString 排他キー = new RString("DBCShikyuGendoGakuTableDbT7109");
    private static final RString 完了メッセージメイン = new RString("区分支給限度額の登録が完了しました。");
    private static final RString 省略_空 = new RString("");
    private static final RString 共通ボタン = new RString("btnUpdate");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onLoad(KubunShikyuGendogakuMainDiv div) {
        div.getKubunShikyuGendogakuIchiran().setDisabled(true);

        LockingKey key = new LockingKey(排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        KubunShikyuGendoGakuManager 居宅manager = new KubunShikyuGendoGakuManager();
        List<KubunShikyuGendoGaku> 居宅List = 居宅manager.get居宅サービス区分支給限度額一覧データ();
        UwanoseKubunShikyuGendoGakuManager 上乗せ居宅manager = new UwanoseKubunShikyuGendoGakuManager();
        List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅List = 上乗せ居宅manager.get上乗せ居宅サービス区分支給限度額一覧データ();

        ViewStateHolder.put(ViewStateKeys.居宅サービス区分支給限度額,
                new KubunShikyuGendoGakuHolder(居宅List));
        ViewStateHolder.put(ViewStateKeys.上乗せ居宅サービス区分支給限度額,
                new UwanoseKubunShikyuGendoGakuHolder(上乗せ居宅List));

        KubunShikyuGendogakuMainHandler handler = getHandler(div);
        handler.initializeDisplay(居宅List, 上乗せ居宅List);

        return ResponseData.of(div).setState(DBC4200011StateName.標準);
    }

    /**
     * 「追加する」ボタン押下の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onClick_btnAdd(KubunShikyuGendogakuMainDiv div) {
        KubunShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態５();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の「修正」が選択状態の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onClick_btnModify(KubunShikyuGendogakuMainDiv div) {
        KubunShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態３();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧の「削除」が選択状態の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onClick_btnDelete(KubunShikyuGendogakuMainDiv div) {
        KubunShikyuGendogakuMainHandler handler = getHandler(div);
        handler.状態４();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力を破棄する」ボタンクリック時の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onClick_btnCancel(KubunShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            KubunShikyuGendogakuMainHandler handler = getHandler(div);
            handler.状態１画面制御();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンクリック時の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onClick_btnUpdate(KubunShikyuGendogakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        KubunShikyuGendogakuMainHandler handler = getHandler(div);

        KubunShikyuGendoGakuHolder 居宅 = ViewStateHolder.get(
                ViewStateKeys.居宅サービス区分支給限度額, KubunShikyuGendoGakuHolder.class);
        UwanoseKubunShikyuGendoGakuHolder 上乗せ居宅 = ViewStateHolder.get(
                ViewStateKeys.上乗せ居宅サービス区分支給限度額, UwanoseKubunShikyuGendoGakuHolder.class);

        List<KubunShikyuGendoGaku> 居宅HoldList = 居宅.getKubunShikyuGendoGakuList();
        List<UwanoseKubunShikyuGendoGaku> 上乗せ居宅HoldList = 上乗せ居宅.getUwanoseKubunShikyuGendoGakuList();

        if (!(div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                || div.getBtnCancel().isDisabled())) {
            KubunShikyuGendogakuMainValidationHandler validationhandler = getValidatioHandler(div);
            ValidationMessageControlPairs 保存Pairs = validationhandler.validate保存する();
            if (保存Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(保存Pairs).respond();
            }
            handler.insertAndUpdate(居宅HoldList, 上乗せ居宅HoldList);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                && !div.getBtnCancel().isDisabled()) {
            handler.update(居宅HoldList, 上乗せ居宅HoldList);
        }
        if (div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().isFromDisabled()
                && div.getBtnCancel().isDisabled()) {
            handler.deleteAndUpdate(居宅HoldList, 上乗せ居宅HoldList);
        }
        div.getCcdKaigoKanryoMessage().setMessage(完了メッセージメイン, 省略_空, 省略_空, true);
        LockingKey key = new LockingKey(排他キー);
        RealInitialLocker.release(key);
        return ResponseData.of(div).setState(DBC4200011StateName.保存完了);
    }

    /**
     * 支給限度額テーブル区分onChangeの事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onChange_Kubun(
            KubunShikyuGendogakuMainDiv div) {
        if (ShikyuGendogakuTableKubun.標準.get名称().equals(
                div.getKubunShikyuGendogakuShosai().getRadTableKubun().getSelectedValue())) {
            div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().clearToValue();
            div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(true);
        }
        if (ShikyuGendogakuTableKubun.上乗せ後.get名称().equals(
                div.getKubunShikyuGendogakuShosai().getRadTableKubun().getSelectedValue())) {
            div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange().setToDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 状態遷移の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> onStateTransition(
            KubunShikyuGendogakuMainDiv div) {
        if (CommonButtonHolder.isVisible(共通ボタン)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 状態遷移の事件です。
     *
     * @param div KubunShikyuGendogakuMainDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuMainDiv> btn_Complete(
            KubunShikyuGendogakuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(
                DBC4200011TransitionEventName.完了状態).respond();
    }

    private KubunShikyuGendogakuMainHandler getHandler(KubunShikyuGendogakuMainDiv div) {
        return KubunShikyuGendogakuMainHandler.of(div);
    }

    private KubunShikyuGendogakuMainValidationHandler getValidatioHandler(
            KubunShikyuGendogakuMainDiv div) {
        return new KubunShikyuGendogakuMainValidationHandler(div);
    }
}
