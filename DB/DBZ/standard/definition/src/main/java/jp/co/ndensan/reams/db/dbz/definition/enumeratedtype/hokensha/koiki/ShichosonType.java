/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.koiki;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域における市町村の種類です。
 *
 * @author N3327 三浦 凌
 */
public enum ShichosonType {

    /**
     * 合併して、今は存在しない市町村であることを表します。
     */
    合併旧市町村("1"),
    /**
     * 広域の構成市町村であることを表します。
     */
    構成市町村("0");
    private final RString theCode;

    private ShichosonType(String code) {
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
