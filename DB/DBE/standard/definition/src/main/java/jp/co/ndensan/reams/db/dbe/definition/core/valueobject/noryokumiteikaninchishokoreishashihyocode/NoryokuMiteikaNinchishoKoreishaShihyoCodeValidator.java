/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.noryokumiteikaninchishokoreishashihyocode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link NoryokuMiteikaNinchishoKoreishaShihyoCode}のバリデータークラスです。
 */
public class NoryokuMiteikaNinchishoKoreishaShihyoCodeValidator {

    private final NoryokuMiteikaNinchishoKoreishaShihyoCode noryokuKoreishaShihyoCode;

    /**
     * コンストラクタです。
     *
     * @param noryokuMiteikaNinchishoKoreishaShihyoCode 運動能力が低下していない認知症高齢者の指標
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoCodeValidator(NoryokuMiteikaNinchishoKoreishaShihyoCode noryokuKoreishaShihyoCode) {
        requireNonNull(noryokuKoreishaShihyoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("運動能力が低下していない認知症高齢者の指標"));
        this.noryokuKoreishaShihyoCode = noryokuKoreishaShihyoCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link NoryokuMiteikaNinchishoKoreishaShihyoCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(noryokuKoreishaShihyoCode)
                .messages();
    }
}
