/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaichiku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link ShinsakaiKaisaiChiku}のバリデータークラスです。
 */
public class ShinsakaiKaisaiChikuValidator {

    private final ShinsakaiKaisaiChiku shinsakaiKaisaiChiku;

    /**
     * コンストラクタです
     *
     * @param shinsakaiKaisaiChiku 介護認定審査会の開催地区
     */
    public ShinsakaiKaisaiChikuValidator(ShinsakaiKaisaiChiku shinsakaiKaisaiChiku) {
        requireNonNull(shinsakaiKaisaiChiku, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会の開催地区"));
        this.shinsakaiKaisaiChiku = shinsakaiKaisaiChiku;
    }

    /**
     * 保持するvalue{@link RString}について{@link ShinsakaiKaisaiChiku}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(shinsakaiKaisaiChiku)
                .messages();
    }
}
