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
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 給付実績の月別集計を保持するコレクションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiTotalCollection implements Iterable {

    private final List<KyufuJissekiTotal> 給付実績月別集計リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 給付実績月別集計リスト 給付実績月別集計リスト
     */
    public KyufuJissekiTotalCollection(List<KyufuJissekiTotal> 給付実績月別集計リスト) {
        this.給付実績月別集計リスト = requireNonNull(給付実績月別集計リスト,
                Messages.E00001.replace("給付実績月別集計リスト").getMessage());
    }

    /**
     * 引数の条件に該当する給付実績月別集計を返します。<br/>
     * 対応した給付実績月別集計が存在しない場合はnullが返ります。
     *
     * @param サービス提供年月 サービス提供年月
     * @return KyufuJissekiTotal
     */
    public KyufuJissekiTotal get給付実績月別集計(ServiceTeikyoYM サービス提供年月) {
        for (KyufuJissekiTotal 給付実績月別集計 : 給付実績月別集計リスト) {
            if (給付実績月別集計.getサービス提供年月().value().equals(サービス提供年月.value())) {
                return 給付実績月別集計;
            }
        }
        return null;
    }

//    /**
//     * 引数の条件に該当する給付実績月別集計のコレクションを返します。
//     *
//     * @param サービス提供年月 サービス提供年月
//     * @return 給付実績月別集計のコレクション
//     */
//    public KyufuJissekiTotalCollection sub給付実績月別集計List(ServiceTeikyoYM サービス提供年月) {
//        List<KyufuJissekiTotal> sub給付実績月別集計List = new ArrayList<>();
//        for (KyufuJissekiTotal 給付実績集計 : 給付実績月別集計リスト) {
//            if (給付実績集計.getサービス提供年月().value().equals(サービス提供年月.value())) {
//                sub給付実績月別集計List.add(給付実績集計);
//            }
//        }
//        return new KyufuJissekiTotalCollection(sub給付実績月別集計List);
//    }
//
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
