/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype;

/**
 * ソート順の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum SortOrder {

    /**
     * 昇順
     */
    ASC(1),
    /**
     * 降順
     */
    DESC(-1);
    private final int theRate;

    private SortOrder(int rate) {
        this.theRate = rate;
    }

    /**
     * {@link Comparable#compareTo(java.lang.Object) comparaTo()}に対応した、順序の係数を返します。
     *
     * @return {@link SortOrder#ASC ASC}のとき1, {@link SortOrder#DESC DESC}のとき-1。
     */
    public int rate() {
        return theRate;
    }
}
