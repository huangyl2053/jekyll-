/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者区分を表す列挙形です。
 *
 * @author N3327 三浦 凌
 */
public enum HihokenshaKubun {

    /**
     * 介護保険の第1号被保険者を表します。
     */
    第1号被保険者,
    /**
     * 介護保険の第2号被保険者を表します。
     */
    第2号被保険者,
    /**
     * その他
     */
    その他;

    /**
     * 名称から該当する被保険者区分を取得します。
     *
     * @param 名称
     * @return 該当する被保険者区分
     */
    public static HihokenshaKubun toValue(RString 名称) {
        return HihokenshaKubun.valueOf(名称.toString());
    }
}
