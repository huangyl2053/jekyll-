/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1140001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140001.ShotokushokaihyoIkkatuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140001.ShotokushokaihyoIkkatuHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBBGM51001_所得照会票一括発行のクラスです。
 *
 * @reamsid_L DBB-1720-010 lijunjun
 */
public class ShotokushokaihyoIkkatu {

    private static final RString MSG_一括処理を実行します = new RString("一括処理を実行します");
    private static final RString MSG_再発行処理を実行します = new RString("再発行処理を実行します");
    private static final RString MSG_再発行対象 = new RString("再発行対象");
    private static final RString MSG_所得調査中 = new RString(
            "テストプリントで発行するため、発行対象者が「所得調査中」として管理されません。<br>一括処理を実行します");

    /**
     * 初期化のメソッド
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<ShotokushokaihyoIkkatuDiv>
     */
    public ResponseData<ShotokushokaihyoIkkatuDiv> onLoad(ShotokushokaihyoIkkatuDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン押下のメソッドです。
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<ShotokuShokaihyoHakkoBatchParameter> onClick_Register(ShotokushokaihyoIkkatuDiv div) {
        ShotokuShokaihyoHakkoBatchParameter parameter = new ShotokuShokaihyoHakkoBatchParameter();
        boolean テストプリント = getHandler(div).isテストプリント();
        boolean 再発行する = getHandler(div).is再発行する();
        if (new RString(DbzWarningMessages.確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            parameter = getHandler(div).getParameter(div, テストプリント, 再発行する);
            return ResponseData.of(parameter).respond();
        }
        return ResponseData.of(parameter).respond();
    }

    /**
     * チェックbefore「発行する」ボタン押下のメソッドです。
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<ShotokushokaihyoIkkatuDiv>
     */
    public ResponseData<ShotokushokaihyoIkkatuDiv> onClick_beforeRegisterCheck(ShotokushokaihyoIkkatuDiv div) {
        boolean テストプリント = getHandler(div).isテストプリント();
        boolean 再発行する = getHandler(div).is再発行する();
        if (getHandler(div).is再発行対象のチェック(再発行する)) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage()
                    .replace(MSG_再発行対象.toString()));
        }
        if (!ResponseHolder.isReRequest()) {
            if (テストプリント) {
                WarningMessage message = new WarningMessage(DbzWarningMessages.確認.getMessage().getCode(),
                        DbzWarningMessages.確認.getMessage().replace(MSG_所得調査中.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (再発行する) {
                WarningMessage message = new WarningMessage(DbzWarningMessages.確認.getMessage().getCode(),
                        DbzWarningMessages.確認.getMessage().replace(MSG_再発行処理を実行します.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else {
                WarningMessage message = new WarningMessage(DbzWarningMessages.確認.getMessage().getCode(),
                        DbzWarningMessages.確認.getMessage().replace(MSG_一括処理を実行します.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再発行する」チェックボックスのメソッドです。
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<ShotokushokaihyoIkkatuDiv>
     */
    public ResponseData<ShotokushokaihyoIkkatuDiv> onChange_check(ShotokushokaihyoIkkatuDiv div) {
        getHandler(div).check再発行する();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理年度ドロップダウンの変更のメソッドです。
     *
     * @param div ShotokushokaihyoIkkatuDiv
     * @return ResponseData<ShotokushokaihyoIkkatuDiv>
     */
    public ResponseData<ShotokushokaihyoIkkatuDiv> onChange_ddlShoriNendo(ShotokushokaihyoIkkatuDiv div) {

        boolean 再発行する = getHandler(div).is再発行する();
        if (再発行する) {
            getHandler(div).set再発行対象();
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShotokushokaihyoIkkatuHandler getHandler(ShotokushokaihyoIkkatuDiv div) {
        return ShotokushokaihyoIkkatuHandler.of(div);
    }
}
