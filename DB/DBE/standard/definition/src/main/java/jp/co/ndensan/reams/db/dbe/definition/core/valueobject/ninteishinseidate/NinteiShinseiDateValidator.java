/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteishinseidate;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link NinteiShinseiDate}のバリデータークラスです。
 */
public class NinteiShinseiDateValidator {

    private final NinteiShinseiDate ninteiShinseiDate;

    /**
     * コンストラクタです。
     *
     * @param ninteiShinseiDate 認定申請年月日
     */
    public NinteiShinseiDateValidator(NinteiShinseiDate ninteiShinseiDate) {
        requireNonNull(ninteiShinseiDate, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請年月日"));
        this.ninteiShinseiDate = ninteiShinseiDate;
    }

    /**
     * 保持するvalue{@link RString}について{@link NinteiShinseiDate}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(ninteiShinseiDate)
                .messages();
    }
}
