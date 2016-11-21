/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修費支給限度額判定クラス
 *
 * @reamsid_L DBC-0992-140 yebangqiang
 */
public class JutakuKaishuShikyuGendogakuHantei {

    private final JutakuKaishuJizenShinsei jizenShisei;

    /**
     * コンストラクタ
     *
     */
    public JutakuKaishuShikyuGendogakuHantei() {
        this.jizenShisei = JutakuKaishuJizenShinsei.createInstance();
    }

    /**
     * サービス提供年月時点の住宅改修費支給限度額を判定するメソッド。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 限度リセットフラグ 限度リセットフラグ
     * @param 今回の保険対象費用額 今回の保険対象費用額
     * @param 支払結果情報 ShiharaiKekkaResult
     * @return 判定結果(true:支給限度額が今回までの保険対象費用額より大きい、false:支給限度額が今回までの保険対象費用額より小さい)
     */
    public boolean checkJutakukaishuShikyuGendogaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            boolean 限度リセットフラグ, Decimal 今回の保険対象費用額, ShiharaiKekkaResult 支払結果情報) {
        Decimal 支給限度額 = jizenShisei.getShikyuGendoGaku(被保険者番号, サービス提供年月);
        if (支給限度額.doubleValue() < 0) {
            return false;
        }

        Decimal 今回までの保険対象費用額;
        if (限度リセットフラグ) {
            今回までの保険対象費用額 = 今回の保険対象費用額;
        } else {
            今回までの保険対象費用額 = 今回の保険対象費用額.add(支払結果情報.get保険対象費用額());
        }
        return 支給限度額.doubleValue() >= 今回までの保険対象費用額.doubleValue();
    }
}
