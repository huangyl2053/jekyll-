/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.ExceptionSuppliers;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグから取得した値をwrapするクラスです。 取得したままの値を取得する場合は{@link #asRString() asRString}、
 * 任意の型へ変換して取得する場合は{@link #as(jp.co.ndensan.reams.db.dbz.model.util.function.IFunction) as()}を使用してください。
 *
 * @author N3327 三浦 凌
 * @deprecated 不要のため削除する。
 */
@Deprecated
public final class _ConfigValue implements IConfigValue {

    private final Optional<RString> rawValue;

    _ConfigValue(Optional<RString> rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public <T> T as(IFunction<RString, T> converter) {
        return this.rawValue.map(converter)
                .orElseThrow(ExceptionSuppliers.nullPointerException(UrSystemErrorMessages.値がnull.getReplacedMessage("取得値")));
    }

    @Override
    public RString asRString() {
        return this.rawValue
                .orElseThrow(ExceptionSuppliers.nullPointerException(UrSystemErrorMessages.値がnull.getReplacedMessage("取得値")));
    }
}
