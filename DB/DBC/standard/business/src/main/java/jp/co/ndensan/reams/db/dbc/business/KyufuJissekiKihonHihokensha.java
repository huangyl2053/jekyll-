/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の基本情報（被保険者）を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiKihonHihokensha {

    private final RString 旧措置入所者特例;
    private final RString 老人保健市町村番号;
    private final RString 老人保健受給者番号;
    private final RString 後期高齢保険者番号;
    private final RString 後期高齢被保番号;
    private final RString 国保保険者番号;
    private final RString 被保険者証番号;
    private final RString 個人番号;

    /**
     * インスタンスを生成します。
     *
     * @param 旧措置入所者特例 旧措置入所者特例
     * @param 老人保健市町村番号 老人保健市町村番号
     * @param 老人保健受給者番号 老人保健受給者番号
     * @param 後期高齢保険者番号 後期高齢保険者番号
     * @param 後期高齢被保番号 後期高齢被保番号
     * @param 国保保険者番号 国保保険者番号
     * @param 被保険者証番号 被保険者証番号
     * @param 個人番号 個人番号
     */
    public KyufuJissekiKihonHihokensha(
            RString 旧措置入所者特例,
            RString 老人保健市町村番号,
            RString 老人保健受給者番号,
            RString 後期高齢保険者番号,
            RString 後期高齢被保番号,
            RString 国保保険者番号,
            RString 被保険者証番号,
            RString 個人番号) throws NullPointerException {
        this.旧措置入所者特例 = 旧措置入所者特例;
        this.老人保健市町村番号 = 老人保健市町村番号;
        this.老人保健受給者番号 = 老人保健受給者番号;
        this.後期高齢保険者番号 = 後期高齢保険者番号;
        this.後期高齢被保番号 = 後期高齢被保番号;
        this.国保保険者番号 = 国保保険者番号;
        this.被保険者証番号 = 被保険者証番号;
        this.個人番号 = 個人番号;
    }

    /**
     * 旧措置入所者特例を返します。
     *
     * @return 旧措置入所者特例
     */
    public RString get旧措置入所者特例() {
        return 旧措置入所者特例;
    }

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return 老人保健市町村番号;
    }

    /**
     * 老人保健受給者番号を返します。
     *
     * @return 老人保健受給者番号
     */
    public RString get老人保健受給者番号() {
        return 老人保健受給者番号;
    }

    /**
     * 後期高齢保険者番号を返します。
     *
     * @return 後期高齢保険者番号
     */
    public RString get後期高齢保険者番号() {
        return 後期高齢保険者番号;
    }

    /**
     * 後期高齢被保番号を返します。
     *
     * @return 後期高齢被保番号
     */
    public RString get後期高齢被保番号() {
        return 後期高齢被保番号;
    }

    /**
     * 国保保険者番号を返します。
     *
     * @return 国保保険者番号
     */
    public RString get国保保険者番号() {
        return 国保保険者番号;
    }

    /**
     * 被保険者証番号を返します。
     *
     * @return 被保険者証番号
     */
    public RString get被保険者証番号() {
        return 被保険者証番号;
    }

    /**
     * 個人番号を返します。
     *
     * @return 個人番号
     */
    public RString get個人番号() {
        return 個人番号;
    }
}
