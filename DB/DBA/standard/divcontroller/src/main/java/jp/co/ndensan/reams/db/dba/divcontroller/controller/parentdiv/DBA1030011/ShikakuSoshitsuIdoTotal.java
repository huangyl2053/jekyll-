/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1030011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.DBA1030011StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.DBA1030011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1030011.ShikakuSoshitsuIdoTotalHandler;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureiChecker;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.TekiyoJogaishaChecker;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
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
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格喪失異動の対象者情報を表示するためのDivControllerです。
 *
 * @reamsid_L DBA-0552-030 wangkun
 */
public class ShikakuSoshitsuIdoTotal {

    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuSoshitsuIdo");
    private static final RString DEFAULT = new RString("被保履歴");
    private static final RString IRYOU = new RString("医療保険");
    private static final RString RONEN = new RString("老福年金");
    private static final RString SHISETSU = new RString("施設入退所");
    private static final RString SHORUIJOKYO = new RString("証交付回収");
    private static final RString 修正 = new RString("修正");
    private static final Integer FIRSTINDEX = Integer.valueOf("0");

    private static final RString COMMON_BUTTON_RESEARCH = new RString("btnUpdate");

    /**
     * 資格喪失異動の初期化します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onLoad(ShikakuSoshitsuIdoTotalDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        HihokenshaNo hihokenshaNo = key.get被保険者番号();

        if (shikibetsuCode == null || shikibetsuCode.isEmpty()) {
            return setNotExecutableAndReturnMessage(div, UrInformationMessages.該当データなし.getMessage());
        }
        if (hihokenshaNo == null || hihokenshaNo.isEmpty()) {
            return setNotExecutableAndReturnMessage(div, UrInformationMessages.該当データなし.getMessage());
        }

        createHandler(div).load(ViewStateHolder.get(ViewStateKeys.資格喪失異動_状態_被保履歴タブ, RString.class));
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }

        if (createHandler(div).is資格喪失中()) {
            releaseLock(div);
            return setNotExecutableAndReturnMessage(div, DbzInformationMessages.資格喪失済み.getMessage());
        }
        if (TaJushochiTokureiChecker.createInstance().is他市町村住所地特例者(shikibetsuCode)) {
            releaseLock(div);
            return setNotExecutableAndReturnMessage(div, DbzInformationMessages.他特例者登録済み.getMessage());
        }
        if (TekiyoJogaishaChecker.createInstance().is適用除外者(shikibetsuCode)) {
            releaseLock(div);
            return setNotExecutableAndReturnMessage(div, DbzInformationMessages.適用除外者登録済み.getMessage());
        }

        return ResponseData.of(div).respond();
    }

    private void releaseLock(ShikakuSoshitsuIdoTotalDiv div) {
        RealInitialLocker.release(前排他ロックキー);
    }

    private ResponseData<ShikakuSoshitsuIdoTotalDiv> setNotExecutableAndReturnMessage(ShikakuSoshitsuIdoTotalDiv div, Message message) {
        div.setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_RESEARCH, true);
        return ResponseData.of(div).addMessage(message).respond();
    }

    /**
     *
     * /**
     * 資格喪失異動タブの切替処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onChange_tabInputs(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        RString title = div.getShikakuSoshitsuJoho().getTabInputs().getSelectedItem().getTitle();
        if (DEFAULT.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_被保履歴タブ, createHandler(div)
                    .onOpenTplDefault(ViewStateHolder.get(ViewStateKeys.資格喪失異動_状態_被保履歴タブ, RString.class)));
        } else if (IRYOU.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_医療保険タブ, createHandler(div)
                    .onOpenTplIryou(ViewStateHolder.get(ViewStateKeys.資格喪失異動_状態_医療保険タブ, RString.class)));
        } else if (RONEN.equals(title)) {
            createHandler(div).onOpenTplRoNen(ViewStateHolder.get(ViewStateKeys.資格喪失異動_状態_医療保険タブ, RString.class));
        } else if (SHISETSU.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_施設入退所タブ, createHandler(div)
                    .onOpenTplShisetsu(ViewStateHolder.get(ViewStateKeys.資格喪失異動_状態_施設入退所タブ, RString.class)));
        } else if (SHORUIJOKYO.equals(title)) {
            ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_証類状況タブ, createHandler(div)
                    .onOpenTplShoruiJokyo(ViewStateHolder.get(ViewStateKeys.資格喪失異動_状態_証類状況タブ, RString.class)));
        }
        response.data = div;
        return response;
    }

    /**
     * 「資格情報を保存する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnUpdate(ShikakuSoshitsuIdoTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            createHandler(div).save();
            RealInitialLocker.release(前排他ロックキー);
            div.getComplete().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBA1030011StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資格情報を詳細」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnSyouHoSo(ShikakuSoshitsuIdoTotalDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        createHandler(div).setパラメータ();
        return ResponseData.of(div).forwardWithEventName(DBA1030011TransitionEventName.詳細へ).respond();
    }

    /**
     * 「戻る」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnBack(ShikakuSoshitsuIdoTotalDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_証類状況タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_施設入退所タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_老福年金タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_医療保険タブ, null);
        ViewStateHolder.put(ViewStateKeys.資格喪失異動_状態_被保履歴タブ, null);
        return ResponseData.of(div).forwardWithEventName(DBA1030011TransitionEventName.再検索).respond();
    }

    /**
     * 「資格得喪履歴を修正する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_ModifyButton(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).資格喪失情報パネルの活性初期化();
        dgShikakuShutokuRireki_Row row = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki()
                .getDataGridSelectItem();
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuDate()
                .setValue(row.getSoshitsuDate().getValue());
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getTxtShutokuTodokedeDate()
                .setValue(row.getSoshitsuTodokedeDate().getValue());
        if (!RString.isNullOrEmpty(row.getSoshitsuJiyuKey())) {
            div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput().getDdlShikakuShutokuJiyu()
                    .setSelectedKey(row.getSoshitsuJiyuKey());
        }
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を確定する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnKakutei(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        List<dgShikakuShutokuRireki_Row> rowlist = div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().getDataGridDataSource();
        dgShikakuShutokuRireki_Row row = rowlist.get(FIRSTINDEX);
        row.getSoshitsuDate().setValue(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getTxtShutokuDate().getValue());
        row.getSoshitsuTodokedeDate().setValue(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getTxtShutokuTodokedeDate().getValue());
        row.setSoshitsuJiyu(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getDdlShikakuShutokuJiyu().getSelectedValue());
        row.setSoshitsuJiyuKey(div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getShikakuSoshitsuInput()
                .getDdlShikakuShutokuJiyu().getSelectedKey());
        row.setState(修正);
        rowlist.set(FIRSTINDEX, row);
        div.getShikakuSoshitsuJoho().getShikakuTokusoRirekiMain().getCcdShikakuTokusoRireki().setDataGridDataSource(rowlist);
        createHandler(div).資格喪失情報パネルの非活性初期化();
        response.data = div;
        return response;
    }

    /**
     * 「資格得喪履歴を取消する」ボタン処理します。
     *
     * @param div ShikakuSoshitsuIdoTotalDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuSoshitsuIdoTotalDiv> onClick_btnTorikeshi(ShikakuSoshitsuIdoTotalDiv div) {
        ResponseData<ShikakuSoshitsuIdoTotalDiv> response = new ResponseData<>();
        createHandler(div).資格喪失情報パネルの非活性初期化();
        response.data = div;
        return response;
    }

    private enum ShikakuSoshitsuIdoErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShikakuSoshitsuIdoErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private ShikakuSoshitsuIdoTotalHandler createHandler(ShikakuSoshitsuIdoTotalDiv div) {
        TaishoshaKey key = ViewStateHolder.get(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
        return new ShikakuSoshitsuIdoTotalHandler(div, key);
    }
}
