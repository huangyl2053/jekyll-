/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費支給限度額判定
 *
 * @reamsid_L DBC-1020-060 chenaoqi
 */
public class FukushiyoguKonyuhiShikyuGendogaku {

    private final FukushiyoguKonyuhiShikyuShinsei sut;

    /**
     * コンストラクタです。
     */
    FukushiyoguKonyuhiShikyuGendogaku() {
        sut = InstanceProvider.create(FukushiyoguKonyuhiShikyuShinsei.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @return FukushiyoguKonyuhiShikyuGendogaku
     */
    public static FukushiyoguKonyuhiShikyuGendogaku createInstance() {
        return InstanceProvider.create(FukushiyoguKonyuhiShikyuGendogaku.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param sut 福祉用具購入費支給申請
     */
    FukushiyoguKonyuhiShikyuGendogaku(FukushiyoguKonyuhiShikyuShinsei sut) {
        this.sut = sut;
    }

    /**
     * 福祉用具購入費支給限度額判定
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 今回の保険対象費用額 今回の保険対象費用額
     * @return flag
     */
    public boolean chkKonyuhiShikyuGendogaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号, Decimal 今回の保険対象費用額) {
        boolean flag = false;
        if (今回の保険対象費用額 == null) {
            今回の保険対象費用額 = Decimal.ZERO;
        }
        Decimal 支給限度額 = sut.getShikyuGendogaku(被保険者番号, サービス提供年月);
        SokanbaraiShiharaiKekkaResult entity = sut.getShokanShiharaiKekkaAll(被保険者番号, サービス提供年月);
        Decimal 今までの保険者対象費用額 = Decimal.ZERO;
        if (entity != null) {
            今までの保険者対象費用額 = entity.get保険対象費用額();
        }
        Decimal 前回までの保険対象費用額 = 今までの保険者対象費用額;

        if (今までの保険者対象費用額 != Decimal.ZERO && 整理番号 != null) {
            entity = sut.getShokanShiharaiKekka(被保険者番号,
                    サービス提供年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    明細番号);
            Decimal 今回登録済みの保険対象費用額 = entity.get保険対象費用額();
            if (今回登録済みの保険対象費用額 != null) {
                前回までの保険対象費用額 = 今までの保険者対象費用額.subtract(今回登録済みの保険対象費用額);
            }
        }
        Decimal 保険対象費用額 = 前回までの保険対象費用額.add(今回の保険対象費用額);
        if (保険対象費用額.doubleValue() <= 支給限度額.doubleValue()) {
            flag = true;
        }
        return flag;

    }
}
