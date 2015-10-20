/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.suiteikyuhukubuncode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link SuiteiKyuhuKubunCode}のバリデータークラスです。
 */
public class SuiteiKyuhuKubunCodeValidator {

    private final SuiteiKyuhuKubunCode suiteiKyuhuKubunCode;

    /**
     * コンストラクタです
     *
     * @param suiteiKyuhuKubunCode 推定給付区分コード
     */
    public SuiteiKyuhuKubunCodeValidator(SuiteiKyuhuKubunCode suiteiKyuhuKubunCode) {
        requireNonNull(suiteiKyuhuKubunCode, UrSystemErrorMessages.値がnull.getReplacedMessage("推定給付区分コード"));
        this.suiteiKyuhuKubunCode = suiteiKyuhuKubunCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link SuiteiKyuhuKubunCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(suiteiKyuhuKubunCode)
                .messages();
    }
}
