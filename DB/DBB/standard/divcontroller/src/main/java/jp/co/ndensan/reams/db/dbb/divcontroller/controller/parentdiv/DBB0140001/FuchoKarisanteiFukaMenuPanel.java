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
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 普徴仮算定賦課のクラスです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaMenuPanel {

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
        handler.load処理状況();
        handler.load管理情報確認();
        handler.load算定帳票作成();
        handler.load帳票作成個別情報();
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
     * 「実行する」ボタンを押下するとチェックです。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onClick_Check(FuchoKarisanteiFukaMenuPanelDiv div) {
        boolean has普徴 = getHandler(div).can実行チェック();
        if (has普徴) {
            FuchoKarisanteiFukaMenuPanelValidationHandler validationHandler = new FuchoKarisanteiFukaMenuPanelValidationHandler(div);
            ValidationMessageControlPairs pairs;
            pairs = validationHandler.validate発行日();
            pairs.add(validationHandler.validate提供年月());
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
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
