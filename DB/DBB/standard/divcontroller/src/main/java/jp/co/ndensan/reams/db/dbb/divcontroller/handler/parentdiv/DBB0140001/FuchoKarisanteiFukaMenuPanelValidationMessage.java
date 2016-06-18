/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックエラーメッセージです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public enum FuchoKarisanteiFukaMenuPanelValidationMessage implements IValidationMessage {

    /**
     * 発行日が入力必要
     */
    発行日チェック(UrErrorMessages.必須項目_追加メッセージあり, "発行日"),
    /**
     * 対象者選択必要
     */
    対象者チェック(UrErrorMessages.必須項目_追加メッセージあり, "対象者"),
    /**
     * 納入通知書の型が「0:なし」の場合、エラーとする.
     */
    帳票IDのチェック_型0(DbbErrorMessages.帳票ID取得不可のため処理不可),
    /**
     * 納入通知書の型が「2:銀振型5期タイプ」の場合、エラーとする
     */
    帳票IDのチェック_型2(DbbErrorMessages.銀振5期タイプ仮算定なし);

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

    private FuchoKarisanteiFukaMenuPanelValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
