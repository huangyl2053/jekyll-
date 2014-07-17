/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 給付実績の基本情報(合計)リストを保持するコレクションクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiKihonGokeiCollection implements Iterable<KyufuJissekiKihonGokei> {

    private final List<KyufuJissekiKihonGokei> list;

    /**
     * インスタンスを生成します。
     *
     * @param list 給付実績基本情報合計List
     */
    public KyufuJissekiKihonGokeiCollection(List<KyufuJissekiKihonGokei> list) {
        this.list = requireNonNull(list, Messages.E00001.replace("給付実績の基本情報合計List").getMessage());
    }

    /**
     * 給付実績基本情報合計ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 給付実績基本情報合計Listの要素数を返します。
     *
     * @return 給付実績基本情報合計Listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiKihonGokei> iterator() {
        return list.iterator();
    }
}
