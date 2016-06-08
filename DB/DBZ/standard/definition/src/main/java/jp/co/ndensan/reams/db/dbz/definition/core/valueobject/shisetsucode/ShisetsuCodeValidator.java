/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.shisetsucode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShisetsuCode}のバリデータークラスです。
 */
public class ShisetsuCodeValidator {

    private final ShisetsuCode shisetsuCode;

    /**
     * コンストラクタです。
     *
     * @param shisetsuCode 施設コード
     */
    public ShisetsuCodeValidator(ShisetsuCode shisetsuCode) {
        requireNonNull(shisetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShisetsuCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shisetsuCode)
                .messages();
    }
}
