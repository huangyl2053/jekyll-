/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public enum ShikyugakuKeisanKekkaTorokuMessage implements IValidationMessage {

    /**
     * 連絡票整理番号既に存在
     */
    連絡票整理番号既に存在(UrErrorMessages.既に存在, "同一連絡票整理番号のデータ"),
    /**
     * 連絡票整理番号年度が不正
     */
    連絡票整理番号年度が不正(UrErrorMessages.不正, "入力された連絡票整理番号の申請対象年度"),
    /**
     * 明細グリッド必須項目
     */
    明細グリッド必須項目(UrErrorMessages.必須項目_追加メッセージあり, "計算結果内訳一覧"),
    /**
     * 按分後支給額必須項目
     */
    按分後支給額(UrErrorMessages.必須項目_追加メッセージあり, "按分後支給額"),
    /**
     * 以上の者に係る所得区分必須項目
     */
    以上の者に係る所得区分必須項目(UrErrorMessages.必須項目_追加メッセージあり, "70歳以上の者に係る所得区分"),
    /**
     * 連絡票整理番号必須項目
     */
    連絡票整理番号必須項目(UrErrorMessages.必須項目_追加メッセージあり, "連絡票整理番号"),
    /**
     * 介護等合算算定基準額必須項目
     */
    介護等合算算定基準額必須項目(UrErrorMessages.必須項目_追加メッセージあり, "介護等合算算定基準額"),
    /**
     * 対象計算期間終了年月日入力値が不正
     */
    対象計算期間終了年月日入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "未来日付が指定されています。【計算対象期間（終了）】"),
    /**
     * 計算期間年度内範囲制約
     */
    計算期間年度内範囲制約(UrErrorMessages.項目に対する制約, "計算期間", "対象年度内"),
    /**
     * 金額入力値が不正
     */
    金額入力値が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "<br>按分後支給額≧うち70歳以上分となるように入力してください"),
    /**
     * 高額合算支給不支給決定データの存在
     */
    高額合算支給不支給決定データの存在(DbcWarningMessages.高額合算支給額計算結果削除確認_支給決定情報あり),
    /**
     * 自己負担額証明書整理番号既に存在
     */
    自己負担額証明書整理番号既に存在(DbcWarningMessages.高額合算支給額計算結果登録),
    /**
     * 内訳入力途中
     */
    内訳入力途中(DbcErrorMessages.内訳入力途中);

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

    private ShikyugakuKeisanKekkaTorokuMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
