/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者構成区分の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum HokenshaKoseiKubun {

    /**
     * 保険者構成区分が「単一市町村」であることを表します。<br/>
     * コード : 1
     */
    単一市町村("1"),
    /**
     * 保険者構成区分が「広域保険者」であることを表します。<br/>
     * コード : 2
     */
    広域保険者("2"),
    /**
     * 保険者構成区分が「UNKNOWN」であることを表します。<br/>
     * コード : 99
     */
    UNKNOWN("99");
    private final RString code;

    private HokenshaKoseiKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 指定のコードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 指定のコードに対応する列挙型。該当する列挙型が見つからない場合は、UNKNOWNを返します。
     */
    public static HokenshaKoseiKubun toValue(RString code) {
        for (HokenshaKoseiKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        return UNKNOWN;
    }
}
