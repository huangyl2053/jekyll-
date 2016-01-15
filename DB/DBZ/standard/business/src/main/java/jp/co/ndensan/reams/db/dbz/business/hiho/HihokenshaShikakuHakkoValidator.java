/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hiho;

import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者証・資格者証発行のバリデーションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakkoValidator implements IValidatable {

    private final RString 交付事由;

    /**
     * コンストラクタです。
     *
     * @param 交付事由 RString
     */
    public HihokenshaShikakuHakkoValidator(RString 交付事由) {
        this.交付事由 = 交付事由;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        messages.add(
                ValidateChain.validateStart(交付事由)
                .ifNot(HihokenshaShikakuHakkoSpec.交付事由が選択されていること)
                .thenAdd(HihokenshaShikakuHakkoValidationMessage.交付事由が未選択)
                .messages());
        return messages;
    }

}
