/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public enum KogakuGassanShikyuShinseiTorokuValidationMessage implements IValidationMessage {

    /**
     * 老人所得区分必須項目
     */
    老人所得区分必須項目(UrErrorMessages.必須, "70歳以上の者に係わる所得区分"),
    /**
     * 計算期間年度内範囲制約
     */
    計算期間年度内範囲制約(UrErrorMessages.項目に対する制約, "計算期間", "対象年度内"),
    /**
     * 計算期間加入期間内範囲制約
     */
    計算期間加入期間内範囲制約(UrErrorMessages.項目に対する制約, "計算期間", "加入期間内"),
    /**
     * 資格喪失1
     */
    資格喪失1(UrErrorMessages.必須, "資格喪失事由が選択されている場合、被保険者情報　資格喪失日"),
    /**
     * 資格喪失2
     */
    資格喪失2(UrErrorMessages.必須, "被保険者情報　資格喪失日が入力されている場合、資格喪失事由"),
    /**
     * 後期保険者番号制約
     */
    後期保険者番号制約(UrErrorMessages.項目に対する制約, "後期資格情報　保険者番号の上2桁", "「39」"),
    /**
     * 国保保険者番号桁数が不正
     */
    国保保険者番号桁数が不正(UrErrorMessages.桁数が不正, "国保資格情報　保険者番号", "8"),
    /**
     * 後期保険者番号桁数が不正
     */
    後期保険者番号桁数が不正(UrErrorMessages.桁数が不正, "後期資格情報　保険者番号", "8"),
    /**
     * 後期被保険者番号桁数が不正
     */
    後期被保険者番号桁数が不正(UrErrorMessages.桁数が不正, "後期資格情報　被保険者番号", "8"),
    /**
     * 国保被保険者番号桁数が不正
     */
    国保被保険者番号桁数が不正(UrErrorMessages.桁数が不正, "国保資格情報　被保険者証記号", "20"),
    /**
     * 被保険者証番号桁数が不正
     */
    被保険者証番号桁数が不正(UrErrorMessages.桁数が不正, "被保険者証番号", "20"),
    /**
     * 介護日付が不正
     */
    介護日付が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[介護資格情報　加入期間]"),
    /**
     * 被保日付が不正
     */
    被保日付が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[被保険者情報　計算期間]"),
    /**
     * 国保日付が不正
     */
    国保日付が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[国保資格情報　加入期間]"),
    /**
     * 後期日付が不正
     */
    後期日付が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[後期資格情報　計算期間]"),
    /**
     * 開始計算期間1
     */
    開始計算期間1(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[介護資格情報　加入期間（開始）]"),
    /**
     * 開始計算期間2
     */
    開始計算期間2(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[介護資格情報　加入期間（終了）]"),
    /**
     * 開始計算期間3
     */
    開始計算期間3(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[国保資格情報　加入期間（開始）]"),
    /**
     * 開始計算期間4
     */
    開始計算期間4(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[国保資格情報　加入期間（終了）]"),
    /**
     * 開始計算期間5
     */
    開始計算期間5(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[後期資格情報　加入期間（開始）]"),
    /**
     * 開始計算期間6
     */
    開始計算期間6(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[後期資格情報　加入期間（終了）]"),
    /**
     * 終了計算期間1
     */
    終了計算期間1(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[介護資格情報　加入期間（開始）]"),
    /**
     * 終了計算期間2
     */
    終了計算期間2(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[介護資格情報　加入期間（終了）]"),
    /**
     * 終了計算期間3
     */
    終了計算期間3(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[国保資格情報　加入期間（開始）]"),
    /**
     * 終了計算期間4
     */
    終了計算期間4(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[国保資格情報　加入期間（終了）]"),
    /**
     * 終了計算期間5
     */
    終了計算期間5(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[後期資格情報　加入期間（開始）]"),
    /**
     * 終了計算期間6
     */
    終了計算期間6(UrErrorMessages.入力値が不正_追加メッセージあり, "日付の指定に誤りがあります。[後期資格情報　加入期間（終了）]"),
    /**
     * 保険加入期間が不正
     */
    保険加入期間が不正(UrErrorMessages.大小関係が不正, "加入期間（開始）≦加入期間（終了）で設定してください。"),
    /**
     * 証明書整理番号桁数が不正
     */
    証明書整理番号桁数が不正(UrErrorMessages.桁数が不正, "自己負担額証明書整理番号", "20"),
    /**
     * 証明書整理番号既に存在
     */
    証明書整理番号既に存在(UrErrorMessages.既に存在, "自己負担額証明書整理番号"),
    /**
     * 医療支給申請書整理番号入力桁不足
     */
    医療支給申請書整理番号入力桁不足(UrErrorMessages.入力値が不正_追加メッセージあり, "入力桁不足"),
    /**
     * 所得区分必須項目
     */
    所得区分必須項目(UrErrorMessages.必須項目),
    /**
     * 加入期間必須項目
     */
    加入期間必須項目(UrErrorMessages.必須項目),
    /**
     * 備考文字種
     */
    備考文字種(UrErrorMessages.使用不可文字);

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

    private KogakuGassanShikyuShinseiTorokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    private KogakuGassanShikyuShinseiTorokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }
}
