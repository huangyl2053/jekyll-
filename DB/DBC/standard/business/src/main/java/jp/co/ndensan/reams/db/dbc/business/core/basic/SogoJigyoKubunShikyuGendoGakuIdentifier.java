/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護予防・日常生活支援総合事業区分支給限度額の識別子です。
 */
@Value
public class SogoJigyoKubunShikyuGendoGakuIdentifier implements Serializable {

    private final RString 要介護状態区分;
    private final FlexibleYearMonth 適用開始年月;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public SogoJigyoKubunShikyuGendoGakuIdentifier(RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        this.要介護状態区分 = 要介護状態区分;
        this.適用開始年月 = 適用開始年月;
        this.履歴番号 = 履歴番号;
    }
}
