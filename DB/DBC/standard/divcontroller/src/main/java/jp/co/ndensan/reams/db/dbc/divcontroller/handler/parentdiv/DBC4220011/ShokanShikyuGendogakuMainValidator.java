/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4220011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011.ShokanShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 償還支給限度額登録のValidatorです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class ShokanShikyuGendogakuMainValidator {

    private final ShokanShikyuGendogakuMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public ShokanShikyuGendogakuMainValidator(ShokanShikyuGendogakuMainDiv div) {
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
                .ifNot(ShokanShikyuGendogakuMainSpec.適用開始年月チェック)
                .thenAdd(ShokanShikyuGendogakuMainValidationMessage.適用年月_重複_開始年月不正)
                .ifNot(ShokanShikyuGendogakuMainSpec.標準適用期間内チェック)
                .thenAdd(ShokanShikyuGendogakuMainValidationMessage.適用期間_標準額と不一致)
                .messages());
        return messages;
    }
}
