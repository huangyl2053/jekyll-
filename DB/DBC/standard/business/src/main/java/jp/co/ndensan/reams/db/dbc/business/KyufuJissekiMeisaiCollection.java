/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 給付実績の明細情報リストを保持するコレクションクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiMeisaiCollection implements Iterable<KyufuJissekiMeisai> {

    private final List<KyufuJissekiMeisai> list;

    /**
     * インスタンスを生成します。
     *
     * @param list 給付実績の明細情報リスト
     */
    public KyufuJissekiMeisaiCollection(List<KyufuJissekiMeisai> list) {
        this.list = requireNonNull(list, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績の明細情報List"));
    }

    /**
     * 給付実績の明細情報ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 給付実績の明細情報Listの要素数を返します。
     *
     * @return listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiMeisai> iterator() {
        return list.iterator();
    }
}
