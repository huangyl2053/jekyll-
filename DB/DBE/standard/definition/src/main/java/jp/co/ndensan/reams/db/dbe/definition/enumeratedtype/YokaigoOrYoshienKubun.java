/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護もしくは要支援をあらわす列挙です。
 *
 * @author N3327 三浦 凌
 */
public enum YokaigoOrYoshienKubun {

    /**
     * 要介護 <br />
     * コード : "1"
     */
    要介護("1"),
    /**
     * 要支援 <br />
     * コード : "2"
     */
    要支援("2"),;

    private final RString code;

    private final RString theName;

    private YokaigoOrYoshienKubun(String code) {
        this.code = new RString(code);
        this.theName = new RString(name());
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * name()と同じ文字列をRString型で返します。
     *
     * @return name()と同じ文字列を持ったRString
     */
    public RString toRString() {
        return this.theName;
    }

}
