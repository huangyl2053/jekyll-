/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0840011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011.DBU0840011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011.SystemKanriPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0840011.SystemKanriPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

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
        div.getSystemKanri().getChohyoJushoDefault().getCcdKaigoAtesakiJushoSettei().initialize_systemKanri(false, true,
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告),
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告),
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告),
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告),
                DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                        RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        return ResponseData.of(div).setState(DBU0840011StateName.初期状態);
    }

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
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).set_保存ボタン(メニューID);
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(new RString("システム管理登録_介護統計共通保存処理は正常に行われました。"),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBU0840011StateName.完了状態);
        }
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
