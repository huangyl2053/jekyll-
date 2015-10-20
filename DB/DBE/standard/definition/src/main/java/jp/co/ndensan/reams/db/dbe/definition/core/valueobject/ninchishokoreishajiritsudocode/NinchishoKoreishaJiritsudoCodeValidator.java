package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninchishokoreishajiritsudocode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link NinchishoKoreishaJiritsudoCode}のバリデータークラスです。
 */
public class NinchishoKoreishaJiritsudoCodeValidator {

    private final NinchishoKoreishaJiritsudoCode ninchishoKoreishaJiritsudoCode;

    /**
     * コンストラクタです
     *
     * @param ninchishoKoreishaJiritsudoCode 認知症高齢者自立度コード
     */
    public NinchishoKoreishaJiritsudoCodeValidator(NinchishoKoreishaJiritsudoCode ninchishoKoreishaJiritsudoCode) {
        requireNonNull(ninchishoKoreishaJiritsudoCode, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症高齢者自立度コード"));
        this.ninchishoKoreishaJiritsudoCode = ninchishoKoreishaJiritsudoCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link NinchishoKoreishaJiritsudoCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ninchishoKoreishaJiritsudoCode)
                .messages();
    }
}
