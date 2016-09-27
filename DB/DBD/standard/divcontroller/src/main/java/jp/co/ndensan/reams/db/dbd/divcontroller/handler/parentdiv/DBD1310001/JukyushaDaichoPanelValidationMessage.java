/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のメッセージクラスです。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public enum JukyushaDaichoPanelValidationMessage implements IValidationMessage {

    /**
     * 基準日RbGr・基準日Rbが選択されている場合、基準日条件・基準日の入力／未入力をチェックする 未入力の場合、エラーとする
     */
    実行するボタンクリック1(UrErrorMessages.必須, "基準日"),
    /**
     * 基準日RbGr・範囲Rbが選択されている場合、範囲From、範囲Toが共に入力されていなければエラーとする。
     */
    実行するボタンクリック2(UrErrorMessages.期間が不正),
    /**
     * 基準日RbGr・範囲Rbが選択されている場合、範囲From、範囲Toが共に入力されている場合、From-Toの大小関係をチェックする。 範囲From > 範囲Toの場合、エラーとする。
     */
    実行するボタンクリック3(UrErrorMessages.期間が不正_追加メッセージあり１, "範囲To", "範囲From"),
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢From、年齢Toが共に入力されていなければエラーとする。
     */
    実行するボタンクリック4(UrErrorMessages.入力値が不正),
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢From、年齢Toが共に入力されている場合、From-Toの大小関係をチェックする。 年齢From > 年齢Toの場合、エラーとする。
     */
    実行するボタンクリック5(UrErrorMessages.大小関係が不正, "年齢"),
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢Fromまたは年齢Toのどちらかに入力されている場合、年齢基準日の入力／未入力をチェックする。 未入力の場合、エラーとする
     */
    実行するボタンクリック6(UrErrorMessages.必須, "年齢基準日"),
    /**
     * 宛名抽出項目区分RDB・生年月日が選択されている場合、生年月日From、生年月日Toが共に入力されていなければエラーとする。
     */
    実行するボタンクリック7(UrErrorMessages.期間が不正),
    /**
     * 宛名抽出項目区分RDB・生年月日が選択されている場合、生年月日From、生年月日Toが共に入力されている場合、From-Toの大小関係をチェックする。 生年月日From > 生年月日Toの場合、エラーとする。
     */
    実行するボタンクリック8(UrErrorMessages.期間が不正_追加メッセージあり１, "日付範囲From", "日付範囲To");

    private final Message message;

    private JukyushaDaichoPanelValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private JukyushaDaichoPanelValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
