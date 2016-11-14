/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *画面設計_DBCMN71001_給付費通知減免情報補正登録の入力チェックエラーメッセージです。
 * 
 * @reamsid_L DBC-2260-010 guyan
 */
public enum KyufuTsuchiGenmenHoseiTorokuMessage implements IValidationMessage {
    
    /**
     * 最大取得件数不正
     */
    最大取得件数不正(UrErrorMessages.入力値が不正_追加メッセージあり, "最大取得件数"),
    /**
     * サービス年月入力
     */
    サービス年月入力(UrErrorMessages.入力値が不正_追加メッセージあり, "サービス年月"),
    /**
     * 証記載保険者番号入力
     */
    証記載保険者番号入力(UrErrorMessages.入力値が不正_追加メッセージあり, "証記載保険者番号"),
    /**
     * 事業者入力
     */
    事業者入力(UrErrorMessages.入力値が不正_追加メッセージあり, "事業者"),
    /**
     * サービス種類入力
     */
    サービス種類入力(UrErrorMessages.入力値が不正_追加メッセージあり, "サービス種類"),
    /**
     * 利用者負担額合計入力
     */
    利用者負担額合計入力(UrErrorMessages.入力値が不正_追加メッセージあり, "利用者負担額合計"),
    /**
     * サービス費用合計入力
     */
    サービス費用合計入力(UrErrorMessages.入力値が不正_追加メッセージあり, "サービス費用合計");
    
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
    
    private KyufuTsuchiGenmenHoseiTorokuMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
