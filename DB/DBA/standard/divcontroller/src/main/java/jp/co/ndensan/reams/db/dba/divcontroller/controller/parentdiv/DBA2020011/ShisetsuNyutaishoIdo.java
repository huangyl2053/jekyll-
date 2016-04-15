package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2020011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.DBA2020011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2020011.ShisetsuNyutaishoIdoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2020011.ShisetsuNyutaishoIdoHandler;
import jp.co.ndensan.reams.db.dba.service.core.nyutaishoshakanri.NyutaishoshaKanriFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 施設入退所異動Divのコントローラです。QA-1017確認中 王暁冬 2016/04/01
 *
 * @reamsid_L DBA-0360-040 wangxiaodong
 */
public class ShisetsuNyutaishoIdo {

    private static final LockingKey 前排他ロックキー = new LockingKey("ShisetsuNyutaishoIdo");

    /**
     * 該当者検索画面でグリッドから対象者を選択した際に実行されます。
     *
     * @param div 施設入退所異動Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuNyutaishoIdoDiv> onLoad(ShisetsuNyutaishoIdoDiv div) {
        ResponseData<ShisetsuNyutaishoIdoDiv> response = new ResponseData<>();

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.施設入退所履歴_識別コード, ShikibetsuCode.class);
        new ShisetsuNyutaishoIdoHandler(div).initLoad(識別コード);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        } else {
            RealInitialLocker.lock(前排他ロックキー);
        }
        response.data = div;
        return response;
    }

    /**
     * 「対象者検索に戻る」ボタンを押下します。
     *
     * @param div 施設入退所異動Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuNyutaishoIdoDiv> onClick_commonButtonBack(ShisetsuNyutaishoIdoDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).respond();
    }

    /**
     * 「資格情報を保存する」ボタンを押下します。
     *
     * @param div 施設入退所異動Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuNyutaishoIdoDiv> onClick_commonButtonUpdate(ShisetsuNyutaishoIdoDiv div) {
        if (is履歴期間重複(div)) {
            throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace("入所日", "退所日"));
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
            RealInitialLocker.release(前排他ロックキー);
            div.getKaigoKanryoMessageOya().getCcdKaigoKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBA2020011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 完了」ボタンを押下します。
     *
     * @param div 施設入退所異動Div
     * @return レスポンス
     */
    public ResponseData<ShisetsuNyutaishoIdoDiv> onClick_commonButtonUpdateDone(ShisetsuNyutaishoIdoDiv div) {

        RealInitialLocker.release(前排他ロックキー);
        onLoad(div);
        return ResponseData.of(div).setState(DBA2020011StateName.初期状態);
    }

    private boolean is履歴期間重複(ShisetsuNyutaishoIdoDiv div) {
        NyutaishoshaKanriFinder finder = NyutaishoshaKanriFinder.createInstance();
        for (dgShisetsuNyutaishoRireki_Row row : div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().get施設入退所履歴一覧()) {
            if (finder.isRirekiKikanJufukuFlag(row.getNyushoDate().getValue(), row.getTaishoDate().getValue(), row.getShisetsuShuruiKey())) {
                return true;
            }
        }
        return false;
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
