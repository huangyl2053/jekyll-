/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1020001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.DBD1020001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.DBD1020001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.RiyoshaFutangakuGengakuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.ddlShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001.RiyoshaFutangakuGengakuHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001.RiyoshaFutangakuGengakuHandler.RiyoshaFutangakuGengakuComparator;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001.RiyoshaFutangakuGengakuValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuService;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IParentResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担額減額申請のクラスです。
 *
 * @reamsid_L DBD-3600-010 xuyue
 */
public class RiyoshaFutangakuGengakuPanel {

    private static final RString 申請メニュー = new RString("DBDMN21002");
    private static final RString 承認メニュー = new RString("DBDMN22002");
    private static final RString 承認する_KEY = new RString("key0");
    private static final RString 追加 = new RString("追加");
    private static final RString BTNUPDATE_FIELDNAME = new RString("btnUpdate");
    private final RString 文字列_申請一覧を表示する = new RString("申請一覧を表示する");
    private final RString 文字列_申請入力を表示する = new RString("申請入力を表示する");
    private final RString 文字列_承認入力を表示する = new RString("承認入力を表示する");
    private static final RString 利用者負担額減額申請TITLE = new RString("利用者負担額減額申請");
    private static final RString 利用者負担額減額申請承認TITLE = new RString("利用者負担額減額申請承認");

