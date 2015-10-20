/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shogaikoreishajiritsudocode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShogaiKoreishaJiritsudoCode}のバリデータークラスです。
 */
public class ShogaiKoreishaJiritsudoCodeValidator {

    private final ShogaiKoreishaJiritsudoCode shogaiKoreishaJiritsudoCode;

    /**
     * コンストラクタです
     *
     * @param shogaiKoreishaJiritsudoCode 障害高齢者自立度コード
     */
    public ShogaiKoreishaJiritsudoCodeValidator(ShogaiKoreishaJiritsudoCode shogaiKoreishaJiritsudoCode) {
        requireNonNull(shogaiKoreishaJiritsudoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("障害高齢者自立度コード"));
        this.shogaiKoreishaJiritsudoCode = shogaiKoreishaJiritsudoCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShogaiKoreishaJiritsudoCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shogaiKoreishaJiritsudoCode)
                .messages();
    }
}
