/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenKyufuRitsu;

/**
 * 給付実績の基本情報（給付率）を保持するクラスです。
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiKihonKyufuritsu {

    private final HokenKyufuRitsu 保険;
    private final HokenKyufuRitsu 公費１;
    private final HokenKyufuRitsu 公費２;
    private final HokenKyufuRitsu 公費３;

    /**
     * インスタンスを生成します。
     *
     * @param 保険 保険
     * @param 公費１ 公費１
     * @param 公費２ 公費２
     * @param 公費３ 公費３
     */
    public KyufuJissekiKihonKyufuritsu(
            HokenKyufuRitsu 保険,
            HokenKyufuRitsu 公費１,
            HokenKyufuRitsu 公費２,
            HokenKyufuRitsu 公費３) {
        this.保険 = 保険;
        this.公費１ = 公費１;
        this.公費２ = 公費２;
        this.公費３ = 公費３;
    }

    /**
     * 保険を返します。
     *
     * @return 保険
     */
    public HokenKyufuRitsu get保険() {
        return 保険;
    }

    /**
     * 公費１を返します。
     *
     * @return 公費１
     */
    public HokenKyufuRitsu get公費１() {
        return 公費１;
    }

    /**
     * 公費２を返します。
     *
     * @return 公費２
     */
    public HokenKyufuRitsu get公費２() {
        return 公費２;
    }

    /**
     * 公費３を返します。
     *
     * @return 公費３
     */
    public HokenKyufuRitsu get公費３() {
        return 公費３;
    }
}
