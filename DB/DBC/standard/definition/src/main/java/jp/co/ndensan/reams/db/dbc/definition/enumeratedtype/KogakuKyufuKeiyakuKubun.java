/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 高額給付契約の有無を表す列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum KogakuKyufuKeiyakuKubun {

    /**
     * 契約有りを表します。
     */
    契約有り(true),
    /**
     * 契約無しを表します。
     */
    契約無し(false);
    private final boolean 契約有無Flag;

    private KogakuKyufuKeiyakuKubun(boolean 契約有無Flag) {
        this.契約有無Flag = 契約有無Flag;
    }

    /**
     * 契約有無を返します。
     *
     * @return 契約有りならtrue
     */
    public boolean is契約有り() {
        return 契約有無Flag;
    }

    /**
     * 引数（boolean型）に対応する契約区分（列挙型）を返します。
     *
     * @param is契約有り 契約区分（boolean型）
     * @return 契約区分（列挙型）
     */
    public static KogakuKyufuKeiyakuKubun toValue(boolean is契約有り) {
        return is契約有り ? KogakuKyufuKeiyakuKubun.契約有り : KogakuKyufuKeiyakuKubun.契約無し;
    }
}
