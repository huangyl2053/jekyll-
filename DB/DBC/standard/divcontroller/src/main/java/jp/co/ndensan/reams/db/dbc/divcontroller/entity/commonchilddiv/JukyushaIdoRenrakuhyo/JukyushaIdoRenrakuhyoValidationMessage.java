/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 受給者異動連絡票関連共有子Divの入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public enum JukyushaIdoRenrakuhyoValidationMessage implements IValidationMessage {

    /**
     * 異動日の必須項目
     */
    異動日の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "異動日"),
    /**
     * 異動区分の必須項目
     */
    異動区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "異動区分"),
    /**
     * 異動事由の必須項目
     */
    異動事由の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "異動事由"),
    /**
     * 被保番号の必須項目
     */
    被保番号の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "被保番号"),
    /**
     * 資格取得日の必須項目
     */
    資格取得日の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "資格取得日"),
    /**
     * 証記載保険者番号の必須項目
     */
    証記載保険者番号の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "証記載保険者番号"),
    /**
     * 訂正日の必須項目
     */
    訂正日の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "訂正日"),
    /**
     * 訂正区分の必須項目
     */
    状態区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "状態区分"),
    /**
     * 認定期間　Froの必須項目
     */
    認定期間_Fromの必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "認定期間　From"),
    /**
     * 認定期間　Toの必須項目
     */
    認定期間_Toの必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "認定期間　To"),
    /**
     * 申請種別の必須項目
     */
    申請種別の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "申請種別"),
    /**
     * 変更申請中区分の必須項目
     */
    変更申請中区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "変更申請中区分"),
    /**
     * みなし区分の必須項目
     */
    みなし区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "みなし区分"),
    /**
     * 計画作成区分の必須項目
     */
    計画作成区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "計画作成区分"),
    /**
     * 減免申請中区分の必須項目
     */
    減免申請中区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "減免申請中区分"),
    /**
     * 利用者負担区分の必須項目
     */
    利用者負担区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "利用者負担区分"),
    /**
     * 標準負担区分の必須項目
     */
    標準負担区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "標準負担区分"),
    /**
     * 認定申請中区分の必須項目
     */
    認定申請中区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "認定申請中区分"),
    /**
     * サービス区分の必須項目
     */
    サービス区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "サービス区分"),
    /**
     * 特例減額措置対象の必須項目
     */
    特例減額措置対象の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "特例減額措置対象"),
    /**
     * 公費負担上限額減額(生活保護等) の必須項目
     */
    公費負担上限額減額_生活保護等の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "公費負担上限額減額(生活保護等) "),
    /**
     * 二次予防事業区分の必須項目
     */
    二次予防事業区分の必須項目(UrErrorMessages.入力値が不正_追加メッセージあり, "二次予防事業区分"),
    /**
     * 期間が不正
     */
    期間が不正(UrErrorMessages.期間が不正);

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

    private JukyushaIdoRenrakuhyoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
