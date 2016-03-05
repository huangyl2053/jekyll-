/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5100001;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.DBE5100001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.DBE5100001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.KaigoNinteiShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100001.KaigoNinteiShinsakaiValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会一覧のコントローラです。
 */
public class KaigoNinteiShinsakai {

    private static final RString 遷移モード_審査会個人別状況照会 = new RString("hanteiKekka");
    private static final RString 遷移モード_介護認定審査会審査対象データ出力 = new RString("dataShutsuryoku");
    private static final RString 遷移モード_介護認定審査会対象者割付 = new RString("kaisaiYoteiToroku");
    private static final RString 遷移モード_介護認定審査会資料作成 = new RString("shinsakaiShiryoSakusei");
    private static final RString 遷移モード_介護認定審査会委員事前審査結果登録 = new RString("jizenKekkaToroku");
    private static final RString 遷移モード_審査会結果登録 = new RString("shinsaKekkaToroku");
    private static final RString 遷移モード_介護認定審査会審査結果データ取込み = new RString("dataShutsuryoku");
    private static final RString 遷移モード_介護認定審査会審査結果登録 = new RString("shinsaKekkaToroku");
    private static final RString メニューID_審査会個人別状況照会 = new RString("DBEMN11004");
    private static final RString メニューID_介護認定審査会審査対象データ出力 = new RString("DBEMN51004");
    private static final RString メニューID_介護認定審査会対象者割付 = new RString("DBEMN51005");
    private static final RString メニューID_介護認定審査会資料作成 = new RString("DBEMN51007");
    private static final RString メニューID_介護認定審査会委員事前審査結果登録 = new RString("DBEMN51008");
    private static final RString メニューID_審査会開催結果登録 = new RString("DBEMN52001");
    private static final RString メニューID_審査会審査結果登録 = new RString("DBEMN52003");
    private static final RString メニューID_介護認定審査会審査結果データ取込み = new RString("DBEMN52002");
    private static final RString メニューID_介護認定審査会審査結果登録 = new RString("DBEMN52004");

    /**
     * 審査会一覧初期化の設定します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onLoad(KaigoNinteiShinsakaiDiv div) {

        RString menuID = ResponseHolder.getMenuID();
        div.getCcdShinsakaiItiran().initialize(getMode().get(menuID));
        return ResponseData.of(div).setState(getState().get(menuID));
    }

    /**
     * 個人別状況照会へ遷移を処理します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnkojin(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択不可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        // TODO QA780 uicontainerがありません。
        return ResponseData.of(div).forwardWithEventName(DBE5100001TransitionEventName.審査会選択).respond();
    }

    /**
     * データ出力を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btndataoutput(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE5100001TransitionEventName.審査会選択).respond();
    }

    /**
     * 審査会対象者割付へ遷移を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnwaritsuke(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択不可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        // TODO QA780 uicontainerがありません。
        return ResponseData.of(div).forwardWithEventName(DBE5100001TransitionEventName.審査会選択).respond();
    }

    /**
     * 自動割付へ遷移を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnAutoWaritsuke(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        // TODO QA780 uicontainerがありません。
        return ResponseData.of(div).forwardWithEventName(DBE5100001TransitionEventName.審査会選択).respond();
    }

    /**
     * 選択ボタンの処理を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnSelect(KaigoNinteiShinsakaiDiv div) {

        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).forwardWithEventName(getFowordState().get(ResponseHolder.getMenuID())).
                parameter(ViewStateHolder.get(ViewStateKeys.介護認定審査会委員割付_開催番号, RString.class));
    }

    /**
     * データ取込みを実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<IraishoIkkatsuHakkoDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btndatainput(KaigoNinteiShinsakaiDiv div) {

        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        // TODO QA780 uicontainerがありません。
        return ResponseData.of(div).forwardWithEventName(DBE5100001TransitionEventName.審査会選択).respond();
    }

    private KaigoNinteiShinsakaiValidationHandler createValidationHandler(KaigoNinteiShinsakaiDiv div) {
        return new KaigoNinteiShinsakaiValidationHandler(div);
    }

    private ValidationMessageControlPairs check_審査会複数選択不可(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(check_審査会複数選択可(div));
        validationMessages.add(createValidationHandler(div).審査会複数選択不可チェック());
        return validationMessages;
    }

    private ValidationMessageControlPairs check_審査会複数選択可(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(createValidationHandler(div).審査会データ空チェック());
        validationMessages.add(createValidationHandler(div).審査会未選択チェック());
        return validationMessages;
    }

    private Map<RString, RString> getMode() {
        Map<RString, RString> mode = new HashMap<>();
        mode.put(メニューID_審査会個人別状況照会, 遷移モード_審査会個人別状況照会);
        mode.put(メニューID_介護認定審査会審査対象データ出力, 遷移モード_介護認定審査会審査対象データ出力);
        mode.put(メニューID_介護認定審査会対象者割付, 遷移モード_介護認定審査会対象者割付);
        mode.put(メニューID_介護認定審査会資料作成, 遷移モード_介護認定審査会資料作成);
        mode.put(メニューID_介護認定審査会委員事前審査結果登録, 遷移モード_介護認定審査会委員事前審査結果登録);
        mode.put(メニューID_審査会開催結果登録, 遷移モード_審査会結果登録);
        mode.put(メニューID_審査会審査結果登録, 遷移モード_審査会結果登録);
        mode.put(メニューID_介護認定審査会審査結果データ取込み, 遷移モード_介護認定審査会審査結果データ取込み);
        mode.put(メニューID_介護認定審査会審査結果登録, 遷移モード_介護認定審査会審査結果登録);
        return mode;
    }

    private Map<RString, DBE5100001StateName> getState() {
        Map<RString, DBE5100001StateName> state = new HashMap<>();
        state.put(メニューID_審査会個人別状況照会, DBE5100001StateName.審査会個人別状況照会);
        state.put(メニューID_介護認定審査会審査対象データ出力, DBE5100001StateName.データ出力_モバイル);
        state.put(メニューID_介護認定審査会対象者割付, DBE5100001StateName.対象者割付);
        state.put(メニューID_介護認定審査会資料作成, DBE5100001StateName.審査会資料);
        state.put(メニューID_介護認定審査会委員事前審査結果登録, DBE5100001StateName.事前結果登録);
        state.put(メニューID_審査会開催結果登録, DBE5100001StateName.審査結果登録);
        state.put(メニューID_審査会審査結果登録, DBE5100001StateName.審査結果登録);
        state.put(メニューID_介護認定審査会審査結果データ取込み, DBE5100001StateName.データ取込み_モバイル);
        state.put(メニューID_介護認定審査会審査結果登録, DBE5100001StateName.結果登録_OCR);
        return state;
    }

    private Map<RString, DBE5100001TransitionEventName> getFowordState() {
        Map<RString, DBE5100001TransitionEventName> fowordState = new HashMap<>();
        fowordState.put(メニューID_介護認定審査会資料作成, DBE5100001TransitionEventName.審査会選択);
        fowordState.put(メニューID_介護認定審査会委員事前審査結果登録, DBE5100001TransitionEventName.審査会選択);
        fowordState.put(メニューID_審査会審査結果登録, DBE5100001TransitionEventName.審査会選択);
        fowordState.put(メニューID_審査会開催結果登録, DBE5100001TransitionEventName.審査会選択);
        fowordState.put(メニューID_介護認定審査会審査結果登録, DBE5100001TransitionEventName.審査会選択);
        return fowordState;
    }
}
