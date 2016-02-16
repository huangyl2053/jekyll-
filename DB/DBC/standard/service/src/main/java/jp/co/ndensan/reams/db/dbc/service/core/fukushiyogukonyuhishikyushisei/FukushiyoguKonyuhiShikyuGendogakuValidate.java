/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費支給限度額判定
 *
 * @author 陳奥奇
 */
public class FukushiyoguKonyuhiShikyuGendogakuValidate {

    private final FukushiyoguKonyuhiShikyuGendogaku sut;

    /**
     * コンストラクタです。
     */
    FukushiyoguKonyuhiShikyuGendogakuValidate() {
        sut = InstanceProvider.create(FukushiyoguKonyuhiShikyuGendogaku.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param sut 福祉用具購入費支給申請
     */
    FukushiyoguKonyuhiShikyuGendogakuValidate(FukushiyoguKonyuhiShikyuGendogaku sut) {
        this.sut = sut;
    }

    /**
     * 福祉用具購入費支給限度額判定
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 今回の保険対象費用額
     * @return flag
     */
    public boolean chkKonyuhiShikyuGendogaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号, Decimal 今回の保険対象費用額) {
        boolean flag = false;
        if (被保険者番号 == null || サービス提供年月 == null || 事業者番号 == null
                || 様式番号 == null || 明細番号 == null || 今回の保険対象費用額 == null) {
            return flag;
        }
        Decimal 支給限度額 = sut.getShikyuGendogaku(被保険者番号, サービス提供年月);
        SokanbaraiShiharaiKekka entity = sut.getShokanShiharaiKekkaAll(被保険者番号, サービス提供年月);
        Decimal 今までの保険者対象費用額 = entity.get保険対象費用額();
        Decimal 前回までの保険対象費用額 = 今までの保険者対象費用額;

        if (今までの保険者対象費用額 != Decimal.ZERO) {
            if (整理番号 != null && !整理番号.isEmpty()) {
                entity = sut.getShokanShiharaiKekka(被保険者番号,
                        サービス提供年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        明細番号);
                Decimal 今回登録済みの保険対象費用額 = entity.get保険対象費用額();
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
