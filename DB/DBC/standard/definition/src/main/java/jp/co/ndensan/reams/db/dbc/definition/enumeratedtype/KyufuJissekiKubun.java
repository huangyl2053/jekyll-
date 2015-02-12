/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KyufuJissekiKubun {

    /**
     * 給付実績区分が「現物」であることを表します。 <br />
     * コード：１
     */
    現物("1"),
    /**
     * 給付実績区分が「償還」であることを表します。 <br />
     * コード：２
     */
    償還("2");
    private final RString code;

    private KyufuJissekiKubun(String code) {
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
    public static KyufuJissekiKubun toValue(RString code) {
        for (KyufuJissekiKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する給付実績区分").evaluate());
    }
}
