/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1070001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuToJotai;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001StateName.世帯情報from一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001StateName.世帯情報from詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001StateName.完了メッセージ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001StateName.申請一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001StateName.申請情報入力;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001TransitionEventName.再検索処理へ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.DBD1070001TransitionEventName.検索結果一覧へ;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.HomonKaigoRiyoshaFutanGengakuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070001.HomonKaigoRiyoshaFutanGengakuHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1070001.HomonKaigoRiyoshaFutanGengakuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 訪問介護利用者負担額減額申請のDivControllerです。
 *
 * @reamsid_L DBD-3730-010 wangjie2
 */
public class HomonKaigoRiyoshaFutanGengakuMain {

    private static final RString 申請メニュー = new RString("DBDMN21003");
    private static final RString ROOTTITLE_承認メニュ = new RString("訪問介護利用者負担額減額申請承認");
    private static final RString ROOTTITLE_申請メニュ = new RString("訪問介護利用者負担額減額申請");
    private final RString 文字列_申請一覧を表示する = new RString("申請一覧を表示する");
    private final RString 文字列_申請入力を表示する = new RString("申請入力を表示する");
    private final RString 文字列_承認入力を表示する = new RString("承認入力を表示する");
    private final RString 保存する = new RString("btnSave");
    private final RString 状態_追加 = new RString("追加");
    private final RString 承認する_Key = new RString("key0");

