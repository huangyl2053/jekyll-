package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosaitemno;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link NinteichosaItemNo}のバリデータークラスです。
 */
public class NinteichosaItemNoValidator {

    private final NinteichosaItemNo ninteichosaItemNo;

    /**
     * コンストラクタです
     *
     * @param ninteichosaItemNo 要介護認定調査の調査項目番号
     */
    public NinteichosaItemNoValidator(NinteichosaItemNo ninteichosaItemNo) {
        requireNonNull(ninteichosaItemNo, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査の調査項目番号"));
        this.ninteichosaItemNo = ninteichosaItemNo;
    }

    /**
     * 保持するvalue{@link RString}について{@link NinteichosaItemNo}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ninteichosaItemNo)
                .messages();
    }
}
