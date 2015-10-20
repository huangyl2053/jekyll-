/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikenshoitemno;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShujiiIkenshoItemNo}のバリデータークラスです。
 */
public class ShujiiIkenshoItemNoValidator {

    private final ShujiiIkenshoItemNo shujiiIkenshoItemNo;

    /**
     * コンストラクタです
     *
     * @param shujiiIkenshoItemNo 主治医意見書の項目番号
     */
    public ShujiiIkenshoItemNoValidator(ShujiiIkenshoItemNo shujiiIkenshoItemNo) {
        requireNonNull(shujiiIkenshoItemNo, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書の項目番号"));
        this.shujiiIkenshoItemNo = shujiiIkenshoItemNo;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShujiiIkenshoItemNo}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shujiiIkenshoItemNo)
                .messages();
    }
}
