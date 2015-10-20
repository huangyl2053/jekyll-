/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosajisshibashokubuncode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link NinteichosaJisshibashoKubunCode}のバリデータークラスです。
 */
public class NinteichosaJisshibashoKubunCodeValidator {

    private final NinteichosaJisshibashoKubunCode ninteichosaJisshibashoKubunCode;

    /**
     * コンストラクタです
     *
     * @param ninteichosaJisshibashoKubunCode 要介護認定調査の実施場所区分コード
     */
    public NinteichosaJisshibashoKubunCodeValidator(NinteichosaJisshibashoKubunCode ninteichosaJisshibashoKubunCode) {
        requireNonNull(ninteichosaJisshibashoKubunCode, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査の実施場所区分コード"));
        this.ninteichosaJisshibashoKubunCode = ninteichosaJisshibashoKubunCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link NinteichosaJisshibashoKubunCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ninteichosaJisshibashoKubunCode)
                .messages();
    }
}
