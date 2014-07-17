/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 給付実績の集計情報リストを保持するコレクションクラス
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiShukeiCollection implements Iterable<KyufuJissekiShukei> {

    private final List<KyufuJissekiShukei> 給付実績の集計情報List;

    /**
     * コンストラクタです。
     *
     * @param 給付実績の集計情報List
     */
    public KyufuJissekiShukeiCollection(List<KyufuJissekiShukei> 給付実績の集計情報List) {
        this.給付実績の集計情報List = requireNonNull(給付実績の集計情報List,
                Messages.E00001.replace("給付実績の集計情報List").getMessage());
    }

    /**
     * 給付実績の明細情報ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return 給付実績の集計情報List.isEmpty();
    }

    /**
     * 給付実績の明細情報Listの要素数を返します。
     *
     * @return 給付実績の明細情報Listの要素数
     */
    public int size() {
        return 給付実績の集計情報List.size();
    }

    @Override
    public Iterator<KyufuJissekiShukei> iterator() {
        return 給付実績の集計情報List.iterator();
    }

}
