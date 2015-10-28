/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.shikakuhenkojiyu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShikakuHenkoJiyu}のバリデータークラスです。
 */
public class ShikakuHenkoJiyuValidator {

    private final ShikakuHenkoJiyu shikakuHenkoJiyu;

    /**
     * コンストラクタです。
     *
     * @param shikakuHenkoJiyu 資格変更事由
     */
    public ShikakuHenkoJiyuValidator(ShikakuHenkoJiyu shikakuHenkoJiyu) {
        requireNonNull(shikakuHenkoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        requireNonNull(shikakuHenkoJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("名称"));
        this.shikakuHenkoJiyu = shikakuHenkoJiyu;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShikakuHenkoJiyu}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shikakuHenkoJiyu)
                .messages();
    }
}
