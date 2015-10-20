/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.timestring;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link TimeString}のバリデータークラスです。
 */
public class TimeStringValidator {

    private final TimeString timeString;

    /**
     * コンストラクタです
     *
     * @param timeString 介護独自で、文字列で表した時間
     */
    public TimeStringValidator(TimeString timeString) {
        requireNonNull(timeString, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.timeString = timeString;
    }

    /**
     * 保持するvalue{@link RString}について{@link TimeString}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(timeString)
                .ifNot(TimeStringSpec.桁数が4桁であること)
                .thenAdd(TimeStringValidationMessage.桁数が4桁でないこと)
                .messages();
    }
}
