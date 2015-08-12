/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 過誤決定集計の識別子です。
 */
@Value
public class KagoKetteiShukeiIdentifier implements Serializable {

    private final FlexibleYearMonth 取扱年月;
    private final RString 保険者区分;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     */
    public KagoKetteiShukeiIdentifier(FlexibleYearMonth 取扱年月,
RString 保険者区分,
Decimal 履歴番号) {
        this.取扱年月 = 取扱年月;
        this.保険者区分 = 保険者区分;
        this.履歴番号 = 履歴番号;
    }
}
