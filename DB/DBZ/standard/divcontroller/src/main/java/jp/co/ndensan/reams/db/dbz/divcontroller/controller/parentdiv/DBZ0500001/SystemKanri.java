/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ0500001;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.configmaintenance.ConfigMaintenance;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0500001.DBZ0500001StateName;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0500001.SystemKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0500001.SystemKanriHandler;
import jp.co.ndensan.reams.db.dbz.service.core.configmaintenance.ConfigMaintenanceFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理汎用クラスです。
 *
 * @reamsid_L DBU-3991-010 wanghui
 */
public class SystemKanri {

    private final ConfigMaintenanceFinder finder;
    private final RString 完了メッセージ = new RString("コンフィグ制御メンテナンス_保存処理は正常に行われました。");
    private LockingKey 前排他ロックキー;

    /**
     * コンストラクタです。
     *
     */
    public SystemKanri() {
        this.finder = ConfigMaintenanceFinder.createInstance();
    }

    /**
     * 初期化します。
     *
     * @param div ChohyoSelectDiv
     * @return ResponseData<ChohyoSelectDiv>
     */
    public ResponseData<SystemKanriDiv> onLoad(SystemKanriDiv div) {
        SubGyomuCode サブ業務コード = ControlDataHolder.getSubGyomuCD();
        List<ConfigMaintenance> resultList = finder.getSyozokuKikan(サブ業務コード.value()).records();
        getHandler(div).initialize(resultList);
        if (!RealInitialLocker.tryGetLock(排他キー())) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShisetsutourukuPanelErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<SystemKanriDiv> onChange_ConfigValue(SystemKanriDiv div) {
        getHandler(div).画面D処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<SystemKanriDiv> btnComplete(SystemKanriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).保存処理();
            RealInitialLocker.release(排他キー());
        }
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setSuccessMessage(完了メッセージ, RString.EMPTY, RString.EMPTY);
        return ResponseData.of(div).setState(DBZ0500001StateName.完了状態);
    }

    private SystemKanriHandler getHandler(SystemKanriDiv div) {
        return new SystemKanriHandler(div);
    }

    private enum ShisetsutourukuPanelErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShisetsutourukuPanelErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private LockingKey 排他キー() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        controlData.getMenuID();
        前排他ロックキー = new LockingKey(controlData.getMenuID().concat(new RString("DBZ0500001")));
        return 前排他ロックキー;
    }
}
