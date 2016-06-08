/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaino;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShinsakaiKaisaiNo}のバリデータークラスです。
 */
public class ShinsakaiKaisaiNoValidator {

    private final ShinsakaiKaisaiNo shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 審査会開催番号
     */
    public ShinsakaiKaisaiNoValidator(ShinsakaiKaisaiNo shinsakaiKaisaiNo) {
        requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会開催番号"));
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShinsakaiKaisaiNo}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shinsakaiKaisaiNo)
                .messages();
    }
}
