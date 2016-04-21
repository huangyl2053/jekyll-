/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1030001;

import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001Div;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.一覧;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.完了;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001StateName.詳細;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001TransitionEventName.検索処理へ;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001TransitionEventName.検索結果一覧へ;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001.DBD1030001Handler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 社会福祉法人等利用者負担軽減申請画面のDivControllerです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class DBD1030001 {

    private static final RString 申請メニューID = new RString("DBDMN21004");

    /**
     * 画面初期化
     *
     * @param div DBD1030001Div
     * @return ResponseData<DBD1030001Div>
     */
    public ResponseData<DBD1030001Div> onLoad(DBD1030001Div div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
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
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            getHandler(div).onClick_onSelectByDeleteButton();
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
        if (getHandler(div).is申請情報エリア入力内容がある()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
                return ResponseData.of(div).setState(一覧);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(一覧);
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
            getHandler(div).onClick_btnShinseiKakutei();
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
            getHandler(div).onClick_btnShoninKakutei();
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
            getHandler(div).変更有無チェック();
            RString メニューID = ResponseHolder.getMenuID();
            if (!申請メニューID.equals(メニューID)) {
                getHandler(div).相関チェック２();
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
    public ResponseData<DBD1030001Div> onClick_onBlur(DBD1030001Div div) {
        getHandler(div).onClick_onBlur();
        return ResponseData.of(div).respond();
    }

    private DBD1030001Handler getHandler(DBD1030001Div div) {
        return new DBD1030001Handler(div);
    }

}
