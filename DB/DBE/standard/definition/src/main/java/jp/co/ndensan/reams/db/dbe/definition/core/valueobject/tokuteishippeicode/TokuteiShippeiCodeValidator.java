/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.tokuteishippeicode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link TokuteiShippeiCode}のバリデータークラスです。
 */
public class TokuteiShippeiCodeValidator {

    private final TokuteiShippeiCode tokuteiShippeiCode;

    /**
     * コンストラクタです。
     *
     * @param tokuteiShippeiCode 特定疾病コード
     */
    public TokuteiShippeiCodeValidator(TokuteiShippeiCode tokuteiShippeiCode) {
        requireNonNull(tokuteiShippeiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("特定疾病コード"));
        this.tokuteiShippeiCode = tokuteiShippeiCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link TokuteiShippeiCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(tokuteiShippeiCode)
                .messages();
    }
}
