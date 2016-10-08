/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoToJotai;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011StateName.一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011StateName.世帯一覧from一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011StateName.世帯一覧from詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011StateName.完了;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011StateName.詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011TransitionEventName.検索処理へ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.DBD4020011TransitionEventName.検索結果一覧へ;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler;
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
 * 障がい者控除対象者申請登録画面のDivControllerです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKojoTaishoshaShinseiTorokuMain {

    private final RString 保存する = new RString("btnUpdate");
    private final RString 申請メニュー = new RString("DBDMN41002");
    private final RString 状態_追加 = new RString("追加");
    private static final RString ROOTTITLE_承認メニュ = new RString("障がい者控除対象者申請承認");
    private static final RString ROOTTITLE_申請メニュ = new RString("障がい者控除対象者申請登録");
    private final RString 文字列_申請一覧を表示する = new RString("申請一覧を表示する");
    private final RString 文字列_申請入力を表示する = new RString("申請入力を表示する");
    private final RString 文字列_承認入力を表示する = new RString("承認入力を表示する");
    private final RString 漢字承認する = new RString("承認する");

    /**
     * 画面初期化
     *
     * @param div ShogaishaKojoTaishoshaShinseiTorokuMainDiv
     * @return ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv>
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onLoad(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        ShogaishaKojoTaishoshaShinseiTorokuMainHandler hanlder = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            if (null == taishoshaKey) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
            }
            ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
            }
            List<ShogaishaKoujo> 申請一覧情報 = hanlder.申請一覧情報の取得(被保険者番号);
            ArrayList<ShogaishaKoujo> 申請一覧情報ArrayList = new ArrayList<>(申請一覧情報);
            List<ShogaishaKoujoToJotai> 情報と状態Lis = hanlder.onLoad(識別コード, 被保険者番号, 申請一覧情報);
            ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList = new ArrayList<>(情報と状態Lis);
            ViewStateHolder.put(ViewStateKeys.申請一覧情報, 申請一覧情報ArrayList);
            ViewStateHolder.put(ViewStateKeys.申請一覧情報と状態, 情報と状態ArrayList);
        }
        if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            div.getBtnShowSetaiJoho().setDisabled(true);
            div.getBtnDispGemmenJoho().setDisabled(true);
            div.getBtnBackToShinseiList().setDisabled(true);
            div.getTxtDetermineShinsei().setDisabled(true);
            div.getBtnAddShinsei().setDisabled(true);
            div.getDgShinseiList().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
        }
        RString rootTitle = ROOTTITLE_申請メニュ;
        if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            rootTitle = ROOTTITLE_承認メニュ;
        }
        return ResponseData.of(div).rootTitle(rootTitle).respond();
    }

    /**
     * 障がい者控除対象者申請登録画面「世帯情報を表示する」を押下する。<br/>
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnShowSetaiJoho(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        div.getBtnShowSetaiJoho().setDisplayNone(true);
        div.getBtnCloseSetaiJoho().setDisplayNone(false);
        Boolean is世帯所得一覧の初期化 = ViewStateHolder.get(ViewStateKeys.is世帯所得一覧の初期化, Boolean.class);
        if (null == is世帯所得一覧の初期化 || !is世帯所得一覧の初期化) {
            getHandler(div).世帯所得一覧の初期化(get識別コードFromViewState());
            ViewStateHolder.put(ViewStateKeys.is世帯所得一覧の初期化, Boolean.TRUE);
        }
        if (一覧.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho().setText(文字列_申請一覧を表示する);
            return ResponseData.of(div).setState(世帯一覧from一覧);
        } else if (詳細.getName().equals(ResponseHolder.getState())) {
            div.getBtnCloseSetaiJoho()
                    .setText(申請メニュー.equals(ResponseHolder.getMenuID()) ? 文字列_申請入力を表示する : 文字列_承認入力を表示する);
            return ResponseData.of(div).setState(世帯一覧from詳細);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 障がい者控除対象者申請登録画面「申請一覧を表示する」を押下する。<br/>
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnCloseSetaiJoho(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        div.getBtnShowSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisplayNone(true);
        if (世帯一覧from一覧.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(一覧);
        } else {
            return ResponseData.of(div).setState(詳細);
        }
    }

    /**
     * 障がい者控除対象者申請登録画面「申請情報を追加する」（また「承認情報を追加する」）を押下する。<br/>
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnAddShinsei(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        getHandler(div).onClick_btnAddShinsei(get識別コードFromViewState());
        ViewStateHolder.put(ViewStateKeys.編集障がい者控除申請登録の情報, null);
        return ResponseData.of(div).setState(詳細);
    }

    /**
     * 申請一覧の修正ボタンを押下する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onSelectByModifyButton(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        ShogaishaKojoTaishoshaShinseiTorokuMainHandler handler = getHandler(div);
        ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        ShogaishaKoujoToJotai 情報と状態 = handler.get情報と状態BySelectDataSouce(情報と状態ArrayList);
        ViewStateHolder.put(ViewStateKeys.編集障がい者控除申請登録の情報, 情報と状態);
        ShogaishaKoujo 最初情報 = null;
        if (情報と状態 != null) {
            最初情報 = get書控除申請登録最初情報(情報と状態);
        }
        boolean is承認情報 = 最初情報 != null && 最初情報.get決定区分() != null && !最初情報.get決定区分().isEmpty();
        getHandler(div).onSelectByModifyButton(情報と状態, is承認情報);
        return ResponseData.of(div).setState(詳細);
    }

    private ShogaishaKoujo get書控除申請登録最初情報(ShogaishaKoujoToJotai 編集情報) {
        ShogaishaKoujoIdentifier id = 編集情報.get障がい書控除申請登録情報().identifier();
        ArrayList<ShogaishaKoujo> 最初申請一覧情報 = ViewStateHolder.get(ViewStateKeys.申請一覧情報, ArrayList.class);
        for (ShogaishaKoujo 最初情報 : 最初申請一覧情報) {
            if (id.equals(最初情報.identifier())) {
                return 最初情報;
            }
        }
        return null;
    }

    /**
     * 申請一覧の削除ボタンを押下する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onSelectByDeleteButton(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
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

    private boolean 削除処理(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        dgShinseiList_Row row = div.getDgShinseiList().getActiveRow();
        if (row.getKetteiKubun() != null && !row.getKetteiKubun().isEmpty() && !状態_追加.equals(row.getJotai())) {
            return false;
        }
        ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
        getHandler(div).onSelectByDeleteButton(情報と状態ArrayList);
        ViewStateHolder.put(ViewStateKeys.申請一覧情報と状態, 情報と状態ArrayList);
        return true;
    }

    private ArrayList<ShogaishaKoujoToJotai> get情報と状態ArrayList() {
        ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList
                = ViewStateHolder.get(ViewStateKeys.申請一覧情報と状態, ArrayList.class);
        if (null == 情報と状態ArrayList) {
            情報と状態ArrayList = new ArrayList<>();
        }
        return 情報と状態ArrayList;
    }

    /**
     * 決定区分を押下する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onChange_radKettaiKubun(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        getHandler(div).onChange_radKettaiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」ボタンを押下する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnHiShoninRiyu(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        div.getShogaishaKojoTaishoshaShinseiToroku().setSubGyomuCode(GyomuCode.DB介護保険.getColumnValue());
        div.getShogaishaKojoTaishoshaShinseiToroku().setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        div.getShogaishaKojoTaishoshaShinseiToroku().setTeikeibun(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * URZ.SampleBunshoToroku　をダイアログで表示し、選択する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClose_btnOpenHiShoninRiyu(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        div.getTxtHiShoninRiyu().setValue(div.getShogaishaKojoTaishoshaShinseiToroku().getTeikeibun());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」　ボタンを押下する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnBack(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).前排他解除(get被保険者番号FromViewState());
            return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」　ボタンを押下する。
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_reSearch(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).前排他解除(get被保険者番号FromViewState());
            return ResponseData.of(div).forwardWithEventName(検索処理へ).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請一覧に戻る」ボタンを押下する。<br/>
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnBackToShinseiList(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            div.getBtnAddShinsei().setDisabled(false);
            div.getDgShinseiList().setDisabled(false);
            getHandler(div).申請情報エリア非活性制御();
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報を確定する」（また「承認情報を確定する」）ボタンを押下する。<br/>
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnConfirm(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler validationhandler = getValidationHandler();
            validationhandler.申請日の未入力チェック(pairs, div);
            if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
                承認情報チェック(pairs, div, validationhandler);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            ShogaishaKoujoToJotai 編集情報
                    = ViewStateHolder.get(ViewStateKeys.編集障がい者控除申請登録の情報, ShogaishaKoujoToJotai.class);
            Integer 追加履歴番号 = ViewStateHolder.get(ViewStateKeys.追加履歴番号, Integer.class);
            if (null == 追加履歴番号 || 追加履歴番号 == 0) {
                追加履歴番号 = -1;
            }
            ShogaishaKoujoToJotai 最初情報 = null;
            if (編集情報 != null) {
                最初情報 = get最初情報(編集情報);
            }
            ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList = get情報と状態ArrayList();
            getHandler(div).onClick_btnConfirm(情報と状態ArrayList, 編集情報, 追加履歴番号, 最初情報, get被保険者番号FromViewState());
            ViewStateHolder.put(ViewStateKeys.申請一覧情報と状態, 情報と状態ArrayList);
            ViewStateHolder.put(ViewStateKeys.追加履歴番号, 追加履歴番号 - 1);
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    private void 承認情報チェック(ValidationMessageControlPairs pairs, ShogaishaKojoTaishoshaShinseiTorokuMainDiv div,
            ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler validationhandler) {
        validationhandler.決定日の未入力チェック(pairs, div);
        validationhandler.対象年度の未入力チェック(pairs, div);
        if (漢字承認する.equals(div.getRadKettaiKubun().getSelectedValue())) {
            validationhandler.認知証高齢者自立度の未入力チェック(pairs, div);
            validationhandler.障がい高齢者自立度の未入力チェック(pairs, div);
            validationhandler.認定区分の未入力チェック(pairs, div);
            validationhandler.認定内容の未入力チェック(pairs, div);
        }
    }

    private ShogaishaKoujoToJotai get最初情報(ShogaishaKoujoToJotai 編集情報) {
        ShogaishaKoujoIdentifier id = 編集情報.get障がい書控除申請登録情報().identifier();
        ArrayList<ShogaishaKoujo> 最初申請一覧情報 = ViewStateHolder.get(ViewStateKeys.申請一覧情報, ArrayList.class);
        for (ShogaishaKoujo 最初情報 : 最初申請一覧情報) {
            if (id.equals(最初情報.identifier())) {
                return new ShogaishaKoujoToJotai(最初情報, RString.EMPTY, 編集情報.get新履歴番号());
            }
        }
        return 編集情報;
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

    /**
     * 「申請情報を保存する」（また「承認情報を保存する」）ボタンを押下する。<br/>
     *
     * @param div {@link ShogaishaKojoTaishoshaShinseiTorokuMainDiv 障がい者控除対象者申請登録画面Div}
     * @return 障がい者控除対象者申請登録Divを持つResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> onClick_btnUpdate(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        ShogaishaKojoTaishoshaShinseiTorokuMainHandler handler = getHandler(div);
        if (!ResponseHolder.isReRequest()) {
            if (!handler.変更有無チェック()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler validationhandler = getValidationHandler();
            if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
                validationhandler.対象年度重複チェック(pairs, div);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            handler.onClick_btnUpdate(get情報と状態ArrayList(), get識別コードFromViewState(), get被保険者番号FromViewState());
            return ResponseData.of(div).setState(完了);
        }
        return ResponseData.of(div).respond();
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

    private ShogaishaKojoTaishoshaShinseiTorokuMainHandler getHandler(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        return new ShogaishaKojoTaishoshaShinseiTorokuMainHandler(div);
    }

    private ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler getValidationHandler() {
        return new ShogaishaKojoTaishoshaShinseiTorokuMainValidationHandler();
    }

}
