/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.kaigoninteichosainno;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link KaigoNinteichosainNo}のバリデータークラスです。
 */
public class KaigoNinteichosainNoValidator {

    private final KaigoNinteichosainNo kaigoNinteichosainNo;

    /**
     * コンストラクタです
     *
     * @param kaigoNinteichosainNo 介護独自の認定調査員番号
     */
    public KaigoNinteichosainNoValidator(KaigoNinteichosainNo kaigoNinteichosainNo) {
        requireNonNull(kaigoNinteichosainNo, UrSystemErrorMessages.値がnull.getReplacedMessage("介護独自の認定調査員番号"));
        this.kaigoNinteichosainNo = kaigoNinteichosainNo;
    }

    /**
     * 保持するvalue{@link RString}について{@link KaigoNinteichosainNo}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(kaigoNinteichosainNo)
                .messages();
    }
}
