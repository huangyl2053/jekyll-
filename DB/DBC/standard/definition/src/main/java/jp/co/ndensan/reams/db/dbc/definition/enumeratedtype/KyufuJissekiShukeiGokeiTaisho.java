/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績集計の合計対象を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum KyufuJissekiShukeiGokeiTaisho {

    /**
     * 合計対象が「居宅サービス合計」であることを表します。 <br />
     * コード：１
     */
    居宅サービス合計("1"),
    /**
     * 合計対象が「施設サービス合計」であることを表します。 <br />
     * コード：２
     */
    施設サービス合計("2"),
    /**
     * 合計対象が「地域密着型サービス合計」であることを表します。 <br />
     * コード：３
     */
    地域密着型サービス合計("3");
    private final RString code;

    private KyufuJissekiShukeiGokeiTaisho(String code) {
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
    public static KyufuJissekiShukeiGokeiTaisho toValue(RString code) {
        for (KyufuJissekiShukeiGokeiTaisho data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する給付実績集計の合計対象").getMessage());
    }

}
