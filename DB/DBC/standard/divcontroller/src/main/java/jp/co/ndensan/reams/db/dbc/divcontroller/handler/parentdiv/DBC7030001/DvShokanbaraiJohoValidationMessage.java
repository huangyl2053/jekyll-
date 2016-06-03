/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 「実行する」ボタンを押下時の入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public enum DvShokanbaraiJohoValidationMessage implements IValidationMessage {

    /**
     * 様式番号一覧データ未指定
     */
    様式番号一覧データ未指定(UrErrorMessages.未指定, "様式番号"),
    /**
     * 金融機関コードは未指定でなければなりません
     */
    金融機関コードは未指定でなければなりません(UrErrorMessages.項目に対する制約, "金融機関コード", "未指定"),
    /**
     * サービス提供年月期間が不正
     */
    サービス提供年月期間が不正(UrErrorMessages.期間が不正_追加メッセージあり１, "サービス提供年月To", "サービス提供年From"),
    /**
     * 申請日期間が不正
     */
    申請日期間が不正(UrErrorMessages.期間が不正_追加メッセージあり１, "申請日To", "申請日From"),
    /**
     * 住宅改修支給届出日期間が不正
     */
    住宅改修支給届出日期間が不正(UrErrorMessages.期間が不正_追加メッセージあり１, "住宅改修支給届出日To", "住宅改修支給届出日From"),
    /**
     * 決定日期間が不正
     */
    決定日期間が不正(UrErrorMessages.期間が不正_追加メッセージあり１, "決定日To", "決定日From"),
    /**
     * 国保連送付年月期間が不正
     */
    国保連送付年月期間が不正(UrErrorMessages.期間が不正_追加メッセージあり１, "国保連送付年月To", "国保連送付年月From"),
    /**
     * 対象のデータがありません
     */
    対象のデータがありません(UrErrorMessages.対象ファイルが存在しない, "識別番号管理");

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

    private DvShokanbaraiJohoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
