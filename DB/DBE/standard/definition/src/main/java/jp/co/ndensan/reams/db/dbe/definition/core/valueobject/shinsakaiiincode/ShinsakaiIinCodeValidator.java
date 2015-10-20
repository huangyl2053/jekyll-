/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiincode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShinsakaiIinCode}のバリデータークラスです。
 */
public class ShinsakaiIinCodeValidator {

    private final ShinsakaiIinCode shinsakaiIinCode;

    /**
     * コンストラクタです
     *
     * @param shinsakaiIinCode 審査会委員コード
     */
    public ShinsakaiIinCodeValidator(ShinsakaiIinCode shinsakaiIinCode) {
        requireNonNull(shinsakaiIinCode, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員コード"));
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShinsakaiIinCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shinsakaiIinCode)
                .ifNot(ShinsakaiIinCodeSpec.桁数が8桁であること)
                .thenAdd(ShinsakaiIinCodeValidationMessage.桁数が8桁ではないこと)
                .messages();
    }
}
