/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 厚労省認定ソフト（インターフェース）のバージョンを表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum KoroshoIFKubun {

    /**
     * バージョンが「認定ソフト99」であることを表します。
     */
    V99A("99A"),
    /**
     * バージョンが「認定ソフト2002」であることを表します。
     */
    V02A("02A"),
    /**
     * バージョンが「認定ソフト2006」であることを表します。
     */
    V06A("06A"),
    /**
     * バージョンが「認定ソフト2009」であることを表します。
     */
    V09A("09A"),
    /**
     * バージョンが「認定ソフト2009（SP3）」であることを表します。
     */
    V09B("09B");
    private RString code;

    private KoroshoIFKubun(String code) {
        this.code = new RString(code);
    }

    public RString getCode() {
        return code;
    }
}
