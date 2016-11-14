/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *画面設計_DBCMN71001_給付費通知減免情報補正登録のValidatorです。
 * 
 * @reamsid_L DBC-2260-010 guyan
 */
public class KyufuTsuchiGenmenHoseiTorokuValidator {
    
    private final KyufuTsuchiGenmenHoseiTorokuDiv div;
    
    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public KyufuTsuchiGenmenHoseiTorokuValidator(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        this.div = div;
    }
    
    /**
     * 「検索する」ボタン押下時のチェックです。
     * @return エラーメッセージ
     */
    public IValidationMessages validate検索する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.最大取得件数不正)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.最大取得件数不正)
        .messages());
        return messages;
    }
    
    /**
     * 「補正情報を確定する」ボタン
     * @return エラーメッセージ
     */
    public IValidationMessages validate確定する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.サービス年月入力)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.サービス年月入力)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.証記載保険者番号入力)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.証記載保険者番号入力)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.事業者入力)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.事業者入力)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.サービス種類入力)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.サービス種類入力)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.利用者負担額合計入力)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.利用者負担額合計入力)
        .ifNot(KyufuTsuchiGenmenHoseiTorokuSpec.サービス費用合計入力)
        .thenAdd(KyufuTsuchiGenmenHoseiTorokuMessage.サービス費用合計入力)
        .messages());
        return messages;
    }
    
    
}