    /**
     * 画面初期化
     *
     *
     * @param div HomonKaigoRiyoshaFutanGengakuMainDiv
     * @return ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv>
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onLoad(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            ShikibetsuCode 識別コード = null;
            HihokenshaNo 被保険者番号 = null;
            if (taishoshaKey != null) {
                識別コード = taishoshaKey.get識別コード();
                被保険者番号 = taishoshaKey.get被保険者番号();
            }
            if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
                div.getBtnOpenGemmenJoho().setDisabled(true);
                div.getBtnAddShinsei().setDisabled(true);
                div.getDgShinseiList().setDisabled(true);
                div.getBtnAddShinseiJoho().setDisabled(true);
                div.getBtnReturnShinseiIchiran().setDisabled(true);
                div.getBtnOpenHiShoninRiyu().setDisabled(true);
                div.getCcdShinseiJoho().setDisabled(true);
                div.getShogaishaTecho().setDisabled(true);
                div.getBtnOpenHiShoninRiyu().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
                return ResponseData.of(div)
                        .rootTitle(申請メニュー.equals(ResponseHolder.getMenuID()) ? ROOTTITLE_申請メニュ : ROOTTITLE_承認メニュ)
                        .addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
            }
            if (null == 識別コード) {
                識別コード = ShikibetsuCode.EMPTY;
            }
            HomonKaigoRiyoshaFutanGengakuHandler handler = getHandler(div);
            List<HomonKaigoRiyoshaFutangakuGengaku> 申請一覧情報 = handler.get申請一覧情報(被保険者番号);
            ArrayList<HomonKaigoRiyoshaFutangakuGengaku> 最初申請一覧情報 = new ArrayList<>(申請一覧情報);
            ViewStateHolder.put(ViewStateKeys.申請一覧情報, 最初申請一覧情報);
            List<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態List = handler.onLoad(識別コード, 被保険者番号, 申請一覧情報);
            ViewStateHolder.put(ViewStateKeys.申請一覧情報と状態, new ArrayList(情報と状態List));
            if (申請メニュー.equals(ResponseHolder.getMenuID())) {
                return ResponseData.of(div).respond();
            }
            return ResponseData.of(div).rootTitle(ROOTTITLE_承認メニュ).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「世帯情報を表示する」を押下する。<br/>
     *
     * @param div {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnShowSetaiJoho(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        div.getBtnShowSetaiJoho().setDisplayNone(true);
        div.getBtnCloseSetaiJoho().setDisplayNone(false);
        div.getBtnOpenGemmenJoho().setDisplayNone(false);
        Boolean is世帯所得一覧の初期化 = ViewStateHolder.get(ViewStateKeys.is世帯所得一覧の初期化, Boolean.class);
        if (null == is世帯所得一覧の初期化 || !is世帯所得一覧の初期化) {
            getHandler(div).世帯所得一覧の初期化(get識別コードFromViewState());
            ViewStateHolder.put(ViewStateKeys.is世帯所得一覧の初期化, Boolean.TRUE);
        }
        if (申請一覧.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho().setText(文字列_申請一覧を表示する);
            return ResponseData.of(div).setState(世帯情報from一覧);
        } else if (申請情報入力.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho()
                    .setText(申請メニュー.equals(ResponseHolder.getMenuID()) ? 文字列_申請入力を表示する : 文字列_承認入力を表示する);
            return ResponseData.of(div).setState(世帯情報from詳細);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧を表示する」を押下する。<br/>
     *
     * @param div {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnCloseSetaiJoho(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        div.getBtnShowSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisplayNone(true);
        div.getBtnOpenGemmenJoho().setDisplayNone(false);
        if (世帯情報from一覧.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(申請一覧);
        } else {
            return ResponseData.of(div).setState(申請情報入力);
        }
    }

    /**
     * 訪問介護利用者負担額減額申請画面「減免情報を表示する」を押下する。<br/>
     *
     * @param div {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnOpenGemmenJoho(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        div.getHomonKaigoRiyoshaFutanGengaku().setHihokenshaNo(get被保険者番号FromViewState().getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 申請一覧の修正ボタンを押下する。
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onSelectByModifyButton(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        HomonKaigoRiyoshaFutanGengakuHandler handler = getHandler(div);
        ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        HomonKaigoRiyoshaFutangakuGengakuToJotai 情報と状態 = handler.get情報と状態BySelectDataSouce(情報と状態ArrayList);
        ViewStateHolder.put(ViewStateKeys.編集訪問介護利用者負担額減額申請の情報, 情報と状態);
        getHandler(div).onSelectByModifyButton(情報と状態);
        return ResponseData.of(div).setState(申請情報入力);
    }

    /**
     * 申請一覧の削除ボタンを押下する。
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onSelectByDeleteButton(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ViewStateHolder.put(ViewStateKeys.is削除ReRequest, Boolean.FALSE);
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            if (!ViewStateHolder.get(ViewStateKeys.is削除ReRequest, Boolean.class) && !削除処理(div)) {
                ViewStateHolder.put(ViewStateKeys.is削除ReRequest, Boolean.TRUE);
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage()).respond();
            }
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean 削除処理(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        dgShinseiList_Row row = div.getDgShinseiList().getActiveRow();
        if (申請メニュー.equals(ResponseHolder.getMenuID()) && row.getKetteiKubun() != null
                && !row.getKetteiKubun().isEmpty() && !状態_追加.equals(row.getJotai())) {
            return false;
        }
        ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        getHandler(div).onSelectByDeleteButton(情報と状態ArrayList);
        ViewStateHolder.put(ViewStateKeys.申請一覧情報と状態, 情報と状態ArrayList);
        return true;
    }

    private ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> get情報と状態ArrayList() {
        ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList
                = ViewStateHolder.get(ViewStateKeys.申請一覧情報と状態, ArrayList.class);
        if (null == 情報と状態ArrayList) {
            情報と状態ArrayList = new ArrayList<>();
        }
        return 情報と状態ArrayList;
    }

    /**
     * 訪問介護利用者負担額減額申請画面「申請情報を追加する」（また「承認情報を追加する」）を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnAddShinsei(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).onClick_btnAddShinsei(get識別コードFromViewState());
        ViewStateHolder.put(ViewStateKeys.編集訪問介護利用者負担額減額申請の情報, null);
        return ResponseData.of(div).setState(申請情報入力);
    }

    /**
     * 「申請情報を確定する」（また「承認情報を確定する」）ボタンを押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnConfirm(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            情報を確定チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            HomonKaigoRiyoshaFutangakuGengakuToJotai 編集前情報
                    = ViewStateHolder.get(ViewStateKeys.編集訪問介護利用者負担額減額申請の情報, HomonKaigoRiyoshaFutangakuGengakuToJotai.class);
            Integer 追加履歴番号 = ViewStateHolder.get(ViewStateKeys.追加履歴番号, Integer.class);
            if (null == 追加履歴番号 || 追加履歴番号 == 0) {
                追加履歴番号 = -1;
            }
            ArrayList<HomonKaigoRiyoshaFutangakuGengakuToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
            getHandler(div).onClick_btnConfirm(情報と状態ArrayList, 編集前情報, 追加履歴番号, /*最初情報,*/ get被保険者番号FromViewState());
            ViewStateHolder.put(ViewStateKeys.申請一覧情報と状態, 情報と状態ArrayList);
            ViewStateHolder.put(ViewStateKeys.追加履歴番号, 追加履歴番号 - 1);
            return ResponseData.of(div).setState(申請一覧);
        }
        return ResponseData.of(div).respond();
    }

    private void 情報を確定チェック(ValidationMessageControlPairs pairs, HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        HomonKaigoRiyoshaFutanGengakuValidationHandler validationhandler = getValidationHandler();
        validationhandler.申請日の未入力チェック(pairs, div);
        if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            validationhandler.決定日の未入力チェック(pairs, div);
            validationhandler.決定区分の未入力チェック(pairs, div);
            if (承認する_Key.equals(div.getDdlKettaiKubun().getSelectedKey())) {
                validationhandler.法別区分の未入力チェック(pairs, div);
                validationhandler.公費受給者番号の未入力チェック(pairs, div);
                validationhandler.有効期限の未入力チェック(pairs, div);
                validationhandler.給付率の未入力チェック(pairs, div);
                validationhandler.適用日の未入力チェック(pairs, div);
                validationhandler.訪問介護利用者負担額減額_給付率範囲外チェック(pairs, div);
                validationhandler.訪問介護利用者負担額減額_適用開始日が法施行以前チェック(pairs, div);
                validationhandler.訪問介護利用者負担額減額_適用終了日が年度外チェック(pairs, div);
                validationhandler.訪問介護利用者負担額減額_適用終了日が開始日以前チェック(pairs, div);
                validationhandler.受給共通_受給者登録なしチェック(pairs, div);
            }
        }
    }

    /**
     * 「申請一覧に戻る」ボタンを押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnReturnShinseiIchiran(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            HomonKaigoRiyoshaFutanGengakuHandler handler = getHandler(div);
            handler.close申請一覧エリア(false);
            handler.close情報エリア(true);
            handler.ボタン制御();
            return ResponseData.of(div).setState(申請一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報を保存する」（また「承認情報を保存する」）ボタンを押下する。<br/>
     *
     * @param div {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnUpdate(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        HomonKaigoRiyoshaFutanGengakuHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            if (!handler.変更有無チェック()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            HomonKaigoRiyoshaFutanGengakuValidationHandler validationhandler = getValidationHandler();
            if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
                validationhandler.減免減額_適用期間重複チェック(pairs, div);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ArrayList<HomonKaigoRiyoshaFutangakuGengaku> 最初申請一覧情報
                    = ViewStateHolder.get(ViewStateKeys.申請一覧情報, ArrayList.class);
            handler.onClick_btnUpdate(get情報と状態ArrayList(),
                    get識別コードFromViewState(), get被保険者番号FromViewState(), 最初申請一覧情報);
            return ResponseData.of(div).setState(完了メッセージ);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」を押下し、URZ.SampleBunshoToroku　をダイアログで表示する。<br/>
     *
     * @param div {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onOpenBefore_btnOpenHiShoninRiyu(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        div.getHomonKaigoGengakuShinseiDetail()
                .setSubGyomuCode(GyomuCode.DB介護保険.getColumnValue());
        div.getHomonKaigoGengakuShinseiDetail()
                .setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        div.getHomonKaigoGengakuShinseiDetail().setTeikeibun(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * URZ.SampleBunshoToroku　をダイアログで表示し、選択する。
     *
     * @param div {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClose_btnOpenHiShoninRiyu(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        div.getTxtHiShoninRiyu().setValue(div.getHomonKaigoGengakuShinseiDetail().getTeikeibun());
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「決定区分」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onChange_ddlKettaiKubun(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).onChange_ddlKettaiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「検索結果一覧へ」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnToSearchResult(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).前排他の解除(get被保険者番号FromViewState());
        return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「再検索する」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onClick_btnReSearch(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).前排他の解除(get被保険者番号FromViewState());
        return ResponseData.of(div).forwardWithEventName(再検索処理へ).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「障害者手帳有無」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onChange_radShogaishaTechoUmu(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).onChange_radShogaishaTechoUmu();
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「法別区分ddl」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onChange_ddlHobetsuKubun(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).onChange_ddlHobetsuKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「適用日」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onBlur_txtTekiyoYmd(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).onBlur_txtTekiyoYmd();
        return ResponseData.of(div).respond();
    }

    /**
     * 訪問介護利用者負担額減額申請画面「公費受給者番号」を押下する。<br/>
     *
     * @param div
     * {@link HomonKaigoRiyoshaFutanGengakuMainDiv 訪問介護利用者負担額減額申請画面Div}
     * @return 訪問介護利用者負担額減額申請Divを持つResponseData
     */
    public ResponseData<HomonKaigoRiyoshaFutanGengakuMainDiv> onBlur_txtKohiJyukyshaNo(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        getHandler(div).onBlur_txtKohiJyukyshaNo();
        return ResponseData.of(div).respond();
    }

    private HihokenshaNo get被保険者番号FromViewState() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (null == taishoshaKey) {
            return HihokenshaNo.EMPTY;
        }
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        if (null == 被保険者番号) {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        return 被保険者番号;
    }

    private ShikibetsuCode get識別コードFromViewState() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (null == taishoshaKey) {
            return ShikibetsuCode.EMPTY;
        }
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        return 識別コード;
    }

    private HomonKaigoRiyoshaFutanGengakuHandler getHandler(HomonKaigoRiyoshaFutanGengakuMainDiv div) {
        return new HomonKaigoRiyoshaFutanGengakuHandler(div);
    }

    private HomonKaigoRiyoshaFutanGengakuValidationHandler getValidationHandler() {
        return new HomonKaigoRiyoshaFutanGengakuValidationHandler();
    }

}
