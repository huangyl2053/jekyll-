/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.inputshikibetsunocode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link InputShikibetsuNoCode}のバリデータークラスです。
 */
public class InputShikibetsuNoCodeValidator {

    private final InputShikibetsuNoCode inputShikibetsuNoCode;

    /**
     * コンストラクタです
     *
     * @param inputShikibetsuNoCode 入力識別番号コード
     */
    public InputShikibetsuNoCodeValidator(InputShikibetsuNoCode inputShikibetsuNoCode) {
        requireNonNull(inputShikibetsuNoCode, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.inputShikibetsuNoCode = inputShikibetsuNoCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link InputShikibetsuNoCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(inputShikibetsuNoCode)
                .messages();
    }
}
