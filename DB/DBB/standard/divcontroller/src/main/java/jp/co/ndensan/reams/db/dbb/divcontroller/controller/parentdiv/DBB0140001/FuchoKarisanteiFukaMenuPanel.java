/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0140001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.DBB014003_FuchoKarisanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.DBB0140001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

    private static final RString 普徴仮算定賦課メニュー = new RString("DBBMN34001");

    /**
     * 普徴仮算定賦課のonLoad事件です。
     *
     * @param div FuFuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onLoad(FuchoKarisanteiFukaMenuPanelDiv div) {
        RDate システム日時 = RDate.getNowDate();
        FuchoKarisanteiFukaMenuPanelHandler handler = getHandler(div);
        RString メニューID = ResponseHolder.getMenuID();
        boolean is非活性 = handler.load処理状況(システム日時);
        handler.load管理情報確認(システム日時);
        handler.load算定帳票作成();
        handler.load帳票作成個別情報(システム日時);
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
    public ResponseData<DBB014003_FuchoKarisanteiTsuchishoHakkoParameter>
            onClick_btnFuchoKarisanteiFukaBatch(FuchoKarisanteiFukaMenuPanelDiv div) {
        DBB014003_FuchoKarisanteiTsuchishoHakkoParameter parameter = getHandler(div).getバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 普徴仮算定通知書一括発行メニューからの場合、「実行する」ボタンの事件です。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return バッチパラメータを引き渡し
     */
    public ResponseData<DBB014003_FuchoKarisanteiTsuchishoHakkoParameter>
            onClick_btnFuchoKarisanteiTsuchishoBatch(FuchoKarisanteiFukaMenuPanelDiv div) {
        DBB014003_FuchoKarisanteiTsuchishoHakkoParameter parameter = getHandler(div).getバッチパラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 画面の初期化時、違うの状態の実行ボタンの設定です。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onStateTransition(FuchoKarisanteiFukaMenuPanelDiv div) {
        boolean flag = ViewStateHolder.get(ViewStateKeys.実行フラグ, Boolean.class);
        getHandler(div).set実行ボタン(flag);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下するとチェックです。
     *
     * @param div FuchoKarisanteiFukaMenuPanelDiv
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onClick_Check(FuchoKarisanteiFukaMenuPanelDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).can実行チェック();
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
