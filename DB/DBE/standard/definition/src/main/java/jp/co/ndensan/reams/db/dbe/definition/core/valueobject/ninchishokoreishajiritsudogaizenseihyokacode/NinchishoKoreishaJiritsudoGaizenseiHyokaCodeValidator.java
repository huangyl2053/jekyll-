/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninchishokoreishajiritsudogaizenseihyokacode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link NinchishoKoreishaJiritsudoGaizenseiHyokaCode}のバリデータークラスです。
 */
public class NinchishoKoreishaJiritsudoGaizenseiHyokaCodeValidator {

    private final NinchishoKoreishaJiritsudoGaizenseiHyokaCode ninchishoGaizenseiHyokaCode;

    /**
     * コンストラクタです。
     *
     * @param ninchishoKoreishaJiritsudoGaizenseiHyokaCode
     * 認知症高齢者日常生活自立度が、どの程度確からしいか
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaCodeValidator(NinchishoKoreishaJiritsudoGaizenseiHyokaCode ninchishoGaizenseiHyokaCode) {
        requireNonNull(ninchishoGaizenseiHyokaCode,
                UrSystemErrorMessages.値がnull.getReplacedMessage("認知症高齢者日常生活自立度が、どの程度確からしいか"));
        this.ninchishoGaizenseiHyokaCode = ninchishoGaizenseiHyokaCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link NinchishoKoreishaJiritsudoGaizenseiHyokaCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ninchishoGaizenseiHyokaCode)
                .messages();
    }
}
