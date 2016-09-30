/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD6010002;

import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceShurui;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002.DBD6010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002.SystemKanriNinteiShienTotalDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002.SystemKanriNinteiShienTotalHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002.SystemKanriNinteiShienTotalValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（認定支援システムとのデータ交換）画面のDivControllerです。
 *
 * @reamsid_L DBD-3761-010 tz_chengpeng
 */
public class SystemKanriNinteiShienTotal {

    /**
     * 画面初期化
     *
     * @param div SystemKanriNinteiShienTotalDiv
     * @return ResponseData<SystemKanriNinteiShienTotalDiv>
     */
    public ResponseData<SystemKanriNinteiShienTotalDiv> onLoad(SystemKanriNinteiShienTotalDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBD6010002StateName.初期状態);
    }

    /**
     * IF種類設定onChange
     *
     * @param div SystemKanriNinteiShienTotalDiv
     * @return ResponseData<SystemKanriNinteiShienTotalDiv>
     */
    public ResponseData<SystemKanriNinteiShienTotalDiv> onChange_DdlIfShuRuiSelectItem(SystemKanriNinteiShienTotalDiv div) {

        RString iF_種類項目 = div.getSystemKanri().getSystemKanriNinteiShien().getDdlIfShurui().getSelectedKey();
        if (iF_種類項目.equals(YokaigoInterfaceShurui.厚労省.getコード())) {
            div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().setDisplayNone(false);
        } else {
            div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().setDisplayNone(true);
        }
        if (iF_種類項目.equals(YokaigoInterfaceShurui.ＢＳＮ.getコード()) || iF_種類項目.equals(YokaigoInterfaceShurui.ＦＮＳ.getコード())) {
            div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().setDisplayNone(false);
        } else {
            div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().setDisplayNone(true);
        }
        if (YokaigoInterfaceShurui.ＮＥＣ.getコード().equals(iF_種類項目)) {
            div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().setDisplayNone(false);
        } else {
            div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().setDisplayNone(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存」ボタンの処理
     *
     * @param div SystemKanriNinteiShienTotalDiv
     * @return ResponseData<SystemKanriNinteiShienTotalDiv>
     */
    public ResponseData<SystemKanriNinteiShienTotalDiv> onClick_btnUpdate(SystemKanriNinteiShienTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).画面項目変更保存();
            div.getKoshinKekkaKakunin().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBD6010002StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private SystemKanriNinteiShienTotalValidationHandler getValidationHandler(SystemKanriNinteiShienTotalDiv div) {
        return new SystemKanriNinteiShienTotalValidationHandler(div);
    }

    private SystemKanriNinteiShienTotalHandler getHandler(SystemKanriNinteiShienTotalDiv div) {
        return new SystemKanriNinteiShienTotalHandler(div);
    }
}
