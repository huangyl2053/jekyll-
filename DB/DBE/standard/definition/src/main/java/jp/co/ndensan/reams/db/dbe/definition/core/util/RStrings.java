/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.util;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 文字列変換のユーティリティです。
 */
public final class RStrings {

    private RStrings() {
    }

    /**
     * 指定の文字列のひらがなを半角カタカナに変換した結果、
     * すべて半角カタカナの文字列となる場合は、その文字列を返却します。
     * 以外の場合は、そのままの文字列を返却します。
     *
     * @param aRawValue 変換対象文字列
     * @return {@link ConvertionResult}
     */
    public static RString to半角カナOnlyOrRawTryToConvertかなto半角カナ(RString aRawValue) {
        if (RString.isNullOrEmpty(aRawValue)) {
            return aRawValue;
        }
        RString mayBeConverted = RStringUtil.convert全角ひらがなto半角カタカナ(aRawValue);
        if (RStringUtil.is半角カナOnly(mayBeConverted)) {
            return mayBeConverted;
        } else {
            return aRawValue;
        }
    }

    /**
     * 指定の文字列からすべてのスペース（全角、半角どちらも）を削除した文字列を返します。
     *
     * @param aRawValue 編集対象の文字列
     * @return 指定の文字列からすべてのスペース（全角、半角どちらも）を削除した文字列
     */
    public static RString removedSpaces(RString aRawValue) {
        if (RString.isNullOrEmpty(aRawValue)) {
            return aRawValue;
        }
        return new RStringBuilder().append(aRawValue)
                .replace(RString.FULL_SPACE, RString.EMPTY)
                .replace(RString.HALF_SPACE, RString.EMPTY)
                .toRString();
    }
}
