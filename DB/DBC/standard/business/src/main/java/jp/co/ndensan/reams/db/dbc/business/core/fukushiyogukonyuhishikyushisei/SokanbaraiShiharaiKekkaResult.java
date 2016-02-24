/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekka;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支払結果Entity結果
 */
public class SokanbaraiShiharaiKekkaResult implements Serializable {

    private final SokanbaraiShiharaiKekka entity;

    /**
     * コンストラクタです。
     *
     * @param entity 償還払支払結果Entity
     */
    public SokanbaraiShiharaiKekkaResult(SokanbaraiShiharaiKekka entity) {
        this.entity = entity;
    }

    /**
     * 費用額合計を取得する。
     *
     * @return Decimal 費用額合計
     */
    public Decimal get費用額合計() {
        return this.entity.get費用額合計();
    }

    /**
     * 保険対象費用額を取得する。
     *
     * @return Decimal 保険対象費用額
     */
    public Decimal get保険対象費用額() {
        return this.entity.get保険対象費用額();
    }

    /**
     * 保険給付額を取得する。
     *
     * @return int 保険給付額
     */
    public int get保険給付額() {
        return this.entity.get保険給付額();
    }

    /**
     * 利用者負担額を取得する。
     *
     * @return int 利用者負担額
     */
    public int get利用者負担額() {
        return this.entity.get利用者負担額();
    }

}
