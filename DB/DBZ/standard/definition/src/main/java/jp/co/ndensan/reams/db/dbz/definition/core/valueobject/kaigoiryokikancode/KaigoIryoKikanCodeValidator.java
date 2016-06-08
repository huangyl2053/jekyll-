/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link KaigoIryoKikanCode}のバリデータークラスです。
 */
public class KaigoIryoKikanCodeValidator {

    private final KaigoIryoKikanCode kaigoIryoKikanCode;

    /**
     * コンストラクタです。
     *
     * @param kaigoIryoKikanCode 介護医療機関コード
     */
    public KaigoIryoKikanCodeValidator(KaigoIryoKikanCode kaigoIryoKikanCode) {
        requireNonNull(kaigoIryoKikanCode, UrSystemErrorMessages.値がnull.getReplacedMessage(""));
        this.kaigoIryoKikanCode = kaigoIryoKikanCode;
    }

    /**
     * 保持するvalue{@link RString}について{@link KaigoIryoKikanCode}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(kaigoIryoKikanCode)
                .messages();
    }
}
