/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修費支給限度額判定クラス
 */
public class JutakuKaishuShikyuGendogakuHantei {

    private final JutakuKaishuJizenShinsei jizenShisei;

    /**
     * コンストラクタ
     *
     * @param jizenShisei JutakuKaishuJizenShinsei
     */
    public JutakuKaishuShikyuGendogakuHantei(JutakuKaishuJizenShinsei jizenShisei) {
        this.jizenShisei = jizenShisei;
    }

    /**
     * サービス提供年月時点の住宅改修費支給限度額を判定するメソッド。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 限度リセットフラグ 限度リセットフラグ
     * @param 今回の保険対象費用額 今回の保険対象費用額
     * @return 判定結果(true:支給限度額が今回までの保険対象費用額より大きい、false:支給限度額が今回までの保険対象費用額より小さい)
     */
    public boolean checkJutakukaishuShikyuGendogaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, boolean 限度リセットフラグ, Decimal 今回の保険対象費用額) {
        Decimal 支給限度額 = jizenShisei.getShikyuGendoGaku(被保険者番号, サービス提供年月);
        if (支給限度額.doubleValue() < 0) {
            return false;
        }

        ShiharaiKekkaResult 住宅改修費支払結果 = jizenShisei.getOldJutakuKaishuHi(
                被保険者番号, サービス提供年月, 整理番号);
        Decimal 過去の保険対象費用額 = Decimal.ZERO;
        if (住宅改修費支払結果 != null) {
            過去の保険対象費用額 = 住宅改修費支払結果.getEntity().保険対象費用額;
        }

        Decimal 今回までの保険対象費用額;
        if (限度リセットフラグ) {
            今回までの保険対象費用額 = 今回の保険対象費用額;
        } else {
            今回までの保険対象費用額 = 今回の保険対象費用額.add(過去の保険対象費用額);
        }
        return 支給限度額.doubleValue() >= 今回までの保険対象費用額.doubleValue();
    }
}
