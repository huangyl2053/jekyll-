/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.jushochitokureikaijojiyu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link JushochitokureiKaijoJiyu}のバリデータークラスです。
 */
public class JushochitokureiKaijoJiyuValidator {

    private final JushochitokureiKaijoJiyu jushochitokureiKaijoJiyu;

    /**
     * コンストラクタです。
     *
     * @param jushochitokureiKaijoJiyu 住所地特例解除事由
     */
    public JushochitokureiKaijoJiyuValidator(JushochitokureiKaijoJiyu jushochitokureiKaijoJiyu) {
        requireNonNull(jushochitokureiKaijoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        requireNonNull(jushochitokureiKaijoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("名称"));
        this.jushochitokureiKaijoJiyu = jushochitokureiKaijoJiyu;
    }

    /**
     * 保持するvalue{@link RString}について{@link JushochitokureiKaijoJiyu}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(jushochitokureiKaijoJiyu)
                .messages();
    }
}
