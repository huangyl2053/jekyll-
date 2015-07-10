/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public enum KokuhorenTorikomiJohoRecordShubetsu {

    コントロールレコード("1"),
    データレコード("2"),
    エンドレコード("3");

    private final RString code;

    private KokuhorenTorikomiJohoRecordShubetsu(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return コードに対応する列挙型
     */
    public static KokuhorenTorikomiJohoRecordShubetsu toValue(RString code) {
        for (KokuhorenTorikomiJohoRecordShubetsu data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return null;
    }
}
