/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 住宅改修費情報リストを保持するコレクションクラスです。
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiJutakuKaishuhiCollection implements Iterable<KyufuJissekiJutakuKaishuhi> {

    private final List<KyufuJissekiJutakuKaishuhi> list;

    /**
     * インスタンスを生成します。
     *
     * @param list 住宅改修費情報List
     */
    public KyufuJissekiJutakuKaishuhiCollection(List<KyufuJissekiJutakuKaishuhi> list) {
        this.list = requireNonNull(list, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修費情報List"));
    }

    /**
     * 住宅改修費情報ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 住宅改修費情報Listの要素数を返します。
     *
     * @return 住宅改修費情報Listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiJutakuKaishuhi> iterator() {
        return list.iterator();
    }

}
