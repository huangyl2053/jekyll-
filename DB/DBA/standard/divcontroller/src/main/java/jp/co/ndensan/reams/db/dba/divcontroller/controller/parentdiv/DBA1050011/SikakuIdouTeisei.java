/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1050011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.DBA1050011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.DBA1050011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.SikakuIdouTeiseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050011.SikakuIdouTeiseiHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 資格異動訂正の画面処理クラスです。
 *
 * @reamsid_L DBA-0521-010 dongyabin
 */
public class SikakuIdouTeisei {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_照会 = new RString("照会");

    /**
     * 画面を初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onLoad(SikakuIdouTeiseiDiv div) {
        getHandler(div).onLoad();
        // TODO 処理詳細シート「３．　前排他制御」を参照
        return ResponseData.of(div).respond();
    }

    /**
     * 追加するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Add(SikakuIdouTeiseiDiv div) {
        getHandler(div).setパラメータ(状態_追加);
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.追加).respond();
    }

    /**
     * 修正するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Update(SikakuIdouTeiseiDiv div) {
        getHandler(div).setパラメータ(状態_修正);
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.修正).respond();
    }

    /**
     * 削除するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Delete(SikakuIdouTeiseiDiv div) {
        getHandler(div).setパラメータ(状態_削除);
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.削除).respond();
    }

    /**
     * 詳細するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Syoukai(SikakuIdouTeiseiDiv div) {
        getHandler(div).setパラメータ(状態_照会);
        return ResponseData.of(div).forwardWithEventName(DBA1050011TransitionEventName.詳細).respond();
    }

    /**
     * 「資格情報を保存する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<SikakuIdouTeiseiDiv>
     */
    public ResponseData<SikakuIdouTeiseiDiv> onClick_Save(SikakuIdouTeiseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save();
        }
        // TODO 前排他ロック解除
        return ResponseData.of(div).setState(DBA1050011StateName.完了状態);
    }

    private SikakuIdouTeiseiHandler getHandler(SikakuIdouTeiseiDiv div) {
        return new SikakuIdouTeiseiHandler(div);
    }
}
