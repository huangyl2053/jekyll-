/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定のサービス区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ServiceKubun {

    /**
     * サービス区分が「予防給付サービス」であることを表します。
     */
    予防給付サービス(1),
    /**
     * サービス区分が「介護給付サービス」であることを表します。
     */
    介護給付サービス(2),
    /**
     * サービス区分が「なし」であることを表します。
     */
    なし(9);
    private final int code;

    private ServiceKubun(int code) {
        this.code = code;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return new RString(Integer.toString(this.code));
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static ServiceKubun toValue(RString code) {
        for (ServiceKubun data : ServiceKubun.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return null;
    }
}
