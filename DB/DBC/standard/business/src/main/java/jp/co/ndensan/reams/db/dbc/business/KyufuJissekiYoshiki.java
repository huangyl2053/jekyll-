/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の様式を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiYoshiki {

    private static final Map<RString, KyufuJissekiYoshikiKubun> map;

    static {
        map = new HashMap<>();
        map.put(new RString("7131"), KyufuJissekiYoshikiKubun.様式第二);
        map.put(new RString("21C1"), KyufuJissekiYoshikiKubun.様式第十三);
        map.put(new RString("21D1"), KyufuJissekiYoshikiKubun.様式第十四);
    }

    /**
     * 指定したコードに該当する様式区分を返します。
     *
     * @param code コード
     * @return 様式区分
     */
    public static KyufuJissekiYoshikiKubun get様式区分(RString code) {
        KyufuJissekiYoshikiKubun kubun = map.get(code);
        return kubun != null ? kubun : KyufuJissekiYoshikiKubun.不明;
    }
}
