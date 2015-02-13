/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 警告区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KeikokuKubun {

    /**
     * 警告区分が「警告なし」であることを表します。 <br />
     * コード：１
     */
    警告なし("1"),
    /**
     * 警告区分が「警告あり」であることを表します。 <br />
     * コード：２
     */
    警告あり("2");
    private final RString code;

    private KeikokuKubun(String code) {
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
    public static KeikokuKubun toValue(RString code) {
        for (KeikokuKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する警告区分").evaluate());
    }
}
