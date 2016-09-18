/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2050021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.datagridTekiyoJogai_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021.DBA2050021StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021.DBA2050021TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021.TekiyoJogaishaIdoTeiseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2050021.TekiyoJogaishaIdoTeiseiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeiseiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeiseiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 適用除外者異動の訂正の取得処理。
 *
 * @reamsid_L DBA-0411-050 lizhuoxuan
 */
public class TekiyoJogaishaIdoTeisei {

    private static final LockingKey 前排他ロックキー = new LockingKey("TekiyoJogaiIdoTeisei");

    /**
     * 該当者検索画面でグリッドから対象者を選択した際に実行されます。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onLoad(TekiyoJogaishaIdoTeiseiDiv div) {
        new TekiyoJogaishaIdoTeiseiHandler(div).initLoad(
                ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShisetsuNyutaishoIdoErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象者検索に戻る」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonBack(TekiyoJogaishaIdoTeiseiDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBA2050021TransitionEventName.再検索する).respond();
    }

    /**
     * 「適用除外情報を保存する」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonUpdate(TekiyoJogaishaIdoTeiseiDiv div) {
        if (!is適用情報一覧変更(div) && !is施設入退所履歴一覧変更(div)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(
                        DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
        } else {
            if (is履歴期間重複(div)) {
                throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace("適用日", "解除日"));
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                一覧データの保存(div);
                RealInitialLocker.release(前排他ロックキー);
                div.getKaigoKanryoMessageJo().getCcdKaigoKanryoMessage().setSuccessMessage(
                        new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
                return ResponseData.of(div).setState(DBA2050021StateName.完了状態);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonUpdateDone(TekiyoJogaishaIdoTeiseiDiv div) {

        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBA2050021TransitionEventName.終了する).respond();
    }

    private boolean is履歴期間重複(TekiyoJogaishaIdoTeiseiDiv div) {
        TekiyoJogaishaIdoTeiseiFinder finder = new TekiyoJogaishaIdoTeiseiFinder();
        List<TekiyoJogaishaIdoTeiseiBusiness> entitylist = new ArrayList<>();
        for (datagridTekiyoJogai_Row row : div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().get適用情報一覧()) {
            TekiyoJogaishaIdoTeiseiBusiness entity = new TekiyoJogaishaIdoTeiseiBusiness(new RString(row.getRowState().toString()),
                    row.getTekiyoDate().getValue() == null ? FlexibleDate.EMPTY : new FlexibleDate(row.getTekiyoDate().getValue().toDateString()),
                    row.getKayijoDate().getValue() == null ? FlexibleDate.EMPTY : new FlexibleDate(row.getKayijoDate().getValue().toDateString())
                    );
            entitylist.add(entity);
        }
        return finder.checkTekiyoJogaiKikanByTeiseiMode(entitylist);
    }

    private boolean is適用情報一覧変更(TekiyoJogaishaIdoTeiseiDiv div) {
        List<datagridTekiyoJogai_Row> 適用情報一覧 = div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().get適用情報一覧();
        for (datagridTekiyoJogai_Row row : 適用情報一覧) {
            if (!RowState.Unchanged.equals(row.getRowState())) {
                return true;
            }
        }
        return false;
    }

    private boolean is施設入退所履歴一覧変更(TekiyoJogaishaIdoTeiseiDiv div) {
        List<dgShisetsuNyutaishoRireki_Row> 施設入退所履歴一覧 = div.getTekiyoJogaiJohoIchiran().
                getCcdShisetsuNyutaishoRirekiKanri().get施設入退所履歴一覧();
        for (dgShisetsuNyutaishoRireki_Row row : 施設入退所履歴一覧) {
            if (!RString.isNullOrEmpty(row.getState())) {
                return true;
            }
        }
        return false;
    }

    private void 一覧データの保存(TekiyoJogaishaIdoTeiseiDiv div) {
        if (is適用情報一覧変更(div)) {
            div.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().
                    saveTekiyoJogaisha(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        }
        if (is施設入退所履歴一覧変更(div)) {
            div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        }
    }

    private enum ShisetsuNyutaishoIdoErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShisetsuNyutaishoIdoErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
