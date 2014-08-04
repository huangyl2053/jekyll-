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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ひと月分の給付実績種類明細情報のリストを保持するコレクションクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceCollection implements Iterable {

    private final List<KyufuJissekiService> 給付実績種類明細情報リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 給付実績種類明細情報リスト 給付実績サービス種類集計リスト
     */
    public KyufuJissekiServiceCollection(List<KyufuJissekiService> 給付実績種類明細情報リスト) {
        this.給付実績種類明細情報リスト = requireNonNull(給付実績種類明細情報リスト,
                Messages.E00001.replace("給付実績種類明細情報リスト").getMessage());
    }

    /**
     * サービス種類ごとの単位数合計の集計値を返します。
     *
     * @param サービス種類コード サービス種類コード
     * @return 単位数合計の集計値
     */
    public Decimal get単位数合計Byサービス種類(ServiceShuruiCode サービス種類コード) {
        Decimal ret = Decimal.ZERO;
        for (KyufuJissekiService 給付実績種類明細情報 : 給付実績種類明細情報リスト) {
            if (給付実績種類明細情報.get給付実績キー情報().getサービス種類コード().equals(サービス種類コード)) {
                if (給付実績種類明細情報.get単位数合計() != null) {
                    ret = ret.add(給付実績種類明細情報.get単位数合計());
                } else if (給付実績種類明細情報.getサービス単位数合計() != null) {
                    ret = ret.add(給付実績種類明細情報.getサービス単位数合計());
                }
            }
        }
        return ret;
    }

    /**
     * サービス種類ごとの保険請求分請求額合計の集計値を返します。
     *
     * @param サービス種類コード サービス種類コード
     * @return 保険請求分請求額合計の集計値
     */
    public Decimal get保険請求分請求額合計Byサービス種類(ServiceShuruiCode サービス種類コード) {
        Decimal ret = Decimal.ZERO;
        for (KyufuJissekiService 給付実績種類明細情報 : 給付実績種類明細情報リスト) {
            if (給付実績種類明細情報.get給付実績キー情報().getサービス種類コード().equals(サービス種類コード)) {
                ret = ret.add(給付実績種類明細情報.get保険請求分請求額合計());
            }
        }
        return ret;
    }

    /**
     * サービスカテゴリごとの単位数合計の集計値を返します。
     *
     * @param サービスカテゴリ サービスカテゴリ
     * @return 単位数合計の集計値
     */
    public Decimal get単位数合計Byサービスカテゴリ(ServiceCategory サービスカテゴリ) {
        Decimal ret = Decimal.ZERO;
        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();
        for (KyufuJissekiService 給付実績種類明細情報 : 給付実績種類明細情報リスト) {
            if (category.get合計カテゴリ(給付実績種類明細情報.get給付実績キー情報().getサービス種類コード())
                    .equals(サービスカテゴリ)) {
                ret = ret.add(給付実績種類明細情報.get単位数合計());
            }
        }
        return ret;
    }

    /**
     * 保険請求分請求額合計の集計値を返します。
     *
     * @return 保険請求分請求額合計の集計値
     */
    public Decimal get給付費合計() {
        Decimal ret = Decimal.ZERO;
        for (KyufuJissekiService 給付実績種類明細情報 : 給付実績種類明細情報リスト) {
            ret = ret.add(給付実績種類明細情報.get保険請求分請求額合計());
        }
        return ret;
    }

    /**
     * 利用者負担額合計の集計値を返します。
     *
     * @return 利用者負担額合計の集計値
     */
    public Decimal get利用者負担合計() {
        Decimal ret = Decimal.ZERO;
        for (KyufuJissekiService 給付実績種類明細情報 : 給付実績種類明細情報リスト) {
            ret = ret.add(給付実績種類明細情報.get利用者負担額合計());
        }
        return ret;
    }

    /**
     * 指定されたサービス種類コードのキー情報を返します。<br/>
     * 対応するサービス種類コードが存在しない場合はnullが返ります。
     *
     * @param サービス種類コード サービス種類コード
     * @return キー情報
     */
    public KyufuJissekiKeyInfo getKeyInfo(ServiceShuruiCode サービス種類コード) {
        for (KyufuJissekiService 給付実績種類明細情報 : 給付実績種類明細情報リスト) {
            if (給付実績種類明細情報.get給付実績キー情報().getサービス種類コード().equals(サービス種類コード)) {
                return 給付実績種類明細情報.get給付実績キー情報();
            }
        }
        return null;
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public ServiceTeikyoYM getサービス提供年月() {
        return 給付実績種類明細情報リスト.get(0).get給付実績キー情報().getサービス提供年月();
    }

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
        return 給付実績種類明細情報リスト.isEmpty();
    }

    /**
     * 給付実績サービス種類集計リストのサイズを返します。
     *
     * @return 給付実績集計リストのサイズ
     */
    public int size() {
        return 給付実績種類明細情報リスト.size();
    }

    @Override
    public Iterator iterator() {
        return 給付実績種類明細情報リスト.iterator();
    }

}
