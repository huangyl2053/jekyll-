/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.KubunShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 区分支給限度額登録のValidatorです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuMainValidator {

    private final KubunShikyuGendogakuMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KubunShikyuGendogakuMainDiv}
     */
    public KubunShikyuGendogakuMainValidator(KubunShikyuGendogakuMainDiv div) {
        this.div = div;
    }

    /**
     * 保存するチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate保存する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KubunShikyuGendogakuMainSpec.適用開始年月チェック)
                .thenAdd(KubunShikyuGendogakuMainValidationMessage.適用年月_重複_開始年月不正)
                .ifNot(KubunShikyuGendogakuMainSpec.標準適用期間内チェック)
                .thenAdd(KubunShikyuGendogakuMainValidationMessage.適用期間_標準額と不一致)
                .messages());
        return messages;
    }
}
