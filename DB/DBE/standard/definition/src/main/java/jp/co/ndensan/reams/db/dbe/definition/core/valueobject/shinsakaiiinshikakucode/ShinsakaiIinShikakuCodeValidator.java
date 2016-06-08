/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiinshikakucode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShinsakaiIinShikakuCode}のバリデータークラスです。
 */
public class ShinsakaiIinShikakuCodeValidator {

    private final ShinsakaiIinShikakuCode shinsakaiIinShikakuCode;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiIinShikakuCode 介護認定審査会委員資格コード
     */
    public ShinsakaiIinShikakuCodeValidator(ShinsakaiIinShikakuCode shinsakaiIinShikakuCode) {
        requireNonNull(shinsakaiIinShikakuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員資格コード"));
        this.shinsakaiIinShikakuCode = shinsakaiIinShikakuCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShinsakaiIinShikakuCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shinsakaiIinShikakuCode)
                .messages();
    }
}
