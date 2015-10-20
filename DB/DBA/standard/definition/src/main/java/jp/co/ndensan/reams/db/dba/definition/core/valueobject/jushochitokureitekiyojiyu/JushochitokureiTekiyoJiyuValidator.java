/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.jushochitokureikaijojiyu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link JushochitokureiTekiyoJiyu}のバリデータークラスです。
 */
public class JushochitokureiTekiyoJiyuValidator {

    private final JushochitokureiTekiyoJiyu jushochitokureiTekiyoJiyu;

    /**
     * コンストラクタです
     *
     * @param jushochitokureiTekiyoJiyu 住所地特例適用事由
     */
    public JushochitokureiTekiyoJiyuValidator(JushochitokureiTekiyoJiyu jushochitokureiTekiyoJiyu) {
        requireNonNull(jushochitokureiTekiyoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        requireNonNull(jushochitokureiTekiyoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("名称"));
        this.jushochitokureiTekiyoJiyu = jushochitokureiTekiyoJiyu;
    }

    /**
     * 保持するvalue{@link RString}について{@link JushochitokureiTekiyoJiyu}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(jushochitokureiTekiyoJiyu)
                .messages();
    }
}
