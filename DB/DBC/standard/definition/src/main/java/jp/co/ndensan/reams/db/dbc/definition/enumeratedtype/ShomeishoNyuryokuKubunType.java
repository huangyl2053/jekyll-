/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証明書入力済フラグの列擧型です。
 *
 * @reamsid_L DBC-1030-090 qiuxy
 */
public enum ShomeishoNyuryokuKubunType {

    /**
     * 入力なし。
     */
    入力なし("0", "入力なし"),
    /**
     * 入力あり。
     */
    入力あり("1", "入力あり");

    private final RString code;
    private final RString name;

    private ShomeishoNyuryokuKubunType(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
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
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return this.name;
    }
}
