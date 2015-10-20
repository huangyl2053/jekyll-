/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ichijihanteikeikokucode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link IchijiHanteiKeikokuCode}のバリデータークラスです。
 */
public class IchijiHanteiKeikokuCodeValidator {

    private final IchijiHanteiKeikokuCode ichijiHanteiKeikokuCode;

    /**
     * コンストラクタです
     *
     * @param ichijiHanteiKeikokuCode 一次判定警告コード
     */
    public IchijiHanteiKeikokuCodeValidator(IchijiHanteiKeikokuCode ichijiHanteiKeikokuCode) {
        requireNonNull(ichijiHanteiKeikokuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定警告コード"));
        this.ichijiHanteiKeikokuCode = ichijiHanteiKeikokuCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link IchijiHanteiKeikokuCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ichijiHanteiKeikokuCode)
                .messages();
    }
}
