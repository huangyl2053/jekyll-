/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigodoctorcode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link KaigoDoctorCode}のバリデータークラスです。
 */
public class KaigoDoctorCodeValidator {

    private final KaigoDoctorCode kaigoDoctorCode;

    /**
     * コンストラクタです
     *
     * @param kaigoDoctorCode 介護医師コード
     */
    public KaigoDoctorCodeValidator(KaigoDoctorCode kaigoDoctorCode) {
        requireNonNull(kaigoDoctorCode, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.kaigoDoctorCode = kaigoDoctorCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link KaigoDoctorCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(kaigoDoctorCode)
                .messages();
    }
}
