/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保区分の列挙型です。<br />
 * 本区分は対象者検索独自の区分であり、被保険者区分（第１号被保険者、第２号被保険者）とは異なります。
 *
 * @author N8156 宮本 康
 */
public enum HihoKubun {

    /**
     * 被保区分が「適除」であることを表します。
     */
    適除,
    /**
     * 被保区分が「他住」であることを表します。
     */
    他住,
    /**
     * 被保区分が「自住」であることを表します。
     */
    自住,
    /**
     * 被保区分が「資格」であることを表します。
     */
    資格,
    /**
     * 被保区分が「UNKNOWN」であることを表します。
     */
    UNKNOWN;

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return (this != UNKNOWN) ? new RString(this.name()) : RString.EMPTY;
    }
}
