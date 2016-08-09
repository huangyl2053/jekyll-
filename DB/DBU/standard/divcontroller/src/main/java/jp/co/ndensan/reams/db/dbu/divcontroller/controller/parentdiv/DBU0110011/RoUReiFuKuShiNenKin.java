/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0110011;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011.DBU0110011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011.DBU0110011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011.RoUReiFuKuShiNenKinDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 老齢福祉年金受給者管理のクラスです。
 *
 * @reamsid_L DBA-1120-030 houtianpeng
 */
public class RoUReiFuKuShiNenKin {

    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("RoreiFukushiNenkin"));

    /**
     * 画面の初期化処理。
     *
     * @param div RoUReiFuKuShiNenKinDiv
     * @return ResponseData<RoUReiFuKuShiNenKinDiv>
     */
    public ResponseData<RoUReiFuKuShiNenKinDiv> onLoad(RoUReiFuKuShiNenKinDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class);
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(DBU0110011TransitionEventName.一覧戻る).respond();
        }
        if (key == null) {
            div.getKihonJoho().getCcdKaigoAtenaInfo().setDisabled(true);
            div.getKihonJoho().getCcdKaigoShikakuKihon().setDisabled(true);
            div.getRoreiFukushiNenkinJohoList().setDisplayNone(true);
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }

        ShikibetsuCode 識別コード = key.get識別コード();
        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getKihonJoho().getCcdKaigoShikakuKihon().initialize(識別コード);

        HihokenshaNo 被保険者番号 = key.get被保険者番号();
        div.getRoreiFukushiNenkinJohoList().getCcdRoreiFukushiNenkinRireki().initialize(識別コード, 被保険者番号);

        AccessLogger.log(AccessLogType.照会, key.toPersonalDataWithHihokenshaNo());

        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }

        return ResponseData.of(div).setState(DBU0110011StateName.初期状態);
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div RoUReiFuKuShiNenKinDiv
     * @return ResponseData<RoUReiFuKuShiNenKinDiv>
     */
    public ResponseData<RoUReiFuKuShiNenKinDiv> onClick_Save(final RoUReiFuKuShiNenKinDiv div) {
        if (!ResponseHolder.isReRequest()) {
            boolean hasChanged = div.getRoreiFukushiNenkinJohoList()
                    .getCcdRoreiFukushiNenkinRireki()
                    .hasChanged();
            return hasChanged
                   ? ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond()
                   : ResponseData.of(div).addValidationMessages(
                    new ValidationMessageControlPairs() {
                        {
                            add(new ValidationMessageControlPair(
                                            TekiyoJogaiTotalErrorMessage.編集なしで更新不可,
                                            div.getRoreiFukushiNenkinJohoList()
                                    ));
                        }
                    }).respond();
        }

        if (Objects.equals(ResponseHolder.getMessageCode(),
                new RString(UrQuestionMessages.保存の確認.getMessage().getCode()))) {
            return onClick_Save_保存の確認(div);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<RoUReiFuKuShiNenKinDiv> onClick_Save_保存の確認(final RoUReiFuKuShiNenKinDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        div.getRoreiFukushiNenkinJohoList().getCcdRoreiFukushiNenkinRireki().click_Save();
        RealInitialLocker.release(LOCKINGKEY);
        AccessLogger.log(AccessLogType.更新, ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).toPersonalDataWithHihokenshaNo());
        div.getKihonJoho().getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(
                new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
        return ResponseData.of(div).setState(DBU0110011StateName.完了状態);
    }

    /**
     * 「再検索する」ボタンを押下する。
     *
     * @param div RoUReiFuKuShiNenKinDiv
     * @return ResponseData<RoUReiFuKuShiNenKinDiv>
     */
    public ResponseData<RoUReiFuKuShiNenKinDiv> onClick_btnSearch(RoUReiFuKuShiNenKinDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBU0110011TransitionEventName.再検索).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンを押下する。
     *
     * @param div RoUReiFuKuShiNenKinDiv
     * @return ResponseData<RoUReiFuKuShiNenKinDiv>
     */
    public ResponseData<RoUReiFuKuShiNenKinDiv> onClick_btnSearchiLan(RoUReiFuKuShiNenKinDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBU0110011TransitionEventName.一覧戻る).respond();
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div RoUReiFuKuShiNenKinDiv
     * @return ResponseData<RoUReiFuKuShiNenKinDiv>
     */
    public ResponseData<RoUReiFuKuShiNenKinDiv> onClick_btnComplete(RoUReiFuKuShiNenKinDiv div) {
        RealInitialLocker.release(LOCKINGKEY);
        return ResponseData.of(div).forwardWithEventName(DBU0110011TransitionEventName.完了する).respond();
    }

    private enum TekiyoJogaiTotalErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中),
        編集なしで更新不可(UrErrorMessages.編集なしで更新不可);
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
