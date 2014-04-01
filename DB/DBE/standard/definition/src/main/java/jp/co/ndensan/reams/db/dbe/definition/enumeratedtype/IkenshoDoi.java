/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 意見書に同意するかどうかを表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum IkenshoDoi {

    /**
     * 意見書に「同意する」ことを表します。
     */
    同意する(true),
    /**
     * 意見書に「同意しない」ことを表します。
     */
    同意しない(false);
    private final boolean flg;

    private IkenshoDoi(boolean flg) {
        this.flg = flg;
    }

    /**
     * 意見書に同意するかどうかを判定します。
     *
     * @return 同意する場合はtrueを返します。
     */
    public boolean is同意() {
        return flg;
    }

    /**
     * フラグに対応する列挙型を返します。
     *
     * @param flg フラグ
     * @return 列挙型
     */
    public static IkenshoDoi toValue(boolean flg) {
        return flg ? 同意する : 同意しない;
    }
}
