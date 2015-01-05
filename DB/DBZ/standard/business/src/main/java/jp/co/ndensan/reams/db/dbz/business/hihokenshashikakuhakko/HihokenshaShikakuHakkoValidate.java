/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko;

import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.model.validation.validators.PresenceValidator;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者証・資格者証発行のバリデーションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshaShikakuHakkoValidate implements IValidatable {

    /**
     * コンストラクタです。
     */
    public HihokenshaShikakuHakkoValidate() {
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        return messages;
    }

    public IValidationMessages validateIn(RString 交付事由) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        if (PresenceValidator.isInvalid(交付事由)) {
            messages.add(HihokenshaShikakuHakkoValidationMessage.交付事由が未選択);
        }

        return messages;
    }

}
