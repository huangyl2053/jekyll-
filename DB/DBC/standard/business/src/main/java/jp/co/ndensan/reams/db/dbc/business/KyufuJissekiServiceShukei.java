/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiShukeiGokeiTaisho;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特定のサービス種類の給付実績集計額を保持するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuJissekiServiceShukei {

    private final KyufuJissekiShukeiGokeiTaisho 給付実績合計対象;
    private final Decimal 合計単位;
    private final KyufuJissekiKeyInfo 給付実績キー情報;

    /**
     * インスタンスを生成します。
     *
     * @param 給付実績合計対象 給付実績合計対象
     * @param 合計単位 合計単位
     * @param 給付実績キー情報 給付実績キー情報
     */
    public KyufuJissekiServiceShukei(KyufuJissekiShukeiGokeiTaisho 給付実績合計対象,
            Decimal 合計単位,
            KyufuJissekiKeyInfo 給付実績キー情報) {
        this.給付実績合計対象 = requireNonNull(給付実績合計対象, Messages.E00001.replace("給付実績合計対象").getMessage());
        this.合計単位 = requireNonNull(合計単位, Messages.E00001.replace("合計単位").getMessage());
        this.給付実績キー情報 = requireNonNull(給付実績キー情報, Messages.E00001.replace("給付実績キー情報").getMessage());
    }

    /**
     * 給付実績合計対象を返します。
     *
     * @return 給付実績合計対象
     */
    public KyufuJissekiShukeiGokeiTaisho get給付実績合計対象() {
        return 給付実績合計対象;
    }

    /**
     * 合計単位を返します。
     *
     * @return 合計単位
     */
    public Decimal get合計単位() {
        return 合計単位;
    }

    /**
     * 給付実績キー情報を返します。
     *
     * @return 給付実績キー情報
     */
    public KyufuJissekiKeyInfo get給付実績キー情報() {
        return 給付実績キー情報;
    }

}
