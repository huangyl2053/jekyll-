/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.view;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連取り込み情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
//@lombok.Value TODO
public class KokuhorenTorikomiJohoIdentifier implements Serializable {

    private final FlexibleYearMonth 処理年月;
    private final RString 交換情報識別番号;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     */
    public KokuhorenTorikomiJohoIdentifier(FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        this.処理年月 = 処理年月;
        this.交換情報識別番号 = 交換情報識別番号;
    }
}
