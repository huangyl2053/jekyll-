/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 受給者異動連絡票関連共有子DivのValidatorです。
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class JukyushaIdoRenrakuhyoValidator {

    private final JukyushaIdoRenrakuhyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JukyushaIdoRenrakuhyoDiv hoDiv}
     */
    public JukyushaIdoRenrakuhyoValidator(JukyushaIdoRenrakuhyoDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate入力チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JukyushaIdoRenrakuhyoSpec.異動日の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.異動日の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.異動区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.異動区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.異動事由の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.異動事由の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.被保番号の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.被保番号の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.資格取得日の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.資格取得日の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.証記載保険者番号の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.証記載保険者番号の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.訂正日の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.訂正日の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.訂正区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.訂正区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.状態区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.状態区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.認定期間_Fromの必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.認定期間_Fromの必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.認定期間_Toの必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.認定期間_Toの必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.申請種別の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.申請種別の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.変更申請中区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.変更申請中区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.みなし区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.みなし区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.計画作成区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.計画作成区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.減免申請中区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.減免申請中区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.利用者負担区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.利用者負担区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.標準負担区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.標準負担区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.認定申請中区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.認定申請中区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.サービス区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.サービス区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.特例減額措置対象の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.特例減額措置対象の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.公費負担上限額減額_生活保護等の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.公費負担上限額減額_生活保護等の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.二次予防事業区分の必須チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.二次予防事業区分の必須項目)
                .ifNot(JukyushaIdoRenrakuhyoSpec.旧訪問通所_管理適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.旧訪問通所_管理適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.旧短期入所_管理適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.旧短期入所_管理適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.居宅適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.居宅適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.住特適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.住特適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.利用者負担適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.利用者負担適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.社会福祉法人軽減情報適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.社会福祉法人軽減情報適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.標準負担適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.標準負担適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.食費限度額適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.食費限度額適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.償還払化期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.償還払化期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.給付率引下げ期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.給付率引下げ期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.二割負担事業適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.二割負担事業適用期間が不正)
                .ifNot(JukyushaIdoRenrakuhyoSpec.二次予防事業適用期間の関連チェック)
                .thenAdd(JukyushaIdoRenrakuhyoValidationMessage.二次予防事業適用期間が不正)
                .messages());
        return messages;
    }

}
