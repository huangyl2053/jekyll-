/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 要介護認定処理画面の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public enum ShokkenTorikeshiIchibuSoshituValidationMessage implements IValidationMessage {

    /**
     * 申請日が未入力。
     */
    申請日が未入力(UrErrorMessages.必須, "申請日"),
    /**
     * 認定日が未入力。
     */
    認定日が未入力(UrErrorMessages.必須, "認定日"),
    /**
     * 喪失日が未入力。
     */
    喪失日が未入力(UrErrorMessages.未入力, "喪失日"),
    /**
     * 要介護度が未入力。
     */
    要介護度が未入力(UrErrorMessages.未入力, "要介護度"),
    /**
     * 有効開始日が未入力。
     */
    有効開始日が未入力(UrErrorMessages.未入力, "有効開始日"),
    /**
     * 有効終了日が未入力。
     */
    有効終了日が未入力(UrErrorMessages.未入力, "有効終了日"),
    /**
     * 有効開始日と有効終了日の関連チェック。
     */
    有効開始日と有効終了日の関連チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "有効開始日", "有効終了日"),
    /**
     * 有効開始日と有効終了日の関連チェック。
     */
    前回有効終了日と今回有効開始日の関連チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "前回有効終了日", "今回有効開始日"),
    /**
     * 新予防給付適用の60日前のみなし更新チェック。
     */
    新予防給付適用の60日前のみなし更新チェック(UrErrorMessages.更新不可, "新予防給付適用の60日前の「みなし更新」"),
    /**
     * 受給申請中かの確認チェック。
     */
    受給申請中かの確認チェック(UrErrorMessages.更新不可_汎用, "受給申請中のデータが存在しない");

    private final Message message;

    ShokkenTorikeshiIchibuSoshituValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    ShokkenTorikeshiIchibuSoshituValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
