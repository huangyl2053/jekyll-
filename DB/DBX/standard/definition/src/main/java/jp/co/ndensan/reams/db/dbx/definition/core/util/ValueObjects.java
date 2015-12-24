/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.util;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IValueObject}を扱うユーティリティです。
 */
public final class ValueObjects {

    /**
     * 第1引数の{@link IValueObject}が{@code null}でなければ、{@link IValueObject#value()}の値を返却します。
     * もし{@code null}であれば、第2引数の値を返します。
     *
     * @param <T> {@code valueObject}の{@code value}の値
     * @param vo {@link IValueObject}を実装した{@code valueObject}
     * @param defaultValue {@link IValueObject}が{@code null}の場合に返却するデフォルト値
     * @return 第1引数の{@link IValueObject}が{@code null}でなければ、{@link IValueObject#value()}の値.{@code null}であれば、第2引数の値.
     */
    public static <T> T valueOrDefault(IValueObject<T> vo, T defaultValue) {
        return vo == null ? defaultValue : vo.value();
    }

    /**
     * 指定の{@link IValueObject}が{@code null}でなければ、{@link IValueObject#value()}の値を返却します。
     * もし{@code null}であれば、{@link RString#EMPTY}を返却します。
     *
     * @param vo {@link IValueObject}
     * @return 指定の{@link IValueObject}が{@code null}でなければ、{@link IValueObject#value()}の値.{@code null}であれば、{@link RString#EMPTY}.
     */
    public static RString valueOrRStringEMPTY(IValueObject<RString> vo) {
        return valueOrDefault(vo, RString.EMPTY);
    }

    private ValueObjects() {
    }
}
