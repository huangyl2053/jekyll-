/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.saikofujiyu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link SaikofuJiyu}のバリデータークラスです。
 */
public class SaikofuJiyuValidator {

    private final SaikofuJiyu saikofuJiyu;

    /**
     * コンストラクタです。
     *
     * @param saikofuJiyu 被保険者証の再交付事由
     */
    public SaikofuJiyuValidator(SaikofuJiyu saikofuJiyu) {
        requireNonNull(saikofuJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        requireNonNull(saikofuJiyu, UrSystemErrorMessages.値がnull.getReplacedMessage("名称"));
        this.saikofuJiyu = saikofuJiyu;
    }

    /**
     * 保持するvalue{@link RString}について{@link SaikofuJiyu}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(saikofuJiyu)
                .messages();
    }
}
