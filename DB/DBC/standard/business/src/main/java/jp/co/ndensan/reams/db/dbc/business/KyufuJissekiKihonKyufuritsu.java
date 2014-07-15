/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;

/**
 * 給付実績の基本情報（給付率）を保持するクラス
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiKihonKyufuritsu {

    private HokenKyufuRitsu 保険;
    private HokenKyufuRitsu 公費１;
    private HokenKyufuRitsu 公費２;
    private HokenKyufuRitsu 公費３;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 保険 保険
     * @param 公費１ 公費１
     * @param 公費２ 公費２
     * @param 公費３ 公費３
     */
    public KyufuJissekiKihonKyufuritsu(HokenKyufuRitsu 保険, HokenKyufuRitsu 公費１, HokenKyufuRitsu 公費２, HokenKyufuRitsu 公費３)
            throws NullPointerException {

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
