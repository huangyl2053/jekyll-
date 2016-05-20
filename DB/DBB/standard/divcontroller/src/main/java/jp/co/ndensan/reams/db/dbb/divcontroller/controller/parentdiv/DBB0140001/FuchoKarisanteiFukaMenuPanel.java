/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 普徴仮算定賦課のクラスです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaMenuPanel {

    /**
     * 普徴仮算定賦課のonLoad事件です。
     *
     * @param div FuFuchoKarisanteiFukaMenuPanelDiv * @return 普徴仮算定賦課画面
     * @return 普徴仮算定賦課画面
     */
    public ResponseData<FuchoKarisanteiFukaMenuPanelDiv> onLoad(FuchoKarisanteiFukaMenuPanelDiv div) {
        FuchoKarisanteiFukaMenuPanelHandler handler = getHandler(div);
        handler.load処理状況();
        handler.load管理情報確認();
        handler.load算定帳票作成();
        handler.load帳票作成個別情報();
        return createResponseData(div);
    }

    private FuchoKarisanteiFukaMenuPanelHandler getHandler(FuchoKarisanteiFukaMenuPanelDiv div) {
        return new FuchoKarisanteiFukaMenuPanelHandler(div);
    }

    private ResponseData<FuchoKarisanteiFukaMenuPanelDiv> createResponseData(FuchoKarisanteiFukaMenuPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
