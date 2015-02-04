/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 措置元・措置先区分の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum SochimotoSochisakiKubun {

    /**
     * 措置元・措置先区分が「措置元」であることを表します。<br/>
     * コード : 1
     */
    措置元("1"),
    /**
     * 措置元・措置先区分が「措置先」であることを表します。<br/>
     * コード : 2
     */
    措置先("2"),
    /**
     * 措置元・措置先区分が「措置元・措置先」であることを表します。<br/>
     * コード : 3
     */
    措置元_措置先("3"),
    /**
     * 措置元・措置先区分が「UNKNOWN」であることを表します。<br/>
     * コード : 99
     */
    UNKNOWN("99");
    private final RString code;

    private SochimotoSochisakiKubun(String code) {
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
    public static SochimotoSochisakiKubun toValue(RString code) {
        for (SochimotoSochisakiKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        return UNKNOWN;
    }
}
