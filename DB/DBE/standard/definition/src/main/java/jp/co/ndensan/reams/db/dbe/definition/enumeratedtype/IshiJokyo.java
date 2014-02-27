/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 医師の状況を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum IshiJokyo {

    /**
     * 医師の状況が「有効」であることを表します。
     */
    有効(true),
    /**
     * 医師の状況が「無効」であることを表します。
     */
    無効(false);
    private final boolean jokyo;

    private IshiJokyo(boolean jokyo) {
        this.jokyo = jokyo;
    }

    /**
     * 医師の状況が有効かどうかを判定します。
     *
     * @return 有効の場合はtrueを返します。
     */
    public boolean is有効() {
        return jokyo;
    }

    /**
     * 引数（boolean型）に対応する医師の状況（列挙型）を返します。
     *
     * @param jokyo 医師の状況（boolean型）
     * @return 医師の状況（列挙型）
     */
    public static IshiJokyo toValue(boolean jokyo) {
        return jokyo ? 有効 : 無効;
    }
}
