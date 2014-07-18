/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategory;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス種類ごとの給付実績サービス種類集計リストを保持するコレクションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceCollection implements Iterable {

    private final List<KyufuJissekiService> 給付実績サービス種類集計リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 給付実績サービス種類集計リスト 給付実績サービス種類集計リスト
     */
    public KyufuJissekiServiceCollection(List<KyufuJissekiService> 給付実績サービス種類集計リスト) {
        this.給付実績サービス種類集計リスト = requireNonNull(給付実績サービス種類集計リスト, Messages.E00001.replace("給付実績サービス種類集計リスト").getMessage());
    }

    public Decimal get単位数合計Byサービス種類(ServiceShuruiCode サービス種類コード) {
        return Decimal.ZERO;
    }

    public Decimal get単位数合計Byサービスカテゴリ(ServiceCategory サービスカテゴリ) {
        return Decimal.ZERO;
    }

    public Decimal get給付費合計() {
        return Decimal.ZERO;
    }

    public Decimal get利用者負担合計() {
        return Decimal.ZERO;
    }

    public KyufuJissekiKeyInfo getKeyInfo(ServiceShuruiCode サービス種類コード) {
        KyufuJissekiKeyInfo keyInfo = 給付実績サービス種類集計リスト.get(0).get給付実績キー情報();
        return keyInfo;
    }
      /**
    //     * 引数の条件に該当する給付実績サービス種類集計を返します。<br/>
    //     * 対応した給付実績サービス種類集計が存在しない場合はnullが返ります。
    //     *
    //     * @param サービス種類コード サービス種類コード
    //     * @return 給付実績サービス種類集計
    //     */
    //    public KyufuJissekiService get給付実績サービス(ServiceShuruiCode サービス種類コード) {
    //        for (KyufuJissekiService 給付実績サービス種類集計 : 給付実績サービス種類集計リスト) {
    //            if (給付実績サービス種類集計.getサービス種類コード().equals(サービス種類コード)) {
    //                return 給付実績サービス種類集計;
    //            }
    //        }
    //        return null;
    //    }
    //    /**
    //     * 引数の条件に該当する給付実績サービス種類集計のコレクションを返します。
    //     *
    //     * @param サービス種類 サービス種類
    //     * @return 給付実績サービス種類集計のコレクション
    //     */
    //    public KyufuJissekiServiceCollection sub給付実績集計List(ServiceShurui サービス種類) {
    //        List<KyufuJissekiService> sub給付実績集計List = new ArrayList<>();
    //        for (KyufuJissekiService 給付実績集計 : 給付実績サービス種類集計リスト) {
    //            if (給付実績集計.getサービス種類().equals(サービス種類)) {
    //                sub給付実績集計List.add(給付実績集計);
    //            }
    //        }
    //        return new KyufuJissekiServiceCollection(sub給付実績集計List);
    //    }
    /**
     * 給付実績サービス種類集計リストがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合はtrueを返します。
     */
    public boolean isEmpty() {
        return 給付実績サービス種類集計リスト.isEmpty();
    }

    /**
     * 給付実績サービス種類集計リストのサイズを返します。
     *
     * @return 給付実績集計リストのサイズ
     */
    public int size() {
        return 給付実績サービス種類集計リスト.size();
    }

    @Override
    public Iterator iterator() {
        return 給付実績サービス種類集計リスト.iterator();
    }

}
