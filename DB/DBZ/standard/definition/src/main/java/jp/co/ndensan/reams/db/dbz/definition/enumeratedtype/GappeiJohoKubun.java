/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報区分の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum GappeiJohoKubun {

    /**
     * 合併情報区分が「合併なし」であることを表します。<br/>
     * コード : 0
     */
    合併なし("0"),
    /**
     * 合併情報区分が「合併あり」であることを表します。<br/>
     * コード : 1
     */
    合併あり("1"),
    /**
     * 合併情報区分が「UNKNOWN」であることを表します。<br/>
     * コード : 99
     */
    UNKNOWN("99");
    private final RString code;

    private GappeiJohoKubun(String code) {
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
    public static GappeiJohoKubun toValue(RString code) {
        for (GappeiJohoKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        return UNKNOWN;
    }
}
