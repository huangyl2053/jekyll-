/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.jotaianteiseicode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link JotaiAnteiseiCode}のバリデータークラスです。
 */
public class JotaiAnteiseiCodeValidator {

    private final JotaiAnteiseiCode jotaiAnteiseiCode;

    /**
     * コンストラクタです
     *
     * @param jotaiAnteiseiCode 要介護認定状態の安定性コード
     */
    public JotaiAnteiseiCodeValidator(JotaiAnteiseiCode jotaiAnteiseiCode) {
        requireNonNull(jotaiAnteiseiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定状態の安定性コード"));
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link JotaiAnteiseiCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(jotaiAnteiseiCode)
                .messages();
    }
}
