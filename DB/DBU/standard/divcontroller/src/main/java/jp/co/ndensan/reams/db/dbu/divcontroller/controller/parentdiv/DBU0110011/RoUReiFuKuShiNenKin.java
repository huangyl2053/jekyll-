/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0110011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011.DBU0110011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011.DBU0110011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0110011.RoUReiFuKuShiNenKinDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.datagridRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 老齢福祉年金受給者管理のクラスです。
 *
 * @reamsid_L DBA-1120-030 houtianpeng
 */
public class RoUReiFuKuShiNenKin {

    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("RoreiFukushiNenkin"));
    private static final QuestionMessage HOZONMESSAGE = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
            UrQuestionMessages.保存の確認.getMessage().evaluate());

    /**
     * 画面の初期化処理。
     *
     * @param div RoUReiFuKuShiNenKinDiv
     * @return ResponseData<RoUReiFuKuShiNenKinDiv>
     */
    public ResponseData<RoUReiFuKuShiNenKinDiv> onLoad(RoUReiFuKuShiNenKinDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get被保険者番号();
        div.getKihonJoho().getCcdKaigoAtenaInfo().onLoad(識別コード);
        div.getKihonJoho().getCcdKaigoShikakuKihon().onLoad(識別コード);
        div.getRoreiFukushiNenkinJohoList().getCcdRoreiFukushiNenkinRireki().initialize(識別コード, 被保険者番号);
        アクセスログ(AccessLogType.照会, 識別コード);
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
    public ResponseData<RoUReiFuKuShiNenKinDiv> onClick_Save(RoUReiFuKuShiNenKinDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(HOZONMESSAGE).respond();
        }
        if (画面状態のチェック(div)) {

            throw new ApplicationException(UrErrorMessages.保存データなし.getMessage());
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getRoreiFukushiNenkinJohoList().getCcdRoreiFukushiNenkinRireki().click_Save();
            RealInitialLocker.release(LOCKINGKEY);
            アクセスログ(AccessLogType.更新, ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
            div.getKihonJoho().getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBU0110011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
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

    private void アクセスログ(AccessLogType type, ShikibetsuCode 識別コード) {
        AccessLogger.log(type, toPersonalData(識別コード));
    }

    private boolean 画面状態のチェック(RoUReiFuKuShiNenKinDiv div) {

        boolean checkFlg = true;
        List<datagridRireki_Row> rowList = div.getRoreiFukushiNenkinJohoList().
                getCcdRoreiFukushiNenkinRireki().getDataGridList();
        for (datagridRireki_Row row : rowList) {

            if (!row.getJotai().isNullOrEmpty()) {
                checkFlg = false;
                break;
            }
        }
        return checkFlg;
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("有り"), new RString("無し"));
        return PersonalData.of(識別コード, expandedInfo);
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
