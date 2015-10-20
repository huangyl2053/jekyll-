/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.valueobject.fukaerrorcode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link FukaErrorCode}のバリデータークラスです。
 */
public class FukaErrorCodeValidator {

    private final FukaErrorCode fukaErrorCode;

    /**
     * コンストラクタです
     *
     * @param fukaErrorCode 賦課のエラーコード
     */
    public FukaErrorCodeValidator(FukaErrorCode fukaErrorCode) {
        requireNonNull(fukaErrorCode, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課のエラーコード"));
        this.fukaErrorCode = fukaErrorCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link FukaErrorCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(fukaErrorCode)
                .messages();
    }
}
