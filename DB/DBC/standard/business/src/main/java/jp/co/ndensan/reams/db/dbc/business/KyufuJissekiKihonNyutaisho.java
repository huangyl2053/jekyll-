/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の基本情報（施設入退所）を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiKihonNyutaisho {

    private final FlexibleDate 入所日;
    private final FlexibleDate 退所日;
    private final int 入所実日数;
    private final int 外泊日数;
    private final RString 入所前の状況;
    private final RString 退所後の状況;

    /**
     * インスタンスを生成します。
     *
     * @param 入所日 旧措置入所者特例
     * @param 退所日 老人保健市町村番号
     * @param 入所実日数 老人保健受給者番号
     * @param 外泊日数 後期高齢保険者番号
     * @param 入所前の状況 後期高齢被保番号
     * @param 退所後の状況 国保保険者番号
     */
    public KyufuJissekiKihonNyutaisho(
            FlexibleDate 入所日,
            FlexibleDate 退所日,
            int 入所実日数,
            int 外泊日数,
            RString 入所前の状況,
            RString 退所後の状況) {
        this.入所日 = 入所日;
        this.退所日 = 退所日;
        this.入所実日数 = 入所実日数;
        this.外泊日数 = 外泊日数;
        this.入所前の状況 = 入所前の状況;
        this.退所後の状況 = 退所後の状況;
    }

    /**
     * 入所日を返します。
     *
     * @return 入所日
     */
    public FlexibleDate get入所日() {
        return 入所日;
    }

    /**
     * 退所日を返します。
     *
     * @return 入所日
     */
    public FlexibleDate get退所日() {
        return 退所日;
    }

    /**
     * 入所実日数を返します。
     *
     * @return 入所実日数
     */
    public int get入所実日数() {
        return 入所実日数;
    }

    /**
     * 外泊日数を返します。
     *
     * @return 外泊日数
     */
    public int get外泊日数() {
        return 外泊日数;
    }

    /**
     * 入所前の状況を返します。
     *
     * @return 入所前の状況
     */
    public RString get入所前の状況() {
        return 入所前の状況;
    }

    /**
     * 退所後の状況を返します。
     *
     * @return 退所後の状況
     */
    public RString get退所後の状況() {
        return 退所後の状況;
    }
}
