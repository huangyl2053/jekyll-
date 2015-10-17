/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 給付実績の集計情報リストを保持するコレクションクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiShukeiCollection implements Iterable<KyufuJissekiShukei> {

    private final List<KyufuJissekiShukei> list;

    /**
     * インスタンスを生成します。
     *
     * @param list 給付実績の集計情報List
     */
    public KyufuJissekiShukeiCollection(List<KyufuJissekiShukei> list) {
        this.list = requireNonNull(list, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績の集計情報List"));
    }

    /**
     * 給付実績の集計情報ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 給付実績の集計情報Listの要素数を返します。
     *
     * @return 給付実績の集計情報Listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiShukei> iterator() {
        return list.iterator();
    }
}
