/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021.DBA2050021StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2050021.TekiyoJogaishaIdoTeiseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2050021.TekiyoJogaishaIdoTeiseiHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 適用除外者異動の訂正の取得処理。
 *
 * @reamsid_L DBA-0411-050 lizhuoxuan
 */
public class TekiyoJogaishaIdoTeisei {

    private static final LockingKey 前排他ロックキー = new LockingKey("ShisetsuNyutaishoIdo");

    /**
     * 該当者検索画面でグリッドから対象者を選択した際に実行されます。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onLoad(TekiyoJogaishaIdoTeiseiDiv div) {
        ResponseData<TekiyoJogaishaIdoTeiseiDiv> response = new ResponseData<>();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.施設入退所履歴_識別コード, ShikibetsuCode.class);
        new TekiyoJogaishaIdoTeiseiHandler(div).initLoad(識別コード);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShisetsuNyutaishoIdoErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        } else {
            RealInitialLocker.lock(前排他ロックキー);
        }
        response.data = div;
        return response;
    }

    /**
     * 「対象者検索に戻る」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonBack(TekiyoJogaishaIdoTeiseiDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).respond();
    }

    /**
     * 「適用除外情報を保存する」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonUpdate(TekiyoJogaishaIdoTeiseiDiv div) {
//        if (is履歴期間重複(div)) {
//            throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace("入所日").replace("退所日"));
//        }
        div.getTekiyoJogaiJohoIchiran().getShisetsuHenkoJohoInput().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
        RealInitialLocker.release(前排他ロックキー);
        div.getKaigoKanryoMessageJo().getCcdKaigoKanryoMessage().setSuccessMessage(
                new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        return ResponseData.of(div).setState(DBA2050021StateName.完了状態);
    }

    /**
     * 「完了」ボタンを押下します。
     *
     * @param div 適用除外者異動の訂正Div
     * @return レスポンス
     */
    public ResponseData onClick_commonButtonUpdateDone(TekiyoJogaishaIdoTeiseiDiv div) {

        RealInitialLocker.release(前排他ロックキー);
        onLoad(div);
        return ResponseData.of(div).setState(DBA2050021StateName.初期状態);
    }

//    private boolean is履歴期間重複(TekiyoJogaishaIdoTeiseiDiv div) {
//        jp.co.ndensan.reams.db.dbz.service.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeisei finder = new jp.co.ndensan.reams.db.dbz.service.core.tekiyojogaishaidoteisei.TekiyoJogaishaIdoTeisei();
//        for (dgShisetsuNyutaishoRireki_Row row : div.getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri().get施設入退所履歴一覧()) {
//            if (finder.isRirekiKikanJufukuFlag(row.getNyushoDate().getValue(), row.getTaishoDate().getValue(), row.getShisetsuShuruiKey())) {
//                return true;
//            }
//        }
//        return false;
//    }
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
