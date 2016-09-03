/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010005;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * システム管理登録（広域データ交換）画面のメッセージクラスです。
 *
 * @reamsid_L DBD-3764-010 tz_chengpeng
 */
public enum SystemKanriKoikiDataTotalValidationMessage implements IValidationMessage {

    /**
     * 一次判定ファイル名が未入力。
     */
    一次判定ファイル名が未入力(UrErrorMessages.必須, "一次判定ファイル名"),
    /**
     * 訪問調査ファイル名が未入力。
     */
    訪問調査ファイル名が未入力(UrErrorMessages.必須, "訪問調査ファイル名"),
    /**
     * 特記事項ファイル名が未入力。
     */
    特記事項ファイル名が未入力(UrErrorMessages.必須, "特記事項ファイル名"),
    /**
     * 意見書ファイル名が未入力。
     */
    意見書ファイル名が未入力(UrErrorMessages.必須, "意見書ファイル名"),
    /**
     * 日医意見書ファイル名が未入力。
     */
    日医意見書ファイル名が未入力(UrErrorMessages.必須, "日医意見書ファイル名"),
    /**
     * 死亡情報ファイル名が未入力。
     */
    死亡情報ファイル名が未入力(UrErrorMessages.必須, "死亡情報ファイル名"),
    /**
     * 更新対象のデータがない。 メッセージ：「いずれの項目も変更されていません。」
     *
     */
    更新対象のデータがない(UrErrorMessages.更新対象のデータがない);

    private final Message message;

    SystemKanriKoikiDataTotalValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SystemKanriKoikiDataTotalValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
