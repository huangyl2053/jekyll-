/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 給付費貸付金償還期限変更の識別子です。
 */
@Value
public class KyufuhiKashitsukekinShokanKigenHenkoIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 貸付管理番号;
    private final FlexibleDate 償還期限延長受付年月日;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 貸付管理番号 貸付管理番号
     * @param 償還期限延長受付年月日 償還期限延長受付年月日
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukekinShokanKigenHenkoIdentifier(HihokenshaNo 被保険者番号,
RString 貸付管理番号,
FlexibleDate 償還期限延長受付年月日,
Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.貸付管理番号 = 貸付管理番号;
        this.償還期限延長受付年月日 = 償還期限延長受付年月日;
        this.履歴番号 = 履歴番号;
    }
}
