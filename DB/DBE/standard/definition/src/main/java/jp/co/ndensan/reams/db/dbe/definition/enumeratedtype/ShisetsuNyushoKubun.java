/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 施設に入所しているかどうかを表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShisetsuNyushoKubun {

    /**
     * 施設に「入所している」ことを表します。<br />
     * コード : true
     */
    入所している(true),
    /**
     * 施設に「入所していない」ことを表します。<br />
     * コード : false
     */
    入所していない(false);
    private final boolean flg;

    private ShisetsuNyushoKubun(boolean flg) {
        this.flg = flg;
    }

    /**
     * 施設に入所しているかどうかを判定します。
     *
     * @return 入所している場合はtrueを返します。
     */
    public boolean is施設入所() {
        return flg;
    }

    /**
     * フラグに対応する列挙型を返します。
     *
     * @param flg フラグ
     * @return 列挙型
     */
    public static ShisetsuNyushoKubun toValue(boolean flg) {
        return flg ? 入所している : 入所していない;
    }
}
