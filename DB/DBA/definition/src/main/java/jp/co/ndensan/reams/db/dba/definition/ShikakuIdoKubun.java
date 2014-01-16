/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険の資格異動を表す区分の列挙型です。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuIdoKubun {

    /**
     * 介護保険資格を新たに取得した場合に該当します。
     */
    資格取得,
    /**
     * 介護保険資格の変更に該当します。
     */
    資格変更,
    /**
     * 介護保険資格を喪失した場合に該当します。
     */
    資格喪失;

    /**
     * 名称から該当する資格異動区分を取得します。
     *
     * @param 名称
     * @return 該当する資格異動区分
     */
    public static ShikakuIdoKubun toValue(RString 名称) {
        return ShikakuIdoKubun.valueOf(名称.toString());
    }
}
