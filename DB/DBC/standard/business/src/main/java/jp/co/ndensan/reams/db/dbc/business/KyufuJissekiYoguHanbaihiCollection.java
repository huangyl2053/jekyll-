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
 * 福祉用具購入費リストを保持するコレクションクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiYoguHanbaihiCollection implements Iterable<KyufuJissekiYoguHanbaihi> {

    private final List<KyufuJissekiYoguHanbaihi> list;

    /**
     * インスタンスを生成します。
     *
     * @param list 福祉用具購入費List
     */
    public KyufuJissekiYoguHanbaihiCollection(List<KyufuJissekiYoguHanbaihi> list) {
        this.list = requireNonNull(list, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具購入費List"));
    }

    /**
     * 福祉用具購入費ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 福祉用具購入費Listの要素数を返します。
     *
     * @return 福祉用具購入費Listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiYoguHanbaihi> iterator() {
        return list.iterator();
    }
}
