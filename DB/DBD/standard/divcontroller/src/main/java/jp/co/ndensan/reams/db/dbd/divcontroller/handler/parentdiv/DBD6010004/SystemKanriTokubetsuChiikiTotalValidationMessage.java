/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010004;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * システム管理登録（社会福祉法人確認番号）画面のメッセージクラスです。
 *
 * @reamsid_L DBD-3763-010 tz_chengpeng
 */
public enum SystemKanriTokubetsuChiikiTotalValidationMessage implements IValidationMessage {

    /**
     * 更新対象のデータがない。 メッセージ：「いずれの項目も変更されていません。」
     *
     */
    更新対象のデータがない(UrErrorMessages.更新対象のデータがない),
    /**
     * 有効桁数が未入力。
     */
    有効桁数が未入力(UrErrorMessages.必須, "有効桁数"),
    /**
     * 減額率の分子が未入力。
     */
    減額率の分子が未入力(UrErrorMessages.必須, "減額率の分子"),
    /**
     * 減額率の分母が未入力。
     */
    減額率の分母が未入力(UrErrorMessages.必須, "減額率の分母"),
    /**
     * 有効桁数入力値が不正
     */
    有効桁数入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "有効桁数は1～10までの数値を入力してください。"),
    /**
     * 減額率入力値が不正
     */
    減額率入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "減額率の分子には、分母以下の値を入力してください。"),
    /**
     * 減額率の分子入力値が不正
     */
    減額率の分子入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "減額率の分子には、1～100までの値を入力してください。"),
    /**
     * 減額率の分母入力値が不正
     */
    減額率の分母入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "減額率の分母には、1～100までの値を入力してください。");

    private final Message message;

    SystemKanriTokubetsuChiikiTotalValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SystemKanriTokubetsuChiikiTotalValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
