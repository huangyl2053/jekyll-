/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 調査員の状況を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ChosainJokyo {

    /**
     * 有効
     */
    有効(true),
    /**
     * 無効
     */
    無効(false);
    private final boolean jokyo;

    private ChosainJokyo(boolean jokyo) {
        this.jokyo = jokyo;
    }

    /**
     * 調査員の状況が有効かどうかを返します。
     *
     * @return 有効ならtrue、無効ならfalse
     */
    public boolean is有効() {
        return jokyo;
    }

    /**
     * 引数（boolean型）に対応する調査員の状況（列挙型）を返します。
     *
     * @param is有効 調査員の状況（boolean型）
     * @return 調査員の状況（列挙型）
     */
    public static ChosainJokyo toValue(boolean is有効) {
        return is有効 ? ChosainJokyo.有効 : ChosainJokyo.無効;
    }
}
