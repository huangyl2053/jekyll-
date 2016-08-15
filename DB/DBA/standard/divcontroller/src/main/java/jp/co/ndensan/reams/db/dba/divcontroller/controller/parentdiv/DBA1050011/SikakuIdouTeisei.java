/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1050011;

import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.SikakuIdouTeiseiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.DBA1050011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.DBA1050011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.SikakuIdouTeiseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050011.SikakuIdouTeiseiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格異動訂正の画面処理クラスです。
 *
 * @reamsid_L DBA-0521-010 dongyabin
 */
public class SikakuIdouTeisei {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_照会 = new RString("照会");
    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuIdoTeisei、HihokenshaNo");

    /**
     * 画面を初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onLoad(SikakuIdouTeiseiDiv div) {
        SikakuIdouTeiseiJoho joho = getHandler(div).onLoad(getKey().get被保険者番号(), getKey().get識別コード());
        ViewStateHolder.put(ViewStateKeys.初期化時医療保険情報, joho);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 追加するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Add(SikakuIdouTeiseiDiv div) {
        setParam(getKey(), 状態_追加);
        ViewStateHolder.put(ViewStateKeys.資格得喪情報, getHandler(div).setパラメータ(状態_追加));
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.追加).respond();
    }

    /**
     * 修正するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Update(SikakuIdouTeiseiDiv div) {
        setParam(getKey(), 状態_修正);
        ViewStateHolder.put(ViewStateKeys.資格得喪情報, getHandler(div).setパラメータ(状態_修正));
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.修正).respond();
    }

    /**
     * 削除するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Delete_bak(SikakuIdouTeiseiDiv div) {
        setParam(getKey(), 状態_削除);
        ViewStateHolder.put(ViewStateKeys.資格得喪情報, getHandler(div).setパラメータ(状態_削除));
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.削除).respond();
    }

    /**
     * 詳細するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Syoukai(SikakuIdouTeiseiDiv div) {
        setParam(getKey(), 状態_照会);
        ViewStateHolder.put(ViewStateKeys.資格得喪情報, getHandler(div).setパラメータ(状態_照会));
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.詳細).respond();
    }

    /**
     * 「資格情報を保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Save(SikakuIdouTeiseiDiv div) {
        SikakuIdouTeiseiJoho joho = ViewStateHolder.get(ViewStateKeys.初期化時医療保険情報, SikakuIdouTeiseiJoho.class);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save(getKey().get識別コード(), joho);
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(div).setState(DBA1050011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象者検索へ」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Modoru(SikakuIdouTeiseiDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.検索結果一覧へ).respond();
    }

    /**
     * 「再検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_btnResearch(SikakuIdouTeiseiDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.再検索).respond();
    }

    private void setParam(TaishoshaKey key, RString 状態) {
        ViewStateHolder.put(ViewStateKeys.識別コード, key.get識別コード());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, key.get被保険者番号());
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
    }

    private SikakuIdouTeiseiHandler getHandler(SikakuIdouTeiseiDiv div) {
        return new SikakuIdouTeiseiHandler(div);
    }

    private TaishoshaKey getKey() {
        return ViewStateHolder.get(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
    }

    private enum SikakuIdouTeiseiErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private SikakuIdouTeiseiErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
