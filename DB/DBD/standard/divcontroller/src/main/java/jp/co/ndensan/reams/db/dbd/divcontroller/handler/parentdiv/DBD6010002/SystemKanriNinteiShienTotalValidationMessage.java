/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * システム管理登録（認定支援システムとのデータ交換）画面のメッセージクラスです。
 *
 * @reamsid_L DBD-3761-010 tz_chengpeng
 */
public enum SystemKanriNinteiShienTotalValidationMessage implements IValidationMessage {

    /**
     * 認定ＩＦ改定日が未入力。
     */
    認定ＩＦ改定日が未入力(UrErrorMessages.必須, "認定ＩＦ改定日"),
    /**
     * 旧様式_認定結果ファイルが未入力。
     */
    旧様式_認定結果ファイルが未入力(UrErrorMessages.必須, "旧様式_認定結果ファイル"),
    /**
     * 旧様式_指定事業出力ファイルが未入力。
     */
    旧様式_指定事業出力ファイルが未入力(UrErrorMessages.必須, "旧様式_指定事業出力ファイル"),
    /**
     * 旧様式_調査員出力ファイルが未入力。
     */
    旧様式_調査員出力ファイルが未入力(UrErrorMessages.必須, "旧様式_調査員出力ファイル"),
    /**
     * 旧様式_医療機関出力ファイルが未入力。
     */
    旧様式_医療機関出力ファイルが未入力(UrErrorMessages.必須, "旧様式_医療機関出力ファイル"),
    /**
     * 旧様式_主治医出力ファイルが未入力。
     */
    旧様式_主治医出力ファイルが未入力(UrErrorMessages.必須, "旧様式_主治医出力ファイル"),
    /**
     * 旧様式_申請情報出力ファイルが未入力。
     */
    旧様式_申請情報出力ファイルが未入力(UrErrorMessages.必須, "旧様式_申請情報出力ファイル"),
    /**
     * 旧様式_認定結果ファイルが未入力。
     */
    新様式_認定結果ファイルが未入力(UrErrorMessages.必須, "新様式_認定結果ファイル"),
    /**
     * 新様式_指定事業出力ファイルが未入力。
     */
    新様式_指定事業出力ファイルが未入力(UrErrorMessages.必須, "新様式_指定事業出力ファイル"),
    /**
     * 新様式_調査員出力ファイルが未入力。
     */
    新様式_調査員出力ファイルが未入力(UrErrorMessages.必須, "新様式_調査員出力ファイル"),
    /**
     * 新様式_医療機関出力ファイルが未入力。
     */
    新様式_医療機関出力ファイルが未入力(UrErrorMessages.必須, "新様式_医療機関出力ファイル"),
    /**
     * 新様式_主治医出力ファイルが未入力。
     */
    新様式_主治医出力ファイルが未入力(UrErrorMessages.必須, "新様式_主治医出力ファイル"),
    /**
     * 新様式_申請情報出力ファイルが未入力。
     */
    新様式_申請情報出力ファイルが未入力(UrErrorMessages.必須, "新様式_申請情報出力ファイル"),
    /**
     * 新様式_死亡情報ファイルが未入力。
     */
    新様式_死亡情報ファイルが未入力(UrErrorMessages.必須, "新様式_死亡情報ファイル"),
    /**
     * 新様式_転入死亡ファイルが未入力。
     */
    新様式_転入死亡ファイルが未入力(UrErrorMessages.必須, "新様式_転入死亡ファイル"),
    /**
     * 更新対象のデータがない。 メッセージ：「いずれの項目も変更されていません。」
     *
     */
    更新対象のデータがない(UrErrorMessages.更新対象のデータがない);

    private final Message message;

    SystemKanriNinteiShienTotalValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SystemKanriNinteiShienTotalValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
