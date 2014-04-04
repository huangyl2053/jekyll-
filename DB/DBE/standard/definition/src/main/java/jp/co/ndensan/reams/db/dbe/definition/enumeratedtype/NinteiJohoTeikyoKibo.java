/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 認定情報の提供を希望するかどうかを表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteiJohoTeikyoKibo {

    /**
     * 認定情報の提供を「希望する」ことを表します。
     */
    希望する(true),
    /**
     * 認定情報の提供を「希望しない」ことを表します。
     */
    希望しない(false);
    private final boolean flg;

    private NinteiJohoTeikyoKibo(boolean flg) {
        this.flg = flg;
    }

    /**
     * 認定情報の提供を希望するかどうかを判定します。
     *
     * @return 希望する場合はtrueを返します。
     */
    public boolean is希望() {
        return flg;
    }

    /**
     * フラグに対応する列挙型を返します。
     *
     * @param flg フラグ
     * @return 列挙型
     */
    public static NinteiJohoTeikyoKibo toValue(boolean flg) {
        return flg ? 希望する : 希望しない;
    }
}
