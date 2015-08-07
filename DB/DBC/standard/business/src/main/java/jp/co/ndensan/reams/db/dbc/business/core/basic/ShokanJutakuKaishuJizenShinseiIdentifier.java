/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 償還払支給住宅改修事前申請の識別子です。
 */
@Value
public class ShokanJutakuKaishuJizenShinseiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public ShokanJutakuKaishuJizenShinseiIdentifier(HihokenshaNo 被保険者番号,
FlexibleYearMonth サービス提供年月,
RString 整理番号,
Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.履歴番号 = 履歴番号;
    }
}