    /**
     * 利用者負担額減額申請の初期化。(オンロード)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onLoad(RiyoshaFutangakuGengakuPanelDiv div) {
        IParentResponse<RiyoshaFutangakuGengakuPanelDiv> response = ResponseData.of(div);
        response.rootTitle(申請メニュー.equals(ResponseHolder.getMenuID()) ? 利用者負担額減額申請TITLE : 利用者負担額減額申請承認TITLE);

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        getHandler(div).initialize(taishoshaKey);

        if (!ResponseHolder.isReRequest()
                && (被保険者番号 == null || 被保険者番号.getColumnValue().isEmpty())) {
            div.getBtnShowSetaiJoho().setDisabled(true);
            div.getBtnShowGemmenJoho().setDisabled(true);
            div.getBtnInputNew().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNUPDATE_FIELDNAME, true);
            div.getDdlShinseiIchiran().setDisabled(true);
            InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            return response.addMessage(message).respond();
        } else if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return response.respond();
        }

        List<RiyoshaFutangakuGengaku> 利用者負担額減額の情報List = getHandler(div).get利用者負担額減額の情報List(被保険者番号);
        if (利用者負担額減額の情報List != null) {
            ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報のDBList, new ArrayList<>(利用者負担額減額の情報List));
            ArrayList<RiyoshaFutangakuGengakuViewState> viewStateList = new ArrayList<>();
            getHandler(div).一覧エリアの初期設定(利用者負担額減額の情報List, viewStateList);
            ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報ListのViewState, viewStateList);
        }
        getHandler(div).初期処理(taishoshaKey);
        ViewStateHolder.put(ViewStateKeys.新規申請の履歴番号, 0);
        List<ddlShinseiIchiran_Row> rows = div.getRiyoshaFutangakuGengakuShinseiList().getDdlShinseiIchiran().getDataSource();
        for (ddlShinseiIchiran_Row row : rows) {
            if (row.getKetteiKubun() == null || row.getKetteiKubun().isEmpty()) {
                div.getRiyoshaFutangakuGengakuShinseiList().getBtnInputNew().setDisabled(true);
            } else {
                if (!承認メニュー.equals(ResponseHolder.getMenuID())) {
                    row.setModifyButtonState(DataGridButtonState.Disabled);
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectable(Boolean.FALSE);
                }
            }
        }
        response.setState(DBD1020001StateName.一覧);
        return response.respond();
    }

    /**
     * 利用者負担額減額申請の初期化。(オンアクティブ)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onActive(RiyoshaFutangakuGengakuPanelDiv div) {
        viewState破棄(div);
        return onLoad(div);
    }

    /**
     * 「世帯情報を表示する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnShowSetaiJoho(RiyoshaFutangakuGengakuPanelDiv div) {

        Boolean 世帯所得一覧初期化済み = ViewStateHolder.get(ViewStateKeys.世帯所得一覧初期化済み, Boolean.class);
        if (世帯所得一覧初期化済み == null || !世帯所得一覧初期化済み) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            getHandler(div).世帯所得一覧の初期化(taishoshaKey);
            ViewStateHolder.put(ViewStateKeys.世帯所得一覧初期化済み, true);
        }

        div.getBtnShowSetaiJoho().setDisplayNone(true);
        div.getBtnCloseSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisabled(false);
        if (DBD1020001StateName.一覧.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho().setText(文字列_申請一覧を表示する);
            return ResponseData.of(div).setState(DBD1020001StateName.世帯情報From一覧);
        } else if (DBD1020001StateName.入力.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho()
                    .setText(承認メニュー.equals(ResponseHolder.getMenuID()) ? 文字列_承認入力を表示する : 文字列_申請入力を表示する);
            return ResponseData.of(div).setState(DBD1020001StateName.入力);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請一覧を表示する/申請情報を表示する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnCloseSetaiJoho(RiyoshaFutangakuGengakuPanelDiv div) {
        div.getBtnShowSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisplayNone(true);
        if (DBD1020001StateName.世帯情報From一覧.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(DBD1020001StateName.一覧);
        } else {
            return ResponseData.of(div).setState(DBD1020001StateName.入力);
        }
    }

    /**
     * 「申請情報/承認情報を追加する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnInputNew(RiyoshaFutangakuGengakuPanelDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.該当DB申請, null);
        ViewStateHolder.put(ViewStateKeys.該当申請のViewState, null);
        getHandler(div).追加するボタン押下(taishoshaKey);
        return ResponseData.of(div).setState(DBD1020001StateName.入力);
    }

    /**
     * 申請一覧の修正ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnModify(RiyoshaFutangakuGengakuPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.該当DB申請, null);
        ViewStateHolder.put(ViewStateKeys.該当申請のViewState, null);

        ddlShinseiIchiran_Row row = div.getDdlShinseiIchiran().getActiveRow();

        List<RiyoshaFutangakuGengaku> dbDatalist = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報のDBList, ArrayList.class);
        RiyoshaFutangakuGengaku 該当DB申請 = getHandler(div).get該当DB申請(row, dbDatalist);
        if (該当DB申請 != null) {
            ViewStateHolder.put(ViewStateKeys.該当DB申請, 該当DB申請);
        }
        List<RiyoshaFutangakuGengakuViewState> existsViewStateList = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報ListのViewState, List.class);
        RiyoshaFutangakuGengakuViewState 該当申請のViewState = getHandler(div).get該当申請のViewState(row, existsViewStateList);
        if (該当申請のViewState != null) {
            ViewStateHolder.put(ViewStateKeys.該当申請のViewState, 該当申請のViewState);
        }

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        RiyoshaFutangakuGengakuViewState joho = ViewStateHolder.get(ViewStateKeys.該当申請のViewState, RiyoshaFutangakuGengakuViewState.class);
        getHandler(div).申請一覧の修正ボタンをクリック(row, taishoshaKey, joho);
        return ResponseData.of(div).setState(DBD1020001StateName.入力);
    }

    /**
     * 申請一覧の削除ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnDelete(RiyoshaFutangakuGengakuPanelDiv div) {
        ddlShinseiIchiran_Row row = div.getDdlShinseiIchiran().getActiveRow();

        RString 元の決定区分 = RString.EMPTY;
        List<RiyoshaFutangakuGengaku> dbDatalist = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報のDBList, ArrayList.class);
        RiyoshaFutangakuGengaku 該当DB申請 = getHandler(div).get該当DB申請(row, dbDatalist);
        if (該当DB申請 != null && 該当DB申請.get決定区分() != null) {
            元の決定区分 = 該当DB申請.get決定区分();
        }

        if (!ResponseHolder.isReRequest() && !追加.equals(row.getJotai()) && !元の決定区分.isEmpty()) {
            InformationMessage message = new InformationMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().getCode(),
                    DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (new RString(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }

        ArrayList<RiyoshaFutangakuGengakuViewState> list = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報ListのViewState, ArrayList.class);
        ArrayList<RiyoshaFutangakuGengakuViewState> newList = new ArrayList<>();
        getHandler(div).申請一覧の削除ボタンをクリック(row, list, newList);
        if (追加.equals(row.getJotai())) {
            ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報ListのViewState, list);
        } else {
            ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報ListのViewState, newList);
        }
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「申請一覧に戻る」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnBackShinseiIchirai(RiyoshaFutangakuGengakuPanelDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);

        div.getBtnInputNew().setDisabled(false);
        div.getDdlShinseiIchiran().setDisabled(false);
        div.getRiyoshaFutangakuGengakuShinseiDetail().setDisabled(true);
        getHandler(div).入力情報をクリア(taishoshaKey);
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「承認情報を確定する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnConfirm(RiyoshaFutangakuGengakuPanelDiv div) {

        RString 決定区分 = div.getRadKetteiKubun().getSelectedKey();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (承認する_KEY.equals(決定区分)) {
            getValidationHandler().validateFor適用日の必須入力(pairs, div);
            getValidationHandler().validateFor有効期限の必須入力(pairs, div);
            getValidationHandler().validateFor給付率の必須入力(pairs, div);
        }
        getValidationHandler().validateFor申請日の必須入力(pairs, div);
        getValidationHandler().validateFor決定区分の必須入力(pairs, div);
        getValidationHandler().validateFor決定日の必須入力(pairs, div);

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (!承認する_KEY.equals(決定区分)) {
            承認情報を確定する処理(div);
            return ResponseData.of(div).setState(DBD1020001StateName.一覧);
        }

        getValidationHandler().validateFor減免減額_給付率範囲外(pairs, div);
        getValidationHandler().validateFor利用者負担額減額_適用開始日が法施行以前(pairs, div);
        getValidationHandler().validateFor利用者負担額減額_適用終了日が年度外(pairs, div);
        getValidationHandler().validateFor利用者負担額減額_適用終了日が開始日以前(pairs, div);
        getValidationHandler().validateFor受給共通_受給者登録なし(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        承認情報を確定する処理(div);
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    private void 承認情報を確定する処理(RiyoshaFutangakuGengakuPanelDiv div) {
        ArrayList<RiyoshaFutangakuGengakuViewState> existsViewStateList = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (existsViewStateList == null) {
            existsViewStateList = new ArrayList<>();
        }
        RiyoshaFutangakuGengaku 該当DB申請 = ViewStateHolder.get(ViewStateKeys.該当DB申請, RiyoshaFutangakuGengaku.class);
        RiyoshaFutangakuGengakuViewState 該当申請のViewState = ViewStateHolder.get(ViewStateKeys.該当申請のViewState, RiyoshaFutangakuGengakuViewState.class);

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShoKisaiHokenshaNo 証記載保険者番号;
        int 履歴番号;
        EntityDataState state;
        GemmenGengakuShinsei gemmenGengakuShinsei;
        RiyoshaFutangakuGengakuBuilder builder;
        if (該当DB申請 != null) {
            証記載保険者番号 = 該当DB申請.get証記載保険者番号();
            履歴番号 = 該当DB申請.get履歴番号();
            boolean 変更あり = getHandler(div).申請情報_変更あり(該当DB申請);
            if (変更あり) {
                state = EntityDataState.Modified;
            } else {
                state = EntityDataState.Unchanged;
            }
            if (該当DB申請.getGemmenGengakuShinseiList().size() > 0) {
                gemmenGengakuShinsei = 該当DB申請.getGemmenGengakuShinseiList().get(0);
            } else {
                ViewStateHolder.put(ViewStateKeys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.getコード(), 履歴番号);
            }
            builder = 該当DB申請.createBuilderForEdit();
        } else {
            state = EntityDataState.Added;
            証記載保険者番号 = getHandler(div).get証記載保険者番号(div.getTxtShinseiYmd().getValue());

            if (該当申請のViewState != null) {
                履歴番号 = 該当申請のViewState.getRiyoshaFutangakuGengaku().get履歴番号();
                gemmenGengakuShinsei = 該当申請のViewState.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0);
                builder = 該当申請のViewState.getRiyoshaFutangakuGengaku().createBuilderForEdit();
            } else {
                Integer 新規申請の履歴番号 = ViewStateHolder.get(ViewStateKeys.新規申請の履歴番号, Integer.class);
                履歴番号 = 新規申請の履歴番号 - 1;
                ViewStateHolder.put(ViewStateKeys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.getコード(), 履歴番号);
                builder = new RiyoshaFutangakuGengaku(証記載保険者番号, 被保険者番号, 履歴番号).createBuilderForEdit();
            }
        }

        ArrayList<RiyoshaFutangakuGengakuViewState> newViewStateList = new ArrayList<>();
        getHandler(div).承認情報を確定するボタン押下(existsViewStateList, newViewStateList,
                state, gemmenGengakuShinsei, builder, 証記載保険者番号, 履歴番号, taishoshaKey);

        ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報ListのViewState, newViewStateList);
    }

    /**
     * 「申請情報を確定する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnShinseiKakutei(RiyoshaFutangakuGengakuPanelDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getTxtShinseiYmd().getValue().isEmpty()) {
            getValidationHandler().validateFor申請日の必須入力(pairs, div);
        } else {
            pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtShinseiYmd()));
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        申請情報を確定す処理(div);
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    private void 申請情報を確定す処理(RiyoshaFutangakuGengakuPanelDiv div) {
        ArrayList<RiyoshaFutangakuGengakuViewState> existsViewStateList = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報ListのViewState, ArrayList.class);
        if (existsViewStateList == null) {
            existsViewStateList = new ArrayList<>();
        }
        RiyoshaFutangakuGengaku 該当DB申請 = ViewStateHolder.get(ViewStateKeys.該当DB申請, RiyoshaFutangakuGengaku.class);
        RiyoshaFutangakuGengakuViewState 該当申請のViewState = ViewStateHolder.get(ViewStateKeys.該当申請のViewState, RiyoshaFutangakuGengakuViewState.class);

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShoKisaiHokenshaNo 証記載保険者番号;
        int 履歴番号;
        EntityDataState state;
        GemmenGengakuShinsei gemmenGengakuShinsei;
        RiyoshaFutangakuGengakuBuilder builder;

        if (該当DB申請 != null) {
            証記載保険者番号 = 該当DB申請.get証記載保険者番号();
            履歴番号 = 該当DB申請.get履歴番号();

            boolean 変更あり = getHandler(div).申請情報_変更あり(該当DB申請);
            if (変更あり) {
                state = EntityDataState.Modified;
            } else {
                state = EntityDataState.Unchanged;
            }
            if (該当DB申請.getGemmenGengakuShinseiList().size() > 0) {
                gemmenGengakuShinsei = 該当DB申請.getGemmenGengakuShinseiList().get(0);
            } else {
                ViewStateHolder.put(ViewStateKeys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.getコード(), 履歴番号);
            }
            builder = 該当DB申請.createBuilderForEdit();
        } else {
            state = EntityDataState.Added;
            証記載保険者番号 = getHandler(div).get証記載保険者番号(div.getTxtShinseiYmd().getValue());

            if (該当申請のViewState != null) {
                履歴番号 = 該当申請のViewState.getRiyoshaFutangakuGengaku().get履歴番号();
                gemmenGengakuShinsei = 該当申請のViewState.getRiyoshaFutangakuGengaku().getGemmenGengakuShinseiList().get(0);
                builder = 該当申請のViewState.getRiyoshaFutangakuGengaku().createBuilderForEdit();
            } else {
                Integer 新規申請の履歴番号 = ViewStateHolder.get(ViewStateKeys.新規申請の履歴番号, Integer.class);
                履歴番号 = 新規申請の履歴番号 - 1;
                ViewStateHolder.put(ViewStateKeys.新規申請の履歴番号, 履歴番号);
                gemmenGengakuShinsei = new GemmenGengakuShinsei(
                        証記載保険者番号, 被保険者番号, GemmenGengakuShurui.利用者負担額減額.getコード(), 履歴番号);
                builder = new RiyoshaFutangakuGengaku(証記載保険者番号, 被保険者番号, 履歴番号).createBuilderForEdit();
            }
        }

        ArrayList<RiyoshaFutangakuGengakuViewState> newViewStateList = new ArrayList<>();
        getHandler(div).申請情報を確定するボタン押下(existsViewStateList, newViewStateList,
                state, gemmenGengakuShinsei, builder, 証記載保険者番号, 履歴番号, taishoshaKey);

        ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報ListのViewState, newViewStateList);
    }

    /**
     * 「決定区分」ラジオボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onChange_radKetteiKubun(RiyoshaFutangakuGengakuPanelDiv div) {
        boolean is申請日非活性 = div.getTxtShinseiYmd().isDisabled();
        getHandler(div).承認情報エリア状態(div.getRadKetteiKubun().getSelectedKey(), false, is申請日非活性, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「減免情報を表示する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onBeforeOpenDialog_btnShowGemmenJoho(RiyoshaFutangakuGengakuPanelDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「DBD.GemmenShokai」ダイアログを閉じる処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onOkClose_btnShowGemmenJoho(RiyoshaFutangakuGengakuPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onBeforeOpenDialog_btnHiShoninRiyu(RiyoshaFutangakuGengakuPanelDiv div) {
        div.setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHidden登録グループコード(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された承認しない理由を本画面にセットします。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onOkClose_btnHiShoninRiyu(RiyoshaFutangakuGengakuPanelDiv div) {
        div.getTxtHiShoninRiyu().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * 「適用日」のonBlur処理に、有効期限を編集します。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onBlur_txtTekiyoYmd(RiyoshaFutangakuGengakuPanelDiv div) {
        getHandler(div).get有効期限By適用日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報を保存する/承認情報を保存する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnUpdate(RiyoshaFutangakuGengakuPanelDiv div) {

        if (ResponseHolder.isReRequest() && new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }

        ArrayList<RiyoshaFutangakuGengakuViewState> list = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報ListのViewState, ArrayList.class);
        boolean 変更あり = getHandler(div).申請一覧_変更あり(list);
        if (!変更あり) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (ResponseHolder.getMenuID().equals(承認メニュー)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor適用期間重複なし(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            PersonalData personalData = getHandler(div).toPersonalData(taishoshaKey);
            AccessLogger.log(AccessLogType.更新, personalData);

            保存処理();
            前排他キーの解除();
            div.getLin1().setDisplayNone(true);
            div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        } else if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).setState(DBD1020001StateName.完了メッセージ);
    }

    /**
     * 「再検索する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnReSearch(RiyoshaFutangakuGengakuPanelDiv div) {

        viewState破棄(div);
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD1020001TransitionEventName.検索処理へ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnToSearchResult(RiyoshaFutangakuGengakuPanelDiv div) {
        viewState破棄(div);
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD1020001TransitionEventName.検索結果一覧へ).respond();
    }

    private void 保存処理() {

        List<RiyoshaFutangakuGengakuViewState> orderViewStateList = new ArrayList<>();
        List<RiyoshaFutangakuGengakuViewState> 削除List = new ArrayList<>();
        履歴番号の修正(orderViewStateList, 削除List);

        List<RiyoshaFutangakuGengakuViewState> 追加List = new ArrayList<>();
        List<RiyoshaFutangakuGengakuViewState> 修正List = new ArrayList<>();
        List<RiyoshaFutangakuGengakuViewState> 履歴修正ありList = new ArrayList<>();
        for (RiyoshaFutangakuGengakuViewState viewState : orderViewStateList) {
            if (EntityDataState.Added == viewState.getState()) {
                追加List.add(viewState);
            } else if (EntityDataState.Modified == viewState.getState()
                    && viewState.getShorigoRirekiNo() == viewState.getRiyoshaFutangakuGengaku().get履歴番号()) {
                修正List.add(viewState);
            } else if (viewState.getShorigoRirekiNo() != viewState.getRiyoshaFutangakuGengaku().get履歴番号()) {
                履歴修正ありList.add(viewState);
            }
        }

        RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();
        service.保存処理(削除List, 追加List, 修正List, 履歴修正ありList);
    }

    private void 履歴番号の修正(List<RiyoshaFutangakuGengakuViewState> orderViewStateList, List<RiyoshaFutangakuGengakuViewState> 削除List) {

        ArrayList<RiyoshaFutangakuGengakuViewState> viewStateList
                = ViewStateHolder.get(ViewStateKeys.利用者負担額減額情報ListのViewState, ArrayList.class);
        Collections.sort(viewStateList, new RiyoshaFutangakuGengakuComparator());

        int size = viewStateList.size();
        int minRirekiNo = Integer.MAX_VALUE;

        List<RiyoshaFutangakuGengakuViewState> not削除List = new ArrayList<>();
        RiyoshaFutangakuGengakuViewState joho;
        EntityDataState 状態;
        EntityDataState 始まり承認データ状態 = EntityDataState.Unchanged;
        for (int i = 0; i < size; i++) {
            joho = viewStateList.get(i);
            状態 = joho.getState();
            if (minRirekiNo > joho.getShorigoRirekiNo() && joho.getShorigoRirekiNo() >= 0) {
                minRirekiNo = joho.getShorigoRirekiNo();
                始まり承認データ状態 = 状態;
            }
            if (EntityDataState.Deleted == 状態) {
                削除List.add(joho);
            } else {
                not削除List.add(joho);
            }
        }
        if (minRirekiNo == Integer.MAX_VALUE && ResponseHolder.getMenuID().equals(承認メニュー)) {
            minRirekiNo = 1;
        } else if (minRirekiNo == Integer.MAX_VALUE) {
            minRirekiNo = 0;
        }
        if (ResponseHolder.getMenuID().equals(承認メニュー)
                && EntityDataState.Modified == 始まり承認データ状態 && minRirekiNo == 0) {
            minRirekiNo = 1;
        }

        int tmpRirekiNo;
        RiyoshaFutangakuGengakuViewState joho１;
        RiyoshaFutangakuGengakuViewState joho２;
        size = not削除List.size();
        for (int i = 0; i < size; i++) {

            joho１ = not削除List.get(i);
            tmpRirekiNo = joho１.getShorigoRirekiNo();

            if (joho１.getShorigoRirekiNo() < minRirekiNo && i == 0) {
                tmpRirekiNo = minRirekiNo;
            } else if (joho１.getShorigoRirekiNo() < 0) {
                tmpRirekiNo = not削除List.get(i - 1).getShorigoRirekiNo() + 1;
            }
            joho１ = joho１.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();

            if (i < size - 1) {
                joho２ = not削除List.get(i + 1);
                if (ResponseHolder.getMenuID().equals(申請メニュー) && joho２.getRiyoshaFutangakuGengaku().get決定区分() == null) {
                    tmpRirekiNo = 0;
                    joho２ = joho２.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();
                    not削除List.set(i + 1, joho２);
                } else if (joho２.getShorigoRirekiNo() <= joho１.getShorigoRirekiNo()) {
                    tmpRirekiNo = tmpRirekiNo + 1;
                    joho２ = joho２.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();
                    not削除List.set(i + 1, joho２);
                }
            }
            orderViewStateList.add(joho１);
        }
    }

    private void 前排他キーの解除() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.release(排他キー);
    }

    private void viewState破棄(RiyoshaFutangakuGengakuPanelDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報ListのViewState, null);
        ViewStateHolder.put(ViewStateKeys.利用者負担額減額情報のDBList, null);
        ViewStateHolder.put(ViewStateKeys.世帯所得一覧初期化済み, null);
        getHandler(div).入力情報をクリア(taishoshaKey);
    }

    private RiyoshaFutangakuGengakuHandler getHandler(RiyoshaFutangakuGengakuPanelDiv div) {
        return new RiyoshaFutangakuGengakuHandler(div);
    }

    private RiyoshaFutangakuGengakuValidationHandler getValidationHandler() {
        return new RiyoshaFutangakuGengakuValidationHandler();
    }
}
