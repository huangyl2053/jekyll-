/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public enum ServiceRiyohyoInfoDivValidationMessage implements IValidationMessage {

    /**
     * サービスコード必須項目
     */
    サービスコード必須項目(UrErrorMessages.必須項目_追加メッセージあり, "サービスコード"),
    /**
     * 単位必須項目
     */
    単位必須項目(UrErrorMessages.必須項目_追加メッセージあり, "単位"),
    /**
     * 回数
     */
    回数必須項目(UrErrorMessages.必須項目_追加メッセージあり, "回数"),
    /**
     * サービス単位必須項目
     */
    サービス単位必須項目(UrErrorMessages.必須項目_追加メッセージあり, "サービス単位"),
    /**
     * 割引適用後率入力値が不正
     */
    割引適用後率入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "割引適用後率：100％までの値を入力してください。"),
    /**
     * 回数入力値が不正
     */
    回数入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "回数：マイナス値入力不可"),
    /**
     * 単位数単価
     */
    単位数単価入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "単位単価：1.00以上を指定"),
    /**
     * 給付率入力値が不正
     */
    給付率入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "給付率：１以上を指定");

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

    private ServiceRiyohyoInfoDivValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
