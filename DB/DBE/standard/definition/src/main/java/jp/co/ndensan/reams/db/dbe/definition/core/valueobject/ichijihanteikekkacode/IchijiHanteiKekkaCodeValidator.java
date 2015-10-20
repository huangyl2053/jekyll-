/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ichijihanteikekkacode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link IchijiHanteiKekkaCode}のバリデータークラスです。
 */
public class IchijiHanteiKekkaCodeValidator {

    private final IchijiHanteiKekkaCode ichijiHanteiKekkaCode;

    /**
     * コンストラクタです
     *
     * @param ichijiHanteiKekkaCode 一次判定結果コード
     */
    public IchijiHanteiKekkaCodeValidator(IchijiHanteiKekkaCode ichijiHanteiKekkaCode) {
        requireNonNull(ichijiHanteiKekkaCode, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果コード"));
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link IchijiHanteiKekkaCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ichijiHanteiKekkaCode)
                .messages();
    }
}
