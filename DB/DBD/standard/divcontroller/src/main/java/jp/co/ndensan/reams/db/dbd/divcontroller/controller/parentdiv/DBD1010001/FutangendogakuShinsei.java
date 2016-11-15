/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiViewState;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.DBD1010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.DBD1010001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001.FutangendogakuNinteiShinseiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001.NinteiShinseiValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutangendogakuNinteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 負担限度額認定申請画面のDivControllerです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public class FutangendogakuShinsei {

    private static final RString KEY1 = new RString("key1");
    private static final RString 申請メニューID = new RString("DBDMN21001");
    private static final RString 承認メニューID = new RString("DBDMN22001");
    private final RString 承認タイトル = new RString("負担限度額認定申請承認（個別）");
    private static final RString 共通エリア_保存する = new RString("btnUpdate");

    /**
     * 画面初期化
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onLoad(FutangendogakuShinseiDiv div) {

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = null;
        HihokenshaNo 被保険者番号 = null;
        boolean データあり = true;
        if (taishoshaKey != null) {
            div.setShikibetsuCode(taishoshaKey.get識別コード().getColumnValue());
            識別コード = taishoshaKey.get識別コード();
            被保険者番号 = taishoshaKey.get被保険者番号();
        }

        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            div.getBtnDispGemmenJoho().setDisabled(true);
            div.getBtnAddShinsei().setDisabled(true);
            div.getBtnDispShisetsuJoho().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(共通エリア_保存する, true);
            データあり = false;
        } else {
            if (承認メニューID.equals(ResponseHolder.getMenuID())) {
                データあり = FutangendogakuNinteiService.createInstance().canBe利用者(被保険者番号, FlexibleDate.getNowDate());
            }
        }

        if (!ResponseHolder.isReRequest() && !データあり) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
        }

        div.setHihokenshaNo(被保険者番号.getColumnValue());
        List<FutanGendogakuNintei> 申請一覧情報 = getHandler(div).get申請一覧情報(被保険者番号);
        ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList = new ArrayList<>(申請一覧情報);
        ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, 申請一覧情報ArrayList);

        ArrayList<FutanGendogakuNinteiViewState> resultList = getHandler(div).onLoad(識別コード, 被保険者番号, 申請一覧情報ArrayList);
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, resultList);
        div.getShinseiDetail().setDisabled(true);
        List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : rows) {
            if (row.getKetteiKubun() == null || row.getKetteiKubun().isEmpty()) {
                div.getShinseiList().getBtnAddShinsei().setDisabled(true);
            } else {
                if (申請メニューID.equals(ResponseHolder.getMenuID())) {
                    row.setModifyButtonState(DataGridButtonState.Disabled);
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectable(Boolean.FALSE);
                }
            }
        }
        if (rows.isEmpty()) {
            div.getShinseiList().getBtnAddShinsei().setDisabled(false);
        }
        if (申請メニューID.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).rootTitle(承認タイトル).respond();
        }
    }

    /**
     * 「減免情報を表示する」ボタンをクリック
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onBeforeOpenDialog_btnDispGemmenJoho(FutangendogakuShinseiDiv div) {

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「所得状況」ボタン押下時の処理です。
     *
     * @param div FutangendogakuShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<FutangendogakuShinseiDiv> onBeforeOpenDialog_btnShotokuJokyo(FutangendogakuShinseiDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        div.setShikibetsuCode(識別コード.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報を追加する」ボタンを押下
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnAddShinsei(FutangendogakuShinseiDiv div) {

        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).onClick_btnAddShinsei(資格対象者);
        div.getShinseiDetail().setDisabled(false);
        return ResponseData.of(div).setState(DBD1010001StateName.詳細);
    }

    /**
     * 「申請一覧の修正」ボタンを押下
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onSelectByModifyButton(FutangendogakuShinseiDiv div) {
        ArrayList<FutanGendogakuNinteiViewState> 申請一覧情報ArrayList
                = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).onSelectByModifyButton(申請一覧情報ArrayList, 資格対象者);
        div.getShinseiDetail().setDisabled(false);
        return ResponseData.of(div).setState(DBD1010001StateName.詳細);
    }

    /**
     * 「申請一覧の削除」ボタンを押下
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onSelectByDeleteButton(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ViewStateHolder.put(ViewStateKeys.isReRequest, Boolean.FALSE);
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ArrayList<FutanGendogakuNinteiViewState> 申請一覧情報ArrayList
                = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
        FutanGendogakuNintei futanGendogakuNintei = 申請一覧情報ArrayList.get(div.getDgShinseiList().getClickedRowId()).getFutanGendogakuNintei();
        if (申請メニューID.equals(ResponseHolder.getMenuID()) && !futanGendogakuNintei.get決定区分().isEmpty()
                && !ViewStateHolder.get(ViewStateKeys.isReRequest, Boolean.class)) {
            ViewStateHolder.put(ViewStateKeys.isReRequest, Boolean.TRUE);
            return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage()).respond();
        }
        if (!ViewStateHolder.get(ViewStateKeys.isReRequest, Boolean.class)) {
            ArrayList<FutanGendogakuNinteiViewState> list = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
            ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, getHandler(div).onSelectByDeleteButton(list));
        }
        List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
        div.getBtnAddShinsei().setDisabled(false);
        for (dgShinseiList_Row row : rows) {
            if (row.getKetteiKubun() == null || row.getKetteiKubun().isEmpty()) {
                div.getBtnAddShinsei().setDisabled(true);
            } else {
                if (申請メニューID.equals(ResponseHolder.getMenuID())) {
                    row.setModifyButtonState((DataGridButtonState.Disabled));
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectable(Boolean.FALSE);
                }
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「決定区分」ラジオボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_radKetteiKubun(FutangendogakuShinseiDiv div) {

        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        getHandler(div).onChange_radKetteiKubun(true, 資格対象者);
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onBeforeOpenDialog_btnHiShoninRiyu(FutangendogakuShinseiDiv div) {
        div.setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHidden登録グループコード(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された承認しない理由を本画面にセットします。
     *
     * @param div FutangendogakuShinseiDiv
     * @return レスポンスデータ
     */
    public ResponseData<FutangendogakuShinseiDiv> onClose_btnOpenHiShoninRiyu(FutangendogakuShinseiDiv div) {
        div.getTxtHiShoninRiyu().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入退所情報」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv>
            onBeforeOpenDialog_btnDispShisetsuJoho(FutangendogakuShinseiDiv div) {
        div.setShikibetsuCode(new RString(div.getCcdAtenaInfo().getAtenaInfoDiv().getHdnTxtShikibetsuCode().toString()));
        div.setMode(new RString(ShisetsuNyutaishoRirekiKanriDiv.DisplayMode.照会.toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請一覧に戻る」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnBackToShinseiList(FutangendogakuShinseiDiv div) {
        div.getShinseiList().setDisabled(false);
        div.setJotai(RString.EMPTY);
        div.getShinseiDetail().setDisabled(true);
        return ResponseData.of(div).setState(DBD1010001StateName.一覧);
    }

    /**
     * 「申請情報を確定する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnShinseiKakutei(FutangendogakuShinseiDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (!div.getTxtShinseiYMD().getValue().isEmpty()) {
            pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtShinseiYMD()));
        }
        NinteiShinseiValidationHandler validationHandler = getValidationHandler();
        pairs = validationHandler.預貯金_チェック(pairs, div);
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ArrayList<FutanGendogakuNinteiViewState> list = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, getHandler(div).onClick_btnShinseiKakutei(list, 資格対象者));
        List<dgShinseiList_Row> rows = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : rows) {
            if (row.getKetteiKubun() == null || row.getKetteiKubun().isEmpty()) {
                div.getBtnAddShinsei().setDisabled(true);
            } else {
                if (申請メニューID.equals(ResponseHolder.getMenuID())) {
                    row.setModifyButtonState((DataGridButtonState.Disabled));
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectable(Boolean.FALSE);
                }
            }
        }
        div.getShinseiDetail().setDisabled(true);
        return ResponseData.of(div).setState(DBD1010001StateName.一覧);
    }

    /**
     * 「承認情報を確定する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnShoninKakutei(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.No)) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        NinteiShinseiValidationHandler validationHandler = getValidationHandler();
        if (!KEY1.equals(div.getRadKetteiKubun().getSelectedKey())) {
            pairs = validationHandler.負担限度額認定_適用開始日が法施行以前チェック(pairs, div);
            pairs = validationHandler.負担限度額認定_適用終了日が年度外チェック(pairs, div);
            pairs = validationHandler.負担限度額認定_適用終了日が開始日以前チェック(pairs, div);
            pairs = validationHandler.減免減額_要介護認定チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        RString メニューID = ResponseHolder.getMenuID();
        if (!申請メニューID.equals(メニューID)) {
            pairs = validationHandler.減免減額_適用期間重複のチェックon確定(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }

        ArrayList<FutanGendogakuNinteiViewState> list = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, getHandler(div).onClick_btnShinseiKakutei(list, 資格対象者));
        for (FutanGendogakuNinteiViewState row : list) {
            if (row.getFutanGendogakuNintei().get決定区分() != null || !row.getFutanGendogakuNintei().get決定区分().isEmpty()) {
                div.getBtnAddShinsei().setDisabled(false);
            }
        }
        div.getShinseiDetail().setDisabled(true);
        return ResponseData.of(div).setState(DBD1010001StateName.一覧);
    }

    /**
     * 「再検索する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnReSearch(FutangendogakuShinseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, new ArrayList<FutanGendogakuNintei>());
        ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, new ArrayList<FutanGendogakuNinteiViewState>());
        RealInitialLocker.release(new LockingKey(div.getLockKey()));
        return ResponseData.of(div).forwardWithEventName(DBD1010001TransitionEventName.検索処理へ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnToSearchResult(FutangendogakuShinseiDiv div) {
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, new ArrayList<FutanGendogakuNintei>());
        ViewStateHolder.put(ViewStateKeys.負担限度額認定申請の情報, new ArrayList<FutanGendogakuNinteiViewState>());

        ArrayList<FutanGendogakuNinteiViewState> list = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.new負担限度額認定申請の情報, getHandler(div).onClick_btnToSearchResult(list, 資格対象者));

        RealInitialLocker.release(new LockingKey(div.getLockKey()));
        return ResponseData.of(div).forwardWithEventName(DBD1010001TransitionEventName.検索結果一覧へ).respond();
    }

    /**
     * 「申請情報を保存する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnUpdate(FutangendogakuShinseiDiv div) {
        if (承認メニューID.equals(ResponseHolder.getMenuID())) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            NinteiShinseiValidationHandler validationHandler = getValidationHandler();
            pairs = validationHandler.減免減額_適用期間重複チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        boolean is変更あり = false;
        List<dgShinseiList_Row> list = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : list) {
            if (!row.getJotai().isEmpty()) {
                is変更あり = true;
                break;
            }
        }
        if (!ResponseHolder.isReRequest()) {
            if (!is変更あり) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {

            ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList = ViewStateHolder.get(ViewStateKeys.負担限度額認定申請の情報, ArrayList.class);
            ArrayList<FutanGendogakuNinteiViewState> new認定申請情報List
                    = ViewStateHolder.get(ViewStateKeys.new負担限度額認定申請の情報, ArrayList.class);
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            getHandler(div).申請情報を保存する(申請一覧情報ArrayList, new認定申請情報List, 資格対象者);
            div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBD1010001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 適用日入力の処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onBlur_txtTekiyoYMD(FutangendogakuShinseiDiv div) {
        if (div.getTxtTekiyoYMD().getValue().isValid()) {
            div.getTxtYukoKigenYMD().setValue(FutangendogakuNinteiService.createInstance().estimate有効期限(div.getTxtTekiyoYMD().getValue()));
            getHandler(div).onBlur_txtTekiyoYMD();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 負担段階の編集
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_ddlRiyoshaFutanDankai(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (getHandler(div).check負担段階変更有無()) {
                return ResponseData.of(div).addMessage(DbdWarningMessages.負担段階確認.getMessage()).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onChange_ddlRiyoshaFutanDankai();
            return ResponseData.of(div).respond();
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            getHandler(div).reset負担段階();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「クリアする」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnHaigushaClear(FutangendogakuShinseiDiv div) {
        div.getTxtHaigushaShikibetsuCode().clearDomain();
        div.getTxtHaigushaShimeiKana().clearDomain();
        div.getTxtHaigushaShimei().clearDomain();
        div.getTxtHaigushaUmareYMD().clearValue();
        div.getTxtHaigushaRenrakusaki().clearDomain();
        div.getTxtHaigushaJusho1().clearDomain();
        div.getTxtHaigushaJusho2().clearDomain();
        return ResponseData.of(div).respond();
    }

    /**
     * 「情報を設定する」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_btnHaigushaJohoSet(FutangendogakuShinseiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return getHandler(div).onClick_btnHaigushaJohoSet();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「配偶者の有無」ボタンの処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_radHaigushaUmu(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_radHaigushaUmu();
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請理由」変更時の処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_ddlShinseiRiyu(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_ddlShinseiRiyu();
        return ResponseData.of(div).respond();
    }

    /**
     * 「旧措置」変更時の処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_ddlKyusochisha(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_ddlKyusochisha();
        return ResponseData.of(div).respond();
    }

    /**
     * 「居室種別」変更時の処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onChange_ddlKyoshitsuShubetsu(FutangendogakuShinseiDiv div) {
        getHandler(div).onChange_ddlKyoshitsuShubetsu();
        return ResponseData.of(div).respond();
    }

    /**
     * 「境界層」クリック時の処理
     *
     * @param div FutangendogakuShinseiDiv
     * @return ResponseData<FutangendogakuShinseiDiv>
     */
    public ResponseData<FutangendogakuShinseiDiv> onClick_chkKyokaiso(FutangendogakuShinseiDiv div) {
        getHandler(div).onClick_chkKyokaiso();
        return ResponseData.of(div).respond();
    }

    private FutangendogakuNinteiShinseiHandler getHandler(FutangendogakuShinseiDiv div) {
        return new FutangendogakuNinteiShinseiHandler(div);
    }

    private NinteiShinseiValidationHandler getValidationHandler() {
        return new NinteiShinseiValidationHandler();
    }

}
