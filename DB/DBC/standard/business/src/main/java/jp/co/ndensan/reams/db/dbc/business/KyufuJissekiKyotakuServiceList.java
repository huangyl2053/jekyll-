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
 * 給付実績居宅サービスをListで管理します。
 *
 * @author n8178 城間篤人
 */
public class KyufuJissekiKyotakuServiceList implements Iterable<KyufuJissekiKyotakuService> {

    List<KyufuJissekiKyotakuService> 給付実績居宅サービスList;

    /**
     * 引数から給付実績居宅サービスのListを受け取り、インスタンスを生成します。
     *
     * @param 給付実績居宅サービスList 給付実績居宅サービスList
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public KyufuJissekiKyotakuServiceList(List<KyufuJissekiKyotakuService> 給付実績居宅サービスList) throws NullPointerException {
        requireNonNull(給付実績居宅サービスList, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績居宅サービスList"));
        this.給付実績居宅サービスList = 給付実績居宅サービスList;
    }

    /**
     * 空であるか否かを判定します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 給付実績居宅サービスList.isEmpty();
    }

    /**
     * リストの大きさを返します。
     *
     * @return リストサイズ
     */
    public int size() {
        return 給付実績居宅サービスList.size();
    }

    @Override
    public Iterator<KyufuJissekiKyotakuService> iterator() {
        return 給付実績居宅サービスList.iterator();
    }

}
