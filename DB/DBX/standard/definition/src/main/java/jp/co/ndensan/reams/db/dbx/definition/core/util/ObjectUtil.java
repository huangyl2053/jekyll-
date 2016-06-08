/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.util;

/**
 * オブジェクトを扱うユーティリティです。
 */
public final class ObjectUtil {

    /**
     * 第1引数が{@code null}でなければ第1引数、{@code null}であれば第2引数を返却します。
     *
     * @param <T> 対象のオブジェクトの型
     * @param t {@code null}かどうか検査する対象
     * @param nullDefault 第1引数が{@code null}であった場合に返却する値
     * @return 第1引数が{@code null}でなければ第1引数、{@code null}であれば第2引数
     */
    public static <T> T defaultIfNull(T t, T nullDefault) {
        return t == null ? nullDefault : t;
    }

    private ObjectUtil() {
    }
}
