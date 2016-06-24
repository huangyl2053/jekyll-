/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ0500001;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.configmaintenance.ConfigMaintenance;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0500001.DBZ0500001StateName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0500001.SystemKanriHoyouDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0500001.SystemKanriHandler;
import jp.co.ndensan.reams.db.dbz.service.core.configmaintenance.ConfigMaintenanceFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * システム管理汎用クラスです。
 *
 * @reamsid_L DBU-3991-010 wanghui
 */
public class SystemKanriHoyou {

    private final ConfigMaintenanceFinder finder;
    private static final RString 共通ボタン = new RString("btnUpdate");

    /**
     * コンストラクタです。
     *
     */
    public SystemKanriHoyou() {
        this.finder = ConfigMaintenanceFinder.createInstance();
    }

    /**
     * 初期化します。
     *
     * @param div ChohyoSelectDiv
     * @return ResponseData<ChohyoSelectDiv>
     */
    public ResponseData<SystemKanriHoyouDiv> onLoad(SystemKanriHoyouDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        controlData.getMenuID();
        SubGyomuCode サブ業務コード = ControlDataHolder.getExecutionSubGyomuCode();
        LockingKey 前排他ロックキー = new LockingKey(controlData.getMenuID().concat(new RString(サブ業務コード.toString())));
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
        div.getSystemKanri().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, false);
        List<ConfigMaintenance> resultList = finder.getSyozokuKikan(サブ業務コード.value()).records();
        getHandler(div).initialize(resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 「設定値がコンフィグ値
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<SystemKanriHoyouDiv> onChange_ConfigValue(SystemKanriHoyouDiv div) {
        getHandler(div).画面処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<SystemKanriHoyouDiv> btnUpdate(SystemKanriHoyouDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).保存処理();
            div.getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(new RString("コンフィグ制御メンテナンス_保存処理は正常に行われました。"),
                    RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBZ0500001StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<SystemKanriHoyouDiv> btnComplete(SystemKanriHoyouDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        controlData.getMenuID();
        SubGyomuCode サブ業務コード = ControlDataHolder.getExecutionSubGyomuCode();
        LockingKey 前排他ロックキー = new LockingKey(controlData.getMenuID().concat(new RString(サブ業務コード.toString())));
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).respond();
    }

    private SystemKanriHandler getHandler(SystemKanriHoyouDiv div) {
        return new SystemKanriHandler(div);
    }
}
