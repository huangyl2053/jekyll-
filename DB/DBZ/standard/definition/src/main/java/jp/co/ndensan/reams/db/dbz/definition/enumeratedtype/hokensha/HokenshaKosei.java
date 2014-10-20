/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者の構成です。
 *
 * @author N3327 三浦 凌
 */
public enum HokenshaKosei {

    単一市町村("1"), 広域市町村("2");
    private final RString theCode;

    private HokenshaKosei(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.theCode;
    }
}
