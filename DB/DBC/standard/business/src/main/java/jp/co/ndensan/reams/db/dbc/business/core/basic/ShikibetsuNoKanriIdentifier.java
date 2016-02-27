/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 識別番号管理の識別子です。
 */
@Value
public class ShikibetsuNoKanriIdentifier implements Serializable {

    private final RString 識別番号;
    private final FlexibleYearMonth 適用開始年月;

    /**
     * コンストラクタです。
     *
     * @param 識別番号 識別番号
     * @param 適用開始年月 適用開始年月
     */
    public ShikibetsuNoKanriIdentifier(RString 識別番号,
            FlexibleYearMonth 適用開始年月) {
        this.識別番号 = 識別番号;
        this.適用開始年月 = 適用開始年月;
    }
}
