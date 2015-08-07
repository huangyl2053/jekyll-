/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import lombok.Value;

/**
 * 居宅給付計画事業者作成の識別子です。
 */
@Value
public class KyotakuKeikakuJigyoshaSakuseiIdentifier implements Serializable {

    private final FlexibleYearMonth 対象年月;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuJigyoshaSakuseiIdentifier(FlexibleYearMonth 対象年月,
Decimal 履歴番号) {
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
    }
}
