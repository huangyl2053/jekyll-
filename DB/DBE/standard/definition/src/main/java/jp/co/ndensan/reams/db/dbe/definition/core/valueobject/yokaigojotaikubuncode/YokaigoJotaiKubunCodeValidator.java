/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.yokaigojotaikubuncode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link YokaigoJotaiKubunCode}のバリデータークラスです。
 */
public class YokaigoJotaiKubunCodeValidator {

    private final YokaigoJotaiKubunCode yokaigoJotaiKubunCode;

    /**
     * コンストラクタです。
     *
     * @param yokaigoJotaiKubunCode 要介護状態区分コード
     */
    public YokaigoJotaiKubunCodeValidator(YokaigoJotaiKubunCode yokaigoJotaiKubunCode) {
        requireNonNull(yokaigoJotaiKubunCode, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link YokaigoJotaiKubunCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(yokaigoJotaiKubunCode)
                .messages();
    }
}
