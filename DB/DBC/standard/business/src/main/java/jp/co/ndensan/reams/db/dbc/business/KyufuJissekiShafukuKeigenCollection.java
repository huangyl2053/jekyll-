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
 * 給付実績の社会福祉法人軽減額情報リストを保持するコレクションクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiShafukuKeigenCollection implements Iterable<KyufuJissekiShafukuKeigen> {

    private final List<KyufuJissekiShafukuKeigen> list;

    /**
     * インスタンスを生成します。
     *
     * @param list 給付実績の社会福祉法人軽減額情報List
     */
    public KyufuJissekiShafukuKeigenCollection(List<KyufuJissekiShafukuKeigen> list) {
        this.list = requireNonNull(list, Messages.E00001.replace("給付実績の社会福祉法人軽減額情報List").getMessage());
    }

    /**
     * 給付実績の社会福祉法人軽減額情報ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 給付実績の社会福祉法人軽減額情報Listの要素数を返します。
     *
     * @return 給付実績の社会福祉法人軽減額情報Listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiShafukuKeigen> iterator() {
        return list.iterator();
    }
}
