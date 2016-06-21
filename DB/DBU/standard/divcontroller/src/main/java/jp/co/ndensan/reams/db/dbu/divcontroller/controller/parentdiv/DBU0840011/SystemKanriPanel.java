/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0840011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011.SystemKanriPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0840011.SystemKanriPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム管理情報（介護統計共通)のDivControllerです。
 *
 * @reamsid_L DBU-3990-010 zhengsongling
 */
public class SystemKanriPanel {

    private IUrControlData controlData;
    private RString メニューID;

    /**
     * システム管理情報（介護統計共通)の初期化です。
     *
     * @param div システム管理情報（介護統計共通)Div
     * @return ResponseData<SystemKanriPanelDiv>
     * @throws PessimisticLockingException
     */
    public ResponseData<SystemKanriPanelDiv> onLoad(SystemKanriPanelDiv div) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        div.setHdnTxtDonyuKeitaiCode(new RString(shichosonSecurityJoho.get導入形態コード().toString()));
        controlData = UrControlDataFactory.createInstance();
        メニューID = controlData.getMenuID();
        if (!RealInitialLocker.tryGetLock(new LockingKey(メニューID))) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initlize();
        getHandler(div).onload();
        //TODO 介護宛先住所編集（共有子Div）が未実装
        return ResponseData.of(div).respond();
    }

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriPanelDiv
     * @return SystemKanriPanelHandler
     */
    public SystemKanriPanelHandler getHandler(SystemKanriPanelDiv div) {
        return new SystemKanriPanelHandler(div);
    }

    /**
     * 保存ボタン。
     *
     * @param div SystemKanriPanelDiv
     * @return ResponseData<SystemKanriPanelDiv>
     */
    public ResponseData<SystemKanriPanelDiv> onClick_btnUpdate(SystemKanriPanelDiv div) {
        controlData = UrControlDataFactory.createInstance();
        メニューID = controlData.getMenuID();
        getHandler(div).on_Click(メニューID);
        return ResponseData.of(div).respond();
    }

    /**
     *
     * 「完了する」ボタン。
     *
     * @param div SystemKanriPanelDiv
     * @return ResponseData<SystemKanriPanelDiv>
     */
    public ResponseData<SystemKanriPanelDiv> onClick_btnComplete(SystemKanriPanelDiv div) {
        RealInitialLocker.release(new LockingKey(メニューID));
        return ResponseData.of(div).respond();
    }
}
