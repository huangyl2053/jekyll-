/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 一次判定が仮のものであるか否かを表す区分です。
 *
 * @author n8178 城間篤人
 */
public enum KariIchijiHanteiKubun {

    /**
     * 一次判定が仮のものであることを表します。
     */
    仮判定(true),
    /**
     * 一次判定が仮ではないことを表します。
     */
    本判定(false);
    private final boolean 仮判定フラグ;

    private KariIchijiHanteiKubun(boolean 仮判定フラグ) {
        this.仮判定フラグ = 仮判定フラグ;
    }

    /**
     * 仮判定か否かを返します。
     *
     * @return 仮判定ならtrue
     */
    public boolean is仮判定() {
        return 仮判定フラグ;
    }

    /**
     * 引数から仮判定フラグを受け取り、対応する項目を返します。
     *
     * @param 仮判定フラグ 仮判定フラグ
     * @return 仮判定区分
     */
    public static KariIchijiHanteiKubun toValue(boolean 仮判定フラグ) {
        if (仮判定フラグ) {
            return 仮判定;
        }
        return 本判定;
    }
}
