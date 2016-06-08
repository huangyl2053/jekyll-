/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hihokenshakubuncode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link HihokenshaKubunCode}のバリデータークラスです。
 */
public class HihokenshaKubunCodeValidator {

    private final HihokenshaKubunCode hihokenshaKubunCode;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaKubunCode 保険者区分コード
     */
    public HihokenshaKubunCodeValidator(HihokenshaKubunCode hihokenshaKubunCode) {
        requireNonNull(hihokenshaKubunCode, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link HihokenshaKubunCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(hihokenshaKubunCode)
                .messages();
    }
}
