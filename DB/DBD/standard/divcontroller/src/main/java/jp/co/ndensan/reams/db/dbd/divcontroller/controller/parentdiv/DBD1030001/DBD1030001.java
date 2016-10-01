/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigenIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shakaifukushihojinkeigen.ShakaifukuRiyoshaFutanKeigenToJotai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001Div;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.世帯情報from一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.世帯情報from詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.完了;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001TransitionEventName.検索処理へ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001TransitionEventName.検索結果一覧へ;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001Handler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 社会福祉法人等利用者負担軽減申請画面のDivControllerです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class DBD1030001 {

    private final RString 文字列_申請一覧を表示する = new RString("申請一覧を表示する");
    private final RString 文字列_申請入力を表示する = new RString("申請入力を表示する");
    private final RString 文字列_承認入力を表示する = new RString("承認入力を表示する");
    private static final RString 申請メニューID = new RString("DBDMN21004");
    private static final RString KEY0 = new RString("key0");
    private static final RString ROOTTITLE_承認メニュ = new RString("社会福祉法人等利用者負担軽減申請承認");
    private static final RString ROOTTITLE_申請メニュ = new RString("社会福祉法人等利用者負担軽減申請");
    private final RString 保存する = new RString("btnUpdate");
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");

    /**
     * 画面初期化
     *
     * @param div DBD1030001Div
     * @return ResponseData<DBD1030001Div>
     */
    public ResponseData<DBD1030001Div> onLoad(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {

            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            ShikibetsuCode 識別コード = null;
            HihokenshaNo 被保険者番号 = null;
            if (taishoshaKey != null) {
                識別コード = taishoshaKey.get識別コード();
                被保険者番号 = taishoshaKey.get被保険者番号();
            }
            if (null == 識別コード) {
                識別コード = ShikibetsuCode.EMPTY;
            }
            if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
                div.getShafukuRiyoshaKeigen().getBtnShowGenmenJoho().setDisabled(true);
                div.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho().setDisabled(true);
                div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho().setDisplayNone(true);
                div.getBtnAddShinsei().setDisabled(true);
                div.getDgShinseiList().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
                InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                        DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
                return ResponseData.of(div)
                        .rootTitle(申請メニューID.equals(ResponseHolder.getMenuID()) ? ROOTTITLE_申請メニュ : ROOTTITLE_承認メニュ)
                        .addMessage(message).respond();
            }
            div.setHiddenHihokenshaNo(被保険者番号.getColumnValue());
            div.setHiddenShikibetsuCode(識別コード.getColumnValue());
            DBD1030001Handler handler = getHandler(div);
            List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報 = handler.申請一覧データ準備(被保険者番号);
            ArrayList<ShakaifukuRiyoshaFutanKeigen> 最初申請一覧情報 = new ArrayList<>(申請一覧情報);
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報, 最初申請一覧情報);
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, handler.onLoad(識別コード, 被保険者番号, 申請一覧情報));
            ViewStateHolder.put(DBD1030001ViewStateKey.is申請情報のDDL初期化, Boolean.FALSE);
            if (申請メニューID.equals(ResponseHolder.getMenuID())) {
                return ResponseData.of(div).respond();
            }
            return ResponseData.of(div).rootTitle(ROOTTITLE_承認メニュ).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「世帯情報を表示する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnShowSetaiJoho(DBD1030001Div div) {
        div.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho().setDisplayNone(true);
        div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho().setDisplayNone(false);
        div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho().setDisabled(false);
        Boolean is世帯所得一覧の初期化 = ViewStateHolder.get(DBD1030001ViewStateKey.is世帯所得一覧の初期化, Boolean.class);
        if (null == is世帯所得一覧の初期化 || !is世帯所得一覧の初期化) {
            getHandler(div).世帯所得一覧の初期化(get識別コードFromViewState());
            ViewStateHolder.put(DBD1030001ViewStateKey.is世帯所得一覧の初期化, Boolean.TRUE);
        }
        if (一覧.getName().equals(ResponseHolder.getState())) {
            div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho().setText(文字列_申請一覧を表示する);
            return ResponseData.of(div).setState(世帯情報from一覧);
        } else if (詳細.getName().equals(ResponseHolder.getState())) {
            div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho()
                    .setText(申請メニューID.equals(ResponseHolder.getMenuID()) ? 文字列_申請入力を表示する : 文字列_承認入力を表示する);
            return ResponseData.of(div).setState(世帯情報from詳細);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧を表示する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnCloseSetaiJoho(DBD1030001Div div) {
        div.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho().setDisplayNone(false);
        div.getShafukuRiyoshaKeigen().getBtnCloseSetaiJoho().setDisplayNone(true);
        if (世帯情報from一覧.getName().equals(ResponseHolder.getState())) {
            return ResponseData.of(div).setState(一覧);
        } else {
            return ResponseData.of(div).setState(詳細);
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を追加する」（また「承認情報を追加する」）を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnAddShinsei(DBD1030001Div div) {
        ViewStateHolder.put(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, null);
        申請情報のDDL初期化(div);
        getHandler(div).onClick_btnAddShinsei(get識別コードFromViewState());
        return ResponseData.of(div).setState(詳細);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の修正ボタン」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onSelectByModifyButton(DBD1030001Div div) {
        申請情報のDDL初期化(div);
        DBD1030001Handler handler = getHandler(div);
        ShakaifukuRiyoshaFutanKeigenToJotai 情報と状態 = handler.get情報と状態BySelectDataSouce(get情報と状態ArrayList());
        ViewStateHolder.put(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, 情報と状態);
        getHandler(div).onClick_onSelectByModifyButton(get識別コードFromViewState(), 情報と状態);
        return ResponseData.of(div).setState(詳細);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の削除ボタン」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onSelectByDeleteButton(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            ViewStateHolder.put(DBD1030001ViewStateKey.is削除ReRequest, Boolean.FALSE);
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            if (!ViewStateHolder.get(DBD1030001ViewStateKey.is削除ReRequest, Boolean.class) && !削除処理(div)) {
                ViewStateHolder.put(DBD1030001ViewStateKey.is削除ReRequest, Boolean.TRUE);
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage()).respond();
            }
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean 削除処理(DBD1030001Div div) {
        dgShinseiList_Row dataSouce = div.getDgShinseiList().getActiveRow();
        if (dataSouce.getKetteiKubun() != null && !dataSouce.getKetteiKubun().isEmpty() && !状態_追加.equals(dataSouce.getJotai())) {
            return false;
        }
        RString 状態 = dataSouce.getJotai();
        if (状態.isEmpty() || 状態_修正.equals(状態)) {
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList
                    = getHandler(div).元状態変更(dataSouce, 状態_削除, get情報と状態ArrayList());
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
        } else if (状態_追加.equals(状態)) {
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList
                    = getHandler(div).dataSourceの削除(dataSouce, get情報と状態ArrayList());
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
        }
        return true;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「決定区分」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_radKetteiKubun(DBD1030001Div div) {
        getHandler(div).onClick_radKetteiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「承認しない理由」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onBeforeOpenDialog(DBD1030001Div div) {
        div.getShafukuRiyoshaKeigen().setSubGyomuCode(DataPassingConverter.serialize(SubGyomuCode.DBD介護受給));
        div.getShafukuRiyoshaKeigen().setSampleBunshoGroupCode(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧に戻る」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnBackToShinseiList(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).情報エリアクリア();
            return ResponseData.of(div).setState(一覧);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を確定する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnShinseiKakutei(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            if (div.getTxtShinseiYMD().getValue().isEmpty()) {
                getValidationHandler().申請日の未入力チェック(pairs, div);
            } else {
                pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtShinseiYMD()));
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            ShakaifukuRiyoshaFutanKeigenToJotai 編集情報
                    = ViewStateHolder.get(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, ShakaifukuRiyoshaFutanKeigenToJotai.class);
            Integer 追加履歴番号 = ViewStateHolder.get(DBD1030001ViewStateKey.追加履歴番号, Integer.class);
            if (null == 追加履歴番号 || 追加履歴番号 == 0) {
                追加履歴番号 = -1;
            }
            ShakaifukuRiyoshaFutanKeigenToJotai 最初情報 = null;
            if (編集情報 != null) {
                最初情報 = get最初情報(編集情報);
            }
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList
                    = getHandler(div).情報を確定(get情報と状態ArrayList(), 編集情報, 追加履歴番号, 最初情報, get被保険者番号FromViewState());
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
            ViewStateHolder.put(DBD1030001ViewStateKey.追加履歴番号, 追加履歴番号 - 1);
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    private ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> get情報と状態ArrayList() {
        ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> 情報と状態ArrayList
                = ViewStateHolder.get(DBD1030001ViewStateKey.申請一覧情報と状態, ArrayList.class);
        if (null == 情報と状態ArrayList) {
            情報と状態ArrayList = new ArrayList<>();
        }
        return 情報と状態ArrayList;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「承認情報を確定する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnShoninKakutei(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            DBD1030001ValidationHandler validationHandler = getValidationHandler();
            if (div.getTxtShinseiYMD().getValue().isEmpty()) {
                validationHandler.申請日の未入力チェック(pairs, div);
            } else {
                pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtShinseiYMD()));
            }
            if (KEY0.equals(div.getRadKetteiKubun().getSelectedKey())) {
                validationHandler.決定区分の未入力チェック(pairs, div);
                if (div.getTxtKetteiYMD().getValue().isEmpty()) {
                    validationHandler.決定日の未入力チェック(pairs, div);
                } else {
                    pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtKetteiYMD()));
                }
                if (div.getTxtTekiyoYMD().getValue().isEmpty()) {
                    validationHandler.適用日の未入力チェック(pairs, div);
                } else {
                    pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtTekiyoYMD()));
                }
                if (div.getTxtYukoKigenYMD().getValue().isEmpty()) {
                    validationHandler.有効期限の未入力チェック(pairs, div);
                } else {
                    pairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getTxtYukoKigenYMD()));
                }
                validationHandler.軽減事由の未入力チェック(pairs, div);
                validationHandler.軽減率_分子の未入力チェック(pairs, div);
                validationHandler.軽減率_分母の未入力チェック(pairs, div);
                validationHandler.確認番号の未入力チェック(pairs, div);
            }
            if (pairs.existsError()) {
                ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (KEY0.equals(div.getRadKetteiKubun().getSelectedKey())) {
                validationHandler.承認情報相関チェック１(pairs, div);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            ShakaifukuRiyoshaFutanKeigenToJotai 編集情報
                    = ViewStateHolder.get(DBD1030001ViewStateKey.編集社会福祉法人等利用者負担軽減申請の情報, ShakaifukuRiyoshaFutanKeigenToJotai.class);
            Integer 追加履歴番号 = ViewStateHolder.get(DBD1030001ViewStateKey.追加履歴番号, Integer.class);
            if (null == 追加履歴番号 || 追加履歴番号 == 0) {
                追加履歴番号 = -1;
            }
            ShakaifukuRiyoshaFutanKeigenToJotai 最初情報 = null;
            if (編集情報 != null) {
                最初情報 = get最初情報(編集情報);
            }
            ArrayList<ShakaifukuRiyoshaFutanKeigenToJotai> new情報と状態ArrayList
                    = getHandler(div).情報を確定(get情報と状態ArrayList(), 編集情報, 追加履歴番号, 最初情報, get被保険者番号FromViewState());
            ViewStateHolder.put(DBD1030001ViewStateKey.追加履歴番号, 追加履歴番号 - 1);
            ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, new情報と状態ArrayList);
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    private ShakaifukuRiyoshaFutanKeigenToJotai get最初情報(ShakaifukuRiyoshaFutanKeigenToJotai 編集情報) {
        ShakaifukuRiyoshaFutanKeigenIdentifier id = 編集情報.get社会福祉法人等利用者負担軽減情報().identifier();
        ArrayList<ShakaifukuRiyoshaFutanKeigen> 最初申請一覧情報 = ViewStateHolder.get(DBD1030001ViewStateKey.申請一覧情報, ArrayList.class);
        for (ShakaifukuRiyoshaFutanKeigen 最初情報 : 最初申請一覧情報) {
            if (id.equals(最初情報.identifier())) {
                return new ShakaifukuRiyoshaFutanKeigenToJotai(最初情報, RString.EMPTY, 編集情報.get新履歴番号());
            }
        }
        return 編集情報;
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「再検索する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnReSearch(DBD1030001Div div) {
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, null);
        getHandler(div).前排他の解除(get被保険者番号FromViewState());
        return ResponseData.of(div).forwardWithEventName(検索処理へ).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「検索結果一覧へ」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnToSearchResult(DBD1030001Div div) {
        ViewStateHolder.put(DBD1030001ViewStateKey.申請一覧情報と状態, null);
        getHandler(div).前排他の解除(get被保険者番号FromViewState());
        return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請情報を保存する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnUpdate(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest()) {
            if (!getHandler(div).変更有無チェック(get情報と状態ArrayList())) {
                InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                        DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            RString メニューID = ResponseHolder.getMenuID();
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            if (!申請メニューID.equals(メニューID)) {
                DBD1030001ValidationHandler validationHandler = getValidationHandler();
                validationHandler.減免減額_適用期間重複チェック(pairs, div);
                validationHandler.減免減額_確認番号が既に存在チェック(pairs, div);
            }
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).onClick_btnUpdate(get情報と状態ArrayList(), get識別コードFromViewState(), get被保険者番号FromViewState());
            return ResponseData.of(div).setState(完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を適用日入力する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onBlur_txtTekiyoYMD(DBD1030001Div div) {
        getHandler(div).onBlur_txtTekiyoYMD();
        return ResponseData.of(div).respond();
    }

    private void 申請情報のDDL初期化(DBD1030001Div div) {
        Boolean is申請情報のDDL初期化 = ViewStateHolder.get(DBD1030001ViewStateKey.is申請情報のDDL初期化, Boolean.class);
        if (!Boolean.TRUE.equals(is申請情報のDDL初期化)) {
            div.getCcdShinseiJoho().initialize(get識別コードFromViewState());
            div.getDdlKeigenJiyu().setDataSource(getAll軽減事由());
            ViewStateHolder.put(DBD1030001ViewStateKey.is申請情報のDDL初期化, Boolean.TRUE);
        }
    }

    private List<KeyValueDataSource> getAll軽減事由() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        dataSourceList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        dataSourceList.add(new KeyValueDataSource(GemmenKubun.非課税_老年受給.getコード(), GemmenKubun.非課税_老年受給.get名称()));
        dataSourceList.add(new KeyValueDataSource(GemmenKubun.生保に準ずる.getコード(), GemmenKubun.生保に準ずる.get名称()));
        dataSourceList.add(new KeyValueDataSource(GemmenKubun.その他.getコード(), GemmenKubun.その他.get名称()));
        dataSourceList.add(new KeyValueDataSource(GemmenKubun.生計困難.getコード(), GemmenKubun.生計困難.get名称()));
        dataSourceList.add(new KeyValueDataSource(GemmenKubun.激変緩和.getコード(), GemmenKubun.激変緩和.get名称()));
        return dataSourceList;

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

    private DBD1030001Handler getHandler(DBD1030001Div div) {
        return new DBD1030001Handler(div);
    }

    private DBD1030001ValidationHandler getValidationHandler() {
        return new DBD1030001ValidationHandler();
    }

    /**
     * 引数定義<br/>
     *
     */
    public enum DBD1030001ViewStateKey {

        /**
         * 申請一覧情報です。
         */
        申請一覧情報,
        /**
         * 申請一覧情報と状態です。
         */
        申請一覧情報と状態,
        /**
         * 編集社会福祉法人等利用者負担軽減申請の情報です。
         */
        編集社会福祉法人等利用者負担軽減申請の情報,
        /**
         * 追加履歴番号です。
         */
        追加履歴番号,
        /**
         * 追加履歴番号です。
         */
        is申請情報のDDL初期化,
        /**
         * is削除ReRequestです。
         */
        is削除ReRequest,
        /**
         *
         */
        is世帯所得一覧の初期化;
    }

}
