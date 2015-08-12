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
 * 国保連インターフェース管理の識別子です。
 */
@Value
public class KokuhorenInterfaceKanriIdentifier implements Serializable {

    private final FlexibleYearMonth 処理年月;
    private final RString 交換情報識別番号;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     */
    public KokuhorenInterfaceKanriIdentifier(FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        this.処理年月 = 処理年月;
        this.交換情報識別番号 = 交換情報識別番号;
    }
}
