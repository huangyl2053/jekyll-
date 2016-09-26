/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190003;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 資格喪失（死亡）データ作成画面の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public enum RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage implements IValidationMessage {

    /**
     * 今回処理日時_終了日時が開始日時以前チェック
     */
    今回処理日時_終了日時が開始日時以前チェック(UrErrorMessages.終了日が開始日以前),
    /**
     * 今回開始チェック（年月日）
     */
    今回開始チェック_年月日(UrErrorMessages.必須項目_追加メッセージあり, "今回開始チェック_年月日"),
    /**
     * 今回開始チェック（時分秒）
     */
    今回開始チェック_時分秒(UrErrorMessages.必須項目_追加メッセージあり, "今回開始チェック_時分秒"),
    /**
     * 今回終了チェック（年月日）
     */
    今回終了チェック_年月日(UrErrorMessages.必須項目_追加メッセージあり, "今回開始チェック_時分秒"),
    /**
     * 今回終了チェック（時分秒）
     */
    今回終了チェック_時分秒(UrErrorMessages.必須項目_追加メッセージあり, "今回開始チェック_時分秒");
    private final Message message;

    private RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
