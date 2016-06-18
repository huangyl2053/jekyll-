/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0140001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisantei.FuchoKarisanteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.DBB0140001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 普徴仮算定賦課のクラスです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaMenuPanel {

    private static final int イチ_定値 = 1;
    private static final int ニ_定値 = 2;
    private static final int ミ_定値 = 3;
    private static final RString 普徴仮算定賦課メニュー = new RString("DBBMN34001");

    /**
     * 普徴仮算定賦課のonLoad事件です。
     *
     * @param div FuFuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onLoad(FuchoKarisanteiFukaMenuPanelDiv div) {
        FuchoKarisanteiFukaMenuPanelHandler handler = getHandler(div);
        RString メニューID = ResponseHolder.getMenuID();
        boolean is非活性 = handler.load処理状況();
        handler.load管理情報確認();
        handler.load算定帳票作成();
        handler.load帳票作成個別情報();
        ViewStateHolder.put(ViewStateKeys.実行フラグ, is非活性);
        if (普徴仮算定賦課メニュー.equals(メニューID)) {
            return ResponseData.of(div).setState(DBB0140001StateName.普徴仮算定賦課);
        } else {
            return ResponseData.of(div).setState(DBB0140001StateName.普徴仮算定通知書一括発行);
        }
    }

    /**
     * 普徴仮算定賦課メニューから起動の場合、「実行する」ボタンの事件です。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return バッチパラメータを引き渡し
     */
    public ResponseData<FuchoKarisanteiBatchParameter> onClick_btnFuchoKarisanteiFukaBatch(FuchoKarisanteiFukaMenuPanelDiv div) {
        FuchoKarisanteiBatchParameter parameter = getHandler(div).getバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 普徴仮算定通知書一括発行メニューからの場合、「実行する」ボタンの事件です。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return バッチパラメータを引き渡し
     */
    public ResponseData<FuchoKarisanteiBatchParameter> onClick_btnFuchoKarisanteiTsuchishoBatch(FuchoKarisanteiFukaMenuPanelDiv div) {
        FuchoKarisanteiBatchParameter parameter = getHandler(div).getバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 画面の初期化時、違うの状態の実行ボタンの設定です。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onStateTransition(FuchoKarisanteiFukaMenuPanelDiv div) {
        boolean falg = ViewStateHolder.get(ViewStateKeys.実行フラグ, Boolean.class);
        getHandler(div).set実行ボタン(falg);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下するとチェックです。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onClick_Check(FuchoKarisanteiFukaMenuPanelDiv div) {
        int has普徴 = getHandler(div).can実行チェック();
        FuchoKarisanteiFukaMenuPanelValidationHandler validationHandler = new FuchoKarisanteiFukaMenuPanelValidationHandler(div);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (イチ_定値 == has普徴) {
            pairs = validationHandler.validate発行日();
            pairs.add(validationHandler.validate提供年月());
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        } else if (ニ_定値 == has普徴) {
            pairs = validationHandler.validate帳票IDのチェック_型0();
        } else if (ミ_定値 == has普徴) {
            pairs = validationHandler.validate帳票IDのチェック_型2();
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponseData(div);
    }

    private FuchoKarisanteiFukaMenuPanelHandler getHandler(FuchoKarisanteiFukaMenuPanelDiv div) {
        return new FuchoKarisanteiFukaMenuPanelHandler(div);
    }

    private ResponseData<FuchoKarisanteiFukaMenuPanelDiv> createResponseData(FuchoKarisanteiFukaMenuPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
