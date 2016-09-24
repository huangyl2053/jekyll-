/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 汎用リスト出力(介護受給共通)の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-3930-011 liwul
 */
public enum HanyoListParamValidationMessage implements IValidationMessage {

    /**
     * 年度RbGr・年度Rbが選択されている場合、年度条件・年度DDLの選択／未選択をチェックする 未選択（空白行が選択されている）の場合、エラーとする
     */
    実行するボタンクリック1(UrErrorMessages.未指定, "年度"),
    /**
     * 年度RbGr・年度基準日Rbが選択されている場合、年度基準日条件・年度基準日の入力／未入力をチェックする 未入力の場合、エラーとする
     */
    実行するボタンクリック2(UrErrorMessages.必須, "基準日"),
    /**
     * 基準日RbGr・基準日Rbが選択されている場合、基準日条件・基準日の入力／未入力をチェックする 未入力の場合、エラーとする
     */
    実行するボタンクリック3(UrErrorMessages.必須, "基準日"),
    /**
     * 基準日RbG・範囲Rbが選択されている場合、範囲条件・範囲From、範囲条件・範囲Toが共に入力されている場合、From-Toの大小関係をチェックする。 範囲From > 範囲Toの場合、エラーとする。
     */
    実行するボタンクリック5(UrErrorMessages.期間が不正_追加メッセージあり１, "範囲To", "範囲From"),
    /**
     * 宛名抽出項目区分RDB・年齢が選択されている場合、年齢From、年齢Toが共に入力されている場合、From-Toの大小関係をチェックする。 年齢From > 年齢Toの場合、エラーとする。
     */
    実行するボタンクリック7(UrErrorMessages.大小関係が不正, "年齢"),
    /**
     * 宛名抽出項目区分RDB・生年月日が選択されている場合、生年月日From、生年月日Toが共に入力されている場合、From-Toの大小関係をチェックする。 生年月日From > 生年月日Toの場合、エラーとする。
     */
    実行するボタンクリック10(UrErrorMessages.期間が不正_追加メッセージあり１, "日付範囲From", "日付範囲To"),
    /**
     * 帳票・CSV出力が「True」または帳票のみ出力が「True」の時、 表題が未入力（Empty)であればWarningMessage、警告MSGを表示する ※条件保存の場合はチェック不要
     */
    帳票出力項目チェック１(UrWarningMessages.未入力, "表題"),
    /**
     * 出力順が未入力（Empty)であれば、エラーとする ※条件保存の場合はチェック不要
     */
    帳票出力項目チェック２(UrErrorMessages.出力順序を指定),
    /**
     * 出力項目が未入力（Empty)であればエラーとする ※条件保存の場合はチェック不要
     */
    帳票出力項目チェック３(UrErrorMessages.出力項目を指定);

    private final Message message;

    private HanyoListParamValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private HanyoListParamValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
