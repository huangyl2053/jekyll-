/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.common.NotEmptyChecker;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.IValueObjectCheckable;
import jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject.common.NotNullChecker;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * RString を保持するValueObjectに対する専用のバリデータを取得する機能を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class RStringValueObjects {

    private RStringValueObjects() {
    }

    /**
     * valueObject自身、または、その保持する{@link RString RString}がnullでないことを、調べるインスタンスを返します。
     *
     * @return nullでないことを調べるインスタンス
     */
    public static IValueObjectCheckable<RString> notNull() {
        return NotNullChecker.getInstance(RString.class);
    }

    /**
     * valueObjectの保持する{@link RString RString}が{@link RString#EMPTY RStirng.EMPTY}でないことを、調べるインスタンスを返します。
     *
     * @return {@link RString#EMPTY RStirng.EMPTY}でないことを調べるインスタンス
     */
    public static IValueObjectCheckable<RString> notEmpty() {
        return NotEmptyChecker.forRString();
    }
}
