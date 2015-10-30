/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.valueobject.keiyakuno;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link KeiyakuNo}のバリデータークラスです。
 */
public class KeiyakuNoValidator {

    private final KeiyakuNo keiyakuNo;

    /**
     * コンストラクタです。
     *
     * @param keiyakuNo 受領委任契約番号
     */
    public KeiyakuNoValidator(KeiyakuNo keiyakuNo) {
        requireNonNull(keiyakuNo, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約番号"));
        this.keiyakuNo = keiyakuNo;
    }

    /**
     * 保持するvalue{@link RString}について{@link KeiyakuNo}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(keiyakuNo)
                .messages();
    }
}
