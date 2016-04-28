/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2040021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeiseiParamter;
import jp.co.ndensan.reams.db.dba.definition.core.tashichosonjushochitokureisyaidoteisei.TekiyouJouhou;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040021.DBA2040021StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040021.TajutokuIdoTeiseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2040021.TajutokuIdoTeiseiHandler;
import jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeisei;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 他市町村住所地特例者異動の訂正のコントローラです。
 *
 * @reamsid_L DBA-0401-030 duanzhanli
 */
public class TajutokuIdoTeisei {

    private static final LockingKey LOCKINGKEY = new LockingKey("TatokuIdoTeisei");
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());

    /**
     * 他市町村住所地特例者異動の訂正初期化の設定します。
     *
     * @param div 他市町村住所地特例者異動の訂正Div
     * @return ResponseData<TajutokuIdoTeiseiDiv>
     */
    public ResponseData<TajutokuIdoTeiseiDiv> onLoad(TajutokuIdoTeiseiDiv div) {
        getHandler(div).load(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(TajutokuIdoTeiseiErrorMessage.排他_他のユーザが使用中));
            div.setReadOnly(true);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).setState(DBA2040021StateName.初期状態);
    }

    /**
     * 保存するボタン押下、データがDBに更新します。
     *
     * @param requestDiv TajutokuIdoTeiseiDiv
     * @return ResponseData<TajutokuIdoTeiseiDiv>
     */
    public ResponseData<TajutokuIdoTeiseiDiv> onClick_btnUpdate(TajutokuIdoTeiseiDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(SYORIMESSAGE).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            set登録処理(requestDiv);
            RealInitialLocker.release(LOCKINGKEY);
            return ResponseData.of(requestDiv).setState(DBA2040021StateName.完了状態);
        }
        return ResponseData.of(requestDiv).respond();
    }

    private ResponseData<TajutokuIdoTeiseiDiv> set登録処理(TajutokuIdoTeiseiDiv requestDiv) {
        List<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki = requestDiv.getTajutokuIdoTeiseiIdoJoho().
                getCcdTaJushochiTokureishaKanri().get適用情報一覧();
        List<TekiyouJouhou> 適用情報グリッド = new ArrayList<>();
        for (dgJushochiTokureiRireki_Row dg : dgJushochiTokureiRireki) {
            if (!dg.getRowState().equals(RowState.Unchanged) && !dg.getRowState().equals(RowState.Deleted)) {
                TekiyouJouhou tekiyouJouhou = new TekiyouJouhou();
                tekiyouJouhou.set適用日(dg.getTekiyoYMD().getText());
                tekiyouJouhou.set解除日(dg.getKaijoYMD().getText());
                適用情報グリッド.add(tekiyouJouhou);
            }
        }
        TaShichosonJushochiTokureisyaIdoTeiseiParamter paramter = new TaShichosonJushochiTokureisyaIdoTeiseiParamter(
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード(),
                適用情報グリッド);
        if (適用情報グリッド != null && !適用情報グリッド.isEmpty()) {
            TaShichosonJushochiTokureisyaIdoTeisei.createInstance().is適用状態のチェック(paramter);
        }
        requestDiv.getTajutokuIdoTeiseiIdoJoho().getCcdTaJushochiTokureishaKanri().saveTaJushochiTokurei(
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        requestDiv.getTajutokuIdoTeiseiIdoJoho().getShisetsuIdoJoho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(requestDiv).setState(DBA2040021StateName.完了状態);
    }

    /**
     * 完了するボタンを押下します。
     *
     * @param requestDiv TajutokuIdoTeiseiDiv
     * @return ResponseData<TajutokuIdoTeiseiDiv>
     */
    public ResponseData<TajutokuIdoTeiseiDiv> onClick_btnComplete(TajutokuIdoTeiseiDiv requestDiv) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 対象者検索に戻るボタンを押下します。
     *
     * @param requestDiv TajutokuIdoTeiseiDiv
     * @return ResponseData<TajutokuIdoTeiseiDiv>
     */
    public ResponseData<TajutokuIdoTeiseiDiv> onClick_btnBack(TajutokuIdoTeiseiDiv requestDiv) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(requestDiv).respond();
    }

    private TajutokuIdoTeiseiHandler getHandler(TajutokuIdoTeiseiDiv div) {
        return new TajutokuIdoTeiseiHandler(div);
    }

    private static enum TajutokuIdoTeiseiErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private TajutokuIdoTeiseiErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
