/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本人区分です。
 */
public enum HonninKubun {

    /**
     * 本人
     */
    本人("1"),
    /**
     * 世帯構成員
     */
    世帯構成員("2");
    private final RString code;

    private HonninKubun(String code) {
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
     * @throws IllegalArgumentException 指定のコードに対応するShikakuIdoKubunがないとき。
     * @return 指定のコードに対応する列挙型。該当する列挙型が見つからない場合は、UNKNOWNを返します。
     */
    public static HonninKubun toValue(RString code) throws IllegalArgumentException {
        for (HonninKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException();
    }
}
