/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.ShiharaiKekaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支払結果情報のオブジェクトクラスです。
 *
 * @reamsid_L DBC-0990-080 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiKekkaResult implements Serializable {

    private final ShiharaiKekaEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public ShiharaiKekkaResult(ShiharaiKekaEntity entity) {
        this.entity = entity;
    }

    /**
     * 費用額合計の取得メソッド
     *
     * @return 費用額合計
     */
    public Decimal get費用額合計() {
        return entity.get費用額合計();
    }

    /**
     * 保険対象費用額の取得メソッド
     *
     * @return 保険対象費用額
     */
    public Decimal get保険対象費用額() {
        return entity.get保険対象費用額();
    }

    /**
     * 保険給付額の取得メソッド
     *
     * @return 保険給付額
     */
    public Decimal get保険給付額() {
        return entity.get保険給付額();
    }

    /**
     * 利用者負担額の取得メソッド
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.get利用者負担額();
    }

    /**
     * 住宅改修住宅住所の取得メソッド
     *
     * @return 住宅改修住宅住所
     */
    public RString get住宅改修住宅住所() {
        return entity.get住宅改修住宅住所();
    }

    /**
     * 開始サービス提供年月の取得メソッド
     *
     * @return 開始サービス提供年月
     */
    public FlexibleYearMonth get開始サービス提供年月() {
        return entity.get開始サービス提供年月();
    }
}
