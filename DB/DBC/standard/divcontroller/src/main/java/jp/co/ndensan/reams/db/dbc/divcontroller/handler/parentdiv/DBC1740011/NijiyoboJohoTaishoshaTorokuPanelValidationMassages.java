/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 総合事業（経過措置）対象者登録 のValidationMessagesです。
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public enum NijiyoboJohoTaishoshaTorokuPanelValidationMassages implements IValidationMessage {

    /**
     * 適用期間重複チェック
     */
    適用期間重複(UrErrorMessages.期間が重複),
    /**
     * 適用期間重複チェック
     */
    開始日と終了日の前後順(UrErrorMessages.終了日が開始日以前);

    private final Message message;

    /**
     * エラーメッセージを取得する。
     *
     * @return エラーメッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

    private NijiyoboJohoTaishoshaTorokuPanelValidationMassages(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
