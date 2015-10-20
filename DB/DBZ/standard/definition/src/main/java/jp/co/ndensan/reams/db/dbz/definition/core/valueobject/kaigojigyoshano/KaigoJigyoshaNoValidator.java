/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link KaigoJigyoshaNo}のバリデータークラスです。
 */
public class KaigoJigyoshaNoValidator {

    private final KaigoJigyoshaNo kaigoJigyoshaNo;

    /**
     * コンストラクタです
     *
     * @param kaigoJigyoshaNo 認定調査委託先コード
     */
    public KaigoJigyoshaNoValidator(KaigoJigyoshaNo kaigoJigyoshaNo) {
        requireNonNull(kaigoJigyoshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.kaigoJigyoshaNo = kaigoJigyoshaNo;
    }

    /**
     * 保持するvalue{@link RString}について{@link KaigoJigyoshaNo}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(kaigoJigyoshaNo)
                .messages();
    }
}
