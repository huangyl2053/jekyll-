/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0840011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011.DBU0840011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011.SystemKanriPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0840011.SystemKanriPanelHandler;
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

    private RString メニューID;

    /**
     * システム管理情報（介護統計共通)の初期化です。
     *
     * @param div システム管理情報（介護統計共通)Div
     * @return ResponseData<SystemKanriPanelDiv>
     * @throws PessimisticLockingException
     */
    public ResponseData<SystemKanriPanelDiv> onLoad(SystemKanriPanelDiv div) {
        メニューID = UrControlDataFactory.createInstance().getMenuID();
        if (!RealInitialLocker.tryGetLock(new LockingKey(メニューID))) {
            throw new PessimisticLockingException();
        }
        getHandler(div).set_DDL();
        getHandler(div).onload();
        //TODO 介護宛先住所編集（共有子Div）が未実装
        return ResponseData.of(div).setState(DBU0840011StateName.初期状態);
    }

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriPanelDiv
     * @return SystemKanriPanelHandler
     */
    private SystemKanriPanelHandler getHandler(SystemKanriPanelDiv div) {
        return new SystemKanriPanelHandler(div);
    }

    /**
     * 保存ボタン。
     *
     * @param div SystemKanriPanelDiv
     * @return ResponseData<SystemKanriPanelDiv>
     */
    public ResponseData<SystemKanriPanelDiv> onClick_btnUpdate(SystemKanriPanelDiv div) {
        メニューID = UrControlDataFactory.createInstance().getMenuID();
        getHandler(div).set_保存ボタン(メニューID);
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
        メニューID = UrControlDataFactory.createInstance().getMenuID();
        RealInitialLocker.release(new LockingKey(メニューID));
        return ResponseData.of(div).respond();
    }
}
