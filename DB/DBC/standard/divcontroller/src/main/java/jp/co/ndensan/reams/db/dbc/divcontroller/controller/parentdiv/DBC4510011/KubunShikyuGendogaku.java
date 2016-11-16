/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.DBC4510011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.DBC4510011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.KubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.dgServiceShurui_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011.KubunShikyuGendogakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011.KubunShikyuGendogakuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kubunshikyugendogaku.KubunShikyuGendogakuManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiHolder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * サービス種類登録です。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogaku {

    private static final RString MESSAGEMAIN = new RString("サービス種類の登録が完了しました。");
    private static final RString MESSAGETAISHO1 = new RString("サービス種類コード：");
    private static final RString MESSAGETAISHO2 = new RString("サービス名称：");
    private static final RString DBCKAIGOSERVICETABLEDBT7130 = new RString("DBCKaigoServiceTableDbT7130");
    private static final RString COLON = new RString("：");
    private static final RString ZERO = new RString("0");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KubunShikyuGendogakuDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onLoad(KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        RString 前排他キー = DBCKAIGOSERVICETABLEDBT7130;
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        div.getDgServiceShurui().init();
        handler.initialDisable(false);
        List<KeyValueDataSource> list = new ArrayList<>();
        for (ServiceBunrui serviceBunrui : ServiceBunrui.values()) {
            RString コード = serviceBunrui.getコード();
            if (コード.length() == 1) {
                コード = ZERO.concat(コード);
            }
            list.add(new KeyValueDataSource(serviceBunrui.getコード(), コード.concat(COLON).concat(serviceBunrui.get名称())));
        }
        div.getServiceShuruiShousai().getDdlServiceBunruiCode().setDataSource(list);
        handler.setServiceShuruiShousaiEnable(true);
        handler.clearValue();
        handler.setCommonButtonVisible(false);
        KubunShikyuGendogakuManager manager = InstanceProvider.create(KubunShikyuGendogakuManager.class);
        List<KaigoServiceShurui> businessList = manager.getサービス種類登録();
        ViewStateHolder.put(ViewStateKeys.介護サービス種類データ, new KaigoServiceShuruiHolder(businessList));
        if (!businessList.isEmpty()) {
            handler.initializeDgList(businessList);
        }
        if (div.getBtnTsuika().isDisabled()) {
            onSelect_Back(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * Dgdの修正ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Modify(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        dgServiceShurui_Row row = div.getDgServiceShurui().getClickedItem();
        handler.setServiceShuruiShousaiEnable(false);
        div.getServiceShuruiShousai().getTxtServiceCode().setDisabled(true);
        div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().setDisabled(true);
        div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().setDisabled(true);
        handler.setDisable();
        handler.modify(row);
        handler.setCommonButtonVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 追加するボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Add(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        handler.setServiceShuruiShousaiEnable(false);
        div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().setDisabled(true);
        handler.setDisable();
        handler.setCommonButtonVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Delete(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        dgServiceShurui_Row row = div.getDgServiceShurui().getClickedItem();
        handler.modify(row);
        handler.setServiceShuruiShousaiEnable(true);
        handler.setDisable();
        handler.setCommonButtonVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 入力前の状態に戻る ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Back(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest() && !div.getServiceShuruiShousai().getDdlServiceBunruiCode().isDisabled()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || div.getServiceShuruiShousai().getDdlServiceBunruiCode().isDisabled()) {
            handler.setEnable();
            handler.clearValue();
            handler.setServiceShuruiShousaiEnable(true);
            handler.setCommonButtonVisible(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンクリック時のボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Save(
            KubunShikyuGendogakuDiv div) {
        KubunShikyuGendogakuValidationHandler validationHander = getValidationHandler(div);
        ValidationMessageControlPairs pairs = validationHander.validate();
        if (pairs.iterator().hasNext() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest() && !div.getServiceShuruiShousai().getDdlServiceBunruiCode().isDisabled()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (!ResponseHolder.isReRequest() && div.getServiceShuruiShousai().getDdlServiceBunruiCode().isDisabled()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            KubunShikyuGendogakuHandler handler = getHandler(div);
            KaigoServiceShuruiHolder holder = ViewStateHolder.get(ViewStateKeys.介護サービス種類データ, KaigoServiceShuruiHolder.class);
            KubunShikyuGendogakuManager manager = InstanceProvider.create(KubunShikyuGendogakuManager.class);
            RString サービス種類コード = div.getServiceShuruiShousai().getTxtServiceCode().getValue();
            RString 提供開始年月 = div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().getValue().getYearMonth().toDateString();
            KaigoServiceShuruiIdentifier identifier = new KaigoServiceShuruiIdentifier(
                    new ServiceShuruiCode(サービス種類コード), new FlexibleYearMonth(提供開始年月));
            KaigoServiceShurui result = holder.getKogakuGassanJikoFutanGaku(identifier);
            List<KaigoServiceShurui> list = holder.getKaigoServiceShuruiList();
            if (result == null) {
                result = new KaigoServiceShurui(
                        new ServiceShuruiCode(サービス種類コード), new FlexibleYearMonth(提供開始年月));
                result = handler.setResult追加(result);
                manager.save(result, Boolean.TRUE);
                追加(list, サービス種類コード, result, manager);
            } else {
                if (div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().isDisabled()
                        && div.getServiceShuruiShousai().getTxtServiceMeisho().isDisabled()) {
                    削除(list, サービス種類コード, result, manager);
                } else {
                    result = handler.setResult修正(result);
                    manager.save(result, Boolean.FALSE);
                }
            }
            前排他キーの解除();
            RString messageTaisho1 = MESSAGETAISHO1.concat(div.getServiceShuruiShousai().getTxtServiceCode().getValue());
            RString messageTaisho2 = MESSAGETAISHO2.concat(div.getServiceShuruiShousai().getTxtServiceMeisho().getValue());
            div.getKanryo().getKanryoMessage().setSuccessMessage(MESSAGEMAIN, messageTaisho1, messageTaisho2);
            return ResponseData.of(div).setState(DBC4510011StateName.完了状態);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「サービス種類登録に戻る」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Return(
            KubunShikyuGendogakuDiv div) {
        onLoad(div);
        return ResponseData.of(div).setState(DBC4510011StateName.初期状態);
    }

    /**
     * 「サービス種類登録に戻る」ボタン表示制御を設定です。
     *
     * @param div KubunShikyuGendogakuDiv
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onStateTransition(
            KubunShikyuGendogakuDiv div) {
        getHandler(div).setサービス種類登録に戻るする();
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<KubunShikyuGendogakuDiv> onSelect_Compelete(
            KubunShikyuGendogakuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC4510011TransitionEventName.処理完了).respond();
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     */
    public void 前排他キーの解除() {
        LockingKey 排他キー = new LockingKey(DBCKAIGOSERVICETABLEDBT7130);
        RealInitialLocker.release(排他キー);
    }

    private void 削除(List<KaigoServiceShurui> list, RString サービス種類コード, KaigoServiceShurui result, KubunShikyuGendogakuManager manager) {
        manager.データを物理削除する(result.toEntity());
        for (KaigoServiceShurui lastResult : list) {
            if (new ServiceShuruiCode(サービス種類コード).equals(lastResult.getサービス種類コード())
                    && (result.get提供開始年月().minusMonth(1).equals(lastResult.get提供終了年月()))) {
                lastResult = lastResult.createBuilderForEdit()
                        .set提供終了年月(new FlexibleYearMonth(RString.EMPTY)).build();
                manager.save(lastResult, Boolean.FALSE);
            }
        }
    }

    private void 追加(List<KaigoServiceShurui> list, RString サービス種類コード, KaigoServiceShurui result, KubunShikyuGendogakuManager manager) {
        for (KaigoServiceShurui lastResult : list) {
            if (new ServiceShuruiCode(サービス種類コード).equals(lastResult.getサービス種類コード())
                    && (lastResult.get提供終了年月() == null || lastResult.get提供終了年月().isEmpty())) {
                lastResult = lastResult.createBuilderForEdit()
                        .set提供終了年月(result.get提供開始年月().minusMonth(1)).build();
                manager.save(lastResult, Boolean.FALSE);
            }
        }
    }

    private KubunShikyuGendogakuHandler getHandler(KubunShikyuGendogakuDiv div) {
        return new KubunShikyuGendogakuHandler(div);
    }

    private KubunShikyuGendogakuValidationHandler getValidationHandler(KubunShikyuGendogakuDiv div) {
        return new KubunShikyuGendogakuValidationHandler(div);
    }
}
