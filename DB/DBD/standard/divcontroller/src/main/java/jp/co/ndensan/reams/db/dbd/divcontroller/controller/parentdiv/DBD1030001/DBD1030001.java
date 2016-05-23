/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1030001;

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
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001Handler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001Handler.DBD1030001ViewStateKey;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001ValidationHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
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
    private static final RString ROOTTITLE_承認メニュ = new RString("社会福祉法事等利用者負担軽減申請承認");

    /**
     * 画面初期化
     *
     * @param div DBD1030001Div
     * @return ResponseData<DBD1030001Div>
     */
    public ResponseData<DBD1030001Div> onLoad(DBD1030001Div div) {
        if (!ResponseHolder.isReRequest() && !getHandler(div).onLoad()) {
            InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            if (申請メニューID.equals(ResponseHolder.getMenuID())) {
                return ResponseData.of(div).addMessage(message).respond();
            }
            return ResponseData.of(div).rootTitle(ROOTTITLE_承認メニュ).addMessage(message).respond();
        }
        if (申請メニューID.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).rootTitle(ROOTTITLE_承認メニュ).respond();
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
        getHandler(div).世帯所得一覧の初期化();
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
        getHandler(div).onClick_btnAddShinsei();
        return ResponseData.of(div).setState(詳細);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「申請一覧の修正ボタン」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_onSelectByModifyButton(DBD1030001Div div) {
        getHandler(div).onClick_onSelectByModifyButton();
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
            if (!ViewStateHolder.get(DBD1030001ViewStateKey.is削除ReRequest, Boolean.class) && !getHandler(div).onClick_onSelectByDeleteButton()) {
                ViewStateHolder.put(DBD1030001ViewStateKey.is削除ReRequest, Boolean.TRUE);
                return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage()).respond();
            }
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
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
            getValidationHandler().申請日の未入力チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getHandler(div).情報を確定();
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
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
            validationHandler.申請日の未入力チェック(pairs, div);
            if (KEY0.equals(div.getRadKetteiKubun().getSelectedKey())) {
                validationHandler.決定区分の未入力チェック(pairs, div);
                validationHandler.決定日の未入力チェック(pairs, div);
                validationHandler.適用日の未入力チェック(pairs, div);
                validationHandler.有効期限の未入力チェック(pairs, div);
                validationHandler.軽減事由の未入力チェック(pairs, div);
                validationHandler.軽減率_分子の未入力チェック(pairs, div);
                validationHandler.軽減率_分母の未入力チェック(pairs, div);
                validationHandler.確認番号の未入力チェック(pairs, div);
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
            getHandler(div).情報を確定();
            return ResponseData.of(div).setState(一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「再検索する」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnReSearch(DBD1030001Div div) {
        ViewStateHolder.put(DBD1030001Handler.DBD1030001ViewStateKey.申請一覧情報と状態, null);
        getHandler(div).前排他の解除();
        return ResponseData.of(div).forwardWithEventName(検索処理へ).respond();
    }

    /**
     * 社会福祉法人等利用者負担軽減申請画面を「検索結果一覧へ」を押下する。<br/>
     *
     * @param div {@link DBD1030001Div 社会福祉法人等利用者負担軽減申請画面Div}
     * @return 社会福祉法人等利用者負担軽減申請画面Divを持つResponseData
     */
    public ResponseData<DBD1030001Div> onClick_btnToSearchResult(DBD1030001Div div) {
        ViewStateHolder.put(DBD1030001Handler.DBD1030001ViewStateKey.申請一覧情報と状態, null);
        getHandler(div).前排他の解除();
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
            if (!getHandler(div).変更有無チェック()) {
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
            getHandler(div).onClick_btnUpdate();
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

    private DBD1030001Handler getHandler(DBD1030001Div div) {
        return new DBD1030001Handler(div);
    }

    private DBD1030001ValidationHandler getValidationHandler() {
        return new DBD1030001ValidationHandler();
    }

}
