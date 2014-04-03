/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link Code Code}をwrapしたValueObjectです。
 *
 * @author N3327 三浦 凌
 */
public interface ICodeWrapValueObject extends IValueObject<RString> {

    /**
     * Codeとして返します。
     *
     * @return {@link Code Code}
     */
    Code asCode();
}
