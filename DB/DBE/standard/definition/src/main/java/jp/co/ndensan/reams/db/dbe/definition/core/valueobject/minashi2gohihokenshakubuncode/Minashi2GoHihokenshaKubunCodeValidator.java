/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.minashi2gohihokenshakubuncode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link Minashi2GoHihokenshaKubunCode}のバリデータークラスです。
 */
public class Minashi2GoHihokenshaKubunCodeValidator {

    private final Minashi2GoHihokenshaKubunCode minashi2GoHihokenshaKubunCode;

    /**
     * コンストラクタです。
     *
     * @param minashi2GoHihokenshaKubunCode みなし2号者の被保険者区分
     */
    public Minashi2GoHihokenshaKubunCodeValidator(Minashi2GoHihokenshaKubunCode minashi2GoHihokenshaKubunCode) {
        requireNonNull(minashi2GoHihokenshaKubunCode, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし2号者の被保険者区分"));
        this.minashi2GoHihokenshaKubunCode = minashi2GoHihokenshaKubunCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link Minashi2GoHihokenshaKubunCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(minashi2GoHihokenshaKubunCode)
                .messages();
    }
}
