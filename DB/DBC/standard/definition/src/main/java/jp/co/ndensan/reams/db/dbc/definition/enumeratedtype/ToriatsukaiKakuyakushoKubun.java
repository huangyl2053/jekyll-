/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 取扱確約書の有無を表す列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum ToriatsukaiKakuyakushoKubun {

    /**
     * 確約書有りを表します。
     */
    確約書有り(true),
    /**
     * 確約書無しを表します。
     */
    確約書無し(false);
    private final boolean 確約書有無Flag;

    private ToriatsukaiKakuyakushoKubun(boolean 確約書有無Flag) {
        this.確約書有無Flag = 確約書有無Flag;
    }

    /**
     * 確約書有無を返します。
     *
     * @return 確約書有りならtrue
     */
    public boolean is確約書有り() {
        return 確約書有無Flag;
    }

    /**
     * 引数（boolean型）に対応する確約書区分（列挙型）を返します。
     *
     * @param is確約書有り 確約書区分（boolean型）
     * @return 確約書区分（列挙型）
     */
    public static ToriatsukaiKakuyakushoKubun toValue(boolean is確約書有り) {
        return is確約書有り ? ToriatsukaiKakuyakushoKubun.確約書有り : ToriatsukaiKakuyakushoKubun.確約書無し;
    }
}
