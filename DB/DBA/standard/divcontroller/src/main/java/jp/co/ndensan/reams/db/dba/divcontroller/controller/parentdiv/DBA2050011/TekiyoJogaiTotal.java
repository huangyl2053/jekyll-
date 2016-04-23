/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2050011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011.DBA2050011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011.DBA2050011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050011.TekiyoJogaiTotalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2050011.TekiyoJogaiTotalHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 適用除外者管理のクラス。
 *
 * @reamsid_L DBA-0410-080 dingyi
 */
public class TekiyoJogaiTotal {

    private static final LockingKey 前排他ロックキー = new LockingKey("TekiyoJogaiIdoKanri");
    private static final RString 遷移元メニューID_適用 = new RString("DBAMN32001");
    private static final RString 遷移元メニューID_解除 = new RString("DBAMN32002");
    private static final RString 遷移元メニューID_変更 = new RString("DBAMN32003");

    /**
     * 適用除外者管理に初期化を設定します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return レスポンス
     */
    public ResponseData onLoad(TekiyoJogaiTotalDiv requestDiv) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.該当者検索_識別コード, ShikibetsuCode.class);
        RString menuId = ResponseHolder.getMenuID();
        getHandler(requestDiv).initialize(識別コード, menuId);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            requestDiv.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(TekiyoJogaiTotal.TekiyoJogaiTotalErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
        }
        if (遷移元メニューID_適用.equals(menuId)) {
            return ResponseData.of(requestDiv).setState(DBA2050011StateName.適用状態);
        } else if (遷移元メニューID_解除.equals(menuId)) {
            return ResponseData.of(requestDiv).setState(DBA2050011StateName.解除状態);
        } else if (遷移元メニューID_変更.equals(menuId)) {
            return ResponseData.of(requestDiv).setState(DBA2050011StateName.変更状態);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「対象者検索に戻る」ボタンを押下して、対象者検索画面に戻る。
     *
     * @param requestDiv 適用除外者管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnBack(TekiyoJogaiTotalDiv requestDiv) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(requestDiv).forwardWithEventName(DBA2050011TransitionEventName.検索に戻る).respond();
    }

    /**
     * 「適用除外情報を保存する」ボタンを押下します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdate(TekiyoJogaiTotalDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(requestDiv).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, ShikibetsuCode.class);
            RString menuId = ResponseHolder.getMenuID();
            if (遷移元メニューID_適用.equals(menuId) || 遷移元メニューID_解除.equals(menuId)) {
                requestDiv.getTekiyoJogaiJohoIchiran().getCcdTekiyoJogaiRireki().saveTekiyoJogaisha(識別コード);
            } else if (遷移元メニューID_変更.equals(menuId)) {
                requestDiv.getTekiyoJogaiJohoIchiran().getCddShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
            }
            RealInitialLocker.release(前排他ロックキー);
            requestDiv.getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(requestDiv).setState(DBA2050011StateName.完了状態);
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「完了」ボタンを押下します。
     *
     * @param requestDiv 適用除外者管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnComplete(TekiyoJogaiTotalDiv requestDiv) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(requestDiv).forwardWithEventName(DBA2050011TransitionEventName.完了).respond();
    }

    private TekiyoJogaiTotalHandler getHandler(TekiyoJogaiTotalDiv requestDiv) {
        return new TekiyoJogaiTotalHandler(requestDiv);
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
