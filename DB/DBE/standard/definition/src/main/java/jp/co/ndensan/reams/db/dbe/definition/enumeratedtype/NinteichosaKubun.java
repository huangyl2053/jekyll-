/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteichosaKubun {

    /**
     * 調査区分が「新規調査」であることを表します。<br />
     * コード : 0
     */
    新規調査(0),
    /**
     * 調査区分が「継続調査」であることを表します。<br />
     * コード : 1
     */
    継続調査(1);
    private final int code;

    private NinteichosaKubun(int code) {
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
    public static NinteichosaKubun toValue(RString code) {
        for (NinteichosaKubun data : NinteichosaKubun.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return null;
    }
}
