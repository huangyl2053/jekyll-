/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0110011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.DBC0110011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.DBC0110011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.dgKyotakuServiceIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0110011.KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0110011.KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBC0110011_居宅サービス計画作成依頼届出情報登録のControllerです。
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class KyotakuSabisuKeikakuIraiTodokedeJohoToroku {

    private static final RString メニューID_事業者作成 = new RString("DBCMN21001");
    private static final RString メニューID_自己作成 = new RString("DBCMN21002");
    private static final RString TITLE_居宅サービス計画作成依頼届出情報登録
            = new RString("居宅サービス計画作成依頼届出情報登録");
    private static final RString TITLE_居宅サービス自己作成届出情報登録
            = new RString("居宅サービス自己作成届出情報登録");
    private static final RString 計画作成依頼届出完了メッセージ
            = new RString("「居宅サービス計画作成依頼届出の登録が完了しました。」");
    private static final RString 自己作成届出完了メッセージ
            = new RString("「居宅サービス自己作成届出の登録が完了しました。」");
    private static final int NUM_1 = 1;

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onLoad(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        TaishoshaKey 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (引き継ぎ情報 == null || 引き継ぎ情報.get被保険者番号() == null
                || 引き継ぎ情報.get被保険者番号().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(
                        DbcInformationMessages.被保険者でないデータ.getMessage()).respond();
            }
        }
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        if (!handler.get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        KyotakuKeikakuTodokedeManager manager = KyotakuKeikakuTodokedeManager.createInstance();
        KyotakuKeikakuTodokedeMapperParameter parameter = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(
                被保険者番号,
                FlexibleYearMonth.MAX,
                Decimal.ZERO);
        List<KyotakuKeikakuTodokede> 居宅給付計画届出履歴一覧 = manager.get居宅給付計画届出履歴一覧(parameter);
        handler.initialize(被保険者番号, 識別コード, 居宅給付計画届出履歴一覧);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        return getResponseData(div);
    }

    /**
     * 居宅サービス一覧Grid「選択」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onSelect_dgKyotakuServiceIchiran(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        KyotakuKeikakuTodokede 居宅給付計画届出 = get居宅給付計画届出履歴(div);
        handler.onSelect居宅サービス一覧(居宅給付計画届出);
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 居宅サービス一覧Grid「修正」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onModify_dgKyotakuServiceIchiran(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        KyotakuKeikakuTodokede 居宅給付計画届出 = get居宅給付計画届出履歴(div);
        handler.onModify居宅サービス一覧(居宅給付計画届出);
        ViewStateHolder.put(ViewStateKeys.居宅給付計画届出, 居宅給付計画届出);
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 居宅サービス一覧Grid「削除」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onDelete_dgKyotakuServiceIchiran(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        KyotakuKeikakuTodokede 居宅給付計画届出 = get居宅給付計画届出履歴(div);
        handler.onDelete居宅サービス一覧(居宅給付計画届出);
        ViewStateHolder.put(ViewStateKeys.居宅給付計画届出, 居宅給付計画届出);
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 「追加・計画作成依頼」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onClick_btnAdd(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        handler.add居宅サービス(被保険者番号);
        ViewStateHolder.put(ViewStateKeys.居宅給付計画届出, null);
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 「計画作成区分」ラジオボタンが変更時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onChange_radKeikakuSakuseiKubun(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        handler.onChange計画作成区分();
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 「事業者検索DIV」onOkClose時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onOkClose_btnJigyoshaKensaku(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getTxtJigyoshaNo().setValue(mode.getJigyoshaNo().getColumnValue());
        div.getTxtJigyoshaName().setValue(mode.getJigyoshaName().getColumnValue());
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 「委託先事業者検索DIV」onOkClose時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onOkClose_btnItakuSakiJigyoshaKensaku(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getTxtItakusakiJigyoshaNo().setValue(mode.getJigyoshaNo().getColumnValue());
        div.getTxtItakusakiJigyoshaName().setValue(mode.getJigyoshaName().getColumnValue());
        return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
    }

    /**
     * 「保存する」ボタン表示制御を設定です。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onStateTransition(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        getHandler(div).set保存する();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onClick_btnSave(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        int 履歴番号 = get履歴番号の採番(被保険者番号);
        KyotakuKeikakuTodokede 居宅給付計画届出 = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出,
                KyotakuKeikakuTodokede.class);
        if (居宅給付計画届出 == null) {
            居宅給付計画届出 = handler.create居宅給付計画届出(被保険者番号, 履歴番号);
        }
        居宅給付計画届出 = handler.set保存処理(居宅給付計画届出);
        ValidationMessageControlPairs valid = getValidationHandler(div).validate(居宅給付計画届出);
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        boolean isReRequest = ResponseHolder.isReRequest();
        if (isReRequest && ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBC0110011StateName.追加状態);
        }
        boolean isSelectedResultYes = ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes;
        boolean isBefore居宅サービス小規模多機能確認 = isBeforeMessage(
                DbcQuestionMessages.居宅サービス小規模多機能.getMessage(),
                isSelectedResultYes);
        boolean isBefore計画作成区分確認 = isBeforeMessage(DbcQuestionMessages.計画作成区分.getMessage(),
                isSelectedResultYes);
        boolean isBefore地域包括支援センター確認 = isBeforeMessage(
                DbcQuestionMessages.地域包括支援センター.getMessage(),
                isSelectedResultYes);
        boolean isBefore居宅サービス受給者確認 = isBeforeMessage(DbcQuestionMessages.居宅サービス受給者.getMessage(),
                isSelectedResultYes);
        ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> 質問チェックの結果 = null;
        質問チェックの結果 = check小規模多機能(div, handler, isReRequest);
        if (質問チェックの結果 != null) {
            return 質問チェックの結果;
        }
        質問チェックの結果 = check介護度サービス種類(div, handler, isReRequest, isBefore居宅サービス小規模多機能確認,
                被保険者番号);
        if (質問チェックの結果 != null) {
            return 質問チェックの結果;
        }
        質問チェックの結果 = check地域包括支援センター(div, handler, isReRequest, isBefore居宅サービス小規模多機能確認,
                isBefore計画作成区分確認);
        if (質問チェックの結果 != null) {
            return 質問チェックの結果;
        }
        質問チェックの結果 = check計画適用開始日での認定状態(div, handler, isReRequest,
                isBefore居宅サービス小規模多機能確認,
                isBefore計画作成区分確認,
                isBefore地域包括支援センター確認,
                被保険者番号);
        if (質問チェックの結果 != null) {
            return 質問チェックの結果;
        }
        質問チェックの結果 = check受給申請中(div, handler, isReRequest, isBefore居宅サービス小規模多機能確認,
                isBefore計画作成区分確認, isBefore地域包括支援センター確認,
                isBefore居宅サービス受給者確認, 被保険者番号);
        if (質問チェックの結果 != null) {
            return 質問チェックの結果;
        }
        KyotakuKeikakuTodokedeManager manager = KyotakuKeikakuTodokedeManager.createInstance();
        manager.saveByForDeletePhysical(居宅給付計画届出);
        AccessLogger.log(AccessLogType.更新, handler.toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        div.getKanryo().getCcdKaigoKanryoMessage().setMessage(get完了メッセージ(), 被保険者番号.getColumnValue(),
                div.getKihonJoho().getCcdKaigoAtenaInfo().get氏名漢字(), true);
        return ResponseData.of(div).setState(DBC0110011StateName.完了状態);
    }

    /**
     * 「個人検索へ戻る」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onClick_btnResearch(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuKeikakuTodokede 居宅給付計画届出 = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出,
                KyotakuKeikakuTodokede.class);
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        boolean is項目が変更 = handler.is項目が変更(居宅給付計画届出);
        if (is項目が変更 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.居宅サービス変更.getMessage()).respond();
        }
        if (!is項目が変更 || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBC0110011TransitionEventName.対象者検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onClick_btnToSearchResult(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        KyotakuKeikakuTodokede 居宅給付計画届出 = ViewStateHolder.get(ViewStateKeys.居宅給付計画届出,
                KyotakuKeikakuTodokede.class);
        KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler = getHandler(div);
        boolean is項目が変更 = Boolean.FALSE;
        if (居宅給付計画届出 != null) {
            is項目が変更 = handler.is項目が変更(居宅給付計画届出);
        }
        if (is項目が変更 && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.居宅サービス変更.getMessage()).respond();
        }
        if (!is項目が変更 || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBC0110011StateName.履歴一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了」ボタン押下時のメソッドです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     * @return ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv>
     */
    public ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> onClick_btnComplete(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0110011TransitionEventName.完了).respond();
    }

    private boolean isBeforeMessage(Message message, boolean isSelectedResultYes) {
        return message.getCode().equals(ResponseHolder.getMessageCode().toString()) && isSelectedResultYes;
    }

    private KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler getHandler(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        return new KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler(div);
    }

    private KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationHandler getValidationHandler(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        return new KyotakuSabisuKeikakuIraiTodokedeJohoTorokuValidationHandler(div);
    }

    private boolean is事業者作成の場合() {
        return メニューID_事業者作成.equals(ResponseHolder.getMenuID());
    }

    private boolean is自己作成の場合() {
        return メニューID_自己作成.equals(ResponseHolder.getMenuID());
    }

    private RString get完了メッセージ() {
        if (is事業者作成の場合()) {
            return 計画作成依頼届出完了メッセージ;
        } else {
            return 自己作成届出完了メッセージ;
        }
    }

    private ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> getResponseData(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        if (is事業者作成の場合()) {
            return ResponseData.of(div).rootTitle(TITLE_居宅サービス計画作成依頼届出情報登録).respond();
        }
        if (is自己作成の場合()) {
            return ResponseData.of(div).rootTitle(TITLE_居宅サービス自己作成届出情報登録).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> check小規模多機能(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div,
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler,
            boolean isReRequest) {
        if (!isReRequest
                && handler.get小規模多機能チェック()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.居宅サービス小規模多機能.getMessage()).respond();
        }
        return null;
    }

    private ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> check介護度サービス種類(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div,
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler,
            boolean isReRequest,
            boolean isBefore居宅サービス小規模多機能確認,
            HihokenshaNo 被保険者番号) {
        if ((!isReRequest || isBefore居宅サービス小規模多機能確認)
                && handler.get介護度サービス種類チェック(被保険者番号)) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.計画作成区分.getMessage()).respond();
        }
        return null;
    }

    private ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> check地域包括支援センター(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div,
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler,
            boolean isReRequest,
            boolean isBefore居宅サービス小規模多機能確認,
            boolean isBefore計画作成区分確認) {
        if ((!isReRequest
                || isBefore居宅サービス小規模多機能確認
                || isBefore計画作成区分確認)
                && handler.get地域包括支援センターチェック()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.地域包括支援センター.getMessage()).respond();
        }
        return null;
    }

    private ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> check計画適用開始日での認定状態(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div,
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler,
            boolean isReRequest,
            boolean isBefore居宅サービス小規模多機能確認,
            boolean isBefore計画作成区分確認,
            boolean isBefore地域包括支援センター確認,
            HihokenshaNo 被保険者番号) {
        if ((!isReRequest
                || isBefore居宅サービス小規模多機能確認
                || isBefore計画作成区分確認
                || isBefore計画作成区分確認
                || isBefore地域包括支援センター確認)
                && handler.get計画適用開始日での認定状態をチェック(被保険者番号)) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.居宅サービス受給者.getMessage()).respond();
        }
        return null;
    }

    private ResponseData<KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv> check受給申請中(
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div,
            KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler handler,
            boolean isReRequest,
            boolean isBefore居宅サービス小規模多機能確認,
            boolean isBefore計画作成区分確認,
            boolean isBefore地域包括支援センター確認,
            boolean isBefore居宅サービス受給者確認,
            HihokenshaNo 被保険者番号) {
        if ((!isReRequest
                || isBefore居宅サービス小規模多機能確認
                || isBefore計画作成区分確認
                || isBefore計画作成区分確認
                || isBefore地域包括支援センター確認
                || isBefore居宅サービス受給者確認)
                && handler.get受給申請中をチェック(被保険者番号)) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.居宅サービス受給者申請.getMessage()).respond();
        }
        return null;
    }

    private KyotakuKeikakuTodokede get居宅給付計画届出履歴(KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        dgKyotakuServiceIchiran_Row 選択行 = div.getRireki().getDgKyotakuServiceIchiran().getClickedItem();
        KyotakuKeikakuTodokedeManager manager = KyotakuKeikakuTodokedeManager.createInstance();
        KyotakuKeikakuTodokedeMapperParameter parameter = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(
                被保険者番号,
                new FlexibleYearMonth(選択行.getTaishoYM()),
                new Decimal(選択行.getRirekiNo().toString()));
        return manager.get居宅給付計画届出履歴(parameter);
    }

    private int get履歴番号の採番(HihokenshaNo 被保険者番号) {
        KyotakuKeikakuTodokedeManager manager = KyotakuKeikakuTodokedeManager.createInstance();
        return manager.get最大履歴番号By被保険者番号(被保険者番号) + NUM_1;
    }
}
