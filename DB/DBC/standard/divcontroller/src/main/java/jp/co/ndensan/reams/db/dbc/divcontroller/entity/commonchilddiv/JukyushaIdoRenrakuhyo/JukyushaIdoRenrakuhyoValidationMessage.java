/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
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
    異動日の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "異動日"),
    /**
     * 異動区分の必須項目
     */
    異動区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "異動区分"),
    /**
     * 異動事由の必須項目
     */
    異動事由の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "異動事由"),
    /**
     * 被保番号の必須項目
     */
    被保番号の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "被保番号"),
    /**
     * 資格取得日の必須項目
     */
    資格取得日の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "資格取得日"),
    /**
     * 証記載保険者番号の必須項目
     */
    証記載保険者番号の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "証記載保険者番号"),
    /**
     * 訂正日の必須項目
     */
    訂正日の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "訂正日"),
    /**
     * 訂正区分の必須項目
     */
    訂正区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "訂正区分"),
    /**
     * 訂正区分の必須項目
     */
    状態区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "状態区分"),
    /**
     * 認定期間　Froの必須項目
     */
    認定期間_Fromの必須項目(UrErrorMessages.必須項目_追加メッセージあり, "認定期間　From"),
    /**
     * 認定期間　Toの必須項目
     */
    認定期間_Toの必須項目(UrErrorMessages.必須項目_追加メッセージあり, "認定期間　To"),
    /**
     * 申請種別の必須項目
     */
    申請種別の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "申請種別"),
    /**
     * 変更申請中区分の必須項目
     */
    変更申請中区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "変更申請中区分"),
    /**
     * みなし区分の必須項目
     */
    みなし区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "みなし区分"),
    /**
     * 計画作成区分の必須項目
     */
    計画作成区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "計画作成区分"),
    /**
     * 減免申請中区分の必須項目
     */
    減免申請中区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "減免申請中区分"),
    /**
     * 認定申請中区分の必須項目
     */
    認定申請中区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "認定申請中区分"),
    /**
     * サービス区分の必須項目
     */
    サービス区分の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "サービス区分"),
    /**
     * 特例減額措置対象の必須項目
     */
    特例減額措置対象の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "特例減額措置対象"),
    /**
     * 公費負担上限額減額(生活保護等) の必須項目
     */
    公費負担上限額減額_生活保護等の必須項目(UrErrorMessages.必須項目_追加メッセージあり, "公費負担上限額減額(生活保護等) "),
    /**
     * 旧訪問通所_管理適用期間が不正
     */
    旧訪問通所_管理適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * (旧短期入所)　管理適用期間が不正
     */
    旧短期入所_管理適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 居宅適用期間が不正
     */
    居宅適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 住特適用期間が不正
     */
    住特適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 利用者負担適用期間が不正
     */
    利用者負担適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 社会福祉法人軽減情報適用期間が不正
     */
    社会福祉法人軽減情報適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 標準負担と異動日が不正
     */
    標準負担と異動日が不正(DbcErrorMessages.受給者異動_制度改正チェック, "平成17年10月", "以降", "標準負担情報"),
    /**
     * 標準負担適用期間が不正
     */
    標準負担適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 認定負担限度額が不正
     */
    認定負担限度額が不正(DbcErrorMessages.負担限度額設定不正),
    /**
     * 食費限度額適用期間が不正
     */
    食費限度額適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 償還払化期間が不正
     */
    償還払化期間が不正(UrErrorMessages.期間が不正),
    /**
     * 給付率引下げ期間が不正
     */
    給付率引下げ期間が不正(UrErrorMessages.期間が不正),
    /**
     * 二割負担事業適用期間が不正
     */
    二割負担事業適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 二次予防事業適用期間が不正
     */
    二次予防事業適用期間が不正(UrErrorMessages.期間が不正),
    /**
     * 住特適用期間と異動日が不正
     */
    住特適用情報が不正(DbcErrorMessages.受給者異動_制度改正チェック, "平成27年04月", "より前", "住所地特例情報"),
    /**
     * 社会福祉法人軽減情報が不正
     */
    社会福祉法人軽減情報が不正(DbcErrorMessages.受給者異動_制度改正チェック, "平成17年10月", "より前", "社会福祉法人軽減情報"),
    /**
     * 食費限度額適用情報が不正
     */
    食費限度額適用情報が不正(DbcErrorMessages.受給者異動_制度改正チェック, "平成17年10月", "より前", "特定入所者サービス費情報"),
    /**
     * 二割負担事業適用情報が不正
     */
    二割負担事業適用情報が不正(DbcErrorMessages.受給者異動_制度改正チェック, "平成27年08月", "より前", "二割負担情報"),
    /**
     * 二次予防事業適用情報が不正
     */
    二次予防事業適用情報が不正(DbcErrorMessages.受給者異動_制度改正チェック, "平成24年04月", "より前", "二次予防事業情報");
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
