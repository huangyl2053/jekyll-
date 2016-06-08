/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.util;

import java.util.Collections;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * コンフィグを取得するクラスが継承する抽象クラスです。
 *
 * @param <E> Enumの型
 */
public abstract class ConfigLoader<E> {

    private final Map<E, RString> map;

    /**
     * 指定のMapからインスタンスを生成します。
     *
     * @param map Map(キーはコンフィグのキー、値はキーに該当するコンフィグの設定値)
     */
    ConfigLoader(Map<? extends E, RString> map) {
        this.map = Collections.unmodifiableMap(map);
    }

    /**
     * 指定のキーに該当する値を返却します。
     *
     * @param e キー
     * @return キーに該当する値
     */
    protected RString get(E e) {
        return map.get(e);
    }

    /**
     * 指定のキーに該当する値をint型で返却します。
     *
     * @param e キー
     * @return キーに該当する値(int型)
     * @thorws NumberFormatException 取得した値が数値に変換できなかった場合
     */
    protected int getAsInt(E e) {
        return Integer.valueOf(this.get(e).toString());
    }

    /**
     * 指定のキーに該当する値を{@link Decimal}型で返却します。
     *
     * @param e キー
     * @return キーに該当する値({@link Decimal}型)
     * @thorws NumberFormatException 取得した値が数値に変換できなかった場合
     */
    protected Decimal getAsDecimal(E e) {
        return new Decimal(this.get(e).toString());
    }
}
