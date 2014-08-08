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
 * 給付実績のサービス計画費情報リストを保持するコレクションクラスです。
 *
 * @author n8178 城間篤人
 */
public class KyufuJissekiKyotakuServiceCollection implements Iterable<KyufuJissekiKyotakuService> {

    private final List<KyufuJissekiKyotakuService> list;

    /**
     * インスタンスを生成します。
     *
     * @param list サービス計画費情報List
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public KyufuJissekiKyotakuServiceCollection(List<KyufuJissekiKyotakuService> list) throws NullPointerException {
        this.list = requireNonNull(list, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費情報List"));
    }

    /**
     * サービス計画費情報ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * サービス計画費情報Listの要素数を返します。
     *
     * @return サービス計画費情報Listの要素数
     */
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<KyufuJissekiKyotakuService> iterator() {
        return list.iterator();
    }
}
