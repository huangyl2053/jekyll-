/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 給付実績月別集計のコレクションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceCollections implements Iterable {

    private final List<KyufuJissekiServiceCollection> 給付実績月別集計リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 給付実績月別集計リスト 給付実績月別集計リスト
     */
    public KyufuJissekiServiceCollections(List<KyufuJissekiServiceCollection> 給付実績月別集計リスト) {
        this.給付実績月別集計リスト = requireNonNull(給付実績月別集計リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績月別集計リスト"));
    }

    /**
     * 指定されたサービス提供年月の給付実績月別集計を返します。<br/>
     * 存在しない場合はnullが返ります。
     *
     * @param サービス提供年月 サービス提供年月
     * @return 給付実績月別集計
     */
    public KyufuJissekiServiceCollection get給付実績月別集計(ServiceTeikyoYM サービス提供年月) {
        for (KyufuJissekiServiceCollection 給付実績月別集計 : 給付実績月別集計リスト) {
            if (給付実績月別集計 != null && !給付実績月別集計.isEmpty() && 給付実績月別集計.getサービス提供年月().equals(サービス提供年月)) {
                return 給付実績月別集計;
            }
        }
        return null;
    }

    /**
     * 給付実績月別集計リストがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合はtrueを返します。
     */
    public boolean isEmpty() {
        return 給付実績月別集計リスト.isEmpty();
    }

    /**
     * 給付実績月別集計リストのサイズを返します。
     *
     * @return 給付実績集計リストのサイズ
     */
    public int size() {
        return 給付実績月別集計リスト.size();
    }

    @Override
    public Iterator iterator() {
        return 給付実績月別集計リスト.iterator();
    }

}
