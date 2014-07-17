/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiShukeiGokeiTaisho;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 特定のサービス種類の給付実績集計額を保持するコレクションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceShukeiCollection implements Iterable {

    private final List<KyufuJissekiServiceShukei> 給付実績特定サービス集計リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 給付実績特定サービス集計リスト 給付実績特定サービス集計リスト
     */
    public KyufuJissekiServiceShukeiCollection(List<KyufuJissekiServiceShukei> 給付実績特定サービス集計リスト) {
        this.給付実績特定サービス集計リスト = requireNonNull(給付実績特定サービス集計リスト,
                Messages.E00001.replace("給付実績特定サービス種類集計リスト").getMessage());
    }

    /**
     * 引数の条件に該当する給付実績特定サービス集計を返します。<br/>
     * 対応した給付実績特定サービス集計が存在しない場合はnullが返ります。
     *
     * @param 合計対象 合計対象
     * @return 給付実績特定サービス集計
     */
    public KyufuJissekiServiceShukei get給付実績特定サービス集計(KyufuJissekiShukeiGokeiTaisho 合計対象) {
        for (KyufuJissekiServiceShukei 給付実績特定サービス集計 : 給付実績特定サービス集計リスト) {
            if (給付実績特定サービス集計.get給付実績合計対象().equals(合計対象)) {
                return 給付実績特定サービス集計;
            }
        }
        return null;
    }

//    /**
//     * 引数の条件に該当する給付実績サービス種類集計のコレクションを返します。
//     *
//     * @param 合計対象 合計対象
//     * @return 給付実績特定サービス集計のコレクション
//     */
//    public KyufuJissekiServiceShukeiCollection sub給付実績集計List(KyufuJissekiShukeiGokeiTaisho 合計対象) {
//        List<KyufuJissekiShukei> sub給付実績集計List = new ArrayList<>();
//        for (KyufuJissekiServiceShukei 給付実績集計 : 給付実績特定サービス集計リスト) {
//            if (給付実績集計.get給付実績合計対象().equals(合計対象)) {
//                sub給付実績集計List.add(給付実績集計);
//            }
//        }
//        return new KyufuJissekiServiceShukeiCollection(sub給付実績集計List);
//    }
    /**
     * 給付実績集計リストがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合はtrueを返します。
     */
    public boolean isEmpty() {
        return 給付実績特定サービス集計リスト.isEmpty();
    }

    /**
     * 給付実績集計リストのサイズを返します。
     *
     * @return 給付実績集計リストのサイズ
     */
    public int size() {
        return 給付実績特定サービス集計リスト.size();
    }

    @Override
    public Iterator iterator() {
        return 給付実績特定サービス集計リスト.iterator();
    }

}
