/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2040021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei.ShisetsuNyutaishoData;
import jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeiseiParamter;
import jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei.TekiyouJouhou;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040021.DBA2040021StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040021.TajutokuIdoTeiseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2040021.TajutokuIdoTeiseiHandler;
import jp.co.ndensan.reams.db.dbz.service.core.tashichosonjushochitokureisyaidoteisei.TaShichosonJushochiTokureisyaIdoTeisei;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private final RString 削除 = new RString("削除");
    private static final QuestionMessage SYORIMESSAGE = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
            UrQuestionMessages.処理実行の確認.getMessage().evaluate());

    /**
     * 他市町村住所地特例者異動の訂正初期化の設定します。
     *
     * @param div 他市町村住所地特例者異動の訂正Div
     * @return ResponseData<TajutokuIdoTeiseiDiv>
     */
    public ResponseData<TajutokuIdoTeiseiDiv> onLoad(TajutokuIdoTeiseiDiv div) {
        RString 台帳種別 = new RString(DaichoType.他市町村住所地特例者.getコード().toString());
        getHandler(div).load(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード(), 台帳種別);
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
        List<dgJushochiTokureiRireki_Row> 適用情報一覧 = requestDiv.getTajutokuIdoTeiseiIdoJoho().
                getCcdTaJushochiTokureishaKanri().get適用情報一覧();
        List<TekiyouJouhou> 適用情報グリッド = new ArrayList<>();
        for (dgJushochiTokureiRireki_Row dg : 適用情報一覧) {
            if (!dg.getRowState().equals(RowState.Deleted)) {
                TekiyouJouhou tekiyouJouhou = new TekiyouJouhou();
                tekiyouJouhou.set適用日(nullCheck(dg.getTekiyoYMD().getValue()));
                tekiyouJouhou.set解除日(nullCheck(dg.getKaijoYMD().getValue()));
                適用情報グリッド.add(tekiyouJouhou);
            }
        }
        List<ShisetsuNyutaishoData> 入退所データリスト = new ArrayList<>();
        List<dgShisetsuNyutaishoRireki_Row> 施設入退所履歴一覧 = requestDiv.getTajutokuIdoTeiseiIdoJoho().
                getShisetsuIdoJoho().getCcdShisetsuNyutaishoRirekiKanri().get施設入退所履歴一覧();
        for (dgShisetsuNyutaishoRireki_Row dg : 施設入退所履歴一覧) {
            if (!削除.equals(dg.getState())) {
                ShisetsuNyutaishoData shisetsuNyutaishoData = new ShisetsuNyutaishoData();
                shisetsuNyutaishoData.set入所日(dg.getNyushoDate().getValue());
                shisetsuNyutaishoData.set退所日(dg.getTaishoDate().getValue());
                入退所データリスト.add(shisetsuNyutaishoData);
            }
        }
        TaShichosonJushochiTokureisyaIdoTeiseiParamter paramter = new TaShichosonJushochiTokureisyaIdoTeiseiParamter(
                入退所データリスト,
                適用情報グリッド);
        TaShichosonJushochiTokureisyaIdoTeisei.createInstance().is適用状態のチェック(paramter);
        requestDiv.getTajutokuIdoTeiseiIdoJoho().getCcdTaJushochiTokureishaKanri().saveTaJushochiTokurei(
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        requestDiv.getTajutokuIdoTeiseiIdoJoho().getShisetsuIdoJoho().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(requestDiv).setState(DBA2040021StateName.完了状態);
    }

    private RString nullCheck(RDate 日付) {
        RString 戻り値 = RString.EMPTY;
        if (日付 != null) {
            戻り値 = 日付.toDateString();
        }
        return 戻り値;
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
