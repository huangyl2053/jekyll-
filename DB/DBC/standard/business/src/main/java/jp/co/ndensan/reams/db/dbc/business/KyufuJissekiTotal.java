/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績の月別集計を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiTotal {

    private final KyufuJissekiServiceCollection サービス種類集計リスト;
    private final KyufuJissekiServiceShukeiCollection 特定サービス種類集計リスト;
    private final ServiceTeikyoYM サービス提供年月;
    private final Decimal 給付費合計;
    private final Decimal 利用者負担合計;
    private final Decimal 高額介護費;
    private final Decimal 福祉用具販売;
    private final Decimal 住宅改修;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類集計リスト サービス種類集計リスト
     * @param 特定サービス種類集計リスト 特定サービス種類集計リスト
     * @param サービス提供年月 サービス提供年月
     */
    public KyufuJissekiTotal(
            KyufuJissekiServiceCollection サービス種類集計リスト,
            KyufuJissekiServiceShukeiCollection 特定サービス種類集計リスト,
            ServiceTeikyoYM サービス提供年月) {
        this.サービス種類集計リスト = requireNonNull(サービス種類集計リスト, Messages.E00001.replace("サービス種類集計リスト").getMessage());
        this.特定サービス種類集計リスト = requireNonNull(特定サービス種類集計リスト, Messages.E00001.replace("特定サービス種類集計リスト").getMessage());
        this.サービス提供年月 = requireNonNull(サービス提供年月, Messages.E00001.replace("サービス提供年月").getMessage());

        //TODO N8187久保田英男 給付費合計等は後ほど計算を実装する。 本実装完了まで。
        給付費合計 = Decimal.ZERO;
        利用者負担合計 = Decimal.ZERO;
        高額介護費 = Decimal.ZERO;
        福祉用具販売 = Decimal.ZERO;
        住宅改修 = Decimal.ZERO;
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public ServiceTeikyoYM getサービス提供年月() {
        return サービス提供年月;
    }

    /**
     * サービス種類集計リストを返します。
     *
     * @return サービス種類集計リスト
     */
    public KyufuJissekiServiceCollection getサービス種類集計リスト() {
        return サービス種類集計リスト;
    }

    /**
     * 特定サービス種類集計リストを返します。
     *
     * @return 特定サービス種類集計リスト
     */
    public KyufuJissekiServiceShukeiCollection get特定サービス種類集計リスト() {
        return 特定サービス種類集計リスト;
    }

    public Decimal get給付費合計() {
        return 給付費合計;
    }

    public Decimal get利用者負担合計() {
        return 利用者負担合計;
    }

    public Decimal get高額介護費() {
        return 高額介護費;
    }

    public Decimal get福祉用具販売() {
        return 福祉用具販売;
    }

    public Decimal get住宅改修() {
        return 住宅改修;
    }

}
