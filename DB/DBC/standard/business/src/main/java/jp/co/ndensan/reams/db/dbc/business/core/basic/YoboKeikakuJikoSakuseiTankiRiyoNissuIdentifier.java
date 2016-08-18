/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Value;

/**
 * 予防給付計画自己作成短期利用日数の識別子です。
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final int 履歴番号;
    private final FlexibleYearMonth 利用年月;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 利用年月 利用年月
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
        this.利用年月 = 利用年月;
    }
}
