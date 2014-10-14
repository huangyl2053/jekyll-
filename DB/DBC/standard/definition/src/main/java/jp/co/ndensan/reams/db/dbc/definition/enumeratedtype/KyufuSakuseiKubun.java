/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績情報作成区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KyufuSakuseiKubun {

    /**
     * 給付実績情報作成区分が「新規」であることを表します。 <br />
     * コード：１
     */
    新規("1"),
    /**
     * 給付実績情報作成区分が「修正」であることを表します。 <br />
     * コード：２
     */
    修正("2"),
    /**
     * 給付実績情報作成区分が「削除」であることを表します。 <br />
     * コード：３
     */
    削除("3");
    private final RString code;

    private KyufuSakuseiKubun(String code) {
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
    public static KyufuSakuseiKubun toValue(RString code) {
        for (KyufuSakuseiKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する給付実績情報作成区分").getMessage());
    }
}
