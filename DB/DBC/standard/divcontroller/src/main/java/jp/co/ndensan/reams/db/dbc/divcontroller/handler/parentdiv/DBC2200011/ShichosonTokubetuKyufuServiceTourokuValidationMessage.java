/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 画面設計_DBC2200011_市町村特別給付サービス内容登録のメッセージクラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public enum ShichosonTokubetuKyufuServiceTourokuValidationMessage implements IValidationMessage {

    /**
     * 更新不可。
     *
     */
    更新不可(UrErrorMessages.更新不可),
    /**
     * 削除不可。
     *
     */
    削除不可(UrErrorMessages.削除不可),
    /**
     * 有効開始日と有効終了日の前後関係が不正。
     */
    有効開始日と有効終了日の前後関係が不正(UrErrorMessages.終了日が開始日以前),
    /**
     * 前回の有効開始日以降の入力不正。
     */
    前回の有効開始日以降の入力不正(UrErrorMessages.入力値が不正_追加メッセージあり, "前回の有効開始年月日以降の日付を入力してください。"),
    /**
     * 前回の有効終了日以前の入力不正。
     */
    前回の有効終了日以前の入力不正(UrErrorMessages.入力値が不正_追加メッセージあり, "前回の有効終了年月日以前の日付は入力できません。"),
    /**
     * 名称入力内容が不正。
     */
    名称入力内容が不正(UrErrorMessages.使用不可文字),
    /**
     * 略称入力内容が不正
     */
    略称入力内容が不正(UrErrorMessages.使用不可文字);

    private final Message message;

    ShichosonTokubetuKyufuServiceTourokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    ShichosonTokubetuKyufuServiceTourokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
