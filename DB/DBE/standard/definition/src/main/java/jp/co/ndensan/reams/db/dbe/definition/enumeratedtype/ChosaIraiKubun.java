/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査依頼区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ChosaIraiKubun {

    /**
     * 調査依頼区分が「初回」であることを表します。
     */
    初回(0),
    /**
     * 調査依頼区分が「再依頼」であることを表します。
     */
    再依頼(1),
    /**
     * 調査依頼区分が「再調査」であることを表します。
     */
    再調査(2);
    private final int code;

    private ChosaIraiKubun(int code) {
        this.code = code;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return new RString(Integer.toString(this.code));
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static ChosaIraiKubun toValue(RString code) {
        for (ChosaIraiKubun data : ChosaIraiKubun.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return null;
    }
}
