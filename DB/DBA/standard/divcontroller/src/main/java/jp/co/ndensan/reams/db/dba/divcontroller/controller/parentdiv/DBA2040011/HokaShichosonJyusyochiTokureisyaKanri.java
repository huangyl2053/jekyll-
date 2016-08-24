/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2040011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisya.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.DBA2040011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.DBA2040011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.HokaShichosonJyusyochiTokureisyaKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2040011.HokaShichosonJyusyochiTokureisyaKanriHandler;
import jp.co.ndensan.reams.db.dba.service.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 他市町村住所地特例者管理のクラスです。
 *
 * @reamsid_L DBA-0400-100 yaodongsheng
 */
public class HokaShichosonJyusyochiTokureisyaKanri {

    private static final RString メニューID_転入転出保留対象者管理 = new RString("DBAMN61002");
    private static final RString メニューID_施設入所により適用 = new RString("DBAMN31001");
    private static final RString メニューID_施設退所により解除 = new RString("DBAMN31002");
    private static final RString メニューID_施設変更により変更 = new RString("DBAMN31003");
    private static final RString 遷移モード_施設入所により適用 = new RString("Tekiyo");
    private static final RString 遷移モード_施設退所により解除 = new RString("Kaijyo");
    private static final RString 遷移モード_施設変更により変更 = new RString("ShisetuHenko");
    private static final RString PARAMETER = new RString("対象者検索");
    private static final RString SHINKI = new RString("新規");
    private static final RString SYUSEI = new RString("修正");
    private static final RString 新規 = new RString("Added");
    private static final RString 修正 = new RString("Modified");
    private static final RString TSUIKA = new RString("追加");
    private static final RString KOSHIN = new RString("修正");
    private static final RString SAKUJYO = new RString("削除");
    private static final RString ROOTTITLE = new RString("他市町村住所地特例異動の保存処理が完了しました。");
    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("TatokuIdoKanri"));
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());

    /**
     * 他市町村住所地特例者管理の初期化です。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onLoad(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RString menuId = ResponseHolder.getMenuID();
        div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().set状態(getMode().get(menuId));
        getHandler(div).onLoad(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(TekiyoJogaiTotalErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (メニューID_施設入所により適用.equals(menuId) || メニューID_転入転出保留対象者管理.equals(menuId)) {
            if (!div.getCddTaJushochiTokureishaKanri().get適用情報一覧().isEmpty()
                    && div.getCddTaJushochiTokureishaKanri().get適用情報一覧().get(0).getKaijoTodokedeYMD().getValue() == null) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
            }
            return ResponseData.of(div).setState(DBA2040011StateName.追加適用);
        } else if (メニューID_施設退所により解除.equals(menuId)) {
            if (!div.getCddTaJushochiTokureishaKanri().get適用情報一覧().isEmpty()
                    && div.getCddTaJushochiTokureishaKanri().get適用情報一覧().get(0).getKaijoTodokedeYMD().getValue() != null) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
            }
            return ResponseData.of(div).setState(DBA2040011StateName.追加解除);
        } else if (メニューID_施設変更により変更.equals(menuId)) {
            div.getCddShisetsuNyutaishoRirekiKanri().initialize(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
            return ResponseData.of(div).setState(DBA2040011StateName.追加変更);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者管理の「該当者一覧へ戻る」ボタンを押下しです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_Return(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBA2040011TransitionEventName.再検索).respond();
    }

    /**
     * 他市町村住所地特例者管理の「完了する」ボタンを押下しです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_Kanryo(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者管理の保存ボタンをです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_Hozon(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        if (ResponseHolder.isReRequest() && new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        RString menuId = ResponseHolder.getMenuID();
        if (((メニューID_施設入所により適用.equals(menuId) || メニューID_転入転出保留対象者管理.equals(menuId)
                || メニューID_施設退所により解除.equals(menuId))
                && (div.getCddTaJushochiTokureishaKanri().get適用情報一覧().isEmpty()
                || RowState.Unchanged.equals(div.getCddTaJushochiTokureishaKanri().get適用情報一覧().get(0).getRowState())))
                || (メニューID_施設変更により変更.equals(menuId) && !get変更(div))) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            set処理実行(div);
            RealInitialLocker.release(LOCKINGKEY);
            div.getCcdKaigoKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBA2040011StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 他市町村住所地特例者管理の再検索ボタンをです。
     *
     * @param div HokaShichosonJyusyochiTokureisyaKanriDiv
     * @return HokaShichosonJyusyochiTokureisyaKanriDiv
     */
    public ResponseData<HokaShichosonJyusyochiTokureisyaKanriDiv> onClick_btnReSearch(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBA2040011TransitionEventName.再検索).parameter(PARAMETER);
    }

    private Map<RString, RString> getMode() {
        Map<RString, RString> mode = new HashMap<>();
        mode.put(メニューID_転入転出保留対象者管理, 遷移モード_施設入所により適用);
        mode.put(メニューID_施設入所により適用, 遷移モード_施設入所により適用);
        mode.put(メニューID_施設退所により解除, 遷移モード_施設退所により解除);
        mode.put(メニューID_施設変更により変更, 遷移モード_施設変更により変更);
        return mode;
    }

    private HokaShichosonJyusyochiTokureisyaKanriHandler getHandler(HokaShichosonJyusyochiTokureisyaKanriDiv requestDiv) {
        return new HokaShichosonJyusyochiTokureisyaKanriHandler(requestDiv);
    }

    private void set処理実行(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        TaJushochiTokureisyaKanriManager manager = TaJushochiTokureisyaKanriManager.createInstance();
        List<TaJushochiTokureisyaKanriParameter> paramaterList = new ArrayList<>();
        for (dgJushochiTokureiRireki_Row row : div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().get適用情報一覧()) {
            TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他市町村住所地特例者管理(
                    row.getNyushoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getNyushoYMD().getValue().toDateString()),
                    row.getTaishoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getTaishoYMD().getValue().toDateString()),
                    row.getKaijoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getKaijoYMD().getValue().toDateString()),
                    row.getTekiyoYMD().getValue() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()),
                    new RString(row.getRowState().toString()));
            paramaterList.add(parameter);
        }
        RString menuId = ResponseHolder.getMenuID();
        if (メニューID_施設入所により適用.equals(menuId)) {
            set適用(paramaterList);
            manager.checkTekiyouJotai(paramaterList);
        } else if (メニューID_施設退所により解除.equals(menuId)) {
            set解除(paramaterList);
            manager.checkKaijoJotai(paramaterList);
        } else if (メニューID_施設変更により変更.equals(menuId)) {
            manager.checkHenkoJotai(paramaterList);
        }
        if (メニューID_施設入所により適用.equals(menuId) || メニューID_転入転出保留対象者管理.equals(menuId)
                || メニューID_施設退所により解除.equals(menuId)) {
            div.getShikakuKihonJoho().getCddTaJushochiTokureishaKanri().saveTaJushochiTokurei(
                    ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        }
        if (メニューID_施設変更により変更.equals(menuId)) {
            div.getCddShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        }
    }

    private void set適用(List<TaJushochiTokureisyaKanriParameter> paramaterList) {
        if (!paramaterList.isEmpty()) {
            TaJushochiTokureisyaKanriParameter parameter1 = paramaterList.get(0);
            TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他市町村住所地特例者管理(
                    parameter1.getNyuusyoYMD(), parameter1.getTayishoYMD(), parameter1.getKaijoYMD(), parameter1.getTekiyoYMD(), SHINKI
            );
            paramaterList.set(0, parameter);
        }
    }

    private void set解除(List<TaJushochiTokureisyaKanriParameter> paramaterList) {
        if (!paramaterList.isEmpty()) {
            TaJushochiTokureisyaKanriParameter parameter1 = paramaterList.get(0);
            TaJushochiTokureisyaKanriParameter parameter = TaJushochiTokureisyaKanriParameter.createParamBy他市町村住所地特例者管理(
                    parameter1.getNyuusyoYMD(), parameter1.getTayishoYMD(), parameter1.getKaijoYMD(), parameter1.getTekiyoYMD(), SYUSEI
            );
            paramaterList.set(0, parameter);
        }
    }

    private boolean get変更(HokaShichosonJyusyochiTokureisyaKanriDiv div) {
        boolean henko = false;
        for (dgShisetsuNyutaishoRireki_Row row : div.getCddShisetsuNyutaishoRirekiKanri().get施設入退所履歴一覧()) {
            if (TSUIKA.equals(row.getState()) || KOSHIN.equals(row.getState())
                    || SAKUJYO.equals(row.getState())) {
                henko = true;
                break;
            }
        }
        return henko;
    }

    private enum TekiyoJogaiTotalErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private TekiyoJogaiTotalErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
