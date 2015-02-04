/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月初・月末区分の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum GesshoGetsumatsuKubun {

    /**
     * 月初・月末区分が「指定無」であることを表します。<br/>
     * コード : 0
     */
    指定無("0"),
    /**
     * 月初・月末区分が「月初」であることを表します。<br/>
     * コード : 1
     */
    月初("1"),
    /**
     * 月初・月末区分が「月末」であることを表します。<br/>
     * コード : 2
     */
    月末("2");
    private final RString code;

    private GesshoGetsumatsuKubun(String code) {
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
     * @return 指定のコードに対応する列挙型。該当する列挙型が見つからない場合は、nullを返します。
     */
    public static GesshoGetsumatsuKubun toValue(RString code) {
        for (GesshoGetsumatsuKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        return null;
    }
}
