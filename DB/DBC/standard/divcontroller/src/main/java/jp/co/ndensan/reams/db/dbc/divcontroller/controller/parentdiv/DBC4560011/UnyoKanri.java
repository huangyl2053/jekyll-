/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4560011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011.DBC4560011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011.UnyoKanriDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4560011.UnyoKanriHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4560011.UnyoKanriValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理登録（利用者負担割合）のDivControllerクラスです。
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public class UnyoKanri {

    private static final RString CODE_処理済 = new RString("1");
    private static final RString CODE_再処理前 = new RString("2");
    private static final RString を使用して更新 = new RString("を使用して更新");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div UnyoKanriDiv
     * @return ResponseData<UnyoKanriDiv>
     */
    public ResponseData<UnyoKanriDiv> onLoad(UnyoKanriDiv div) {
        LockingKey 前排他キー = new LockingKey(ResponseHolder.getMenuID());
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        UnyoKanriHandler handler = getHandler(div);
        handler.initializeDisplay();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存」ボタン押下時のイベントメソッドです。
     *
     * @param div UnyoKanriDiv
     * @return ResponseData<UnyoKanriDiv>
     */
    public ResponseData<UnyoKanriDiv> onClick_btnUpdate(UnyoKanriDiv div) {
        UnyoKanriHandler handler = getHandler(div);
        ValidationMessageControlPairs valid = getValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        if (CODE_処理済.equals(div.getHdnNenjiFutanWariaiShoriJotai())
                && CODE_再処理前.equals(div.getDdlNenjiFutanWariaiShoriJotai().getSelectedKey())) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbcQuestionMessages.年次負担割合再処理.getMessage().
                        replace(handler.getパターン102(div.getTxtNenjiFutanWariaiShoriZumiNendo().getValue().getYear()).toString())).respond();
            }
            if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
        }
        RString メニューID = ResponseHolder.getMenuID();
        RString 変更理由 = メニューID.concat(を使用して更新);
        RDate 適用基準日 = RDate.getNowDate();
        updateConfigData(ConfigNameDBC.利用者負担割合判定基準_本人未申告区分, div.getDdlHonninMishinkokuKubun().getSelectedKey(),
                変更理由, 適用基準日);
        updateConfigData(ConfigNameDBC.利用者負担割合判定基準_本人所得調査中区分, div.getDdlHonninShutokuChosachuKubun().getSelectedKey(),
                変更理由, 適用基準日);
        updateConfigData(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, div.getDdlNenjiFutanWariaiShoriJotai().getSelectedKey(),
                変更理由, 適用基準日);
        LockingKey 前排他キー = new LockingKey(メニューID);
        RealInitialLocker.release(前排他キー);
        return ResponseData.of(div).setState(DBC4560011StateName.完了状態);
    }

    private void updateConfigData(ConfigNameDBC キー名称, RString キー値, RString 変更理由, RDate 適用基準日) {
        BusinessConfig.update(SubGyomuCode.DBC介護給付, キー名称, キー値, 変更理由, RString.EMPTY, 適用基準日);
    }

    private UnyoKanriHandler getHandler(UnyoKanriDiv div) {
        return new UnyoKanriHandler(div);
    }

    private UnyoKanriValidationHandler getValidationHandler(UnyoKanriDiv div) {
        return new UnyoKanriValidationHandler(div);
    }
}
